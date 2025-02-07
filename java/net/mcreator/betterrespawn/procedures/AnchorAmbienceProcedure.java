package net.mcreator.betterrespawn.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.init.BetterRespawnModBlocks;

public class AnchorAmbienceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Math.random() < 0.1) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_MEMORY_ANCHOR.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 4, 9), 0.3, 0.3, 0.3, 0.05);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_DUAT_ANCHOR.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, (float) 0.8);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, (float) 0.8, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMALL_FLAME, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 4, 9), 0.3, 0.3, 0.3, 0.05);
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_KHAOS_ANCHOR.get()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 4, 9), 0.3, 0.3, 0.3, 0.05);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, (float) 1.2, false);
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.BUBBLE_COLUMN_UP, (x + 0.5), (y + 0.5), (z + 0.5), Mth.nextInt(RandomSource.create(), 4, 9), 0.3, 0.3, 0.3, 0.05);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, (float) 0.9);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchorambient")), SoundSource.BLOCKS, 1, (float) 0.9, false);
					}
				}
			}
		}
		if (Math.random() < 0.2) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_ABZU_ANCHOR.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:abzuanchorambient")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:abzuanchorambient")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
		AnchorBlockstateUpdateProcedure.execute(world, x, y, z);
	}
}
