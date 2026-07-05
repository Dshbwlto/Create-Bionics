package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.item.client.AnoleItemRenderer;
import net.dshbwlto.createbionics.item.client.InventoryPreviewItemRenderer;
import net.dshbwlto.createbionics.item.client.OrganHeadItemRenderer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class InventoryPreviewItem extends Item {
    public InventoryPreviewItem(Properties properties) {
        super(properties);
    }

    public int currentRobot = 1;
    public int robotCount = 6;
    public int variant = 0;
    public int marking = 0;
    public int countdown = 0;

    public void advanceRobot() {
        if (variant < robotCount) {
            variant += 1;
        } else {
            variant = 0;
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new InventoryPreviewItemRenderer()));
    }
}
