
package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.item.custom.AnoleItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = CreateBionics.MOD_ID)
public class BionicsEvents {

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
