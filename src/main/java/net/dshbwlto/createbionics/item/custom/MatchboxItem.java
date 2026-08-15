
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.Util.TimeUtil;
import net.dshbwlto.createbionics.Util.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.custom.MatchboxEntity;
import net.dshbwlto.createbionics.item.api.RobotSpawnerItem;
import net.dshbwlto.createbionics.item.client.MatchboxItemRenderer;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class MatchboxItem extends RobotSpawnerItem {

    public EntityType<? extends AbstractRobot> type;

    public MatchboxItem(EntityType<? extends AbstractRobot> defaultType, Properties properties) {
        super(defaultType, properties);
        this.type = defaultType;
    }

    @Override
    public void spawnEntity(Level level, BlockPos blockPos, InteractionHand hand, Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 2;
        int fuel = stack.get(BionicsDataComponentTypes.FUEL.get()) != null ? stack.get(BionicsDataComponentTypes.FUEL.get()) : 0;
        int torches = stack.get(BionicsDataComponentTypes.MISC_INT.get()) != null ? stack.get(BionicsDataComponentTypes.MISC_INT.get()) : 0;
        String name = stack.get(BionicsDataComponentTypes.NAME.get());
        int i = fuel < 24001 ? fuel : -1;

        MatchboxEntity matchboxEntity = new MatchboxEntity(type, level);
        matchboxEntity.setPos(blockPos.getCenter().add(0, -0.5f, 0));
        matchboxEntity.setVariantNumber(variant);
        matchboxEntity.setFuel(i);
        matchboxEntity.setTorchCount(torches);
        if (name != null) {
            matchboxEntity.setCustomName(Component.literal(name));
        }
        level.addFreshEntity(matchboxEntity);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 2;
        int fuel = stack.get(BionicsDataComponentTypes.FUEL.get()) != null ? stack.get(BionicsDataComponentTypes.FUEL.get()) : 0;
        int torches = stack.get(BionicsDataComponentTypes.MISC_INT.get()) != null ? stack.get(BionicsDataComponentTypes.MISC_INT.get()) : 0;
        String name = stack.get(BionicsDataComponentTypes.NAME.get());
        int variantColor = variant == 0 ? 0xC9974C : variant == 1 ? 0xF1DD79 : 11184810;
        int fuelColor = fuel > 24000 ? 16733695 : fuel > 12000 ? 0x93ebff : fuel > 0 ? 0xfc9903 : 5592405;
        int torchColor = torches == 0 ? 5592405 : 16777215;

        tooltipComponents.add(Component.literal(""));

        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant").append(Component.translatable("entity.createbionics.tooltip.variant_" + variant).setStyle(Style.EMPTY.withColor(variantColor))));
        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.torches").append(Component.literal("" + torches).setStyle(Style.EMPTY.withColor(torchColor))));

        if (fuel != 0) {
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.fuel").append(fuel == 24001 ? Component.translatable("entity.createbionics.tooltip.infinite").getString() : TimeUtil.ticksToMinutes(fuel)).setStyle(Style.EMPTY.withColor(fuelColor)));
        } else {
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.fuel").append("0:00").setStyle(Style.EMPTY.withColor(fuelColor)));
        }
        if (name != null) {
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.name").append(Component.literal(name)));
        }
        tooltipComponents.add(Component.literal(""));

        if (Screen.hasAltDown()) {
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant_list2"));
            tooltipComponents.add(Component.literal(""));
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant_" + 0).setStyle(Style.EMPTY.withColor(0xC9974C)));
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant_" + 1).setStyle(Style.EMPTY.withColor(0xF1DD79)));
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant_" + 2).setStyle(Style.EMPTY.withColor(11184810)));
        } else {
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant_list1"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new MatchboxItemRenderer()));
    }
}
