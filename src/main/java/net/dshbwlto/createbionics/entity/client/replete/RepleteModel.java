package net.dshbwlto.createbionics.entity.client.replete;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.client.anole.AnoleAnimations;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RepleteModel<T extends RepleteEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart tank;
    private final ModelPart fluid24;
    private final ModelPart fluid23;
    private final ModelPart fluid22;
    private final ModelPart fluid21;
    private final ModelPart fluid20;
    private final ModelPart fluid19;
    private final ModelPart fluid18;
    private final ModelPart fluid17;
    private final ModelPart fluid16;
    private final ModelPart fluid15;
    private final ModelPart fluid14;
    private final ModelPart fluid13;
    private final ModelPart fluid12;
    private final ModelPart fluid11;
    private final ModelPart fluid10;
    private final ModelPart fluid9;
    private final ModelPart fluid8;
    private final ModelPart fluid7;
    private final ModelPart fluid6;
    private final ModelPart fluid5;
    private final ModelPart fluid4;
    private final ModelPart fluid3;
    private final ModelPart fluid2;
    private final ModelPart fluid1;
    private final ModelPart leg_l;
    private final ModelPart leg_r;
    private final ModelPart leg2_l;
    private final ModelPart leg2_r;
    private final ModelPart leg3_l;
    private final ModelPart leg3_r;
    private final ModelPart pump;

    public RepleteModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("root_util").getChild("body");
        this.tank = this.root.getChild("root_util").getChild("body").getChild("tank");
        this.fluid24 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid24");
        this.fluid23 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid23");
        this.fluid22 =  this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid22");
        this.fluid21 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid21");
        this.fluid20 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid20");
        this.fluid19 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid19");
        this.fluid18 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid18");
        this.fluid17 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid17");
        this.fluid16 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid16");
        this.fluid15 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid15");
        this.fluid14 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid14");
        this.fluid13 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid13");
        this.fluid12 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid12");
        this.fluid11 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid11");
        this.fluid10 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid10");
        this.fluid9 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid9");
        this.fluid8 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid8");
        this.fluid7 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid7");
        this.fluid6 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid6");
        this.fluid5 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid5");
        this.fluid4 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid4");
        this.fluid3 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid3");
        this.fluid2 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid2");
        this.fluid1 = this.root.getChild("root_util").getChild("body").getChild("tank").getChild("fluids").getChild("fluid1");
        this.leg_l = this.root.getChild("root_util").getChild("body").getChild("leg_l");
        this.leg_r = this.root.getChild("root_util").getChild("body").getChild("leg_r");
        this.leg2_l = this.root.getChild("root_util").getChild("body").getChild("leg2_l");
        this.leg2_r = this.root.getChild("root_util").getChild("body").getChild("leg2_r");
        this.leg3_l = this.root.getChild("root_util").getChild("body").getChild("leg3_l");
        this.leg3_r = this.root.getChild("root_util").getChild("body").getChild("leg3_r");
        this.pump = this.root.getChild("root_util").getChild("body").getChild("pump");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, -13.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create().texOffs(262, 216).addBox(-14.0F, -10.5F, 7.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(262, 216).addBox(-14.0F, -4.5F, 7.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(270, 171).addBox(-12.0F, -2.5F, 9.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(270, 171).addBox(-12.0F, 0.5F, -4.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(270, 171).addBox(-12.0F, 4.0F, -19.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(262, 216).addBox(-14.0F, -1.5F, -6.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(262, 216).addBox(-14.0F, -7.5F, -6.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(262, 216).addBox(-14.0F, 2.0F, -21.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(262, 216).addBox(-14.0F, -4.0F, -21.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(176, 312).addBox(0.0F, 6.5F, -4.5F, 2.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -19.0F, 13.75F, 0.3054F, -0.7854F, -0.2007F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(176, 312).addBox(-2.0F, 6.5F, -4.5F, 2.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -19.0F, 13.75F, 0.3054F, 0.7854F, 0.2007F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(120, 73).addBox(-2.0F, 10.0F, -56.0F, 4.0F, 9.0F, 63.0F, new CubeDeformation(0.0F))
                .texOffs(68, 269).addBox(10.0F, 9.0F, -44.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(270, 84).addBox(3.5F, 8.5F, -55.5F, 7.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(68, 298).addBox(4.0F, 9.0F, -56.0F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(310, 313).addBox(9.5F, 9.5F, -30.5F, 1.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(68, 251).addBox(9.5F, 9.5F, -15.5F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(68, 240).addBox(-10.5F, 9.5F, -15.5F, 1.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(236, 54).addBox(-10.5F, 9.5F, -30.5F, 1.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(270, 63).addBox(-10.5F, 8.5F, -55.5F, 7.0F, 5.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(68, 262).addBox(-11.0F, 9.0F, -44.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(172, 297).addBox(-11.0F, 9.0F, -56.0F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(160, 54).addBox(-10.5F, 14.5F, -55.5F, 21.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-10.0F, 4.0F, -55.0F, 20.0F, 13.0F, 60.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 13.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(96, 175).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(160, 214).addBox(-1.5F, -2.0F, 3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 214).addBox(-1.5F, -2.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 175).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.177F, 18.7472F, 1.0036F, 0.0F, 0.0F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(316, 82).addBox(-9.0F, -3.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(316, 72).addBox(7.0F, -3.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.177F, 18.7472F, 1.1345F, 0.0F, 0.0F));

        PartDefinition tank = body.addOrReplaceChild("tank", CubeListBuilder.create().texOffs(120, 145).addBox(-16.0F, -4.0F, 0.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F))
                .texOffs(143, 124).addBox(-5.0F, -6.0F, 11.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(159, 103).addBox(-3.0F, -9.0F, 13.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(68, 313).addBox(1.0F, 0.0F, 12.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(68, 313).addBox(-3.0F, 0.0F, 12.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(296, 43).addBox(-10.0F, 0.0F, 21.0F, 20.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(296, 43).addBox(-10.0F, 0.0F, 9.0F, 20.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(134, 214).addBox(4.0F, -76.0F, 0.0F, 12.0F, 72.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(220, 213).addBox(-16.0F, -76.0F, 0.0F, 12.0F, 72.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(168, 213).addBox(-16.0F, -76.0F, 0.0F, 1.0F, 72.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(194, 213).addBox(-16.0F, -76.0F, 20.0F, 1.0F, 72.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(108, 214).addBox(15.0F, -76.0F, 20.0F, 1.0F, 72.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(82, 214).addBox(15.0F, -76.0F, 0.0F, 1.0F, 72.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(254, 54).addBox(-4.0F, -76.0F, 0.5F, 8.0F, 72.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(26, 240).addBox(-16.0F, -76.0F, 31.0F, 12.0F, 72.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(254, 126).addBox(-4.0F, -76.0F, 31.5F, 8.0F, 72.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(52, 240).addBox(15.5F, -76.0F, 12.0F, 0.0F, 72.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(246, 213).addBox(-15.5F, -76.0F, 12.0F, 0.0F, 72.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(4.0F, -76.0F, 31.0F, 12.0F, 72.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 0).addBox(-16.0F, -80.0F, 0.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 13.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r6 = tank.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(246, 313).mirror().addBox(0.0F, -2.0F, -4.0F, 2.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 16.0F, -0.6109F, 0.0F, 0.0F));

        PartDefinition fluids = tank.addOrReplaceChild("fluids", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 16.0F));

        PartDefinition fluid24 = fluids.addOrReplaceChild("fluid24", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -72.0F, -15.0F, 30.0F, 72.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid23 = fluids.addOrReplaceChild("fluid23", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -69.0F, -15.0F, 30.0F, 69.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid22 = fluids.addOrReplaceChild("fluid22", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -66.0F, -15.0F, 30.0F, 66.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid21 = fluids.addOrReplaceChild("fluid21", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -63.0F, -15.0F, 30.0F, 63.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid20 = fluids.addOrReplaceChild("fluid20", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -60.0F, -15.0F, 30.0F, 60.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid19 = fluids.addOrReplaceChild("fluid19", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -57.0F, -15.0F, 30.0F, 57.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid18 = fluids.addOrReplaceChild("fluid18", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -54.0F, -15.0F, 30.0F, 54.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid17 = fluids.addOrReplaceChild("fluid17", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -51.0F, -15.0F, 30.0F, 51.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid16 = fluids.addOrReplaceChild("fluid16", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -48.0F, -15.0F, 30.0F, 48.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid15 = fluids.addOrReplaceChild("fluid15", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -45.0F, -15.0F, 30.0F, 45.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid14 = fluids.addOrReplaceChild("fluid14", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -42.0F, -15.0F, 30.0F, 42.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid13 = fluids.addOrReplaceChild("fluid13", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -39.0F, -15.0F, 30.0F, 39.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid12 = fluids.addOrReplaceChild("fluid12", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -36.0F, -15.0F, 30.0F, 36.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid11 = fluids.addOrReplaceChild("fluid11", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -33.0F, -15.0F, 30.0F, 33.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid10 = fluids.addOrReplaceChild("fluid10", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -30.0F, -15.0F, 30.0F, 30.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid9 = fluids.addOrReplaceChild("fluid9", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -27.0F, -15.0F, 30.0F, 27.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid8 = fluids.addOrReplaceChild("fluid8", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -24.0F, -15.0F, 30.0F, 24.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid7 = fluids.addOrReplaceChild("fluid7", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -21.0F, -15.0F, 30.0F, 21.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid6 = fluids.addOrReplaceChild("fluid6", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -18.0F, -15.0F, 30.0F, 18.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid5 = fluids.addOrReplaceChild("fluid5", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -15.0F, -15.0F, 30.0F, 15.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid4 = fluids.addOrReplaceChild("fluid4", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -12.0F, -15.0F, 30.0F, 12.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid3 = fluids.addOrReplaceChild("fluid3", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -9.0F, -15.0F, 30.0F, 9.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid2 = fluids.addOrReplaceChild("fluid2", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -6.0F, -15.0F, 30.0F, 6.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition fluid1 = fluids.addOrReplaceChild("fluid1", CubeListBuilder.create().texOffs(0, 73).addBox(-15.0F, -3.0F, -15.0F, 30.0F, 3.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(340, 111).addBox(-6.0F, 31.0F, -29.0F, 12.0F, 2.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 13.0F));

        PartDefinition cube_r7 = stand.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(199, 90).addBox(-1.0F, 19.0F, -22.0F, 2.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition carapace = body.addOrReplaceChild("carapace", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.0F, 13.0F, 0.3316F, 0.0F, 0.0F));

        PartDefinition cube_r8 = carapace.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(84, 181).addBox(-13.0F, 0.0F, -29.0F, 13.0F, 4.0F, 29.0F, new CubeDeformation(0.0F))
                .texOffs(294, 299).addBox(-9.0F, 0.0F, -21.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(264, 299).mirror().addBox(-9.0F, 1.75F, -21.0F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r9 = carapace.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(264, 299).addBox(3.0F, 1.75F, -21.0F, 6.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(258, 299).addBox(3.0F, 0.0F, -21.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 175).addBox(0.0F, 0.0F, -29.0F, 13.0F, 4.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition carapace2 = carapace.addOrReplaceChild("carapace2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -28.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r10 = carapace2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(301, 299).mirror().addBox(-11.0F, 1.0F, -19.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(142, 312).addBox(-11.0F, 0.0F, -19.0F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r11 = carapace2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(265, 300).addBox(5.0F, 1.0F, -19.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(312, 176).addBox(5.0F, 0.0F, -19.0F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r12 = carapace2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(168, 181).addBox(-13.0F, 0.0F, -28.0F, 13.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0003F, -0.1745F));

        PartDefinition cube_r13 = carapace2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 208).addBox(0.0F, 0.0F, -28.0F, 13.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0003F, 0.1745F));

        PartDefinition leg_l = body.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(104, 298).addBox(-2.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(318, 121).addBox(6.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -6.5F, 10.0F, 0.0F, -0.9599F, 0.0F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(264, 321).addBox(-2.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(270, 151).addBox(4.0F, -2.0F, -2.0F, 27.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(270, 105).addBox(4.0F, 2.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(270, 109).addBox(4.0F, -3.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(316, 63).addBox(31.0F, -3.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, 0.0F, 1.5F, 0.0F, 0.0F, -1.1781F));

        PartDefinition leg_l3 = leg_l2.addOrReplaceChild("leg_l3", CubeListBuilder.create().texOffs(160, 36).addBox(-2.0F, -2.0F, -2.5F, 63.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.2689F));

        PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(104, 298).addBox(-6.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(318, 121).addBox(-11.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.5F, 10.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(316, 63).mirror().addBox(-39.0F, -3.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(270, 156).addBox(-31.0F, -2.0F, -2.0F, 27.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(270, 105).addBox(-31.0F, -3.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(270, 105).addBox(-31.0F, 2.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(264, 321).addBox(-4.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 0.0F, 1.5F, 0.0F, 0.0F, 1.1781F));

        PartDefinition leg_r3 = leg_r2.addOrReplaceChild("leg_r3", CubeListBuilder.create().texOffs(160, 45).addBox(-61.0F, -2.0F, -2.5F, 63.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-37.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.2689F));

        PartDefinition leg2_l = body.addOrReplaceChild("leg2_l", CubeListBuilder.create().texOffs(106, 298).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(318, 121).addBox(4.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -3.5F, -3.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg2_l2 = leg2_l.addOrReplaceChild("leg2_l2", CubeListBuilder.create().texOffs(304, 273).addBox(-2.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 1.5F, 0.0F, 0.0F, -1.0036F));

        PartDefinition leg2_l3 = leg2_l2.addOrReplaceChild("leg2_l3", CubeListBuilder.create().texOffs(192, 36).addBox(-2.0F, -2.0F, -2.5F, 31.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.2253F));

        PartDefinition leg2_r = body.addOrReplaceChild("leg2_r", CubeListBuilder.create().texOffs(106, 298).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(318, 121).addBox(-9.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -3.5F, -3.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg2_r2 = leg2_r.addOrReplaceChild("leg2_r2", CubeListBuilder.create().texOffs(304, 273).mirror().addBox(-14.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 1.5F, 0.0F, 0.0F, 1.0036F));

        PartDefinition leg2_r3 = leg2_r2.addOrReplaceChild("leg2_r3", CubeListBuilder.create().texOffs(192, 36).mirror().addBox(-29.0F, -2.0F, -2.5F, 31.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(162, 26).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.2253F));

        PartDefinition leg3_l = body.addOrReplaceChild("leg3_l", CubeListBuilder.create().texOffs(106, 298).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(318, 121).addBox(4.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -18.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg3_l1 = leg3_l.addOrReplaceChild("leg3_l1", CubeListBuilder.create().texOffs(304, 273).addBox(-2.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 1.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leg3_l3 = leg3_l1.addOrReplaceChild("leg3_l3", CubeListBuilder.create().texOffs(196, 36).addBox(-2.0F, -2.0F, -2.5F, 27.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -1.5F, 0.0F, 0.0F, 1.8762F));

        PartDefinition leg3_r = body.addOrReplaceChild("leg3_r", CubeListBuilder.create().texOffs(106, 298).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(318, 121).addBox(-9.0F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -18.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg3_r2 = leg3_r.addOrReplaceChild("leg3_r2", CubeListBuilder.create().texOffs(304, 273).mirror().addBox(-14.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 1.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leg3_r3 = leg3_r2.addOrReplaceChild("leg3_r3", CubeListBuilder.create().texOffs(196, 36).mirror().addBox(-25.0F, -2.0F, -2.5F, 27.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(162, 26).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.8762F));

        PartDefinition pump = body.addOrReplaceChild("pump", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, -7.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r14 = pump.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(270, 136).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(270, 121).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r15 = pump.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(333, 249).mirror().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.5F, 13.75F, -1.5708F, 0.0F, -1.0036F));

        PartDefinition cube_r16 = pump.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(304, 224).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(259, 225).addBox(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -10.5F, 13.75F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r17 = pump.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(339, 212).addBox(0.0F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -10.5F, 13.75F, -1.5708F, 0.0F, 1.0036F));

        PartDefinition cube_r18 = pump.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(264, 313).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 17.75F, -1.789F, 0.0F, 0.0F));

        PartDefinition cube_r19 = pump.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(304, 291).addBox(-5.0F, 0.0F, -0.25F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, -1.4835F, 0.0F, 0.0F));

        PartDefinition gear = pump.addOrReplaceChild("gear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r20 = gear.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(288, 0).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(262, 273).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.3562F));

        PartDefinition cube_r21 = gear.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(262, 286).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 3.1416F));

        PartDefinition cube_r22 = gear.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(262, 273).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

        PartDefinition cube_r23 = gear.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(270, 176).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 2.3562F));

        PartDefinition cube_r24 = gear.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(134, 297).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(220, 293).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.1781F));

        PartDefinition cube_r25 = gear.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(296, 28).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.9635F));

        PartDefinition cube_r26 = gear.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(220, 293).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -0.3927F));

        PartDefinition cube_r27 = gear.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(288, 13).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.7489F));

        PartDefinition cube_r28 = gear.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(288, 13).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.1781F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void setupAnim(RepleteEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(RepleteAnimations.replete_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, RepleteAnimations.replete_idle, ageInTicks, 1f);
        if(entity.isCurrentlyGlowing()) {
            this.animate(entity.sitDownAnimationState, RepleteAnimations.replete_sit, ageInTicks, 1.0F);
            this.animate(entity.sitPoseAnimationState, RepleteAnimations.replete_stay, ageInTicks, 1.0F);
            this.animate(entity.sitUpAnimationState, RepleteAnimations.replete_stand, ageInTicks, 1.0F);
        }

        fluid1.visible = entity.fluid_1();
        fluid2.visible = entity.fluid_2();
        fluid3.visible = entity.fluid_3();
        fluid4.visible = entity.fluid_4();
        fluid5.visible = entity.fluid_5();
        fluid6.visible = entity.fluid_6();
        fluid7.visible = entity.fluid_7();
        fluid8.visible = entity.fluid_8();
        fluid9.visible = entity.fluid_9();
        fluid10.visible = entity.fluid_10();
        fluid11.visible = entity.fluid_11();
        fluid12.visible = entity.fluid_12();
        fluid13.visible = entity.fluid_13();
        fluid14.visible = entity.fluid_14();
        fluid15.visible = entity.fluid_15();
        fluid16.visible = entity.fluid_16();
        fluid17.visible = entity.fluid_17();
        fluid18.visible = entity.fluid_18();
        fluid19.visible = entity.fluid_19();
        fluid20.visible = entity.fluid_20();
        fluid21.visible = entity.fluid_21();
        fluid22.visible = entity.fluid_22();
        fluid23.visible = entity.fluid_23();
        fluid24.visible = entity.fluid_24();
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
