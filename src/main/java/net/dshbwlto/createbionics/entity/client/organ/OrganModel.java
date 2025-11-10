package net.dshbwlto.createbionics.entity.client.organ;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.client.stalker.StalkerAnimations;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class OrganModel <T extends OrganEntity> extends HierarchicalModel<T> {
    private final ModelPart root;

    private final ModelPart body;
    private final ModelPart chest;
    private final ModelPart neck;
    private final ModelPart head;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart leg_l;
    private final ModelPart leg_r;

    private final ModelPart piston_l1;
    private final ModelPart piston_l2;
    private final ModelPart piston_l3;
    private final ModelPart piston_l4;
    private final ModelPart piston_r1;
    private final ModelPart piston_r2;
    private final ModelPart piston_r3;
    private final ModelPart piston_r4;
    private final ModelPart blink;
    private final ModelPart dial;

    private final ModelPart steam_head;
    private final ModelPart steam_face;
    private final ModelPart steam_tail;

    private final ModelPart steam_4;
    private final ModelPart steam_chest;
    private final ModelPart steam_neck;
    private final ModelPart steam_foot;

    public OrganModel(ModelPart root) {
        this.root = root.getChild("root");

        this.body = this.root.getChild("root_util").getChild("body");
        this.chest = this.root.getChild("root_util").getChild("body").getChild("chest");
        this.neck = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck");
        this.head = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head");
        this.tail1 = this.root.getChild("root_util").getChild("body").getChild("tail1");
        this.tail2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2");
        this.leg_l = this.root.getChild("root_util").getChild("leg_l");
        this.leg_r = this.root.getChild("root_util").getChild("leg_r");

        this.piston_l1 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l1");
        this.piston_l2 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l2");
        this.piston_l3 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l3");
        this.piston_l4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l4");
        this.piston_r1 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r1");
        this.piston_r2 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r2");
        this.piston_r3 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r3");
        this.piston_r4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r4");
        this.blink = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("blink");
        this.dial = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("dial");

        this.steam_head = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("exhaust").getChild("steam_head");
        this.steam_face = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("face").getChild("steam_face");
        this.steam_tail = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("steam_tail");

        this.steam_4 = this.root.getChild("root_util").getChild("body").getChild("steam_4");
        this.steam_chest = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("steam_chest");
        this.steam_neck = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("steam_neck");
        this.steam_foot = this.root.getChild("root_util").getChild("leg_r").getChild("leg_r2").getChild("steam_foot");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create().texOffs(384, 425).addBox(-18.0F, -12.0F, -30.0F, 36.0F, 31.0F, 64.0F, new CubeDeformation(0.0F))
                .texOffs(425, 340).addBox(21.75F, -10.0F, 30.0F, 5.0F, 23.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(696, 589).addBox(22.25F, 5.5F, -20.0F, 4.0F, 4.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(696, 589).addBox(22.25F, -6.5F, -20.0F, 4.0F, 4.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(425, 340).addBox(21.75F, -10.0F, -28.0F, 5.0F, 23.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(425, 340).addBox(-26.75F, -10.0F, -28.0F, 5.0F, 23.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(696, 589).addBox(-26.25F, -6.5F, -20.0F, 4.0F, 4.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(696, 589).addBox(-26.25F, 5.5F, -20.0F, 4.0F, 4.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(425, 340).addBox(-26.75F, -10.0F, 30.0F, 5.0F, 23.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(305, 134).addBox(-24.0F, -24.0F, -30.0F, 48.0F, 12.0F, 64.0F, new CubeDeformation(0.0F))
                .texOffs(550, 520).addBox(-13.0F, -35.0F, -24.0F, 26.0F, 11.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -80.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(185, 70).addBox(-9.0F, -7.0F, -1.0F, 14.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(185, 70).addBox(-9.0F, -7.0F, -59.0F, 14.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, 16.0F, 33.5F, 0.0F, 0.0F, 0.48F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(185, 70).addBox(-5.0F, -7.0F, -1.0F, 14.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(185, 70).addBox(-5.0F, -7.0F, 57.0F, 14.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, 16.0F, -24.5F, 0.0F, 0.0F, -0.48F));

        PartDefinition steam_4 = body.addOrReplaceChild("steam_4", CubeListBuilder.create(), PartPose.offset(24.75F, 2.0F, 29.0F));

        PartDefinition steam_hip_r1 = steam_4.addOrReplaceChild("steam_hip_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2733F, 0.7001F, 1.0797F));

        PartDefinition steam_hip_r2 = steam_4.addOrReplaceChild("steam_hip_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.8316F, 0.8277F, -1.6515F));

        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(474, 666).mirror().addBox(-23.0F, 15.0F, -52.0F, 9.0F, 26.0F, 44.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(474, 668).mirror().addBox(-23.0F, 22.0F, -29.0F, 1.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(474, 668).addBox(22.0F, 22.0F, -29.0F, 1.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(285, 48).addBox(-2.0F, 37.0F, -43.0F, 4.0F, 4.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(474, 666).addBox(14.0F, 15.0F, -52.0F, 9.0F, 26.0F, 44.0F, new CubeDeformation(0.0F))
                .texOffs(549, 680).addBox(18.0F, 19.0F, -48.0F, 5.0F, 16.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(549, 680).mirror().addBox(-23.0F, 19.0F, -48.0F, 5.0F, 16.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 222).addBox(-20.0F, -16.0F, -60.0F, 40.0F, 53.0F, 60.0F, new CubeDeformation(0.0F))
                .texOffs(196, 520).addBox(-23.0F, -4.1F, -55.0F, 46.0F, 13.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -30.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r3 = chest.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(296, 89).mirror().addBox(0.0F, -2.0F, -1.0F, 17.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 37.0F, -49.0F, 0.0F, -0.5236F, 0.1309F));

        PartDefinition cube_r4 = chest.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(298, 82).mirror().addBox(0.0F, -2.0F, -1.0F, 15.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 37.0F, -39.0F, 0.0F, -0.2618F, 0.1309F));

        PartDefinition cube_r5 = chest.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(298, 82).mirror().addBox(0.0F, -2.0F, -2.0F, 15.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 37.0F, -21.0F, 0.0F, 0.2618F, 0.1309F));

        PartDefinition cube_r6 = chest.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(296, 89).mirror().addBox(0.0F, -2.0F, -2.0F, 17.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 37.0F, -11.0F, 0.0F, 0.5236F, 0.1309F));

        PartDefinition cube_r7 = chest.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(298, 96).mirror().addBox(1.0F, -2.0F, -1.0F, 13.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 37.0F, -30.5F, 0.0F, 0.0F, 0.1309F));

        PartDefinition cube_r8 = chest.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(296, 89).addBox(-17.0F, -2.0F, -1.0F, 17.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 37.0F, -49.0F, 0.0F, 0.5236F, -0.1309F));

        PartDefinition cube_r9 = chest.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(298, 96).addBox(-14.0F, -2.0F, -1.0F, 13.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 37.0F, -30.5F, 0.0F, 0.0F, -0.1309F));

        PartDefinition cube_r10 = chest.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(298, 82).addBox(-15.0F, -2.0F, -1.0F, 15.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 37.0F, -39.0F, 0.0F, 0.2618F, -0.1309F));

        PartDefinition cube_r11 = chest.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(298, 82).addBox(-15.0F, -2.0F, -2.0F, 15.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 37.0F, -21.0F, 0.0F, -0.2618F, -0.1309F));

        PartDefinition cube_r12 = chest.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(296, 89).addBox(-17.0F, -2.0F, -2.0F, 17.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 37.0F, -11.0F, 0.0F, -0.5236F, -0.1309F));

        PartDefinition steam_chest = chest.addOrReplaceChild("steam_chest", CubeListBuilder.create(), PartPose.offset(-23.0F, 26.0F, -34.0F));

        PartDefinition steam_5_r1 = steam_chest.addOrReplaceChild("steam_5_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(46.0F, 4.0F, 21.0F, -2.9278F, -0.5302F, -2.6192F));

        PartDefinition steam_5_r2 = steam_chest.addOrReplaceChild("steam_5_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(46.0F, 4.0F, 21.0F, -2.7943F, 1.003F, -2.2136F));

        PartDefinition steam_1_r1 = steam_chest.addOrReplaceChild("steam_1_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.6014F, -0.9901F, 1.8873F));

        PartDefinition steam_1_r2 = steam_chest.addOrReplaceChild("steam_1_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3255F, -0.4898F, -0.6321F));

        PartDefinition dial = chest.addOrReplaceChild("dial", CubeListBuilder.create(), PartPose.offset(-0.5F, 29.0F, -22.0F));

        PartDefinition cube_r13 = dial.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(484, 674).addBox(22.0F, -6.0F, -0.5F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(484, 674).mirror().addBox(-23.0F, -6.0F, -0.5F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, -1.3963F, 0.0F, 0.0F));

        PartDefinition sheet = chest.addOrReplaceChild("sheet", CubeListBuilder.create().texOffs(530, 638).addBox(0.0F, -18.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 636).addBox(0.0F, -20.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 634).addBox(0.0F, -22.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 632).addBox(0.0F, -24.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 630).addBox(0.0F, -26.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 628).addBox(0.0F, -28.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 626).addBox(0.0F, -30.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 624).addBox(0.0F, -32.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 628).addBox(0.0F, -12.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 626).addBox(0.0F, -14.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 624).addBox(0.0F, -16.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 638).mirror().addBox(-38.0F, -18.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 636).mirror().addBox(-38.0F, -20.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 634).mirror().addBox(-38.0F, -22.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 632).mirror().addBox(-38.0F, -24.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 630).mirror().addBox(-38.0F, -26.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 628).mirror().addBox(-38.0F, -28.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 626).mirror().addBox(-38.0F, -30.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 624).mirror().addBox(-38.0F, -32.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 628).mirror().addBox(-38.0F, -12.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 626).mirror().addBox(-38.0F, -14.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 624).mirror().addBox(-38.0F, -16.0F, -5.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(19.0F, 35.0F, -42.5F));

        PartDefinition sheet1 = sheet.addOrReplaceChild("sheet1", CubeListBuilder.create().texOffs(530, 638).addBox(0.0F, 8.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 636).addBox(0.0F, 6.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 634).addBox(0.0F, 4.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 632).addBox(0.0F, 2.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 630).addBox(0.0F, 0.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(530, 638).mirror().addBox(-38.0F, 8.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 636).mirror().addBox(-38.0F, 6.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 634).mirror().addBox(-38.0F, 4.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 632).mirror().addBox(-38.0F, 2.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(530, 630).mirror().addBox(-38.0F, 0.0F, -6.0F, 0.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -10.0F, 1.0F));

        PartDefinition piston_parent_l = chest.addOrReplaceChild("piston_parent_l", CubeListBuilder.create(), PartPose.offsetAndRotation(20.0F, 3.0F, -48.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition piston_l1 = piston_parent_l.addOrReplaceChild("piston_l1", CubeListBuilder.create().texOffs(188, 12).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition piston_2_l1 = piston_l1.addOrReplaceChild("piston_2_l1", CubeListBuilder.create().texOffs(180, 32).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_l2 = piston_parent_l.addOrReplaceChild("piston_l2", CubeListBuilder.create().texOffs(188, 12).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.0F));

        PartDefinition piston_2_l2 = piston_l2.addOrReplaceChild("piston_2_l2", CubeListBuilder.create().texOffs(180, 32).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_l3 = piston_parent_l.addOrReplaceChild("piston_l3", CubeListBuilder.create().texOffs(188, 12).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 25.0F));

        PartDefinition piston_2_l3 = piston_l3.addOrReplaceChild("piston_2_l3", CubeListBuilder.create().texOffs(180, 32).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_l4 = piston_parent_l.addOrReplaceChild("piston_l4", CubeListBuilder.create().texOffs(188, 12).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 37.0F));

        PartDefinition piston_2_l4 = piston_l4.addOrReplaceChild("piston_2_l4", CubeListBuilder.create().texOffs(180, 32).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_parent_r = chest.addOrReplaceChild("piston_parent_r", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.0F, 3.0F, -48.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition piston_r1 = piston_parent_r.addOrReplaceChild("piston_r1", CubeListBuilder.create().texOffs(188, 12).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition piston_2_r1 = piston_r1.addOrReplaceChild("piston_2_r1", CubeListBuilder.create().texOffs(180, 32).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_r2 = piston_parent_r.addOrReplaceChild("piston_r2", CubeListBuilder.create().texOffs(188, 12).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 13.0F));

        PartDefinition piston_2_r2 = piston_r2.addOrReplaceChild("piston_2_r2", CubeListBuilder.create().texOffs(180, 32).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_r3 = piston_parent_r.addOrReplaceChild("piston_r3", CubeListBuilder.create().texOffs(188, 12).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 25.0F));

        PartDefinition piston_2_r3 = piston_r3.addOrReplaceChild("piston_2_r3", CubeListBuilder.create().texOffs(180, 32).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_r4 = piston_parent_r.addOrReplaceChild("piston_r4", CubeListBuilder.create().texOffs(188, 12).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 37.0F));

        PartDefinition piston_2_r4 = piston_r4.addOrReplaceChild("piston_2_r4", CubeListBuilder.create().texOffs(180, 32).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(48, 814).addBox(-10.0F, 12.0F, -19.0F, 20.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(283, 38).addBox(-10.0F, -3.0F, -52.0F, 20.0F, 15.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(48, 814).addBox(-10.0F, 12.0F, 1.0F, 20.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 814).addBox(-10.0F, 12.0F, -39.0F, 20.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(388, 520).addBox(-6.0F, 16.0F, -52.0F, 12.0F, 12.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(328, 601).addBox(-2.0F, 12.0F, -52.0F, 4.0F, 4.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(550, 589).addBox(-2.0F, 28.0F, -52.0F, 4.0F, 8.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(401, 26).addBox(-9.0F, 18.0F, -52.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(401, 26).mirror().addBox(7.0F, 18.0F, -52.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.0F, -54.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r14 = neck.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(401, 26).addBox(-1.0F, 12.0F, -46.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(401, 26).addBox(13.0F, 12.0F, -46.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 13.0F, -6.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r15 = neck.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(584, 425).addBox(-1.5F, 10.0F, -46.0F, 6.0F, 6.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 20.0F, -6.0F, 0.0436F, 0.0262F, -0.1309F));

        PartDefinition cube_r16 = neck.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(584, 425).addBox(-4.5F, 10.0F, -46.0F, 6.0F, 6.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 20.0F, -6.0F, 0.0436F, -0.0262F, 0.1309F));

        PartDefinition steam_neck = neck.addOrReplaceChild("steam_neck", CubeListBuilder.create(), PartPose.offset(-12.0F, 26.0F, -3.0F));

        PartDefinition steam_2_r1 = steam_neck.addOrReplaceChild("steam_2_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, -2.1817F));

        PartDefinition steam_2_r2 = steam_neck.addOrReplaceChild("steam_2_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, -0.7854F, 0.9599F));

        PartDefinition steam_3_r1 = steam_neck.addOrReplaceChild("steam_3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -5.0F, -19.0F, 3.1416F, 0.7854F, -1.7453F));

        PartDefinition steam_3_r2 = steam_neck.addOrReplaceChild("steam_3_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -5.0F, -19.0F, 0.0F, 0.7854F, 1.3963F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(150, 159).addBox(-14.0F, -6.0F, -24.0F, 28.0F, 26.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(259, 379).addBox(-12.0F, -12.0F, -38.0F, 24.0F, 20.0F, 36.0F, new CubeDeformation(0.0F))
                .texOffs(734, 470).addBox(-14.0F, -6.0F, -38.0F, 28.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.0F, -41.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition blink = head.addOrReplaceChild("blink", CubeListBuilder.create().texOffs(818, 470).addBox(-14.0F, 0.0F, 13.0F, 28.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -51.0F));

        PartDefinition exhaust = head.addOrReplaceChild("exhaust", CubeListBuilder.create().texOffs(135, 30).addBox(-24.0F, -31.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(135, 8).addBox(-24.0F, -7.0F, -4.0F, 10.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(135, 8).mirror().addBox(14.0F, -7.0F, -4.0F, 10.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(135, 30).mirror().addBox(16.0F, -31.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, -6.5F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r17 = exhaust.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(135, 30).mirror().addBox(16.0F, 6.0F, -1.0F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(135, 8).mirror().addBox(14.0F, 21.0F, -1.0F, 10.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -26.0F, -13.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r18 = exhaust.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(135, 8).addBox(-24.0F, 21.0F, -1.0F, 10.0F, 14.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(135, 30).addBox(-24.0F, 6.0F, -1.0F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -26.0F, -13.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition steam_head = exhaust.addOrReplaceChild("steam_head", CubeListBuilder.create(), PartPose.offset(-20.0F, -31.0F, 0.0F));

        PartDefinition steam_exhaust_a_r1 = steam_head.addOrReplaceChild("steam_exhaust_a_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition steam_exhaust_a_r2 = steam_head.addOrReplaceChild("steam_exhaust_a_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition steam_exhaust_a_r3 = steam_head.addOrReplaceChild("steam_exhaust_a_r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition steam_exhaust_a_r4 = steam_head.addOrReplaceChild("steam_exhaust_a_r4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition steam_exhaust_a_r5 = steam_head.addOrReplaceChild("steam_exhaust_a_r5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1543F, 14.3818F, -10.0F, 0.0F, -0.7854F, -0.1745F));

        PartDefinition steam_exhaust_a_r6 = steam_head.addOrReplaceChild("steam_exhaust_a_r6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(42.1543F, 14.3818F, -10.0F, -3.1416F, 0.7854F, -2.9671F));

        PartDefinition steam_exhaust_a_r7 = steam_head.addOrReplaceChild("steam_exhaust_a_r7", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(42.1543F, 14.3818F, -10.0F, 0.0F, 0.7854F, 0.1745F));

        PartDefinition steam_head2 = exhaust.addOrReplaceChild("steam_head2", CubeListBuilder.create(), PartPose.offset(20.0F, -31.0F, 0.0F));

        PartDefinition steam_exhaust_a_r8 = steam_head2.addOrReplaceChild("steam_exhaust_a_r8", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-42.1543F, 14.3818F, -10.0F, -3.1416F, -0.7854F, 2.9671F));

        PartDefinition face = head.addOrReplaceChild("face", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, -44.0F));

        PartDefinition cube_r19 = face.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(718, 500).addBox(-12.0F, 0.0F, -30.0F, 24.0F, 22.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r20 = face.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(416, 293).addBox(-14.0F, 0.0F, -25.0F, 28.0F, 16.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 6.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition steam_face = face.addOrReplaceChild("steam_face", CubeListBuilder.create(), PartPose.offset(-14.0F, 18.5F, -5.0F));

        PartDefinition steam7_r1 = steam_face.addOrReplaceChild("steam7_r1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7743F, 0.0192F, -0.8342F));

        PartDefinition steam7_r2 = steam_face.addOrReplaceChild("steam7_r2", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5433F, -0.7963F, 0.717F));

        PartDefinition steam7_r3 = steam_face.addOrReplaceChild("steam7_r3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0F, 0.0F, 0.0F, -1.5433F, 0.7963F, -0.717F));

        PartDefinition steam7_r4 = steam_face.addOrReplaceChild("steam7_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.0F, 0.0F, 0.0F, -0.7743F, -0.0192F, 0.8342F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, -16.0F));

        PartDefinition cube_r21 = jaw.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(323, 438).addBox(-12.0F, 0.0F, 0.0F, 24.0F, 11.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -19.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition jaw_front = jaw.addOrReplaceChild("jaw_front", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -19.0F));

        PartDefinition cube_r22 = jaw_front.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(734, 417).addBox(0.0F, 7.0F, -23.0F, 4.0F, 7.0F, 46.0F, new CubeDeformation(0.0F))
                .texOffs(734, 417).addBox(-14.0F, 7.0F, -23.0F, 4.0F, 7.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r23 = jaw_front.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(718, 552).addBox(-12.0F, 0.0F, -26.0F, 24.0F, 11.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bellows_l = chest.addOrReplaceChild("bellows_l", CubeListBuilder.create().texOffs(164, 583).addBox(1.0F, 3.0F, -49.0F, 26.0F, 13.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(586, 502).addBox(1.0F, 3.0F, 7.0F, 26.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(84, 440).addBox(-4.5F, -1.0F, 14.0F, 38.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 519).addBox(-4.0F, 1.0F, -45.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -30.0F, -12.0F, 0.0F, 0.0F, 0.6545F));

        PartDefinition bellows_bottom_l = bellows_l.addOrReplaceChild("bellows_bottom_l", CubeListBuilder.create().texOffs(804, 627).addBox(-12.0F, 0.9F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(16.5F, -0.1F, -45.0F));

        PartDefinition cube_r24 = bellows_bottom_l.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r25 = bellows_bottom_l.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition top_l = bellows_l.addOrReplaceChild("top_l", CubeListBuilder.create().texOffs(0, 519).addBox(-20.5F, -2.9F, -61.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offset(16.5F, 0.9F, 16.0F));

        PartDefinition bellows_top_l = top_l.addOrReplaceChild("bellows_top_l", CubeListBuilder.create().texOffs(804, 627).addBox(-12.0F, -2.1F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -61.0F));

        PartDefinition cube_r26 = bellows_top_l.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r27 = bellows_top_l.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bellows_fabric_l = bellows_l.addOrReplaceChild("bellows_fabric_l", CubeListBuilder.create().texOffs(0, 320).addBox(-16.5F, -56.792F, 7.7442F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F))
                .texOffs(0, 320).mirror().addBox(18.5F, -56.792F, 7.7442F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.5F, 0.8F, -52.45F));

        PartDefinition bellows_fabric_l1 = bellows_fabric_l.addOrReplaceChild("bellows_fabric_l1", CubeListBuilder.create().texOffs(14, 136).addBox(-7.8211F, -55.9F, -6.8211F, 21.0F, 59.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, -0.892F, 7.4942F));

        PartDefinition cube_r28 = bellows_fabric_l1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 224).addBox(-12.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0992F, 0.1F, -1.8713F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r29 = bellows_fabric_l1.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 224).mirror().addBox(2.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.4008F, 0.1F, -1.8713F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bellows_r = chest.addOrReplaceChild("bellows_r", CubeListBuilder.create().texOffs(164, 583).addBox(-27.0F, 3.0F, -49.0F, 26.0F, 13.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(586, 502).addBox(-27.0F, 3.0F, 7.0F, 26.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(84, 440).addBox(-33.5F, -1.0F, 14.0F, 38.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 519).addBox(-33.0F, 1.0F, -45.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -30.0F, -12.0F, 0.0F, 0.0F, -0.6545F));

        PartDefinition bellows_bottom_r = bellows_r.addOrReplaceChild("bellows_bottom_r", CubeListBuilder.create().texOffs(804, 627).addBox(-8.0F, 0.9F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.5F, -0.1F, -45.0F));

        PartDefinition cube_r30 = bellows_bottom_r.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r31 = bellows_bottom_r.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition top_r = bellows_r.addOrReplaceChild("top_r", CubeListBuilder.create().texOffs(0, 519).addBox(-16.5F, -2.9F, -61.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.5F, 0.9F, 16.0F));

        PartDefinition bellows_top_r = top_r.addOrReplaceChild("bellows_top_r", CubeListBuilder.create().texOffs(804, 627).addBox(-8.0F, -2.1F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -61.0F));

        PartDefinition cube_r32 = bellows_top_r.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r33 = bellows_top_r.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bellows_fabric_r = bellows_r.addOrReplaceChild("bellows_fabric_r", CubeListBuilder.create().texOffs(0, 320).addBox(-18.5F, -58.8F, 14.45F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F))
                .texOffs(0, 320).mirror().addBox(16.5F, -58.8F, 14.45F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.5F, 0.8F, -59.45F));

        PartDefinition bellows_fabric_r1 = bellows_fabric_r.addOrReplaceChild("bellows_fabric_r1", CubeListBuilder.create().texOffs(14, 136).addBox(-13.1789F, -55.9F, -6.8211F, 21.0F, 59.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -2.9F, 14.2F));

        PartDefinition cube_r34 = bellows_fabric_r1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 224).mirror().addBox(2.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0992F, 0.1F, -1.8713F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r35 = bellows_fabric_r1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 224).addBox(-12.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4008F, 0.1F, -1.8713F, 0.0F, 0.7854F, 0.0F));

        PartDefinition whistle_chest_parent = chest.addOrReplaceChild("whistle_chest_parent", CubeListBuilder.create(), PartPose.offset(0.0F, -20.0F, -1.0F));

        PartDefinition fs4 = whistle_chest_parent.addOrReplaceChild("fs4", CubeListBuilder.create().texOffs(649, 103).addBox(-5.0F, -30.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 79).addBox(-4.0F, -28.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fs4head = fs4.addOrReplaceChild("fs4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition g4 = whistle_chest_parent.addOrReplaceChild("g4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -38.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 71).addBox(-4.0F, -36.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

        PartDefinition g4head = g4.addOrReplaceChild("g4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition gs4 = whistle_chest_parent.addOrReplaceChild("gs4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -42.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 67).addBox(-4.0F, -40.0F, -4.0F, 8.0F, 28.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -24.0F));

        PartDefinition gs4head = gs4.addOrReplaceChild("gs4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition a4 = whistle_chest_parent.addOrReplaceChild("a4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -34.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 75).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -36.0F));

        PartDefinition a4head = a4.addOrReplaceChild("a4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition as4 = whistle_chest_parent.addOrReplaceChild("as4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -30.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 79).addBox(-4.0F, -28.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -48.0F));

        PartDefinition as4head = as4.addOrReplaceChild("as4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition b4 = whistle_chest_parent.addOrReplaceChild("b4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -26.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 83).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -60.0F));

        PartDefinition b4head = b4.addOrReplaceChild("b4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(155, 46).addBox(-12.0F, -2.0F, 0.0F, 24.0F, 26.0F, 78.0F, new CubeDeformation(0.0F))
                .texOffs(174, 133).addBox(3.0F, 24.0F, 59.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(0.0F, 8.0F, 69.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(-14.0F, 8.0F, 69.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(-14.0F, 8.0F, 33.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(0.0F, 8.0F, 33.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(-14.0F, 8.0F, 42.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(0.0F, 8.0F, 42.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(-14.0F, 8.0F, 51.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(0.0F, 8.0F, 51.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(-14.0F, 8.0F, 60.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 132).addBox(0.0F, 8.0F, 60.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(174, 133).addBox(3.0F, 24.0F, 44.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(174, 133).addBox(3.0F, 24.0F, 29.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(174, 133).addBox(-3.0F, 24.0F, 29.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(174, 133).addBox(-3.0F, 24.0F, 44.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(174, 133).addBox(-3.0F, 24.0F, 59.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(196, 455).addBox(-14.0F, 6.0F, 29.0F, 28.0F, 20.0F, 45.0F, new CubeDeformation(0.0F))
                .texOffs(384, 335).addBox(-15.0F, -14.0F, 0.0F, 30.0F, 12.0F, 78.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 34.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition steam_tail = tail1.addOrReplaceChild("steam_tail", CubeListBuilder.create(), PartPose.offset(12.0F, 24.0F, 38.0F));

        PartDefinition steam_exhaust_b_r1 = steam_tail.addOrReplaceChild("steam_exhaust_b_r1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.6859F, 0.989F, -1.143F));

        PartDefinition steam_exhaust_b_r2 = steam_tail.addOrReplaceChild("steam_exhaust_b_r2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2818F, 0.5161F, 2.5292F));

        PartDefinition steam_exhaust_b_r3 = steam_tail.addOrReplaceChild("steam_exhaust_b_r3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.1555F, 0.6555F, 2.4591F));

        PartDefinition steam_exhaust_b_r4 = steam_tail.addOrReplaceChild("steam_exhaust_b_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 2.9428F, 0.8998F, -0.9342F));

        PartDefinition steam_exhaust_b_r5 = steam_tail.addOrReplaceChild("steam_exhaust_b_r5", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -2.9861F, 0.6555F, -0.6825F));

        PartDefinition steam_exhaust_b_r6 = steam_tail.addOrReplaceChild("steam_exhaust_b_r6", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -0.1988F, 0.8998F, 2.2074F));

        PartDefinition steam_exhaust_b_r7 = steam_tail.addOrReplaceChild("steam_exhaust_b_r7", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -0.4557F, 0.989F, 1.9986F));

        PartDefinition steam_exhaust_b_r8 = steam_tail.addOrReplaceChild("steam_exhaust_b_r8", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -2.8598F, 0.5161F, -0.6124F));

        PartDefinition steam_exhaust_b_r9 = steam_tail.addOrReplaceChild("steam_exhaust_b_r9", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 0.2818F, -0.5161F, -2.5292F));

        PartDefinition steam_exhaust_b_r10 = steam_tail.addOrReplaceChild("steam_exhaust_b_r10", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 2.6859F, -0.989F, 1.143F));

        PartDefinition steam_exhaust_b_r11 = steam_tail.addOrReplaceChild("steam_exhaust_b_r11", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 9.0F, 2.9428F, -0.8998F, 0.9342F));

        PartDefinition steam_exhaust_b_r12 = steam_tail.addOrReplaceChild("steam_exhaust_b_r12", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 9.0F, 0.1555F, -0.6555F, -2.4591F));

        PartDefinition steam_exhaust_b_r13 = steam_tail.addOrReplaceChild("steam_exhaust_b_r13", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 18.0F, -0.1988F, -0.8998F, -2.2074F));

        PartDefinition steam_exhaust_b_r14 = steam_tail.addOrReplaceChild("steam_exhaust_b_r14", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 18.0F, -2.9861F, -0.6555F, 0.6825F));

        PartDefinition steam_exhaust_b_r15 = steam_tail.addOrReplaceChild("steam_exhaust_b_r15", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 27.0F, -0.4557F, -0.989F, -1.9986F));

        PartDefinition steam_exhaust_b_r16 = steam_tail.addOrReplaceChild("steam_exhaust_b_r16", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 27.0F, -2.8598F, -0.5161F, 0.6124F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -5.0F, 16.0F, 23.0F, 98.0F, new CubeDeformation(0.0F))
                .texOffs(186, 557).addBox(-11.0F, -11.0F, 86.0F, 22.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 121).addBox(-11.0F, 15.0F, -5.0F, 22.0F, 3.0F, 98.0F, new CubeDeformation(0.0F))
                .texOffs(0, 222).addBox(-11.0F, -14.0F, 0.0F, 22.0F, 12.0F, 86.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 78.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition whistle_tail2_parent = tail2.addOrReplaceChild("whistle_tail2_parent", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 78.0F));

        PartDefinition c5 = whistle_tail2_parent.addOrReplaceChild("c5", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 76).mirror().addBox(5.0F, -9.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -11.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -70.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition c5head = c5.addOrReplaceChild("c5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition cs5 = whistle_tail2_parent.addOrReplaceChild("cs5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -15.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 72).mirror().addBox(5.0F, -13.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -60.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cs5head = cs5.addOrReplaceChild("cs5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition d5 = whistle_tail2_parent.addOrReplaceChild("d5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -19.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 68).mirror().addBox(5.0F, -17.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -50.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition d5head = d5.addOrReplaceChild("d5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition ds5 = whistle_tail2_parent.addOrReplaceChild("ds5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -23.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 64).mirror().addBox(5.0F, -21.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -40.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition ds5head = ds5.addOrReplaceChild("ds5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition e5 = whistle_tail2_parent.addOrReplaceChild("e5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -27.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 60).mirror().addBox(5.0F, -25.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -30.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition e5head = e5.addOrReplaceChild("e5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition f5 = whistle_tail2_parent.addOrReplaceChild("f5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -31.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 56).mirror().addBox(5.0F, -29.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -20.0F, 0.0F, 0.0F, 0.8727F));

        PartDefinition f5head = f5.addOrReplaceChild("f5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition fs5 = whistle_tail2_parent.addOrReplaceChild("fs5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -35.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 52).mirror().addBox(5.0F, -33.0F, -3.0F, 6.0F, 36.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -10.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition fs5head = fs5.addOrReplaceChild("fs5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition g5 = whistle_tail2_parent.addOrReplaceChild("g5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -39.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 48).mirror().addBox(5.0F, -37.0F, -3.0F, 6.0F, 40.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition g5head = g5.addOrReplaceChild("g5head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition gs5 = whistle_tail2_parent.addOrReplaceChild("gs5", CubeListBuilder.create().texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 76).addBox(-11.0F, -9.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-12.0F, -11.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -70.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition gs5head = gs5.addOrReplaceChild("gs5head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition a5 = whistle_tail2_parent.addOrReplaceChild("a5", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 72).addBox(-11.0F, -13.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -60.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition a5head = a5.addOrReplaceChild("a5head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition as5 = whistle_tail2_parent.addOrReplaceChild("as5", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -19.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 68).addBox(-11.0F, -17.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -50.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition as5head = as5.addOrReplaceChild("as5head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition b5 = whistle_tail2_parent.addOrReplaceChild("b5", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -23.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 64).addBox(-11.0F, -21.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -40.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition b5head = b5.addOrReplaceChild("b5head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition c6 = whistle_tail2_parent.addOrReplaceChild("c6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -27.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 60).addBox(-11.0F, -25.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -30.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition c6head = c6.addOrReplaceChild("c6head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition cs6 = whistle_tail2_parent.addOrReplaceChild("cs6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -31.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 56).addBox(-11.0F, -29.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -20.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cs6head = cs6.addOrReplaceChild("cs6head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition d6 = whistle_tail2_parent.addOrReplaceChild("d6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -35.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 52).addBox(-11.0F, -33.0F, -3.0F, 6.0F, 36.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -10.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition d6head = d6.addOrReplaceChild("d6head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition ds6 = whistle_tail2_parent.addOrReplaceChild("ds6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -39.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 48).addBox(-11.0F, -37.0F, -3.0F, 6.0F, 40.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition ds6head = ds6.addOrReplaceChild("ds6head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition e6 = whistle_tail2_parent.addOrReplaceChild("e6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -70.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 24).addBox(-3.0F, -68.0F, -3.0F, 6.0F, 64.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -70.0F));

        PartDefinition e6head = e6.addOrReplaceChild("e6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition f6 = whistle_tail2_parent.addOrReplaceChild("f6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 32).addBox(-3.0F, -60.0F, -3.0F, 6.0F, 56.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -62.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -60.0F));

        PartDefinition f6head = f6.addOrReplaceChild("f6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition fs6 = whistle_tail2_parent.addOrReplaceChild("fs6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -54.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 40).addBox(-3.0F, -52.0F, -3.0F, 6.0F, 48.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -50.0F));

        PartDefinition fs6head = fs6.addOrReplaceChild("fs6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition g6 = whistle_tail2_parent.addOrReplaceChild("g6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 48).addBox(-3.0F, -44.0F, -3.0F, 6.0F, 40.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -46.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -40.0F));

        PartDefinition g6head = g6.addOrReplaceChild("g6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition gs6 = whistle_tail2_parent.addOrReplaceChild("gs6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -38.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 56).addBox(-3.0F, -36.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -30.0F));

        PartDefinition gs6head = gs6.addOrReplaceChild("gs6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition a6 = whistle_tail2_parent.addOrReplaceChild("a6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 64).addBox(-3.0F, -28.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -30.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -20.0F));

        PartDefinition a6head = a6.addOrReplaceChild("a6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition as6 = whistle_tail2_parent.addOrReplaceChild("as6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -26.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 68).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));

        PartDefinition as6head = as6.addOrReplaceChild("as6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition b6 = whistle_tail2_parent.addOrReplaceChild("b6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 72).addBox(-3.0F, -20.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -22.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition b6head = b6.addOrReplaceChild("b6head", CubeListBuilder.create().texOffs(698, 11).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition c7 = whistle_tail2_parent.addOrReplaceChild("c7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 76).mirror().addBox(5.0F, -8.75F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -10.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -50.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition c7head = c7.addOrReplaceChild("c7head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition cs7 = whistle_tail2_parent.addOrReplaceChild("cs7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 72).mirror().addBox(5.0F, -12.75F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -14.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -40.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cs7head = cs7.addOrReplaceChild("cs7head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition d7 = whistle_tail2_parent.addOrReplaceChild("d7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 68).mirror().addBox(5.0F, -16.75F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -18.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -30.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition d7head = d7.addOrReplaceChild("d7head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition ds7 = whistle_tail2_parent.addOrReplaceChild("ds7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 64).mirror().addBox(5.0F, -20.75F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -22.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 3.0F, -20.0F));

        PartDefinition ds7head = ds7.addOrReplaceChild("ds7head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition e7 = whistle_tail2_parent.addOrReplaceChild("e7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 60).mirror().addBox(5.0F, -24.75F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -26.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -10.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition e7head = e7.addOrReplaceChild("e7head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition f7 = whistle_tail2_parent.addOrReplaceChild("f7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 56).mirror().addBox(5.0F, -28.75F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -30.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition f7head = f7.addOrReplaceChild("f7head", CubeListBuilder.create().texOffs(727, 11).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition fs7 = whistle_tail2_parent.addOrReplaceChild("fs7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 56).addBox(-11.0F, -28.75F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -30.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition fs7head = fs7.addOrReplaceChild("fs7head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition g7 = whistle_tail2_parent.addOrReplaceChild("g7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 60).addBox(-11.0F, -24.75F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -26.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -10.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition g7head = g7.addOrReplaceChild("g7head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition gs7 = whistle_tail2_parent.addOrReplaceChild("gs7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 64).addBox(-11.0F, -20.75F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -22.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 3.0F, -20.0F));

        PartDefinition gs7head = gs7.addOrReplaceChild("gs7head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition a7 = whistle_tail2_parent.addOrReplaceChild("a7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 68).addBox(-11.0F, -16.75F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -18.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -30.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition a7head = a7.addOrReplaceChild("a7head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition as7 = whistle_tail2_parent.addOrReplaceChild("as7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 72).addBox(-11.0F, -12.75F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -14.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -40.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition as7head = as7.addOrReplaceChild("as7head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition b7 = whistle_tail2_parent.addOrReplaceChild("b7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 76).addBox(-11.0F, -8.75F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -10.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -50.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition b7head = b7.addOrReplaceChild("b7head", CubeListBuilder.create().texOffs(727, 11).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition whistle_tail1_parent = tail1.addOrReplaceChild("whistle_tail1_parent", CubeListBuilder.create(), PartPose.offset(-11.75F, 4.0F, 22.0F));

        PartDefinition c3 = whistle_tail1_parent.addOrReplaceChild("c3", CubeListBuilder.create().texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(3.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 75).mirror().addBox(4.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(23.75F, 11.0F, -13.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition c3head = c3.addOrReplaceChild("c3head", CubeListBuilder.create().texOffs(656, 8).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition cs3 = whistle_tail1_parent.addOrReplaceChild("cs3", CubeListBuilder.create().texOffs(649, 103).addBox(3.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 79).mirror().addBox(4.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, 11.0F, -1.0F, 0.0F, 0.0F, 0.6981F));

        PartDefinition cs3head = cs3.addOrReplaceChild("cs3head", CubeListBuilder.create().texOffs(656, 8).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition d3 = whistle_tail1_parent.addOrReplaceChild("d3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-13.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 75).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 11.0F, -13.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition d3head = d3.addOrReplaceChild("d3head", CubeListBuilder.create().texOffs(656, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition ds3 = whistle_tail1_parent.addOrReplaceChild("ds3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-13.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 79).addBox(-12.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 11.0F, -1.0F, 0.0F, 0.0F, -0.6981F));

        PartDefinition ds3head = ds3.addOrReplaceChild("ds3head", CubeListBuilder.create().texOffs(656, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition e3 = whistle_tail1_parent.addOrReplaceChild("e3", CubeListBuilder.create().texOffs(656, 71).mirror().addBox(5.0F, -19.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 103).addBox(4.0F, -21.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(682, 131).addBox(1.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(22.75F, -5.0F, 11.0F));

        PartDefinition e3head = e3.addOrReplaceChild("e3head", CubeListBuilder.create().texOffs(656, 8).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(9.0F, 4.0F, 0.0F));

        PartDefinition f3 = whistle_tail1_parent.addOrReplaceChild("f3", CubeListBuilder.create().texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 75).mirror().addBox(4.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 103).addBox(3.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -5.0F, 23.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition f3head = f3.addOrReplaceChild("f3head", CubeListBuilder.create().texOffs(656, 8).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition fs3 = whistle_tail1_parent.addOrReplaceChild("fs3", CubeListBuilder.create().texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 79).mirror().addBox(4.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 103).addBox(3.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -5.0F, 35.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition fs3head = fs3.addOrReplaceChild("fs3head", CubeListBuilder.create().texOffs(656, 8).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition g3 = whistle_tail1_parent.addOrReplaceChild("g3", CubeListBuilder.create().texOffs(682, 131).mirror().addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(656, 83).mirror().addBox(4.0F, -7.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 103).addBox(3.0F, -9.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -5.0F, 47.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition g3head = g3.addOrReplaceChild("g3head", CubeListBuilder.create().texOffs(656, 8).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition gs3 = whistle_tail1_parent.addOrReplaceChild("gs3", CubeListBuilder.create().texOffs(682, 131).addBox(-12.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 71).addBox(-13.0F, -19.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-14.0F, -21.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, -5.0F, 11.0F));

        PartDefinition gs3head = gs3.addOrReplaceChild("gs3head", CubeListBuilder.create().texOffs(656, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-9.0F, 4.0F, 0.0F));

        PartDefinition a3 = whistle_tail1_parent.addOrReplaceChild("a3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-13.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 75).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, 23.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition a3head = a3.addOrReplaceChild("a3head", CubeListBuilder.create().texOffs(656, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition as3 = whistle_tail1_parent.addOrReplaceChild("as3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 79).addBox(-12.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-13.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, 35.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition as3head = as3.addOrReplaceChild("as3head", CubeListBuilder.create().texOffs(656, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition b3 = whistle_tail1_parent.addOrReplaceChild("b3", CubeListBuilder.create().texOffs(656, 83).addBox(-12.0F, -7.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-13.0F, -9.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, 47.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition b3head = b3.addOrReplaceChild("b3head", CubeListBuilder.create().texOffs(656, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition c4 = whistle_tail1_parent.addOrReplaceChild("c4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(619, 43).addBox(-4.0F, -56.0F, -4.0F, 8.0F, 52.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -58.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(11.75F, -18.0F, -13.0F));

        PartDefinition c4head = c4.addOrReplaceChild("c4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition cs4 = whistle_tail1_parent.addOrReplaceChild("cs4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -54.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 47).addBox(-4.0F, -52.0F, -4.0F, 8.0F, 48.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.75F, -18.0F, -1.0F));

        PartDefinition cs4head = cs4.addOrReplaceChild("cs4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition d4 = whistle_tail1_parent.addOrReplaceChild("d4", CubeListBuilder.create().texOffs(619, 51).addBox(-4.0F, -48.0F, -4.0F, 8.0F, 44.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 103).addBox(-5.0F, -50.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(11.75F, -18.0F, 11.0F));

        PartDefinition d4head = d4.addOrReplaceChild("d4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition ds4 = whistle_tail1_parent.addOrReplaceChild("ds4", CubeListBuilder.create().texOffs(649, 103).addBox(-5.0F, -66.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(619, 35).addBox(-4.0F, -64.0F, -4.0F, 8.0F, 60.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.75F, -18.0F, 23.0F));

        PartDefinition ds4head = ds4.addOrReplaceChild("ds4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition e4 = whistle_tail1_parent.addOrReplaceChild("e4", CubeListBuilder.create().texOffs(649, 103).addBox(-5.0F, -74.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 27).addBox(-4.0F, -72.0F, -4.0F, 8.0F, 68.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(11.75F, -18.0F, 35.0F));

        PartDefinition e4head = e4.addOrReplaceChild("e4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition f4 = whistle_tail1_parent.addOrReplaceChild("f4", CubeListBuilder.create().texOffs(649, 103).addBox(-5.0F, -78.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 23).addBox(-4.0F, -76.0F, -4.0F, 8.0F, 72.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(11.75F, -18.0F, 47.0F));

        PartDefinition f4head = f4.addOrReplaceChild("f4head", CubeListBuilder.create().texOffs(619, 8).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition gs2 = whistle_tail1_parent.addOrReplaceChild("gs2", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -30.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 39).addBox(-13.0F, -28.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition gs2head = gs2.addOrReplaceChild("gs2head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition a2 = whistle_tail1_parent.addOrReplaceChild("a2", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -34.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 35).mirror().addBox(3.0F, -32.0F, -5.0F, 10.0F, 32.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5F, 0.0F, -13.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition a2head = a2.addOrReplaceChild("a2head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, -1.0F, 0.0F));

        PartDefinition as2 = whistle_tail1_parent.addOrReplaceChild("as2", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -30.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 39).mirror().addBox(3.0F, -28.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5F, 0.0F, -1.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition as2head = as2.addOrReplaceChild("as2head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, -1.0F, 0.0F));

        PartDefinition b2 = whistle_tail1_parent.addOrReplaceChild("b2", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -34.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 35).addBox(-13.0F, -32.0F, -5.0F, 10.0F, 32.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition b2head = b2.addOrReplaceChild("b2head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition whistle_back_parent = body.addOrReplaceChild("whistle_back_parent", CubeListBuilder.create(), PartPose.offset(19.0F, -28.0F, -16.0F));

        PartDefinition c1 = whistle_back_parent.addOrReplaceChild("c1", CubeListBuilder.create().texOffs(569, 23).mirror().addBox(-5.0F, -43.0F, -5.0F, 10.0F, 44.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(561, 77).addBox(-6.0F, -45.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-8.0F, -6.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition c1head = c1.addOrReplaceChild("c1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cs1 = whistle_back_parent.addOrReplaceChild("cs1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -31.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 31).mirror().addBox(3.0F, -29.0F, -5.0F, 10.0F, 36.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -6.0F, 14.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cs1head = cs1.addOrReplaceChild("cs1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition d1 = whistle_back_parent.addOrReplaceChild("d1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -23.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 39).mirror().addBox(3.0F, -21.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -6.0F, 28.0F));

        PartDefinition d1head = d1.addOrReplaceChild("d1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition ds1 = whistle_back_parent.addOrReplaceChild("ds1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -22.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 47).mirror().addBox(3.0F, -20.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 1.0F, 42.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition ds1head = ds1.addOrReplaceChild("ds1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, -1.0F, 0.0F));

        PartDefinition e1 = whistle_back_parent.addOrReplaceChild("e1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -7.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 55).mirror().addBox(3.0F, -5.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 42.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition e1head = e1.addOrReplaceChild("e1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition f1 = whistle_back_parent.addOrReplaceChild("f1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -11.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 51).mirror().addBox(3.0F, -9.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 28.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition f1head = f1.addOrReplaceChild("f1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition fs1 = whistle_back_parent.addOrReplaceChild("fs1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -15.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 47).mirror().addBox(3.0F, -13.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition fs1head = fs1.addOrReplaceChild("fs1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition g1 = whistle_back_parent.addOrReplaceChild("g1", CubeListBuilder.create().texOffs(561, 77).addBox(2.0F, -19.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 43).mirror().addBox(3.0F, -17.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition g1head = g1.addOrReplaceChild("g1head", CubeListBuilder.create().texOffs(569, 6).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition gs1 = whistle_back_parent.addOrReplaceChild("gs1", CubeListBuilder.create().texOffs(716, 127).addBox(-4.0F, -6.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(569, 23).addBox(-5.0F, -43.0F, -5.0F, 10.0F, 44.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(561, 77).addBox(-6.0F, -45.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition gs1head = gs1.addOrReplaceChild("gs1head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition a1 = whistle_back_parent.addOrReplaceChild("a1", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -31.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 31).addBox(-13.0F, -29.0F, -5.0F, 10.0F, 36.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, -6.0F, 14.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition a1head = a1.addOrReplaceChild("a1head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition as1 = whistle_back_parent.addOrReplaceChild("as1", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -23.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 39).addBox(-13.0F, -21.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, -6.0F, 28.0F));

        PartDefinition as1head = as1.addOrReplaceChild("as1head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition b1 = whistle_back_parent.addOrReplaceChild("b1", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -22.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 47).addBox(-13.0F, -20.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, 1.0F, 42.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition b1head = b1.addOrReplaceChild("b1head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition c2 = whistle_back_parent.addOrReplaceChild("c2", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -7.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 55).addBox(-13.0F, -5.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 42.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition c2head = c2.addOrReplaceChild("c2head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition cs2 = whistle_back_parent.addOrReplaceChild("cs2", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -11.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 51).addBox(-13.0F, -9.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 28.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cs2head = cs2.addOrReplaceChild("cs2head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition d2 = whistle_back_parent.addOrReplaceChild("d2", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -15.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 47).addBox(-13.0F, -13.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 14.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition d2head = d2.addOrReplaceChild("d2head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition ds2 = whistle_back_parent.addOrReplaceChild("ds2", CubeListBuilder.create().texOffs(561, 77).addBox(-14.0F, -19.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 43).addBox(-13.0F, -17.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition ds2head = ds2.addOrReplaceChild("ds2head", CubeListBuilder.create().texOffs(569, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition e2 = whistle_back_parent.addOrReplaceChild("e2", CubeListBuilder.create().texOffs(725, 143).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(524, 55).addBox(-5.0F, -16.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(561, 77).addBox(-6.0F, -18.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -7.0F, 0.0F));

        PartDefinition e2head = e2.addOrReplaceChild("e2head", CubeListBuilder.create().texOffs(524, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition f2 = whistle_back_parent.addOrReplaceChild("f2", CubeListBuilder.create().texOffs(725, 143).addBox(-12.0F, -11.0F, 4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(524, 47).addBox(-13.0F, -24.0F, 3.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(561, 77).addBox(-14.0F, -26.0F, 2.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -7.0F, 6.0F));

        PartDefinition f2head = f2.addOrReplaceChild("f2head", CubeListBuilder.create().texOffs(524, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -5.0F, 8.0F));

        PartDefinition fs2 = whistle_back_parent.addOrReplaceChild("fs2", CubeListBuilder.create().texOffs(725, 143).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(561, 77).addBox(-6.0F, -34.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(524, 39).addBox(-5.0F, -32.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -7.0F, 28.0F));

        PartDefinition fs2head = fs2.addOrReplaceChild("fs2head", CubeListBuilder.create().texOffs(524, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition g2 = whistle_back_parent.addOrReplaceChild("g2", CubeListBuilder.create().texOffs(561, 77).addBox(-6.0F, -42.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(524, 31).addBox(-5.0F, -40.0F, -5.0F, 10.0F, 36.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(725, 143).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -7.0F, 42.0F));

        PartDefinition g2head = g2.addOrReplaceChild("g2head", CubeListBuilder.create().texOffs(524, 6).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(502, 100).addBox(-16.0F, -64.0F, -16.0F, 32.0F, 64.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 80.0F, 2.0F));

        PartDefinition leg_l = root_util.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(370, 341).addBox(20.25F, -17.0F, -13.0F, 8.0F, 33.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -80.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r36 = leg_l.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 652).addBox(-18.0F, -4.0F, -13.0F, 18.0F, 46.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, -14.0F, 2.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create(), PartPose.offsetAndRotation(30.0F, 28.0F, -5.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r37 = leg_l2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(342, 509).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r38 = leg_l2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(560, 736).addBox(-1.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(560, 736).addBox(7.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 39.0F, 10.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r39 = leg_l2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(133, 240).addBox(-6.0F, -40.0F, 2.0F, 11.0F, 40.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(133, 240).addBox(-6.0F, -42.0F, -15.0F, 11.0F, 42.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(428, 674).addBox(-4.5F, -40.0F, -13.0F, 8.0F, 40.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 39.0F, 10.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition foot_l = leg_l2.addOrReplaceChild("foot_l", CubeListBuilder.create().texOffs(0, 814).addBox(-3.0F, -4.5F, -8.5F, 6.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition toe_front_l = foot_l.addOrReplaceChild("toe_front_l", CubeListBuilder.create().texOffs(768, 643).addBox(-9.0F, -2.0F, -11.0F, 18.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -8.5F));

        PartDefinition toe_rear_l = foot_l.addOrReplaceChild("toe_rear_l", CubeListBuilder.create().texOffs(133, 284).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 9.5F));

        PartDefinition leg_r = root_util.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(370, 341).mirror().addBox(-28.25F, -17.0F, -13.0F, 8.0F, 33.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -80.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r40 = leg_r.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 652).addBox(0.0F, -4.0F, -13.0F, 18.0F, 46.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.0F, -14.0F, 2.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(-30.0F, 28.0F, -5.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r41 = leg_r2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(342, 509).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r42 = leg_r2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(560, 736).addBox(-1.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(560, 736).addBox(-9.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, 10.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r43 = leg_r2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(133, 240).addBox(-5.0F, -40.0F, 2.0F, 11.0F, 40.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(133, 240).addBox(-5.0F, -42.0F, -15.0F, 11.0F, 42.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(428, 674).addBox(-3.5F, -40.0F, -13.0F, 8.0F, 40.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 39.0F, 10.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition foot_r = leg_r2.addOrReplaceChild("foot_r", CubeListBuilder.create().texOffs(0, 814).addBox(-3.0F, -4.5F, -8.5F, 6.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition toe_front_r = foot_r.addOrReplaceChild("toe_front_r", CubeListBuilder.create().texOffs(768, 643).mirror().addBox(-9.0F, -2.0F, -11.0F, 18.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.5F, -8.5F));

        PartDefinition toe_rear_r = foot_r.addOrReplaceChild("toe_rear_r", CubeListBuilder.create().texOffs(133, 284).mirror().addBox(-4.0F, -2.0F, -2.0F, 8.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.5F, 9.5F));

        PartDefinition steam_foot = leg_r2.addOrReplaceChild("steam_foot", CubeListBuilder.create(), PartPose.offset(-3.0F, 46.5F, -3.5F));

        PartDefinition steam_foot_r1 = steam_foot.addOrReplaceChild("steam_foot_r1", CubeListBuilder.create().texOffs(-16, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.8906F, -0.422F, 2.2507F));

        PartDefinition steam_foot_r2 = steam_foot.addOrReplaceChild("steam_foot_r2", CubeListBuilder.create().texOffs(-16, 0).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.1817F, -1.0472F, -1.5708F));

        return LayerDefinition.create(meshdefinition, 1024, 1024);
    }
    @Override
    public void setupAnim(OrganEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OrganAnimations.organ_walk, limbSwing, limbSwingAmount, 1f, 2f);

        this.animate(entity.idleAnimationState, OrganAnimations.organ_idle, ageInTicks, 1f);

        this.animate(entity.sitDownAnimationState, OrganAnimations.organ_sit_l, ageInTicks, 1.0F);
        this.animate(entity.sitPoseAnimationState, OrganAnimations.organ_stay_l, ageInTicks, 1.0F);
        this.animate(entity.sitUpAnimationState, OrganAnimations.organ_stand_l, ageInTicks, 1.0F);

        blink.visible = entity.blinkCountdown > 0;

        steam_neck.visible = entity.showPuff1;
        steam_chest.visible = entity.showPuff2;
        steam_foot.visible = entity.showPuff3;
        steam_4.visible = entity.showPuff4;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
