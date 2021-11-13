package com.github.rochedo098.fth.items

import com.github.rochedo098.fth.FabricSmith
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class FTHCasts: Item(Settings()) {
    override fun getName(stack: ItemStack): Text {
        val cCast: String = stack.nbt!!.getString("cast")
        FabricSmith.casts.forEach { cast ->
            if (cCast == cast) {
                return TranslatableText("item.${FabricSmith.namespace}.cast.${cCast}")
            }
        }
        return LiteralText("404 Not Found")
    }
}