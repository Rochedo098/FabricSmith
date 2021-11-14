package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith.myIdentifier
import com.glisco.owo.itemgroup.Icon
import com.glisco.owo.itemgroup.OwoItemGroup
import com.glisco.owo.itemgroup.gui.ItemGroupButton
import com.glisco.owo.itemgroup.gui.ItemGroupTab
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry


object FTHItemGroups {
    val GROUP: OwoItemGroup = object : OwoItemGroup(myIdentifier("general")) {
        override fun setup() {
            keepStaticTitle()
            addTab(Icon.of(Registry.ITEM.get(myIdentifier("steel_ingot"))), "materials", ItemGroupTab.EMPTY)
            addTab(Icon.of(Registry.ITEM.get(myIdentifier("steel_ingot"))), "parts", ItemGroupTab.EMPTY)
            addTab(Icon.of(Registry.ITEM.get(myIdentifier("steel_ingot"))), "smeltery", ItemGroupTab.EMPTY)
        }

        override fun createIcon(): ItemStack {
            return ItemStack(FTHBlocks.SMELTERY_CONTROLLER_BLOCK)
        }
    }
}