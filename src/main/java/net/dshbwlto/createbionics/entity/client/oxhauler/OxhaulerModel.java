package net.dshbwlto.createbionics.entity.client.oxhauler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class OxhaulerModel <T extends OxhaulerEntity> extends  HierarchicalModel<T>
{
    private final ModelPart Root;
    private final ModelPart BackMaster;
    private final ModelPart FlagRootWhite;
    private final ModelPart FlagRootLightGray;
    private final ModelPart FlagRootGray;
    private final ModelPart FlagRootBlack;
    private final ModelPart FlagRootBrown;
    private final ModelPart FlagRootRed;
    private final ModelPart FlagRootOrange;
    private final ModelPart FlagRootYellow;
    private final ModelPart FlagRootLime;
    private final ModelPart FlagRootGreen;
    private final ModelPart FlagRootCyan;
    private final ModelPart FlagRootLightBlue;
    private final ModelPart FlagRootBlue;
    private final ModelPart FlagRootMagenta;
    private final ModelPart FlagRootPink;
    private final ModelPart FlagRootPurple;
    private final ModelPart FrontMaster;
    private final ModelPart neck_master;
    private final ModelPart combine;
    private final ModelPart plough;
    private final ModelPart bolts_front;
    private final ModelPart bolts_rear;

    public OxhaulerModel(ModelPart root) {
        this.Root = root.getChild("Root");
        this.BackMaster = this.Root.getChild("Body").getChild("BackMaster");
        this.FlagRootWhite = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootWhite");
        this.FlagRootLightGray = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootLightGray");
        this.FlagRootGray = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootGray");
        this.FlagRootBlack = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootBlack");
        this.FlagRootBrown = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootBrown");
        this.FlagRootRed = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootRed");
        this.FlagRootOrange = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootOrange");
        this.FlagRootYellow = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootYellow");
        this.FlagRootLime = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootLime");
        this.FlagRootGreen = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootGreen");
        this.FlagRootCyan = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootCyan");
        this.FlagRootLightBlue = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootLightBlue");
        this.FlagRootBlue = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootBlue");
        this.FlagRootMagenta = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootMagenta");
        this.FlagRootPink = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootPink");
        this.FlagRootPurple = this.Root.getChild("Body").getChild("BackMaster").getChild("Back").getChild("FlagRootPurple");
        this.FrontMaster = this.Root.getChild("Body").getChild("FrontMaster");
        this.neck_master = this.Root.getChild("Body").getChild("FrontMaster").getChild("Front").getChild("neck_master");
        this.combine = this.Root.getChild("combine");
        this.plough = this.Root.getChild("plough");
        this.bolts_front = this.Root.getChild("Body").getChild("bolts_front");
        this.bolts_rear = this.Root.getChild("Body").getChild("bolts_rear");
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

        PartDefinition FlagRootWhite = Back.addOrReplaceChild("FlagRootWhite", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag3 = FlagRootWhite.addOrReplaceChild("Flag3", CubeListBuilder.create().texOffs(220, 2).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag4 = Flag3.addOrReplaceChild("Flag4", CubeListBuilder.create().texOffs(238, 2).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootLightGray = Back.addOrReplaceChild("FlagRootLightGray", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag5 = FlagRootLightGray.addOrReplaceChild("Flag5", CubeListBuilder.create().texOffs(220, 13).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag6 = Flag5.addOrReplaceChild("Flag6", CubeListBuilder.create().texOffs(238, 13).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootGray = Back.addOrReplaceChild("FlagRootGray", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag7 = FlagRootGray.addOrReplaceChild("Flag7", CubeListBuilder.create().texOffs(220, 24).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag8 = Flag7.addOrReplaceChild("Flag8", CubeListBuilder.create().texOffs(238, 24).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootBlack = Back.addOrReplaceChild("FlagRootBlack", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag9 = FlagRootBlack.addOrReplaceChild("Flag9", CubeListBuilder.create().texOffs(220, 35).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag10 = Flag9.addOrReplaceChild("Flag10", CubeListBuilder.create().texOffs(238, 35).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootBrown = Back.addOrReplaceChild("FlagRootBrown", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag11 = FlagRootBrown.addOrReplaceChild("Flag11", CubeListBuilder.create().texOffs(220, 46).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag12 = Flag11.addOrReplaceChild("Flag12", CubeListBuilder.create().texOffs(238, 46).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootRed = Back.addOrReplaceChild("FlagRootRed", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag1 = FlagRootRed.addOrReplaceChild("Flag1", CubeListBuilder.create().texOffs(220, -9).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag2 = Flag1.addOrReplaceChild("Flag2", CubeListBuilder.create().texOffs(238, -9).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootOrange = Back.addOrReplaceChild("FlagRootOrange", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag13 = FlagRootOrange.addOrReplaceChild("Flag13", CubeListBuilder.create().texOffs(220, 57).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag14 = Flag13.addOrReplaceChild("Flag14", CubeListBuilder.create().texOffs(238, 57).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootYellow = Back.addOrReplaceChild("FlagRootYellow", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag15 = FlagRootYellow.addOrReplaceChild("Flag15", CubeListBuilder.create().texOffs(220, 68).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag16 = Flag15.addOrReplaceChild("Flag16", CubeListBuilder.create().texOffs(238, 68).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootLime = Back.addOrReplaceChild("FlagRootLime", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag17 = FlagRootLime.addOrReplaceChild("Flag17", CubeListBuilder.create().texOffs(220, 79).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag18 = Flag17.addOrReplaceChild("Flag18", CubeListBuilder.create().texOffs(238, 79).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootGreen = Back.addOrReplaceChild("FlagRootGreen", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag19 = FlagRootGreen.addOrReplaceChild("Flag19", CubeListBuilder.create().texOffs(220, 90).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag20 = Flag19.addOrReplaceChild("Flag20", CubeListBuilder.create().texOffs(238, 90).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootCyan = Back.addOrReplaceChild("FlagRootCyan", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag21 = FlagRootCyan.addOrReplaceChild("Flag21", CubeListBuilder.create().texOffs(220, 101).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag22 = Flag21.addOrReplaceChild("Flag22", CubeListBuilder.create().texOffs(238, 101).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootLightBlue = Back.addOrReplaceChild("FlagRootLightBlue", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag23 = FlagRootLightBlue.addOrReplaceChild("Flag23", CubeListBuilder.create().texOffs(220, 112).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag24 = Flag23.addOrReplaceChild("Flag24", CubeListBuilder.create().texOffs(238, 112).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootBlue = Back.addOrReplaceChild("FlagRootBlue", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag25 = FlagRootBlue.addOrReplaceChild("Flag25", CubeListBuilder.create().texOffs(220, 123).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag26 = Flag25.addOrReplaceChild("Flag26", CubeListBuilder.create().texOffs(238, 123).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootMagenta = Back.addOrReplaceChild("FlagRootMagenta", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag27 = FlagRootMagenta.addOrReplaceChild("Flag27", CubeListBuilder.create().texOffs(220, 134).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag28 = Flag27.addOrReplaceChild("Flag28", CubeListBuilder.create().texOffs(238, 134).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootPink = Back.addOrReplaceChild("FlagRootPink", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag29 = FlagRootPink.addOrReplaceChild("Flag29", CubeListBuilder.create().texOffs(220, 145).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag30 = Flag29.addOrReplaceChild("Flag30", CubeListBuilder.create().texOffs(238, 145).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

        PartDefinition FlagRootPurple = Back.addOrReplaceChild("FlagRootPurple", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 26.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Flag31 = FlagRootPurple.addOrReplaceChild("Flag31", CubeListBuilder.create().texOffs(220, 156).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Flag32 = Flag31.addOrReplaceChild("Flag32", CubeListBuilder.create().texOffs(238, 156).addBox(0.0F, -3.0F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

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

        PartDefinition bolts_front = Body.addOrReplaceChild("bolts_front", CubeListBuilder.create().texOffs(107, 171).addBox(14.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(107, 171).mirror().addBox(-14.0F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 3.0F, -9.0F));

        PartDefinition bolts_rear = Body.addOrReplaceChild("bolts_rear", CubeListBuilder.create().texOffs(107, 171).addBox(14.0F, -3.0F, 6.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(107, 171).mirror().addBox(-14.0F, -3.0F, 6.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 4.0F, 1.5F));

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

        PartDefinition combine = Root.addOrReplaceChild("combine", CubeListBuilder.create(), PartPose.offset(2.5F, -27.5F, -9.0F));

        PartDefinition cube_r27 = combine.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(234, 186).addBox(11.0F, -2.5F, -5.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).addBox(11.5F, -1.5F, -42.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, 4.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, -2.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).mirror().addBox(-17.5F, -1.5F, -42.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, 4.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, -2.5F, -42.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(234, 186).mirror().addBox(-18.0F, -2.5F, -5.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r28 = combine.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 264).addBox(-50.0F, -1.0F, 0.0F, 50.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.5F, 19.9F, -39.2F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r29 = combine.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(98, 204).addBox(23.0F, -1.5F, -1.5F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(98, 204).mirror().addBox(-29.0F, -1.5F, -1.5F, 2.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 22.5F, -46.5F, 0.2618F, 0.0F, 0.0F));

        PartDefinition roller = combine.addOrReplaceChild("roller", CubeListBuilder.create().texOffs(62, 122).addBox(26.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(62, 122).addBox(13.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(62, 122).mirror().addBox(-26.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(62, 122).mirror().addBox(-13.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(62, 122).mirror().addBox(0.0F, -6.0F, -6.0F, 0.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 22.5F, -46.5F));

        PartDefinition cube_r30 = roller.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.7053F, 0.0873F, 0.0F));

        PartDefinition cube_r31 = roller.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0071F, 0.0F, -0.0873F));

        PartDefinition cube_r32 = roller.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, -0.0436F, 0.0F));

        PartDefinition cube_r33 = roller.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(-1, 234).addBox(-26.5F, -6.0F, 0.5F, 53.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 240).addBox(-26.5F, -6.0F, 2.5F, 53.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1345F, 0.0F, 0.0873F));

        PartDefinition plough = Root.addOrReplaceChild("plough", CubeListBuilder.create().texOffs(93, 252).addBox(-40.5F, 19.5F, 34.5F, 76.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -27.5F, 9.0F));

        PartDefinition cube_r34 = plough.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(234, 186).addBox(11.0F, -2.5F, -2.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).addBox(11.5F, -1.5F, 5.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, 4.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(176, 184).addBox(11.0F, -2.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(130, 201).mirror().addBox(-17.5F, -1.5F, 5.5F, 2.0F, 6.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, 4.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(176, 184).mirror().addBox(-18.0F, -2.5F, 5.5F, 3.0F, 1.0F, 37.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(234, 186).mirror().addBox(-18.0F, -2.5F, -2.5F, 3.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r35 = plough.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(92, 278).addBox(-40.0F, -2.0F, -2.0F, 80.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(1, 286).addBox(-39.5F, 0.0F, 0.0F, 79.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 23.5F, 39.5F, -0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 512);
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

        FlagRootWhite.visible = entity.whiteFlag();
        FlagRootLightGray.visible = entity.lightGrayFlag();
        FlagRootGray.visible = entity.grayFlag();
        FlagRootBlack.visible = entity.blackFlag();
        FlagRootBrown.visible = entity.brownFlag();
        FlagRootRed.visible = entity.redFlag();
        FlagRootOrange.visible = entity.orangeFlag();
        FlagRootYellow.visible = entity.yellowFlag();
        FlagRootLime.visible = entity.limeFlag();
        FlagRootGreen.visible = entity.greenFlag();
        FlagRootCyan.visible = entity.cyanFlag();
        FlagRootLightBlue.visible = entity.lightBlueFlag();
        FlagRootBlue.visible = entity.blueFlag();
        FlagRootMagenta.visible = entity.magentaFlag();
        FlagRootPurple.visible = entity.purpleFlag();
        FlagRootPink.visible = entity.pinkFlag();

        combine.visible = entity.isHarvester();
        plough.visible = entity.isPlough();
        bolts_front.visible = entity.isHarvester();
        bolts_rear.visible = entity.isPlough();
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
