package com.github.rochedo098.fth.items

import com.github.rochedo098.fth.FabricSmith
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class FTHIngot: Item(Settings()) {
    override fun getName(stack: ItemStack): Text {
        val iIngot: String = stack.nbt!!.getString("ingot")
        FabricSmith.ingots.forEach { ingot ->
            if (iIngot == ingot) {
                return TranslatableText("item.${FabricSmith.namespace}.ingot.${iIngot}")
            }
        }
        return LiteralText("404 Not Found")
    }
}
