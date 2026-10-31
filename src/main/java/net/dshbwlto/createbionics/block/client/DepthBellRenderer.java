package net.dshbwlto.createbionics.block.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.dshbwlto.createbionics.Util.BionicsPartialModels;
import net.dshbwlto.createbionics.block.custom.DepthBellBlock;
import net.dshbwlto.createbionics.block.custom.DepthBellBlockEntity;
import net.dshbwlto.createbionics.block.custom.DepthBellExtenderBlock;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.DecoratedPotBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Quaternionf;

public class DepthBellRenderer extends SafeBlockEntityRenderer<DepthBellBlockEntity> {

    public DepthBellRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    protected void renderSafe(DepthBellBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource bufferSource,
                              int light, int overlay) {
        BlockState blockState = be.getBlockState();
        if (!(blockState.getBlock() instanceof DepthBellBlock)) {
            return;
        }
        int bellSize = blockState.getValue(DepthBellBlock.SIZE);
        PartialModel cap = BionicsPartialModels.depthBellCap(bellSize);

        if (!(be.blockAbove().getBlock() instanceof DepthBellExtenderBlock)) {
            CachedBuffers.partial(cap, blockState)
                    .translate(0, 1, 0)
                    .light(light + 1)
                    .renderInto(ms, bufferSource.getBuffer(RenderType.CUTOUT));
        }
    }
}
