package net.dshbwlto.createbionics.entity.client.golem;


import net.dshbwlto.createbionics.entity.api.GolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class GolemModel<T extends Entity> extends HierarchicalModel<GolemEntity> {
    private final ModelPart root;

    public GolemModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition golem = partdefinition.addOrReplaceChild("golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = golem.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -46.0F, -5.0F, 26.0F, 46.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(72, 0).addBox(-6.0F, -54.0F, -6.0F, 12.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition larm = body.addOrReplaceChild("larm", CubeListBuilder.create().texOffs(36, 56).addBox(0.0F, 0.0F, -3.0F, 12.0F, 35.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(13.0F, -40.0F, 0.0F));

        PartDefinition rarm = body.addOrReplaceChild("rarm", CubeListBuilder.create().texOffs(0, 56).addBox(-12.0F, 0.0F, -3.0F, 12.0F, 35.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -40.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(GolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}