package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.FabricSmith.itemSettings
import com.github.rochedo098.fth.FabricSmith.myIdentifier
import com.github.rochedo098.fth.smeltery.FTHSmelteryController
import com.github.rochedo098.fth.smeltery.FTHSmelteryTank
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.util.registry.Registry

object FTHBlocks {
    val metal_blocks: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron", "solid_ender")

    var SMELTERY_CONTROLLER_BLOCK: Block? = null
    var SMELTERY_TANK_BLOCK: Block? = null
    var SMELTERY_BRICKS: Block? = null

    fun register() {
        metal_blocks.forEach { mblock ->
            val BLOCK = Registry.register(Registry.BLOCK, myIdentifier("${mblock}_block"), Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)))
            Registry.register(Registry.ITEM, myIdentifier("${mblock}_block"), BlockItem(BLOCK, itemSettings(FabricSmith.GroupTypes.MATERIALS)))
        }
    }

    fun registerSmeltery() {
        // Smeltery Blocks
        SMELTERY_CONTROLLER_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("smeltery_controller"), FTHSmelteryController.SBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)))
        SMELTERY_TANK_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("smeltery_tank"), FTHSmelteryTank.TBlock(AbstractBlock.Settings.copy(Blocks.GLASS)))
        SMELTERY_BRICKS = Registry.register(Registry.BLOCK, myIdentifier("smeltery_bricks"), Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)))
    }
}