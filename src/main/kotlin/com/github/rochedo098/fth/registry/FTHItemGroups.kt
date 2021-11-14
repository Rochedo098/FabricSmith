package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.FabricSmith.myIdentifier
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.registry.Registry

object FTHItemGroups {
    val GROUP: ItemGroup =
        FabricItemGroupBuilder.create(
            myIdentifier("general")
        ).icon { ItemStack(FabricSmith.getItemHelper("steel_ingot")) }
        .build()
}