package net.dshbwlto.createrobotics.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dshbwlto.createrobotics.entity.custom.AnoleEntity;
import net.dshbwlto.createrobotics.entity.custom.ThrusterEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import javax.swing.text.html.parser.Entity;

public class ThrusterModel<T extends ThrusterEntity> extends HierarchicalModel<T> {
    private final ModelPart Scale;

    public ThrusterModel(ModelPart root) {
        this.Scale = root.getChild("Scale");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Scale = partdefinition.addOrReplaceChild("Scale", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition Plume = Scale.addOrReplaceChild("Plume", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition Fin5 = Plume.addOrReplaceChild("Fin5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r1 = Fin5.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r2 = Fin5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r3 = Fin5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r4 = Fin5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r5 = Fin5.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r6 = Fin5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r7 = Fin5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r8 = Fin5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r9 = Fin5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r10 = Fin5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r11 = Fin5.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r12 = Fin5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r13 = Fin5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r14 = Fin5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r15 = Fin5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r16 = Fin5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r17 = Fin5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone5 = Fin5.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r18 = bone5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r19 = bone5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r20 = bone5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r21 = bone5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r22 = bone5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r23 = bone5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r24 = bone5.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r25 = bone5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r26 = bone5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin = Plume.addOrReplaceChild("Fin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r27 = Fin.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r28 = Fin.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r29 = Fin.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r30 = Fin.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r31 = Fin.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r32 = Fin.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r33 = Fin.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r34 = Fin.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r35 = Fin.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r36 = Fin.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r37 = Fin.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r38 = Fin.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r39 = Fin.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r40 = Fin.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r41 = Fin.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r42 = Fin.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r43 = Fin.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone = Fin.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r44 = bone.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r45 = bone.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r46 = bone.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r47 = bone.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r48 = bone.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r49 = bone.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r50 = bone.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r51 = bone.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r52 = bone.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin8 = Plume.addOrReplaceChild("Fin8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r53 = Fin8.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r54 = Fin8.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r55 = Fin8.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r56 = Fin8.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r57 = Fin8.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r58 = Fin8.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r59 = Fin8.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r60 = Fin8.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r61 = Fin8.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r62 = Fin8.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r63 = Fin8.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r64 = Fin8.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r65 = Fin8.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r66 = Fin8.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r67 = Fin8.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r68 = Fin8.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r69 = Fin8.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone8 = Fin8.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r70 = bone8.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r71 = bone8.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r72 = bone8.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r73 = bone8.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r74 = bone8.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r75 = bone8.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r76 = bone8.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r77 = bone8.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r78 = bone8.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin4 = Plume.addOrReplaceChild("Fin4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r79 = Fin4.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r80 = Fin4.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r81 = Fin4.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r82 = Fin4.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r83 = Fin4.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r84 = Fin4.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r85 = Fin4.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r86 = Fin4.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r87 = Fin4.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r88 = Fin4.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r89 = Fin4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r90 = Fin4.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r91 = Fin4.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r92 = Fin4.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r93 = Fin4.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r94 = Fin4.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r95 = Fin4.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone4 = Fin4.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r96 = bone4.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r97 = bone4.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r98 = bone4.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r99 = bone4.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r100 = bone4.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r101 = bone4.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r102 = bone4.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r103 = bone4.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r104 = bone4.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin6 = Plume.addOrReplaceChild("Fin6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r105 = Fin6.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r106 = Fin6.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r107 = Fin6.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r108 = Fin6.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r109 = Fin6.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r110 = Fin6.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r111 = Fin6.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r112 = Fin6.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r113 = Fin6.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r114 = Fin6.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r115 = Fin6.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r116 = Fin6.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r117 = Fin6.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r118 = Fin6.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r119 = Fin6.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r120 = Fin6.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r121 = Fin6.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone6 = Fin6.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r122 = bone6.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r123 = bone6.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r124 = bone6.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r125 = bone6.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r126 = bone6.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r127 = bone6.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r128 = bone6.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r129 = bone6.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r130 = bone6.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin2 = Plume.addOrReplaceChild("Fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r131 = Fin2.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r132 = Fin2.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r133 = Fin2.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r134 = Fin2.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r135 = Fin2.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r136 = Fin2.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r137 = Fin2.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r138 = Fin2.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r139 = Fin2.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r140 = Fin2.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r141 = Fin2.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r142 = Fin2.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r143 = Fin2.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r144 = Fin2.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r145 = Fin2.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r146 = Fin2.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r147 = Fin2.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone2 = Fin2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r148 = bone2.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r149 = bone2.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r150 = bone2.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r151 = bone2.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r152 = bone2.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r153 = bone2.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r154 = bone2.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r155 = bone2.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r156 = bone2.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin7 = Plume.addOrReplaceChild("Fin7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

        PartDefinition cube_r157 = Fin7.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r158 = Fin7.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r159 = Fin7.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r160 = Fin7.addOrReplaceChild("cube_r160", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r161 = Fin7.addOrReplaceChild("cube_r161", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r162 = Fin7.addOrReplaceChild("cube_r162", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r163 = Fin7.addOrReplaceChild("cube_r163", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r164 = Fin7.addOrReplaceChild("cube_r164", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r165 = Fin7.addOrReplaceChild("cube_r165", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r166 = Fin7.addOrReplaceChild("cube_r166", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r167 = Fin7.addOrReplaceChild("cube_r167", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r168 = Fin7.addOrReplaceChild("cube_r168", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r169 = Fin7.addOrReplaceChild("cube_r169", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r170 = Fin7.addOrReplaceChild("cube_r170", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r171 = Fin7.addOrReplaceChild("cube_r171", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r172 = Fin7.addOrReplaceChild("cube_r172", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r173 = Fin7.addOrReplaceChild("cube_r173", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone7 = Fin7.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r174 = bone7.addOrReplaceChild("cube_r174", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r175 = bone7.addOrReplaceChild("cube_r175", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r176 = bone7.addOrReplaceChild("cube_r176", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r177 = bone7.addOrReplaceChild("cube_r177", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r178 = bone7.addOrReplaceChild("cube_r178", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r179 = bone7.addOrReplaceChild("cube_r179", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r180 = bone7.addOrReplaceChild("cube_r180", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r181 = bone7.addOrReplaceChild("cube_r181", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r182 = bone7.addOrReplaceChild("cube_r182", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition Fin3 = Plume.addOrReplaceChild("Fin3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

        PartDefinition cube_r183 = Fin3.addOrReplaceChild("cube_r183", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r184 = Fin3.addOrReplaceChild("cube_r184", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -59.0F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r185 = Fin3.addOrReplaceChild("cube_r185", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r186 = Fin3.addOrReplaceChild("cube_r186", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -43.25F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r187 = Fin3.addOrReplaceChild("cube_r187", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r188 = Fin3.addOrReplaceChild("cube_r188", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -27.5F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r189 = Fin3.addOrReplaceChild("cube_r189", CubeListBuilder.create().texOffs(68, 56).addBox(0.0F, 0.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, 0.3578F));

        PartDefinition cube_r190 = Fin3.addOrReplaceChild("cube_r190", CubeListBuilder.create().texOffs(68, 50).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -11.75F, 0.0F, 0.0F, 0.0F, -0.3578F));

        PartDefinition cube_r191 = Fin3.addOrReplaceChild("cube_r191", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, -20.0F, -9.0F, 0.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -66.85F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r192 = Fin3.addOrReplaceChild("cube_r192", CubeListBuilder.create().texOffs(18, 62).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r193 = Fin3.addOrReplaceChild("cube_r193", CubeListBuilder.create().texOffs(18, 70).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -51.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r194 = Fin3.addOrReplaceChild("cube_r194", CubeListBuilder.create().texOffs(18, 86).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.35F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r195 = Fin3.addOrReplaceChild("cube_r195", CubeListBuilder.create().texOffs(18, 78).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -35.4F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r196 = Fin3.addOrReplaceChild("cube_r196", CubeListBuilder.create().texOffs(18, 94).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.65F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r197 = Fin3.addOrReplaceChild("cube_r197", CubeListBuilder.create().texOffs(18, 102).addBox(0.0F, 0.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -19.6F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r198 = Fin3.addOrReplaceChild("cube_r198", CubeListBuilder.create().texOffs(18, 110).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r199 = Fin3.addOrReplaceChild("cube_r199", CubeListBuilder.create().texOffs(18, 118).addBox(0.0F, -4.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition bone3 = Fin3.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(2.0F, -4.1F, 0.0F));

        PartDefinition cube_r200 = bone3.addOrReplaceChild("cube_r200", CubeListBuilder.create().texOffs(36, 28).addBox(0.0F, -14.0F, -6.0F, 0.0F, 20.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -62.75F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r201 = bone3.addOrReplaceChild("cube_r201", CubeListBuilder.create().texOffs(45, 96).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r202 = bone3.addOrReplaceChild("cube_r202", CubeListBuilder.create().texOffs(45, 90).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r203 = bone3.addOrReplaceChild("cube_r203", CubeListBuilder.create().texOffs(45, 84).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r204 = bone3.addOrReplaceChild("cube_r204", CubeListBuilder.create().texOffs(45, 78).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.55F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r205 = bone3.addOrReplaceChild("cube_r205", CubeListBuilder.create().texOffs(45, 72).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r206 = bone3.addOrReplaceChild("cube_r206", CubeListBuilder.create().texOffs(45, 66).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.05F, 0.0F, 0.0F, 0.0F, -0.1745F));

        PartDefinition cube_r207 = bone3.addOrReplaceChild("cube_r207", CubeListBuilder.create().texOffs(45, 60).addBox(0.0F, 0.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition cube_r208 = bone3.addOrReplaceChild("cube_r208", CubeListBuilder.create().texOffs(45, 54).addBox(0.0F, -6.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -46.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(ThrusterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleAnimationState, ThrusterAnimations.Loop, ageInTicks, 1f);

        this.animate(entity.sitDownAnimationState, ThrusterAnimations.Off, ageInTicks, 1.0F);
        this.animate(entity.sitPoseAnimationState, ThrusterAnimations.Loop, ageInTicks, 1.0F);
        this.animate(entity.sitUpAnimationState, ThrusterAnimations.On, ageInTicks, 1.0F);

    }
    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Scale.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Scale;
    }
}
