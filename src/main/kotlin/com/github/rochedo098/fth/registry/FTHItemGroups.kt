package com.github.rochedo098.fth.registry

import com.github.rochedo098.fth.FabricSmith
import com.github.rochedo098.fth.FabricSmith.myIdentifier
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

enum class GroupVariant() {
    RESOURCES,
    SMELTERY,
    TOOLS,
    PARTS,
    OTHERS
}

object FTHItemGroups {
    fun getGroup(group: GroupVariant): ItemGroup {
        return when (group) {
            GroupVariant.RESOURCES -> RESOURCES_GROUP
            GroupVariant.SMELTERY -> SMELTERY_GROUP
            GroupVariant.TOOLS -> TOOLS_GROUP
            GroupVariant.PARTS -> PARTS_GROUP
            GroupVariant.OTHERS -> OTHERS_GROUP
        }
    }

    private val RESOURCES_GROUP: ItemGroup =
        FabricItemGroupBuilder.create(
            myIdentifier("resources_group")
        ).icon { ItemStack(FabricSmith.getItemHelper("steel_ingot")) }
        .build()

    private val SMELTERY_GROUP: ItemGroup =
        FabricItemGroupBuilder.create(
            myIdentifier("smeltery_group")
        ).icon { ItemStack(FabricSmith.getItemHelper("steel_ingot")) }
            .build()

    private val TOOLS_GROUP: ItemGroup =
        FabricItemGroupBuilder.create(
            myIdentifier("tools_group")
        ).icon { ItemStack(FabricSmith.getItemHelper("steel_ingot")) }
            .build()

    private val PARTS_GROUP: ItemGroup =
        FabricItemGroupBuilder.create(
            myIdentifier("parts_group")
        ).icon { ItemStack(FabricSmith.getItemHelper("steel_ingot")) }
            .build()

    private val OTHERS_GROUP: ItemGroup =
        FabricItemGroupBuilder.create(
            myIdentifier("others_group")
        ).icon { ItemStack(FabricSmith.getItemHelper("steel_ingot")) }
            .build()
}