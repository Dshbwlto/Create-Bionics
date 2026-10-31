package net.dshbwlto.createbionics.block.custom;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.content.decoration.steamWhistle.WhistleExtenderBlock;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.utility.CreateLang;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class DepthBellBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    protected int pitch;

    public DepthBellBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {

    }

    public BlockState blockAbove() {
        return level.getBlockState(getBlockPos().above());
    }

    public void updatePitch() {
        BlockPos currentPos = worldPosition.above();
        int newPitch;
        for (newPitch = 0; newPitch <= 24; newPitch += 4) {
            BlockState blockState = level.getBlockState(currentPos);
            if (!BionicsBlocks.DEPTH_BELL_EXTENSION.has(blockState))
                break;
            if (blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.SINGLE ||
                    blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.DOUBLE ||
                    blockState.getValue(DepthBellExtenderBlock.SHAPE) == DepthBellExtenderBlock.BellExtenderShape.TRIPLE) {
                newPitch++;
                break;
            }
            currentPos = currentPos.above();
        }
        if (pitch == newPitch)
            return;
        pitch = newPitch;

        notifyUpdate();
    }


    @Override
    protected void write(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        tag.putInt("Pitch", pitch);
        super.write(tag, registries, clientPacket);
    }

    @Override
    protected void read(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        pitch = tag.getInt("Pitch");
        super.read(tag, registries, clientPacket);
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        String[] pitches = CreateLang.translateDirect("generic.notes")
                .getString()
                .split(";");
        CreateLang.translate("generic.pitch", pitches[pitch % pitches.length]).forGoggles(tooltip);
        return true;
    }
}
