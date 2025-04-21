package net.dshbwlto.createrobotics.entity.client;

import net.dshbwlto.createrobotics.CreateRobotics;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation ANOLE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateRobotics.MOD_ID, "anole"), "main");


    public static final ModelLayerLocation THRUSTER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(CreateRobotics.MOD_ID, "thruster"), "main");

}
