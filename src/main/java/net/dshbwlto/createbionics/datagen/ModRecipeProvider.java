package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.I2_COAL_ENGINE.get())
                .pattern("ABA")
                .pattern("CEC")
                .pattern("DCD")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.DIRT)
                .define('C', Items.STONE)
                .define('D', Items.IRON_INGOT)
                .define('E', Items.COAL)
                .unlockedBy("has_coal", has(Items.COAL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.ORGAN_PISTON.get())
                .pattern("SS")
                .pattern("II")
                .pattern("II")
                .define('S', Items.OBSIDIAN)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_sheet", has(Items.OBSIDIAN)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.ANOLE_BODY.get())
                .pattern("ACA")
                .pattern("AEA")
                .pattern("CDC")
                .define('A', Items.COPPER_INGOT)
                .define('C', Items.STONE)
                .define('D', Items.IRON_INGOT)
                .define('E', BionicsItems.I2_COAL_ENGINE)
                .unlockedBy("has_engine", has(BionicsItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.ANOLE_HEAD.get())
                .pattern(" DA")
                .pattern("AED")
                .pattern("CA ")
                .define('A', Items.COPPER_INGOT)
                .define('C', Items.ANDESITE)
                .define('D', Items.FLINT)
                .define('E', Items.LIGHTNING_ROD)
                .unlockedBy("has_engine", has(BionicsItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.SHEET_MUSIC.get())
                .pattern("AP ")
                .pattern(" P ")
                .pattern(" PA")
                .define('A', BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                .define('P', Items.PAPER)
                .unlockedBy("has_paper", has(Items.PAPER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.ANOLE_LEG.get())
                .pattern(" A ")
                .pattern("  A")
                .pattern("BBC")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.ANDESITE)
                .define('C', Items.IRON_INGOT)
                .unlockedBy("has_engine", has(BionicsItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.ANOLE_TAIL.get())
                .pattern("  B")
                .pattern(" CA")
                .pattern("C  ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.ANDESITE)
                .define('C', Items.IRON_INGOT)
                .unlockedBy("has_engine", has(BionicsItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.SILENT_PISTON.get())
                .pattern(" Z ")
                .pattern(" A ")
                .define('Z', BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:zinc_ingot")))
                .define('A', BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:andesite_alloy")))
                .unlockedBy("has_zinc", has(BuiltInRegistries.ITEM.get(ResourceLocation.parse("create:zinc_ingot")))).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.ANOLE.get())
                .pattern(" CB")
                .pattern("CAC")
                .pattern("DC ")
                .define('A', BionicsItems.ANOLE_BODY)
                .define('B', BionicsItems.ANOLE_HEAD)
                .define('C', BionicsItems.ANOLE_LEG)
                .define('D', BionicsItems.ANOLE_TAIL)
                .unlockedBy("has_anole_body", has(BionicsItems.ANOLE_BODY)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.OXHAULER_ENGINE.get())
                .pattern("EAE")
                .pattern("EBE")
                .pattern("ECE")
                .define('A', Blocks.ANDESITE)
                .define('B', BionicsBlocks.OXHAULER_ENGINE)
                .define('C', Blocks.COPPER_BLOCK)
                .define('E', BionicsItems.I2_COAL_ENGINE)
                .unlockedBy("has_engine_block", has(BionicsBlocks.OXHAULER_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.OXHAULER_REAR.get())
                .pattern("GEG")
                .pattern("CBC")
                .pattern("LDL")
                .define('E', BionicsItems.OXHAULER_ENGINE)
                .define('G', Blocks.GOLD_BLOCK)
                .define('C', Blocks.CHEST)
                .define('B', BionicsBlocks.OXHAULER_REAR)
                .define('L', BionicsItems.OXHAULER_LEG)
                .define('D', Items.DIAMOND)
                .unlockedBy("has_rear", has(BionicsBlocks.OXHAULER_REAR)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.OXHAULER_MIDDLE.get())
                .pattern("GSG")
                .pattern("DFC")
                .pattern("AAC")
                .define('S', Blocks.RED_CARPET)
                .define('G', Blocks.GOLD_BLOCK)
                .define('C', Blocks.CHEST)
                .define('F', BionicsBlocks.OXHAULER_FURNACE)
                .define('D', BionicsBlocks.OXHAULER_GRATE)
                .define('A', Blocks.ANDESITE)
                .unlockedBy("has_furnace", has(BionicsBlocks.OXHAULER_FURNACE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.OXHAULER_FRONT.get())
                .pattern("NGT")
                .pattern("CFC")
                .pattern("LDL")
                .define('N', Blocks.FURNACE)
                .define('G', Blocks.GOLD_BLOCK)
                .define('T', Blocks.CRAFTING_TABLE)
                .define('C', Blocks.CHEST)
                .define('F', BionicsBlocks.OXHAULER_FRONT)
                .define('L', BionicsItems.OXHAULER_LEG)
                .define('D', Items.DIAMOND)
                .unlockedBy("has_front", has(BionicsBlocks.OXHAULER_FRONT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.OXHAULER_HEAD.get())
                .pattern("GCG")
                .pattern("RHR")
                .pattern("SPS")
                .define('G', Items.GOLD_INGOT)
                .define('C', Items.LIGHTNING_ROD)
                .define('R', Items.REDSTONE)
                .define('H', BionicsBlocks.OXHAULER_HEAD)
                .define('S', Items.STICK)
                .define('P', Blocks.CARVED_PUMPKIN)
                .unlockedBy("has_oxhauler_head", has(BionicsBlocks.OXHAULER_HEAD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.OXHAULER_LEG.get())
                .pattern("GDG")
                .pattern("AG ")
                .pattern(" GA")
                .define('G', Items.GOLD_INGOT)
                .define('D', Items.DIAMOND)
                .define('A', Blocks.ANDESITE)
                .unlockedBy("has_oxhauler_engine", has(BionicsItems.OXHAULER_ENGINE)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.NETHER_BRICK_CRUCIBLE.get())
                .pattern("A A")
                .pattern(" A ")
                .define('A', BionicsItems.NETHER_BRICK_CRUCIBLE)
                .unlockedBy("has_nether_brick", has(Items.NETHER_BRICK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsItems.WAX_INGOT.get())
                .pattern(" A ")
                .pattern("BBB")
                .define('A', Items.GREEN_DYE)
                .define('B', Items.HONEYCOMB)
                .unlockedBy("has_honeycomb", has(Items.HONEYCOMB)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BionicsBlocks.WAX_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', BionicsItems.WAX_INGOT)
                .unlockedBy("has_honeycomb", has(Items.HONEYCOMB)).save(recipeOutput);
    }
}
