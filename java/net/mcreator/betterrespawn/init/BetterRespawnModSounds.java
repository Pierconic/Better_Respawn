
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterrespawn.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.betterrespawn.BetterRespawnMod;

public class BetterRespawnModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, BetterRespawnMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMORYANCHORCHARGE = REGISTRY.register("memoryanchorcharge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "memoryanchorcharge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMORYANCHORDEPLETE = REGISTRY.register("memoryanchordeplete", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "memoryanchordeplete")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMORYANCHORSET = REGISTRY.register("memoryanchorset", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "memoryanchorset")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DUATANCHORCHARGE = REGISTRY.register("duatanchorcharge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "duatanchorcharge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DUATANCHORDEPLETE = REGISTRY.register("duatanchordeplete", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "duatanchordeplete")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DUATANCHORSET = REGISTRY.register("duatanchorset", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "duatanchorset")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ABZUANCHORCHARGE = REGISTRY.register("abzuanchorcharge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "abzuanchorcharge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ABZUANCHORDEPLETE = REGISTRY.register("abzuanchordeplete", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "abzuanchordeplete")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ABZUANCHORSET = REGISTRY.register("abzuanchorset", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "abzuanchorset")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KHAOSANCHORCHARGE = REGISTRY.register("khaosanchorcharge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "khaosanchorcharge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KHAOSANCHORSET = REGISTRY.register("khaosanchorset", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "khaosanchorset")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KHAOSANCHORDEPLETE = REGISTRY.register("khaosanchordeplete", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "khaosanchordeplete")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MEMORYANCHORAMBIENT = REGISTRY.register("memoryanchorambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "memoryanchorambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ABZUANCHORAMBIENT = REGISTRY.register("abzuanchorambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "abzuanchorambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DUATANCHORAMBIENT = REGISTRY.register("duatanchorambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "duatanchorambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> KHAOSANCHORAMBIENT = REGISTRY.register("khaosanchorambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("better_respawn", "khaosanchorambient")));
}
