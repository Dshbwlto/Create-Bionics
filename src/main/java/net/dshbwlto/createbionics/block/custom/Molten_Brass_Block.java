package net.dshbwlto.createbionics.block.custom;

import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class Molten_Brass_Block extends LiquidBlock {
    public Molten_Brass_Block(FlowingFluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        level.setBlock(pos, (BlockState) BionicsBlocks.SCRAP_BRASS.get().defaultBlockState(), 11);
        super.onPlace(state, level, pos, oldState, isMoving);
    }
}
