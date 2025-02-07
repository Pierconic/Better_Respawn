package net.mcreator.betterrespawn.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.init.BetterRespawnModBlocks;

public class MemoryAnchorChargeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -5;
		found = false;
		for (int index0 = 0; index0 < 10; index0++) {
			sy = -5;
			for (int index1 = 0; index1 < 10; index1++) {
				sz = -5;
				for (int index2 = 0; index2 < 10; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).is(BlockTags.create(ResourceLocation.parse("forge:all_anchors"))) && !(x + sx == x && y + sy == y && z + sz == z)) {
						found = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (((entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 4 || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false))
				&& ((entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) || found == false)) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(-(40));
			world.setBlock(BlockPos.containing(x, y, z), BetterRespawnModBlocks.ACTIVATED_MEMORY_ANCHOR.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorcharge")), SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorcharge")), SoundSource.NEUTRAL, 2, 1, false);
				}
			}
		} else if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) < 4) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Not enough energy..."), true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.NEUTRAL, 2, 1, false);
				}
			}
		} else if (found == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Too close to another Anchor"), true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.NEUTRAL, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.NEUTRAL, 2, 1, false);
				}
			}
		}
	}
}
