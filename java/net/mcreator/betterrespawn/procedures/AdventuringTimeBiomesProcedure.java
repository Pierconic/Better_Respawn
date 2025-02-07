package net.mcreator.betterrespawn.procedures;

import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AdventuringTimeBiomesProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("forest"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedForest = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("sunflower_plains"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedPlains = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("meadow"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedMeadow = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("taiga"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedTaiga = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_pine_taiga")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_spruce_taiga"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedMegaTaiga = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("birch_forest")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("old_growth_birch_forest"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedBirch = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("flower_forest"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedFlowerForest = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("dark_forest"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedDarkForest = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("desert"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedDesert = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("badlands")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("eroded_badlands"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("plains")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("wooded_badlands"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedMesa = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("savanna")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("windswept_savanna"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedSavanna = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("cold_ocean")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("ocean"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("lukewarm_ocean")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("warm_ocean"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedOcean = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("jungle")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("bamboo_jungle"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedJungle = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("snowy_slopes")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("frozen_peaks"))
					|| world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("stony_peaks")) || world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("jagged_peaks"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedMountains = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("snowy_plains"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedTundra = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("snowy_taiga"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedSnowyTaiga = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("ice_spikes"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedIceSpikes = true;
					_vars.syncPlayerVariables(entity);
				}
			}
			if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("mushroom_fields"))) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.HasVisitedMushroomIsle = true;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
