package net.dshbwlto.createbionics.entity.client.seeker;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.custom.SeekerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SeekerModel<T extends SeekerEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart head;

    public SeekerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("body").getChild("body_front").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, -9.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -4.0F, -5.0F, 7.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.0F, 9.0F));

        PartDefinition body_front = body.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(32, 9).addBox(-2.0F, -1.5F, -3.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, -6.0F));

        PartDefinition bolt_front = body_front.addOrReplaceChild("bolt_front", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, -1.0F));

        PartDefinition head = body_front.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, -3.0F));

        PartDefinition head_spin = head.addOrReplaceChild("head_spin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

        PartDefinition cube_r1 = head_spin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 32).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 4).addBox(1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bone = head_spin.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(20, 32).addBox(-3.0F, -1.0F, -3.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(33, 22).addBox(-4.0F, -0.5F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 22).mirror().addBox(-4.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(32, 1).addBox(0.0F, -1.0F, -3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 22).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 1).mirror().addBox(-4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition arm_l = body_front.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, -0.3054F, 0.2182F));

        PartDefinition arm_l2 = arm_l.addOrReplaceChild("arm_l2", CubeListBuilder.create().texOffs(32, 5).mirror().addBox(0.0F, -0.5F, -2.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 32).mirror().addBox(0.0F, -1.0F, -1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 6).addBox(5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.025F, 0.0F, 0.0F, 1.0472F, 0.0F));

        PartDefinition arm_r = body_front.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.3054F, -0.2182F));

        PartDefinition arm_r2 = arm_r.addOrReplaceChild("arm_r2", CubeListBuilder.create().texOffs(32, 5).addBox(-6.0F, -0.5F, -2.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-5.0F, -1.0F, -1.0F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).mirror().addBox(-6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -0.025F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition body_rear = body.addOrReplaceChild("body_rear", CubeListBuilder.create().texOffs(32, 9).addBox(-2.5F, -1.5F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -2.0F, 6.0F));

        PartDefinition tail = body_rear.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition handle = tail.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(24, 28).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 8.0F));

        PartDefinition leg_l = body_rear.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 0.0F, 1.0F, 0.0F, 0.3054F, 0.2182F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(24, 18).mirror().addBox(0.0F, -0.5F, -2.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 32).mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 6).addBox(4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition leg_r = body_rear.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, 1.0F, 0.0F, -0.3054F, -0.2182F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(24, 18).addBox(-5.0F, -0.5F, -2.0F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).mirror().addBox(-5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

        PartDefinition bolt_rear = body_rear.addOrReplaceChild("bolt_rear", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(SeekerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(SeekerAnimations.seeker_walk, limbSwing, limbSwingAmount, 2f, 2.5f);

        if (entity.isPassenger()) {
            this.animate(entity.idleAnimationState, SeekerAnimations.seeker_sit_up, ageInTicks, 1f);
        }

        this.animate(entity.sitDownAnimationState, SeekerAnimations.seeker_sit, ageInTicks, 1.0F);
        if (!entity.isPassenger()) {
            this.animate(entity.sitPoseAnimationState, SeekerAnimations.seeker_stay, ageInTicks, 1.0F);
        }
        this.animate(entity.sitUpAnimationState, SeekerAnimations.seeker_stand, ageInTicks, 1.0F);

    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}