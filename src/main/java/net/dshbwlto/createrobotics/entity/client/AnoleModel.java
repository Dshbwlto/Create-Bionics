package net.dshbwlto.createrobotics.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createrobotics.entity.custom.AnoleEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class AnoleModel<T extends AnoleEntity> extends HierarchicalModel<T> {
    private final ModelPart anole;
    private final ModelPart head_main;

    public AnoleModel(ModelPart root) {
        this.anole = root.getChild("anole");
        this.head_main = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition anole = partdefinition.addOrReplaceChild("anole", CubeListBuilder.create(), PartPose.offset(0.0F, 21.7382F, -0.3918F));

        PartDefinition lower_body = anole.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(10, 22).addBox(-1.0F, -0.9882F, -0.1082F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = lower_body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.1555F, 0.1536F, -0.7734F));

        PartDefinition cube_r2 = lower_body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.1555F, 0.1536F, -0.7734F));

        PartDefinition exhaust = lower_body.addOrReplaceChild("exhaust", CubeListBuilder.create(), PartPose.offset(1.1F, 0.0118F, -0.6082F));

        PartDefinition cube_r3 = exhaust.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 10).mirror().addBox(0.0F, 0.0F, -0.501F, 1.0F, 1.0F, 5.002F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.3053F, -0.2591F, 0.4971F));

        PartDefinition cube_r4 = exhaust.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 10).addBox(-1.0F, 0.0F, -0.501F, 1.0F, 1.0F, 5.002F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.0F, 0.3053F, 0.2591F, -0.4971F));

        PartDefinition legl = lower_body.addOrReplaceChild("legl", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.5118F, 2.1418F));

        PartDefinition legl2 = legl.addOrReplaceChild("legl2", CubeListBuilder.create().texOffs(26, 26).addBox(-1.25F, -0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, 0.25F, 0.25F));

        PartDefinition legr = lower_body.addOrReplaceChild("legr", CubeListBuilder.create().texOffs(6, 30).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.5118F, 2.1418F));

        PartDefinition legr2 = legr.addOrReplaceChild("legr2", CubeListBuilder.create().texOffs(0, 27).addBox(-1.75F, -0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, 0.25F, 0.25F));

        PartDefinition tail1 = lower_body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0118F, 2.8918F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(24, 14).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 5.0F));

        PartDefinition bone = tail1.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 16).addBox(-0.25F, -0.25F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.35F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition upper_body = lower_body.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0118F, -0.1082F));

        PartDefinition cube_r6 = upper_body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 18).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2618F, -2.8918F, 0.3185F, 0.3035F, -0.7363F));

        PartDefinition cube_r7 = upper_body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5118F, -1.8918F, 0.1555F, 0.1536F, -0.7734F));

        PartDefinition cube_r8 = upper_body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(26, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r9 = upper_body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 10).addBox(0.0F, 0.0F, -1.001F, 1.0F, 1.0F, 3.002F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, -2.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r10 = upper_body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(20, 22).addBox(-1.0F, 0.0F, -1.001F, 1.0F, 1.0F, 3.002F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition neck = upper_body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(20, 26).addBox(-0.5F, -0.75F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -2.5F));

        PartDefinition head_main = neck.addOrReplaceChild("head_main", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, -1.5F));

        PartDefinition jaw = head_main.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(16, 6).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));

        PartDefinition chest = upper_body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -2.0F));

        PartDefinition arml = upper_body.addOrReplaceChild("arml", CubeListBuilder.create().texOffs(28, 3).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.5F, -2.0F));

        PartDefinition arml2 = arml.addOrReplaceChild("arml2", CubeListBuilder.create().texOffs(28, 22).addBox(-0.25F, -0.5F, -0.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.25F, 0.0F));

        PartDefinition armr = upper_body.addOrReplaceChild("armr", CubeListBuilder.create().texOffs(26, 28).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.5F, -2.0F));

        PartDefinition armr2 = armr.addOrReplaceChild("armr2", CubeListBuilder.create().texOffs(28, 24).addBox(-1.75F, -0.5F, -0.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.25F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(AnoleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(AnoleAnimations.anole_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, AnoleAnimations.anole_idle, ageInTicks, 1f);

        this.animate(entity.sitDownAnimationState, AnoleAnimations.anole_sit, ageInTicks, 1.0F);
        this.animate(entity.sitPoseAnimationState, AnoleAnimations.anole_stay, ageInTicks, 1.0F);
        this.animate(entity.sitUpAnimationState, AnoleAnimations.anole_stand, ageInTicks, 1.0F);

    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head_main.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head_main.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        anole.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return anole;
    }
}