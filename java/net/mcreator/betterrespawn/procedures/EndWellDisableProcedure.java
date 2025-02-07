package net.mcreator.betterrespawn.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.betterrespawn.network.BetterRespawnModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EndWellDisableProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y - 0.2, z))).getBlock() == Blocks.END_PORTAL
				&& (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.END) {
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.XAnchor = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.YAnchor = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.ZAnchor = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.XBedOverride = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.YBedOverride = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.ZBedOverride = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				BetterRespawnModVariables.PlayerVariables _vars = entity.getData(BetterRespawnModVariables.PLAYER_VARIABLES);
				_vars.AnchorType = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
