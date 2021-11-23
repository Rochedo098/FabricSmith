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
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry

object FTHBlocks {
    val metal_blocks: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron", "solid_ender")

    var SMELTERY_CONTROLLER_BLOCK: Block? = null
    var SMELTERY_TANK_BLOCK: Block? = null
    var SMELTERY_BRICKS: Block? = null

    var TOOL_STATION_BLOCK: Block? = null

    fun block(id: String, blockCopy: Block, group: GroupVariant, maxCount: Int = 64): Block {
        val BLOCK = Registry.register(Registry.BLOCK, myIdentifier(id), Block(AbstractBlock.Settings.copy(blockCopy)))
        Registry.register(Registry.ITEM, myIdentifier(id), BlockItem(BLOCK, itemSettings(group).maxCount(maxCount)))
        return BLOCK
    }

    fun block(id: String, block: Block, itemSettings: Item.Settings, group: GroupVariant, maxCount: Int = 64): Block {
        val BLOCK = Registry.register(Registry.BLOCK, myIdentifier(id), block)
        Registry.register(Registry.ITEM, myIdentifier(id), BlockItem(BLOCK, itemSettings.group(FTHItemGroups.getGroup(group)).maxCount(maxCount)))
        return BLOCK
    }

    fun register() {
        metal_blocks.forEach { mblock ->
            block("${mblock}_block", Blocks.IRON_BLOCK, GroupVariant.RESOURCES)
        }

        SMELTERY_CONTROLLER_BLOCK = block("smeltery_controller", block = FTHSmelteryController.SBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)), Item.Settings(), GroupVariant.SMELTERY)
        SMELTERY_TANK_BLOCK = block("smeltery_tank", block = FTHSmelteryTank.TBlock(AbstractBlock.Settings.copy(Blocks.GLASS)), Item.Settings(), GroupVariant.SMELTERY)
        SMELTERY_BRICKS = block("smeltery_bricks", blockCopy = Blocks.STONE_BRICKS,GroupVariant.SMELTERY)

        TOOL_STATION_BLOCK = block("tool_station", block = FTHToolStation.TSBlock(AbstractBlock.Settings.copy(Blocks.CRAFTING_TABLE)), Item.Settings(), GroupVariant.SMELTERY)
    }
}