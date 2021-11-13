package com.github.rochedo098.fth.items

import com.github.rochedo098.fth.FabricSmith
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText

class FTHMetalBlockItem(block: Block, settings: Settings): BlockItem(block, settings) {
    override fun getName(stack: ItemStack): Text {
        val mMetal: String = stack.nbt!!.getString("metal")
        FabricSmith.ingots.forEach { metal ->
            if (mMetal == metal) {
                return TranslatableText("item.${FabricSmith.namespace}.block_metal.${mMetal}")
            }
        }
        return LiteralText("404 Not Found")
    }
}