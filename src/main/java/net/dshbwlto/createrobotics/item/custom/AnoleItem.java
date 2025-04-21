package net.dshbwlto.createrobotics.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class AnoleItem extends SpawnEggItem {
    /**
     * @param defaultType
     * @param backgroundColor
     * @param highlightColor
     * @param properties
     * @deprecated
     */
    public AnoleItem(EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor, Properties properties) {
        super(defaultType, backgroundColor, highlightColor, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift1"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift2"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift1"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift3"));
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift4"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.createrobotics.anoleitem.tooltip.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
