//package net.dshbwlto.createrobotics.entity.client.anole;

//public class AnoleMarkingLayer extends RenderLayer<AnoleEntity, AnoleModel<AnoleEntity>> {
    //private static final Map LOCATION_BY_MARKINGS = (Map) Util.make(Maps.newEnumMap(AnoleMarkings.class), (context) -> {
        //context.put(AnoleMarkings.NONE, (Object) null);
        //context.put(AnoleMarkings.REDSTONE, ResourceLocation.withDefaultNamespace("textures/entity/anole/anole_redstone"));
        //context.put(AnoleMarkings.GOLD, ResourceLocation.withDefaultNamespace("textures/entity/anole/anole_gold"));
        //context.put(AnoleMarkings.DIAMOND, ResourceLocation.withDefaultNamespace("textures/entity/anole/anole_diamond"));

    //});

    //public AnoleMarkingLayer(RenderLayerParent<AnoleEntity, AnoleModel<AnoleEntity>> renderer) {
        //super(renderer);
    //}

    //public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AnoleEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        //ResourceLocation resourcelocation = (ResourceLocation)LOCATION_BY_MARKINGS.get(livingEntity.getMarkings());
        //if (resourcelocation != null && !livingEntity.isInvisible()) {
            //VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(resourcelocation));
            //((AnoleModel)this.getParentModel()).renderToBuffer(poseStack, vertexconsumer, packedLight, LivingEntityRenderer.getOverlayCoords(livingEntity, 0.0F));
        //}

    //}
//}
