package net.dshbwlto.createbionics.entity.client;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation ANOLE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "anole"), "main");
    public static final ModelLayerLocation ANOLE_MARKINGS = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "anole"), "markings");


    public static final ModelLayerLocation OXHAULER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "oxhauler"), "main");
    public static final ModelLayerLocation OXHAULER_GLOW = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "oxhauler"), "glow");
    public static final ModelLayerLocation OXHAULER_COLOR = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "oxhauler"), "color");

    public static final ModelLayerLocation REPLETE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "replete"), "main");

    public static final ModelLayerLocation STALKER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "stalker"), "main");

}
