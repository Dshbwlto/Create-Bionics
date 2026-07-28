package net.dshbwlto.createbionics.entity.part;

import com.simibubi.create.AllBlocks;
import net.dshbwlto.createbionics.entity.api.MultiPartRobot;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GroundLevelSamplerPartEntity extends RobotPartEntity{
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
    public GroundLevelSamplerPartEntity(@NotNull MultiPartRobot parent, float width, float height, double xOffset, double yOffset, double zOffset, Item pickResult) {
        super(parent, width, height, xOffset, yOffset, zOffset, pickResult, false);
    }

    public boolean isColliding() {
        return !(this.getBlockStateOn().getBlock() instanceof AirBlock);
    }
}
