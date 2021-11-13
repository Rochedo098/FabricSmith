package com.github.rochedo098.fth.items

import com.github.rochedo098.fth.FabricSmith
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class FTHNugget: Item(Settings()) {
    override fun getName(stack: ItemStack): Text {
        val nNugget: String = stack.nbt!!.getString("nugget")
        FabricSmith.ingots.forEach { nugget ->
            if (nNugget == nugget) {
                return TranslatableText("item.${FabricSmith.namespace}.nugget.${nNugget}")
            }
        }
        return LiteralText("404 Not Found")
    }
}
