package com.github.rochedo098.fth

import com.github.rochedo098.fth.registry.FTHBlocks
import com.github.rochedo098.fth.registry.FTHItemGroups
import com.github.rochedo098.fth.registry.FTHItems
import com.github.rochedo098.fth.registry.GroupVariant
import com.github.rochedo098.fth.smeltery.FTHSmelteryController.SEntity
import com.github.rochedo098.fth.smeltery.FTHSmelteryTank.TEntity
import com.github.rochedo098.fth.tables.FTHToolStation.TSEntity
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object FabricSmith: ModInitializer {
    const val namespace: String = "fth"
    fun myIdentifier(identifier: String): Identifier = Identifier(namespace, identifier)

    fun getItemHelper(identifier: String): Item = Registry.ITEM.get(myIdentifier(identifier))
    fun itemSettings(groupVariant: GroupVariant): Item.Settings = Item.Settings().group(FTHItemGroups.getGroup(groupVariant))

    // Block Entity's
    var SMELTERY_CONTROLLER_ENTITY: BlockEntityType<SEntity>? = null
    var SMELTERY_TANK_ENTITY: BlockEntityType<TEntity>? = null

    var TOOL_STATION_ENTITY: BlockEntityType<TSEntity>? = null

    override fun onInitialize() {
        // Registry Block's
        FTHBlocks.register()
        FTHItems.register()

        // Registry Block Entity's
        SMELTERY_CONTROLLER_ENTITY = FabricBlockEntityTypeBuilder.create(::SEntity, FTHBlocks.SMELTERY_CONTROLLER_BLOCK).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("smeltery_controller_entity"), SMELTERY_CONTROLLER_ENTITY)

        SMELTERY_TANK_ENTITY = FabricBlockEntityTypeBuilder.create(::TEntity, FTHBlocks.SMELTERY_TANK_BLOCK).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("smeltery_tank_entity"), SMELTERY_TANK_ENTITY)

        TOOL_STATION_ENTITY = FabricBlockEntityTypeBuilder.create(::TSEntity, FTHBlocks.TOOL_STATION_BLOCK).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("tool_station_entity"), TOOL_STATION_ENTITY)
    }
}