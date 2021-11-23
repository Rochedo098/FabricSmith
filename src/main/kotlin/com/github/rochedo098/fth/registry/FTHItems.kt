package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.FabricSmith.itemSettings
import com.github.rochedo098.fth.FabricSmith.myIdentifier
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.registry.Registry

object FTHItems {
    // Variants
    val materials: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron")
    val slimes: Array<String> = arrayOf("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink")
    val casts: Array<String> = arrayOf("blank", "rod", "binding", "sword_blade", "pickaxe_head", "axe_head", "shovel_head", "hoe_head")

    private fun item(id: String, group: GroupVariant, maxCount: Int = 64) = Registry.register(Registry.ITEM, myIdentifier(id), Item(itemSettings(group).maxCount(maxCount)))
    private fun item(id: String, item: Item) = Registry.register(Registry.ITEM, myIdentifier(id), item)

    fun register() {
        // Resources
        materials.forEach { material ->
            item("${material}_nugget", GroupVariant.RESOURCES)
            item("${material}_ingot", GroupVariant.RESOURCES)

            // Heads
            item("${material}_rod", GroupVariant.PARTS)
            item("${material}_binding", GroupVariant.PARTS)
            item("${material}_sword_blade", GroupVariant.PARTS)
            item("${material}_pickaxe_head", GroupVariant.PARTS)
            item("${material}_axe_head", GroupVariant.PARTS)
            item("${material}_shovel_head", GroupVariant.PARTS)
            item("${material}_hoe_head", GroupVariant.PARTS)
        }

        slimes.forEach { slime ->
            item("${slime}_slime", GroupVariant.RESOURCES)
        }

        casts.forEach { cast ->
            item("${cast}_cast", GroupVariant.OTHERS)
        }
    }
}