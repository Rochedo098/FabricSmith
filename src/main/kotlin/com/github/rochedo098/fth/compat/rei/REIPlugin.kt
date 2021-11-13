package com.github.rochedo098.fth.compat.rei

import com.github.rochedo098.fth.FabricSmith
import me.shedaniel.rei.api.client.plugins.REIClientPlugin
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry
import me.shedaniel.rei.api.common.util.EntryStacks
import net.minecraft.item.ItemStack

object REIPlugin: REIClientPlugin {
    override fun registerEntries(registry: EntryRegistry) {
        FabricSmith.ingots.forEach { ingot ->
            registry.addEntriesAfter(EntryStacks.of(FabricSmith.INGOT),
                EntryStacks.of(ItemStack(FabricSmith.INGOT).also { it.orCreateNbt.putString("ingot", ingot) }))
        }

        FabricSmith.slimes.forEach { slime ->
            registry.addEntriesAfter(EntryStacks.of(FabricSmith.SLIME),
                EntryStacks.of(ItemStack(FabricSmith.SLIME).also { it.orCreateNbt.putString("slime", slime) }))
        }

        FabricSmith.casts.forEach { cast ->
            registry.addEntriesAfter(EntryStacks.of(FabricSmith.CAST),
                EntryStacks.of(ItemStack(FabricSmith.CAST).also { it.orCreateNbt.putString("cast", cast) }))
        }
    }
}