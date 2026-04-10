
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.entity.custom.AnoleEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class AnoleItem extends SpawnEggItem {
    /**
     * @param defaultType
     * @param backgroundColor
     * @param highlightColor
     * @param properties
     * @deprecated
     */
    public AnoleItem(EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor, Properties properties) {
        super(defaultType, backgroundColor, highlightColor, properties);
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new AnoleItemRenderer()));
    }
}
