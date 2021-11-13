package com.github.rochedo098.fth.blocks.smeltery

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.utils.ImplementedInventory
import net.minecraft.block.*
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World

object FTHSmelteryController {
    class SBlock(): BlockWithEntity(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)) {
        init {
            defaultState = this.stateManager.defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
        }

        override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
            builder.add(Properties.HORIZONTAL_FACING)
        }

        override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
            return this.defaultState.with(FACING, ctx.playerFacing.opposite)
        }

        override fun onUse(
            state: BlockState?,
            world: World?,
            pos: BlockPos?,
            player: PlayerEntity?,
            hand: Hand?,
            hit: BlockHitResult?
        ): ActionResult {
            TODO("Not yet implemented")
        }

        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
            return SEntity(pos, state)
        }

        override fun getRenderType(state: BlockState?): BlockRenderType {
            return BlockRenderType.MODEL
        }

        companion object {
            val FACING = HorizontalFacingBlock.FACING
        }
    }

    class SEntity(pos: BlockPos, state: BlockState):
        BlockEntity(FabricSmith.SMELTERY_CONTROLLER_ENTITY, pos, state), ImplementedInventory {
        private var items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)

        override fun getItems(): DefaultedList<ItemStack> {
            return items
        }

        companion object {
            val INVENTORY_SIZE = 8
        }

        override fun markDirty() {
            super<ImplementedInventory>.markDirty()
        }
    }
}