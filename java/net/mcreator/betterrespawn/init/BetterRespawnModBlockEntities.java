
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterrespawn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.betterrespawn.block.entity.ActivatedMemoryAnchorBlockEntity;
import net.mcreator.betterrespawn.block.entity.ActivatedKhaosAnchorBlockEntity;
import net.mcreator.betterrespawn.block.entity.ActivatedDuatAnchorBlockEntity;
import net.mcreator.betterrespawn.block.entity.ActivatedAbzuAnchorBlockEntity;
import net.mcreator.betterrespawn.BetterRespawnMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BetterRespawnModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BetterRespawnMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ACTIVATED_MEMORY_ANCHOR = register("activated_memory_anchor", BetterRespawnModBlocks.ACTIVATED_MEMORY_ANCHOR, ActivatedMemoryAnchorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ACTIVATED_DUAT_ANCHOR = register("activated_duat_anchor", BetterRespawnModBlocks.ACTIVATED_DUAT_ANCHOR, ActivatedDuatAnchorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ACTIVATED_ABZU_ANCHOR = register("activated_abzu_anchor", BetterRespawnModBlocks.ACTIVATED_ABZU_ANCHOR, ActivatedAbzuAnchorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ACTIVATED_KHAOS_ANCHOR = register("activated_khaos_anchor", BetterRespawnModBlocks.ACTIVATED_KHAOS_ANCHOR, ActivatedKhaosAnchorBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVATED_MEMORY_ANCHOR.get(), (blockEntity, side) -> ((ActivatedMemoryAnchorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVATED_DUAT_ANCHOR.get(), (blockEntity, side) -> ((ActivatedDuatAnchorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVATED_ABZU_ANCHOR.get(), (blockEntity, side) -> ((ActivatedAbzuAnchorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ACTIVATED_KHAOS_ANCHOR.get(), (blockEntity, side) -> ((ActivatedKhaosAnchorBlockEntity) blockEntity).getItemHandler());
	}
}
