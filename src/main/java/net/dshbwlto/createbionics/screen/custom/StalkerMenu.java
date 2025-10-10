package net.dshbwlto.createbionics.screen.custom;

import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.dshbwlto.createbionics.screen.BionicsMenuTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.UUID;

public class StalkerMenu extends AbstractContainerMenu {
    private Container stalkerContainer;
    public StalkerEntity stalker;
    private static final int SLOTS_PER_ROW = 9;

    static int getContainerSize() {
        return 50;
    }

    // With Help from https://github.com/Mrbysco/ChocoCraft4/tree/arch/1.21
    // Under MIT LICENSE
    public static StalkerMenu create(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        UUID uuid = registryFriendlyByteBuf.readUUID();
        List<StalkerEntity> robots = inventory.player.level().getEntitiesOfClass(StalkerEntity.class,
                inventory.player.getBoundingBox().inflate(16), test -> test.getUUID().equals(uuid));
        StalkerEntity stalkerEntity = robots.isEmpty() ? null : robots.getFirst();
        return new StalkerMenu(i, inventory, new SimpleContainer(29), stalkerEntity, 4, inventory.player);
    }

    protected static void checkContainerSize(Container container, int minSize) {
        int i = getContainerSize();
        if (i < minSize) {
            throw new IllegalArgumentException("Container size " + i + " is smaller than expected " + minSize);
        }
    }


    public StalkerMenu(int containerId, Inventory inventory, Container container, final StalkerEntity stalkerEntity, int rows, Player player) {
        super(BionicsMenuTypes.STALKER_MENU.get(), containerId);
        this.stalkerContainer = container;
        this.stalker = stalkerEntity;
        container.startOpen(inventory.player);
        checkContainerSize(container, 9);

        //mob inventory//
        for (int h = 0; h < 3; h++) {
            for (int w = 0; w < 9; w++) {
                this.addSlot(new Slot(container, w + h * 9, 7 + w * 18, 55 + h * 18));
            }
        }

        //player inventory//
        for (int i1 = 0; i1 < 3; i1++) {
            for (int k1 = 0; k1 < 9; k1++) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 7 + k1 * 18, 131 + i1 * 18 + -18));
            }
        }

        //hotbar//
        for (int j1 = 0; j1 < 9; j1++) {
            this.addSlot(new Slot(inventory, j1, 7 + j1 * 18, 171));
        }
    }

    /**
     * Determines whether supplied player can use this container
     */
    @Override
    public boolean stillValid(Player player) {
        return !this.stalker.hasInventoryChanged(this.stalkerContainer)
                && this.stalkerContainer.stillValid(player)
                && this.stalker.isAlive()
                && player.canInteractWithEntity(this.stalker, 4.0);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s).
     */
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int i = this.stalkerContainer.getContainerSize() + 1;
            if (index < i) {
                if (!this.moveItemStackTo(itemstack1, i, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(1).mayPlace(itemstack1) && !this.getSlot(1).hasItem()) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(0).mayPlace(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (i <= 1 || !this.moveItemStackTo(itemstack1, 2, i, false)) {
                int j = i + 27;
                int k = j + 9;
                if (index >= j && index < k) {
                    if (!this.moveItemStackTo(itemstack1, i, j, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= i && index < j) {
                    if (!this.moveItemStackTo(itemstack1, j, k, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (!this.moveItemStackTo(itemstack1, j, j, false)) {
                    return ItemStack.EMPTY;
                }

                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed(Player player) {
        super.removed(player);
        this.stalkerContainer.stopOpen(player);
    }
}
