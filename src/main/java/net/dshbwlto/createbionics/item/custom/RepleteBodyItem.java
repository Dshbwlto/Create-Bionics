
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.client.RobotVariant;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.dshbwlto.createbionics.item.api.RobotSpawnerItem;
import net.dshbwlto.createbionics.item.client.OrganHeadItemRenderer;
import net.dshbwlto.createbionics.item.client.RepleteBodyItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RepleteBodyItem extends RobotSpawnerItem {

    public EntityType<MultiPartRobot<?>> type;

    public RepleteBodyItem(EntityType<MultiPartRobot<?>> defaultType, Properties properties) {
        super(defaultType, properties);
        this.type = defaultType;
    }

    @Override
    public void spawnEntity(Level level, BlockPos blockPos, InteractionHand hand, Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);

        RepleteEntity repleteEntity = new RepleteEntity(type, level);
        repleteEntity.setPos(blockPos.getCenter().add(0, -0.5f, 0));
        repleteEntity.setVariant(RobotVariant.COPPER);
        level.addFreshEntity(repleteEntity);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new RepleteBodyItemRenderer()));
    }
}
