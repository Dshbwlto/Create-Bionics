package net.dshbwlto.createbionics.block.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.decoration.steamWhistle.WhistleBlock;
import com.simibubi.create.content.decoration.steamWhistle.WhistleBlockEntity;
import com.simibubi.create.content.decoration.steamWhistle.WhistleExtenderBlock;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import net.createmod.catnip.lang.Lang;
import net.dshbwlto.createbionics.block.BionicsBlockEntityTypes;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class DepthBellBlock extends Block implements IBE<DepthBellBlockEntity>, IWrenchable {

    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public static final IntegerProperty SIZE = IntegerProperty.create("size", 1, 5);

    public DepthBellBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(POWERED, false)
                .setValue(SIZE, 1)
        );
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int size = state.getValue(DepthBellBlock.SIZE);
        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(AllItems.WRENCH)) {
            if (!player.isShiftKeyDown()) {
                if (size < SIZE.getPossibleValues().size()) {
                    level.setBlock(pos, state.setValue(SIZE, size + 1), 2);
                } else {
                    level.setBlock(pos, state.setValue(SIZE, 1), 2);
                }
            }
        }
        return super.useWithoutItem(state, level, pos, player, hitResult);
    }
/*
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int size = state.getValue(DepthBellBlock.SIZE);
        if (stack.is(AllItems.WRENCH)) {
            if (!player.isShiftKeyDown()) {
                if (size < SIZE.getPossibleValues().size()) {
                    level.setBlock(pos, state.setValue(SIZE, size + 1), 2);
                } else {
                    level.setBlock(pos, state.setValue(SIZE, 1), 2);
                }
            }
        }

        if (BionicsBlocks.DEPTH_BELL_BLOCK.isIn(stack)) {
            incrementSize(level, pos);
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public static void incrementSize(LevelAccessor pLevel, BlockPos pPos) {
        BlockState base = pLevel.getBlockState(pPos);
        if (!base.hasProperty(SIZE))
            return;
        int size = base.getValue(SIZE);
        SoundType soundtype = base.getSoundType();
        BlockPos currentPos = pPos.above();

        for (int i = 1; i <= 3; i++) {
            BlockState blockState = pLevel.getBlockState(currentPos);
            float pVolume = (soundtype.getVolume() + 1.0F) / 2.0F;
            SoundEvent growSound = SoundEvents.NOTE_BLOCK_XYLOPHONE.value();
            SoundEvent hitSound = soundtype.getHitSound();

            if (BionicsBlocks.DEPTH_BELL_EXTENSION.has(blockState)) {
                if (blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.QUADRUPLE_CONNECTED) {
                    currentPos = currentPos.above();
                }
                if (blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.SINGLE) {
                    pLevel.setBlock(currentPos,
                            blockState.setValue(DepthBellExtenderBlock.SHAPE, DepthBellExtenderBlock.BellExtenderShape.DOUBLE), 3);
                    if (soundtype != null) {
                        float pPitch = (float) Math.pow(2, -(i * 2) / 12.0);
                        pLevel.playSound(null, currentPos, growSound, SoundSource.BLOCKS, pVolume / 4f, pPitch);
                        pLevel.playSound(null, currentPos, hitSound, SoundSource.BLOCKS, pVolume, pPitch);
                    }
                    return;
                } else if (blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.DOUBLE) {
                    pLevel.setBlock(currentPos,
                            blockState.setValue(DepthBellExtenderBlock.SHAPE, DepthBellExtenderBlock.BellExtenderShape.TRIPLE), 3);
                    if (soundtype != null) {
                        float pPitch = (float) Math.pow(2, -(i * 2) / 12.0);
                        pLevel.playSound(null, currentPos, growSound, SoundSource.BLOCKS, pVolume / 4f, pPitch);
                        pLevel.playSound(null, currentPos, hitSound, SoundSource.BLOCKS, pVolume, pPitch);
                    }
                    return;
                } else if (blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.TRIPLE) {
                    pLevel.setBlock(currentPos,
                            blockState.setValue(DepthBellExtenderBlock.SHAPE, DepthBellExtenderBlock.BellExtenderShape.QUADRUPLE), 3);
                    if (soundtype != null) {
                        float pPitch = (float) Math.pow(2, -(i * 2) / 12.0);
                        pLevel.playSound(null, currentPos, growSound, SoundSource.BLOCKS, pVolume / 4f, pPitch);
                        pLevel.playSound(null, currentPos, hitSound, SoundSource.BLOCKS, pVolume, pPitch);
                    }
                    return;
                } else if (blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.QUADRUPLE && currentPos.getY() - pPos.getY() != 3) {
                    pLevel.setBlock(currentPos,
                            blockState.setValue(DepthBellExtenderBlock.SHAPE, DepthBellExtenderBlock.BellExtenderShape.QUADRUPLE_CONNECTED), 3);
                    currentPos = currentPos.above();
                }
                continue;
            }

            if (!blockState.canBeReplaced())
                return;

            pLevel.setBlock(currentPos, BionicsBlocks.DEPTH_BELL_EXTENSION.getDefaultState()
                    .setValue(SIZE, size), 3);
            if (soundtype != null) {
                float pPitch = (float) Math.pow(2, -(i * 2 - 1) / 12.0);
                pLevel.playSound(null, currentPos, growSound, SoundSource.BLOCKS, pVolume / 4f, pPitch);
                pLevel.playSound(null, currentPos, hitSound, SoundSource.BLOCKS, pVolume, pPitch);
            }
            return;
        }
    }
*/
    public static void queuePitchUpdate(LevelAccessor level, BlockPos pos) {
        BlockState blockState = level.getBlockState(pos);
        if (blockState.getBlock()instanceof DepthBellBlock bell && !level.getBlockTicks()
                .hasScheduledTick(pos, bell))
            level.scheduleTick(pos, bell, 1);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        //withBlockEntityDo(pLevel, pPos, DepthBellBlockEntity::updatePitch);
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        return IWrenchable.super.onWrenched(state, context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
        builder.add(SIZE);
    }

    @Override
    public Class<DepthBellBlockEntity> getBlockEntityClass() {
        return DepthBellBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends DepthBellBlockEntity> getBlockEntityType() {
        //return BionicsBlockEntityTypes.DEPTH_BELL.get();
        return null;
    }
}
