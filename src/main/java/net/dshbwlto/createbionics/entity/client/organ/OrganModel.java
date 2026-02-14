package net.dshbwlto.createbionics.entity.client.organ;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.client.organ.layers.OrganVariant;
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

    public final ModelPart body;
    public final ModelPart chest;
    public final ModelPart neck;
    private final ModelPart head;
    public final ModelPart tail1;
    public final ModelPart tail2;
    private final ModelPart leg_l;
    private final ModelPart leg_l2;
    private final ModelPart foot_l;
    private final ModelPart leg_r;
    private final ModelPart leg_r2;
    private final ModelPart foot_r;

    private final ModelPart stand;

    private final ModelPart piston_l1;
    private final ModelPart piston_l2;
    private final ModelPart piston_l3;
    private final ModelPart piston_l4;
    private final ModelPart piston_r1;
    private final ModelPart piston_r2;
    private final ModelPart piston_r3;
    private final ModelPart piston_r4;
    private final ModelPart bellows_l;
    private final ModelPart bellows_r;
    private final ModelPart blink;
    private final ModelPart dial;

    private final ModelPart steam_head;
    private final ModelPart steam_face;
    private final ModelPart steam_tail;

    public OrganModel(ModelPart root) {
        this.root = root.getChild("root");

        this.body = this.root.getChild("root_util").getChild("body");
        this.chest = this.root.getChild("root_util").getChild("body").getChild("chest");
        this.stand = this.root.getChild("root_util").getChild("body").getChild("stand");
        this.neck = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck");
        this.head = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head");
        this.tail1 = this.root.getChild("root_util").getChild("body").getChild("tail1");
        this.tail2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2");
        this.leg_l = this.root.getChild("root_util").getChild("leg_l");
        this.leg_l2 = this.root.getChild("root_util").getChild("leg_l").getChild("leg_l2");
        this.foot_l = this.root.getChild("root_util").getChild("leg_l").getChild("leg_l2").getChild("foot_l");
        this.leg_r = this.root.getChild("root_util").getChild("leg_r");
        this.leg_r2 = this.root.getChild("root_util").getChild("leg_r").getChild("leg_r2");
        this.foot_r = this.root.getChild("root_util").getChild("leg_r").getChild("leg_r2").getChild("foot_r");

        this.piston_l1 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l1");
        this.piston_l2 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l2");
        this.piston_l3 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l3");
        this.piston_l4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_l").getChild("piston_l4");
        this.piston_r1 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r1");
        this.piston_r2 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r2");
        this.piston_r3 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r3");
        this.piston_r4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("piston_parent_r").getChild("piston_r4");
        this.bellows_l = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("bellows_l");
        this.bellows_r = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("bellows_r");
        this.blink = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("blink");
        this.dial = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("dial");

        this.steam_head = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("exhaust").getChild("steam_head");
        this.steam_face = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("face").getChild("steam_face");
        this.steam_tail = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("steam_tail");
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
                .texOffs(422, 218).addBox(-9.0F, 18.0F, -52.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(422, 218).mirror().addBox(7.0F, 18.0F, -52.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -7.0F, -54.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r14 = neck.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(422, 218).addBox(-1.0F, 12.0F, -46.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(422, 218).addBox(13.0F, 12.0F, -46.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 13.0F, -6.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r15 = neck.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(584, 425).addBox(-1.5F, 10.0F, -46.0F, 6.0F, 6.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 20.0F, -6.0F, 0.0436F, 0.0262F, -0.1309F));

        PartDefinition cube_r16 = neck.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(584, 425).addBox(-4.5F, 10.0F, -46.0F, 6.0F, 6.0F, 69.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 20.0F, -6.0F, 0.0436F, -0.0262F, 0.1309F));

        PartDefinition steam_neck = neck.addOrReplaceChild("steam_neck", CubeListBuilder.create(), PartPose.offset(-12.0F, 26.0F, -3.0F));

        PartDefinition steam_2_r1 = steam_neck.addOrReplaceChild("steam_2_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, -2.1817F));

        PartDefinition steam_2_r2 = steam_neck.addOrReplaceChild("steam_2_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, -0.7854F, 0.9599F));

        PartDefinition steam_3_r1 = steam_neck.addOrReplaceChild("steam_3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -5.0F, -19.0F, 3.1416F, 0.7854F, -1.7453F));

        PartDefinition steam_3_r2 = steam_neck.addOrReplaceChild("steam_3_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -5.0F, -19.0F, 0.0F, 0.7854F, 1.3963F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(150, 159).addBox(-14.0F, -6.0F, -24.0F, 28.0F, 26.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(259, 379).addBox(-12.0F, -12.0F, -38.0F, 24.0F, 20.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 21.0F, -41.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition face1_r1 = head.addOrReplaceChild("face1_r1", CubeListBuilder.create().texOffs(734, 470).addBox(-28.0F, 0.0F, -14.0F, 28.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -6.0F, -24.0F, 0.0F, 0.0002F, 0.0F));

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

        PartDefinition cube_r19 = face.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.306F, 31.7496F, -1.7271F, 0.8742F, -1.1512F));

        PartDefinition cube_r20 = face.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.306F, 31.7496F, -0.6906F, 0.1F, 0.5399F));

        PartDefinition cube_r21 = face.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.306F, 20.7496F, -1.7271F, 0.8742F, -1.9366F));

        PartDefinition cube_r22 = face.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.306F, 20.7496F, -0.6906F, 0.1F, -0.2455F));

        PartDefinition cube_r23 = face.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.694F, 7.7496F, -0.855F, 0.647F, -0.3079F));

        PartDefinition cube_r24 = face.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.694F, 7.7496F, -2.3568F, 0.551F, -2.3616F));

        PartDefinition cube_r25 = face.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.694F, -5.2504F, -2.5586F, 0.6956F, -2.4799F));

        PartDefinition cube_r26 = face.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.694F, -5.2504F, -0.583F, 0.6956F, -0.1381F));

        PartDefinition cube_r27 = face.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.694F, -15.2504F, -0.583F, -0.6956F, 0.0508F));

        PartDefinition cube_r28 = face.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.694F, -15.2504F, -2.5586F, -0.6956F, 2.3927F));

        PartDefinition cube_r29 = face.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(718, 500).addBox(-12.0F, 0.0F, -30.0F, 24.0F, 22.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r30 = face.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(416, 293).addBox(-14.0F, 0.0F, -25.0F, 28.0F, 16.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 6.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition steam_face = face.addOrReplaceChild("steam_face", CubeListBuilder.create(), PartPose.offset(-14.0F, 18.5F, -5.0F));

        PartDefinition steam7_r1 = steam_face.addOrReplaceChild("steam7_r1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7743F, 0.0192F, -0.8342F));

        PartDefinition steam7_r2 = steam_face.addOrReplaceChild("steam7_r2", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5433F, -0.7963F, 0.717F));

        PartDefinition steam7_r3 = steam_face.addOrReplaceChild("steam7_r3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(28.0F, 0.0F, 0.0F, -1.5433F, 0.7963F, -0.717F));

        PartDefinition steam7_r4 = steam_face.addOrReplaceChild("steam7_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.0F, 0.0F, 0.0F, -0.7743F, -0.0192F, 0.8342F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 14.0F, -16.0F));

        PartDefinition cube_r31 = jaw.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(323, 438).addBox(-12.0F, 0.0F, 0.0F, 24.0F, 11.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -19.0F, 0.0436F, 0.0F, 0.0F));

        PartDefinition jaw_front = jaw.addOrReplaceChild("jaw_front", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -19.0F));

        PartDefinition cube_r32 = jaw_front.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(734, 417).addBox(0.0F, 7.0F, -23.0F, 4.0F, 7.0F, 46.0F, new CubeDeformation(0.0F))
                .texOffs(734, 417).addBox(-14.0F, 7.0F, -23.0F, 4.0F, 7.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r33 = jaw_front.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(718, 552).addBox(-12.0F, 0.0F, -26.0F, 24.0F, 11.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bellows_l = chest.addOrReplaceChild("bellows_l", CubeListBuilder.create().texOffs(164, 583).addBox(1.0F, 3.0F, -49.0F, 26.0F, 13.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(586, 502).addBox(1.0F, 3.0F, 7.0F, 26.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(84, 440).addBox(-4.5F, -1.0F, 14.0F, 38.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 519).addBox(-4.0F, 1.0F, -45.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -30.0F, -12.0F, 0.0F, 0.0F, 0.6545F));

        PartDefinition bellows_bottom_l = bellows_l.addOrReplaceChild("bellows_bottom_l", CubeListBuilder.create().texOffs(804, 627).addBox(-12.0F, 0.9F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(16.5F, -0.1F, -45.0F));

        PartDefinition cube_r34 = bellows_bottom_l.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r35 = bellows_bottom_l.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition top_l = bellows_l.addOrReplaceChild("top_l", CubeListBuilder.create().texOffs(0, 519).addBox(-20.5F, -2.9F, -61.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offset(16.5F, 0.9F, 16.0F));

        PartDefinition bellows_top_l = top_l.addOrReplaceChild("bellows_top_l", CubeListBuilder.create().texOffs(804, 627).addBox(-12.0F, -2.1F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -61.0F));

        PartDefinition cube_r36 = bellows_top_l.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r37 = bellows_top_l.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition bellows_fabric_l = bellows_l.addOrReplaceChild("bellows_fabric_l", CubeListBuilder.create().texOffs(0, 320).addBox(-16.5F, -56.792F, 7.7442F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F))
                .texOffs(0, 320).mirror().addBox(18.5F, -56.792F, 7.7442F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.5F, 0.8F, -52.45F));

        PartDefinition bellows_fabric_l1 = bellows_fabric_l.addOrReplaceChild("bellows_fabric_l1", CubeListBuilder.create().texOffs(14, 136).addBox(-7.8211F, -55.9F, -6.8211F, 21.0F, 59.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, -0.892F, 7.4942F));

        PartDefinition cube_r38 = bellows_fabric_l1.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 224).addBox(-12.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0992F, 0.1F, -1.8713F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r39 = bellows_fabric_l1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 224).mirror().addBox(2.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.4008F, 0.1F, -1.8713F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bellows_r = chest.addOrReplaceChild("bellows_r", CubeListBuilder.create().texOffs(164, 583).addBox(-27.0F, 3.0F, -49.0F, 26.0F, 13.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(586, 502).addBox(-27.0F, 3.0F, 7.0F, 26.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(84, 440).addBox(-33.5F, -1.0F, 14.0F, 38.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 519).addBox(-33.0F, 1.0F, -45.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -30.0F, -12.0F, 0.0F, 0.0F, -0.6545F));

        PartDefinition bellows_bottom_r = bellows_r.addOrReplaceChild("bellows_bottom_r", CubeListBuilder.create().texOffs(804, 627).addBox(-8.0F, 0.9F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.5F, -0.1F, -45.0F));

        PartDefinition cube_r40 = bellows_bottom_r.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r41 = bellows_bottom_r.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 1.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition top_r = bellows_r.addOrReplaceChild("top_r", CubeListBuilder.create().texOffs(0, 519).addBox(-16.5F, -2.9F, -61.0F, 37.0F, 3.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offset(-16.5F, 0.9F, 16.0F));

        PartDefinition bellows_top_r = top_r.addOrReplaceChild("bellows_top_r", CubeListBuilder.create().texOffs(804, 627).addBox(-8.0F, -2.1F, -8.45F, 20.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -61.0F));

        PartDefinition cube_r42 = bellows_top_r.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(139, 334).addBox(-12.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r43 = bellows_top_r.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(139, 334).addBox(0.0F, 0.0F, -12.0F, 12.0F, 3.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition bellows_fabric_r = bellows_r.addOrReplaceChild("bellows_fabric_r", CubeListBuilder.create().texOffs(0, 320).addBox(-18.5F, -58.8F, 14.45F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F))
                .texOffs(0, 320).mirror().addBox(16.5F, -58.8F, 14.45F, 0.0F, 59.0F, 61.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.5F, 0.8F, -59.45F));

        PartDefinition bellows_fabric_r1 = bellows_fabric_r.addOrReplaceChild("bellows_fabric_r1", CubeListBuilder.create().texOffs(14, 136).addBox(-13.1789F, -55.9F, -6.8211F, 21.0F, 59.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -2.9F, 14.2F));

        PartDefinition cube_r44 = bellows_fabric_r1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 224).mirror().addBox(2.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0992F, 0.1F, -1.8713F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r45 = bellows_fabric_r1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 224).addBox(-12.0F, -56.0F, -9.0F, 10.0F, 59.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4008F, 0.1F, -1.8713F, 0.0F, 0.7854F, 0.0F));

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

        PartDefinition steam_exhaust_b_r9 = steam_tail.addOrReplaceChild("steam_exhaust_b_r9", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 27.0F, -2.8598F, 0.5161F, -1.0488F));

        PartDefinition steam_exhaust_b_r10 = steam_tail.addOrReplaceChild("steam_exhaust_b_r10", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 27.0F, -0.4557F, 0.989F, 1.5623F));

        PartDefinition steam_exhaust_b_r11 = steam_tail.addOrReplaceChild("steam_exhaust_b_r11", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 18.0F, -2.9861F, 0.6555F, -1.1188F));

        PartDefinition steam_exhaust_b_r12 = steam_tail.addOrReplaceChild("steam_exhaust_b_r12", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 18.0F, -0.1988F, 0.8998F, 1.771F));

        PartDefinition steam_exhaust_b_r13 = steam_tail.addOrReplaceChild("steam_exhaust_b_r13", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 9.0F, 2.9428F, 0.8998F, -1.3706F));

        PartDefinition steam_exhaust_b_r14 = steam_tail.addOrReplaceChild("steam_exhaust_b_r14", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 0.0F, 0.2818F, 0.5161F, 2.0928F));

        PartDefinition steam_exhaust_b_r15 = steam_tail.addOrReplaceChild("steam_exhaust_b_r15", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 0.0F, 2.6859F, 0.989F, -1.5793F));

        PartDefinition steam_exhaust_b_r16 = steam_tail.addOrReplaceChild("steam_exhaust_b_r16", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 9.0F, 0.1555F, 0.6555F, 2.0228F));

        PartDefinition steam_exhaust_b_r17 = steam_tail.addOrReplaceChild("steam_exhaust_b_r17", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 0.0F, 2.6859F, -0.989F, 1.5793F));

        PartDefinition steam_exhaust_b_r18 = steam_tail.addOrReplaceChild("steam_exhaust_b_r18", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 0.0F, 0.2818F, -0.5161F, -2.0928F));

        PartDefinition steam_exhaust_b_r19 = steam_tail.addOrReplaceChild("steam_exhaust_b_r19", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 9.0F, 0.1555F, -0.6555F, -2.0228F));

        PartDefinition steam_exhaust_b_r20 = steam_tail.addOrReplaceChild("steam_exhaust_b_r20", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 9.0F, 2.9428F, -0.8998F, 1.3706F));

        PartDefinition steam_exhaust_b_r21 = steam_tail.addOrReplaceChild("steam_exhaust_b_r21", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 18.0F, -2.9861F, -0.6555F, 1.1188F));

        PartDefinition steam_exhaust_b_r22 = steam_tail.addOrReplaceChild("steam_exhaust_b_r22", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 18.0F, -0.1988F, -0.8998F, -1.771F));

        PartDefinition steam_exhaust_b_r23 = steam_tail.addOrReplaceChild("steam_exhaust_b_r23", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 27.0F, -0.4557F, -0.989F, -1.5623F));

        PartDefinition steam_exhaust_b_r24 = steam_tail.addOrReplaceChild("steam_exhaust_b_r24", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 27.0F, -2.8598F, -0.5161F, 1.0488F));

        PartDefinition steam_exhaust_b_r25 = steam_tail.addOrReplaceChild("steam_exhaust_b_r25", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 0.2818F, -0.5161F, -2.5292F));

        PartDefinition steam_exhaust_b_r26 = steam_tail.addOrReplaceChild("steam_exhaust_b_r26", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 2.6859F, -0.989F, 1.143F));

        PartDefinition steam_exhaust_b_r27 = steam_tail.addOrReplaceChild("steam_exhaust_b_r27", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 9.0F, 2.9428F, -0.8998F, 0.9342F));

        PartDefinition steam_exhaust_b_r28 = steam_tail.addOrReplaceChild("steam_exhaust_b_r28", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 9.0F, 0.1555F, -0.6555F, -2.4591F));

        PartDefinition steam_exhaust_b_r29 = steam_tail.addOrReplaceChild("steam_exhaust_b_r29", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 18.0F, -0.1988F, -0.8998F, -2.2074F));

        PartDefinition steam_exhaust_b_r30 = steam_tail.addOrReplaceChild("steam_exhaust_b_r30", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 18.0F, -2.9861F, -0.6555F, 0.6825F));

        PartDefinition steam_exhaust_b_r31 = steam_tail.addOrReplaceChild("steam_exhaust_b_r31", CubeListBuilder.create().texOffs(0, 16).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 27.0F, -0.4557F, -0.989F, -1.9986F));

        PartDefinition steam_exhaust_b_r32 = steam_tail.addOrReplaceChild("steam_exhaust_b_r32", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 27.0F, -2.8598F, -0.5161F, 0.6124F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -5.0F, 16.0F, 23.0F, 98.0F, new CubeDeformation(0.0F))
                .texOffs(186, 557).addBox(-11.0F, -11.0F, 86.0F, 22.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 121).addBox(-11.0F, 15.0F, -5.0F, 22.0F, 3.0F, 98.0F, new CubeDeformation(0.0F))
                .texOffs(0, 222).addBox(-11.0F, -14.0F, 0.0F, 22.0F, 12.0F, 86.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 78.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(528, 311).addBox(-16.0F, -64.0F, -16.0F, 32.0F, 64.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 80.0F, 2.0F));

        PartDefinition leg_l = root_util.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(370, 341).addBox(20.25F, -17.0F, -13.0F, 8.0F, 33.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -80.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r46 = leg_l.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 652).addBox(-18.0F, -4.0F, -13.0F, 18.0F, 46.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, -14.0F, 2.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create(), PartPose.offsetAndRotation(30.0F, 28.0F, -5.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r47 = leg_l2.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(342, 509).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r48 = leg_l2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(560, 736).addBox(-1.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(560, 736).addBox(7.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 39.0F, 10.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r49 = leg_l2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(133, 240).addBox(-6.0F, -40.0F, 2.0F, 11.0F, 40.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(133, 240).addBox(-6.0F, -42.0F, -15.0F, 11.0F, 42.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(428, 674).addBox(-4.5F, -40.0F, -13.0F, 8.0F, 40.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 39.0F, 10.0F, 0.0873F, 0.0F, 0.0F));

        PartDefinition foot_l = leg_l2.addOrReplaceChild("foot_l", CubeListBuilder.create().texOffs(0, 814).addBox(-3.0F, -4.5F, -8.5F, 6.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition toe_front_l = foot_l.addOrReplaceChild("toe_front_l", CubeListBuilder.create().texOffs(768, 643).addBox(-9.0F, -2.0F, -11.0F, 18.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -8.5F));

        PartDefinition toe_rear_l = foot_l.addOrReplaceChild("toe_rear_l", CubeListBuilder.create().texOffs(133, 284).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 9.5F));

        PartDefinition leg_r = root_util.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(370, 341).mirror().addBox(-28.25F, -17.0F, -13.0F, 8.0F, 33.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -80.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r50 = leg_r.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 652).addBox(0.0F, -4.0F, -13.0F, 18.0F, 46.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.0F, -14.0F, 2.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(-30.0F, 28.0F, -5.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r51 = leg_r2.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(342, 509).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 50.5F, 0.5F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r52 = leg_r2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(560, 736).addBox(-1.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(560, 736).addBox(-9.0F, -19.0F, -8.0F, 2.0F, 38.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 39.0F, 10.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r53 = leg_r2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(133, 240).addBox(-5.0F, -40.0F, 2.0F, 11.0F, 40.0F, 2.0F, new CubeDeformation(0.0F))
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

        if (entity.getAssembly() > 20) {
            this.animate(entity.idleAnimationState, OrganAnimations.organ_idle, ageInTicks, 1f);
        } else {
            this.animate(entity.idleAnimationState, OrganAnimations.organ_assembly, ageInTicks, 1f);
        }
            this.animate(entity.sitDownAnimationState, OrganAnimations.organ_sit_l, ageInTicks, 1.0F);
            this.animate(entity.sitPoseAnimationState, OrganAnimations.organ_stay_l, ageInTicks, 1.0F);
            this.animate(entity.sitUpAnimationState, OrganAnimations.organ_stand_l, ageInTicks, 1.0F);

        blink.visible = entity.blinkCountdown > 0;

        leg_l.visible = entity.getAssembly() > 0;
        leg_r.visible = entity.getAssembly() > 1;
        leg_l2.visible = entity.getAssembly() > 2;
        leg_r2.visible = entity.getAssembly() > 3;
        foot_l.visible = entity.getAssembly() > 4;
        foot_r.visible = entity.getAssembly() > 5;
        tail1.visible = entity.getAssembly() > 6;
        tail2.visible = entity.getAssembly() > 7;
        chest.visible = entity.getAssembly() > 8;
        piston_l1.visible = entity.getAssembly() > 9;
        piston_l2.visible = entity.getAssembly() > 10;
        piston_l3.visible = entity.getAssembly() > 11;
        piston_l4.visible = entity.getAssembly() > 12;
        piston_r1.visible = entity.getAssembly() > 13;
        piston_r2.visible = entity.getAssembly() > 14;
        piston_r3.visible = entity.getAssembly() > 15;
        piston_r4.visible = entity.getAssembly() > 16;
        bellows_l.visible = entity.getAssembly() > 17;
        bellows_r.visible = entity.getAssembly() > 18;
        neck.visible = entity.getAssembly() > 19;
        head.visible = entity.getAssembly() > 20;

        stand.visible = entity.getAssembly() < 21;

        float ySwing = (float) Math.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 16) / 16 ;
        float ySwing2 = (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 16) - 2) / 16 ;

        tail1.yRot = ySwing;
        tail2.yRot = ySwing2;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.neck.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.chest.yRot = pNetHeadYaw * ((float)Math.PI / 180F);

        this.tail1.yRot = pNetHeadYaw * -((float)Math.PI / 180F);
        this.tail1.yRot = pNetHeadYaw * -((float)Math.PI / 180F);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
