package com.P4.GUI;

import com.P4.GuiContainer.ContainerKurtBlockTileEntity;
import com.P4.tileentity.KurtBlockTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by esben on 22/03/16.
 */
public class GuiKurtBlockTileEntity extends GuiContainer{
    private IInventory playerInv;
    private KurtBlockTileEntity KBTE;
    public GuiKurtBlockTileEntity(IInventory playerInv, KurtBlockTileEntity KBTE) {
        super(new ContainerKurtBlockTileEntity( playerInv, KBTE));

        this.playerInv = playerInv;
        this.KBTE = KBTE;

        this.xSize = 176;
        this.ySize = 166;
    }

    public GuiKurtBlockTileEntity(ContainerKurtBlockTileEntity CKBTE) {
        super(CKBTE);

        this.playerInv = CKBTE.getPlayerInv();
        this.KBTE = CKBTE.getKBTE();

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation("obco:GUI/KurtBlockTest.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.KBTE.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040
    }
}
