package net.dshbwlto.createrobotics.item.custom;

import net.dshbwlto.createrobotics.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.effects.PlaySoundEffect;
import net.minecraft.world.level.Level;

import java.util.List;

public class CommandWhistleItem extends Item {
    public CommandWhistleItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        player.playSound(ModSounds.COMMAND_WHISTLE.get(), 1.0F, 1.0F);
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift1"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift3"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.command_whistle_item.tooltip.shift1"));            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift1"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.command_whistle_item.tooltip.shift2"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.command_whistle_item.tooltip.shift3"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
}

