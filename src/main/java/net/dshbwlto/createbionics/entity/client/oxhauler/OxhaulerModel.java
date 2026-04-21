
package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueHandler;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class OxhaulerModel <T extends OxhaulerEntity> extends  HierarchicalModel<T>
{
    private final ModelPart root;
    private final ModelPart back_master;
    private final ModelPart front_master;
    private final ModelPart neck_master;
    private final ModelPart neck;
    private final ModelPart pistons;
    private final ModelPart head;
    private final ModelPart leg_l;
    private final ModelPart leg_r;
    private final ModelPart arm_l;
    private final ModelPart arm_r;
    private final ModelPart combine;
    private final ModelPart roller;
    private final ModelPart plough;
    private final ModelPart bolts_front;
    private final ModelPart bolts_rear;
    private final ModelPart dial;
    private final ModelPart stand;
    private final ModelPart piston1;
    private final ModelPart piston2;
    private final ModelPart piston3;
    private final ModelPart piston4;
    private final ModelPart piston5;
    private final ModelPart piston6;

    public OxhaulerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.back_master = this.root.getChild("body").getChild("back_master");
        this.leg_l = this.root.getChild("body").getChild("back_master").getChild("leg_l");
        this.leg_r = this.root.getChild("body").getChild("back_master").getChild("leg_r");
        this.arm_l = this.root.getChild("body").getChild("front_master").getChild("arm_l");
        this.arm_r = this.root.getChild("body").getChild("front_master").getChild("arm_r");
        this.front_master = this.root.getChild("body").getChild("front_master");
        this.neck_master = this.root.getChild("body").getChild("front_master").getChild("front").getChild("neck_master");
        this.neck = this.root.getChild("body").getChild("front_master").getChild("front").getChild("neck_master").getChild("neck");
        this.pistons = this.root.getChild("body").getChild("front_master").getChild("front").getChild("neck_master").getChild("pistons");
        this.head = this.root.getChild("body").getChild("front_master").getChild("front").getChild("neck_master").getChild("neck").getChild("head");
        this.combine = this.root.getChild("combine");
        this.roller = this.root.getChild("combine").getChild("roller");
        this.plough = this.root.getChild("plough");
        this.bolts_front = this.root.getChild("body").getChild("bolts_front");
        this.bolts_rear = this.root.getChild("body").getChild("bolts_rear");
        this.dial = this.root.getChild("body").getChild("front_master").getChild("front").getChild("neck_master").getChild("neck").getChild("dial");
        this.stand = this.root.getChild("body").getChild("stand");
        this.piston1 = this.root.getChild("body").getChild("back_master").getChild("back").getChild("piston1").getChild("bone7");
        this.piston2 = this.root.getChild("body").getChild("back_master").getChild("back").getChild("piston2").getChild("bone8");
        this.piston3 = this.root.getChild("body").getChild("back_master").getChild("back").getChild("piston3").getChild("bone9");
        this.piston4 = this.root.getChild("body").getChild("back_master").getChild("back").getChild("piston4").getChild("bone10");
        this.piston5 = this.root.getChild("body").getChild("back_master").getChild("back").getChild("piston5").getChild("bone11");
        this.piston6 = this.root.getChild("body").getChild("back_master").getChild("back").getChild("piston6").getChild("bone12");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(183, 206).addBox(-11.5F, -2.0F, -6.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(183, 206).addBox(-11.5F, -2.0F, 4.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(183, 191).addBox(-11.5F, 11.0F, -4.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(113, 194).addBox(-11.5F, -2.0F, -4.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(207, 186).addBox(10.5F, -8.5F, 8.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(207, 186).addBox(10.5F, -8.5F, -10.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(207, 186).addBox(-12.5F, -8.5F, 8.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(207, 186).addBox(-12.5F, -8.5F, -10.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(104, 164).addBox(-9.5F, -2.5F, -7.0F, 12.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 115).addBox(-10.5F, -9.0F, -11.0F, 21.0F, 23.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(202, 157).addBox(-6.5F, -10.0F, -7.0F, 13.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(191, 235).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -11.9F, -8.6F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(199, 234).addBox(-1.0F, -4.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -8.0F, -8.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition back_master = body.addOrReplaceChild("back_master", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 9.0F));

        PartDefinition back = back_master.addOrReplaceChild("back", CubeListBuilder.create().texOffs(208, 121).addBox(-4.0F, -6.0F, 3.25F, 8.0F, 20.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(129, 195).addBox(10.0F, -7.0F, 3.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(129, 195).addBox(-11.0F, -7.0F, 3.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(140, 136).addBox(-10.0F, -7.0F, 3.0F, 20.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(217, 236).addBox(-2.0F, -11.0F, 15.5F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(217, 236).addBox(-2.0F, -11.0F, 2.99F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(242, 245).addBox(-10.0F, 4.5F, 3.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(242, 245).addBox(4.0F, 4.5F, 3.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(129, 195).addBox(7.0F, 10.0F, 4.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(129, 195).addBox(7.0F, 7.0F, 4.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(129, 195).addBox(-8.0F, 10.0F, 4.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(129, 195).addBox(-8.0F, 7.0F, 4.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(192, 250).addBox(-6.0F, 10.0F, 17.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r3 = back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(146, 239).addBox(-5.0F, -5.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 13.0F, 17.75F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r4 = back.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(146, 239).addBox(0.0F, -5.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 13.0F, 17.75F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r5 = back.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(43, 209).addBox(-4.5F, -4.5F, -12.0F, 9.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 15.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition chest_back_l = back.addOrReplaceChild("chest_back_l", CubeListBuilder.create().texOffs(43, 184).addBox(-4.0F, -2.0F, -5.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(236, 245).addBox(2.0F, 0.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -3.0F, 8.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition chest_back_r = back.addOrReplaceChild("chest_back_r", CubeListBuilder.create().texOffs(43, 184).addBox(-2.0F, -2.0F, -5.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(236, 245).addBox(-3.0F, 0.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -3.0F, 8.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition piston1 = back.addOrReplaceChild("piston1", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 14.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone7 = piston1.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(43, 186).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 196).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-5.5F, -3.0F, -9.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 196).addBox(-5.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-5.5F, -4.45F, -9.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston2 = back.addOrReplaceChild("piston2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 10.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone8 = piston2.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(43, 186).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 196).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-5.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 196).addBox(-5.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-5.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston3 = back.addOrReplaceChild("piston3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 6.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone9 = piston3.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(43, 186).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 196).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-5.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 186).addBox(-5.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(43, 196).addBox(-5.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston4 = back.addOrReplaceChild("piston4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 6.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone10 = piston4.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(43, 186).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 196).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(2.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(2.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 196).mirror().addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston5 = back.addOrReplaceChild("piston5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 10.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone11 = piston5.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(43, 186).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 196).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(2.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 196).mirror().addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(2.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston6 = back.addOrReplaceChild("piston6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 14.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone12 = piston6.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(43, 186).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 196).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(2.5F, -3.0F, -9.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 196).mirror().addBox(3.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(43, 186).mirror().addBox(2.5F, -4.45F, -9.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_r = back_master.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(154, 205).addBox(-4.0F, -4.0F, -4.5F, 5.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 5.0F, 8.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone3 = leg_r.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(219, 207).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 11.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition leg_l = back_master.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(154, 205).addBox(-1.0F, -4.0F, -4.5F, 5.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 5.0F, 8.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone4 = leg_l.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(219, 207).mirror().addBox(-1.5F, -1.0F, -4.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 11.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition bolts_front = body.addOrReplaceChild("bolts_front", CubeListBuilder.create().texOffs(160, 250).addBox(14.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(160, 250).mirror().addBox(-14.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -3.0F, -9.0F));

        PartDefinition bolts_rear = body.addOrReplaceChild("bolts_rear", CubeListBuilder.create().texOffs(160, 250).addBox(14.0F, -3.0F, 6.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(160, 250).mirror().addBox(-14.0F, -3.0F, 6.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -2.0F, 1.5F));

        PartDefinition front_master = body.addOrReplaceChild("front_master", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -10.75F));

        PartDefinition front = front_master.addOrReplaceChild("front", CubeListBuilder.create().texOffs(156, 159).addBox(-8.0F, -8.0F, -15.0F, 16.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(54, 160).addBox(-5.0F, 4.0F, -14.0F, 10.0F, 9.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(242, 245).addBox(4.25F, 3.5F, -2.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(242, 245).addBox(-10.25F, 3.5F, -2.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(192, 250).addBox(-6.0F, 9.0F, -16.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(128, 195).addBox(8.0F, -8.0F, -15.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(128, 195).addBox(-10.0F, -8.0F, -15.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(148, 187).addBox(7.0F, 9.0F, -14.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(148, 187).addBox(7.0F, 6.0F, -14.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(148, 187).addBox(-8.0F, 9.0F, -14.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(148, 187).addBox(-8.0F, 6.0F, -14.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r6 = front.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(146, 239).addBox(-5.0F, -5.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 12.0F, -13.75F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r7 = front.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(146, 239).addBox(0.0F, -5.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 12.0F, -13.75F, 0.0F, 0.0F, -0.4363F));

        PartDefinition chest_front_r = front.addOrReplaceChild("chest_front_r", CubeListBuilder.create().texOffs(43, 184).addBox(-2.0F, -2.0F, -8.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(236, 245).addBox(-3.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.25F, -7.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition chest_front_l = front.addOrReplaceChild("chest_front_l", CubeListBuilder.create().texOffs(43, 184).addBox(-4.0F, -2.0F, -8.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(236, 245).addBox(2.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.25F, -7.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition neck_master = front.addOrReplaceChild("neck_master", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -14.0F));

        PartDefinition pistons = neck_master.addOrReplaceChild("pistons", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r8 = pistons.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(131, 198).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r9 = pistons.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(131, 198).addBox(-2.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.0F));

        PartDefinition cube_r10 = pistons.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(131, 198).addBox(0.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition neck = neck_master.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(216, 172).addBox(-5.0F, -2.5F, -11.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(226, 187).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 0.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(238, 187).addBox(-4.0F, -2.5F, -10.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(238, 187).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(238, 179).addBox(4.0F, -2.5F, -10.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(238, 179).addBox(-4.0F, -2.5F, -10.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(132, 198).addBox(4.0F, 1.0F, -11.5F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(132, 198).addBox(-5.0F, 1.0F, -11.5F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(114, 214).addBox(-5.0F, -2.5F, -18.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(114, 214).addBox(4.0F, -2.5F, -18.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(85, 192).addBox(-3.99F, -2.0F, -11.5F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition dial = neck.addOrReplaceChild("dial", CubeListBuilder.create().texOffs(228, 191).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.25F, -8.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(19, 208).addBox(-4.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(222, 244).addBox(-9.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(240, 210).addBox(2.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(160, 234).addBox(5.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 214).mirror().addBox(-3.0F, -3.5F, -4.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(182, 251).addBox(-2.0F, 9.5F, -3.75F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(176, 251).addBox(-1.0F, 10.5F, -3.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(179, 255).addBox(-1.0F, 10.5F, -3.75F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(177, 254).addBox(-1.0F, 12.5F, -3.75F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -15.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r11 = head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 202).addBox(-3.0F, 0.0F, 0.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.5F, -4.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(130, 218).addBox(-2.0F, 0.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -1.0F, 0.0F, 0.1745F, -0.2182F));

        PartDefinition cube_r13 = head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(234, 236).addBox(-2.0F, 0.5F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -4.6F, -2.45F, -0.1309F, 0.48F, -0.48F));

        PartDefinition cube_r14 = head.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(234, 236).mirror().addBox(-5.0F, 0.5F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-14.0F, -4.6F, -2.45F, -0.1309F, -0.48F, 0.4363F));

        PartDefinition cube_r15 = head.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(130, 218).mirror().addBox(-5.0F, 0.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -3.0F, -1.0F, 0.0F, -0.1745F, 0.2182F));

        PartDefinition rope = head.addOrReplaceChild("rope", CubeListBuilder.create().texOffs(228, 167).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 13.5F, -3.75F));

        PartDefinition arm_l = front_master.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(0, 186).addBox(-1.0F, -4.0F, -3.5F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 4.0F, -6.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone5 = arm_l.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(174, 186).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(171, 198).addBox(-1.0F, -2.3617F, -2.1471F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, -2.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition arm_r = front_master.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(0, 186).addBox(-4.0F, -4.0F, -3.5F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 4.0F, -6.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone = arm_r.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(174, 186).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(171, 198).addBox(-2.0F, -2.3617F, -2.1471F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, -2.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition lever_l = body.addOrReplaceChild("lever_l", CubeListBuilder.create().texOffs(209, 187).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(209, 187).addBox(-0.5F, -10.0F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -9.0F, -7.5F));

        PartDefinition cube_r16 = lever_l.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(234, 186).addBox(0.0F, -3.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7F, 1.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition lever_r = body.addOrReplaceChild("lever_r", CubeListBuilder.create().texOffs(209, 187).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(209, 187).addBox(-0.5F, -10.0F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -9.0F, -7.5F));

        PartDefinition cube_r17 = lever_r.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(234, 186).addBox(0.0F, -3.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7F, 1.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition door = body.addOrReplaceChild("door", CubeListBuilder.create().texOffs(193, 201).addBox(-0.5F, -6.0F, -9.0F, 2.0F, 12.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(233, 212).addBox(-2.5F, -4.5F, -9.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 186).addBox(-0.5F, -5.0F, -2.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 186).addBox(-0.5F, -5.0F, -8.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 186).addBox(-0.5F, -5.0F, -4.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(228, 186).addBox(-0.5F, -5.0F, -6.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.5F, 5.0F, 4.5F));

        PartDefinition chest_middle_top = body.addOrReplaceChild("chest_middle_top", CubeListBuilder.create().texOffs(43, 184).addBox(-4.0F, -2.0F, -6.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(236, 245).addBox(2.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -5.5F, -1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition chest_middle_bottom = body.addOrReplaceChild("chest_middle_bottom", CubeListBuilder.create().texOffs(43, 184).addBox(-4.0F, -2.0F, -6.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(236, 245).addBox(2.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 5.5F, -1.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(199, 188).addBox(7.75F, 0.0F, 8.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(199, 188).addBox(7.75F, 0.0F, -10.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(127, 193).addBox(8.25F, 0.0F, -8.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(127, 193).addBox(-9.0F, 0.0F, -8.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(199, 188).addBox(-9.5F, 0.0F, -10.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(199, 188).addBox(-9.5F, 0.0F, 8.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(217, 232).addBox(-7.5F, 0.0F, 8.5F, 16.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(217, 232).addBox(-7.5F, 0.0F, -9.5F, 16.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition combine = root.addOrReplaceChild("combine", CubeListBuilder.create(), PartPose.offset(2.5F, -27.5F, -9.0F));

        PartDefinition cube_r18 = combine.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(92, 212).addBox(11.0F, -2.5F, -5.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(178, 185).addBox(11.5F, -1.5F, -42.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(0, 194).addBox(11.0F, 4.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(0, 194).addBox(11.0F, -2.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(178, 185).mirror().addBox(-17.5F, -1.5F, -42.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 194).mirror().addBox(-18.0F, 4.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 194).mirror().addBox(-18.0F, -2.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(92, 212).mirror().addBox(-18.0F, -2.5F, -5.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r19 = combine.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 237).addBox(-50.0F, -1.0F, 0.0F, 50.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, 19.9F, -39.2F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r20 = combine.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(202, 232).addBox(23.0F, -1.5F, -1.5F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(202, 232).mirror().addBox(-29.0F, -1.5F, -1.5F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 22.5F, -46.5F, 0.2618F, 0.0F, 0.0F));

        PartDefinition roller = combine.addOrReplaceChild("roller", CubeListBuilder.create().texOffs(232, 186).addBox(26.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(232, 186).addBox(13.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(232, 186).mirror().addBox(-26.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(232, 186).mirror().addBox(-13.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(232, 186).mirror().addBox(0.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 22.5F, -46.5F));

        PartDefinition cube_r21 = roller.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(-2, 247).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 246).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7053F, 0.0873F, 0.0F));

        PartDefinition cube_r22 = roller.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(-2, 247).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 246).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0071F, 0.0F, -0.0873F));

        PartDefinition cube_r23 = roller.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(-2, 247).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 246).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, -0.0873F, 0.0F));

        PartDefinition cube_r24 = roller.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(-2, 247).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 246).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 0.0F, 0.0873F));

        PartDefinition plough = root.addOrReplaceChild("plough", CubeListBuilder.create().texOffs(0, 249).addBox(-40.5F, 19.5F, 34.5F, 76.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -27.5F, 9.0F));

        PartDefinition cube_r25 = plough.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(92, 212).addBox(11.0F, -2.5F, -2.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(178, 185).addBox(11.5F, -1.5F, 5.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(0, 194).addBox(11.0F, 4.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(0, 194).addBox(11.0F, -2.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(178, 185).mirror().addBox(-17.5F, -1.5F, 5.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 194).mirror().addBox(-18.0F, 4.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 194).mirror().addBox(-18.0F, -2.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(92, 212).mirror().addBox(-18.0F, -2.5F, -2.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r26 = plough.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(92, 228).addBox(-40.0F, -2.0F, -2.0F, 80.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 232).addBox(-39.5F, 0.0F, 0.0F, 79.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 23.5F, 39.5F, -0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(OxhaulerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OxhaulerAnimations.oxhauler_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, OxhaulerAnimations.oxhauler_assembly, ageInTicks, 1f);

        this.animate(entity.idleAnimation1, OxhaulerAnimations.oxhauler_idle1, ageInTicks, 1f);
        this.animate(entity.idleAnimation2, OxhaulerAnimations.oxhauler_idle2, ageInTicks, 1f);
        this.animate(entity.idleAnimation3, OxhaulerAnimations.oxhauler_idle3, ageInTicks, 1f);

        float piston1 = entity.getFuel() > 0 ? Mth.sin(AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) + 1 : 1;
        float piston2 = entity.getFuel() > 0 ? Mth.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) + (Mth.PI * 2/3)) + 1 : 1;
        float piston3 = entity.getFuel() > 0 ? Mth.sin((AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks()) - (Mth.PI * 2/3)) + 1 : 1;

        back_master.visible = entity.getAssembly() > 0;
        front_master.visible = entity.getAssembly() > 1;
        leg_l.visible = entity.getAssembly() > 2;
        leg_r.visible = entity.getAssembly() > 3;
        arm_l.visible = entity.getAssembly() > 4;
        arm_r.visible = entity.getAssembly() > 5;
        neck_master.visible = entity.getAssembly() > 6;

        combine.visible = entity.isHarvester();
        plough.visible = entity.isPlough();
        bolts_front.visible = entity.isHarvester();
        bolts_rear.visible = entity.isPlough();

        this.piston1.y = piston1;
        this.piston4.y = piston1;

        this.piston2.y = piston2;
        this.piston5.y = piston2;

        this.piston3.y = piston3;
        this.piston6.y = piston3;

        stand.visible = entity.getFuel() == 0;

        dial.yRot = (float) entity.getFuel() / 25000 * (Mth.PI / 2) - Mth.PI / 2;
        roller.xRot = ScrollValueHandler.getScroll(AnimationTickHolder.getPartialTicks()) / 20;
    }
    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw/2, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch/2 + 22.5f, -25.0F, 45.0F);

        this.neck.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.neck.xRot = pHeadPitch * ((float)Math.PI / 180F);

        this.head.xRot = -pHeadPitch * ((float)Math.PI / 180F);

        this.pistons.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.pistons.xRot = pHeadPitch * ((float)Math.PI / 180F) + (-10 * (Mth.PI / 180));
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
