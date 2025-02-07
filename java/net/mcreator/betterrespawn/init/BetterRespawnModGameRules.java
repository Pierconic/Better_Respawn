
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterrespawn.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BetterRespawnModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> DEATH_EFFECT_INTENSITY;
	public static GameRules.Key<GameRules.BooleanValue> DEPLETE_ANCHORS;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		DEATH_EFFECT_INTENSITY = GameRules.register("deathEffectIntensity", GameRules.Category.PLAYER, GameRules.IntegerValue.create(1));
		DEPLETE_ANCHORS = GameRules.register("depleteAnchors", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	}
}
