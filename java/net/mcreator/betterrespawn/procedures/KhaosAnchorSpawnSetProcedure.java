package net.mcreator.betterrespawn.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;
import net.mcreator.betterrespawn.init.BetterRespawnModBlocks;

import java.util.ArrayList;

public class KhaosAnchorSpawnSetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
			world.setBlock(BlockPos.containing(x, y, z), BetterRespawnModBlocks.DEACTIVATED_KHAOS_ANCHOR.get().defaultBlockState(), 3);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchordeplete")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchordeplete")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor == x && entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor == y
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor == z && entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 4) {
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
						_player.displayClientMessage(Component.literal("Your Anchor has been deactivated"), true);
				}
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END) {
				if (!(x == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor && y == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor && z == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor
						&& 1 == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType)) {
					if ((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 20, 0.1, 0.1, 0.1, 0.6);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Respawn point set"), true);
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.AnchorType = 4;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XBedOverride = x + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YBedOverride = y - 2;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZBedOverride = z + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XAnchor = x;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YAnchor = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZAnchor = z;
							_vars.syncPlayerVariables(entity);
						}
					} else if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR) {
						AnchorParticlesProcedure.execute(world, x, y, z);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Respawn point set"), true);
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.AnchorType = 4;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XBedOverride = x + 1;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YBedOverride = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZBedOverride = z + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XAnchor = x;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YAnchor = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZAnchor = z;
							_vars.syncPlayerVariables(entity);
						}
					} else if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR) {
						AnchorParticlesProcedure.execute(world, x, y, z);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Respawn point set"), true);
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.AnchorType = 4;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XBedOverride = x - 1;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YBedOverride = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZBedOverride = z + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XAnchor = x;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YAnchor = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZAnchor = z;
							_vars.syncPlayerVariables(entity);
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR) {
						AnchorParticlesProcedure.execute(world, x, y, z);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Respawn point set"), true);
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.AnchorType = 4;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XBedOverride = x + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YBedOverride = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZBedOverride = z - 1;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XAnchor = x;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YAnchor = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZAnchor = z;
							_vars.syncPlayerVariables(entity);
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR) {
						AnchorParticlesProcedure.execute(world, x, y, z);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Respawn point set"), true);
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.AnchorType = 4;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XBedOverride = x + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YBedOverride = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZBedOverride = z + 1;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XAnchor = x;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YAnchor = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZAnchor = z;
							_vars.syncPlayerVariables(entity);
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
						AnchorParticlesProcedure.execute(world, x, y, z);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchorset")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Respawn point set"), true);
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.AnchorType = 4;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XBedOverride = x + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YBedOverride = y + 1;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZBedOverride = z + 0;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.XAnchor = x;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.YAnchor = y;
							_vars.syncPlayerVariables(entity);
						}
						{
							BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
							_vars.ZAnchor = z;
							_vars.syncPlayerVariables(entity);
						}
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Anchor obstructed"), true);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchordeplete")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:khaosanchordeplete")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
					{
						BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
						_vars.HasInteractedWithAnchor = true;
						_vars.syncPlayerVariables(entity);
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Anchor already set"), true);
				}
			} else {
				RespawnAnchorExplodeProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
