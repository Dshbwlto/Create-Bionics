package net.dshbwlto.createbionics.entity.client.organ;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.custom.OrganEntity;
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
    private final ModelPart leg_l2;
    private final ModelPart leg_l_p;
    private final ModelPart leg_l3;
    private final ModelPart foot_l;
    private final ModelPart leg_r2;
    private final ModelPart leg_r_p;
    private final ModelPart leg_r3;
    private final ModelPart foot_r;

    private final ModelPart stand;

    private final ModelPart blink0;
    private final ModelPart blink1;
    private final ModelPart blink2;

    public OrganModel(ModelPart root) {
        this.root = root.getChild("root");

        this.body = this.root.getChild("root_util").getChild("body");
        this.chest = this.root.getChild("root_util").getChild("body").getChild("chest");
        this.stand = this.root.getChild("root_util").getChild("body").getChild("stand");
        this.neck = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck");
        this.head = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head");
        this.tail1 = this.root.getChild("root_util").getChild("body").getChild("tail1");
        this.tail2 = this.root.getChild("root_util").getChild("body").getChild("tail1").getChild("tail2");
        this.leg_l_p = this.root.getChild("root_util").getChild("leg_l_p");
        this.leg_l2 = this.root.getChild("root_util").getChild("leg_l_p").getChild("leg_l2");
        this.leg_l3 = this.root.getChild("root_util").getChild("leg_l_p").getChild("leg_l2").getChild("leg_l3");
        this.foot_l = this.root.getChild("root_util").getChild("leg_l_p").getChild("foot_l");
        this.leg_r_p = this.root.getChild("root_util").getChild("leg_r_p");
        this.leg_r2 = this.root.getChild("root_util").getChild("leg_r_p").getChild("leg_r2");
        this.leg_r3 = this.root.getChild("root_util").getChild("leg_r_p").getChild("leg_r2").getChild("leg_r3");
        this.foot_r = this.root.getChild("root_util").getChild("leg_r_p").getChild("foot_r");

        this.blink0 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("blink0");
        this.blink1 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("blink1");
        this.blink2 = this.root.getChild("root_util").getChild("body").getChild("chest").getChild("neck").getChild("head").getChild("blink2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create().texOffs(94, 151).addBox(-12.0F, -15.0F, -12.0F, 24.0F, 19.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(160, 45).addBox(-8.0F, 6.0F, -12.0F, 16.0F, 16.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-7.0F, 7.0F, -25.0F, 14.0F, 14.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(-7.0F, 7.0F, 15.0F, 14.0F, 14.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(26, 45).addBox(-5.0F, 9.0F, 12.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(26, 45).addBox(-5.0F, 9.0F, -28.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-5.0F, 9.0F, -15.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-5.0F, 9.0F, 25.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(160, 92).addBox(-2.0F, -4.0F, -15.0F, 4.0F, 11.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(198, 106).addBox(-4.0F, -10.0F, 29.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(198, 90).addBox(-4.0F, -10.0F, -37.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 145).addBox(-4.0F, -23.0F, -15.0F, 8.0F, 19.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(110, 0).addBox(-15.0F, -23.0F, 15.0F, 30.0F, 30.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0F, -38.0F, -24.0F, 26.0F, 11.0F, 58.0F, new CubeDeformation(0.0F))
                .texOffs(0, 69).addBox(-24.0F, -27.0F, -30.0F, 48.0F, 12.0F, 64.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(20.0104F, -14.9749F, 19.0F, 7.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(26, 0).addBox(21.0104F, -13.9749F, 18.0F, 5.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(20.0104F, -14.9749F, -25.0F, 7.0F, 15.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(26, 0).addBox(21.0104F, -13.9749F, -26.0F, 5.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(110, 44).addBox(-11.0F, -1.0F, 29.0F, 22.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(110, 44).addBox(-11.0F, -17.0F, 29.0F, 22.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 69).addBox(-11.0F, -17.0F, -37.0F, 22.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 69).addBox(-11.0F, -1.0F, -37.0F, 22.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(198, 0).addBox(-15.0F, -23.0F, -29.0F, 30.0F, 30.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(26, 0).addBox(-26.0104F, -13.9749F, 18.0F, 5.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).mirror().addBox(-27.0104F, -14.9749F, 19.0F, 7.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 0).addBox(-26.0104F, -13.9749F, -26.0F, 5.0F, 13.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).mirror().addBox(-27.0104F, -14.9749F, -25.0F, 7.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -80.0F, -6.25F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 152).mirror().addBox(-1.85F, -10.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(52, 152).mirror().addBox(-1.85F, -10.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 83).addBox(0.0F, -1.0F, -46.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 88).addBox(0.0F, -5.0F, -45.0F, 13.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 83).addBox(0.0F, -6.0F, -46.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 83).addBox(0.0F, -1.0F, -2.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 88).addBox(0.0F, -5.0F, -1.0F, 13.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 83).addBox(0.0F, -6.0F, -2.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 5.0F, 22.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 83).mirror().addBox(-13.0F, -1.0F, -46.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 88).mirror().addBox(-13.0F, -5.0F, -45.0F, 13.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 83).mirror().addBox(-13.0F, -6.0F, -46.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 83).mirror().addBox(-13.0F, -1.0F, -2.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 88).mirror().addBox(-13.0F, -5.0F, -1.0F, 13.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 83).mirror().addBox(-13.0F, -6.0F, -2.0F, 13.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.0F, 5.0F, 22.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(46, 149).addBox(1.0F, -9.0F, -14.0F, 14.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(46, 149).addBox(1.0F, 5.0F, -14.0F, 14.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, 4.0F, 0.0F, 1.5708F, 0.0F, -0.3927F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(46, 149).mirror().addBox(-15.0F, -9.0F, -14.0F, 14.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(46, 149).mirror().addBox(-15.0F, 5.0F, -14.0F, 14.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(18.0F, 4.0F, 0.0F, 1.5708F, 0.0F, 0.3927F));

        PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(52, 152).addBox(-2.15F, -10.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(174, 286).addBox(-12.0F, -2.0F, 0.0F, 24.0F, 26.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(174, 286).addBox(-12.0F, -2.0F, 18.0F, 24.0F, 26.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(544, 175).addBox(-9.0F, 1.0F, 3.0F, 18.0F, 20.0F, 71.0F, new CubeDeformation(0.0F))
                .texOffs(0, 344).addBox(-1.0F, -2.0F, 3.0F, 2.0F, 3.0F, 71.0F, new CubeDeformation(0.0F))
                .texOffs(45, 389).addBox(-1.0F, 21.0F, 3.0F, 2.0F, 3.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(822, 78).addBox(9.0F, 14.0F, 3.0F, 2.0F, 2.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(822, 78).addBox(9.0F, 6.0F, 3.0F, 2.0F, 2.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(822, 78).mirror().addBox(-11.0F, 6.0F, 3.0F, 2.0F, 2.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(822, 78).mirror().addBox(-11.0F, 14.0F, 3.0F, 2.0F, 2.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(174, 286).addBox(-12.0F, -2.0F, 36.0F, 24.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(174, 286).addBox(-12.0F, -2.0F, 54.0F, 24.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(174, 286).addBox(-12.0F, -2.0F, 72.0F, 24.0F, 26.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(160, 192).addBox(3.0F, 24.0F, 59.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(0.0F, 8.0F, 69.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(-14.0F, 8.0F, 69.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(-14.0F, 8.0F, 33.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(0.0F, 8.0F, 33.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(-14.0F, 8.0F, 42.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(0.0F, 8.0F, 42.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(-14.0F, 8.0F, 51.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(0.0F, 8.0F, 51.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(-14.0F, 8.0F, 60.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(246, 191).addBox(0.0F, 8.0F, 60.5F, 14.0F, 18.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(160, 192).addBox(3.0F, 24.0F, 44.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(160, 192).addBox(3.0F, 24.0F, 29.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(160, 192).addBox(-3.0F, 24.0F, 29.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(160, 192).addBox(-3.0F, 24.0F, 44.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(160, 192).addBox(-3.0F, 24.0F, 59.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(145, 164).addBox(-14.0F, 6.0F, 29.0F, 28.0F, 20.0F, 45.0F, new CubeDeformation(0.0F))
                .texOffs(0, 285).addBox(-12.0F, 6.0F, 31.0F, 24.0F, 18.0F, 41.0F, new CubeDeformation(0.0F))
                .texOffs(0, 195).addBox(-15.0F, -14.0F, 0.0F, 30.0F, 12.0F, 78.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 34.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(272, 145).addBox(-8.0F, -8.0F, -5.0F, 16.0F, 23.0F, 98.0F, new CubeDeformation(0.0F))
                .texOffs(312, 233).addBox(-11.0F, -11.0F, 86.0F, 22.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(402, 168).addBox(-11.0F, 15.0F, -5.0F, 22.0F, 3.0F, 98.0F, new CubeDeformation(0.0F))
                .texOffs(142, 229).addBox(-11.0F, -14.0F, 0.0F, 22.0F, 12.0F, 86.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 76.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition steam_tail = tail1.addOrReplaceChild("steam_tail", CubeListBuilder.create(), PartPose.offset(12.0F, 24.0F, 38.0F));

        PartDefinition steam_exhaust_b_r1 = steam_tail.addOrReplaceChild("steam_exhaust_b_r1", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.6859F, 0.989F, -1.143F));

        PartDefinition steam_exhaust_b_r2 = steam_tail.addOrReplaceChild("steam_exhaust_b_r2", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2818F, 0.5161F, 2.5292F));

        PartDefinition steam_exhaust_b_r3 = steam_tail.addOrReplaceChild("steam_exhaust_b_r3", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 0.1555F, 0.6555F, 2.4591F));

        PartDefinition steam_exhaust_b_r4 = steam_tail.addOrReplaceChild("steam_exhaust_b_r4", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 9.0F, 2.9428F, 0.8998F, -0.9342F));

        PartDefinition steam_exhaust_b_r5 = steam_tail.addOrReplaceChild("steam_exhaust_b_r5", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -2.9861F, 0.6555F, -0.6825F));

        PartDefinition steam_exhaust_b_r6 = steam_tail.addOrReplaceChild("steam_exhaust_b_r6", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -0.1988F, 0.8998F, 2.2074F));

        PartDefinition steam_exhaust_b_r7 = steam_tail.addOrReplaceChild("steam_exhaust_b_r7", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -0.4557F, 0.989F, 1.9986F));

        PartDefinition steam_exhaust_b_r8 = steam_tail.addOrReplaceChild("steam_exhaust_b_r8", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, -2.8598F, 0.5161F, -0.6124F));

        PartDefinition steam_exhaust_b_r9 = steam_tail.addOrReplaceChild("steam_exhaust_b_r9", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 27.0F, -2.8598F, 0.5161F, -1.0488F));

        PartDefinition steam_exhaust_b_r10 = steam_tail.addOrReplaceChild("steam_exhaust_b_r10", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 27.0F, -0.4557F, 0.989F, 1.5623F));

        PartDefinition steam_exhaust_b_r11 = steam_tail.addOrReplaceChild("steam_exhaust_b_r11", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 18.0F, -2.9861F, 0.6555F, -1.1188F));

        PartDefinition steam_exhaust_b_r12 = steam_tail.addOrReplaceChild("steam_exhaust_b_r12", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 18.0F, -0.1988F, 0.8998F, 1.771F));

        PartDefinition steam_exhaust_b_r13 = steam_tail.addOrReplaceChild("steam_exhaust_b_r13", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 9.0F, 2.9428F, 0.8998F, -1.3706F));

        PartDefinition steam_exhaust_b_r14 = steam_tail.addOrReplaceChild("steam_exhaust_b_r14", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.0F, 0.0F, 0.2818F, 0.5161F, 2.0928F));

        PartDefinition steam_exhaust_b_r15 = steam_tail.addOrReplaceChild("steam_exhaust_b_r15", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 0.0F, 2.6859F, 0.989F, -1.5793F));

        PartDefinition steam_exhaust_b_r16 = steam_tail.addOrReplaceChild("steam_exhaust_b_r16", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -14.0F, 9.0F, 0.1555F, 0.6555F, 2.0228F));

        PartDefinition steam_exhaust_b_r17 = steam_tail.addOrReplaceChild("steam_exhaust_b_r17", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 0.0F, 2.6859F, -0.989F, 1.5793F));

        PartDefinition steam_exhaust_b_r18 = steam_tail.addOrReplaceChild("steam_exhaust_b_r18", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 0.0F, 0.2818F, -0.5161F, -2.0928F));

        PartDefinition steam_exhaust_b_r19 = steam_tail.addOrReplaceChild("steam_exhaust_b_r19", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 9.0F, 0.1555F, -0.6555F, -2.0228F));

        PartDefinition steam_exhaust_b_r20 = steam_tail.addOrReplaceChild("steam_exhaust_b_r20", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 9.0F, 2.9428F, -0.8998F, 1.3706F));

        PartDefinition steam_exhaust_b_r21 = steam_tail.addOrReplaceChild("steam_exhaust_b_r21", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 18.0F, -2.9861F, -0.6555F, 1.1188F));

        PartDefinition steam_exhaust_b_r22 = steam_tail.addOrReplaceChild("steam_exhaust_b_r22", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 18.0F, -0.1988F, -0.8998F, -1.771F));

        PartDefinition steam_exhaust_b_r23 = steam_tail.addOrReplaceChild("steam_exhaust_b_r23", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -14.0F, 27.0F, -0.4557F, -0.989F, -1.5623F));

        PartDefinition steam_exhaust_b_r24 = steam_tail.addOrReplaceChild("steam_exhaust_b_r24", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.0F, -14.0F, 27.0F, -2.8598F, -0.5161F, 1.0488F));

        PartDefinition steam_exhaust_b_r25 = steam_tail.addOrReplaceChild("steam_exhaust_b_r25", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 0.2818F, -0.5161F, -2.5292F));

        PartDefinition steam_exhaust_b_r26 = steam_tail.addOrReplaceChild("steam_exhaust_b_r26", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 0.0F, 2.6859F, -0.989F, 1.143F));

        PartDefinition steam_exhaust_b_r27 = steam_tail.addOrReplaceChild("steam_exhaust_b_r27", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 9.0F, 2.9428F, -0.8998F, 0.9342F));

        PartDefinition steam_exhaust_b_r28 = steam_tail.addOrReplaceChild("steam_exhaust_b_r28", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 9.0F, 0.1555F, -0.6555F, -2.4591F));

        PartDefinition steam_exhaust_b_r29 = steam_tail.addOrReplaceChild("steam_exhaust_b_r29", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 18.0F, -0.1988F, -0.8998F, -2.2074F));

        PartDefinition steam_exhaust_b_r30 = steam_tail.addOrReplaceChild("steam_exhaust_b_r30", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 18.0F, -2.9861F, -0.6555F, 0.6825F));

        PartDefinition steam_exhaust_b_r31 = steam_tail.addOrReplaceChild("steam_exhaust_b_r31", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.0F, 0.0F, 27.0F, -0.4557F, -0.989F, -1.9986F));

        PartDefinition steam_exhaust_b_r32 = steam_tail.addOrReplaceChild("steam_exhaust_b_r32", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.0F, 0.0F, 27.0F, -2.8598F, -0.5161F, 0.6124F));

        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(170, 85).addBox(-20.0F, -16.0F, -60.0F, 40.0F, 19.0F, 60.0F, new CubeDeformation(0.0F))
                .texOffs(435, 34).addBox(-9.0F, 3.0F, -5.0F, 18.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(240, 22).addBox(-23.0F, -4.0F, -55.0F, 46.0F, 13.0F, 50.0F, new CubeDeformation(0.0F))
                .texOffs(437, 1).addBox(-7.0F, 9.0F, -20.0F, 14.0F, 8.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(400, 53).addBox(-8.0F, 22.0F, -46.0F, 16.0F, 16.0F, 32.0F, new CubeDeformation(0.0F))
                .texOffs(368, 90).addBox(-7.0F, 23.0F, -48.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(368, 106).addBox(-5.0F, 25.0F, -50.0F, 10.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(310, 88).addBox(-4.0F, 26.0F, -52.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(368, 118).addBox(-4.0F, 26.0F, -60.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(310, 110).addBox(-4.0F, 6.0F, -60.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(310, 98).addBox(-4.0F, 22.0F, -60.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(392, 106).addBox(-7.0F, 23.0F, -14.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(453, 58).addBox(-1.0F, 32.0F, -51.5F, 2.0F, 10.0F, 43.0F, new CubeDeformation(0.0F))
                .texOffs(400, 101).addBox(-0.1421F, 39.1421F, -49.5F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(402, 101).addBox(-0.2635F, 34.1924F, -49.5F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(400, 122).addBox(-0.1421F, 35.1421F, -48.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(402, 101).addBox(-0.2635F, 34.1924F, -14.5F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(400, 122).addBox(-0.1421F, 35.1421F, -13.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(400, 101).addBox(-0.1421F, 39.1421F, -14.5F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(382, 48).addBox(15.0F, 12.0F, -17.5F, 8.0F, 14.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(382, 24).mirror().addBox(16.0F, 13.0F, -18.5F, 6.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(382, 24).mirror().addBox(16.0F, 13.0F, -53.5F, 6.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(382, 48).addBox(15.0F, 12.0F, -52.5F, 8.0F, 14.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).addBox(16.0F, 9.0F, -14.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(434, 104).addBox(17.0F, 9.0F, -13.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).addBox(21.0F, 9.0F, -14.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).addBox(21.0F, 9.0F, -49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(434, 104).addBox(17.0F, 9.0F, -48.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).addBox(16.0F, 9.0F, -49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).mirror().addBox(-17.0F, 9.0F, -14.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(434, 104).mirror().addBox(-21.0F, 9.0F, -13.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(424, 101).mirror().addBox(-22.0F, 9.0F, -14.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(424, 101).mirror().addBox(-17.0F, 9.0F, -49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(434, 104).mirror().addBox(-21.0F, 9.0F, -48.5F, 4.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(424, 101).mirror().addBox(-22.0F, 9.0F, -49.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(400, 101).addBox(-7.8579F, 39.1421F, -14.5F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(400, 122).addBox(-7.8579F, 35.1421F, -13.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(402, 101).addBox(-5.7365F, 34.1924F, -14.5F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(402, 101).addBox(-5.7365F, 34.1924F, -49.5F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(400, 122).addBox(-7.8579F, 35.1421F, -48.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(400, 101).addBox(-7.8579F, 39.1421F, -49.5F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(382, 24).mirror().addBox(-22.0F, 13.0F, -53.5F, 6.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(382, 24).mirror().addBox(-22.0F, 13.0F, -18.5F, 6.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(408, 28).mirror().addBox(-20.0F, 15.0F, -41.5F, 2.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(408, 28).addBox(18.0F, 15.0F, -41.5F, 2.0F, 2.0F, 23.0F, new CubeDeformation(0.0F))
                .texOffs(406, 1).addBox(17.0F, 20.0F, -41.5F, 4.0F, 4.0F, 23.0F, new CubeDeformation(0.0F))
                .texOffs(382, 48).mirror().addBox(-23.0F, 12.0F, -52.5F, 8.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(382, 48).mirror().addBox(-23.0F, 12.0F, -17.5F, 8.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(406, 1).mirror().addBox(-21.0F, 20.0F, -41.5F, 4.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(387, 9).addBox(-7.0F, 9.0F, -29.0F, 14.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(310, 96).addBox(-5.0F, 4.0F, -58.0F, 10.0F, 11.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -30.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r7 = chest.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(424, 101).mirror().addBox(5.0F, 0.0F, -2.0F, 1.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(424, 101).mirror().addBox(0.0F, 0.0F, -2.0F, 1.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(434, 104).mirror().addBox(1.0F, 0.0F, -1.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.001F)).mirror(false)
                .texOffs(434, 104).mirror().addBox(1.0F, 0.0F, 34.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.001F)).mirror(false)
                .texOffs(424, 101).mirror().addBox(0.0F, 0.0F, 33.0F, 1.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(424, 101).mirror().addBox(5.0F, 0.0F, 33.0F, 1.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.0F, 26.0F, -47.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r8 = chest.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(424, 101).addBox(-6.0F, 0.0F, 34.0F, 1.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).addBox(-1.0F, 0.0F, 34.0F, 1.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(434, 104).addBox(-5.0F, 0.0F, 35.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.001F))
                .texOffs(434, 104).addBox(-5.0F, 0.0F, 0.0F, 4.0F, 19.0F, 2.0F, new CubeDeformation(0.001F))
                .texOffs(424, 101).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 20.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(424, 101).addBox(-6.0F, 0.0F, -1.0F, 1.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, 26.0F, -48.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bellows_l = chest.addOrReplaceChild("bellows_l", CubeListBuilder.create().texOffs(305, 274).addBox(-25.0F, -7.9F, -27.0F, 25.0F, 16.0F, 53.0F, new CubeDeformation(0.0F))
                .texOffs(75, 327).addBox(-27.0F, -11.9F, -29.0F, 29.0F, 4.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.1F, -32.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition bellows_middle_l = bellows_l.addOrReplaceChild("bellows_middle_l", CubeListBuilder.create().texOffs(190, 332).addBox(-13.0F, -1.0F, -55.0F, 27.0F, 2.0F, 55.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -11.9F, 27.0F));

        PartDefinition bellows_fabric_top_l = bellows_middle_l.addOrReplaceChild("bellows_fabric_top_l", CubeListBuilder.create().texOffs(303, 343).addBox(-12.0F, -21.0F, 0.0F, 25.0F, 21.0F, 51.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -54.0F));

        PartDefinition bellows_fabric_bottom_l = bellows_middle_l.addOrReplaceChild("bellows_fabric_bottom_l", CubeListBuilder.create().texOffs(303, 415).addBox(-12.0F, 0.0F, 0.0F, 25.0F, 21.0F, 51.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -54.0F));

        PartDefinition bellows_top_l = bellows_l.addOrReplaceChild("bellows_top_l", CubeListBuilder.create().texOffs(75, 327).addBox(-14.0F, -4.0F, -56.0F, 29.0F, 4.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(81, 364).addBox(-7.0F, -13.0F, -18.0F, 15.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(26, 45).addBox(-4.5F, -11.5F, -21.0F, 10.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(26, 45).addBox(-4.5F, -11.5F, -54.0F, 10.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(116, 388).addBox(-7.0F, -13.0F, -51.0F, 15.0F, 9.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -11.9F, 27.0F));

        PartDefinition bellows_gear_l = bellows_l.addOrReplaceChild("bellows_gear_l", CubeListBuilder.create().texOffs(144, 285).addBox(-3.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(-4.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(-17.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(-16.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -11.9F, 27.0F));

        PartDefinition cube_r9 = bellows_gear_l.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(-5.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(8.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r10 = bellows_gear_l.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r11 = bellows_gear_l.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r12 = bellows_gear_l.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(-5.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(8.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r13 = bellows_gear_l.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(104, 307).addBox(-9.0F, -2.0F, -2.0F, 31.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(-5.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(108, 285).addBox(8.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r14 = bellows_gear_l.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r15 = bellows_gear_l.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(144, 285).addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(144, 285).addBox(8.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

        PartDefinition bellows_r = chest.addOrReplaceChild("bellows_r", CubeListBuilder.create().texOffs(305, 274).mirror().addBox(0.0F, -7.9F, -27.0F, 25.0F, 16.0F, 53.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(75, 327).mirror().addBox(-2.0F, -11.9F, -29.0F, 29.0F, 4.0F, 56.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -16.1F, -32.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition bellows_middle_r = bellows_r.addOrReplaceChild("bellows_middle_r", CubeListBuilder.create().texOffs(190, 332).mirror().addBox(-14.0F, -1.0F, -55.0F, 27.0F, 2.0F, 55.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.0F, -11.9F, 27.0F));

        PartDefinition bellows_fabric_top_r = bellows_middle_r.addOrReplaceChild("bellows_fabric_top_r", CubeListBuilder.create().texOffs(303, 343).mirror().addBox(-13.0F, -21.0F, 0.0F, 25.0F, 21.0F, 51.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.0F, -54.0F));

        PartDefinition bellows_fabric_bottom_r = bellows_middle_r.addOrReplaceChild("bellows_fabric_bottom_r", CubeListBuilder.create().texOffs(303, 415).mirror().addBox(-13.0F, 0.0F, 0.0F, 25.0F, 21.0F, 51.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, -54.0F));

        PartDefinition bellows_top_r = bellows_r.addOrReplaceChild("bellows_top_r", CubeListBuilder.create().texOffs(75, 327).mirror().addBox(-15.0F, -4.0F, -56.0F, 29.0F, 4.0F, 56.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(81, 364).mirror().addBox(-8.0F, -13.0F, -18.0F, 15.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 45).mirror().addBox(-5.5F, -11.5F, -21.0F, 10.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 45).mirror().addBox(-5.5F, -11.5F, -54.0F, 10.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(116, 388).mirror().addBox(-8.0F, -13.0F, -51.0F, 15.0F, 9.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.0F, -11.9F, 27.0F));

        PartDefinition bellows_gear_r = bellows_r.addOrReplaceChild("bellows_gear_r", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-5.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-6.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(7.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(7.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.0F, -11.9F, 27.0F));

        PartDefinition cube_r16 = bellows_gear_r.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-5.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-18.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r17 = bellows_gear_r.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r18 = bellows_gear_r.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r19 = bellows_gear_r.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-5.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-18.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r20 = bellows_gear_r.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(104, 307).mirror().addBox(-22.0F, -2.0F, -2.0F, 31.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-5.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 285).mirror().addBox(-18.0F, -1.5F, -8.0F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r21 = bellows_gear_r.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r22 = bellows_gear_r.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(144, 285).mirror().addBox(-4.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(144, 285).mirror().addBox(-17.5F, -7.245F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

        PartDefinition neck_hose_l = chest.addOrReplaceChild("neck_hose_l", CubeListBuilder.create(), PartPose.offset(12.0F, 3.0F, -55.0F));

        PartDefinition cube_r23 = neck_hose_l.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(696, 231).addBox(-6.0F, -18.9F, -16.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(666, 219).addBox(-3.0F, -13.9F, -16.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(672, 227).addBox(-3.0F, -1.9F, -11.0F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.1F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition neck_hose_r = chest.addOrReplaceChild("neck_hose_r", CubeListBuilder.create(), PartPose.offset(-12.0F, 3.0F, -55.0F));

        PartDefinition cube_r24 = neck_hose_r.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(696, 231).mirror().addBox(-3.0F, -18.9F, -17.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(666, 219).mirror().addBox(-3.0F, -13.9F, -17.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.1F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r25 = neck_hose_r.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(672, 227).mirror().addBox(-3.0F, -1.9F, -11.0F, 5.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.1F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(495, 0).addBox(-10.0F, 1.0F, -32.0F, 20.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(500, 0).addBox(-10.0F, -14.0F, -65.0F, 20.0F, 15.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(495, 0).addBox(-10.0F, 1.0F, -13.0F, 20.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(525, 56).addBox(-8.0F, 17.0F, -3.0F, 16.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(495, 0).addBox(-10.0F, 1.0F, -51.0F, 20.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(609, 15).addBox(-6.0F, 5.0F, -65.0F, 12.0F, 12.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(475, 84).addBox(-2.0F, 1.0F, -65.0F, 4.0F, 4.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(702, 27).addBox(-2.0F, 17.0F, -65.0F, 4.0F, 8.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(779, 35).addBox(-9.0F, 13.0F, -65.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(779, 35).addBox(-9.0F, 7.0F, -65.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F))
                .texOffs(836, 106).addBox(-9.0F, -2.0F, 4.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(836, 106).addBox(7.0F, -2.0F, 4.0F, 2.0F, 17.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(779, 35).mirror().addBox(7.0F, 7.0F, -65.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(779, 35).mirror().addBox(7.0F, 13.0F, -65.0F, 2.0F, 2.0F, 69.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, -62.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r26 = neck.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(564, 102).addBox(-1.5F, 10.0F, -46.0F, 6.0F, 6.0F, 57.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 8.0F, -14.0F, 0.0436F, 0.0262F, -0.1309F));

        PartDefinition cube_r27 = neck.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(564, 102).addBox(-4.5F, 10.0F, -46.0F, 6.0F, 6.0F, 57.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 8.0F, -14.0F, 0.0436F, -0.0262F, 0.1309F));

        PartDefinition cube_r28 = neck.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(477, 35).addBox(-6.0F, -12.0F, 0.0F, 12.0F, 12.0F, 11.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(0.0F, 17.0F, 4.0F, 0.6981F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(633, 109).addBox(-14.0F, -6.0F, -24.0F, 28.0F, 26.0F, 24.0F, new CubeDeformation(0.0F))
                .texOffs(900, 70).addBox(-12.0F, -12.563F, -37.8447F, 24.0F, 20.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, -54.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition cube_r29 = head.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -11.306F, -36.2504F, -0.855F, -0.647F, 0.3079F));

        PartDefinition cube_r30 = head.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -11.306F, -36.2504F, -2.3568F, -0.551F, 2.3616F));

        PartDefinition cube_r31 = head.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -12.306F, -12.2504F, -0.6906F, -0.1F, -0.5399F));

        PartDefinition cube_r32 = head.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -12.306F, -12.2504F, -1.7271F, -0.8742F, 1.1512F));

        PartDefinition cube_r33 = head.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.306F, -23.2504F, -1.7271F, -0.8742F, 1.9366F));

        PartDefinition cube_r34 = head.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.306F, -23.2504F, -0.6906F, -0.1F, 0.2455F));

        PartDefinition cube_r35 = head.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.306F, -49.2504F, -2.8102F, 0.815F, -2.6532F));

        PartDefinition cube_r36 = head.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.306F, -49.2504F, -0.2975F, 0.7057F, 0.0467F));

        PartDefinition cube_r37 = head.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.306F, -59.2504F, -0.244F, -0.6804F, -0.1657F));

        PartDefinition cube_r38 = head.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.306F, -59.2504F, -2.8515F, -0.8546F, 2.599F));

        PartDefinition cube_r39 = head.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(906, 126).addBox(-12.0F, -0.471F, -29.63F, 24.0F, 22.0F, 30.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -12.0F, -38.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition steam7_r1 = head.addOrReplaceChild("steam7_r1", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, 8.5F, -47.0F, -0.7743F, 0.0192F, -0.8342F));

        PartDefinition steam7_r2 = head.addOrReplaceChild("steam7_r2", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 8.5F, -47.0F, -1.5433F, -0.7963F, 0.717F));

        PartDefinition steam8_r1 = head.addOrReplaceChild("steam8_r1", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 8.5F, -47.0F, -0.7743F, -0.0192F, 0.8342F));

        PartDefinition steam7_r3 = head.addOrReplaceChild("steam7_r3", CubeListBuilder.create().texOffs(0, 257).mirror().addBox(-8.0F, -16.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(14.0F, 8.5F, -47.0F, -1.5433F, 0.7963F, -0.717F));

        PartDefinition cube_r40 = head.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(819, 106).addBox(-14.0F, -0.007F, -24.987F, 28.0F, 16.0F, 25.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -6.0F, -38.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r41 = head.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 241).addBox(0.0F, -40.85F, -3.009F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(688, 206).addBox(-6.0F, -17.35F, 3.491F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(688, 206).addBox(-4.75F, -12.35F, 15.391F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(698, 208).addBox(-0.25F, -12.35F, 21.891F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(688, 206).addBox(6.25F, -12.35F, 15.391F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(688, 206).addBox(5.0F, -17.35F, 3.491F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(761, 120).addBox(-5.0F, -24.85F, -0.009F, 10.0F, 29.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 257).addBox(-8.0F, -40.85F, 4.991F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.734F, -4.0F, -4.146F, -0.7854F, 0.3927F, 0.0F));

        PartDefinition cube_r42 = head.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(732, 176).mirror().addBox(-5.0F, -9.85F, -19.009F, 10.0F, 10.0F, 19.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(-18.2752F, -5.1642F, -2.8394F, -1.5708F, -0.3927F, 0.0F));

        PartDefinition cube_r43 = head.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(703, 171).mirror().addBox(-4.975F, -9.8508F, -14.0006F, 10.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 241).mirror().addBox(0.025F, -12.8508F, -30.0006F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(-16, 257).mirror().addBox(-7.975F, -4.8508F, -30.0006F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.2752F, -24.0392F, -2.8894F, -2.3562F, -0.3927F, 0.0F));

        PartDefinition cube_r44 = head.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(-16, 257).addBox(-8.025F, -4.8508F, -30.0006F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 241).addBox(-0.025F, -12.8508F, -30.0006F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(703, 171).addBox(-5.025F, -9.8508F, -14.0006F, 10.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.2752F, -24.0392F, -2.8894F, -2.3562F, 0.3927F, 0.0F));

        PartDefinition cube_r45 = head.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(732, 176).addBox(-5.0F, -9.85F, -19.009F, 10.0F, 10.0F, 19.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(18.2752F, -5.1642F, -2.8394F, -1.5708F, 0.3927F, 0.0F));

        PartDefinition cube_r46 = head.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(688, 206).mirror().addBox(3.75F, -12.35F, 15.391F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(688, 206).mirror().addBox(-6.0F, -17.35F, 3.491F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(688, 206).mirror().addBox(-7.25F, -12.35F, 15.391F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(688, 206).mirror().addBox(5.0F, -17.35F, 3.491F, 1.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(698, 208).mirror().addBox(-2.75F, -12.35F, 21.891F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(698, 208).mirror().addBox(-2.75F, -12.35F, 21.891F, 3.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 257).mirror().addBox(-8.0F, -40.85F, 4.991F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 241).mirror().addBox(0.0F, -40.85F, -3.009F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(761, 120).mirror().addBox(-5.0F, -24.85F, -0.009F, 10.0F, 29.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.734F, -4.0F, -4.146F, -0.7854F, -0.3927F, 0.0F));

        PartDefinition cube_r47 = head.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(684, 209).mirror().addBox(-4.15F, 17.4F, 5.48F, 1.0F, 3.0F, 12.0F, new CubeDeformation(-0.02F)).mirror(false)
                .texOffs(684, 209).mirror().addBox(-3.0F, 5.5F, 2.63F, 1.0F, 3.0F, 12.0F, new CubeDeformation(-0.02F)).mirror(false)
                .texOffs(698, 212).mirror().addBox(0.3F, 23.975F, 5.48F, 3.0F, 1.0F, 12.0F, new CubeDeformation(-0.02F)).mirror(false)
                .texOffs(657, 171).mirror().addBox(-2.0F, 2.0F, -2.87F, 10.0F, 10.0F, 24.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(-14.0F, -6.0F, -21.0F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r48 = head.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 257).addBox(-8.0F, -40.85F, 4.991F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(745, 143).addBox(-2.0F, -17.85F, -2.009F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(761, 120).addBox(-5.0F, -24.85F, -0.009F, 10.0F, 29.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 241).addBox(0.0F, -40.85F, -3.009F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 257).addBox(-8.0F, -40.85F, 4.991F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.734F, 8.0F, -0.146F, -0.7854F, 0.3927F, 0.0F));

        PartDefinition cube_r49 = head.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(524, 35).addBox(1.0F, 7.0F, 24.93F, 4.0F, 7.0F, 7.0F, new CubeDeformation(-0.02F))
                .texOffs(531, 34).mirror().addBox(1.0F, 7.0F, 3.93F, 4.0F, 7.0F, 15.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(-14.0F, -6.0F, -21.0F, 0.7854F, -0.3927F, 0.0F));

        PartDefinition cube_r50 = head.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(745, 143).mirror().addBox(-2.0F, -17.85F, -2.009F, 4.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 241).mirror().addBox(0.0F, -40.85F, -3.009F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 257).mirror().addBox(-8.0F, -40.85F, 4.991F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(761, 120).mirror().addBox(-5.0F, -24.85F, -0.009F, 10.0F, 29.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-20.734F, 8.0F, -0.146F, -0.7854F, -0.3927F, 0.0F));

        PartDefinition cube_r51 = head.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(723, 145).mirror().addBox(1.0F, 0.0F, -0.87F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(655, 169).mirror().addBox(-2.0F, 2.0F, -4.87F, 10.0F, 10.0F, 26.0F, new CubeDeformation(-0.02F)).mirror(false), PartPose.offsetAndRotation(-17.0F, 6.0F, -17.0F, 0.0F, -0.3927F, 0.0F));

        PartDefinition cube_r52 = head.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(723, 145).addBox(-5.0F, 0.0F, -0.87F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(655, 169).addBox(-8.0F, 2.0F, -4.87F, 10.0F, 10.0F, 26.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(17.0F, 6.0F, -17.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r53 = head.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(698, 212).addBox(-3.3F, 23.975F, 5.48F, 3.0F, 1.0F, 12.0F, new CubeDeformation(-0.02F))
                .texOffs(684, 209).addBox(3.2F, 17.45F, 5.48F, 1.0F, 3.0F, 12.0F, new CubeDeformation(-0.02F))
                .texOffs(684, 209).addBox(2.0F, 5.5F, 2.63F, 1.0F, 3.0F, 12.0F, new CubeDeformation(-0.02F))
                .texOffs(657, 171).addBox(-8.0F, 2.0F, -2.87F, 10.0F, 10.0F, 24.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(14.0F, -6.0F, -21.0F, 0.0F, 0.3927F, 0.0F));

        PartDefinition cube_r54 = head.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(524, 35).mirror().addBox(-5.0F, 7.0F, 24.93F, 4.0F, 7.0F, 7.0F, new CubeDeformation(-0.02F)).mirror(false)
                .texOffs(531, 34).addBox(-5.0F, 7.0F, 3.93F, 4.0F, 7.0F, 15.0F, new CubeDeformation(-0.02F)), PartPose.offsetAndRotation(14.0F, -6.0F, -21.0F, 0.7854F, 0.3927F, 0.0F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(688, 232).addBox(-12.0F, 4.0F, -26.0F, 24.0F, 13.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -9.0F));

        PartDefinition cube_r55 = jaw.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(779, 147).addBox(-12.0F, -0.01F, -21.99F, 24.0F, 13.0F, 22.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 4.0F, -26.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition blink2 = head.addOrReplaceChild("blink2", CubeListBuilder.create().texOffs(852, 74).addBox(-14.0F, 0.0F, 13.0F, 28.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -51.0F));

        PartDefinition blink1 = head.addOrReplaceChild("blink1", CubeListBuilder.create().texOffs(852, 44).addBox(-14.0F, 0.0F, 13.0F, 28.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -51.0F));

        PartDefinition blink0 = head.addOrReplaceChild("blink0", CubeListBuilder.create().texOffs(852, 14).addBox(-14.0F, 0.0F, 13.0F, 28.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -51.0F));

        PartDefinition piston_parent_r = chest.addOrReplaceChild("piston_parent_r", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.0F, 3.0F, -48.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition piston_r1 = piston_parent_r.addOrReplaceChild("piston_r1", CubeListBuilder.create().texOffs(216, 49).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition piston_2_r1 = piston_r1.addOrReplaceChild("piston_2_r1", CubeListBuilder.create().texOffs(244, 49).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_r2 = piston_parent_r.addOrReplaceChild("piston_r2", CubeListBuilder.create().texOffs(216, 49).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 13.0F));

        PartDefinition piston_2_r2 = piston_r2.addOrReplaceChild("piston_2_r2", CubeListBuilder.create().texOffs(244, 49).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_r3 = piston_parent_r.addOrReplaceChild("piston_r3", CubeListBuilder.create().texOffs(216, 49).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 25.0F));

        PartDefinition piston_2_r3 = piston_r3.addOrReplaceChild("piston_2_r3", CubeListBuilder.create().texOffs(244, 49).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_r4 = piston_parent_r.addOrReplaceChild("piston_r4", CubeListBuilder.create().texOffs(216, 49).mirror().addBox(-17.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 37.0F));

        PartDefinition piston_2_r4 = piston_r4.addOrReplaceChild("piston_2_r4", CubeListBuilder.create().texOffs(244, 49).mirror().addBox(0.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-13.0F, 0.0F, -1.0F));

        PartDefinition piston_parent_l = chest.addOrReplaceChild("piston_parent_l", CubeListBuilder.create(), PartPose.offsetAndRotation(20.0F, 3.0F, -48.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition piston_l1 = piston_parent_l.addOrReplaceChild("piston_l1", CubeListBuilder.create().texOffs(216, 49).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition piston_2_l1 = piston_l1.addOrReplaceChild("piston_2_l1", CubeListBuilder.create().texOffs(244, 49).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_l2 = piston_parent_l.addOrReplaceChild("piston_l2", CubeListBuilder.create().texOffs(216, 49).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 13.0F));

        PartDefinition piston_2_l2 = piston_l2.addOrReplaceChild("piston_2_l2", CubeListBuilder.create().texOffs(244, 49).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_l3 = piston_parent_l.addOrReplaceChild("piston_l3", CubeListBuilder.create().texOffs(216, 49).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 25.0F));

        PartDefinition piston_2_l3 = piston_l3.addOrReplaceChild("piston_2_l3", CubeListBuilder.create().texOffs(244, 49).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition piston_l4 = piston_parent_l.addOrReplaceChild("piston_l4", CubeListBuilder.create().texOffs(216, 49).addBox(13.0F, -5.0F, -6.0F, 4.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 37.0F));

        PartDefinition piston_2_l4 = piston_l4.addOrReplaceChild("piston_2_l4", CubeListBuilder.create().texOffs(244, 49).addBox(-12.0F, -5.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, 0.0F, -1.0F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_l_p = root_util.addOrReplaceChild("leg_l_p", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_l = leg_l_p.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(274, 135).addBox(7.05F, -14.5F, -14.5F, 0.0F, 29.0F, 29.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(274, 135).addBox(7.05F, -14.5F, -14.5F, 0.0F, 29.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -76.0F, -6.4F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r56 = leg_l.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r57 = leg_l.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r58 = leg_l.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r59 = leg_l.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r60 = leg_l.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r61 = leg_l.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r62 = leg_l.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(22, 89).addBox(3.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r63 = leg_l.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-1.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition leg_l2 = leg_l_p.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(402, 179).addBox(1.603F, -5.955F, -9.0F, 12.0F, 38.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(478, 208).addBox(3.603F, -3.955F, 17.0F, 8.0F, 34.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(478, 208).addBox(3.603F, -3.955F, -10.0F, 8.0F, 34.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(0.5F, 22.344F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 176).addBox(14.575F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 176).mirror().addBox(0.425F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(402, 179).addBox(1.603F, -5.955F, -9.0F, 12.0F, 38.0F, 26.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(0.5F, 22.344F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 176).addBox(14.55F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 176).mirror().addBox(0.45F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(18.0F, -75.6711F, -6.5197F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r64 = leg_l2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r65 = leg_l2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r66 = leg_l2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r67 = leg_l2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r68 = leg_l2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r69 = leg_l2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r70 = leg_l2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 212).addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, 32.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition leg_l3 = leg_l2.addOrReplaceChild("leg_l3", CubeListBuilder.create().texOffs(426, 132).addBox(-3.25F, -1.0F, -10.5F, 6.0F, 38.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(464, 185).addBox(-3.25F, 37.0F, -11.0F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(402, 165).addBox(-5.25F, -1.0F, -12.5F, 10.0F, 38.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(402, 165).addBox(-5.25F, -1.0F, -1.5F, 10.0F, 38.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(452, 187).addBox(-1.7F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(452, 187).addBox(-1.7F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.75F, 32.0F, 0.0F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r71 = leg_l3.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r72 = leg_l3.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

        PartDefinition cube_r73 = leg_l3.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r74 = leg_l3.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(452, 187).addBox(5.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition foot_l = leg_l_p.addOrReplaceChild("foot_l", CubeListBuilder.create().texOffs(488, 130).addBox(-6.0F, 0.0F, -8.0F, 12.0F, 7.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(464, 125).addBox(-4.0F, -2.0F, 10.0F, 8.0F, 9.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(291, 212).addBox(-8.0F, -2.0F, -22.0F, 16.0F, 9.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(464, 146).addBox(-5.0F, 1.0F, -10.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(464, 146).addBox(-5.0F, 1.0F, 8.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(452, 175).addBox(-8.25F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(25.75F, -6.9211F, -0.0197F));

        PartDefinition leg_r_p = root_util.addOrReplaceChild("leg_r_p", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_r = leg_r_p.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(274, 135).mirror().addBox(-7.05F, -14.5F, -14.5F, 0.0F, 29.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(274, 135).mirror().addBox(-7.05F, -14.5F, -14.5F, 0.0F, 29.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.0F, -76.0F, -6.4F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r75 = leg_r.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r76 = leg_r.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r77 = leg_r.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r78 = leg_r.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r79 = leg_r.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r80 = leg_r.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r81 = leg_r.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 89).mirror().addBox(-7.0F, -0.515F, -6.0F, 4.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r82 = leg_r.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(-3.0F, -0.1F, -7.0F, 4.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition leg_r2 = leg_r_p.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(402, 179).mirror().addBox(-13.603F, -5.955F, -9.0F, 12.0F, 38.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(478, 208).mirror().addBox(-11.603F, -3.955F, 17.0F, 8.0F, 34.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(478, 208).mirror().addBox(-11.603F, -3.955F, -10.0F, 8.0F, 34.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-14.5F, 22.344F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 176).mirror().addBox(-14.575F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 176).addBox(-0.425F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(402, 179).mirror().addBox(-13.603F, -5.955F, -9.0F, 12.0F, 38.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-14.5F, 22.344F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 176).mirror().addBox(-14.55F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 176).addBox(-0.45F, 23.0F, -9.0F, 0.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -75.6711F, -6.5197F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r83 = leg_r2.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r84 = leg_r2.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r85 = leg_r2.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r86 = leg_r2.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r87 = leg_r2.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

        PartDefinition cube_r88 = leg_r2.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r89 = leg_r2.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 212).mirror().addBox(-7.0F, -9.656F, -4.0F, 14.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.5F, 32.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition leg_r3 = leg_r2.addOrReplaceChild("leg_r3", CubeListBuilder.create().texOffs(426, 132).mirror().addBox(-2.75F, -1.0F, -10.5F, 6.0F, 38.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(464, 185).mirror().addBox(-2.75F, 37.0F, -11.0F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(402, 165).mirror().addBox(-4.75F, -1.0F, -12.5F, 10.0F, 38.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(402, 165).mirror().addBox(-4.75F, -1.0F, -1.5F, 10.0F, 38.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 187).mirror().addBox(-1.3F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 187).mirror().addBox(-1.3F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.75F, 32.0F, 0.0F, 0.9163F, 0.0F, 0.0F));

        PartDefinition cube_r90 = leg_r3.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r91 = leg_r3.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

        PartDefinition cube_r92 = leg_r3.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r93 = leg_r3.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 187).mirror().addBox(-8.0F, -1.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.7F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition foot_r = leg_r_p.addOrReplaceChild("foot_r", CubeListBuilder.create().texOffs(488, 130).mirror().addBox(-6.0F, 0.0F, -8.0F, 12.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(464, 125).mirror().addBox(-4.0F, -2.0F, 10.0F, 8.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(291, 212).mirror().addBox(-8.0F, -2.0F, -22.0F, 16.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(464, 146).mirror().addBox(-5.0F, 1.0F, -10.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(464, 146).mirror().addBox(-5.0F, 1.0F, 8.0F, 10.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(452, 175).mirror().addBox(-7.75F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-25.75F, -6.9211F, -0.0197F));

        return LayerDefinition.create(meshdefinition, 1024, 1024);
    }

    @Override
    public void setupAnim(OrganEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        netHeadYaw = Mth.clamp(netHeadYaw, -60.0F, 60.0F) / 2;
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.chest.yRot = (netHeadYaw * ((float) Math.PI / 180F)) / 3;

        float ySwing = entity.getAssembly() >= 11 ? (float) Math.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 16) / 16 : 0;
        float ySwing2 = entity.getAssembly() >= 11 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 16) - 2) / 16 : 0;
        float bodyYOffset = entity.getAssembly() >= 11 ? (float) Math.sin(((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 22)) / 2 : 0;

        tail1.yRot = ySwing - (netHeadYaw * ((float) Math.PI / 180F)) / 3;
        tail2.yRot = ySwing2 - (netHeadYaw * ((float) Math.PI / 180F)) / 3;
        body.y = bodyYOffset - 80 + entity.z0;

        this.animateWalk(OrganAnimations.organ_walk_forward, limbSwing, limbSwingAmount, 1f, 2f);
        if (entity.getAssembly() > 10) {
            this.animate(entity.idleAnimationState, OrganAnimations.organ_idle, ageInTicks, 1f);
        } else {
            this.animate(entity.idleAnimationState, OrganAnimations.organ_assembly, ageInTicks, 1f);
        }

        this.animate(entity.sitDownAnimationState, OrganAnimations.organ_sit, ageInTicks, 1.0F);
        this.animate(entity.sitPoseAnimationState, OrganAnimations.organ_stay, ageInTicks, 1.0F);
        this.animate(entity.sitUpAnimationState, OrganAnimations.organ_stand, ageInTicks, 1.0F);

        this.animate(entity.lookAnimationState, OrganAnimations.sit_look, ageInTicks, 1.0f);
        this.animate(entity.shakeAnimationState, OrganAnimations.sit_shake, ageInTicks, 1.0f);
        this.animate(entity.yawnAnimationState, OrganAnimations.sit_yawn, ageInTicks, 1.0f);

        blink0.visible = entity.blinkCountdown == 0;
        blink1.visible = entity.blinkCountdown == 1 || entity.inbetween;
        blink2.visible = entity.blinkCountdown > 1 && !entity.inbetween;

        leg_l2.visible = entity.getAssembly() > 0;
        leg_r2.visible = entity.getAssembly() > 1;
        leg_l3.visible = entity.getAssembly() > 2;
        leg_r3.visible = entity.getAssembly() > 3;
        foot_l.visible = entity.getAssembly() > 4;
        foot_r.visible = entity.getAssembly() > 5;
        tail1.visible = entity.getAssembly() > 6;
        tail2.visible = entity.getAssembly() > 7;
        chest.visible = entity.getAssembly() > 8;
        neck.visible = entity.getAssembly() > 9;
        head.visible = entity.getAssembly() > 10;

        stand.visible = entity.isAddedToLevel() && entity.getAssembly() < 11;

        leg_l_p.y = !entity.leg_l1.isColliding() ? 16 : entity.leg_l1.isColliding() && !entity.leg_l2.isColliding() ? 0 : -16;
        leg_r_p.y = !entity.leg_r1.isColliding() ? 16 : entity.leg_r1.isColliding() && !entity.leg_r2.isColliding() ? 0 : -16;

        float animationTick = (AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 10;
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