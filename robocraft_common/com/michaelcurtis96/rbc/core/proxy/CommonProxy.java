package com.michaelcurtis96.rbc.core.proxy;

import net.minecraftforge.common.ForgeDirection;

public class CommonProxy {
    // public static String BLOCKS_PNG = "/mods/robocraft/textures/blocks.png";
    // public static String ITEMS_PNG = "/mods/robocraft/textures/items.png";

    public void registerRenderers() {
        // Nothing here because graphics are client side
    }

    public void handleTileEntityPacket(int x, int y, int z,
            ForgeDirection orientation, short state, String player,
            String customName) {

    }

}
