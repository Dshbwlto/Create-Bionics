package net.dshbwlto.createbionics.entity.client;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation ANOLE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "anole"), "main");


    public static final ModelLayerLocation THRUSTER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "thruster"), "main");

}
