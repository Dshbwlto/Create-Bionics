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
}
