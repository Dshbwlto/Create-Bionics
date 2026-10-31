package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.item.client.InventoryPreviewItemRenderer;
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

    public int robotCount = 3;
    public int currentRobot = 1;
    public int marking = 0;
    public int countdown = 0;

    public void advanceRobot() {
        if (currentRobot < robotCount) {
            currentRobot += 1;
        } else {
            currentRobot = 1;
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (countdown > 0) {
            countdown -= 1;
        } else {
            countdown = 60;
            advanceRobot();
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new InventoryPreviewItemRenderer()));
    }
}
