package com.github.rochedo098.fth

import com.github.rochedo098.fth.blocks.smeltery.FTHSmelteryController
import com.github.rochedo098.fth.blocks.smeltery.FTHSmelteryController.SEntity
import com.github.rochedo098.fth.blocks.smeltery.FTHSmelteryTank
import com.github.rochedo098.fth.blocks.smeltery.FTHSmelteryTank.TEntity
import com.github.rochedo098.fth.items.*
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object FabricSmith: ModInitializer {
    // Things to Help
    private fun myIdentifier(identifier: String): Identifier = Identifier("fth", identifier)
    private var GROUP: ItemGroup? = null
    const val namespace: String = "fth"

    // Variants
    val metal_blocks: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron", "solid_ender")
    val nuggets: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron")
    val ingots: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron")
    val slimes: Array<String> = arrayOf("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink")
    val casts: Array<String> = arrayOf("default", "rod", "binding", "sword_blade", "pickaxe_head", "axe_head", "shovel_head", "hoe_head")

    // Block Entity's
    var SMELTERY_CONTROLLER_ENTITY: BlockEntityType<SEntity>? = null
    var SMELTERY_TANK_ENTITY: BlockEntityType<TEntity>? = null

    // Generic Item's
    var NUGGET: Item? = null
    var INGOT: Item? = null
    var SLIME: Item? = null
    var CAST:  Item? = null

    // Generic Block's
    var METAL_BLOCK: Block? = null

    // Smeltery's Blocks
    var SMELTERY_CONTROLLER_BLOCK: Block? = null
    var SMELTERY_TANK_BLOCK: Block? = null

    override fun onInitialize() {
        FabricItemGroupBuilder.create(
            myIdentifier("general")
        )
            .icon { ItemStack(INGOT).also { it.orCreateNbt.putString("ingot", "steel") } }
            .appendItems { stacks ->
                metal_blocks.forEach { block ->
                    stacks.add(ItemStack(METAL_BLOCK).also { it.orCreateNbt.putString("block", block) })
                }

                nuggets.forEach { nugget ->
                    stacks.add(ItemStack(NUGGET).also { it.orCreateNbt.putString("nugget", nugget) })
                }

                // Add Ingots for ItemGroup
                ingots.forEach { ingot ->
                    stacks.add(ItemStack(INGOT).also { it.orCreateNbt.putString("ingot", ingot) })
                }

                // Add Slimes for ItemGroup
                slimes.forEach { slime ->
                    stacks.add(ItemStack(SLIME).also { it.orCreateNbt.putString("slime", slime) })
                }

                // Add Casts for ItemGroup
                casts.forEach { cast ->
                    stacks.add(ItemStack(CAST).also { it.orCreateNbt.putString("cast", cast) })
                }
            }
        .build()

        // Generic Registry's
        NUGGET = Registry.register(Registry.ITEM, myIdentifier("nugget"), FTHNugget())
        INGOT = Registry.register(Registry.ITEM, myIdentifier("ingot"), FTHIngot())
        SLIME = Registry.register(Registry.ITEM, myIdentifier("slime"), FTHSlime())
        CAST  = Registry.register(Registry.ITEM, myIdentifier("cast"),  FTHCasts())

        METAL_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("metal_block"), Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)))
        Registry.register(Registry.ITEM, myIdentifier("metal_block"), FTHMetalBlockItem(METAL_BLOCK!!, Item.Settings()))

        // Smeltery Blocks
        SMELTERY_CONTROLLER_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("smeltery_controller"), FTHSmelteryController.SBlock())
        SMELTERY_TANK_BLOCK = Registry.register(Registry.BLOCK, myIdentifier("smeltery_tank"), FTHSmelteryTank.TBlock())

        // Registry Block Entity's
        SMELTERY_CONTROLLER_ENTITY = FabricBlockEntityTypeBuilder.create(::SEntity, SMELTERY_CONTROLLER_BLOCK).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("smeltery_controller_entity"), SMELTERY_CONTROLLER_ENTITY)

        SMELTERY_TANK_ENTITY = FabricBlockEntityTypeBuilder.create(::TEntity, SMELTERY_TANK_BLOCK).build(null)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, myIdentifier("smeltery_tank_entity"), SMELTERY_TANK_ENTITY)
    }
}