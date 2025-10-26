package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.anole.AnoleModel;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerModel;
import net.dshbwlto.createbionics.entity.client.replete.RepleteModel;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerModel;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CreateBionics.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class BionicsEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BionicsModelLayers.ANOLE, AnoleModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.ANOLE_MARKINGS, AnoleModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.OXHAULER, OxhaulerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.OXHAULER_GLOW, OxhaulerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.OXHAULER_COLOR, OxhaulerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.REPLETE, RepleteModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.REPLETE_GLOW, RepleteModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.STALKER, StalkerModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(Capabilities.FluidHandler.ENTITY, BionicsEntities.REPLETE.get(), RepleteEntity::getTank);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(BionicsEntities.ANOLE.get(), AnoleEntity.createAttributes().build());
        event.put(BionicsEntities.OXHAULER.get(), OxhaulerEntity.createAttributes().build());
        event.put(BionicsEntities.REPLETE.get(), RepleteEntity.createAttributes().build());
        event.put(BionicsEntities.STALKER.get(), StalkerEntity.createAttributes().build());
    }

}
