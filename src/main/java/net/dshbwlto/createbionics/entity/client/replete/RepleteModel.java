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
import net.minecraft.server.level.BlockDestructionProgress;
import net.minecraft.util.Mth;

public class RepleteModel<T extends RepleteEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart body;

    private final ModelPart tank;
    private final ModelPart tank_single;
    private final ModelPart tank_3;
    private final ModelPart tank_4;
    private final ModelPart tank_5;
    private final ModelPart tank_bottom;
    private final ModelPart tank_cap;
    private final ModelPart tank_top;

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

        this.tank = this.root.getChild("root_util").getChild("tank");
        this.tank_single = this.root.getChild("root_util").getChild("tank").getChild("tank_single");
        this.tank_3 = this.root.getChild("root_util").getChild("tank").getChild("tank_3");
        this.tank_4 = this.root.getChild("root_util").getChild("tank").getChild("tank_4");
        this.tank_5 = this.root.getChild("root_util").getChild("tank").getChild("tank_5");
        this.tank_bottom = this.root.getChild("root_util").getChild("tank").getChild("tank_bottom");
        this.tank_cap = this.root.getChild("root_util").getChild("tank").getChild("tank_cap");
        this.tank_top = this.root.getChild("root_util").getChild("tank").getChild("tank_cap").getChild("tank_top");

        this.leg_l = this.root.getChild("root_util").getChild("body").getChild("leg_l");
        this.leg_r = this.root.getChild("root_util").getChild("body").getChild("leg_r");
        this.leg2_l = this.root.getChild("root_util").getChild("body").getChild("leg2_l");
        this.leg2_r = this.root.getChild("root_util").getChild("body").getChild("leg2_r");
        this.leg3_l = this.root.getChild("root_util").getChild("body").getChild("leg3_l");
        this.leg3_r = this.root.getChild("root_util").getChild("body").getChild("leg3_r");
        this.pump = this.root.getChild("root_util").getChild("body").getChild("pump_case").getChild("pump");
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
                .texOffs(68, 262).mirror().addBox(9.5F, 9.5F, -42.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(326, 146).mirror().addBox(3.5F, 9.5F, -55.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(68, 262).addBox(-10.5F, 9.5F, -42.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(326, 146).addBox(-10.5F, 9.5F, -55.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(160, 54).addBox(-10.5F, 14.5F, -55.5F, 21.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(282, 253).addBox(-10.0F, 4.0F, -55.0F, 20.0F, 13.0F, 60.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 13.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(96, 175).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(160, 214).addBox(-1.5F, -2.0F, 3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 214).addBox(-1.5F, -2.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(84, 175).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.177F, 18.7472F, 1.0036F, 0.0F, 0.0F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(316, 82).addBox(-9.0F, -3.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(316, 82).addBox(7.0F, -3.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.177F, 18.7472F, 1.1345F, 0.0F, 0.0F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(70, 314).addBox(-6.0F, 31.0F, -29.0F, 12.0F, 2.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 13.0F));

        PartDefinition cube_r6 = stand.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(199, 90).addBox(-1.0F, 19.0F, -22.0F, 2.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition carapace = body.addOrReplaceChild("carapace", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.0F, 13.0F, 0.3316F, 0.0F, 0.0F));

        PartDefinition cube_r7 = carapace.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 175).mirror().addBox(-13.0F, 0.0F, -29.0F, 13.0F, 4.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, -0.0949F, -0.0805F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r8 = carapace.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(294, 299).addBox(-9.0F, 0.0F, -21.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r9 = carapace.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(294, 299).addBox(3.0F, 0.0F, -21.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r10 = carapace.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 175).addBox(0.0F, 0.0F, -29.0F, 13.0F, 4.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -0.0949F, -0.0805F, 0.0F, 0.0F, 0.1745F));

        PartDefinition carapace2 = carapace.addOrReplaceChild("carapace2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -28.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r11 = carapace2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(301, 299).mirror().addBox(-11.0F, 1.0F, -19.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(312, 176).addBox(-11.0F, 0.0F, -19.0F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r12 = carapace2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(301, 300).addBox(5.0F, 1.0F, -19.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(312, 176).addBox(5.0F, 0.0F, -19.0F, 6.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r13 = carapace2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(168, 181).addBox(-13.0F, 0.0F, -28.0F, 13.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0003F, -0.1745F));

        PartDefinition cube_r14 = carapace2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 208).addBox(0.0F, 0.0F, -28.0F, 13.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0003F, 0.1745F));

        PartDefinition leg_l = body.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(104, 298).addBox(-2.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(319, 122).addBox(6.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -6.5F, 10.0F, 0.0F, -0.9599F, 0.0F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(264, 321).addBox(-2.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(270, 151).addBox(4.0F, -2.0F, -2.0F, 27.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(270, 105).addBox(4.0F, 2.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(270, 109).addBox(4.0F, -3.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(316, 63).addBox(31.0F, -3.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, 0.0F, 1.5F, 0.0F, 0.0F, -1.1781F));

        PartDefinition leg_l3 = leg_l2.addOrReplaceChild("leg_l3", CubeListBuilder.create().texOffs(160, 36).addBox(-2.0F, -2.0F, -2.5F, 63.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.2689F));

        PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(104, 298).addBox(-6.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(319, 122).addBox(-11.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.5F, 10.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(316, 63).mirror().addBox(-39.0F, -3.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(270, 156).addBox(-31.0F, -2.0F, -2.0F, 27.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(270, 105).addBox(-31.0F, -3.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(270, 105).addBox(-31.0F, 2.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(264, 321).addBox(-4.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 0.0F, 1.5F, 0.0F, 0.0F, 1.1781F));

        PartDefinition leg_r3 = leg_r2.addOrReplaceChild("leg_r3", CubeListBuilder.create().texOffs(160, 36).mirror().addBox(-61.0F, -2.0F, -2.5F, 63.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(162, 26).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-37.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.2689F));

        PartDefinition leg2_l = body.addOrReplaceChild("leg2_l", CubeListBuilder.create().texOffs(106, 298).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(319, 122).addBox(4.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -3.5F, -3.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg2_l2 = leg2_l.addOrReplaceChild("leg2_l2", CubeListBuilder.create().texOffs(304, 264).addBox(-2.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 1.5F, 0.0F, 0.0F, -1.0036F));

        PartDefinition leg2_l3 = leg2_l2.addOrReplaceChild("leg2_l3", CubeListBuilder.create().texOffs(192, 36).addBox(-2.0F, -2.0F, -2.5F, 31.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.2253F));

        PartDefinition leg2_r = body.addOrReplaceChild("leg2_r", CubeListBuilder.create().texOffs(106, 298).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(319, 122).addBox(-9.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -3.5F, -3.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg2_r2 = leg2_r.addOrReplaceChild("leg2_r2", CubeListBuilder.create().texOffs(304, 264).mirror().addBox(-14.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 1.5F, 0.0F, 0.0F, 1.0036F));

        PartDefinition leg2_r3 = leg2_r2.addOrReplaceChild("leg2_r3", CubeListBuilder.create().texOffs(192, 36).mirror().addBox(-29.0F, -2.0F, -2.5F, 31.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(162, 26).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.2253F));

        PartDefinition leg3_l = body.addOrReplaceChild("leg3_l", CubeListBuilder.create().texOffs(106, 298).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(319, 122).addBox(4.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -18.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg3_l1 = leg3_l.addOrReplaceChild("leg3_l1", CubeListBuilder.create().texOffs(304, 273).addBox(-2.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 1.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leg3_l3 = leg3_l1.addOrReplaceChild("leg3_l3", CubeListBuilder.create().texOffs(196, 36).addBox(-2.0F, -2.0F, -2.5F, 27.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(162, 26).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, -1.5F, 0.0F, 0.0F, 1.8762F));

        PartDefinition leg3_r = body.addOrReplaceChild("leg3_r", CubeListBuilder.create().texOffs(106, 298).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(319, 122).addBox(-9.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -18.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg3_r2 = leg3_r.addOrReplaceChild("leg3_r2", CubeListBuilder.create().texOffs(304, 273).mirror().addBox(-14.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 1.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leg3_r3 = leg3_r2.addOrReplaceChild("leg3_r3", CubeListBuilder.create().texOffs(196, 36).mirror().addBox(-25.0F, -2.0F, -2.5F, 27.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(162, 26).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.8762F));

        PartDefinition pump_case = body.addOrReplaceChild("pump_case", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, -7.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r15 = pump_case.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(263, 250).mirror().addBox(-9.0F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.5F, 13.75F, -1.5708F, 0.0F, -1.0036F));

        PartDefinition cube_r16 = pump_case.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(304, 224).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(262, 224).addBox(0.0F, 0.0F, 0.0F, 10.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -10.5F, 13.75F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r17 = pump_case.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(263, 250).addBox(0.0F, 0.0F, 0.0F, 9.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -10.5F, 13.75F, -1.5708F, 0.0F, 1.0036F));

        PartDefinition cube_r18 = pump_case.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(304, 291).addBox(-5.0F, -3.0F, -5.25F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 17.75F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r19 = pump_case.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(304, 291).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition pump = pump_case.addOrReplaceChild("pump", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r20 = pump.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(270, 136).addBox(-6.0F, -16.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(270, 121).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition gear = pump.addOrReplaceChild("gear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r21 = gear.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(288, 0).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(262, 273).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.3562F));

        PartDefinition cube_r22 = gear.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(262, 286).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 3.1416F));

        PartDefinition cube_r23 = gear.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(262, 273).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

        PartDefinition cube_r24 = gear.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(270, 176).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 2.3562F));

        PartDefinition cube_r25 = gear.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(134, 297).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(220, 293).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.1781F));

        PartDefinition cube_r26 = gear.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(296, 28).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.9635F));

        PartDefinition cube_r27 = gear.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(220, 293).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -0.3927F));

        PartDefinition cube_r28 = gear.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(288, 13).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.7489F));

        PartDefinition cube_r29 = gear.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(288, 13).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.1781F));

        PartDefinition tank = root_util.addOrReplaceChild("tank", CubeListBuilder.create().texOffs(120, 145).addBox(-16.0F, -4.0F, 0.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F))
                .texOffs(143, 124).addBox(-5.0F, -6.0F, 11.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(159, 103).addBox(-3.0F, -9.0F, 13.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(68, 313).addBox(1.0F, 0.0F, 12.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(68, 313).addBox(-3.0F, 0.0F, 12.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(296, 43).addBox(-10.0F, 0.0F, 21.0F, 20.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(296, 43).addBox(-10.0F, 0.0F, 9.0F, 20.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 13.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r30 = tank.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(246, 313).mirror().addBox(0.0F, -2.0F, -4.0F, 2.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 16.0F, -0.6109F, 0.0F, 0.0F));

        PartDefinition tank_single = tank.addOrReplaceChild("tank_single", CubeListBuilder.create().texOffs(36, 46).addBox(15.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 58).addBox(15.0F, -8.0F, -4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 46).addBox(16.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 58).addBox(4.0F, -8.0F, -16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 58).addBox(4.0F, -8.0F, -15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 57).addBox(4.0F, -8.0F, -16.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 58).mirror().addBox(-16.0F, -8.0F, -16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 58).mirror().addBox(-16.0F, -8.0F, -15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 57).mirror().addBox(-4.0F, -8.0F, -16.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 46).mirror().addBox(-16.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 46).mirror().addBox(-15.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 58).mirror().addBox(-16.0F, -8.0F, -4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 58).mirror().addBox(-16.0F, -8.0F, 16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 58).mirror().addBox(-16.0F, -8.0F, 15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 57).mirror().addBox(-4.0F, -8.0F, 15.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 46).mirror().addBox(-16.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 46).mirror().addBox(-15.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 58).mirror().addBox(-16.0F, -8.0F, 4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 58).addBox(4.0F, -8.0F, 16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 58).addBox(4.0F, -8.0F, 15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, 46).addBox(16.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 46).addBox(15.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 58).addBox(15.0F, -8.0F, 4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 57).addBox(4.0F, -8.0F, 15.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 0).addBox(-4.0F, -8.0F, -15.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 0).addBox(-4.0F, -8.0F, 15.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, -8).addBox(15.5F, -8.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(82, -8).addBox(-15.5F, -8.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 16.0F));

        PartDefinition tank_3 = tank.addOrReplaceChild("tank_3", CubeListBuilder.create().texOffs(36, 6).addBox(15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 18).addBox(15.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 6).addBox(16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 17).addBox(4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 17).mirror().addBox(-4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 18).mirror().addBox(-16.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 17).mirror().addBox(-4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 18).mirror().addBox(-16.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).addBox(4.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, 6).addBox(16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 6).addBox(15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 18).addBox(15.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 17).addBox(4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 16).addBox(-4.0F, -16.0F, -15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 16).addBox(-4.0F, -16.0F, 15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(-15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 16.0F));

        PartDefinition tank_4 = tank.addOrReplaceChild("tank_4", CubeListBuilder.create().texOffs(36, 6).addBox(15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 18).addBox(15.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 6).addBox(16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 17).addBox(4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 17).mirror().addBox(-4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 18).mirror().addBox(-16.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 17).mirror().addBox(-4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 18).mirror().addBox(-16.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).addBox(4.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, 6).addBox(16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 6).addBox(15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 18).addBox(15.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 17).addBox(4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 16).addBox(-4.0F, -16.0F, -15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 16).addBox(-4.0F, -16.0F, 15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(-15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -32.0F, 16.0F));

        PartDefinition tank_5 = tank.addOrReplaceChild("tank_5", CubeListBuilder.create().texOffs(36, 6).addBox(15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 18).addBox(15.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 6).addBox(16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 17).addBox(4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 17).mirror().addBox(-4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 18).mirror().addBox(-16.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).mirror().addBox(-16.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 17).mirror().addBox(-4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 6).mirror().addBox(-15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 18).mirror().addBox(-16.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 18).addBox(4.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 18).addBox(4.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, 6).addBox(16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 6).addBox(15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 18).addBox(15.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 17).addBox(4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 16).addBox(-4.0F, -16.0F, -15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 16).addBox(-4.0F, -16.0F, 15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(-15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -48.0F, 16.0F));

        PartDefinition tank_bottom = tank.addOrReplaceChild("tank_bottom", CubeListBuilder.create().texOffs(36, 24).addBox(15.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 36).addBox(15.0F, -12.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 24).addBox(16.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(4.0F, -12.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(4.0F, -12.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 35).addBox(4.0F, -12.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).mirror().addBox(-16.0F, -12.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 36).mirror().addBox(-16.0F, -12.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 35).mirror().addBox(-4.0F, -12.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 24).mirror().addBox(-16.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 24).mirror().addBox(-15.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 36).mirror().addBox(-16.0F, -12.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 36).mirror().addBox(-16.0F, -12.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 36).mirror().addBox(-16.0F, -12.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 35).mirror().addBox(-4.0F, -12.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 24).mirror().addBox(-16.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 24).mirror().addBox(-15.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 36).mirror().addBox(-16.0F, -12.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 36).addBox(4.0F, -12.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 36).addBox(4.0F, -12.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, 24).addBox(16.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 24).addBox(15.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 36).addBox(15.0F, -12.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 35).addBox(4.0F, -12.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 28).addBox(-4.0F, -12.0F, -15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 28).addBox(-4.0F, -12.0F, 15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 20).addBox(15.5F, -12.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(82, 20).addBox(-15.5F, -12.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 16.0F));

        PartDefinition tank_cap = tank.addOrReplaceChild("tank_cap", CubeListBuilder.create().texOffs(160, 0).addBox(-16.0F, 4.0F, -16.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, 16.0F));

        PartDefinition tank_top = tank_cap.addOrReplaceChild("tank_top", CubeListBuilder.create().texOffs(36, -8).addBox(15.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 4).addBox(15.0F, -8.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, -8).addBox(16.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 4).addBox(4.0F, -8.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 4).addBox(4.0F, -8.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 3).addBox(4.0F, -8.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 4).mirror().addBox(-16.0F, -8.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 4).mirror().addBox(-16.0F, -8.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 3).mirror().addBox(-4.0F, -8.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, -8).mirror().addBox(-16.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, -8).mirror().addBox(-15.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 4).mirror().addBox(-16.0F, -8.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 4).mirror().addBox(-16.0F, -8.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 4).mirror().addBox(-16.0F, -8.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 3).mirror().addBox(-4.0F, -8.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, -8).mirror().addBox(-16.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, -8).mirror().addBox(-15.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(47, 4).mirror().addBox(-16.0F, -8.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(36, 4).addBox(4.0F, -8.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 4).addBox(4.0F, -8.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(24, -8).addBox(16.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, -8).addBox(15.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(47, 4).addBox(15.0F, -8.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(47, 3).addBox(4.0F, -8.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(-4.0F, -8.0F, -15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 8).addBox(-4.0F, -8.0F, 15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 0).addBox(15.5F, -8.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(82, 0).addBox(-15.5F, -8.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void setupAnim(RepleteEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(RepleteAnimations.replete_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        if (entity.fuel() > 0) {
            this.animate(entity.idleAnimationState, RepleteAnimations.replete_idle, ageInTicks, 1f);
        } else {
            this.animate(entity.idleAnimationState, RepleteAnimations.replete_assembly, ageInTicks, 1f);
        }
        this.animate(entity.sitDownAnimationState, RepleteAnimations.replete_sit, ageInTicks, 1.0F);
        this.animate(entity.sitPoseAnimationState, RepleteAnimations.replete_stay, ageInTicks, 1.0F);
        this.animate(entity.sitUpAnimationState, RepleteAnimations.replete_stand, ageInTicks, 1.0F);

        leg_l.visible = entity.buildProgress() > 0;
        leg_r.visible = entity.buildProgress() > 1;
        leg2_l.visible = entity.buildProgress() > 2;
        leg2_r.visible = entity.buildProgress() > 3;
        leg3_l.visible = entity.buildProgress() > 4;
        leg3_r.visible = entity.buildProgress() > 5;

        tank.visible = entity.buildProgress() > 6;
        tank_single.visible = entity.buildProgress() == 7;
        tank_bottom.visible = entity.buildProgress() >= 8;
        tank_top.visible = entity.buildProgress() >= 8;
        tank_3.visible = entity.buildProgress() >= 9;
        tank_4.visible = entity.buildProgress() >= 10;
        tank_5.visible = entity.buildProgress() >= 11;
        tank_cap.y = (-(entity.buildProgress() * 16) + 92);
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
