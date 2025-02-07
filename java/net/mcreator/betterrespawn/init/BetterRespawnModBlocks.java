
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterrespawn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.betterrespawn.block.DeactivatedMemoryAnchorBlock;
import net.mcreator.betterrespawn.block.DeactivatedKhaosAnchorBlock;
import net.mcreator.betterrespawn.block.DeactivatedDuatAnchorBlock;
import net.mcreator.betterrespawn.block.DeactivatedAbzuAnchorBlock;
import net.mcreator.betterrespawn.block.BrokenAnchorBlock;
import net.mcreator.betterrespawn.block.ActivatedMemoryAnchorBlock;
import net.mcreator.betterrespawn.block.ActivatedKhaosAnchorBlock;
import net.mcreator.betterrespawn.block.ActivatedDuatAnchorBlock;
import net.mcreator.betterrespawn.block.ActivatedAbzuAnchorBlock;
import net.mcreator.betterrespawn.BetterRespawnMod;

public class BetterRespawnModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BetterRespawnMod.MODID);
	public static final DeferredBlock<Block> BROKEN_ANCHOR = REGISTRY.register("broken_anchor", BrokenAnchorBlock::new);
	public static final DeferredBlock<Block> DEACTIVATED_MEMORY_ANCHOR = REGISTRY.register("deactivated_memory_anchor", DeactivatedMemoryAnchorBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_MEMORY_ANCHOR = REGISTRY.register("activated_memory_anchor", ActivatedMemoryAnchorBlock::new);
	public static final DeferredBlock<Block> DEACTIVATED_DUAT_ANCHOR = REGISTRY.register("deactivated_duat_anchor", DeactivatedDuatAnchorBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_DUAT_ANCHOR = REGISTRY.register("activated_duat_anchor", ActivatedDuatAnchorBlock::new);
	public static final DeferredBlock<Block> DEACTIVATED_ABZU_ANCHOR = REGISTRY.register("deactivated_abzu_anchor", DeactivatedAbzuAnchorBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_ABZU_ANCHOR = REGISTRY.register("activated_abzu_anchor", ActivatedAbzuAnchorBlock::new);
	public static final DeferredBlock<Block> DEACTIVATED_KHAOS_ANCHOR = REGISTRY.register("deactivated_khaos_anchor", DeactivatedKhaosAnchorBlock::new);
	public static final DeferredBlock<Block> ACTIVATED_KHAOS_ANCHOR = REGISTRY.register("activated_khaos_anchor", ActivatedKhaosAnchorBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
