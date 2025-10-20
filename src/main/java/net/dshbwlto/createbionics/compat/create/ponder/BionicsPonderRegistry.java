/*
package net.dshbwlto.createbionics.compat.create.ponder;

import net.createmod.ponder.api.registration.MultiSceneBuilder;
import net.createmod.ponder.api.registration.StoryBoardEntry;
import net.createmod.ponder.api.scene.PonderStoryBoard;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.block.BionicsBlocks;
import net.dshbwlto.createbionics.compat.create.ponder.scenes.WaxBlockScene;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import java.util.function.Function;

//Ponders implemented with help from the developer of Starlance. Please support their work at https://modrinth.com/mod/starlance//

public class BionicsPonderRegistry {
    private static final PonderSceneRegistrationHelper HELPER = new PonderSceneRegistrationHelper() {
        @Override
        public StoryBoardEntry addStoryBoard(Object component, ResourceLocation schematicLocation, PonderStoryBoard storyBoard, ResourceLocation... tags) {
            return null;
        }

        @Override
        public StoryBoardEntry addStoryBoard(Object component, String schematicPath, PonderStoryBoard storyBoard, ResourceLocation... tags) {
            return null;
        }

        @Override
        public MultiSceneBuilder forComponents(Object[] components) {
            return null;
        }

        @Override
        public MultiSceneBuilder forComponents(Iterable components) {
            return null;
        }

        @Override
        public ResourceLocation asLocation(String path) {
            return null;
        }

        @Override
        public PonderSceneRegistrationHelper<ItemLike> withKeyFunction(Function keyGen) {
            return null;
        }
    };

    public static void register() {
        HELPER.forComponents(
                BionicsBlocks.WAX_BLOCK
        ).addStoryBoard("drag_inducer", WaxBlockScene::inducer);
    }
}
*/

