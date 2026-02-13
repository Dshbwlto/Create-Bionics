package net.dshbwlto.createbionics.screen.custom;

import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.screen.BionicsMenuTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class OxhaulerMenu extends AbstractContainerMenu {

    private Container oxhaulerContainer;
    public OxhaulerEntity oxhauler;

    // With Help from https://github.com/Mrbysco/ChocoCraft4/tree/arch/1.21
    // Under MIT LICENSE

    public static OxhaulerMenu create(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        UUID uuid = registryFriendlyByteBuf.readUUID();
        List<OxhaulerEntity> turtles = inventory.player.level().getEntitiesOfClass(OxhaulerEntity.class,
                inventory.player.getBoundingBox().inflate(16), test -> test.getUUID().equals(uuid));
        OxhaulerEntity oxhaulerEntity = turtles.isEmpty() ? null : turtles.getFirst();
        return new OxhaulerMenu(i, inventory, new SimpleContainer(28), oxhaulerEntity);
    }
    public OxhaulerMenu(int containerId, Inventory inventory, Container horseContainer, final OxhaulerEntity oxhaulerEntity) {
        super(BionicsMenuTypes.OXHAULER_MENU.get(), containerId);
        this.oxhaulerContainer = horseContainer;
        this.oxhauler = oxhaulerEntity;
        horseContainer.startOpen(inventory.player);

        //Inventory//
        for (int i1 = 0; i1 < 3; i1++) {
            for (int k1 = 0; k1 < 9; k1++) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, -16 + k1 * 18, 133 + i1 * 18 + -18));
            }
        }
        for (int j1 = 0; j1 < 9; j1++) {
            this.addSlot(new Slot(inventory, j1, -16 + j1 * 18, 173));
        }

        //Container//
        for(int j = 0; j < 3; ++j) {
            for(int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, k + j * 9, -16 + k * 18, 57 + j * 18));
            }
        }


    }

    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean stillValid(Player player) {
        return !this.oxhauler.hasInventoryChanged(this.oxhaulerContainer)
                && this.oxhaulerContainer.stillValid(player)
                && this.oxhauler.isAlive()
                && player.canInteractWithEntity(this.oxhauler, 4.0);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s).
     */

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.oxhaulerContainer.stopOpen(player);
    }
}