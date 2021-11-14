package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith.itemSettings
import com.github.rochedo098.fth.FabricSmith.myIdentifier
import com.github.rochedo098.fth.smeltery.FTHSmelteryController
import com.github.rochedo098.fth.smeltery.FTHSmelteryTank
import com.github.rochedo098.fth.tables.FTHToolStation
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

    var TOOL_STATION_BLOCK: Block? = null

    fun register() {
        metal_blocks.forEach { mblock ->
            val BLOCK = Registry.register(Registry.BLOCK, myIdentifier("${mblock}_block"), Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)))
            Registry.register(Registry.ITEM, myIdentifier("${mblock}_block"), BlockItem(BLOCK, itemSettings(FTHItemGroups.GroupVariant.RESOURCES)))
        }
    }

    fun registerSmeltery() {
        // Smeltery Blocks
        SMELTERY_CONTROLLER_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("smeltery_controller"), FTHSmelteryController.SBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)))
        Registry.register(Registry.ITEM, myIdentifier("smeltery_controller"), BlockItem(SMELTERY_CONTROLLER_BLOCK, itemSettings(FTHItemGroups.GroupVariant.SMELTERY)))

        SMELTERY_TANK_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("smeltery_tank"), FTHSmelteryTank.TBlock(AbstractBlock.Settings.copy(Blocks.GLASS)))
        Registry.register(Registry.ITEM, myIdentifier("smeltery_tank"), BlockItem(SMELTERY_TANK_BLOCK, itemSettings(FTHItemGroups.GroupVariant.SMELTERY)))

        SMELTERY_BRICKS = Registry.register(Registry.BLOCK, myIdentifier("smeltery_bricks"), Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)))
        Registry.register(Registry.ITEM, myIdentifier("smeltery_bricks"), BlockItem(SMELTERY_BRICKS, itemSettings(FTHItemGroups.GroupVariant.SMELTERY)))
    }

    fun registerTables() {
        TOOL_STATION_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("tool_station"), FTHToolStation.TSBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)))
        Registry.register(Registry.ITEM, myIdentifier("tool_station"), BlockItem(TOOL_STATION_BLOCK, itemSettings(FTHItemGroups.GroupVariant.OTHERS)))
    }
}