package net.dshbwlto.createbionics.Util;

import net.dshbwlto.createbionics.CreateBionics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BionicsTags {
        public static final TagKey<Block> SEEKER_COAL_ACCEPTABLE = registerBlockTag("seeker_coal_acceptable");
        public static final TagKey<Block> SEEKER_IRON_ACCEPTABLE = registerBlockTag("seeker_iron_acceptable");
        public static final TagKey<Block> SEEKER_COPPER_ACCEPTABLE = registerBlockTag("seeker_copper_acceptable");
        public static final TagKey<Block> SEEKER_GOLD_ACCEPTABLE = registerBlockTag("seeker_gold_acceptable");
        public static final TagKey<Block> SEEKER_EMERALD_ACCEPTABLE = registerBlockTag("seeker_emerald_acceptable");
        public static final TagKey<Block> SEEKER_LAPIS_ACCEPTABLE = registerBlockTag("seeker_lapis_acceptable");
        public static final TagKey<Block> SEEKER_DIAMOND_ACCEPTABLE = registerBlockTag("seeker_diamond_acceptable");
        public static final TagKey<Block> SEEKER_QUARTZ_ACCEPTABLE = registerBlockTag("seeker_quartz_acceptable");
        public static final TagKey<Block> SEEKER_REDSTONE_ACCEPTABLE = registerBlockTag("seeker_redstone_acceptable");
        public static final TagKey<Block> SEEKER_ANCIENT_DEBRIS_ACCEPTABLE = registerBlockTag("seeker_ancient_debris_acceptable");
        public static final TagKey<Block> SEEKER_ZINC_ACCEPTABLE = registerBlockTag("seeker_zinc_acceptable");

        public static final TagKey<Item> SEEKER_ACCEPTABLE = registerItemTag("seeker_acceptable");

        public static final TagKey<Item> SEEKER_COAL = registerItemTag("seeker_coal");
        public static final TagKey<Item> SEEKER_IRON = registerItemTag("seeker_iron");
        public static final TagKey<Item> SEEKER_COPPER = registerItemTag("seeker_copper");
        public static final TagKey<Item> SEEKER_GOLD = registerItemTag("seeker_gold");
        public static final TagKey<Item> SEEKER_EMERALD = registerItemTag("seeker_emerald");
        public static final TagKey<Item> SEEKER_LAPIS = registerItemTag("seeker_lapis");
        public static final TagKey<Item> SEEKER_DIAMOND = registerItemTag("seeker_diamond");
        public static final TagKey<Item> SEEKER_QUARTZ = registerItemTag("seeker_quartz");
        public static final TagKey<Item> SEEKER_REDSTONE = registerItemTag("seeker_redstone");
        public static final TagKey<Item> SEEKER_ANCIENT_DEBRIS = registerItemTag("seeker_ancient_debris");
        public static final TagKey<Item> SEEKER_ZINC = registerItemTag("seeker_zinc");

    private static TagKey<Item> registerItemTag(String name) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, name));
    }

    private static TagKey<Block> registerBlockTag(String name) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, name));
    }

}
