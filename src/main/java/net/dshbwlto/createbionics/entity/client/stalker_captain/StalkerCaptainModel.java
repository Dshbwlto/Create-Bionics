package net.dshbwlto.createbionics.entity.client.stalker_captain;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerAnimations;
import net.dshbwlto.createbionics.entity.custom.StalkerCaptainEntity;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class StalkerCaptainModel<T extends StalkerCaptainEntity> extends HierarchicalModel <T> {
    private final ModelPart root;
    private final ModelPart stand;
    private final ModelPart neck;
    private final ModelPart head;


    public StalkerCaptainModel(ModelPart root) {
        this.root = root.getChild("root");
        this.stand = this.root.getChild("root_util").getChild("stand");
        this.head = this.root.getChild("root_util").getChild("upper_body").getChild("neck").getChild("head");
        this.neck = this.root.getChild("root_util").getChild("upper_body").getChild("neck");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create().texOffs(27, 9).addBox(-3.0F, 0.25F, 0.0F, 6.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(48, 50).addBox(-3.5F, 2.25F, 8.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(48, 50).mirror().addBox(2.5F, 2.25F, 8.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 58).addBox(-4.0F, -0.25F, -0.5F, 8.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 2.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition exhaust = body.addOrReplaceChild("exhaust", CubeListBuilder.create().texOffs(37, 59).addBox(2.001F, 0.0F, 0.0F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(37, 59).addBox(-3.001F, 0.0F, 0.0F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.75F, 4.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(58, 64).addBox(-2.5F, -2.0F, 0.3F, 5.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-1.5F, 0.0021F, -0.7105F, 3.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 13.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(-1.002F, -1.926F, 12.6278F));

        PartDefinition cube_r1 = tail2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 76).addBox(-0.998F, 1.0F, -1.0F, 4.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = tail2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, 2.0F, -1.3F, 3.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(57, 63).addBox(-1.5F, 0.0F, -0.3F, 5.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.002F, -0.0366F, 0.184F, 0.3927F, 0.0F, 0.0F));

        PartDefinition leg_l = body.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(27, 30).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 43).addBox(2.0F, -1.5F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(52, 44).addBox(1.5F, 6.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 4.25F, 10.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(2, 45).addBox(-1.0F, 1.5F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(40, 46).addBox(-0.5F, 9.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(48, 44).addBox(-0.5F, 4.5F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, 0.0F, 1.3526F, 0.0F, 0.0F));

        PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(27, 30).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 43).addBox(-4.0F, -1.5F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(52, 44).addBox(-4.5F, 6.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.25F, 10.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(2, 45).addBox(-1.0F, 1.5F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(40, 46).addBox(-0.5F, 9.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(48, 44).addBox(-0.5F, 4.5F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 8.0F, 0.0F, 1.3526F, 0.0F, 0.0F));

        PartDefinition antenna_l2 = body.addOrReplaceChild("antenna_l2", CubeListBuilder.create().texOffs(10, 63).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.5F, 1.5F, -0.7418F, 0.1309F, 0.2182F));

        PartDefinition cube_r3 = antenna_l2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(10, 58).addBox(-0.5F, -13.0F, 0.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition antenna_r2 = body.addOrReplaceChild("antenna_r2", CubeListBuilder.create().texOffs(10, 63).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -0.5F, 1.5F, -0.7418F, -0.1309F, -0.2182F));

        PartDefinition cube_r4 = antenna_r2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(10, 58).addBox(-0.5F, -13.0F, 0.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition upper_body = root_util.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -1.0F, -11.0F, 9.0F, 11.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(26, 44).mirror().addBox(4.0F, 0.5F, -9.5F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 44).addBox(-5.0F, 0.5F, -9.5F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(26, 31).addBox(-5.5F, -3.0F, -11.0F, 11.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 2.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r5 = upper_body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(52, 6).addBox(-3.5F, -1.0F, -5.0F, 8.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.9F, -10.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition select = upper_body.addOrReplaceChild("select", CubeListBuilder.create().texOffs(-6, 106).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.2F, -5.4F));

        PartDefinition icon = upper_body.addOrReplaceChild("icon", CubeListBuilder.create().texOffs(-16, 112).addBox(-8.0F, 0.0F, -7.9F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.2F, -5.5F));

        PartDefinition antenna_l = upper_body.addOrReplaceChild("antenna_l", CubeListBuilder.create().texOffs(10, 63).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.5F, -9.5F, -0.7418F, 0.1309F, 0.2182F));

        PartDefinition cube_r6 = antenna_l.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(10, 58).addBox(-0.5F, -13.0F, 0.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition antenna_r = upper_body.addOrReplaceChild("antenna_r", CubeListBuilder.create().texOffs(10, 63).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.5F, -9.5F, -0.7418F, -0.1309F, -0.2182F));

        PartDefinition cube_r7 = antenna_r.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(10, 58).addBox(-0.5F, -13.0F, 0.0F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition arm_l = upper_body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(0, 43).addBox(1.5F, -2.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(52, 44).addBox(1.0F, 6.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(27, 30).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 3.5F, -6.5F, 0.0436F, 0.0F, -0.3054F));

        PartDefinition arm_l2 = arm_l.addOrReplaceChild("arm_l2", CubeListBuilder.create().texOffs(3, 25).addBox(-1.0F, 1.5F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(79, 29).addBox(0.5F, 2.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, -5).addBox(2.0F, 1.5F, -2.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(40, 46).addBox(-0.5F, 9.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(48, 44).addBox(-0.5F, 4.5F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 7.5F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition arm_r = upper_body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(0, 43).addBox(-3.5F, -2.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(52, 44).addBox(-4.0F, 6.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(27, 30).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 3.5F, -6.5F, 0.0436F, 0.0F, 0.3054F));

        PartDefinition arm_r2 = arm_r.addOrReplaceChild("arm_r2", CubeListBuilder.create().texOffs(3, 25).addBox(-1.0F, 1.5F, -2.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(79, 29).addBox(-2.5F, 2.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, -5).mirror().addBox(-2.0F, 1.5F, -2.0F, 0.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(40, 46).addBox(-0.5F, 9.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(48, 44).addBox(-0.5F, 4.5F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 7.5F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition neck = upper_body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, 3.5F, -12.0F));

        PartDefinition cube_r8 = neck.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(59, 23).addBox(-1.5F, -5.0F, -10.5F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9487F, 1.6504F, 1.2654F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(73, 33).addBox(-2.5F, -1.5F, -6.5F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(73, 44).addBox(-2.0F, -3.5F, -10.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(78, 48).addBox(-2.0F, -7.5F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 48).addBox(-1.5F, -2.5F, -9.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -4.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(41, 1).mirror().addBox(0.0F, -1.099F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, -0.4F, -6.5F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r10 = head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(41, 1).addBox(-2.0F, -1.099F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -0.4F, -6.5F, 0.0F, 0.3927F, 0.0F));

        PartDefinition stand = root_util.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(0, 42).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -5.0F));

        PartDefinition cube_r11 = stand.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 58).addBox(-1.0F, -8.0F, 0.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(StalkerCaptainEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.applyHeadRotation(netHeadYaw, headPitch);
        if (entity.isInFluidType()) {
            this.animateWalk(StalkerCaptainAnimations.stalker_captain_swim, limbSwing, limbSwingAmount, 1f, 2f);
        } else if (entity.isAggressive()) {
            this.animateWalk(StalkerCaptainAnimations.stalker_captain_run, limbSwing, limbSwingAmount, 1f, 2f);
        } else {
            this.animateWalk(StalkerCaptainAnimations.stalker_captain_walk, limbSwing, limbSwingAmount, 2f, 2f);
        }
        this.animate(entity.idleAnimationState, StalkerCaptainAnimations.stalker_captain_idle, ageInTicks, 1f);
            this.animate(entity.sitDownAnimationState, StalkerCaptainAnimations.stalker_captain_sit, ageInTicks, 1.0F);
            this.animate(entity.sitPoseAnimationState, StalkerCaptainAnimations.stalker_captain_stay, ageInTicks, 1.0F);
            this.animate(entity.sitUpAnimationState, StalkerCaptainAnimations.stalker_captain_stand, ageInTicks, 1.0F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = (pNetHeadYaw * ((float)Math.PI / 180F)) / 2;
        this.neck.yRot = (pNetHeadYaw * ((float)Math.PI / 180F)) / 2;
        this.head.xRot = (pHeadPitch * ((float)Math.PI / 180F)) / 2;
        this.neck.xRot = (pHeadPitch * ((float)Math.PI / 180F)) / 2;
    }

    @Override
    public ModelPart root() {
        return root;
    }

}
