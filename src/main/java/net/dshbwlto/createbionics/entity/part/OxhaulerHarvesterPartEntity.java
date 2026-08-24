package net.dshbwlto.createbionics.entity.part;

import com.simibubi.create.AllBlocks;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OxhaulerHarvesterPartEntity extends RobotPartEntity{
    /**
     * Creates a new part for an entity to use, does not need to be registered as an entity type
     *
     * @param parent     the MultiPartMob that this part belongs to
     * @param width      the width of this part
     * @param height     the height of this part
     * @param xOffset    the offset from parent along x-axis
     * @param yOffset    the offset from parent along y-axis
     * @param zOffset    the offset from parent along z-axis
     * @param pickResult
     * @apiNote Where ever offset is used it assumes that the mob is facing the default direction when spawned. Mob rotating is handled by api.
     */
    public OxhaulerHarvesterPartEntity(@NotNull MultiPartRobot parent, Entity connectedTo, float width, float height, double xOffset, double yOffset, double zOffset, Item pickResult, boolean collision) {
        super(parent, connectedTo, width, height, xOffset, yOffset, zOffset, pickResult, collision);
    }

    @Override
    public @Nullable ItemStack getPickResult() {
        OxhaulerEntity entity = (OxhaulerEntity) getParent();
        return entity.isHarvester() ? AllBlocks.MECHANICAL_HARVESTER.asStack() : BionicsItems.OXHAULER_MIDDLE.asStack();
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        OxhaulerEntity oxhauler = (OxhaulerEntity) getParent();
        if (oxhauler.isHarvester()) {
            return oxhauler.interact(player, hand);
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void offsetFromParent() {
        super.offsetFromParent();
        OxhaulerEntity oxhauler = (OxhaulerEntity) getParent();
        if (oxhauler.isHarvester()) {
            boolean flag = false;
            AABB aabb = this.getBoundingBox().inflate(0.2);
            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                Block block = blockstate.getBlock();
                if (block instanceof CropBlock && ((CropBlock) block).isMaxAge(blockstate)) {
                    flag = this.level().destroyBlock(blockpos, true, this) || flag;
                    flag = this.level().setBlock(blockpos, block.defaultBlockState(), 1) || flag;
                }
            }
        }
    }
}
