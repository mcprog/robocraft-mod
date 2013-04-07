package com.michaelcurtis96.rbc.client.gui.inventory;

import java.awt.Container;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.michaelcurtis96.rbc.inventory.ContainerKoP;
import com.michaelcurtis96.rbc.tileentity.TileKoP;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiKoP extends GuiContainer {

    private TileKoP tileKoP;

    public GuiKoP(InventoryPlayer inventoryPlayer, TileKoP KoP) {

        super(new ContainerKoP(inventoryPlayer, KoP));
        tileKoP = KoP;
        xSize = 248;
        ySize = 186;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        fontRenderer.drawString(tileKoP.isInvNameLocalized() ? tileKoP.getInvName() : StatCollector.translateToLocal(tileKoP.getInvName()), 8, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.KoP"), 44, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture("/mods/ee3/textures/gui/KoPInventory.png");
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}
