package net.mcreator.betterrespawn.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.betterrespawn.BetterRespawnMod;

public class DelayedSmokeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BetterRespawnMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 40), () -> {
			world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 0, 0.18, 0);
		});
	}
}
