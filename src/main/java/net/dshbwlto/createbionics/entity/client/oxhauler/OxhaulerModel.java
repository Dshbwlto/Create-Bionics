package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.client.anole.AnoleAnimations;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class OxhaulerModel <T extends OxhaulerEntity> extends  HierarchicalModel<T>
{
    private final ModelPart Root;
    private final ModelPart BackMaster;
    private final ModelPart FrontMaster;
    private final ModelPart neck_master;
    private final ModelPart Head;

    public OxhaulerModel(ModelPart root) {
        this.Root = root.getChild("Root");
        this.BackMaster = this.Root.getChild("Body").getChild("BackMaster");
        this.FrontMaster = this.Root.getChild("Body").getChild("FrontMaster");
        this.neck_master = this.Root.getChild("Body").getChild("FrontMaster").getChild("Front").getChild("neck_master");
        this.Head = this.Root.getChild("Body").getChild("FrontMaster").getChild("Front").getChild("neck_master").getChild("Neck").getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(184, 30).addBox(-11.5F, 4.0F, -6.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(184, 46).addBox(-11.5F, 4.0F, 4.5F, 3.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 167).addBox(-11.5F, 17.0F, -4.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(168, 0).addBox(-11.5F, 4.0F, -4.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(136, 166).addBox(10.5F, -2.5F, 8.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(144, 166).addBox(10.5F, -2.5F, -10.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(48, 167).addBox(-12.5F, -2.5F, 8.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 177).addBox(-12.5F, -2.5F, -10.0F, 2.0F, 22.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(60, 81).addBox(-9.5F, 3.5F, -7.0F, 12.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-10.5F, -3.0F, -11.0F, 21.0F, 23.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(86, 24).addBox(-6.5F, -4.0F, -7.0F, 13.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -30.0F, 0.0F));

        PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 191).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.9F, -8.6F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(106, 134).addBox(-1.0F, -4.0F, 0.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.0F, -8.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(126, 126).addBox(-4.0F, 0.0F, -7.0F, 4.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, -2.0F, -0.5F, 0.0F, 0.0F, -0.4363F));

        PartDefinition BackMaster = Body.addOrReplaceChild("BackMaster", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 9.0F));

        PartDefinition Back = BackMaster.addOrReplaceChild("Back", CubeListBuilder.create().texOffs(68, 45).addBox(-4.0F, -6.0F, 3.25F, 8.0F, 20.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(74, 134).addBox(10.0F, -6.5F, 2.0F, 1.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(42, 134).addBox(-11.0F, -6.5F, 2.0F, 1.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 45).addBox(-10.0F, -7.0F, 3.0F, 20.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-2.0F, -11.0F, 15.5F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 52).addBox(-2.0F, -11.0F, 3.0F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(180, 162).addBox(-10.25F, 4.5F, 3.0F, 7.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 180).addBox(3.25F, 4.5F, 3.0F, 7.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 144).addBox(7.0F, 10.0F, 4.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(60, 151).addBox(7.0F, 7.0F, 4.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(30, 151).addBox(-8.0F, 10.0F, 4.0F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(154, 78).addBox(-8.0F, 7.0F, 4.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(166, 120).addBox(-6.0F, 10.0F, 17.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r4 = Back.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(188, 126).addBox(-5.0F, -5.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 13.0F, 17.75F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r5 = Back.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(188, 133).addBox(0.0F, -5.0F, 0.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 13.0F, 17.75F, 0.0F, 0.0F, -0.4363F));

        PartDefinition cube_r6 = Back.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 119).addBox(-4.5F, -4.5F, -12.0F, 9.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 15.5F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r7 = Back.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(44, 109).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -11.0F, 17.5F, 2.3562F, 0.0F, 0.0F));

        PartDefinition FlagRoot = Back.addOrReplaceChild("FlagRoot", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag1 = FlagRoot.addOrReplaceChild("Flag1", CubeListBuilder.create().texOffs(51, 101).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag2 = Flag1.addOrReplaceChild("Flag2", CubeListBuilder.create().texOffs(69, 101).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition ChestBackL = Back.addOrReplaceChild("ChestBackL", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -5.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -2.0F, 8.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition ChestBackR = Back.addOrReplaceChild("ChestBackR", CubeListBuilder.create().texOffs(0, 94).addBox(-2.0F, -2.0F, -5.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(-3.0F, 0.0F, 1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -2.0F, 8.0F, 0.0F, 0.0F, 0.2182F));

        PartDefinition Piston1 = Back.addOrReplaceChild("Piston1", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 14.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone7 = Piston1.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -3.0F, -9.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-5.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -4.45F, -9.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Piston6 = Back.addOrReplaceChild("Piston6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 14.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone12 = Piston6.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -3.0F, -9.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(3.0F, -4.0F, -9.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -4.45F, -9.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Piston2 = Back.addOrReplaceChild("Piston2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 10.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone8 = Piston2.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-5.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Piston5 = Back.addOrReplaceChild("Piston5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 10.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone11 = Piston5.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Piston3 = Back.addOrReplaceChild("Piston3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -11.35F, 6.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition bone9 = Piston3.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-5.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-5.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Piston4 = Back.addOrReplaceChild("Piston4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -11.35F, 6.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition bone10 = Piston4.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(-1.5F, -4.45F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -3.0F, 2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).mirror().addBox(2.5F, -4.45F, 2.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 10).mirror().addBox(3.0F, -4.0F, 3.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition LegR = BackMaster.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(106, 143).addBox(-4.0F, -4.0F, -4.5F, 5.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 5.0F, 8.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone3 = LegR.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(74, 179).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(-1.25F, 7.25F, -0.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(0.25F, 7.25F, -0.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(152, 189).addBox(-2.0F, 8.25F, -4.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 11.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r8 = bone3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(56, 167).addBox(0.0F, -8.75F, -1.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.3883F, -2.8529F, 0.2182F, 0.0F, 0.0F));

        PartDefinition LegL = BackMaster.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(130, 143).addBox(-1.0F, -4.0F, -4.5F, 5.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 5.0F, 8.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone4 = LegL.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(88, 179).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(0.25F, 7.25F, -0.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(-1.25F, 7.25F, -0.25F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(190, 105).addBox(-2.0F, 8.25F, -4.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 11.0F, 3.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r9 = bone4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(56, 167).addBox(0.0F, -8.75F, -1.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.3883F, -2.8529F, 0.2182F, 0.0F, 0.0F));

        PartDefinition FrontMaster = Body.addOrReplaceChild("FrontMaster", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -10.75F));

        PartDefinition Front = FrontMaster.addOrReplaceChild("Front", CubeListBuilder.create().texOffs(0, 68).addBox(-8.0F, -8.0F, -15.0F, 16.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(86, 0).addBox(-5.0F, 4.0F, -14.0F, 10.0F, 9.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(172, 185).addBox(4.25F, 3.5F, -2.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(186, 185).addBox(-10.25F, 3.5F, -2.0F, 6.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 39).addBox(-6.0F, 9.0F, -16.0F, 12.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(136, 0).addBox(8.0F, -7.5F, -15.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(140, 16).addBox(-10.0F, -7.5F, -15.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(158, 49).addBox(7.0F, 9.0F, -14.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(60, 166).addBox(7.0F, 6.0F, -14.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(158, 63).addBox(-8.0F, 9.0F, -14.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(86, 166).addBox(-8.0F, 6.0F, -14.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r10 = Front.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 188).addBox(-5.0F, -5.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 12.0F, -13.75F, 0.0F, 0.0F, 0.4363F));

        PartDefinition cube_r11 = Front.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(140, 32).addBox(0.0F, -5.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 12.0F, -13.75F, 0.0F, 0.0F, -0.4363F));

        PartDefinition ChestFrontR = Front.addOrReplaceChild("ChestFrontR", CubeListBuilder.create().texOffs(0, 94).addBox(-2.0F, -2.0F, -8.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(-3.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -3.25F, -7.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition ChestFrontL = Front.addOrReplaceChild("ChestFrontL", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -8.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.25F, -7.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition neck_master = Front.addOrReplaceChild("neck_master", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -14.0F));

        PartDefinition Pistons = neck_master.addOrReplaceChild("Pistons", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r12 = Pistons.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(154, 164).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r13 = Pistons.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(154, 164).addBox(-2.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.0F));

        PartDefinition cube_r14 = Pistons.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(154, 93).addBox(0.0F, -2.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

        PartDefinition Neck = neck_master.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(90, 151).addBox(-5.0F, -2.5F, -18.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(42, 94).addBox(4.0F, -2.5F, -18.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(126, 106).addBox(-3.99F, -2.0F, -11.5F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r15 = Neck.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(112, 166).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -10.5F, 0.0F, 0.0F, -0.2182F));

        PartDefinition cube_r16 = Neck.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(166, 106).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -10.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition cube_r17 = Neck.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(116, 64).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -5.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(180, 93).addBox(-4.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(152, 177).addBox(-9.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(102, 180).addBox(2.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(176, 142).addBox(5.0F, -3.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(158, 32).mirror().addBox(-3.0F, -3.5F, -4.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(30, 144).addBox(-2.0F, 9.5F, -3.75F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 144).addBox(-1.0F, 10.5F, -3.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -15.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r18 = Head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 176).addBox(-3.0F, 0.0F, 0.0F, 5.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.5F, -4.5F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r19 = Head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(172, 20).addBox(-2.0F, 0.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -1.0F, 0.0F, 0.1745F, -0.2182F));

        PartDefinition cube_r20 = Head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(172, 177).addBox(-2.0F, 0.5F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -4.6F, -2.45F, -0.1309F, 0.48F, -0.48F));

        PartDefinition cube_r21 = Head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(176, 154).addBox(-5.0F, 0.5F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -4.6F, -2.45F, -0.1309F, -0.48F, 0.4363F));

        PartDefinition cube_r22 = Head.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(172, 10).addBox(-5.0F, 0.0F, -2.0F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -3.0F, -1.0F, 0.0F, -0.1745F, 0.2182F));

        PartDefinition Rope = Head.addOrReplaceChild("Rope", CubeListBuilder.create().texOffs(32, 115).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 13.5F, -3.75F));

        PartDefinition ArmL = FrontMaster.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(164, 126).addBox(-1.0F, -4.0F, -3.5F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 4.0F, -6.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone5 = ArmL.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(56, 179).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone6 = bone5.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(184, 76).addBox(-1.0F, -2.3617F, -2.1471F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(190, 110).addBox(-1.5F, 6.8883F, -2.6471F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(-0.75F, 5.8883F, 0.6029F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(0.75F, 5.8883F, 0.6029F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, -2.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r23 = bone6.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(56, 167).addBox(0.0F, -8.75F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.3883F, 1.8529F, 0.0873F, 0.0F, 0.0F));

        PartDefinition ArmR = FrontMaster.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(0, 160).addBox(-4.0F, -4.0F, -3.5F, 5.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 4.0F, -6.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone = ArmR.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(30, 177).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(184, 62).addBox(-2.0F, -2.3617F, -2.1471F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(30, 189).addBox(-2.5F, 6.8883F, -2.6471F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(-0.25F, 5.8883F, 0.6029F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(136, 20).addBox(-1.75F, 5.8883F, 0.6029F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, -2.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r24 = bone2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(56, 167).addBox(0.0F, -8.75F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.3883F, 1.8529F, 0.0873F, 0.0F, 0.0F));

        PartDefinition LeverL = Body.addOrReplaceChild("LeverL", CubeListBuilder.create().texOffs(44, 189).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 79).addBox(-0.5F, -10.0F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.0F, -7.5F));

        PartDefinition cube_r25 = LeverL.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(66, 68).addBox(0.0F, -3.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7F, 1.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition LeverR = Body.addOrReplaceChild("LeverR", CubeListBuilder.create().texOffs(140, 190).addBox(-0.5F, -12.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 79).addBox(-0.5F, -10.0F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -3.0F, -7.5F));

        PartDefinition cube_r26 = LeverR.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(66, 73).addBox(0.0F, -3.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7F, 1.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition Door = Body.addOrReplaceChild("Door", CubeListBuilder.create().texOffs(154, 143).addBox(-0.5F, -6.0F, -9.0F, 2.0F, 12.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(144, 190).addBox(-2.5F, -4.5F, -9.0F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -2.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -8.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -4.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(60, 68).addBox(-0.5F, -5.0F, -6.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.5F, 11.0F, 4.5F));

        PartDefinition ChestMiddleTop = Body.addOrReplaceChild("ChestMiddleTop", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -6.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.5F, -1.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition ChestMiddleBottom = Body.addOrReplaceChild("ChestMiddleBottom", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -2.0F, -6.5F, 6.0F, 10.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(190, 115).addBox(2.0F, 0.0F, 0.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 11.5F, -1.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition stand = Body.addOrReplaceChild("stand", CubeListBuilder.create().texOffs(64, 0).addBox(7.75F, 0.0F, 8.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(7.75F, 0.0F, -10.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(103, 112).addBox(8.25F, 0.0F, -8.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(103, 112).addBox(-9.0F, 0.0F, -8.0F, 1.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(-9.5F, 0.0F, -10.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(-9.5F, 0.0F, 8.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(117, 52).addBox(-7.5F, 0.0F, 8.5F, 16.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(117, 52).addBox(-7.5F, 0.0F, -9.5F, 16.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }



    @Override
    public void setupAnim(OxhaulerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(OxhaulerAnimations.oxhauler_walk, limbSwing, limbSwingAmount, 2f, 2.5f);
        if(entity.firstFuel()) {
            if (entity.isFueled()) {
                this.animate(entity.idleAnimationState, OxhaulerAnimations.oxhauler_idle, ageInTicks, 1f);
            } else {
                this.animate(entity.idleAnimationState, OxhaulerAnimations.oxhauler_dead, ageInTicks, 1f);
            }
        } else {
            this.animate(entity.idleAnimationState, OxhaulerAnimations.oxhauler_assembly, ageInTicks, 1f);
        }

        BackMaster.visible = entity.hasBack();
        FrontMaster.visible = entity.hasFront();
        neck_master.visible = entity.hasNeck();
    }
    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.neck_master.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.neck_master.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
    @Override
    public ModelPart root() {
        return Root;
    }

}
