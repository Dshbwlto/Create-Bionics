package net.dshbwlto.createbionics.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SilentPistonItem extends Item {
    public SilentPistonItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.shift"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.piston.tooltip.info"));

        } else {
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.shift"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
}

