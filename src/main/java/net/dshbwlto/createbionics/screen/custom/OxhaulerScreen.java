package net.dshbwlto.createbionics.screen.custom;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundSetBeaconPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.BeaconMenu;
import net.minecraft.world.inventory.Slot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Optional;

public class OxhaulerScreen  extends AbstractContainerScreen<OxhaulerMenu> {
    private static final ResourceLocation GUI_TEXTURE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"textures/gui/oxhauler/oxhauler_gui.png");

    private static final ResourceLocation BUTTON_SPRITE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"oxhauler/button");
    private static final ResourceLocation BUTTON_SELECTED_SPRITE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"oxhauler/button_selected");
    private static final ResourceLocation BUTTON_PRESSED_SPRITE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"oxhauler/button_selected");
    private static final ResourceLocation BUTTON_DISABLED_SPRITE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"oxhauler/button_unavailable");
    private static final ResourceLocation UP_SPRITE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"oxhauler/up_widget");
    private static final ResourceLocation DOWN_SPRITE = ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"oxhauler/down_widget");

    private final OxhaulerEntity oxhauler;
    private float xMouse;
    private float yMouse;
    private final List<OxhaulerScreen.OxhaulerButton> oxhaulerButtons = Lists.newArrayList();

    public OxhaulerScreen(OxhaulerMenu pMenu, Inventory pPlayerInventory, Component title) {
        super(pMenu, pPlayerInventory, title);
        this.oxhauler = pMenu.oxhauler;
    }
    @Override
    protected void init() {
        super.init();
        titleLabelX = -20;
        titleLabelY = -30;
        inventoryLabelX = 1000;

        this.addOxhaulerButton(new OxhaulerScreen.OxhaulerUpButton(this.leftPos + 149, this.topPos + 67) {
            @Override
            public boolean isActive() {
                return oxhauler.pageCount > 1;
            }
        });
        this.addOxhaulerButton(new OxhaulerScreen.OxhaulerDownButton(this.leftPos + 149, this.topPos + 84) {
            @Override
            public boolean isActive() {
                return oxhauler.pageCount < 6;
            }
        });
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        pGuiGraphics.blit(GUI_TEXTURE, 120, 10, 0, 0, 218, 236);

        InventoryScreen.renderEntityInInventoryFollowsMouse(pGuiGraphics, x -16, y, x + 36, y + 52, 15, 0.25f,
                this.xMouse, this.yMouse, this. oxhauler);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderLabels(guiGraphics, mouseX, mouseY);
        guiGraphics.drawString(this.font, Component.translatable("entity.createbionics.all.page_progress", oxhauler.pageCount, 6), 109, 45, 0xFFFFFF, true);
        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                guiGraphics.drawString(this.font, Component.translatable("entity.createbionics.all.int_preview", ((k + j * 9) + oxhauler.pageCount * 27) - 27), -16 + k * 18, 57 + j * 18, 0xFFFFFF, true);
            }
        }

    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.xMouse = (float)mouseX;
        this.yMouse = (float)mouseY;

        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }


    @OnlyIn(Dist.CLIENT)
    abstract static class OxhaulerScreenButton extends AbstractButton implements OxhaulerButton {
        private boolean selected;

        protected OxhaulerScreenButton(int x, int y) {
            super(x, y, 13, 13, CommonComponents.EMPTY);
        }

        protected OxhaulerScreenButton(int x, int y, Component message) {
            super(x, y, 13, 13, message);
        }

        public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
            ResourceLocation resourcelocation;
            if (!this.isActive()) {
                resourcelocation = OxhaulerScreen.BUTTON_DISABLED_SPRITE;
            } else if (this.selected) {
                resourcelocation = OxhaulerScreen.BUTTON_PRESSED_SPRITE;
            } else if (this.isHoveredOrFocused()) {
                resourcelocation = OxhaulerScreen.BUTTON_SELECTED_SPRITE;
            } else {
                resourcelocation = OxhaulerScreen.BUTTON_SPRITE;
            }

            guiGraphics.blitSprite(resourcelocation, this.getX(), this.getY(), this.width, this.height);
            this.renderIcon(guiGraphics);
        }

        protected abstract void renderIcon(GuiGraphics var1);

        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {
            this.defaultButtonNarrationText(narrationElementOutput);
        }
    }

    @OnlyIn(Dist.CLIENT)
    abstract static class OxhaulerSpriteScreenButton extends OxhaulerScreen.OxhaulerScreenButton {
        private final ResourceLocation sprite;

        protected OxhaulerSpriteScreenButton(int x, int y, ResourceLocation sprite, Component message) {
            super(x, y, message);
            this.sprite = sprite;
        }

        protected void renderIcon(GuiGraphics guiGraphics) {
            guiGraphics.blitSprite(this.sprite, this.getX(), this.getY(), 13, 13);
        }
    }

    private <T extends AbstractWidget & OxhaulerScreen.OxhaulerButton> void addOxhaulerButton(T oxhaulerButton) {
        this.addRenderableWidget(oxhaulerButton);
        this.oxhaulerButtons.add(oxhaulerButton);
    }

    @OnlyIn(Dist.CLIENT)
    class OxhaulerUpButton extends OxhaulerScreen.OxhaulerSpriteScreenButton {
        public OxhaulerUpButton(int x, int y) {
            super(x, y, OxhaulerScreen.UP_SPRITE, CommonComponents.GUI_DONE);
        }
        public void onPress() {
            if (oxhauler.pageCount > 1) {
                oxhauler.pageCount--;
            }
        }
        @Override
        public void updateStatus(int var1) {
        }
    }

    @OnlyIn(Dist.CLIENT)
    class OxhaulerDownButton extends OxhaulerScreen.OxhaulerSpriteScreenButton {
        public OxhaulerDownButton(int x, int y) {
            super(x, y, OxhaulerScreen.DOWN_SPRITE, CommonComponents.GUI_DONE);
        }
        public void onPress() {
            if (oxhauler.pageCount < 6) {
                oxhauler.pageCount++;
            }
        }
        @Override
        public void updateStatus(int var1) {
        }
    }

    @OnlyIn(Dist.CLIENT)
    interface OxhaulerButton {
        void updateStatus(int var1);
    }
}