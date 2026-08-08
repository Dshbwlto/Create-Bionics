package net.dshbwlto.createbionics.entity.client.matchbox;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.BionicsClientConfig;
import net.dshbwlto.createbionics.entity.custom.MatchboxEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class MatchboxModel<T extends MatchboxEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart eyes;

    private final ModelPart abdomen1;
    private final ModelPart abdomen2;

    private final ModelPart root_util;
    private final ModelPart root_alt;

    public MatchboxModel(ModelPart root) {
        this.root = root.getChild("root");
        this.root_util = this.root.getChild("root_util");
        this.root_alt = this.root.getChild("root_alt");

        this.eyes = this.root.getChild("root_util").getChild("body").getChild("head").getChild("eyes");

        this.abdomen1 = this.root.getChild("root_util").getChild("body").getChild("abdomen1");
        this.abdomen2 = this.root.getChild("root_util").getChild("body").getChild("abdomen2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(5.0F, -4.5F, -7.25F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -9.0F, 8.0F, 5.0F, 9.0F, new CubeDeformation(0.013F))
                .texOffs(5, 28).addBox(-5.0F, -3.0F, -8.0F, 10.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.5F, 7.25F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 3).addBox(-4.0F, -4.0F, -1.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0F, -0.1F, 0.7854F, 0.0F, 0.0F));

        PartDefinition mouth_l = head.addOrReplaceChild("mouth_l", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, 0.0F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.5F, -8.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition mouth_r = head.addOrReplaceChild("mouth_r", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.5F, -8.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(3, 6).addBox(-2.5F, -1.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 6).addBox(0.5F, -1.0F, -0.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -9.0F));

        PartDefinition l1 = body.addOrReplaceChild("l1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leg_l1 = l1.addOrReplaceChild("leg_l1", CubeListBuilder.create().texOffs(3, 40).addBox(-1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leg_l1b = leg_l1.addOrReplaceChild("leg_l1b", CubeListBuilder.create().texOffs(2, 56).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.8326F));

        PartDefinition l2 = body.addOrReplaceChild("l2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 2.5F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg_l2 = l2.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(2, 44).addBox(-1.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition leg_l2b = leg_l2.addOrReplaceChild("leg_l2b", CubeListBuilder.create().texOffs(2, 56).addBox(0.0F, -1.0F, -1.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.1345F));

        PartDefinition l3 = body.addOrReplaceChild("l3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg_l3 = l3.addOrReplaceChild("leg_l3", CubeListBuilder.create().texOffs(1, 48).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

        PartDefinition leg_l3b = leg_l3.addOrReplaceChild("leg_l3b", CubeListBuilder.create().texOffs(1, 59).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.4835F));

        PartDefinition l4 = body.addOrReplaceChild("l4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 7.5F, 0.0F, -0.7854F, 0.0F));

        PartDefinition leg_l4 = l4.addOrReplaceChild("leg_l4", CubeListBuilder.create().texOffs(0, 52).addBox(-1.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.48F));

        PartDefinition leg_l4b = leg_l4.addOrReplaceChild("leg_l4b", CubeListBuilder.create().texOffs(0, 62).addBox(0.0F, -1.0F, -1.0F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.2217F));

        PartDefinition r1 = body.addOrReplaceChild("r1", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition leg_r1 = r1.addOrReplaceChild("leg_r1", CubeListBuilder.create().texOffs(3, 40).mirror().addBox(-5.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leg_r1b = leg_r1.addOrReplaceChild("leg_r1b", CubeListBuilder.create().texOffs(2, 56).addBox(-9.0F, -1.0F, -1.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.8326F));

        PartDefinition r2 = body.addOrReplaceChild("r2", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 0.0F, 2.5F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg_r2 = r2.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(2, 44).mirror().addBox(-6.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition leg_r2b = leg_r2.addOrReplaceChild("leg_r2b", CubeListBuilder.create().texOffs(2, 56).addBox(-9.0F, -1.0F, -1.0F, 9.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.1345F));

        PartDefinition r3 = body.addOrReplaceChild("r3", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 0.0F, 5.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg_r3 = r3.addOrReplaceChild("leg_r3", CubeListBuilder.create().texOffs(1, 48).mirror().addBox(-7.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

        PartDefinition leg_r3b = leg_r3.addOrReplaceChild("leg_r3b", CubeListBuilder.create().texOffs(1, 59).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.4835F));

        PartDefinition r4 = body.addOrReplaceChild("r4", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 0.0F, 7.5F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leg_r4 = r4.addOrReplaceChild("leg_r4", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-8.0F, -1.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

        PartDefinition leg_r4b = leg_r4.addOrReplaceChild("leg_r4b", CubeListBuilder.create().texOffs(0, 62).addBox(-11.0F, -1.0F, -1.0F, 11.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.2217F));

        PartDefinition abdomen1 = body.addOrReplaceChild("abdomen1", CubeListBuilder.create().texOffs(14, 14).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(5, 40).addBox(0.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(5, 40).mirror().addBox(-4.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 14).addBox(-2.5F, -0.5F, 1.5F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(45, 3).addBox(-3.0F, -10.5F, 0.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -0.5F, 10.75F));

        PartDefinition abdomen2 = body.addOrReplaceChild("abdomen2", CubeListBuilder.create().texOffs(14, 14).addBox(-3.5F, -0.5F, -0.5F, 7.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(5, 40).addBox(0.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(5, 40).mirror().addBox(-4.0F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 14).addBox(-2.5F, -0.5F, 1.5F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(79, 3).addBox(-3.0F, -10.5F, 0.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -0.5F, 10.75F));

        PartDefinition root_alt = root.addOrReplaceChild("root_alt", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.0F, -20.0F, -3.0F, 14.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(MatchboxEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(MatchboxAnimations.matchbox_walk, limbSwing, limbSwingAmount, 2f, 2.5f);

        this.animate(entity.sitDownAnimationState, MatchboxAnimations.matchbox_sit, ageInTicks, 1.0F);

        this.animate(entity.deployAnimationState, MatchboxAnimations.matchbox_deploy, ageInTicks, 1.0F);
        this.animate(entity.collapseAnimationState, MatchboxAnimations.matchbox_collapse, ageInTicks, 1.0F);

        if (!entity.isPassenger()) {
            this.animate(entity.sitPoseAnimationState, MatchboxAnimations.matchbox_stay, ageInTicks, 1.0F);
        }
        this.animate(entity.sitUpAnimationState, MatchboxAnimations.matchbox_stand, ageInTicks, 1.0F);

        root_util.visible = !BionicsClientConfig.arachnophobia;
        root_alt.visible = BionicsClientConfig.arachnophobia;

        abdomen1.visible = entity.isPlaceable();
        abdomen2.visible = !entity.isPlaceable();
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -50, 50);
        pHeadPitch = Mth.clamp(pHeadPitch, -50, 50);

        this.eyes.x = -pNetHeadYaw / 100;
        this.eyes.y = pHeadPitch / 100 - 6;
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