package net.dshbwlto.createbionics.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.dshbwlto.createbionics.CreateBionics;
import net.dshbwlto.createbionics.entity.custom.StalkerEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StalkerScreen extends AbstractContainerScreen<StalkerMenu> {
    private static final ResourceLocation GUI_TEXTURE_T0 =
            ResourceLocation.fromNamespaceAndPath(CreateBionics.MOD_ID, "textures/entity/oxhauler/gui/gui1.png");
    private final StalkerEntity stalker;
    private float xMouse;
    private float yMouse;


    public StalkerScreen(StalkerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.stalker = menu.stalker;
    }

    @Override
    protected void init() {
        super.init();
        titleLabelX = -3;
        titleLabelY = -31;

        inventoryLabelX = 1000;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int x = (width - imageWidth) / 2 + 10;
        int y = (height - imageHeight) / 2 + 0;

        imageWidth = 230;
        imageHeight = 236;

        RenderSystem.setShaderTexture(0, GUI_TEXTURE_T0);

        guiGraphics.blit(GUI_TEXTURE_T0, x, y, -8, 0, imageWidth, imageHeight);

        InventoryScreen.renderEntityInInventoryFollowsMouse(guiGraphics, x + 23, y + 32, x + 76, y + 85, 20, 0.05F,
                this.xMouse, this.yMouse, this.stalker);
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
