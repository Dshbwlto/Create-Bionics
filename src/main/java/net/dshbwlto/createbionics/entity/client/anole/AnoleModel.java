package net.dshbwlto.createbionics.entity.client.anole;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class AnoleModel<T extends AnoleEntity> extends HierarchicalModel<T>
{
    private final ModelPart anole;
    private final ModelPart head_main;
    private final ModelPart hat1;
    private final ModelPart hat2;
    private final ModelPart hat3;
    private final ModelPart hat4;
    private final ModelPart hat5;
    private final ModelPart hat6;
    private final ModelPart hat7;
    private final ModelPart hat8;
    private final ModelPart hat9;

    public AnoleModel(ModelPart root) {
        this.anole = root.getChild("anole");
        this.head_main = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main");
        this.hat1 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat1");
        this.hat2 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat2");
        this.hat3 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat3");
        this.hat4 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat4");
        this.hat5 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat5");
        this.hat6 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat6");
        this.hat7 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat7");
        this.hat8 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat8");
        this.hat9 = this.anole.getChild("lower_body").getChild("upper_body").getChild("neck").getChild("head_main").getChild("hat9");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition anole = partdefinition.addOrReplaceChild("anole", CubeListBuilder.create(), PartPose.offset(0.0F, 21.7382F, -0.3918F));

        PartDefinition lower_body = anole.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(10, 22).addBox(-1.0F, -1.25F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2618F, 0.3918F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r1 = lower_body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7618F, -0.3918F, 0.1555F, 0.1536F, -0.7734F));

        PartDefinition cube_r2 = lower_body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7618F, -1.3918F, 0.1555F, 0.1536F, -0.7734F));

        PartDefinition exhaust = lower_body.addOrReplaceChild("exhaust", CubeListBuilder.create(), PartPose.offset(1.1F, -0.25F, -1.0F));

        PartDefinition cube_r3 = exhaust.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 10).mirror().addBox(0.0F, 0.0F, -0.501F, 1.0F, 1.0F, 5.002F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.3053F, -0.2591F, 0.4971F));

        PartDefinition cube_r4 = exhaust.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 10).addBox(-1.0F, 0.0F, -0.501F, 1.0F, 1.0F, 5.002F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.0F, 0.3053F, 0.2591F, -0.4971F));

        PartDefinition legl = lower_body.addOrReplaceChild("legl", CubeListBuilder.create().texOffs(0, 29).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.25F, 1.75F, 0.0F, 0.0F, 0.2182F));

        PartDefinition legl2 = legl.addOrReplaceChild("legl2", CubeListBuilder.create().texOffs(26, 26).addBox(-1.25F, -0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 0.25F, 0.25F, 0.0F, -1.309F, 0.0F));

        PartDefinition legr = lower_body.addOrReplaceChild("legr", CubeListBuilder.create().texOffs(6, 30).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.25F, 1.75F, 0.0F, 0.0F, -0.2182F));

        PartDefinition legr2 = legr.addOrReplaceChild("legr2", CubeListBuilder.create().texOffs(0, 27).addBox(-1.75F, -0.5F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 0.25F, 0.25F, 0.0F, 1.309F, 0.0F));

        PartDefinition tail1 = lower_body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 2.5F, -0.0436F, 0.0F, 0.0F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(24, 14).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition bone = tail1.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.0F));

        PartDefinition cube_r5 = bone.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 16).addBox(-0.25F, -0.25F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.35F, 0.0F, 0.1F, 0.0F, 0.0F, -0.7854F));

        PartDefinition upper_body = lower_body.addOrReplaceChild("upper_body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.25F, -0.5F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r6 = upper_body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 18).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2618F, -2.8918F, 0.3185F, 0.3035F, -0.7363F));

        PartDefinition cube_r7 = upper_body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5118F, -1.8918F, 0.1555F, 0.1536F, -0.7734F));

        PartDefinition cube_r8 = upper_body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(26, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r9 = upper_body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 10).addBox(0.0F, 0.0F, -1.001F, 1.0F, 1.0F, 3.002F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, -2.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition cube_r10 = upper_body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(20, 22).addBox(-1.0F, 0.0F, -1.001F, 1.0F, 1.0F, 3.002F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition neck = upper_body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(20, 26).addBox(-0.5F, -0.75F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -2.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition head_main = neck.addOrReplaceChild("head_main", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, -1.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition hat1 = head_main.addOrReplaceChild("hat1", CubeListBuilder.create().texOffs(36, 17).addBox(-2.0F, -0.25F, -2.85F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.75F, -0.75F));

        PartDefinition cube_r11 = hat1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(36, 9).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(38, 0).addBox(-0.5F, -4.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0436F));

        PartDefinition hat2 = head_main.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(38, 5).addBox(-1.0F, -0.6F, -0.9F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(47, 9).addBox(-0.5F, -1.1F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -0.5F, -0.1309F, 0.0F, 0.1309F));

        PartDefinition propeller = hat2.addOrReplaceChild("propeller", CubeListBuilder.create().texOffs(45, 5).addBox(-1.5F, 0.15F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.1F));

        PartDefinition hat3 = head_main.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(36, 13).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -0.25F));

        PartDefinition cube_r12 = hat3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(42, 13).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.5F, 0.2618F, 0.0F, 0.0F));

        PartDefinition hat4 = head_main.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(46, 15).addBox(-1.5F, -1.7F, -1.9F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -0.5F, -0.1571F, 0.0F, 0.0F));

        PartDefinition hat5 = head_main.addOrReplaceChild("hat5", CubeListBuilder.create().texOffs(52, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 29).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 21).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

        PartDefinition hat6 = head_main.addOrReplaceChild("hat6", CubeListBuilder.create().texOffs(37, 24).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(59, 24).addBox(-0.5F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition hat7 = head_main.addOrReplaceChild("hat7", CubeListBuilder.create().texOffs(53, 6).addBox(-1.0F, -0.75F, -1.4F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(75, 14).addBox(-0.5F, -4.0F, -0.9F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -1.0F, -0.3054F, 0.0262F, 0.1745F));

        PartDefinition cube_r13 = hat7.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(74, 5).addBox(-1.0F, -4.0F, -2.4F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition hat8 = head_main.addOrReplaceChild("hat8", CubeListBuilder.create().texOffs(61, 15).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.5F, -0.2182F, 0.0F, 0.0349F));

        PartDefinition cube_r14 = hat8.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(62, 13).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.0F, 0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r15 = hat8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(62, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 0.0F, 0.4363F, 0.0F, 0.0F));

        PartDefinition hat9 = head_main.addOrReplaceChild("hat9", CubeListBuilder.create().texOffs(72, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -0.5F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r16 = hat9.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(66, 28).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, 0.0F, 0.6109F, -0.3491F, 0.0F));

        PartDefinition cube_r17 = hat9.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(69, 21).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition jaw = head_main.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(16, 6).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));

        PartDefinition chest = upper_body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, -2.0F));

        PartDefinition arml = upper_body.addOrReplaceChild("arml", CubeListBuilder.create().texOffs(28, 3).addBox(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, -2.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition arml2 = arml.addOrReplaceChild("arml2", CubeListBuilder.create().texOffs(28, 22).addBox(-0.25F, -0.5F, -0.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.25F, 0.0F, 0.0F, 1.3526F, 0.0F));

        PartDefinition armr = upper_body.addOrReplaceChild("armr", CubeListBuilder.create().texOffs(26, 28).addBox(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.5F, -2.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition armr2 = armr.addOrReplaceChild("armr2", CubeListBuilder.create().texOffs(28, 24).addBox(-1.75F, -0.5F, -0.25F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.25F, 0.0F, 0.0F, -1.3526F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(AnoleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(AnoleAnimations.anole_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        if (entity.climbing) {
            this.animate(entity.idleAnimationState, AnoleAnimations.anole_climbing, ageInTicks, 1f);
        } else {
            if (entity.isPassenger()) {
                this.animate(entity.idleAnimationState, AnoleAnimations.anole_sit_up, ageInTicks, 1f);
            } else {
                this.animate(entity.idleAnimationState, AnoleAnimations.anole_idle, ageInTicks, 1f);
            }
        }

        if(entity.isCurrentlyGlowing()) {
            this.animate(entity.sitDownAnimationState, AnoleAnimations.anole_die, ageInTicks, 1.0F);
            this.animate(entity.sitPoseAnimationState, AnoleAnimations.anole_dead, ageInTicks, 1.0F);
            this.animate(entity.sitUpAnimationState, AnoleAnimations.anole_revive, ageInTicks, 1.0F);
        } else {
            this.animate(entity.sitDownAnimationState, AnoleAnimations.anole_sit, ageInTicks, 1.0F);
            this.animate(entity.sitPoseAnimationState, AnoleAnimations.anole_stay, ageInTicks, 1.0F);
            this.animate(entity.sitUpAnimationState, AnoleAnimations.anole_stand, ageInTicks, 1.0F);
        }

        hat1.visible = entity.hat1();
        hat2.visible = entity.hat2();
        hat3.visible = entity.hat3();
        hat4.visible = entity.hat4();
        hat5.visible = entity.hat5();
        hat6.visible = entity.hat6();
        hat7.visible = entity.hat7();
        hat8.visible = entity.hat8();
        hat9.visible = entity.hat9();
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