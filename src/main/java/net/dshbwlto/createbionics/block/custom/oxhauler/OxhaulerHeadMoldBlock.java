package net.dshbwlto.createbionics.block.custom.oxhauler;

import net.dshbwlto.createbionics.Util.BionicsTags;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class OxhaulerHeadMoldBlock extends Block {
    public static final BooleanProperty HEAD_FILLED = BooleanProperty.create("head_filled");

    public OxhaulerHeadMoldBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HEAD_FILLED, false));
    }
    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return super.propagatesSkylightDown(state, level, pos);
    }
    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if ((!itemStack.is(BionicsTags.Items.MOLD_ITEMS))) {
            return super.useItemOn(itemStack, blockState, level, pos, player, hand, hitResult);
        } else if (level.isClientSide) {
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            if (itemStack.is(BionicsItems.MOLTEN_ANDESITE_ALLOY_CRUCIBLE.get()) && !blockState.getValue(HEAD_FILLED)) {
                level.playSound((Player) null, pos, SoundEvents.BUCKET_FILL_LAVA, SoundSource.BLOCKS, 1.0F, 0.8F);
                boolean currentState = blockState.getValue(HEAD_FILLED);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);

                }
                level.setBlock(pos, blockState.setValue(HEAD_FILLED, !currentState), 11);
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
            if (itemStack.is(Items.BRUSH) && blockState.getValue(HEAD_FILLED)) {
                level.playSound((Player) null, pos, SoundEvents.SOUL_SAND_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F);
                level.setBlock(pos, (BlockState) BionicsBlocks.OXHAULER_HEAD.get().defaultBlockState(), 11);
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
            if (!itemStack.is(BionicsItems.MOLTEN_ANDESITE_ALLOY_CRUCIBLE.get()) && !blockState.getValue(HEAD_FILLED)) {
                player.sendSystemMessage(Component.literal("This part requires molten andesite alloy"));
            }
        }


        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HEAD_FILLED);
    }
}




