package net.mcreator.betterrespawn.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;
import net.mcreator.betterrespawn.init.BetterRespawnModBlocks;
import net.mcreator.betterrespawn.BetterRespawnMod;

import java.util.ArrayList;

public class RespawnDisableProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(
				BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor)))
				.getBlock() == BetterRespawnModBlocks.ACTIVATED_MEMORY_ANCHOR.get() && Math.random() < 0.6) {
			{
				BlockPos _bp = BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
						entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor);
				BlockState _bs = BetterRespawnModBlocks.DEACTIVATED_MEMORY_ANCHOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			BetterRespawnMod.queueServerWork(5, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchordeplete")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor,
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchordeplete")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 1) {
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
		} else if ((world.getBlockState(
				BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor)))
				.getBlock() == BetterRespawnModBlocks.ACTIVATED_ABZU_ANCHOR.get() && Math.random() < 0.2) {
			{
				BlockPos _bp = BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
						entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor);
				BlockState _bs = BetterRespawnModBlocks.DEACTIVATED_ABZU_ANCHOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			BetterRespawnMod.queueServerWork(5, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:abzuanchordeplete")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor,
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:abzuanchordeplete")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 2) {
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
		} else if ((world.getBlockState(
				BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor)))
				.getBlock() == BetterRespawnModBlocks.ACTIVATED_DUAT_ANCHOR.get() && Math.random() < 0.3) {
			{
				BlockPos _bp = BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
						entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor);
				BlockState _bs = BetterRespawnModBlocks.DEACTIVATED_DUAT_ANCHOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			BetterRespawnMod.queueServerWork(5, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchordeplete")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor,
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchordeplete")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 3) {
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
		} else if ((world.getBlockState(
				BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor)))
				.getBlock() == BetterRespawnModBlocks.ACTIVATED_KHAOS_ANCHOR.get() && Math.random() < 0.1) {
			{
				BlockPos _bp = BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
						entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor);
				BlockState _bs = BetterRespawnModBlocks.DEACTIVATED_KHAOS_ANCHOR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			BetterRespawnMod.queueServerWork(5, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor,
								entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchordeplete")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor, entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor,
								BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("better_respawn:memoryanchordeplete")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			});
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).XAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).YAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor == entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES).ZAnchor
						&& entityiterator.getData(BetterRespawnModVariables.PLAYER_VARIABLES).AnchorType == 4) {
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
		}
	}
}
