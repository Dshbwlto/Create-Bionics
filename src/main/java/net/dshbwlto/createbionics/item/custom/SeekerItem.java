
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.TooltipHelper;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.entity.custom.SeekerEntity;
import net.dshbwlto.createbionics.item.api.RobotSpawnerItem;
import net.dshbwlto.createbionics.item.client.RepleteBodyItemRenderer;
import net.dshbwlto.createbionics.item.client.SeekerItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.cef.input.CefCompositionUnderline;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.function.Consumer;

public class SeekerItem extends RobotSpawnerItem {

    public EntityType<? extends AbstractRobot> type;

    public SeekerItem(EntityType<? extends AbstractRobot> defaultType, Properties properties) {
        super(defaultType, properties);
        this.type = defaultType;
    }

    @Override
    public void spawnEntity(Level level, BlockPos blockPos, InteractionHand hand, Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int fuel = stack.get(BionicsDataComponentTypes.FUEL.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int pickaxe = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;

        SeekerEntity seekerEntity = new SeekerEntity(type, level);
        seekerEntity.setPos(blockPos.getCenter().add(0, -0.5f, 0));
        seekerEntity.setVariantNumber(variant);
        seekerEntity.setFuel(fuel);
        level.addFreshEntity(seekerEntity);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int fuel = stack.get(BionicsDataComponentTypes.FUEL.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int pickaxe = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;

        int variantColor = variant == 0 ? 0xC9974C : variant == 1 ? 0xF1DD79 : 11184810;
        int pickaxeColor = pickaxe == 0 ? 0xFFFFFF : pickaxe == 1 ? 0x4aedd9 : 0x6d585d;

        tooltipComponents.add(Component.literal(""));

        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant").append(Component.translatable("entity.createbionics.tooltip.variant_" + variant).setStyle(Style.EMPTY.withColor(variantColor))));
        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.pickaxe").append(Component.translatable("entity.createbionics.tooltip.pickaxe_" + pickaxe).setStyle(Style.EMPTY.withColor(pickaxeColor))));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new SeekerItemRenderer()));
    }
}
