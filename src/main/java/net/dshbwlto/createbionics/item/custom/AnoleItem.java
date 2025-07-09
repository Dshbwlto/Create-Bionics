package net.dshbwlto.createbionics.item.custom;

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
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.shift"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.anoleitem.tooltip.info1"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.when_used"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.anoleitem.tooltip.info3"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.anoleitem.tooltip.info4"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.anoleitem.tooltip.info5"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.anoleitem.tooltip.info6"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.anoleitem.tooltip.info7"));

        } else {
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
