package net.dshbwlto.createbionics.block.custom.oxhauler;

import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class OxhaulerHeadWaxBlock extends Block {
    public OxhaulerHeadWaxBlock(Properties properties) {
        super(properties);
    }

    protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!itemStack.is(Items.SAND)) {
            return super.useItemOn(itemStack, blockState, level, pos, player, hand, hitResult);
        } else if (level.isClientSide) {
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } else {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            level.playSound((Player)null, pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F);
            level.setBlock(pos, (BlockState) BionicsBlocks.OXHAULER_HEAD_MOLD.get().defaultBlockState(), 11);
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }
    }
    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return super.propagatesSkylightDown(state, level, pos);
    }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.shift"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.wax_cast.tooltip.1"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.space"));
            tooltipComponents.add(Component.translatable("tooltip.createbionics.wax_cast.tooltip.andesite"));

        } else {
            tooltipComponents.add(Component.translatable("tooltip.createbionics.basic.tooltip.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
