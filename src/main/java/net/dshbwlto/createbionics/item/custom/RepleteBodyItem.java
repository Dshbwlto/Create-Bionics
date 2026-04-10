
package net.dshbwlto.createbionics.item.custom;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RepleteBodyItem extends SpawnEggItem {
    /**
     * @param defaultType
     * @param backgroundColor
     * @param highlightColor
     * @param properties
     * @deprecated
     */
    public RepleteBodyItem(EntityType<? extends Mob> defaultType, int backgroundColor, int highlightColor, Properties properties) {
        super(defaultType, backgroundColor, highlightColor, properties);
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new RepleteBodyItemRenderer()));
    }
}
