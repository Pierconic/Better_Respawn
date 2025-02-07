package net.mcreator.betterrespawn.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.init.BetterRespawnModBlocks;

public class AnchorParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double offset = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_MEMORY_ANCHOR.get()) {
			for (int index0 = 0; index0 < 10; index0++) {
				DelayedSmokeProcedure.execute(world, x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5, y + Mth.nextDouble(RandomSource.create(), 0.6, 1), z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5);
			}
			for (int index1 = 0; index1 < 20; index1++) {
				world.addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), (y + 0.5), (z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), 0, 0.08, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_DUAT_ANCHOR.get()) {
			for (int index2 = 0; index2 < 8; index2++) {
				DelayedSmokeProcedure.execute(world, x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5, y + Mth.nextDouble(RandomSource.create(), 0.6, 1), z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5);
			}
			for (int index3 = 0; index3 < 20; index3++) {
				world.addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER, (x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), (y + 0.5), (z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), 0, 0.08, 0);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_ABZU_ANCHOR.get()) {
			for (int index4 = 0; index4 < 16; index4++) {
				world.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, (x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), (y + Mth.nextDouble(RandomSource.create(), 0.6, 1)), (z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), 0,
						0.08, 0);
			}
			for (int index5 = 0; index5 < 20; index5++) {
				world.addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), (y + 0.5), (z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), 0, 0.08, 0);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == BetterRespawnModBlocks.ACTIVATED_KHAOS_ANCHOR.get()) {
			for (int index6 = 0; index6 < 16; index6++) {
				world.addParticle(ParticleTypes.PORTAL, (x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), (y + Mth.nextDouble(RandomSource.create(), 0.6, 2.6)), (z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), 0, 0.08, 0);
			}
			for (int index7 = 0; index7 < 20; index7++) {
				world.addParticle(ParticleTypes.TRIAL_SPAWNER_DETECTED_PLAYER_OMINOUS, (x + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), (y + 0.5), (z + Mth.nextDouble(RandomSource.create(), -0.6, 0.6) + 0.5), 0, 0.08, 0);
			}
		}
	}
}
