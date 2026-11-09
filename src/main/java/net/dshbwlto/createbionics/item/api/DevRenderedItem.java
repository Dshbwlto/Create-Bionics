package net.dshbwlto.createbionics.item.api;

import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.dshbwlto.createbionics.item.client.AnoleItemRenderer;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class DevRenderedItem extends Item {
    public DevRenderedItem(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new DevRenderedItemRenderer()));
    }
}
