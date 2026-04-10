
package net.dshbwlto.createbionics.entity.client.replete;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.custom.RepleteEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class RepleteModel<T extends RepleteEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart stand;

    private final ModelPart tank;
    private final ModelPart tank_single;
    private final ModelPart tank_single_b;
    private final ModelPart tank_3;
    private final ModelPart tank_3_b;
    private final ModelPart tank_4;
    private final ModelPart tank_4_b;
    private final ModelPart tank_5;
    private final ModelPart tank_5_b;
    private final ModelPart tank_bottom;
    private final ModelPart tank_bottom_b;
    private final ModelPart tank_cap;
    private final ModelPart tank_top;
    private final ModelPart tank_top_b;

    private final ModelPart leg_l;
    private final ModelPart leg_r;
    private final ModelPart leg2_l;
    private final ModelPart leg2_r;
    private final ModelPart leg3_l;
    private final ModelPart leg3_r;
    private final ModelPart pump;
    private final ModelPart gear;
    private final ModelPart dial_fuel;
    private final ModelPart dial_fluid;

    public RepleteModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("root_util").getChild("body");
        this.stand = this.root.getChild("root_util").getChild("body").getChild("stand");

        this.tank = this.root.getChild("root_util").getChild("tank");
        this.tank_single = this.root.getChild("root_util").getChild("tank").getChild("tank_single");
        this.tank_single_b = this.root.getChild("root_util").getChild("tank").getChild("tank_single").getChild("tank_single_b");
        this.tank_3 = this.root.getChild("root_util").getChild("tank").getChild("tank_3");
        this.tank_3_b = this.root.getChild("root_util").getChild("tank").getChild("tank_3").getChild("tank_3_b");
        this.tank_4 = this.root.getChild("root_util").getChild("tank").getChild("tank_4");
        this.tank_4_b = this.root.getChild("root_util").getChild("tank").getChild("tank_4").getChild("tank_4_b");
        this.tank_5 = this.root.getChild("root_util").getChild("tank").getChild("tank_5");
        this.tank_5_b = this.root.getChild("root_util").getChild("tank").getChild("tank_5").getChild("tank_5_b");
        this.tank_bottom = this.root.getChild("root_util").getChild("tank").getChild("tank_bottom");
        this.tank_bottom_b = this.root.getChild("root_util").getChild("tank").getChild("tank_bottom").getChild("tank_bottom_b");
        this.tank_cap = this.root.getChild("root_util").getChild("tank").getChild("tank_cap");
        this.tank_top = this.root.getChild("root_util").getChild("tank").getChild("tank_cap").getChild("tank_top");
        this.tank_top_b = this.root.getChild("root_util").getChild("tank").getChild("tank_cap").getChild("tank_top").getChild("tank_top_b");

        this.leg_l = this.root.getChild("root_util").getChild("body").getChild("leg_l");
        this.leg_r = this.root.getChild("root_util").getChild("body").getChild("leg_r");
        this.leg2_l = this.root.getChild("root_util").getChild("body").getChild("leg2_l");
        this.leg2_r = this.root.getChild("root_util").getChild("body").getChild("leg2_r");
        this.leg3_l = this.root.getChild("root_util").getChild("body").getChild("leg3_l");
        this.leg3_r = this.root.getChild("root_util").getChild("body").getChild("leg3_r");
        this.pump = this.root.getChild("root_util").getChild("body").getChild("pump_case").getChild("pump");
        this.gear = this.root.getChild("root_util").getChild("body").getChild("pump_case").getChild("pump").getChild("gear");
        this.dial_fuel = this.root.getChild("root_util").getChild("body").getChild("carapace").getChild("carapace_l").getChild("dial_fuel");
        this.dial_fluid = this.root.getChild("root_util").getChild("body").getChild("carapace").getChild("carapace_r").getChild("dial_fluid");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, -13.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = root_util.addOrReplaceChild("body", CubeListBuilder.create().texOffs(146, 92).addBox(-14.0F, -10.5F, 7.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(146, 92).addBox(-14.0F, -4.5F, 7.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(82, 102).addBox(-12.0F, -2.5F, 9.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(82, 102).addBox(-12.0F, 0.5F, -4.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(82, 102).addBox(-12.0F, 4.0F, -19.0F, 24.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(146, 92).addBox(-14.0F, -1.5F, -6.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(146, 92).addBox(-14.0F, -7.5F, -6.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(146, 92).addBox(-14.0F, 2.0F, -21.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(146, 92).addBox(-14.0F, -4.0F, -21.0F, 28.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(114, 44).addBox(0.0F, 6.5F, -4.5F, 2.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -19.0F, 13.75F, 0.3054F, -0.7854F, -0.2007F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(114, 44).addBox(-2.0F, 6.5F, -4.5F, 2.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -19.0F, 13.75F, 0.3054F, 0.7854F, 0.2007F));

        PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(75, 73).addBox(-2.0F, 10.0F, -56.0F, 4.0F, 9.0F, 63.0F, new CubeDeformation(0.0F))
                .texOffs(1, 106).mirror().addBox(9.5F, 9.5F, -42.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 102).mirror().addBox(3.5F, 9.5F, -55.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(1, 106).addBox(-10.5F, 9.5F, -42.5F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-10.5F, 9.5F, -55.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(83, 9).addBox(-10.5F, 14.5F, -55.5F, 21.0F, 2.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(0, 174).addBox(-10.0F, 4.0F, -55.0F, 20.0F, 13.0F, 60.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.0F, 13.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 48).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 49).addBox(-1.5F, -2.0F, 3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 49).addBox(-1.5F, -2.0F, 1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 48).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.177F, 18.7472F, 1.0036F, 0.0F, 0.0F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(115, 28).addBox(-9.0F, -3.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(115, 28).addBox(7.0F, -3.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.177F, 18.7472F, 1.1345F, 0.0F, 0.0F));

        PartDefinition carapace = body.addOrReplaceChild("carapace", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -20.0F, 13.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition carapace_l = carapace.addOrReplaceChild("carapace_l", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, 0.0F, -33.0F, 13.0F, 4.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(-10, 129).addBox(1.0F, 0.5F, -28.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(2, 138).addBox(2.0F, 0.0F, -19.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(2, 138).addBox(2.0F, 0.0F, -27.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(2, 130).addBox(2.0F, 0.0F, -27.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 130).addBox(10.0F, 0.0F, -27.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(146, 122).addBox(3.0F, 0.0F, 3.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -23.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition dial_fuel = carapace_l.addOrReplaceChild("dial_fuel", CubeListBuilder.create().texOffs(0, 149).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.25F, -25.0F));

        PartDefinition carapace_r = carapace.addOrReplaceChild("carapace_r", CubeListBuilder.create().texOffs(0, 69).addBox(-13.0F, 0.0F, -33.001F, 13.0F, 4.0F, 56.0F, new CubeDeformation(0.0F))
                .texOffs(146, 122).addBox(-10.0F, 0.0F, 3.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(2, 130).addBox(-2.0F, 0.0F, -27.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 130).addBox(-10.0F, 0.0F, -27.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 138).addBox(-10.0F, 0.0F, -27.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(2, 138).addBox(-10.0F, 0.0F, -19.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(-10, 139).addBox(-11.0F, 0.5F, -28.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(146, 122).mirror().addBox(-9.0F, 0.0F, 3.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -23.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition dial_fluid = carapace_r.addOrReplaceChild("dial_fluid", CubeListBuilder.create().texOffs(0, 149).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.25F, -25.0F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(0, 129).addBox(-6.0F, 31.0F, -29.0F, 12.0F, 2.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, 13.0F));

        PartDefinition cube_r6 = stand.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 69).addBox(-1.0F, 19.0F, -22.0F, 2.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

        PartDefinition leg_l = body.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(82, 28).addBox(-2.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 44).addBox(6.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -6.5F, 10.0F, 0.0F, -0.9599F, 0.0F));

        PartDefinition leg_l2 = leg_l.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(95, 86).addBox(-2.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(98, 4).addBox(4.0F, -2.0F, -2.0F, 27.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 0).mirror().addBox(4.0F, 2.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(52, 0).addBox(4.0F, -3.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(124, 146).addBox(31.0F, -3.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, 0.0F, 1.5F, 0.0F, 0.0F, -1.1781F));

        PartDefinition leg_l3 = leg_l2.addOrReplaceChild("leg_l3", CubeListBuilder.create().texOffs(0, 165).addBox(-2.0F, -2.0F, -2.5F, 63.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(26, 69).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.2689F));

        PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(82, 28).addBox(-6.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 44).addBox(-11.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -6.5F, 10.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition leg_r2 = leg_r.addOrReplaceChild("leg_r2", CubeListBuilder.create().texOffs(124, 146).mirror().addBox(-39.0F, -3.0F, -3.0F, 8.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(98, 4).addBox(-31.0F, -2.0F, -2.0F, 27.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(52, 0).mirror().addBox(-31.0F, -3.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(52, 0).addBox(-31.0F, 2.0F, -3.0F, 27.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(95, 86).addBox(-4.0F, -3.0F, -3.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, 0.0F, 1.5F, 0.0F, 0.0F, 1.1781F));

        PartDefinition leg_r3 = leg_r2.addOrReplaceChild("leg_r3", CubeListBuilder.create().texOffs(0, 165).mirror().addBox(-61.0F, -2.0F, -2.5F, 63.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 69).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-37.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.2689F));

        PartDefinition leg2_l = body.addOrReplaceChild("leg2_l", CubeListBuilder.create().texOffs(84, 28).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 44).addBox(4.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -3.5F, -3.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg2_l2 = leg2_l.addOrReplaceChild("leg2_l2", CubeListBuilder.create().texOffs(58, 145).addBox(-2.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 1.5F, 0.0F, 0.0F, -1.0036F));

        PartDefinition leg2_l3 = leg2_l2.addOrReplaceChild("leg2_l3", CubeListBuilder.create().texOffs(32, 165).addBox(-2.0F, -2.0F, -2.5F, 31.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(26, 69).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.2253F));

        PartDefinition leg2_r = body.addOrReplaceChild("leg2_r", CubeListBuilder.create().texOffs(84, 28).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 44).addBox(-9.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -3.5F, -3.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg2_r2 = leg2_r.addOrReplaceChild("leg2_r2", CubeListBuilder.create().texOffs(58, 145).mirror().addBox(-14.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 1.5F, 0.0F, 0.0F, 1.0036F));

        PartDefinition leg2_r3 = leg2_r2.addOrReplaceChild("leg2_r3", CubeListBuilder.create().texOffs(32, 165).mirror().addBox(-29.0F, -2.0F, -2.5F, 31.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 69).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.2253F));

        PartDefinition leg3_l = body.addOrReplaceChild("leg3_l", CubeListBuilder.create().texOffs(84, 28).addBox(-2.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 44).addBox(4.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, -18.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition leg3_l1 = leg3_l.addOrReplaceChild("leg3_l1", CubeListBuilder.create().texOffs(58, 154).addBox(-2.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 0.0F, 1.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition leg3_l3 = leg3_l1.addOrReplaceChild("leg3_l3", CubeListBuilder.create().texOffs(36, 165).addBox(-2.0F, -2.0F, -2.5F, 27.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(26, 69).addBox(-2.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, -1.5F, 0.0F, 0.0F, 1.8762F));

        PartDefinition leg3_r = body.addOrReplaceChild("leg3_r", CubeListBuilder.create().texOffs(84, 28).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 44).addBox(-9.0F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, -18.0F, 0.0F, -0.2618F, 0.0F));

        PartDefinition leg3_r2 = leg3_r.addOrReplaceChild("leg3_r2", CubeListBuilder.create().texOffs(58, 154).mirror().addBox(-14.0F, -3.0F, -3.0F, 16.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 1.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition leg3_r3 = leg3_r2.addOrReplaceChild("leg3_r3", CubeListBuilder.create().texOffs(36, 165).mirror().addBox(-25.0F, -2.0F, -2.5F, 27.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 69).mirror().addBox(-10.0F, -1.0F, -1.5F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.8762F));

        PartDefinition pump_case = body.addOrReplaceChild("pump_case", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.65F, -6.5F, 0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r7 = pump_case.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(146, 73).mirror().addBox(-4.0F, 0.0F, 0.0F, 18.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -10.5F, 13.95F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r8 = pump_case.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 75).addBox(-5.0F, -3.2164F, -6.2263F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, -3.25F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r9 = pump_case.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(32, 75).addBox(-5.0F, -3.2164F, -6.2263F, 10.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, 17.75F, -1.5708F, 0.0F, 0.0F));

        PartDefinition pump = pump_case.addOrReplaceChild("pump", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r10 = pump.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(82, 110).addBox(-6.0F, -16.2164F, -6.9763F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r11 = pump.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(82, 110).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition gear = pump.addOrReplaceChild("gear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r12 = gear.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(82, 73).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(82, 73).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.3562F));

        PartDefinition cube_r13 = gear.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(82, 73).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 3.1416F));

        PartDefinition cube_r14 = gear.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(82, 73).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.5708F));

        PartDefinition cube_r15 = gear.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(82, 73).addBox(-9.0F, -13.0F, -1.5F, 18.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 2.3562F));

        PartDefinition cube_r16 = gear.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(82, 36).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(82, 36).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.1781F));

        PartDefinition cube_r17 = gear.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(82, 36).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 1.9635F));

        PartDefinition cube_r18 = gear.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(82, 36).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -0.3927F));

        PartDefinition cube_r19 = gear.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(82, 36).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -2.7489F));

        PartDefinition cube_r20 = gear.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(82, 36).addBox(-7.0F, -12.9F, -2.5F, 14.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -1.1781F));

        PartDefinition tank = root_util.addOrReplaceChild("tank", CubeListBuilder.create().texOffs(106, 37).addBox(-16.0F, -4.0F, 0.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F))
                .texOffs(14, 53).addBox(-5.0F, -6.0F, 11.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 54).addBox(-3.0F, -9.0F, 13.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(82, 86).addBox(1.0F, 0.0F, 12.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(82, 86).addBox(-3.0F, 0.0F, 12.0F, 2.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(52, 4).addBox(-10.0F, 0.0F, 21.0F, 20.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(52, 4).addBox(-10.0F, 0.0F, 9.0F, 20.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, 11.0F));

        PartDefinition cube_r21 = tank.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(38, 105).mirror().addBox(0.0F, -2.0F, -4.0F, 2.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.0F, 16.0F, -0.6109F, 0.0F, 0.0F));

        PartDefinition tank_single = tank.addOrReplaceChild("tank_single", CubeListBuilder.create().texOffs(12, 28).addBox(15.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 40).addBox(15.0F, -8.0F, -4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(16.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 40).addBox(4.0F, -8.0F, -16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 40).addBox(4.0F, -8.0F, -15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 39).addBox(4.0F, -8.0F, -16.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(216, 124).mirror().addBox(-16.0F, -8.0F, -16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 40).mirror().addBox(-16.0F, -8.0F, -15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 39).mirror().addBox(-4.0F, -8.0F, -16.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 112).addBox(-16.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).mirror().addBox(-15.0F, -8.0F, -16.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 40).mirror().addBox(-16.0F, -8.0F, -4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 40).addBox(-16.0F, -8.0F, 16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 40).mirror().addBox(-16.0F, -8.0F, 15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 39).mirror().addBox(-4.0F, -8.0F, 15.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 28).mirror().addBox(-16.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 28).mirror().addBox(-15.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 40).mirror().addBox(-16.0F, -8.0F, 4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 124).addBox(4.0F, -8.0F, 16.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 40).addBox(4.0F, -8.0F, 15.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 112).addBox(16.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(15.0F, -8.0F, 4.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 40).addBox(15.0F, -8.0F, 4.0F, 1.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 39).addBox(4.0F, -8.0F, 15.0F, 0.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(-4.0F, -8.0F, -15.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(-4.0F, -8.0F, 15.5F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, -8).addBox(15.5F, -8.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, -8).addBox(-15.5F, -8.0F, -4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 16.0F));

        PartDefinition tank_single_b = tank_single.addOrReplaceChild("tank_single_b", CubeListBuilder.create().texOffs(15, 214).addBox(-4.0F, -8.0F, -8.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 206).addBox(16.0F, -8.0F, 4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(7, 214).addBox(-4.0F, -8.0F, 24.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(7, 206).addBox(-16.0F, -8.0F, 4.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

        PartDefinition tank_3 = tank.addOrReplaceChild("tank_3", CubeListBuilder.create().texOffs(12, 0).addBox(15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(15.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).mirror().addBox(-4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 84).addBox(-16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).mirror().addBox(-16.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 12).addBox(-16.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).mirror().addBox(-4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(-15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).mirror().addBox(-16.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 96).addBox(4.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(15.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 16).addBox(-4.0F, -16.0F, -15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 16).addBox(-4.0F, -16.0F, 15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(-15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 16.0F));

        PartDefinition tank_3_b = tank_3.addOrReplaceChild("tank_3_b", CubeListBuilder.create().texOffs(15, 186).addBox(0.0F, -16.0F, -4.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 178).addBox(20.0F, -16.0F, 8.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(7, 186).addBox(0.0F, -16.0F, 28.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(7, 178).addBox(-12.0F, -16.0F, 8.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -12.0F));

        PartDefinition tank_4 = tank.addOrReplaceChild("tank_4", CubeListBuilder.create().texOffs(12, 0).addBox(15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(15.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).mirror().addBox(-4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 84).addBox(-16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).mirror().addBox(-16.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 12).addBox(-16.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).mirror().addBox(-4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).mirror().addBox(-15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 12).mirror().addBox(-16.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 96).addBox(4.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(15.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 16).addBox(-4.0F, -16.0F, -15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 16).addBox(-4.0F, -16.0F, 15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(-15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -32.0F, 16.0F));

        PartDefinition tank_4_b = tank_4.addOrReplaceChild("tank_4_b", CubeListBuilder.create().texOffs(15, 186).addBox(0.0F, -16.0F, -4.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 178).addBox(20.0F, -16.0F, 8.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(7, 186).addBox(0.0F, -16.0F, 28.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(7, 178).addBox(-12.0F, -16.0F, 8.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -12.0F));

        PartDefinition tank_5 = tank.addOrReplaceChild("tank_5", CubeListBuilder.create().texOffs(12, 0).addBox(15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(15.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, -16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, -15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).mirror().addBox(-4.0F, -16.0F, -16.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 84).addBox(-16.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-15.0F, -16.0F, -16.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).mirror().addBox(-16.0F, -16.0F, -4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 12).addBox(-16.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 96).addBox(-16.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).mirror().addBox(-4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(-15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).mirror().addBox(-16.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 96).addBox(4.0F, -16.0F, 16.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 12).addBox(4.0F, -16.0F, 15.0F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(16.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(15.0F, -16.0F, 4.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 12).addBox(15.0F, -16.0F, 4.0F, 1.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(4.0F, -16.0F, 15.0F, 0.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 16).addBox(-4.0F, -16.0F, -15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 16).addBox(-4.0F, -16.0F, 15.5F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(-15.5F, -16.0F, -4.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -48.0F, 16.0F));

        PartDefinition tank_5_b = tank_5.addOrReplaceChild("tank_5_b", CubeListBuilder.create().texOffs(15, 186).addBox(0.0F, -16.0F, -4.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 178).addBox(20.0F, -16.0F, 8.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(7, 186).addBox(0.0F, -16.0F, 28.0F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(7, 178).addBox(-12.0F, -16.0F, 8.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -12.0F));

        PartDefinition tank_bottom = tank.addOrReplaceChild("tank_bottom", CubeListBuilder.create().texOffs(12, 16).addBox(15.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 28).addBox(15.0F, -12.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 16).addBox(16.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(4.0F, -12.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(4.0F, -12.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 27).addBox(4.0F, -12.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 112).addBox(-16.0F, -12.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 112).addBox(-16.0F, -12.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 27).mirror().addBox(-4.0F, -12.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 100).addBox(-16.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 16).addBox(-15.0F, -12.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 28).mirror().addBox(-16.0F, -12.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 28).addBox(-16.0F, -12.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 112).addBox(-16.0F, -12.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 27).mirror().addBox(-4.0F, -12.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 16).addBox(-16.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 100).addBox(-15.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 28).mirror().addBox(-16.0F, -12.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 112).addBox(4.0F, -12.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 28).addBox(4.0F, -12.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 100).mirror().addBox(16.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(228, 100).addBox(15.0F, -12.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 28).addBox(15.0F, -12.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, 27).addBox(4.0F, -12.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 28).addBox(-4.0F, -12.0F, -15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 28).addBox(-4.0F, -12.0F, 15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 20).addBox(15.5F, -12.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 20).addBox(-15.5F, -12.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 16.0F));

        PartDefinition tank_bottom_b = tank_bottom.addOrReplaceChild("tank_bottom_b", CubeListBuilder.create().texOffs(15, 202).addBox(0.0F, -12.0F, -4.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 194).addBox(20.0F, -12.0F, 8.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(7, 202).addBox(0.0F, -12.0F, 28.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(7, 194).addBox(-12.0F, -12.0F, 8.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -12.0F));

        PartDefinition tank_cap = tank.addOrReplaceChild("tank_cap", CubeListBuilder.create().texOffs(127, 0).addBox(-16.0F, 4.0F, -16.0F, 32.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -84.0F, 16.0F));

        PartDefinition tank_top = tank_cap.addOrReplaceChild("tank_top", CubeListBuilder.create().texOffs(12, -12).addBox(15.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 0).addBox(15.0F, -8.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, -12).addBox(16.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(4.0F, -8.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(4.0F, -8.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, -1).addBox(4.0F, -8.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(-16.0F, -8.0F, -16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(-16.0F, -8.0F, -15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, -1).mirror().addBox(-4.0F, -8.0F, -16.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 72).addBox(-16.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, -12).mirror().addBox(-15.0F, -8.0F, -16.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 0).mirror().addBox(-16.0F, -8.0F, -4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-16.0F, -8.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 84).addBox(-16.0F, -8.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, -1).mirror().addBox(-4.0F, -8.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, -12).addBox(-16.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(228, 72).addBox(-15.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 0).mirror().addBox(-16.0F, -8.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(216, 84).addBox(4.0F, -8.0F, 16.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(4.0F, -8.0F, 15.0F, 12.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(228, 72).addBox(16.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(12, -12).addBox(15.0F, -8.0F, 4.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(11, 0).addBox(15.0F, -8.0F, 4.0F, 1.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(11, -1).addBox(4.0F, -8.0F, 15.0F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(-4.0F, -8.0F, -15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(-4.0F, -8.0F, 15.5F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(15.5F, -8.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 0).addBox(-15.5F, -8.0F, -4.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition tank_top_b = tank_top.addOrReplaceChild("tank_top_b", CubeListBuilder.create().texOffs(15, 174).addBox(0.0F, -12.0F, -4.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(15, 166).addBox(20.0F, -12.0F, 8.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(7, 174).addBox(0.0F, -12.0F, 28.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(7, 166).addBox(-12.0F, -12.0F, 8.0F, 0.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 4.0F, -12.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(RepleteEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(RepleteAnimations.replete_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        if (entity.countdown != 0) {
            this.animate(entity.idleAnimationState, RepleteAnimations.get_stick_bugged_lol, ageInTicks, 1f);
        } else if (entity.getFuel() > 0) {
            this.animate(entity.idleAnimationState, RepleteAnimations.replete_assembly, ageInTicks, 1f);
        } else {
            this.animate(entity.idleAnimationState, RepleteAnimations.replete_assembly, ageInTicks, 1f);
        }

        this.animate(entity.sitDownAnimationState, RepleteAnimations.replete_sit,ageInTicks, 1.0f);

        this.animate(entity.sitPoseAnimationState, RepleteAnimations.replete_stay, ageInTicks, 1.0F);

        this.animate(entity.sitUpAnimationState, RepleteAnimations.replete_stand, ageInTicks, 1.0F);

        leg_l.visible = entity.getAssembly() > 0;
        leg_r.visible = entity.getAssembly() > 1;
        leg2_l.visible = entity.getAssembly() > 2;
        leg2_r.visible = entity.getAssembly() > 3;
        leg3_l.visible = entity.getAssembly() > 4;
        leg3_r.visible = entity.getAssembly() > 5;

        tank.visible = entity.getAssembly() > 7;
        tank_single.visible = entity.getAssembly() == 8;
        tank_bottom.visible = entity.getAssembly() >= 9;
        tank_top.visible = entity.getAssembly() >= 9;
        tank_3.visible = entity.getAssembly() >= 10;
        tank_4.visible = entity.getAssembly() >= 11;
        tank_5.visible = entity.getAssembly() >= 12;
        tank_cap.y = (-(entity.getAssembly() * 16) + 108);
        pump.visible = entity.getAssembly() > 6;
        stand.visible = entity.getAssembly() < 12;

        tank_single_b.visible = !entity.getWindow();
        tank_bottom_b.visible = !entity.getWindow();
        tank_top_b.visible = !entity.getWindow();
        tank_3_b.visible = !entity.getWindow();
        tank_4_b.visible = !entity.getWindow();
        tank_5_b.visible = !entity.getWindow();

        dial_fuel.yRot = (float) entity.getFuel() / 25000 * (Mth.PI / 2) - Mth.PI / 2;
        dial_fluid.yRot = entity.getSynchedFluid().getAmount() / 160000f * (Mth.PI / 2) - Mth.PI / 2;
        gear.zRot = entity.getFuel() > 0 && entity.getAssembly() == 12? (AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) / 100 : 0;
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
