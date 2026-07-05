
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.component.BionicsDataComponentTypes;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.item.api.RobotSpawnerItem;
import net.dshbwlto.createbionics.item.client.AnoleItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
import org.jetbrains.annotations.NotNull;

import java.util.AbstractCollection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class AnoleItem extends RobotSpawnerItem {

    public EntityType<? extends AbstractRobot> type;

    public AnoleItem(EntityType<? extends AbstractRobot> defaultType, Properties properties) {
        super(defaultType, properties);
        this.type = defaultType;
    }

    @Override
    public void spawnEntity(Level level, BlockPos blockPos, InteractionHand hand, Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int fuel = stack.get(BionicsDataComponentTypes.FUEL.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int marking = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;
        String name = stack.get(BionicsDataComponentTypes.NAME.get());

        AnoleEntity anoleEntity = new AnoleEntity(type, level);
        anoleEntity.setPos(blockPos.getCenter().add(0, -0.5f, 0));
        anoleEntity.setVariantNumber(variant);
        anoleEntity.setMarkingNumber(marking);
        anoleEntity.setFuel(fuel);
        if (name != null) {
            anoleEntity.setCustomName(Component.literal(name));
        }
        level.addFreshEntity(anoleEntity);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int variant = stack.get(BionicsDataComponentTypes.VARIANT.get()) != null ? stack.get(BionicsDataComponentTypes.VARIANT.get()) : 0;
        int marking = stack.get(BionicsDataComponentTypes.MARKING.get()) != null ? stack.get(BionicsDataComponentTypes.MARKING.get()) : 0;
        String name = stack.get(BionicsDataComponentTypes.NAME.get());

        int variantColor = variant == 0 ? 0xC9974C
                : variant == 1 ? 0xF1DD79
                : variant == 2 ? 11184810
                : variant == 3 ? 0x6d585d
                : variant == 4 ? 0x937661
                : variant == 5 ? 0x738b55
                : 0x58af92;

        int markingColor = marking == 0 ? 0x555555
                : marking == 1 ? 0xc61501
                : marking == 2 ? 0xfad43d
                : marking == 3 ? 0x55FFFF
                : 0xff00bf;

        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.variant").append(Component.translatable("entity.createbionics.tooltip.variant_" + variant).setStyle(Style.EMPTY.withColor(variantColor))));
        tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.marking").append(Component.translatable("entity.createbionics.tooltip.marking_" + marking).setStyle(Style.EMPTY.withColor(markingColor))));
        if (name != null) {
            tooltipComponents.add(Component.translatable("entity.createbionics.tooltip.name").append(Component.literal(name)));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new AnoleItemRenderer()));
    }
}
