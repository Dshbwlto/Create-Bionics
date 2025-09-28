package net.dshbwlto.createbionics.Util;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class BionicsTags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,name));
        }
    }

    public static class Items{
        public static final TagKey<Item> MOLD_ITEMS = createTag("mold_items");
        public static final TagKey<Item> BRASS_INGOT = createTag("brass_ingot");
        public static final TagKey<Item> WRENCH = createTag("wrench");
        public static final TagKey<Item> ANDESITE_ALLOY_SINGLE = createTag("andesite_alloy_single");
        public static final TagKey<Item> ANDESITE_ALLOY_MULTI = createTag("andesite_alloy_multi");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,name));
        }
    }
    public static class Fluids{
        public static final TagKey<Fluid> ANDESITE_ALLOY = createTag("andesite_alloy");

        private static TagKey<Fluid> createTag(String name) {
            return FluidTags.create(ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,name));
        }
    }
}
