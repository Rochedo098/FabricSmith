package com.github.rochedo098.fth.tables

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.utils.ImplementedInventory
import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockState
import net.minecraft.block.BlockWithEntity
import net.minecraft.block.entity.BlockEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos

object FTHToolStation {
    class TSBlock(settings: AbstractBlock.Settings): BlockWithEntity(settings) {
        override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
            return TSEntity(pos, state)
        }
    }

    class TSEntity(pos: BlockPos, state: BlockState): BlockEntity(FabricSmith.TOOL_STATION_ENTITY, pos, state), ImplementedInventory {
        private var items: DefaultedList<ItemStack> = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY)

        override fun getItems(): DefaultedList<ItemStack> {
            return items
        }

        override fun markDirty() {
            super<ImplementedInventory>.markDirty()
        }

        companion object {
            val INVENTORY_SIZE = 8
        }
    }
}