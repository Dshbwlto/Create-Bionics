package net.dshbwlto.createbionics.entity.client.stalker;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class StalkerModel <T extends StalkerEntity> extends HierarchicalModel <T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart leg_l;
    private final ModelPart leg_r;
    private final ModelPart upper_body;
    private final ModelPart stand;
    private final ModelPart head;
    private final ModelPart arm_l;
    private final ModelPart arm_r;

    public StalkerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("root_util").getChild("body");
        this.tail = this.root.getChild("root_util").getChild("body").getChild("tail");
        this.leg_l = this.root.getChild("root_util").getChild("body").getChild("leg_l");
        this.leg_r = this.root.getChild("root_util").getChild("body").getChild("leg_r");
        this.upper_body = this.root.getChild("root_util").getChild("upper_body");
        this.stand = this.root.getChild("root_util").getChild("upper_body").getChild("stand");
        this.head = this.root.getChild("root_util").getChild("upper_body").getChild("head");
        this.arm_l = this.root.getChild("root_util").getChild("upper_body").getChild("arm_l");
        this.arm_r = this.root.getChild("root_util").getChild("upper_body").getChild("arm_r");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 73).addBox(-3.0F, 1.25F, -1.0F, 6.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(132, 137).addBox(-2.5F, 2.25F, 8.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(132, 137).mirror().addBox(-3.5F, 2.25F, 8.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(78, 73).addBox(-3.5F, 0.0F, -0.75F, 7.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 2.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(40, 73).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 107).addBox(-2.0F, -2.0F, 0.3F, 4.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.25F, 13.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(74, 110).addBox(-1.0F, 0.0F, -0.3F, 4.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.9977F, 12.9847F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(40, 94).addBox(-0.498F, 1.0F, -1.0F, 3.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.001F, -2.023F, 13.1495F, 0.3054F, 0.0F, 0.0F));

        PartDefinition bone3 = tail.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, -2.75F, 0.25F));

        PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(120, 73).addBox(0.0F, 0.0F, -0.2F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 13.0F, 0.2182F, -0.2182F, 0.7854F));

        PartDefinition cube_r4 = bone3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(34, 113).addBox(0.0F, 0.0F, 0.05F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leg_l = body.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(146, 145).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 140).addBox(2.0F, -1.5F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(1.5F, 6.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(3.5F, 6.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 4.25F, 10.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(14, 145).addBox(-1.0F, 1.5F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(146, 56).addBox(-0.5F, 9.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(34, 107).addBox(-0.5F, 4.5F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, 0.0F, 1.3526F, 0.0F, 0.0F));

        PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(114, 151).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(140, 103).addBox(-4.0F, -1.5F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-2.5F, 6.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-4.5F, 6.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.25F, 10.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(146, 0).addBox(-1.0F, 1.5F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(146, 62).addBox(-0.5F, 9.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(136, 152).addBox(-0.5F, 4.5F, -2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 8.0F, 0.0F, 1.3526F, 0.0F, 0.0F));

        PartDefinition bone4 = body.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 8.75F, 3.5F));

        PartDefinition cube_r5 = bone4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(108, 126).addBox(-3.5F, -2.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0436F, 0.0436F, 0.0F));

        PartDefinition cube_r6 = bone4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(84, 125).addBox(1.5F, -2.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0436F, -0.0436F, 0.0F));

        PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r7 = bone2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(108, 110).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7854F));

        PartDefinition upper_body = root_util.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(78, 89).addBox(-3.5F, 0.0F, -11.0F, 7.0F, 10.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(142, 86).addBox(3.0F, 0.5F, -9.5F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 145).addBox(-4.0F, 0.5F, -9.5F, 1.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 94).addBox(-4.5F, -2.0F, -11.0F, 9.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(26, 127).addBox(-3.25F, -1.5F, -11.5F, 1.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(42, 127).addBox(2.25F, -1.5F, -11.5F, 1.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 2.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r8 = upper_body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(146, 27).addBox(1.0F, 5.0F, -3.5F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(146, 11).addBox(-2.0F, 5.0F, -3.5F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -11.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r9 = upper_body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 135).addBox(-0.5F, -3.0F, -9.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -11.0F, 1.2654F, 0.0F, 0.0F));

        PartDefinition cube_r10 = upper_body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(146, 50).addBox(-0.25F, 1.5F, -7.75F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(146, 68).addBox(0.5F, 0.5F, -5.75F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 146).addBox(-1.0F, 0.5F, -5.75F, 1.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(142, 98).addBox(-1.25F, -0.5F, -6.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(36, 146).addBox(-0.75F, -0.5F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(62, 125).addBox(-2.75F, 0.0F, -5.0F, 6.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -2.0F, -11.0F, 0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r11 = upper_body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(132, 145).addBox(-2.75F, 3.5F, -8.75F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -2.0F, -11.0F, 0.5236F, -0.1309F, 0.0F));

        PartDefinition cube_r12 = upper_body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(140, 116).addBox(1.75F, 3.5F, -8.75F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -2.0F, -11.0F, 0.5236F, 0.1309F, 0.0F));

        PartDefinition stand = upper_body.addOrReplaceChild("stand", CubeListBuilder.create(), PartPose.offset(0.0F, 11.25F, -4.5F));

        PartDefinition cube_r13 = stand.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(27, 62).addBox(-2.0F, 6.35F, 0.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2352F, -0.4686F, 0.1078F));

        PartDefinition cube_r14 = stand.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(27, 62).mirror().addBox(0.0F, 6.35F, 0.0F, 2.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2352F, 0.4686F, -0.1078F));

        PartDefinition cube_r15 = stand.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(72, 80).addBox(-2.0F, 6.25F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(79, 91).addBox(-1.0F, -0.75F, -5.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2094F, 0.0F, 0.0F));

        PartDefinition bone = upper_body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.95F, -5.5F, 0.0F, 0.0F, 3.1416F));

        PartDefinition cube_r16 = bone.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 122).addBox(0.4445F, -3.4445F, 0.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r17 = bone.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(114, 89).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.45F, 0.0F, 0.0F, -2.3562F));

        PartDefinition antenna_l = upper_body.addOrReplaceChild("antenna_l", CubeListBuilder.create().texOffs(58, 127).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.5F, -13.0F, -0.7418F, 0.1309F, 0.2182F));

        PartDefinition antenna_l2 = antenna_l.addOrReplaceChild("antenna_l2", CubeListBuilder.create().texOffs(74, 94).addBox(-0.5F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition antenna_r = upper_body.addOrReplaceChild("antenna_r", CubeListBuilder.create().texOffs(44, 152).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, -13.0F, -0.7418F, -0.1309F, -0.2182F));

        PartDefinition antenna_r2 = antenna_r.addOrReplaceChild("antenna_r2", CubeListBuilder.create().texOffs(146, 36).addBox(-0.5F, -13.0F, -0.5F, 1.0F, 13.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition head = upper_body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(114, 103).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(74, 108).addBox(1.75F, 1.0F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(128, 86).addBox(-2.75F, 1.0F, -0.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5F, -16.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r18 = head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(132, 126).addBox(-1.5F, 0.25F, -6.65F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -1.25F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r19 = head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(24, 146).addBox(0.0F, -1.0F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -0.5F, -4.0F, 0.0F, -0.2531F, 0.0F));

        PartDefinition cube_r20 = head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(146, 20).addBox(-2.0F, -1.0F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -0.5F, -4.0F, 0.0F, 0.2531F, 0.0F));

        PartDefinition jaw_hyd = head.addOrReplaceChild("jaw_hyd", CubeListBuilder.create().texOffs(120, 86).addBox(1.0F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(124, 86).addBox(-2.0F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -1.5F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(-2.5F, 1.5F, 0.0F));

        PartDefinition cube_r21 = jaw.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(84, 137).addBox(0.0F, -2.01F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition cube_r22 = jaw.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 135).addBox(-2.0F, -2.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.1309F, 0.0F));

        PartDefinition arm_l = upper_body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(104, 138).addBox(1.5F, -2.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(3.0F, 6.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(1.0F, 6.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(26, 122).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 3.5F, -6.5F, 0.0436F, 0.0F, -0.3054F));

        PartDefinition arm_l2 = arm_l.addOrReplaceChild("arm_l2", CubeListBuilder.create().texOffs(62, 113).addBox(-1.0F, 1.5F, -2.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(146, 76).addBox(-0.5F, 9.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(132, 152).addBox(-0.5F, 4.5F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 7.5F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition arm_r = upper_body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(118, 138).addBox(-3.5F, -2.0F, -2.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(150, 36).addBox(-4.0F, 6.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-2.0F, 6.0F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(152, 129).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 3.5F, -6.5F, 0.0436F, 0.0F, 0.3054F));

        PartDefinition arm_r2 = arm_r.addOrReplaceChild("arm_r2", CubeListBuilder.create().texOffs(72, 140).addBox(-1.0F, 1.5F, -2.0F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(146, 81).addBox(-0.5F, 9.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(152, 133).addBox(-0.5F, 4.5F, -3.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(132, 103).addBox(-0.5F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 7.5F, 0.0F, -1.0472F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);

    }

    @Override
    public void setupAnim(StalkerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.applyHeadRotation(netHeadYaw, headPitch);
        if (entity.isAggressive()) {
            this.animateWalk(StalkerAnimations.stalker_run, limbSwing, limbSwingAmount, 1f, 2f);
        } else {
            this.animateWalk(StalkerAnimations.stalker_walk, limbSwing, limbSwingAmount, 2f, 2f);
        }
        this.animate(entity.idleAnimationState, StalkerAnimations.stalker_idle, ageInTicks, 1f);
            this.animate(entity.sitDownAnimationState, StalkerAnimations.stalker_sit, ageInTicks, 1.0F);
            this.animate(entity.sitPoseAnimationState, StalkerAnimations.stalker_stay, ageInTicks, 1.0F);
            this.animate(entity.sitUpAnimationState, StalkerAnimations.stalker_stand, ageInTicks, 1.0F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
