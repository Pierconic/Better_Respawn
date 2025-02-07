package net.mcreator.betterrespawn.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;
import net.mcreator.betterrespawn.init.BetterRespawnModGameRules;
import net.mcreator.betterrespawn.BetterRespawnMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RespawnCheckProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 0) {
			if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).HasInteractedWithAnchor == true) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your anchor was missing, or deactivated"), true);
			}
			if (!((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD)) {
				if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
					ResourceKey<Level> destinationType = Level.OVERWORLD;
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
			}
			if ((world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY)) > 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, (int) (Mth.nextInt(RandomSource.create(), 120, 360) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(
							new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (Mth.nextInt(RandomSource.create(), 120, 360) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(
							new MobEffectInstance(MobEffects.WEAKNESS, (int) (Mth.nextInt(RandomSource.create(), 1200, 2400) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0, false, false));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.soul_sand_valley.mood")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else {
			if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 1) {
				if (!((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD)) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = Level.OVERWORLD;
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
							entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride, _ent.getYRot(), _ent.getXRot());
				}
				if ((world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY)) > 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.DARKNESS, (int) (Mth.nextInt(RandomSource.create(), 120, 220) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (Mth.nextInt(RandomSource.create(), 120, 220) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0,
								false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.WEAKNESS, (int) (Mth.nextInt(RandomSource.create(), 800, 1800) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0, false, false));
				}
			} else if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 2) {
				if (!((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD)) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = Level.OVERWORLD;
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
							entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride, _ent.getYRot(), _ent.getXRot());
				}
				if ((world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY)) > 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.DARKNESS, (int) (Mth.nextInt(RandomSource.create(), 90, 220) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.DOLPHINS_GRACE, (int) (Mth.nextInt(RandomSource.create(), 90, 220) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (int) (Mth.nextInt(RandomSource.create(), 600, 800) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1,
								false, false));
				}
			} else if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 3) {
				if (!((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.NETHER)) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = Level.NETHER;
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
							entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride, _ent.getYRot(), _ent.getXRot());
				}
				if ((world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY)) > 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.DARKNESS, (int) (Mth.nextInt(RandomSource.create(), 120, 220) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (Mth.nextInt(RandomSource.create(), 90, 220) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0,
								false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, (int) (Mth.nextInt(RandomSource.create(), 240, 400) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1,
								false, false));
				}
			} else if (entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 4) {
				if (!((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END)) {
					if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
						ResourceKey<Level> destinationType = Level.END;
						if (_player.level().dimension() == destinationType)
							return;
						ServerLevel nextLevel = _player.server.getLevel(destinationType);
						if (nextLevel != null) {
							_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
							_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
							_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
							for (MobEffectInstance _effectinstance : _player.getActiveEffects())
								_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
							_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
							entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XBedOverride, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YBedOverride,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZBedOverride, _ent.getYRot(), _ent.getXRot());
				}
				if ((world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY)) > 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.DARKNESS, (int) (Mth.nextInt(RandomSource.create(), 60, 120) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) (Mth.nextInt(RandomSource.create(), 60, 120) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 0,
								false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(
								new MobEffectInstance(MobEffects.SLOW_FALLING, (int) (Mth.nextInt(RandomSource.create(), 240, 400) * (world.getLevelData().getGameRules().getInt(BetterRespawnModGameRules.DEATH_EFFECT_INTENSITY))), 1, false, false));
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(BetterRespawnModGameRules.DEPLETE_ANCHORS)) {
				BetterRespawnMod.queueServerWork(5, () -> {
					RespawnDisableProcedure.execute(world, entity);
				});
			}
		}
	}
}
