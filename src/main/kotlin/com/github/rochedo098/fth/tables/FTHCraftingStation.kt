package com.github.rochedo098.fth.tables

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.CraftingTableBlock
import net.minecraft.block.ShapeContext
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

object FTHCraftingStation {
    class CSBlock(settings: Settings): CraftingTableBlock(settings) {
        override fun getOutlineShape(
            state: BlockState?,
            world: BlockView?,
            pos: BlockPos?,
            context: ShapeContext?
        ): VoxelShape {
            val vs1: VoxelShape = Block.createCuboidShape(0.0, 12.0, 0.0, 16.0, 16.0, 16.0);
            val vs2: VoxelShape = Block.createCuboidShape(1.0, 0.0, 1.0, 4.0, 12.0, 4.0);
            val vs3: VoxelShape = Block.createCuboidShape(12.0, 0.0, 1.0, 15.0, 12.0, 4.0);
            val vs4: VoxelShape = Block.createCuboidShape(1.0, 0.0, 12.0, 4.0, 12.0, 15.0);
            val vs5: VoxelShape = Block.createCuboidShape(12.0, 0.0, 12.0, 15.0, 12.0, 15.0);
            val vs6: VoxelShape = Block.createCuboidShape(2.0, 5.0, 2.0, 14.0, 7.0, 14.0);
            return VoxelShapes.union(vs1, vs2, vs3, vs4, vs5, vs6).simplify();
        }
    }
}