
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.custom.MatchboxEntity;
import net.dshbwlto.createbionics.entity.custom.SeekerEntity;
import net.dshbwlto.createbionics.item.api.RobotSpawnerItem;
import net.dshbwlto.createbionics.item.client.MatchboxItemRenderer;
import net.dshbwlto.createbionics.item.client.SeekerItemRenderer;
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
        int fuel = stack.get(BionicsDataComponentTypes.FUEL.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 2;

        MatchboxEntity matchboxEntity = new MatchboxEntity(type, level);
        matchboxEntity.setPos(blockPos.getCenter().add(0, -0.5f, 0));
        matchboxEntity.setVariantNumber(variant);
        matchboxEntity.setFuel(fuel);
        level.addFreshEntity(matchboxEntity);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 2;

        int variantColor = variant == 0 ? 0xC9974C : variant == 1 ? 0xF1DD79 : 11184810;

        tooltipComponents.add(Component.literal(""));

        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant").append(Component.translatable("entity.createbionics.tooltip.variant_" + variant).setStyle(Style.EMPTY.withColor(variantColor))));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new MatchboxItemRenderer()));
    }
}
