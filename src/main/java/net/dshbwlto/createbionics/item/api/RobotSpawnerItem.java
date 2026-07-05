package net.dshbwlto.createbionics.item.api;

import net.dshbwlto.createbionics.entity.BionicsEntities;
import net.dshbwlto.createbionics.entity.api.AbstractRobot;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RobotSpawnerItem extends Item {

    public EntityType<? extends AbstractRobot> type;

    public RobotSpawnerItem(EntityType<? extends AbstractRobot> defaultType, Properties properties) {
        super(properties);
        this.type = defaultType;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (!(level instanceof ServerLevel)) {
            return InteractionResult.SUCCESS;
        } else {
            ItemStack itemstack = context.getItemInHand();
            BlockPos blockpos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            BlockEntity var8 = level.getBlockEntity(blockpos);
            if (!(var8 instanceof Spawner)) {
                BlockPos blockpos1;
                if (blockstate.getCollisionShape(level, blockpos).isEmpty()) {
                    blockpos1 = blockpos;
                } else {
                    blockpos1 = blockpos.relative(direction);
                }
                spawnEntity(level, blockpos1, context.getHand(), context.getPlayer());
                itemstack.shrink(1);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.CONSUME;
    }

    public void spawnEntity(Level level, BlockPos blockpos, InteractionHand hand, Player player) {
    }
}
