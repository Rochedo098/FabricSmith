package com.github.rochedo098.fth.items

import com.github.rochedo098.fth.FabricSmith
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class FTHSlime: Item(Settings()) {
    override fun getName(stack: ItemStack): Text {
        val sSlime: String = stack.nbt!!.getString("slime")
        FabricSmith.slimes.forEach { slime ->
            if (sSlime == slime) {
                return TranslatableText("item.${FabricSmith.namespace}.slime.${sSlime}")
            }
        }
        return LiteralText("404 Not Found")
    }
}