
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterrespawn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.betterrespawn.BetterRespawnMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BetterRespawnModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterRespawnMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {

			tabData.accept(BetterRespawnModBlocks.BROKEN_ANCHOR.get().asItem());
			tabData.accept(BetterRespawnModBlocks.DEACTIVATED_MEMORY_ANCHOR.get().asItem());
			tabData.accept(BetterRespawnModBlocks.DEACTIVATED_DUAT_ANCHOR.get().asItem());
			tabData.accept(BetterRespawnModBlocks.DEACTIVATED_ABZU_ANCHOR.get().asItem());
			tabData.accept(BetterRespawnModBlocks.DEACTIVATED_KHAOS_ANCHOR.get().asItem());

		}
	}
}
