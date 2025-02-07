package net.mcreator.betterrespawn.network;

import org.openjdk.nashorn.internal.runtime.regexp.joni.constants.AnchorType;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.betterrespawn.BetterRespawnMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class BetterRespawnModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, BetterRespawnMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		BetterRespawnMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.XBedOverride = original.XBedOverride;
			clone.YBedOverride = original.YBedOverride;
			clone.ZBedOverride = original.ZBedOverride;
			clone.HasInteractedWithAnchor = original.HasInteractedWithAnchor;
			clone.HasVisitedForest = original.HasVisitedForest;
			clone.HasVisitedPlains = original.HasVisitedPlains;
			clone.HasVisitedMeadow = original.HasVisitedMeadow;
			clone.HasVisitedTaiga = original.HasVisitedTaiga;
			clone.HasVisitedMegaTaiga = original.HasVisitedMegaTaiga;
			clone.HasVisitedBirch = original.HasVisitedBirch;
			clone.HasVisitedFlowerForest = original.HasVisitedFlowerForest;
			clone.HasVisitedDarkForest = original.HasVisitedDarkForest;
			clone.HasVisitedDesert = original.HasVisitedDesert;
			clone.HasVisitedMesa = original.HasVisitedMesa;
			clone.HasVisitedSavanna = original.HasVisitedSavanna;
			clone.HasVisitedOcean = original.HasVisitedOcean;
			clone.HasVisitedJungle = original.HasVisitedJungle;
			clone.HasVisitedMountains = original.HasVisitedMountains;
			clone.HasVisitedTundra = original.HasVisitedTundra;
			clone.HasVisitedSnowyTaiga = original.HasVisitedSnowyTaiga;
			clone.HasVisitedIceSpikes = original.HasVisitedIceSpikes;
			clone.HasVisitedMushroomIsle = original.HasVisitedMushroomIsle;
			clone.AnchorType = original.AnchorType;
			clone.XAnchor = original.XAnchor;
			clone.YAnchor = original.YAnchor;
			clone.ZAnchor = original.ZAnchor;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double XBedOverride = 0;
		public double YBedOverride = 0;
		public double ZBedOverride = 0;
		public boolean HasInteractedWithAnchor = false;
		public boolean HasVisitedForest = false;
		public boolean HasVisitedPlains = false;
		public boolean HasVisitedMeadow = false;
		public boolean HasVisitedTaiga = false;
		public boolean HasVisitedMegaTaiga = false;
		public boolean HasVisitedBirch = false;
		public boolean HasVisitedFlowerForest = false;
		public boolean HasVisitedDarkForest = false;
		public boolean HasVisitedDesert = false;
		public boolean HasVisitedMesa = false;
		public boolean HasVisitedSavanna = false;
		public boolean HasVisitedOcean = false;
		public boolean HasVisitedJungle = false;
		public boolean HasVisitedMountains = false;
		public boolean HasVisitedTundra = false;
		public boolean HasVisitedSnowyTaiga = false;
		public boolean HasVisitedIceSpikes = false;
		public boolean HasVisitedMushroomIsle = false;
		public double AnchorType = 0.0;
		public double XAnchor = 0;
		public double YAnchor = 0;
		public double ZAnchor = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("XBedOverride", XBedOverride);
			nbt.putDouble("YBedOverride", YBedOverride);
			nbt.putDouble("ZBedOverride", ZBedOverride);
			nbt.putBoolean("HasInteractedWithAnchor", HasInteractedWithAnchor);
			nbt.putBoolean("HasVisitedForest", HasVisitedForest);
			nbt.putBoolean("HasVisitedPlains", HasVisitedPlains);
			nbt.putBoolean("HasVisitedMeadow", HasVisitedMeadow);
			nbt.putBoolean("HasVisitedTaiga", HasVisitedTaiga);
			nbt.putBoolean("HasVisitedMegaTaiga", HasVisitedMegaTaiga);
			nbt.putBoolean("HasVisitedBirch", HasVisitedBirch);
			nbt.putBoolean("HasVisitedFlowerForest", HasVisitedFlowerForest);
			nbt.putBoolean("HasVisitedDarkForest", HasVisitedDarkForest);
			nbt.putBoolean("HasVisitedDesert", HasVisitedDesert);
			nbt.putBoolean("HasVisitedMesa", HasVisitedMesa);
			nbt.putBoolean("HasVisitedSavanna", HasVisitedSavanna);
			nbt.putBoolean("HasVisitedOcean", HasVisitedOcean);
			nbt.putBoolean("HasVisitedJungle", HasVisitedJungle);
			nbt.putBoolean("HasVisitedMountains", HasVisitedMountains);
			nbt.putBoolean("HasVisitedTundra", HasVisitedTundra);
			nbt.putBoolean("HasVisitedSnowyTaiga", HasVisitedSnowyTaiga);
			nbt.putBoolean("HasVisitedIceSpikes", HasVisitedIceSpikes);
			nbt.putBoolean("HasVisitedMushroomIsle", HasVisitedMushroomIsle);
			nbt.putDouble("AnchorType", AnchorType);
			nbt.putDouble("XAnchor", XAnchor);
			nbt.putDouble("YAnchor", YAnchor);
			nbt.putDouble("ZAnchor", ZAnchor);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			XBedOverride = nbt.getDouble("XBedOverride");
			YBedOverride = nbt.getDouble("YBedOverride");
			ZBedOverride = nbt.getDouble("ZBedOverride");
			HasInteractedWithAnchor = nbt.getBoolean("HasInteractedWithAnchor");
			HasVisitedForest = nbt.getBoolean("HasVisitedForest");
			HasVisitedPlains = nbt.getBoolean("HasVisitedPlains");
			HasVisitedMeadow = nbt.getBoolean("HasVisitedMeadow");
			HasVisitedTaiga = nbt.getBoolean("HasVisitedTaiga");
			HasVisitedMegaTaiga = nbt.getBoolean("HasVisitedMegaTaiga");
			HasVisitedBirch = nbt.getBoolean("HasVisitedBirch");
			HasVisitedFlowerForest = nbt.getBoolean("HasVisitedFlowerForest");
			HasVisitedDarkForest = nbt.getBoolean("HasVisitedDarkForest");
			HasVisitedDesert = nbt.getBoolean("HasVisitedDesert");
			HasVisitedMesa = nbt.getBoolean("HasVisitedMesa");
			HasVisitedSavanna = nbt.getBoolean("HasVisitedSavanna");
			HasVisitedOcean = nbt.getBoolean("HasVisitedOcean");
			HasVisitedJungle = nbt.getBoolean("HasVisitedJungle");
			HasVisitedMountains = nbt.getBoolean("HasVisitedMountains");
			HasVisitedTundra = nbt.getBoolean("HasVisitedTundra");
			HasVisitedSnowyTaiga = nbt.getBoolean("HasVisitedSnowyTaiga");
			HasVisitedIceSpikes = nbt.getBoolean("HasVisitedIceSpikes");
			HasVisitedMushroomIsle = nbt.getBoolean("HasVisitedMushroomIsle");
			AnchorType = nbt.getDouble("AnchorType");
			XAnchor = nbt.getDouble("XAnchor");
			YAnchor = nbt.getDouble("YAnchor");
			ZAnchor = nbt.getDouble("ZAnchor");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(BetterRespawnMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
