
package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.client.BionicsModelLayers;
import net.dshbwlto.createbionics.entity.client.anole.AnoleModel;
import net.dshbwlto.createbionics.entity.client.organ.OrganModel;
import net.dshbwlto.createbionics.entity.client.oxhauler.OxhaulerModel;
import net.dshbwlto.createbionics.entity.client.replete.RepleteModel;
import net.dshbwlto.createbionics.entity.client.seeker.SeekerModel;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerModel;
import net.dshbwlto.createbionics.entity.client.stalker_captain.StalkerCaptainModel;
import net.dshbwlto.createbionics.entity.custom.*;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = CreateBionics.MOD_ID)
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

        event.registerLayerDefinition(BionicsModelLayers.SEEKER, SeekerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.SEEKER_GLOW, SeekerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.SEEKER_PICKAXE, SeekerModel::createBodyLayer);

        event.registerLayerDefinition(BionicsModelLayers.STALKER, StalkerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.STALKER_GLOW, StalkerModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.STALKER_CAPTAIN, StalkerCaptainModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.STALKER_CAPTAIN_GLOW, StalkerCaptainModel::createBodyLayer);

        event.registerLayerDefinition(BionicsModelLayers.ORGAN, OrganModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.ORGAN_GLOW, OrganModel::createBodyLayer);
        event.registerLayerDefinition(BionicsModelLayers.ORGAN_EXHAUST, OrganModel::createBodyLayer);

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
        event.put(BionicsEntities.SEEKER.get(), SeekerEntity.createAttributes().build());
        event.put(BionicsEntities.STALKER.get(), StalkerEntity.createAttributes().build());
        event.put(BionicsEntities.STALKER_CAPTAIN.get(), StalkerCaptainEntity.createAttributes().build());
        event.put(BionicsEntities.ORGAN.get(), OrganEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void scareEntity(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Spider spider) {
            spider.goalSelector.addGoal(1, new AvoidEntityGoal(spider, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE));
                }
            });
        }
        if (event.getEntity() instanceof CaveSpider caveSpider) {
            caveSpider.goalSelector.addGoal(1, new AvoidEntityGoal(caveSpider, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE));
                }
            });
        }
        if (event.getEntity() instanceof Silverfish silverfish) {
            silverfish.goalSelector.addGoal(1, new AvoidEntityGoal(silverfish, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE));
                }
            });
        }
        if (event.getEntity() instanceof Bee bee) {
            bee.goalSelector.addGoal(1, new AvoidEntityGoal(bee, Player.class, 6.0F, (double)1.0F, 1.2) {
                @Override
                public boolean canUse() {
                    return super.canUse() && (toAvoid.getMainHandItem().is(BionicsItems.ANOLE) || toAvoid.getOffhandItem().is(BionicsItems.ANOLE));
                }
            });
        }
    }
}
