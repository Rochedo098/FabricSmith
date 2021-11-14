package com.github.rochedo098.fth.smeltery

import com.github.rochedo098.fth.FabricSmith
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage
import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockRenderType
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos

object FTHSmelteryTank {
    class TBlock(settings: AbstractBlock.Settings): BlockWithEntity(settings) {
        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
            return TEntity(pos, state)
        }

        override fun getRenderType(state: BlockState?): BlockRenderType {
            return BlockRenderType.MODEL
        }
    }

    @Suppress("UnstableApiUsage")
    class TEntity(pos: BlockPos, state: BlockState): BlockEntity(FabricSmith.SMELTERY_TANK_ENTITY, pos, state) {
        val fluidStorage: SingleVariantStorage<FluidVariant> = object : SingleVariantStorage<FluidVariant>() {
            override fun getBlankVariant(): FluidVariant? {
                return FluidVariant.blank()
            }

            override fun getCapacity(variant: FluidVariant): Long {
                return 8 * FluidConstants.BUCKET
            }

            override fun onFinalCommit() {
                markDirty()
            }
        }

        override fun writeNbt(tag: NbtCompound): NbtCompound? {
            tag.put("fluidVariant", fluidStorage.variant.toNbt())
            tag.putLong("amount", fluidStorage.amount)
            return super.writeNbt(tag)
        }

        override fun readNbt(tag: NbtCompound) {
            super.readNbt(tag)
            fluidStorage.variant = FluidVariant.fromNbt(tag.getCompound("fluidVariant"))
            fluidStorage.amount = tag.getLong("amount")
        }
    }
}