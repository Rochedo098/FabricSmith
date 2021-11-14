package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.FabricSmith.itemSettings
import com.github.rochedo098.fth.FabricSmith.myIdentifier
import net.minecraft.item.Item
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.registry.Registry

object FTHItems {
    val nuggets: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron")
    val ingots: Array<String> = arrayOf("cobalt", "ardite", "manyullyn", "copper", "tin", "aluminium", "bronze", "aluminium_brass", "alumite", "steel", "obsidian", "pig_iron")
    val slimes: Array<String> = arrayOf("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink")
    val casts: Array<String> = arrayOf("blank", "rod", "binding", "sword_blade", "pickaxe_head", "axe_head", "shovel_head", "hoe_head")

    fun registerMaterials() {
        nuggets.forEach { nugget ->
            Registry.register(Registry.ITEM, myIdentifier("${nugget}_nugget"), DynamicItem(itemSettings(), "nugget", nugget))
        }

        ingots.forEach { ingot ->
            Registry.register(Registry.ITEM, myIdentifier("${ingot}_ingot"), DynamicItem(itemSettings(), "ingot", ingot))
        }

        slimes.forEach { slime ->
            Registry.register(Registry.ITEM, myIdentifier("${slime}_slime"), DynamicItem(itemSettings(), "slime", slime))
        }

        casts.forEach { cast ->
            Registry.register(Registry.ITEM, myIdentifier("${cast}_cast"), DynamicItem(itemSettings(), "cast", cast))
        }
    }

    class DynamicItem(settings: Settings, val item: String, val variant: String): Item(settings) {
        override fun getName(): Text {
            return TranslatableText("item.${FabricSmith.namespace}.$item.$variant")
        }
    }
}