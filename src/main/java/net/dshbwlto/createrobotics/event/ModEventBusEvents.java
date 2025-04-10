package net.dshbwlto.createrobotics.event;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.dshbwlto.createrobotics.entity.ModEntities;
import net.dshbwlto.createrobotics.entity.client.AnoleModel;
import net.dshbwlto.createrobotics.entity.client.ModModelLayers;
import net.dshbwlto.createrobotics.entity.custom.AnoleEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CreateRobotics.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.ANOLE, AnoleModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ANOLE.get(), AnoleEntity.createAttributes().build());
    }

}
