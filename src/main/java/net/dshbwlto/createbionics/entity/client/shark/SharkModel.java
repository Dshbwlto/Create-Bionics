package net.dshbwlto.createbionics.entity.client.shark;

import net.createmod.catnip.animation.AnimationTickHolder;
import net.dshbwlto.createbionics.entity.custom.SharkEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class SharkModel<T extends SharkEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart root_util;
    private final ModelPart head;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tail5;
    private final ModelPart tail6;

    public SharkModel(ModelPart root) {
        this.root = root.getChild("root");
        this.root_util = root().getChild("root_util");
        this.head = root().getChild("root_util").getChild("head");
        this.tail1 = root().getChild("root_util").getChild("tail1");
        this.tail2 = root().getChild("root_util").getChild("tail1").getChild("tail2");
        this.tail3 = root().getChild("root_util").getChild("tail1").getChild("tail2").getChild("tail3");
        this.tail4 = root().getChild("root_util").getChild("tail1").getChild("tail2").getChild("tail3").getChild("tail4");
        this.tail5 = root().getChild("root_util").getChild("tail1").getChild("tail2").getChild("tail3").getChild("tail4").getChild("tail5");
        this.tail6 = root().getChild("root_util").getChild("tail1").getChild("tail2").getChild("tail3").getChild("tail4").getChild("tail5").getChild("tail6");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition root_util = root.addOrReplaceChild("root_util", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -33.0F, -48.0F, 54.0F, 66.0F, 96.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = root_util.addOrReplaceChild("head", CubeListBuilder.create().texOffs(282, 162).addBox(-21.0F, -18.0F, -68.0F, 42.0F, 52.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -59.0F));

        PartDefinition tail1 = root_util.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(282, 278).addBox(-24.0F, -30.0F, 15.0F, 48.0F, 59.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(444, 0).addBox(24.0F, -7.0F, 15.0F, 8.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(348, 453).addBox(-32.0F, -7.0F, 15.0F, 8.0F, 13.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 63.0F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(300, 0).addBox(-21.0F, -27.0F, 15.0F, 42.0F, 54.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(438, 278).addBox(21.0F, -7.0F, 15.0F, 14.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(438, 321).addBox(-35.0F, -7.0F, 15.0F, 14.0F, 13.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 60.0F));

        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(0, 438).addBox(18.0F, -7.0F, 17.0F, 20.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(100, 438).addBox(-38.0F, -7.0F, 17.0F, 20.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(300, 84).addBox(-18.0F, -25.0F, 17.0F, 36.0F, 48.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 59.0F));

        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(0, 309).addBox(-15.0F, -24.0F, 15.0F, 30.0F, 42.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(124, 395).addBox(15.0F, -7.0F, 15.0F, 26.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(364, 410).addBox(-41.0F, -7.0F, 15.0F, 26.0F, 13.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 62.0F));

        PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(256, 367).addBox(-12.0F, -21.0F, 15.0F, 24.0F, 36.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(0, 395).addBox(12.0F, -7.0F, 15.0F, 32.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(364, 367).addBox(-44.0F, -7.0F, 15.0F, 32.0F, 13.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 60.0F));

        PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(0, 162).addBox(-9.0F, -14.0F, 15.0F, 18.0F, 24.0F, 123.0F, new CubeDeformation(0.0F))
                .texOffs(120, 352).addBox(9.0F, -6.0F, 15.0F, 38.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(120, 309).addBox(-47.0F, -6.0F, 15.0F, 38.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(432, 84).addBox(9.0F, -6.0F, 75.0F, 26.0F, 13.0F, 30.0F, new CubeDeformation(0.0F))
                .texOffs(236, 433).addBox(-35.0F, -6.0F, 75.0F, 26.0F, 13.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 61.0F));

        return LayerDefinition.create(meshdefinition, 1024, 1024);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(SharkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        //this.root.yRot = -entity.getPreciseBodyRotation(AnimationTickHolder.getPartialTicks()) * ((float)Math.PI / 180F);

        int y = !entity.turning_y ? 0 : entity.yDir0 == 1 ? -1 : entity.yDir0 == -1 ? 1 : 0;
        if (y == 0) {
            entity.tail1Y = Mth.approach(entity.tail1Y, 0, 0.6f);
        } else {
            if (y == 1 && entity.tail1Y < 20) {
                entity.tail1Y += 0.5f;
            } else if (y == -1 && entity.tail1Y > -20) {
                entity.tail1Y -= 0.5f;
            }
        }

        int x = !entity.turning_x ? 0 : entity.xDir0 == 1 ? -1 : entity.xDir0 == -1 ? 1 : 0;
        if (x == 0) {
            entity.tail1X = Mth.approach(entity.tail1X, 0, 0.6f);
        } else {
            if (x == 1 && entity.tail1X < 20) {
                entity.tail1X += 0.1f;
            } else if (x == -1 && entity.tail1X > -10) {
                entity.tail1X -= 0.1f;
            }
        }

        entity.tail2Y = Mth.approach(entity.tail2Y, entity.tail1Y, 0.5f);
        entity.tail3Y = Mth.approach(entity.tail3Y, entity.tail2Y, 0.4f);
        entity.tail4Y = Mth.approach(entity.tail4Y, entity.tail3Y, 0.3f);
        entity.tail5Y = Mth.approach(entity.tail5Y, entity.tail4Y, 0.2f);

        entity.tail2X = Mth.approach(entity.tail2X, entity.tail1X, 0.4f);
        entity.tail3X = Mth.approach(entity.tail3X, entity.tail2X, 0.3f);
        entity.tail4X = Mth.approach(entity.tail4X, entity.tail3X, 0.2f);
        entity.tail5X = Mth.approach(entity.tail5X, entity.tail4X, 0.1f);

        this.tail1.yRot = ((entity.tail2Y) + tailWave(0, 7.5f, 0.1f)) * ((float)Math.PI / 180F);
        this.tail2.yRot = ((entity.tail2Y) + tailWave(-0.7f, 7.5f, 0.1f)) * ((float)Math.PI / 180F);
        this.tail3.yRot = ((entity.tail3Y) + tailWave(-1.4f, 7.5f, 0.1f)) * ((float)Math.PI / 180F);
        this.tail4.yRot = ((entity.tail4Y) + tailWave(-2.1f, 7.5f, 0.1f)) * ((float)Math.PI / 180F);
        this.tail5.yRot = ((entity.tail5Y) + tailWave(-2.8f, 7.5f, 0.1f)) * ((float)Math.PI / 180F);

        this.tail1.xRot = entity.tail2X * ((float)Math.PI / 180F);
        this.tail2.xRot = entity.tail2X * ((float)Math.PI / 180F);
        this.tail3.xRot = entity.tail3X * ((float)Math.PI / 180F);
        this.tail4.xRot = entity.tail4X * ((float)Math.PI / 180F);
        this.tail5.xRot = entity.tail5X * ((float)Math.PI / 180F);
    }

    public float tailWave(float offset, float multiplier, float speed) {
        float i = AnimationTickHolder.getTicks() + AnimationTickHolder.getPartialTicks();
        return Mth.sin((i * speed) + offset) * multiplier;
    }
}
