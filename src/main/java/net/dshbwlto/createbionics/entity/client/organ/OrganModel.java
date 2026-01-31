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

    private final ModelPart c1;
    private final ModelPart cs1;
    private final ModelPart d1;
    private final ModelPart ds1;
    private final ModelPart e1;
    private final ModelPart f1;
    private final ModelPart fs1;
    private final ModelPart g1;
    private final ModelPart gs1;
    private final ModelPart a1;
    private final ModelPart as1;
    private final ModelPart b1;

    private final ModelPart c2;
    private final ModelPart cs2;
    private final ModelPart d2;
    private final ModelPart ds2;
    private final ModelPart e2;
    private final ModelPart f2;
    private final ModelPart fs2;
    private final ModelPart g2;
    private final ModelPart gs2;
    private final ModelPart a2;
    private final ModelPart as2;
    private final ModelPart b2;

    private final ModelPart c3;
    private final ModelPart cs3;
    private final ModelPart d3;
    private final ModelPart ds3;
    private final ModelPart e3;
    private final ModelPart f3;
    private final ModelPart fs3;
    private final ModelPart g3;
    private final ModelPart gs3;
    private final ModelPart a3;
    private final ModelPart as3;
    private final ModelPart b3;

    private final ModelPart c4;
    private final ModelPart cs4;
    private final ModelPart d4;
    private final ModelPart ds4;
    private final ModelPart e4;
    private final ModelPart f4;
    private final ModelPart fs4;
    private final ModelPart g4;
    private final ModelPart gs4;
    private final ModelPart a4;
    private final ModelPart as4;
    private final ModelPart b4;

    private final ModelPart c5;
    private final ModelPart cs5;
    private final ModelPart d5;
    private final ModelPart ds5;
    private final ModelPart e5;
    private final ModelPart f5;
    private final ModelPart fs5;
    private final ModelPart g5;
    private final ModelPart gs5;
    private final ModelPart a5;
    private final ModelPart as5;
    private final ModelPart b5;

    private final ModelPart c6;
    private final ModelPart cs6;
    private final ModelPart d6;
    private final ModelPart ds6;
    private final ModelPart e6;
    private final ModelPart f6;
    private final ModelPart fs6;
    private final ModelPart g6;
    private final ModelPart gs6;
    private final ModelPart a6;
    private final ModelPart as6;
    private final ModelPart b6;

    private final ModelPart c7;
    private final ModelPart cs7;
    private final ModelPart d7;
    private final ModelPart ds7;
    private final ModelPart e7;
    private final ModelPart f7;
    private final ModelPart fs7;
    private final ModelPart g7;
    private final ModelPart gs7;
    private final ModelPart a7;
    private final ModelPart as7;
    private final ModelPart b7;

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

        this.c1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("c1");
        this.cs1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("cs1");
        this.d1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("d1");
        this.ds1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("ds1");
        this.e1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("e1");
        this.f1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("f1");
        this.fs1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("fs1");
        this.g1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("g1");
        this.gs1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("gs1");
        this.a1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("a1");
        this.as1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("as1");
        this.b1 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("b1");

        this.c2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("c2");
        this.cs2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("cs2");
        this.d2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("d2");
        this.ds2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("ds2");
        this.e2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("e2");
        this.f2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("f2");
        this.fs2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("fs2");
        this.g2 = this.root.getChild("root_util").getChild("body").getChild("whistle_back_parent").getChild("g2");
        this.gs2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("gs2");
        this.a2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("a2");
        this.as2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("as2");
        this.b2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("b2");

        this.c3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("c3");
        this.cs3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("cs3");
        this.d3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("d3");
        this.ds3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("ds3");
        this.e3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("e3");
        this.f3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("f3");
        this.fs3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("fs3");
        this.g3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("g3");
        this.gs3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("gs3");
        this.a3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("a3");
        this.as3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("as3");
        this.b3 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("b3");

        this.c4 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("c4");
        this.cs4 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("cs4");
        this.d4 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("d4");
        this.ds4 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("ds4");
        this.e4 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("e4");
        this.f4 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("whistle_tail1_parent").getChild("f4");
        this.fs4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("whistle_chest_parent").getChild("fs4");
        this.g4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("whistle_chest_parent").getChild("g4");
        this.gs4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("whistle_chest_parent").getChild("gs4");
        this.a4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("whistle_chest_parent").getChild("a4");
        this.as4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("whistle_chest_parent").getChild("as4");
        this.b4 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("whistle_chest_parent").getChild("b4");

        this.c5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("c5");
        this.cs5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("cs5");
        this.d5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("d5");
        this.ds5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("ds5");
        this.e5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("e5");
        this.f5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("f5");
        this.fs5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("fs5");
        this.g5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("g5");
        this.gs5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("gs5");
        this.a5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("a5");
        this.as5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("as5");
        this.b5 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("b5");
        this.c6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("c6");
        this.cs6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("cs6");
        this.d6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("d6");
        this.ds6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("ds6");
        this.e6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("e6");
        this.f6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("f6");
        this.fs6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("fs6");
        this.g6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("g6");
        this.gs6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("gs6");
        this.a6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("a6");
        this.as6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("as6");
        this.b6 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("b6");

        this.c7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("c7");
        this.cs7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("cs7");
        this.d7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("d7");
        this.ds7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("ds7");
        this.e7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("e7");
        this.f7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("f7");
        this.fs7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("fs7");
        this.g7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("g7");
        this.gs7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("gs7");
        this.a7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("a7");
        this.as7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("as7");
        this.b7 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2").getChild("whistle_tail2_parent").getChild("b7");
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

        PartDefinition bellows_l = chest.addOrReplaceChild("bellows_l", CubeListBuilder.create().texOffs(164, 583).addBox(1.0F, 3.0F, -49.0F, 26.0F, 13.0F, 56.0F, new CubeDeformation(0.01F))
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

        PartDefinition bellows_r = chest.addOrReplaceChild("bellows_r", CubeListBuilder.create().texOffs(164, 583).addBox(-27.0F, 3.0F, -49.0F, 26.0F, 13.0F, 56.0F, new CubeDeformation(0.01F))
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

        PartDefinition whistle_chest_parent = chest.addOrReplaceChild("whistle_chest_parent", CubeListBuilder.create(), PartPose.offset(0.0F, -20.0F, -1.0F));

        PartDefinition fs4 = whistle_chest_parent.addOrReplaceChild("fs4", CubeListBuilder.create().texOffs(649, 113).addBox(-5.0F, -46.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 73).addBox(-4.0F, -44.0F, -4.0F, 8.0F, 32.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition fs4head = fs4.addOrReplaceChild("fs4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition fs4_steam = fs4.addOrReplaceChild("fs4_steam", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r1 = fs4_steam.addOrReplaceChild("WhistleLargeBase_r1", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r2 = fs4_steam.addOrReplaceChild("WhistleLargeBase_r2", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r3 = fs4_steam.addOrReplaceChild("WhistleLargeBase_r3", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r4 = fs4_steam.addOrReplaceChild("WhistleLargeBase_r4", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition g4 = whistle_chest_parent.addOrReplaceChild("g4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -42.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 77).addBox(-4.0F, -40.0F, -4.0F, 8.0F, 28.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition g4head = g4.addOrReplaceChild("g4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition g4_steam = g4.addOrReplaceChild("g4_steam", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r5 = g4_steam.addOrReplaceChild("WhistleLargeBase_r5", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r6 = g4_steam.addOrReplaceChild("WhistleLargeBase_r6", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r7 = g4_steam.addOrReplaceChild("WhistleLargeBase_r7", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r8 = g4_steam.addOrReplaceChild("WhistleLargeBase_r8", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition gs4 = whistle_chest_parent.addOrReplaceChild("gs4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -38.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 81).addBox(-4.0F, -36.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -24.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition gs4head = gs4.addOrReplaceChild("gs4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition gs4_steam = gs4.addOrReplaceChild("gs4_steam", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r9 = gs4_steam.addOrReplaceChild("WhistleLargeBase_r9", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r10 = gs4_steam.addOrReplaceChild("WhistleLargeBase_r10", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r11 = gs4_steam.addOrReplaceChild("WhistleLargeBase_r11", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r12 = gs4_steam.addOrReplaceChild("WhistleLargeBase_r12", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition a4 = whistle_chest_parent.addOrReplaceChild("a4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -34.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 85).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -36.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition a4head = a4.addOrReplaceChild("a4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition a4_steam = a4.addOrReplaceChild("a4_steam", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r13 = a4_steam.addOrReplaceChild("WhistleLargeBase_r13", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r14 = a4_steam.addOrReplaceChild("WhistleLargeBase_r14", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r15 = a4_steam.addOrReplaceChild("WhistleLargeBase_r15", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r16 = a4_steam.addOrReplaceChild("WhistleLargeBase_r16", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition as4 = whistle_chest_parent.addOrReplaceChild("as4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -30.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 89).addBox(-4.0F, -28.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -48.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition as4head = as4.addOrReplaceChild("as4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition as4_steam = as4.addOrReplaceChild("as4_steam", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r17 = as4_steam.addOrReplaceChild("WhistleLargeBase_r17", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r18 = as4_steam.addOrReplaceChild("WhistleLargeBase_r18", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r19 = as4_steam.addOrReplaceChild("WhistleLargeBase_r19", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r20 = as4_steam.addOrReplaceChild("WhistleLargeBase_r20", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition b4 = whistle_chest_parent.addOrReplaceChild("b4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -26.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 93).addBox(-4.0F, -24.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -60.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition b4head = b4.addOrReplaceChild("b4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition b4_steam = b4.addOrReplaceChild("b4_steam", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r21 = b4_steam.addOrReplaceChild("WhistleLargeBase_r21", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r22 = b4_steam.addOrReplaceChild("WhistleLargeBase_r22", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r23 = b4_steam.addOrReplaceChild("WhistleLargeBase_r23", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r24 = b4_steam.addOrReplaceChild("WhistleLargeBase_r24", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

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

        PartDefinition whistle_tail2_parent = tail2.addOrReplaceChild("whistle_tail2_parent", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 78.0F));

        PartDefinition c5 = whistle_tail2_parent.addOrReplaceChild("c5", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 76).mirror().addBox(5.0F, -9.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -11.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -70.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition c5head = c5.addOrReplaceChild("c5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition c5_steam = c5.addOrReplaceChild("c5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r25 = c5_steam.addOrReplaceChild("WhistleLargeBase_r25", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r26 = c5_steam.addOrReplaceChild("WhistleLargeBase_r26", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition cs5 = whistle_tail2_parent.addOrReplaceChild("cs5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -15.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 72).mirror().addBox(5.0F, -13.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -60.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cs5head = cs5.addOrReplaceChild("cs5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition cs5_steam = cs5.addOrReplaceChild("cs5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r27 = cs5_steam.addOrReplaceChild("WhistleLargeBase_r27", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r28 = cs5_steam.addOrReplaceChild("WhistleLargeBase_r28", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition d5 = whistle_tail2_parent.addOrReplaceChild("d5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -19.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 68).mirror().addBox(5.0F, -17.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -50.0F, 0.0F, 0.0F, 0.5236F));

        PartDefinition d5head = d5.addOrReplaceChild("d5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition d5_steam = d5.addOrReplaceChild("d5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r29 = d5_steam.addOrReplaceChild("WhistleLargeBase_r29", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r30 = d5_steam.addOrReplaceChild("WhistleLargeBase_r30", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition ds5 = whistle_tail2_parent.addOrReplaceChild("ds5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -23.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 64).mirror().addBox(5.0F, -21.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -40.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition ds5head = ds5.addOrReplaceChild("ds5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition ds5_steam = ds5.addOrReplaceChild("ds5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r31 = ds5_steam.addOrReplaceChild("WhistleLargeBase_r31", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r32 = ds5_steam.addOrReplaceChild("WhistleLargeBase_r32", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition e5 = whistle_tail2_parent.addOrReplaceChild("e5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -27.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 60).mirror().addBox(5.0F, -25.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -30.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition e5head = e5.addOrReplaceChild("e5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition e5_steam = e5.addOrReplaceChild("e5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r33 = e5_steam.addOrReplaceChild("WhistleLargeBase_r33", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r34 = e5_steam.addOrReplaceChild("WhistleLargeBase_r34", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f5 = whistle_tail2_parent.addOrReplaceChild("f5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -31.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 56).mirror().addBox(5.0F, -29.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -20.0F, 0.0F, 0.0F, 0.8727F));

        PartDefinition f5head = f5.addOrReplaceChild("f5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition f5_steam = f5.addOrReplaceChild("f5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r35 = f5_steam.addOrReplaceChild("WhistleLargeBase_r35", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r36 = f5_steam.addOrReplaceChild("WhistleLargeBase_r36", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition fs5 = whistle_tail2_parent.addOrReplaceChild("fs5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -35.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 52).mirror().addBox(5.0F, -33.0F, -3.0F, 6.0F, 36.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, -10.0F, 0.0F, 0.0F, 0.9599F));

        PartDefinition fs5head = fs5.addOrReplaceChild("fs5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition fs5_steam = fs5.addOrReplaceChild("fs5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r37 = fs5_steam.addOrReplaceChild("WhistleLargeBase_r37", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r38 = fs5_steam.addOrReplaceChild("WhistleLargeBase_r38", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition g5 = whistle_tail2_parent.addOrReplaceChild("g5", CubeListBuilder.create().texOffs(723, 94).addBox(4.0F, -39.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 48).mirror().addBox(5.0F, -37.0F, -3.0F, 6.0F, 40.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(651, 135).addBox(1.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 13.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

        PartDefinition g5head = g5.addOrReplaceChild("g5head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition g5_steam = g5.addOrReplaceChild("g5_steam", CubeListBuilder.create(), PartPose.offset(13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r39 = g5_steam.addOrReplaceChild("WhistleLargeBase_r39", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r40 = g5_steam.addOrReplaceChild("WhistleLargeBase_r40", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition gs5 = whistle_tail2_parent.addOrReplaceChild("gs5", CubeListBuilder.create().texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 76).addBox(-11.0F, -9.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-12.0F, -11.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -70.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition gs5head = gs5.addOrReplaceChild("gs5head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition gs5_steam = gs5.addOrReplaceChild("gs5_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r41 = gs5_steam.addOrReplaceChild("WhistleLargeBase_r41", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r42 = gs5_steam.addOrReplaceChild("WhistleLargeBase_r42", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition a5 = whistle_tail2_parent.addOrReplaceChild("a5", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 72).addBox(-11.0F, -13.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -60.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition a5head = a5.addOrReplaceChild("a5head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition a5_steam = a5.addOrReplaceChild("a5_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r43 = a5_steam.addOrReplaceChild("WhistleLargeBase_r43", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r44 = a5_steam.addOrReplaceChild("WhistleLargeBase_r44", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition as5 = whistle_tail2_parent.addOrReplaceChild("as5", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -19.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 68).addBox(-11.0F, -17.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -50.0F, 0.0F, 0.0F, -0.5236F));

        PartDefinition as5head = as5.addOrReplaceChild("as5head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition as5_steam = as5.addOrReplaceChild("as5_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r45 = as5_steam.addOrReplaceChild("WhistleLargeBase_r45", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r46 = as5_steam.addOrReplaceChild("WhistleLargeBase_r46", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition b5 = whistle_tail2_parent.addOrReplaceChild("b5", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -23.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 64).addBox(-11.0F, -21.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -40.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition b5head = b5.addOrReplaceChild("b5head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition b5_steam = b5.addOrReplaceChild("b5_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r47 = b5_steam.addOrReplaceChild("WhistleLargeBase_r47", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r48 = b5_steam.addOrReplaceChild("WhistleLargeBase_r48", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition c6 = whistle_tail2_parent.addOrReplaceChild("c6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -27.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 60).addBox(-11.0F, -25.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -30.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition c6head = c6.addOrReplaceChild("c6head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition c6_steam = c6.addOrReplaceChild("c6_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r49 = c6_steam.addOrReplaceChild("WhistleLargeBase_r49", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r50 = c6_steam.addOrReplaceChild("WhistleLargeBase_r50", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition cs6 = whistle_tail2_parent.addOrReplaceChild("cs6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -31.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 56).addBox(-11.0F, -29.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -20.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition cs6head = cs6.addOrReplaceChild("cs6head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition cs6_steam = cs6.addOrReplaceChild("cs6_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r51 = cs6_steam.addOrReplaceChild("WhistleLargeBase_r51", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r52 = cs6_steam.addOrReplaceChild("WhistleLargeBase_r52", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition d6 = whistle_tail2_parent.addOrReplaceChild("d6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -35.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 52).addBox(-11.0F, -33.0F, -3.0F, 6.0F, 36.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, -10.0F, 0.0F, 0.0F, -0.9599F));

        PartDefinition d6head = d6.addOrReplaceChild("d6head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition d6_steam = d6.addOrReplaceChild("d6_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r53 = d6_steam.addOrReplaceChild("WhistleLargeBase_r53", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r54 = d6_steam.addOrReplaceChild("WhistleLargeBase_r54", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition ds6 = whistle_tail2_parent.addOrReplaceChild("ds6", CubeListBuilder.create().texOffs(723, 94).addBox(-12.0F, -39.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(727, 48).addBox(-11.0F, -37.0F, -3.0F, 6.0F, 40.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(651, 135).addBox(-10.0F, 0.0F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 13.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

        PartDefinition ds6head = ds6.addOrReplaceChild("ds6head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition ds6_steam = ds6.addOrReplaceChild("ds6_steam", CubeListBuilder.create(), PartPose.offset(-13.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r55 = ds6_steam.addOrReplaceChild("WhistleLargeBase_r55", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r56 = ds6_steam.addOrReplaceChild("WhistleLargeBase_r56", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition e6 = whistle_tail2_parent.addOrReplaceChild("e6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -50.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 44).addBox(-3.0F, -48.0F, -3.0F, 6.0F, 44.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -70.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition e6head = e6.addOrReplaceChild("e6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition e6_steam = e6.addOrReplaceChild("e6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r57 = e6_steam.addOrReplaceChild("WhistleLargeBase_r57", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r58 = e6_steam.addOrReplaceChild("WhistleLargeBase_r58", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r59 = e6_steam.addOrReplaceChild("WhistleLargeBase_r59", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r60 = e6_steam.addOrReplaceChild("WhistleLargeBase_r60", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f6 = whistle_tail2_parent.addOrReplaceChild("f6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 36).addBox(-3.0F, -44.0F, -3.0F, 6.0F, 40.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -46.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -60.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition f6head = f6.addOrReplaceChild("f6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition f6_steam = f6.addOrReplaceChild("f6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r61 = f6_steam.addOrReplaceChild("WhistleLargeBase_r61", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r62 = f6_steam.addOrReplaceChild("WhistleLargeBase_r62", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r63 = f6_steam.addOrReplaceChild("WhistleLargeBase_r63", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r64 = f6_steam.addOrReplaceChild("WhistleLargeBase_r64", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition fs6 = whistle_tail2_parent.addOrReplaceChild("fs6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -42.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 52).addBox(-3.0F, -40.0F, -3.0F, 6.0F, 36.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -50.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition fs6head = fs6.addOrReplaceChild("fs6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition fs6_steam = fs6.addOrReplaceChild("fs6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r65 = fs6_steam.addOrReplaceChild("WhistleLargeBase_r65", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r66 = fs6_steam.addOrReplaceChild("WhistleLargeBase_r66", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r67 = fs6_steam.addOrReplaceChild("WhistleLargeBase_r67", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r68 = fs6_steam.addOrReplaceChild("WhistleLargeBase_r68", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition g6 = whistle_tail2_parent.addOrReplaceChild("g6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 56).addBox(-3.0F, -36.0F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -38.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -40.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition g6head = g6.addOrReplaceChild("g6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition g6_steam = g6.addOrReplaceChild("g6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r69 = g6_steam.addOrReplaceChild("WhistleLargeBase_r69", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r70 = g6_steam.addOrReplaceChild("WhistleLargeBase_r70", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r71 = g6_steam.addOrReplaceChild("WhistleLargeBase_r71", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r72 = g6_steam.addOrReplaceChild("WhistleLargeBase_r72", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition gs6 = whistle_tail2_parent.addOrReplaceChild("gs6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -34.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 60).addBox(-3.0F, -32.0F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -30.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition gs6head = gs6.addOrReplaceChild("gs6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition gs6_steam = gs6.addOrReplaceChild("gs6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r73 = gs6_steam.addOrReplaceChild("WhistleLargeBase_r73", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r74 = gs6_steam.addOrReplaceChild("WhistleLargeBase_r74", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r75 = gs6_steam.addOrReplaceChild("WhistleLargeBase_r75", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r76 = gs6_steam.addOrReplaceChild("WhistleLargeBase_r76", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition a6 = whistle_tail2_parent.addOrReplaceChild("a6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 64).addBox(-3.0F, -28.0F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -30.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -20.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition a6head = a6.addOrReplaceChild("a6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition a6_steam = a6.addOrReplaceChild("a6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r77 = a6_steam.addOrReplaceChild("WhistleLargeBase_r77", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r78 = a6_steam.addOrReplaceChild("WhistleLargeBase_r78", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r79 = a6_steam.addOrReplaceChild("WhistleLargeBase_r79", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r80 = a6_steam.addOrReplaceChild("WhistleLargeBase_r80", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition as6 = whistle_tail2_parent.addOrReplaceChild("as6", CubeListBuilder.create().texOffs(723, 94).addBox(-4.0F, -26.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(698, 68).addBox(-3.0F, -24.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition as6head = as6.addOrReplaceChild("as6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition as6_steam = as6.addOrReplaceChild("as6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r81 = as6_steam.addOrReplaceChild("WhistleLargeBase_r81", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r82 = as6_steam.addOrReplaceChild("WhistleLargeBase_r82", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r83 = as6_steam.addOrReplaceChild("WhistleLargeBase_r83", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r84 = as6_steam.addOrReplaceChild("WhistleLargeBase_r84", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition b6 = whistle_tail2_parent.addOrReplaceChild("b6", CubeListBuilder.create().texOffs(656, 143).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(698, 72).addBox(-3.0F, -20.0F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).addBox(-4.0F, -22.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition b6head = b6.addOrReplaceChild("b6head", CubeListBuilder.create().texOffs(698, 3).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition b6_steam = b6.addOrReplaceChild("b6_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, 8.0F));

        PartDefinition WhistleLargeBase_r85 = b6_steam.addOrReplaceChild("WhistleLargeBase_r85", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r86 = b6_steam.addOrReplaceChild("WhistleLargeBase_r86", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r87 = b6_steam.addOrReplaceChild("WhistleLargeBase_r87", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r88 = b6_steam.addOrReplaceChild("WhistleLargeBase_r88", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition c7 = whistle_tail2_parent.addOrReplaceChild("c7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 76).mirror().addBox(5.0F, -8.75F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -10.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -50.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition c7head = c7.addOrReplaceChild("c7head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition c7_steam = c7.addOrReplaceChild("c7_steam", CubeListBuilder.create(), PartPose.offset(14.0F, 11.0F, 7.0F));

        PartDefinition WhistleLargeBase_r89 = c7_steam.addOrReplaceChild("WhistleLargeBase_r89", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r90 = c7_steam.addOrReplaceChild("WhistleLargeBase_r90", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition cs7 = whistle_tail2_parent.addOrReplaceChild("cs7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 72).mirror().addBox(5.0F, -12.75F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -14.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -40.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cs7head = cs7.addOrReplaceChild("cs7head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition cs7_steam = cs7.addOrReplaceChild("cs7_steam", CubeListBuilder.create(), PartPose.offset(14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r91 = cs7_steam.addOrReplaceChild("WhistleLargeBase_r91", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r92 = cs7_steam.addOrReplaceChild("WhistleLargeBase_r92", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition d7 = whistle_tail2_parent.addOrReplaceChild("d7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 68).mirror().addBox(5.0F, -16.75F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -18.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -30.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition d7head = d7.addOrReplaceChild("d7head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition d7_steam = d7.addOrReplaceChild("d7_steam", CubeListBuilder.create(), PartPose.offset(14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r93 = d7_steam.addOrReplaceChild("WhistleLargeBase_r93", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r94 = d7_steam.addOrReplaceChild("WhistleLargeBase_r94", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition ds7 = whistle_tail2_parent.addOrReplaceChild("ds7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 64).mirror().addBox(5.0F, -20.75F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -22.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 3.0F, -20.0F));

        PartDefinition ds7head = ds7.addOrReplaceChild("ds7head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition ds7_steam = ds7.addOrReplaceChild("ds7_steam", CubeListBuilder.create(), PartPose.offset(14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r95 = ds7_steam.addOrReplaceChild("WhistleLargeBase_r95", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r96 = ds7_steam.addOrReplaceChild("WhistleLargeBase_r96", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition e7 = whistle_tail2_parent.addOrReplaceChild("e7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 60).mirror().addBox(5.0F, -24.75F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -26.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, -10.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition e7head = e7.addOrReplaceChild("e7head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition e7_steam = e7.addOrReplaceChild("e7_steam", CubeListBuilder.create(), PartPose.offset(14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r97 = e7_steam.addOrReplaceChild("WhistleLargeBase_r97", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r98 = e7_steam.addOrReplaceChild("WhistleLargeBase_r98", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f7 = whistle_tail2_parent.addOrReplaceChild("f7", CubeListBuilder.create().texOffs(651, 135).addBox(1.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(727, 56).mirror().addBox(5.0F, -28.75F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(723, 94).addBox(4.0F, -30.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition f7head = f7.addOrReplaceChild("f7head", CubeListBuilder.create().texOffs(727, 3).mirror().addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 2.0F, 0.0F));

        PartDefinition f7_steam = f7.addOrReplaceChild("f7_steam", CubeListBuilder.create(), PartPose.offset(14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r99 = f7_steam.addOrReplaceChild("WhistleLargeBase_r99", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r100 = f7_steam.addOrReplaceChild("WhistleLargeBase_r100", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition fs7 = whistle_tail2_parent.addOrReplaceChild("fs7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 56).addBox(-11.0F, -28.75F, -3.0F, 6.0F, 32.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -30.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition fs7head = fs7.addOrReplaceChild("fs7head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition fs7_steam = fs7.addOrReplaceChild("fs7_steam", CubeListBuilder.create(), PartPose.offset(-14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r101 = fs7_steam.addOrReplaceChild("WhistleLargeBase_r101", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r102 = fs7_steam.addOrReplaceChild("WhistleLargeBase_r102", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition g7 = whistle_tail2_parent.addOrReplaceChild("g7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 60).addBox(-11.0F, -24.75F, -3.0F, 6.0F, 28.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -26.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -10.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition g7head = g7.addOrReplaceChild("g7head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition g7_steam = g7.addOrReplaceChild("g7_steam", CubeListBuilder.create(), PartPose.offset(-14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r103 = g7_steam.addOrReplaceChild("WhistleLargeBase_r103", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r104 = g7_steam.addOrReplaceChild("WhistleLargeBase_r104", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition gs7 = whistle_tail2_parent.addOrReplaceChild("gs7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 64).addBox(-11.0F, -20.75F, -3.0F, 6.0F, 24.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -22.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, 3.0F, -20.0F));

        PartDefinition gs7head = gs7.addOrReplaceChild("gs7head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition gs7_steam = gs7.addOrReplaceChild("gs7_steam", CubeListBuilder.create(), PartPose.offset(-14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r105 = gs7_steam.addOrReplaceChild("WhistleLargeBase_r105", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r106 = gs7_steam.addOrReplaceChild("WhistleLargeBase_r106", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition a7 = whistle_tail2_parent.addOrReplaceChild("a7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 68).addBox(-11.0F, -16.75F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -18.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -30.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition a7head = a7.addOrReplaceChild("a7head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition a7_steam = a7.addOrReplaceChild("a7_steam", CubeListBuilder.create(), PartPose.offset(-14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r107 = a7_steam.addOrReplaceChild("WhistleLargeBase_r107", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r108 = a7_steam.addOrReplaceChild("WhistleLargeBase_r108", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition as7 = whistle_tail2_parent.addOrReplaceChild("as7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 72).addBox(-11.0F, -12.75F, -3.0F, 6.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -14.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -40.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition as7head = as7.addOrReplaceChild("as7head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition as7_steam = as7.addOrReplaceChild("as7_steam", CubeListBuilder.create(), PartPose.offset(-14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r109 = as7_steam.addOrReplaceChild("WhistleLargeBase_r109", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r110 = as7_steam.addOrReplaceChild("WhistleLargeBase_r110", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition b7 = whistle_tail2_parent.addOrReplaceChild("b7", CubeListBuilder.create().texOffs(651, 135).mirror().addBox(-10.0F, 0.25F, -2.0F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(727, 76).addBox(-11.0F, -8.75F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(723, 94).mirror().addBox(-12.0F, -10.75F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 3.0F, -50.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition b7head = b7.addOrReplaceChild("b7head", CubeListBuilder.create().texOffs(727, 3).addBox(-3.0F, -6.75F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 2.0F, 0.0F));

        PartDefinition b7_steam = b7.addOrReplaceChild("b7_steam", CubeListBuilder.create(), PartPose.offset(-14.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r111 = b7_steam.addOrReplaceChild("WhistleLargeBase_r111", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r112 = b7_steam.addOrReplaceChild("WhistleLargeBase_r112", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition whistle_tail1_parent = tail1.addOrReplaceChild("whistle_tail1_parent", CubeListBuilder.create(), PartPose.offset(-11.75F, 4.0F, 22.0F));

        PartDefinition c3 = whistle_tail1_parent.addOrReplaceChild("c3", CubeListBuilder.create().texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(3.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 85).mirror().addBox(4.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(23.75F, 11.0F, -13.0F, 0.0F, 0.0F, 0.6109F));

        PartDefinition c3head = c3.addOrReplaceChild("c3head", CubeListBuilder.create().texOffs(656, 2).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition c3_steam = c3.addOrReplaceChild("c3_steam", CubeListBuilder.create(), PartPose.offset(15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r113 = c3_steam.addOrReplaceChild("WhistleLargeBase_r113", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r114 = c3_steam.addOrReplaceChild("WhistleLargeBase_r114", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition cs3 = whistle_tail1_parent.addOrReplaceChild("cs3", CubeListBuilder.create().texOffs(649, 113).addBox(3.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 89).mirror().addBox(4.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, 11.0F, -1.0F, 0.0F, 0.0F, 0.6981F));

        PartDefinition cs3head = cs3.addOrReplaceChild("cs3head", CubeListBuilder.create().texOffs(656, 2).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition cs3_steam = cs3.addOrReplaceChild("cs3_steam", CubeListBuilder.create(), PartPose.offset(15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r115 = cs3_steam.addOrReplaceChild("WhistleLargeBase_r115", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r116 = cs3_steam.addOrReplaceChild("WhistleLargeBase_r116", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition d3 = whistle_tail1_parent.addOrReplaceChild("d3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-13.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 85).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 11.0F, -13.0F, 0.0F, 0.0F, -0.6109F));

        PartDefinition d3head = d3.addOrReplaceChild("d3head", CubeListBuilder.create().texOffs(656, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition d3_steam = d3.addOrReplaceChild("d3_steam", CubeListBuilder.create(), PartPose.offset(-15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r117 = d3_steam.addOrReplaceChild("WhistleLargeBase_r117", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r118 = d3_steam.addOrReplaceChild("WhistleLargeBase_r118", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition ds3 = whistle_tail1_parent.addOrReplaceChild("ds3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 89).addBox(-12.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-13.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 11.0F, -1.0F, 0.0F, 0.0F, -0.6981F));

        PartDefinition ds3head = ds3.addOrReplaceChild("ds3head", CubeListBuilder.create().texOffs(656, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition ds3_steam = ds3.addOrReplaceChild("ds3_steam", CubeListBuilder.create(), PartPose.offset(-15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r119 = ds3_steam.addOrReplaceChild("WhistleLargeBase_r119", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r120 = ds3_steam.addOrReplaceChild("WhistleLargeBase_r120", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition e3 = whistle_tail1_parent.addOrReplaceChild("e3", CubeListBuilder.create().texOffs(656, 81).mirror().addBox(5.0F, -19.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 113).addBox(4.0F, -21.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(682, 131).addBox(1.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(22.75F, -5.0F, 11.0F));

        PartDefinition e3head = e3.addOrReplaceChild("e3head", CubeListBuilder.create().texOffs(656, 2).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(9.0F, 4.0F, 0.0F));

        PartDefinition e3_steam = e3.addOrReplaceChild("e3_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r121 = e3_steam.addOrReplaceChild("WhistleLargeBase_r121", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r122 = e3_steam.addOrReplaceChild("WhistleLargeBase_r122", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f3 = whistle_tail1_parent.addOrReplaceChild("f3", CubeListBuilder.create().texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 85).mirror().addBox(4.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 113).addBox(3.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -5.0F, 23.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition f3head = f3.addOrReplaceChild("f3head", CubeListBuilder.create().texOffs(656, 2).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition f3_steam = f3.addOrReplaceChild("f3_steam", CubeListBuilder.create(), PartPose.offset(15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r123 = f3_steam.addOrReplaceChild("WhistleLargeBase_r123", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r124 = f3_steam.addOrReplaceChild("WhistleLargeBase_r124", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition fs3 = whistle_tail1_parent.addOrReplaceChild("fs3", CubeListBuilder.create().texOffs(682, 131).addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 89).mirror().addBox(4.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 113).addBox(3.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -5.0F, 35.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition fs3head = fs3.addOrReplaceChild("fs3head", CubeListBuilder.create().texOffs(656, 2).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition fs3_steam = fs3.addOrReplaceChild("fs3_steam", CubeListBuilder.create(), PartPose.offset(15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r125 = fs3_steam.addOrReplaceChild("WhistleLargeBase_r125", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r126 = fs3_steam.addOrReplaceChild("WhistleLargeBase_r126", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition g3 = whistle_tail1_parent.addOrReplaceChild("g3", CubeListBuilder.create().texOffs(682, 131).mirror().addBox(0.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(656, 93).mirror().addBox(4.0F, -7.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(649, 113).addBox(3.0F, -9.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.75F, -5.0F, 47.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition g3head = g3.addOrReplaceChild("g3head", CubeListBuilder.create().texOffs(656, 2).mirror().addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 4.0F, 0.0F));

        PartDefinition g3_steam = g3.addOrReplaceChild("g3_steam", CubeListBuilder.create(), PartPose.offset(15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r127 = g3_steam.addOrReplaceChild("WhistleLargeBase_r127", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r128 = g3_steam.addOrReplaceChild("WhistleLargeBase_r128", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition gs3 = whistle_tail1_parent.addOrReplaceChild("gs3", CubeListBuilder.create().texOffs(682, 131).addBox(-12.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 81).addBox(-13.0F, -19.0F, -4.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-14.0F, -21.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.75F, -5.0F, 11.0F));

        PartDefinition gs3head = gs3.addOrReplaceChild("gs3head", CubeListBuilder.create().texOffs(656, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-9.0F, 4.0F, 0.0F));

        PartDefinition gs3_steam = gs3.addOrReplaceChild("gs3_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r129 = gs3_steam.addOrReplaceChild("WhistleLargeBase_r129", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r130 = gs3_steam.addOrReplaceChild("WhistleLargeBase_r130", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition a3 = whistle_tail1_parent.addOrReplaceChild("a3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-13.0F, -17.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(656, 85).addBox(-12.0F, -15.0F, -4.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, 23.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition a3head = a3.addOrReplaceChild("a3head", CubeListBuilder.create().texOffs(656, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition a3_steam = a3.addOrReplaceChild("a3_steam", CubeListBuilder.create(), PartPose.offset(-15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r131 = a3_steam.addOrReplaceChild("WhistleLargeBase_r131", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r132 = a3_steam.addOrReplaceChild("WhistleLargeBase_r132", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition as3 = whistle_tail1_parent.addOrReplaceChild("as3", CubeListBuilder.create().texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(656, 89).addBox(-12.0F, -11.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-13.0F, -13.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, 35.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition as3head = as3.addOrReplaceChild("as3head", CubeListBuilder.create().texOffs(656, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition as3_steam = as3.addOrReplaceChild("as3_steam", CubeListBuilder.create(), PartPose.offset(-15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r133 = as3_steam.addOrReplaceChild("WhistleLargeBase_r133", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r134 = as3_steam.addOrReplaceChild("WhistleLargeBase_r134", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition b3 = whistle_tail1_parent.addOrReplaceChild("b3", CubeListBuilder.create().texOffs(656, 93).addBox(-12.0F, -7.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-13.0F, -9.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(682, 131).addBox(-11.0F, 0.0F, -3.0F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, 47.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition b3head = b3.addOrReplaceChild("b3head", CubeListBuilder.create().texOffs(656, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 4.0F, 0.0F));

        PartDefinition b3_steam = b3.addOrReplaceChild("b3_steam", CubeListBuilder.create(), PartPose.offset(-15.0F, 11.0F, 8.0F));

        PartDefinition WhistleLargeBase_r135 = b3_steam.addOrReplaceChild("WhistleLargeBase_r135", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r136 = b3_steam.addOrReplaceChild("WhistleLargeBase_r136", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition c4 = whistle_tail1_parent.addOrReplaceChild("c4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(619, 35).addBox(-4.0F, -74.0F, -4.0F, 8.0F, 70.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -76.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.75F, -18.0F, -13.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition c4head = c4.addOrReplaceChild("c4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition c4_steam = c4.addOrReplaceChild("c4_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 2.0F, 8.0F));

        PartDefinition WhistleLargeBase_r137 = c4_steam.addOrReplaceChild("WhistleLargeBase_r137", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r138 = c4_steam.addOrReplaceChild("WhistleLargeBase_r138", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r139 = c4_steam.addOrReplaceChild("WhistleLargeBase_r139", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r140 = c4_steam.addOrReplaceChild("WhistleLargeBase_r140", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition cs4 = whistle_tail1_parent.addOrReplaceChild("cs4", CubeListBuilder.create().texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -72.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 39).addBox(-4.0F, -70.0F, -4.0F, 8.0F, 66.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.75F, -18.0F, -1.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cs4head = cs4.addOrReplaceChild("cs4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition cs4_steam = cs4.addOrReplaceChild("cs4_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 2.0F, 8.0F));

        PartDefinition WhistleLargeBase_r141 = cs4_steam.addOrReplaceChild("WhistleLargeBase_r141", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r142 = cs4_steam.addOrReplaceChild("WhistleLargeBase_r142", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r143 = cs4_steam.addOrReplaceChild("WhistleLargeBase_r143", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r144 = cs4_steam.addOrReplaceChild("WhistleLargeBase_r144", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition d4 = whistle_tail1_parent.addOrReplaceChild("d4", CubeListBuilder.create().texOffs(619, 43).addBox(-4.0F, -66.0F, -4.0F, 8.0F, 62.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(649, 113).addBox(-5.0F, -68.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.75F, -18.0F, 11.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition d4head = d4.addOrReplaceChild("d4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition d4_steam = d4.addOrReplaceChild("d4_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 2.0F, 8.0F));

        PartDefinition WhistleLargeBase_r145 = d4_steam.addOrReplaceChild("WhistleLargeBase_r145", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r146 = d4_steam.addOrReplaceChild("WhistleLargeBase_r146", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r147 = d4_steam.addOrReplaceChild("WhistleLargeBase_r147", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r148 = d4_steam.addOrReplaceChild("WhistleLargeBase_r148", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition ds4 = whistle_tail1_parent.addOrReplaceChild("ds4", CubeListBuilder.create().texOffs(649, 113).addBox(-5.0F, -64.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(619, 47).addBox(-4.0F, -62.0F, -4.0F, 8.0F, 58.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.75F, -18.0F, 23.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition ds4head = ds4.addOrReplaceChild("ds4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition ds4_steam = ds4.addOrReplaceChild("ds4_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 2.0F, 8.0F));

        PartDefinition WhistleLargeBase_r149 = ds4_steam.addOrReplaceChild("WhistleLargeBase_r149", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r150 = ds4_steam.addOrReplaceChild("WhistleLargeBase_r150", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r151 = ds4_steam.addOrReplaceChild("WhistleLargeBase_r151", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r152 = ds4_steam.addOrReplaceChild("WhistleLargeBase_r152", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition e4 = whistle_tail1_parent.addOrReplaceChild("e4", CubeListBuilder.create().texOffs(649, 113).addBox(-5.0F, -60.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 51).addBox(-4.0F, -58.0F, -4.0F, 8.0F, 54.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.75F, -18.0F, 35.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition e4head = e4.addOrReplaceChild("e4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition e4_steam = e4.addOrReplaceChild("e4_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 2.0F, 8.0F));

        PartDefinition WhistleLargeBase_r153 = e4_steam.addOrReplaceChild("WhistleLargeBase_r153", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r154 = e4_steam.addOrReplaceChild("WhistleLargeBase_r154", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r155 = e4_steam.addOrReplaceChild("WhistleLargeBase_r155", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r156 = e4_steam.addOrReplaceChild("WhistleLargeBase_r156", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f4 = whistle_tail1_parent.addOrReplaceChild("f4", CubeListBuilder.create().texOffs(649, 113).addBox(-5.0F, -56.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(619, 55).addBox(-4.0F, -54.0F, -4.0F, 8.0F, 50.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(687, 143).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 21.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.75F, -18.0F, 47.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition f4head = f4.addOrReplaceChild("f4head", CubeListBuilder.create().texOffs(619, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition f4_steam = f4.addOrReplaceChild("f4_steam", CubeListBuilder.create(), PartPose.offset(7.0F, 2.0F, 8.0F));

        PartDefinition WhistleLargeBase_r157 = f4_steam.addOrReplaceChild("WhistleLargeBase_r157", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r158 = f4_steam.addOrReplaceChild("WhistleLargeBase_r158", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r159 = f4_steam.addOrReplaceChild("WhistleLargeBase_r159", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r160 = f4_steam.addOrReplaceChild("WhistleLargeBase_r160", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition gs2 = whistle_tail1_parent.addOrReplaceChild("gs2", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -30.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 49).addBox(-13.0F, -28.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition gs2head = gs2.addOrReplaceChild("gs2head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition gs2_steam = gs2.addOrReplaceChild("gs2_steam", CubeListBuilder.create(), PartPose.offset(-15.25F, 6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r161 = gs2_steam.addOrReplaceChild("WhistleLargeBase_r161", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r162 = gs2_steam.addOrReplaceChild("WhistleLargeBase_r162", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition a2 = whistle_tail1_parent.addOrReplaceChild("a2", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -34.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 45).mirror().addBox(3.0F, -32.0F, -5.0F, 10.0F, 32.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5F, 0.0F, -13.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition a2head = a2.addOrReplaceChild("a2head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, -1.0F, 0.0F));

        PartDefinition a2_steam = a2.addOrReplaceChild("a2_steam", CubeListBuilder.create(), PartPose.offset(15.25F, 6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r163 = a2_steam.addOrReplaceChild("WhistleLargeBase_r163", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r164 = a2_steam.addOrReplaceChild("WhistleLargeBase_r164", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition as2 = whistle_tail1_parent.addOrReplaceChild("as2", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -30.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 49).mirror().addBox(3.0F, -28.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5F, 0.0F, -1.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition as2head = as2.addOrReplaceChild("as2head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, -1.0F, 0.0F));

        PartDefinition as2_steam = as2.addOrReplaceChild("as2_steam", CubeListBuilder.create(), PartPose.offset(15.25F, 6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r165 = as2_steam.addOrReplaceChild("WhistleLargeBase_r165", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r166 = as2_steam.addOrReplaceChild("WhistleLargeBase_r166", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition b2 = whistle_tail1_parent.addOrReplaceChild("b2", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -34.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 45).addBox(-13.0F, -32.0F, -5.0F, 10.0F, 32.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition b2head = b2.addOrReplaceChild("b2head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition b2_steam = b2.addOrReplaceChild("b2_steam", CubeListBuilder.create(), PartPose.offset(-15.25F, 6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r167 = b2_steam.addOrReplaceChild("WhistleLargeBase_r167", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r168 = b2_steam.addOrReplaceChild("WhistleLargeBase_r168", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition whistle_back_parent = body.addOrReplaceChild("whistle_back_parent", CubeListBuilder.create(), PartPose.offset(19.0F, -28.0F, -16.0F));

        PartDefinition c1 = whistle_back_parent.addOrReplaceChild("c1", CubeListBuilder.create().texOffs(569, 33).mirror().addBox(-5.0F, -43.0F, -5.0F, 10.0F, 44.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(473, 16).addBox(-6.0F, -45.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-8.0F, -6.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition c1head = c1.addOrReplaceChild("c1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition c1_steam = c1.addOrReplaceChild("c1_steam", CubeListBuilder.create(), PartPose.offset(8.0F, 6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r169 = c1_steam.addOrReplaceChild("WhistleLargeBase_r169", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -1.5708F));

        PartDefinition WhistleLargeBase_r170 = c1_steam.addOrReplaceChild("WhistleLargeBase_r170", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.5708F));

        PartDefinition cs1 = whistle_back_parent.addOrReplaceChild("cs1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -31.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 41).mirror().addBox(3.0F, -29.0F, -5.0F, 10.0F, 36.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -6.0F, 14.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition cs1head = cs1.addOrReplaceChild("cs1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition cs1_steam = cs1.addOrReplaceChild("cs1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r171 = cs1_steam.addOrReplaceChild("WhistleLargeBase_r171", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -1.5708F));

        PartDefinition WhistleLargeBase_r172 = cs1_steam.addOrReplaceChild("WhistleLargeBase_r172", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.5708F));

        PartDefinition d1 = whistle_back_parent.addOrReplaceChild("d1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -23.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 49).mirror().addBox(3.0F, -21.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -6.0F, 28.0F));

        PartDefinition d1head = d1.addOrReplaceChild("d1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition d1_steam = d1.addOrReplaceChild("d1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r173 = d1_steam.addOrReplaceChild("WhistleLargeBase_r173", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -1.5708F));

        PartDefinition WhistleLargeBase_r174 = d1_steam.addOrReplaceChild("WhistleLargeBase_r174", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.5708F));

        PartDefinition ds1 = whistle_back_parent.addOrReplaceChild("ds1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -22.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 57).mirror().addBox(3.0F, -20.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 1.0F, 42.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition ds1head = ds1.addOrReplaceChild("ds1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, -1.0F, 0.0F));

        PartDefinition ds1_steam = ds1.addOrReplaceChild("ds1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 5.0F, 8.0F));

        PartDefinition WhistleLargeBase_r175 = ds1_steam.addOrReplaceChild("WhistleLargeBase_r175", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -1.5708F));

        PartDefinition WhistleLargeBase_r176 = ds1_steam.addOrReplaceChild("WhistleLargeBase_r176", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.5708F));

        PartDefinition e1 = whistle_back_parent.addOrReplaceChild("e1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -7.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 65).mirror().addBox(3.0F, -5.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 42.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition e1head = e1.addOrReplaceChild("e1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition e1_steam = e1.addOrReplaceChild("e1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r177 = e1_steam.addOrReplaceChild("WhistleLargeBase_r177", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r178 = e1_steam.addOrReplaceChild("WhistleLargeBase_r178", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f1 = whistle_back_parent.addOrReplaceChild("f1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -11.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 61).mirror().addBox(3.0F, -9.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 28.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition f1head = f1.addOrReplaceChild("f1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition f1_steam = f1.addOrReplaceChild("f1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r179 = f1_steam.addOrReplaceChild("WhistleLargeBase_r179", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r180 = f1_steam.addOrReplaceChild("WhistleLargeBase_r180", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition fs1 = whistle_back_parent.addOrReplaceChild("fs1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -15.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 57).mirror().addBox(3.0F, -13.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition fs1head = fs1.addOrReplaceChild("fs1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition fs1_steam = fs1.addOrReplaceChild("fs1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r181 = fs1_steam.addOrReplaceChild("WhistleLargeBase_r181", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r182 = fs1_steam.addOrReplaceChild("WhistleLargeBase_r182", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition g1 = whistle_back_parent.addOrReplaceChild("g1", CubeListBuilder.create().texOffs(473, 16).addBox(2.0F, -19.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 53).mirror().addBox(3.0F, -17.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(716, 127).addBox(0.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition g1head = g1.addOrReplaceChild("g1head", CubeListBuilder.create().texOffs(569, 0).mirror().addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(8.0F, 6.0F, 0.0F));

        PartDefinition g1_steam = g1.addOrReplaceChild("g1_steam", CubeListBuilder.create(), PartPose.offset(16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r183 = g1_steam.addOrReplaceChild("WhistleLargeBase_r183", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r184 = g1_steam.addOrReplaceChild("WhistleLargeBase_r184", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition gs1 = whistle_back_parent.addOrReplaceChild("gs1", CubeListBuilder.create().texOffs(716, 127).addBox(-4.0F, -6.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(569, 33).addBox(-5.0F, -43.0F, -5.0F, 10.0F, 44.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(473, 16).addBox(-6.0F, -45.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition gs1head = gs1.addOrReplaceChild("gs1head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition gs1_steam = gs1.addOrReplaceChild("gs1_steam", CubeListBuilder.create(), PartPose.offset(-8.0F, 6.0F, 8.0F));

        PartDefinition WhistleLargeBase_r185 = gs1_steam.addOrReplaceChild("WhistleLargeBase_r185", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r186 = gs1_steam.addOrReplaceChild("WhistleLargeBase_r186", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition a1 = whistle_back_parent.addOrReplaceChild("a1", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -31.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 41).addBox(-13.0F, -29.0F, -5.0F, 10.0F, 36.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, -6.0F, 14.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition a1head = a1.addOrReplaceChild("a1head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition a1_steam = a1.addOrReplaceChild("a1_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r187 = a1_steam.addOrReplaceChild("WhistleLargeBase_r187", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r188 = a1_steam.addOrReplaceChild("WhistleLargeBase_r188", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition as1 = whistle_back_parent.addOrReplaceChild("as1", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -23.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 49).addBox(-13.0F, -21.0F, -5.0F, 10.0F, 28.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, -6.0F, 28.0F));

        PartDefinition as1head = as1.addOrReplaceChild("as1head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition as1_steam = as1.addOrReplaceChild("as1_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r189 = as1_steam.addOrReplaceChild("WhistleLargeBase_r189", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r190 = as1_steam.addOrReplaceChild("WhistleLargeBase_r190", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition b1 = whistle_back_parent.addOrReplaceChild("b1", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -22.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 57).addBox(-13.0F, -20.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, -7.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, 1.0F, 42.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition b1head = b1.addOrReplaceChild("b1head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -1.0F, 0.0F));

        PartDefinition b1_steam = b1.addOrReplaceChild("b1_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 5.0F, 8.0F));

        PartDefinition WhistleLargeBase_r191 = b1_steam.addOrReplaceChild("WhistleLargeBase_r191", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r192 = b1_steam.addOrReplaceChild("WhistleLargeBase_r192", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition c2 = whistle_back_parent.addOrReplaceChild("c2", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -7.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 65).addBox(-13.0F, -5.0F, -5.0F, 10.0F, 12.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 42.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition c2head = c2.addOrReplaceChild("c2head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition c2_steam = c2.addOrReplaceChild("c2_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r193 = c2_steam.addOrReplaceChild("WhistleLargeBase_r193", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r194 = c2_steam.addOrReplaceChild("WhistleLargeBase_r194", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition cs2 = whistle_back_parent.addOrReplaceChild("cs2", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -11.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 61).addBox(-13.0F, -9.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 28.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cs2head = cs2.addOrReplaceChild("cs2head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition cs2_steam = cs2.addOrReplaceChild("cs2_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r195 = cs2_steam.addOrReplaceChild("WhistleLargeBase_r195", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r196 = cs2_steam.addOrReplaceChild("WhistleLargeBase_r196", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition d2 = whistle_back_parent.addOrReplaceChild("d2", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -15.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 57).addBox(-13.0F, -13.0F, -5.0F, 10.0F, 20.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 14.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition d2head = d2.addOrReplaceChild("d2head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition d2_steam = d2.addOrReplaceChild("d2_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r197 = d2_steam.addOrReplaceChild("WhistleLargeBase_r197", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r198 = d2_steam.addOrReplaceChild("WhistleLargeBase_r198", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition ds2 = whistle_back_parent.addOrReplaceChild("ds2", CubeListBuilder.create().texOffs(473, 16).addBox(-14.0F, -19.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(569, 53).addBox(-13.0F, -17.0F, -5.0F, 10.0F, 24.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(716, 127).addBox(-12.0F, 0.0F, -4.0F, 12.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition ds2head = ds2.addOrReplaceChild("ds2head", CubeListBuilder.create().texOffs(569, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, 6.0F, 0.0F));

        PartDefinition ds2_steam = ds2.addOrReplaceChild("ds2_steam", CubeListBuilder.create(), PartPose.offset(-16.0F, 12.0F, 8.0F));

        PartDefinition WhistleLargeBase_r199 = ds2_steam.addOrReplaceChild("WhistleLargeBase_r199", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r200 = ds2_steam.addOrReplaceChild("WhistleLargeBase_r200", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition e2 = whistle_back_parent.addOrReplaceChild("e2", CubeListBuilder.create().texOffs(725, 143).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(524, 53).addBox(-5.0F, -44.0F, -5.0F, 10.0F, 40.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(473, 16).addBox(-6.0F, -46.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -7.0F, 0.0F));

        PartDefinition e2head = e2.addOrReplaceChild("e2head", CubeListBuilder.create().texOffs(524, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition e2_steam = e2.addOrReplaceChild("e2_steam", CubeListBuilder.create(), PartPose.offset(8.0F, 1.0F, 8.0F));

        PartDefinition WhistleLargeBase_r201 = e2_steam.addOrReplaceChild("WhistleLargeBase_r201", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r202 = e2_steam.addOrReplaceChild("WhistleLargeBase_r202", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r203 = e2_steam.addOrReplaceChild("WhistleLargeBase_r203", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r204 = e2_steam.addOrReplaceChild("WhistleLargeBase_r204", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition f2 = whistle_back_parent.addOrReplaceChild("f2", CubeListBuilder.create().texOffs(725, 143).addBox(-12.0F, -11.0F, 4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(524, 45).addBox(-13.0F, -52.0F, 3.0F, 10.0F, 48.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(473, 16).addBox(-14.0F, -54.0F, 2.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -7.0F, 6.0F));

        PartDefinition f2head = f2.addOrReplaceChild("f2head", CubeListBuilder.create().texOffs(524, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(-8.0F, -5.0F, 8.0F));

        PartDefinition f2_steam = f2.addOrReplaceChild("f2_steam", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 16.0F));

        PartDefinition WhistleLargeBase_r205 = f2_steam.addOrReplaceChild("WhistleLargeBase_r205", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r206 = f2_steam.addOrReplaceChild("WhistleLargeBase_r206", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r207 = f2_steam.addOrReplaceChild("WhistleLargeBase_r207", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r208 = f2_steam.addOrReplaceChild("WhistleLargeBase_r208", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition fs2 = whistle_back_parent.addOrReplaceChild("fs2", CubeListBuilder.create().texOffs(725, 143).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(473, 16).addBox(-6.0F, -62.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(524, 37).addBox(-5.0F, -60.0F, -5.0F, 10.0F, 56.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -7.0F, 28.0F));

        PartDefinition fs2head = fs2.addOrReplaceChild("fs2head", CubeListBuilder.create().texOffs(524, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition fs2_steam = fs2.addOrReplaceChild("fs2_steam", CubeListBuilder.create(), PartPose.offset(8.0F, 1.0F, 8.0F));

        PartDefinition WhistleLargeBase_r209 = fs2_steam.addOrReplaceChild("WhistleLargeBase_r209", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r210 = fs2_steam.addOrReplaceChild("WhistleLargeBase_r210", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r211 = fs2_steam.addOrReplaceChild("WhistleLargeBase_r211", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r212 = fs2_steam.addOrReplaceChild("WhistleLargeBase_r212", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

        PartDefinition g2 = whistle_back_parent.addOrReplaceChild("g2", CubeListBuilder.create().texOffs(473, 16).addBox(-6.0F, -70.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(524, 29).addBox(-5.0F, -68.0F, -5.0F, 10.0F, 64.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(725, 143).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-19.0F, -7.0F, 42.0F));

        PartDefinition g2head = g2.addOrReplaceChild("g2head", CubeListBuilder.create().texOffs(524, 0).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition g2_steam = g2.addOrReplaceChild("g2_steam", CubeListBuilder.create(), PartPose.offset(8.0F, 1.0F, 8.0F));

        PartDefinition WhistleLargeBase_r213 = g2_steam.addOrReplaceChild("WhistleLargeBase_r213", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 3.1416F, -0.7854F, 2.0071F));

        PartDefinition WhistleLargeBase_r214 = g2_steam.addOrReplaceChild("WhistleLargeBase_r214", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -9.3431F, -8.0F, 0.0F, -0.7854F, -1.1345F));

        PartDefinition WhistleLargeBase_r215 = g2_steam.addOrReplaceChild("WhistleLargeBase_r215", CubeListBuilder.create().texOffs(0, 33).addBox(-7.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 3.1416F, 0.7854F, -2.0071F));

        PartDefinition WhistleLargeBase_r216 = g2_steam.addOrReplaceChild("WhistleLargeBase_r216", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-9.0F, -16.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -9.3431F, -8.0F, 0.0F, 0.7854F, 1.1345F));

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

        this.animate(entity.idleAnimationState, OrganAnimations.organ_idle, ageInTicks, 1f);

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

        c1.visible = entity.getAssembly() > 21;
        cs1.visible = entity.getAssembly() > 22;
        d1.visible = entity.getAssembly() > 23;
        ds1.visible = entity.getAssembly() > 24;
        e1.visible = entity.getAssembly() > 25;
        f1.visible = entity.getAssembly() > 26;
        fs1.visible = entity.getAssembly() > 27;
        g1.visible = entity.getAssembly() > 28;
        gs1.visible = entity.getAssembly() > 29;
        a1.visible = entity.getAssembly() > 30;
        as1.visible = entity.getAssembly() > 31;
        b1.visible = entity.getAssembly() > 32;

        c2.visible = entity.getAssembly() > 33;
        cs2.visible = entity.getAssembly() > 34;
        d2.visible = entity.getAssembly() > 35;
        ds2.visible = entity.getAssembly() > 36;
        e2.visible = entity.getAssembly() > 37;
        f2.visible = entity.getAssembly() > 38;
        fs2.visible = entity.getAssembly() > 39;
        g2.visible = entity.getAssembly() > 40;
        gs2.visible = entity.getAssembly() > 41;
        a2.visible = entity.getAssembly() > 42;
        as2.visible = entity.getAssembly() > 43;
        b2.visible = entity.getAssembly() > 44;

        c3.visible = entity.getAssembly() > 45;
        cs3.visible = entity.getAssembly() > 46;
        d3.visible = entity.getAssembly() > 47;
        ds3.visible = entity.getAssembly() > 48;
        e3.visible = entity.getAssembly() > 49;
        f3.visible = entity.getAssembly() > 50;
        fs3.visible = entity.getAssembly() > 51;
        g3.visible = entity.getAssembly() > 52;
        gs3.visible = entity.getAssembly() > 53;
        a3.visible = entity.getAssembly() > 54;
        as3.visible = entity.getAssembly() > 55;
        b3.visible = entity.getAssembly() > 56;

        c4.visible = entity.getAssembly() > 57;
        cs4.visible = entity.getAssembly() > 58;
        d4.visible = entity.getAssembly() > 59;
        ds4.visible = entity.getAssembly() > 60;
        e4.visible = entity.getAssembly() > 61;
        f4.visible = entity.getAssembly() > 62;
        fs4.visible = entity.getAssembly() > 63;
        g4.visible = entity.getAssembly() > 64;
        gs4.visible = entity.getAssembly() > 65;
        a4.visible = entity.getAssembly() > 66;
        as4.visible = entity.getAssembly() > 67;
        b4.visible = entity.getAssembly() > 68;

        c5.visible = entity.getAssembly() > 69;
        cs5.visible = entity.getAssembly() > 70;
        d5.visible = entity.getAssembly() > 71;
        ds5.visible = entity.getAssembly() > 72;
        e5.visible = entity.getAssembly() > 73;
        f5.visible = entity.getAssembly() > 74;
        fs5.visible = entity.getAssembly() > 75;
        g5.visible = entity.getAssembly() > 76;
        gs5.visible = entity.getAssembly() > 77;
        a5.visible = entity.getAssembly() > 78;
        as5.visible = entity.getAssembly() > 79;
        b5.visible = entity.getAssembly() > 80;

        c6.visible = entity.getAssembly() > 81;
        cs6.visible = entity.getAssembly() > 82;
        d6.visible = entity.getAssembly() > 83;
        ds6.visible = entity.getAssembly() > 84;
        e6.visible = entity.getAssembly() > 85;
        f6.visible = entity.getAssembly() > 86;
        fs6.visible = entity.getAssembly() > 87;
        g6.visible = entity.getAssembly() > 88;
        gs6.visible = entity.getAssembly() > 89;
        a6.visible = entity.getAssembly() > 90;
        as6.visible = entity.getAssembly() > 91;
        b6.visible = entity.getAssembly() > 92;

        c7.visible = entity.getAssembly() > 93;
        cs7.visible = entity.getAssembly() > 94;
        d7.visible = entity.getAssembly() > 95;
        ds7.visible = entity.getAssembly() > 96;
        e7.visible = entity.getAssembly() > 97;
        f7.visible = entity.getAssembly() > 98;
        fs7.visible = entity.getAssembly() > 99;
        g7.visible = entity.getAssembly() > 100;
        gs7.visible = entity.getAssembly() > 101;
        a7.visible = entity.getAssembly() > 102;
        as7.visible = entity.getAssembly() > 103;
        b7.visible = entity.getAssembly() > 104;

        stand.visible = false;
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
