package net.dshbwlto.createbionics.event;

import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber(modid = CreateBionics.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if(event.getEntity() instanceof Sheep sheep) {
            if(event.getSource().getDirectEntity() instanceof Player player) {
                if (player.getMainHandItem().getItem() == ModItems.ANOLE.get()) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with a metal detector!"));
                }

                if (player.getMainHandItem().getItem() == ModItems.COMMAND_WHISTLE.get()) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with a tomato!"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.GLOWING, 600));
                    player.getMainHandItem().shrink(1);
                }
            }
        }
    }
}
