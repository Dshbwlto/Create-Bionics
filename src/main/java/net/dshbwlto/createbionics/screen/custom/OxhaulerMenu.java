
package net.dshbwlto.createbionics.screen.custom;

import com.simibubi.create.AllSoundEvents;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.dshbwlto.createbionics.item.BionicsItems;
import net.dshbwlto.createbionics.screen.BionicsMenuTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OxhaulerMenu extends RecipeBookMenu {

    private Container oxhaulerContainer;
    public OxhaulerEntity oxhauler;
    private final CraftingContainer craftSlots;
    private final ResultContainer resultSlots;
    private boolean placingRecipe;
    private final Player player;
    private final ContainerLevelAccess access;


    // With Help from https://github.com/Mrbysco/ChocoCraft4/tree/arch/1.21
    // Under MIT LICENSE

    public static OxhaulerMenu create(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        UUID uuid = registryFriendlyByteBuf.readUUID();
        List<OxhaulerEntity> turtles = inventory.player.level().getEntitiesOfClass(OxhaulerEntity.class,
                inventory.player.getBoundingBox().inflate(16), test -> test.getUUID().equals(uuid));
        OxhaulerEntity oxhaulerEntity = turtles.isEmpty() ? null : turtles.getFirst();
        return new OxhaulerMenu(i, inventory, new SimpleContainer(200), oxhaulerEntity);
    }

    public OxhaulerMenu(int containerId, Inventory inventory, Container horseContainer, final OxhaulerEntity oxhaulerEntity) {
        super(BionicsMenuTypes.OXHAULER_MENU.get(), containerId);
        this.oxhaulerContainer = horseContainer;
        this.craftSlots = new TransientCraftingContainer(this, 3, 3);
        this.resultSlots = new ResultContainer();
        this.oxhauler = oxhaulerEntity;
        this.player = inventory.player;
        this.access = ContainerLevelAccess.create(player.level(), player.getOnPos());
        horseContainer.startOpen(inventory.player);

        //Inventory//
        for (int i1 = 0; i1 < 3; i1++) {
            for (int k1 = 0; k1 < 9; k1++) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, -16 + k1 * 18, 133 + i1 * 18 - 18));
            }
        }
        for (int j1 = 0; j1 < 9; j1++) {
            this.addSlot(new Slot(inventory, j1, -16 + j1 * 18, 173));
        }

        //Container//
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, (k + j * 9) + 36, -16 + k * 18, 57 + j * 18) {
                    @Override
                    public boolean isActive() {
                        return oxhauler.pageCount == 1;
                    }
                });
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, (k + j * 9) + 63, -16 + k * 18, 57 + j * 18) {
                    @Override
                    public boolean isActive() {
                        return oxhauler.pageCount == 2;
                    }
                });
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, (k + j * 9) + 90, -16 + k * 18, 57 + j * 18) {
                    @Override
                    public boolean isActive() {
                        return oxhauler.pageCount == 3;
                    }
                });
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, (k + j * 9) + 117, -16 + k * 18, 57 + j * 18) {
                    @Override
                    public boolean isActive() {
                        return oxhauler.pageCount == 4;
                    }
                });
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, (k + j * 9) + 144, -16 + k * 18, 57 + j * 18) {
                    @Override
                    public boolean isActive() {
                        return oxhauler.pageCount == 5;
                    }
                });
            }
        }
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(horseContainer, (k + j * 9) + 171, -16 + k * 18, 57 + j * 18) {
                    @Override
                    public boolean isActive() {
                        return oxhauler.pageCount == 6;
                    }
                });
            }
        }

        //Crafting Grid//
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.addSlot(new Slot(this.craftSlots, j + i * 3, 42 + j * 18, i * 18));
            }
        }
        this.addSlot(new ResultSlot(inventory.player, this.craftSlots, this.resultSlots, 0, 110, 18));

    }

    protected static void slotChangedCraftingGrid(AbstractContainerMenu menu, Level level, Player player, CraftingContainer craftSlots, ResultContainer resultSlots, @Nullable RecipeHolder<CraftingRecipe> recipe) {
        if (!level.isClientSide) {
            CraftingInput craftinginput = craftSlots.asCraftInput();
            ServerPlayer serverplayer = (ServerPlayer) player;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<RecipeHolder<CraftingRecipe>> optional = level.getServer().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftinginput, level, recipe);
            if (optional.isPresent()) {
                RecipeHolder<CraftingRecipe> recipeholder = (RecipeHolder) optional.get();
                CraftingRecipe craftingrecipe = (CraftingRecipe) recipeholder.value();
                if (resultSlots.setRecipeUsed(level, serverplayer, recipeholder)) {
                    ItemStack itemstack1 = craftingrecipe.assemble(craftinginput, level.registryAccess());
                    if (itemstack1.isItemEnabled(level.enabledFeatures())) {
                        itemstack = itemstack1;
                    }
                }
            }

            resultSlots.setItem(0, itemstack);
            menu.setRemoteSlot(0, itemstack);
            serverplayer.connection.send(new ClientboundContainerSetSlotPacket(menu.containerId, menu.incrementStateId(), 0, itemstack));
        }

    }

    public void fillCraftSlotsStackedContents(StackedContents itemHelper) {
        this.craftSlots.fillStackedContents(itemHelper);
    }

    public void clearCraftingContent() {
        this.craftSlots.clearContent();
        this.resultSlots.clearContent();
    }

    @Override
    public boolean recipeMatches(RecipeHolder recipeHolder) {
        return false;
    }

    @Override
    public int getResultSlotIndex() {
        return 0;
    }

    @Override
    public int getGridWidth() {
        return 0;
    }

    @Override
    public int getGridHeight() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return null;
    }

    @Override
    public boolean shouldMoveToInventory(int i) {
        return false;
    }

    public void slotsChanged(Container inventory) {
        if (!this.placingRecipe) {
            this.access.execute((p_344363_, p_344364_) -> slotChangedCraftingGrid(this, p_344363_, this.player, this.craftSlots, this.resultSlots, (RecipeHolder) null));
        }

    }

    @Override
    public boolean stillValid(Player player) {
        return !this.oxhauler.hasInventoryChanged(this.oxhaulerContainer)
                && this.oxhaulerContainer.stillValid(player)
                && this.oxhauler.isAlive()
                && player.canInteractWithEntity(this.oxhauler, 4.0);
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (slot instanceof ResultSlot) {
                clearCraftingContent();
                playerIn.playSound(AllSoundEvents.CONFIRM.getMainEvent());
            }
            if (index < 36) {
                moveItemStackTo(stack, 36, 198, false);
            } else {
                moveItemStackTo(stack, 0, 35, false);
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return ItemStack.EMPTY;
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void removed (Player player){
        super.removed(player);
        this.access.execute((p_39371_, p_39372_) -> this.clearContainer(player, this.craftSlots));
        this.oxhaulerContainer.stopOpen(player);
    }
}
