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
    private final ModelPart leg_l;
    private final ModelPart leg_r;
    private final ModelPart arm_l;
    private final ModelPart arm_r;
    private final ModelPart combine;
    private final ModelPart roller;
    private final ModelPart plough;
    private final ModelPart bolts_front;
    private final ModelPart bolts_rear;

    public OxhaulerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.back_master = this.root.getChild("body").getChild("back_master");
        this.leg_l = this.root.getChild("body").getChild("back_master").getChild("leg_l");
        this.leg_r = this.root.getChild("body").getChild("back_master").getChild("leg_r");
        this.arm_l = this.root.getChild("body").getChild("front_master").getChild("arm_l");
        this.arm_r = this.root.getChild("body").getChild("front_master").getChild("arm_r");
        this.front_master = this.root.getChild("body").getChild("front_master");
        this.neck_master = this.root.getChild("body").getChild("front_master").getChild("front").getChild("neck_master");
        this.combine = this.root.getChild("combine");
        this.roller = this.root.getChild("combine").getChild("roller");
        this.plough = this.root.getChild("plough");
        this.bolts_front = this.root.getChild("body").getChild("bolts_front");
        this.bolts_rear = this.root.getChild("body").getChild("bolts_rear");
   }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(184, 30).addBox(-11.5F, 4.0F, -6.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(184, 46).addBox(-11.5F, 4.0F, 4.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 167).addBox(-11.5F, 17.0F, -4.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(168, 0).addBox(-11.5F, 4.0F, -4.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(48, 167).addBox(10.5F, -2.5F, 8.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 167).addBox(10.5F, -2.5F, -10.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 167).addBox(-12.5F, -2.5F, 8.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 167).addBox(-12.5F, -2.5F, -10.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(60, 81).addBox(-9.5F, 3.5F, -7.0F, 12.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-10.5F, -3.0F, -11.0F, 21.0F, 23.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(86, 24).addBox(-6.5F, -4.0F, -7.0F, 13.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -30.0F, 0.0F));

        PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(109, 135).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.9F, -8.6F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(106, 134).addBox(-1.0F, -4.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.0F, -8.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition back_master = body.addOrReplaceChild("back_master", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 9.0F));

        PartDefinition back = back_master.addOrReplaceChild("back", CubeListBuilder.create().texOffs(68, 45).addBox(-4.0F, -6.0F, 3.25F, 8.0F, 20.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(105, 114).addBox(10.0F, -7.0F, 3.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(105, 114).addBox(-11.0F, -7.0F, 3.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-10.0F, -7.0F, 3.0F, 20.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-2.0F, -11.0F, 15.5F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-2.0F, -11.0F, 2.99F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(172, 185).addBox(-10.0F, 4.5F, 3.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(172, 185).addBox(4.0F, 4.5F, 3.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(105, 114).addBox(7.0F, 10.0F, 4.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(105, 114).addBox(7.0F, 7.0F, 4.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(105, 114).addBox(-8.0F, 10.0F, 4.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(105, 114).addBox(-8.0F, 7.0F, 4.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(86, 39).addBox(-6.0F, 10.0F, 17.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r3 = back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(188, 133).addBox(-5.0F, -5.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 13.0F, 17.75F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r4 = back.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(188, 133).addBox(0.0F, -5.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 13.0F, 17.75F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r5 = back.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 119).addBox(-4.5F, -4.5F, -12.0F, 9.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 15.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r6 = back.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(44, 109).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -11.0F, 17.5F, 2.3562F, 0.0F, 0.0F));

        PartDefinition flag = back.addOrReplaceChild("flag", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition flag3 = flag.addOrReplaceChild("flag3", CubeListBuilder.create().texOffs(51, 101).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition flag4 = flag3.addOrReplaceChild("flag4", CubeListBuilder.create().texOffs(69, 101).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition chest_back_l = back.addOrReplaceChild("chest_back_l", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -5.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -3.0F, 8.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition chest_back_r = back.addOrReplaceChild("chest_back_r", CubeListBuilder.create().texOffs(0, 94).addBox(-2.0F, -2.0F, -5.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(-3.0F, 0.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -3.0F, 8.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition piston1 = back.addOrReplaceChild("piston1", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 14.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone7 = piston1.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -3.0F, -9.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-5.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -4.45F, -9.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston6 = back.addOrReplaceChild("piston6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 14.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone12 = piston6.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -3.0F, -9.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(3.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -4.45F, -9.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston2 = back.addOrReplaceChild("piston2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 10.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone8 = piston2.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-5.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston5 = back.addOrReplaceChild("piston5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 10.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone11 = piston5.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston3 = back.addOrReplaceChild("piston3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 6.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone9 = piston3.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-5.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition piston4 = back.addOrReplaceChild("piston4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 6.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone10 = piston4.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_r = back_master.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(106, 143).addBox(-4.0F, -4.0F, -4.5F, 5.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 5.0F, 8.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone3 = leg_r.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(74, 179).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 11.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition leg_l = back_master.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(106, 143).addBox(-1.0F, -4.0F, -4.5F, 5.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 5.0F, 8.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone4 = leg_l.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(88, 179).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 11.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition bolts_front = body.addOrReplaceChild("bolts_front", CubeListBuilder.create().texOffs(107, 171).addBox(14.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(107, 171).mirror().addBox(-14.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 3.0F, -9.0F));

        PartDefinition bolts_rear = body.addOrReplaceChild("bolts_rear", CubeListBuilder.create().texOffs(107, 171).addBox(14.0F, -3.0F, 6.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(107, 171).mirror().addBox(-14.0F, -3.0F, 6.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 4.0F, 1.5F));

        PartDefinition front_master = body.addOrReplaceChild("front_master", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -10.75F));

        PartDefinition front = front_master.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 68).addBox(-8.0F, -8.0F, -15.0F, 16.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(86, 0).addBox(-5.0F, 4.0F, -14.0F, 10.0F, 9.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(172, 185).addBox(4.25F, 3.5F, -2.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(172, 185).addBox(-10.25F, 3.5F, -2.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 39).addBox(-6.0F, 9.0F, -16.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(104, 114).addBox(8.0F, -8.0F, -15.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(104, 114).addBox(-10.0F, -8.0F, -15.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(158, 49).addBox(7.0F, 9.0F, -14.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(158, 49).addBox(7.0F, 6.0F, -14.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(158, 49).addBox(-8.0F, 9.0F, -14.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(158, 49).addBox(-8.0F, 6.0F, -14.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r7 = front.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(188, 133).addBox(-5.0F, -5.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 12.0F, -13.75F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r8 = front.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(188, 133).addBox(0.0F, -5.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 12.0F, -13.75F, 0.0F, 0.0F, -0.4363F));

        PartDefinition chest_front_r = front.addOrReplaceChild("chest_front_r", CubeListBuilder.create().texOffs(0, 94).addBox(-2.0F, -2.0F, -8.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(-3.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.25F, -7.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition chest_front_l = front.addOrReplaceChild("chest_front_l", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -8.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.25F, -7.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition neck_master = front.addOrReplaceChild("neck_master", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -14.0F));

        PartDefinition pistons = neck_master.addOrReplaceChild("pistons", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r9 = pistons.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(107, 117).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r10 = pistons.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(107, 117).addBox(-2.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.0F));

        PartDefinition cube_r11 = pistons.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(107, 117).addBox(0.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition neck = neck_master.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(116, 64).addBox(-5.0F, -2.5F, -11.0F, 10.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(108, 117).addBox(4.0F, 1.0F, -11.5F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(108, 117).addBox(-5.0F, 1.0F, -11.5F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(90, 151).addBox(-5.0F, -2.5F, -18.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(90, 151).addBox(4.0F, -2.5F, -18.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(126, 106).addBox(-3.99F, -2.0F, -11.5F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(180, 93).addBox(-4.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(152, 177).addBox(-9.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(102, 180).addBox(2.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(176, 142).addBox(5.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(158, 32).mirror().addBox(-3.0F, -3.5F, -4.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(30, 144).addBox(-2.0F, 9.5F, -3.75F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 144).addBox(-1.0F, 10.5F, -3.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -15.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 176).addBox(-3.0F, 0.0F, 0.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.5F, -4.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r13 = head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(172, 20).addBox(-2.0F, 0.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -1.0F, 0.0F, 0.1745F, -0.2182F));

        PartDefinition cube_r14 = head.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(172, 177).addBox(-2.0F, 0.5F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -4.6F, -2.45F, -0.1309F, 0.48F, -0.48F));

        PartDefinition cube_r15 = head.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(176, 154).addBox(-5.0F, 0.5F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.6F, -2.45F, -0.1309F, -0.48F, 0.4363F));

        PartDefinition cube_r16 = head.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(172, 10).addBox(-5.0F, 0.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -3.0F, -1.0F, 0.0F, -0.1745F, 0.2182F));

        PartDefinition rope = head.addOrReplaceChild("rope", CubeListBuilder.create().texOffs(32, 115).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 13.5F, -3.75F));

        PartDefinition arm_l = front_master.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(164, 126).addBox(-1.0F, -4.0F, -3.5F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 4.0F, -6.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone5 = arm_l.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(56, 179).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(184, 76).addBox(-1.0F, -2.3617F, -2.1471F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, -2.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition arm_r = front_master.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(0, 160).addBox(-4.0F, -4.0F, -3.5F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 4.0F, -6.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone = arm_r.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 177).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(184, 62).addBox(-2.0F, -2.3617F, -2.1471F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, -2.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition lever_l = body.addOrReplaceChild("lever_l", CubeListBuilder.create().texOffs(50, 168).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 168).addBox(-0.5F, -10.0F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, -7.5F));

        PartDefinition cube_r17 = lever_l.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(66, 68).addBox(0.0F, -3.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7F, 1.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition lever_r = body.addOrReplaceChild("lever_r", CubeListBuilder.create().texOffs(50, 168).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 168).addBox(-0.5F, -10.0F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -3.0F, -7.5F));

        PartDefinition cube_r18 = lever_r.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(66, 68).addBox(0.0F, -3.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7F, 1.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition door = body.addOrReplaceChild("door", CubeListBuilder.create().texOffs(154, 143).addBox(-0.5F, -6.0F, -9.0F, 2.0F, 12.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(144, 190).addBox(-2.5F, -4.5F, -9.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -2.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -8.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -4.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -6.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.5F, 11.0F, 4.5F));

        PartDefinition chest_middle_top = body.addOrReplaceChild("chest_middle_top", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -6.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.5F, -1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition chest_middle_bottom = body.addOrReplaceChild("chest_middle_bottom", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -6.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 11.5F, -1.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition stand = body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(64, 0).addBox(7.75F, 0.0F, 8.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(7.75F, 0.0F, -10.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(103, 112).addBox(8.25F, 0.0F, -8.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(103, 112).addBox(-9.0F, 0.0F, -8.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(-9.5F, 0.0F, -10.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(-9.5F, 0.0F, 8.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(117, 52).addBox(-7.5F, 0.0F, 8.5F, 16.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(117, 52).addBox(-7.5F, 0.0F, -9.5F, 16.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        PartDefinition combine = root.addOrReplaceChild("combine", CubeListBuilder.create(), PartPose.offset(2.5F, -27.5F, -9.0F));

        PartDefinition cube_r19 = combine.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(234, 186).addBox(11.0F, -2.5F, -5.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).addBox(11.5F, -1.5F, -42.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, 4.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, -2.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).mirror().addBox(-17.5F, -1.5F, -42.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, 4.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, -2.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(234, 186).mirror().addBox(-18.0F, -2.5F, -5.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r20 = combine.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 264).addBox(-50.0F, -1.0F, 0.0F, 50.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, 19.9F, -39.2F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r21 = combine.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(98, 204).addBox(23.0F, -1.5F, -1.5F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(98, 204).mirror().addBox(-29.0F, -1.5F, -1.5F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 22.5F, -46.5F, 0.2618F, 0.0F, 0.0F));

        PartDefinition roller = combine.addOrReplaceChild("roller", CubeListBuilder.create().texOffs(62, 122).addBox(26.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(62, 122).addBox(13.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(62, 122).mirror().addBox(-26.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(62, 122).mirror().addBox(-13.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(62, 122).mirror().addBox(0.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 22.5F, -46.5F));

        PartDefinition cube_r22 = roller.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7053F, 0.0873F, 0.0F));

        PartDefinition cube_r23 = roller.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0071F, 0.0F, -0.0873F));

        PartDefinition cube_r24 = roller.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, -0.0873F, 0.0F));

        PartDefinition cube_r25 = roller.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 0.0F, 0.0873F));

        PartDefinition plough = root.addOrReplaceChild("plough", CubeListBuilder.create().texOffs(93, 252).addBox(-40.5F, 19.5F, 34.5F, 76.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -27.5F, 9.0F));

        PartDefinition cube_r26 = plough.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(234, 186).addBox(11.0F, -2.5F, -2.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).addBox(11.5F, -1.5F, 5.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, 4.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, -2.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).mirror().addBox(-17.5F, -1.5F, 5.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, 4.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, -2.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(234, 186).mirror().addBox(-18.0F, -2.5F, -2.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r27 = plough.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(92, 278).addBox(-40.0F, -2.0F, -2.0F, 80.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 286).addBox(-39.5F, 0.0F, 0.0F, 79.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 23.5F, 39.5F, -0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 512);
    }

    @Override
    public void setupAnim(OxhaulerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OxhaulerAnimations.oxhauler_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        if (entity.getFuel() > 0) {
            this.animate(entity.idleAnimationState, OxhaulerAnimations.oxhauler_idle, ageInTicks, 1f);
        } else {
            this.animate(entity.idleAnimationState, OxhaulerAnimations.oxhauler_assembly, ageInTicks, 1f);
        }

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

        roller.xRot = ScrollValueHandler.getScroll(AnimationTickHolder.getPartialTicks()) / 20;
    }
    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.neck_master.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.neck_master.xRot = pHeadPitch * ((float)Math.PI / 180F);
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
