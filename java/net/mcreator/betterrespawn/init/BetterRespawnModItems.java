
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterrespawn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.betterrespawn.BetterRespawnMod;

public class BetterRespawnModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BetterRespawnMod.MODID);
	public static final DeferredItem<Item> BROKEN_ANCHOR = block(BetterRespawnModBlocks.BROKEN_ANCHOR);
	public static final DeferredItem<Item> DEACTIVATED_MEMORY_ANCHOR = block(BetterRespawnModBlocks.DEACTIVATED_MEMORY_ANCHOR);
	public static final DeferredItem<Item> ACTIVATED_MEMORY_ANCHOR = block(BetterRespawnModBlocks.ACTIVATED_MEMORY_ANCHOR);
	public static final DeferredItem<Item> DEACTIVATED_DUAT_ANCHOR = block(BetterRespawnModBlocks.DEACTIVATED_DUAT_ANCHOR);
	public static final DeferredItem<Item> ACTIVATED_DUAT_ANCHOR = block(BetterRespawnModBlocks.ACTIVATED_DUAT_ANCHOR);
	public static final DeferredItem<Item> DEACTIVATED_ABZU_ANCHOR = block(BetterRespawnModBlocks.DEACTIVATED_ABZU_ANCHOR);
	public static final DeferredItem<Item> ACTIVATED_ABZU_ANCHOR = block(BetterRespawnModBlocks.ACTIVATED_ABZU_ANCHOR);
	public static final DeferredItem<Item> DEACTIVATED_KHAOS_ANCHOR = block(BetterRespawnModBlocks.DEACTIVATED_KHAOS_ANCHOR);
	public static final DeferredItem<Item> ACTIVATED_KHAOS_ANCHOR = block(BetterRespawnModBlocks.ACTIVATED_KHAOS_ANCHOR);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
