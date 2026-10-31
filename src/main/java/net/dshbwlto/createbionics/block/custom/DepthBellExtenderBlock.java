package net.dshbwlto.createbionics.block.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.createmod.catnip.lang.Lang;
import net.dshbwlto.createbionics.Util.BionicsShapes;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DepthBellExtenderBlock extends Block implements IWrenchable {

    public static final EnumProperty<DepthBellExtenderBlock.BellExtenderShape> SHAPE =
            EnumProperty.create("shape", DepthBellExtenderBlock.BellExtenderShape.class);
    public static final IntegerProperty SIZE = DepthBellBlock.SIZE;

    public static enum BellExtenderShape implements StringRepresentable {
        SINGLE, DOUBLE, TRIPLE, QUADRUPLE, QUADRUPLE_CONNECTED;

        @Override
        public String getSerializedName() {
            return Lang.asId(name());
        }
    }

    public DepthBellExtenderBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(SHAPE, BellExtenderShape.SINGLE)
                .setValue(SIZE, 1));
    }


    @Override
    public InteractionResult onSneakWrenched(BlockState state, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (context.getClickLocation().y < context.getClickedPos()
                .getY() + .5f || state.getValue(SHAPE) == BellExtenderShape.SINGLE)
            return IWrenchable.super.onSneakWrenched(state, context);
        if (!(world instanceof ServerLevel))
            return InteractionResult.SUCCESS;
        world.setBlock(pos, state.setValue(SHAPE, BellExtenderShape.SINGLE), Block.UPDATE_ALL);
        IWrenchable.playRemoveSound(world, pos);
        return InteractionResult.SUCCESS;
    }

    protected UseOnContext relocateContext(UseOnContext context, BlockPos target) {
        return new UseOnContext(context.getPlayer(), context.getHand(),
                new BlockHitResult(context.getClickLocation(), context.getClickedFace(), target, context.isInside()));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player == null || !BionicsBlocks.DEPTH_BELL_BLOCK.isIn(stack))
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        BlockPos findRoot = findRoot(level, pos);
        BlockState blockState = level.getBlockState(findRoot);
        if (blockState.getBlock()instanceof DepthBellBlock bell)
            return bell.useItemOn(stack, blockState, level, findRoot, player, hand,
                    new BlockHitResult(hitResult.getLocation(), hitResult.getDirection(), findRoot, hitResult.isInside()));
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        Level level = context.getLevel();
        BlockPos findRoot = findRoot(level, context.getClickedPos());
        BlockState blockState = level.getBlockState(findRoot);
        if (blockState.getBlock()instanceof DepthBellBlock bell)
            return bell.onWrenched(blockState, relocateContext(context, findRoot));
        return IWrenchable.super.onWrenched(state, context);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader level, BlockPos pos, Player player) {
        return BionicsBlocks.DEPTH_BELL_BLOCK.asStack();
    }

    public static BlockPos findRoot(LevelAccessor pLevel, BlockPos pPos) {
        BlockPos currentPos = pPos.below();
        while (true) {
            BlockState blockState = pLevel.getBlockState(currentPos);
            if (BionicsBlocks.DEPTH_BELL_BLOCK.has(blockState)) {
                currentPos = currentPos.below();
                continue;
            }
            return currentPos;
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState below = pLevel.getBlockState(pPos.below());
        return below.is(this) && below.getValue(SHAPE) == BellExtenderShape.QUADRUPLE_CONNECTED
                || BionicsBlocks.DEPTH_BELL_BLOCK.has(below);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel,
                                  BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pFacing.getAxis() != Direction.Axis.Y)
            return pState;

        if (pFacing == Direction.UP) {
            boolean connected = pState.getValue(SHAPE) == BellExtenderShape.QUADRUPLE_CONNECTED;
            boolean shouldConnect = pLevel.getBlockState(pCurrentPos.above())
                    .is(this);
            if (!connected && shouldConnect)
                return pState.setValue(SHAPE, BellExtenderShape.QUADRUPLE_CONNECTED);
            if (connected && !shouldConnect)
                return pState.setValue(SHAPE, BellExtenderShape.QUADRUPLE);
            return pState;
        }

        return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState()
                : pState.setValue(SIZE, pLevel.getBlockState(pCurrentPos.below())
                .getValue(SIZE));
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {

    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder.add(SHAPE, SIZE));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        int size = pState.getValue(SIZE);
        switch (pState.getValue(SHAPE)) {
            case QUADRUPLE_CONNECTED:
                return size == 5 ? BionicsShapes.DEPTH_BELL_EXTENDER_5_QUADRUPLE_CONNECTED
                        : size == 4 ? BionicsShapes.DEPTH_BELL_EXTENDER_4_QUADRUPLE_CONNECTED
                        : size == 3 ? BionicsShapes.DEPTH_BELL_EXTENDER_3_QUADRUPLE_CONNECTED
                        : size == 2 ? BionicsShapes.DEPTH_BELL_EXTENDER_2_QUADRUPLE_CONNECTED
                        : BionicsShapes.DEPTH_BELL_EXTENDER_1_QUADRUPLE_CONNECTED;
            case QUADRUPLE:
                return size == 5 ? BionicsShapes.DEPTH_BELL_EXTENDER_5_QUADRUPLE
                        : size == 4 ? BionicsShapes.DEPTH_BELL_EXTENDER_4_QUADRUPLE
                        : size == 3 ? BionicsShapes.DEPTH_BELL_EXTENDER_3_QUADRUPLE
                        : size == 2 ? BionicsShapes.DEPTH_BELL_EXTENDER_2_QUADRUPLE
                        : BionicsShapes.DEPTH_BELL_EXTENDER_1_QUADRUPLE;
            case TRIPLE:
                return size == 5 ? BionicsShapes.DEPTH_BELL_EXTENDER_5_TRIPLE
                        : size == 4 ? BionicsShapes.DEPTH_BELL_EXTENDER_4_TRIPLE
                        : size == 3 ? BionicsShapes.DEPTH_BELL_EXTENDER_3_TRIPLE
                        : size == 2 ? BionicsShapes.DEPTH_BELL_EXTENDER_2_TRIPLE
                        : BionicsShapes.DEPTH_BELL_EXTENDER_1_TRIPLE;
            case DOUBLE:
                return size == 5 ? BionicsShapes.DEPTH_BELL_EXTENDER_5_DOUBLE
                        : size == 4 ? BionicsShapes.DEPTH_BELL_EXTENDER_4_DOUBLE
                        : size == 3 ? BionicsShapes.DEPTH_BELL_EXTENDER_3_DOUBLE
                        : size == 2 ? BionicsShapes.DEPTH_BELL_EXTENDER_2_DOUBLE
                        : BionicsShapes.DEPTH_BELL_EXTENDER_1_DOUBLE;
            case SINGLE:
            default:
                return size == 5 ? BionicsShapes.DEPTH_BELL_EXTENDER_5_SINGLE
                        : size == 4 ? BionicsShapes.DEPTH_BELL_EXTENDER_4_SINGLE
                        : size == 3 ? BionicsShapes.DEPTH_BELL_EXTENDER_3_SINGLE
                        : size == 2 ? BionicsShapes.DEPTH_BELL_EXTENDER_2_SINGLE
                        : BionicsShapes.DEPTH_BELL_EXTENDER_1_SINGLE;
        }
    }
}
