package net.mcreator.betterrespawn.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiveAdventuringTimeProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedForest == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedPlains == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedMeadow == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedTaiga == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedMegaTaiga == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedBirch == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedFlowerForest == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedDarkForest == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedDesert == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedMesa == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedSavanna == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedOcean == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedJungle == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedMountains == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedTundra == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedSnowyTaiga == true
				&& entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedIceSpikes == true && entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasVisitedMushroomIsle == true) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("better_respawn:adventuring_time"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}
}
