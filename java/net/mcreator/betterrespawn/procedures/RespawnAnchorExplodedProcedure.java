package net.mcreator.betterrespawn.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;
import net.mcreator.betterrespawn.init.BetterRespawnModBlocks;
import net.mcreator.betterrespawn.BetterRespawnMod;

import java.util.ArrayList;

public class RespawnAnchorExplodedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.TNT);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 3, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 3, 1, false);
			}
		}
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 4, 8); index0++) {
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 2));
			if (world instanceof ServerLevel _level)
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 1));
		}
		BetterRespawnMod.queueServerWork(5, () -> {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(BetterRespawnModBlocks.BROKEN_ANCHOR.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		});
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor == x && entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor == y
					&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor == z) {
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.XAnchor = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.YAnchor = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.ZAnchor = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.XBedOverride = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.YBedOverride = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.ZBedOverride = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				{
					BetterRespawnModVariables.PlayerVariables _vars = entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
					_vars.AnchorType = 0;
					_vars.syncPlayerVariables(entityiterator);
				}
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your Anchor has been destroyed"), true);
			}
		}
	}
}
