package net.dshbwlto.createbionics.datagen;

import net.dshbwlto.createbionics.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.I2_COAL_ENGINE.get())
                .pattern("ABA")
                .pattern("CEC")
                .pattern("DCD")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.DIRT)
                .define('C', Items.STONE)
                .define('D', Items.IRON_INGOT)
                .define('E', Items.COAL)
                .unlockedBy("has_coal", has(Items.COAL)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANOLE_BODY.get())
                .pattern("ACA")
                .pattern("AEA")
                .pattern("CDC")
                .define('A', Items.COPPER_INGOT)
                .define('C', Items.STONE)
                .define('D', Items.IRON_INGOT)
                .define('E', ModItems.I2_COAL_ENGINE)
                .unlockedBy("has_engine", has(ModItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANOLE_HEAD.get())
                .pattern(" DA")
                .pattern("AED")
                .pattern("CA ")
                .define('A', Items.COPPER_INGOT)
                .define('C', Items.ANDESITE)
                .define('D', Items.FLINT)
                .define('E', Items.LIGHTNING_ROD)
                .unlockedBy("has_engine", has(ModItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANOLE_LEG.get())
                .pattern(" A ")
                .pattern("  A")
                .pattern("BBC")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.ANDESITE)
                .define('C', Items.IRON_INGOT)
                .unlockedBy("has_engine", has(ModItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANOLE_TAIL.get())
                .pattern("  B")
                .pattern(" CA")
                .pattern("C  ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.ANDESITE)
                .define('C', Items.IRON_INGOT)
                .unlockedBy("has_engine", has(ModItems.I2_COAL_ENGINE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ANOLE.get())
                .pattern(" CB")
                .pattern("CAC")
                .pattern("DC ")
                .define('A', ModItems.ANOLE_BODY)
                .define('B', ModItems.ANOLE_HEAD)
                .define('C', ModItems.ANOLE_LEG)
                .define('D', ModItems.ANOLE_TAIL)
                .unlockedBy("has_anole_body", has(ModItems.ANOLE_BODY)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COMMAND_WHISTLE.get())
                .pattern("AB ")
                .define('A', ModItems.ANOLE_LEG)
                .define('B', ModItems.ANOLE_TAIL)
                .unlockedBy("has_anole", has(ModItems.ANOLE)).save(recipeOutput);


    }
}
