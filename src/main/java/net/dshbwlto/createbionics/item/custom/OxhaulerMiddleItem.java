
package net.dshbwlto.createbionics.item.custom;

import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.item.api.RobotSpawnerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OxhaulerMiddleItem extends RobotSpawnerItem {

    public EntityType<MultiPartRobot<?>> type;

    public OxhaulerMiddleItem(EntityType<MultiPartRobot<?>> defaultType, Properties properties) {
        super(defaultType, properties);
        this.type = defaultType;
    }

    @Override
    public void spawnEntity(Level level, BlockPos blockPos, InteractionHand hand, Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);

        OxhaulerEntity oxhaulerEntity = new OxhaulerEntity(type, level);
        oxhaulerEntity.setPos(blockPos.getCenter().add(0, -0.5f, 0));
        oxhaulerEntity.showRear = true;
        oxhaulerEntity.showFront = true;
        oxhaulerEntity.showHead = true;
        level.addFreshEntity(oxhaulerEntity);
    }
}
