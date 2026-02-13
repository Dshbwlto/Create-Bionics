package net.dshbwlto.createbionics.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.OxhaulerEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class OxhaulerScreen  extends AbstractContainerScreen<OxhaulerMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID,"textures/gui/oxhauler/gui1.png");
    private final OxhaulerEntity oxhauler;
    private float xMouse;
    private float yMouse;

    public OxhaulerScreen(OxhaulerMenu pMenu, Inventory pPlayerInventory, Component title) {
        super(pMenu, pPlayerInventory, title);
        this.oxhauler = pMenu.oxhauler;
    }

    @Override
    protected void init() {
        super.init();
        titleLabelX = 72;
        titleLabelY = 12;

        inventoryLabelX = 1000;
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        RenderSystem.setShaderTexture(0, GUI_TEXTURE);
        pGuiGraphics.blit(GUI_TEXTURE, 120, 10, 0, 0, 214, 236);

        InventoryScreen.renderEntityInInventoryFollowsMouse(pGuiGraphics, x -16, y, x + 36, y + 52, 20, 0.05F,
                this.xMouse, this.yMouse, this. oxhauler);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.xMouse = (float)mouseX;
        this.yMouse = (float)mouseY;

        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}