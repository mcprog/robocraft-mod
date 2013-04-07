package com.michaelcurtis96.rbc.block;

import net.minecraft.block.Block;

import com.michaelcurtis96.rbc.lib.BlockIds;
import com.michaelcurtis96.rbc.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block KoP;

    public static void init() {
        KoP = new BlockKoP(BlockIds.KOP_DEFAULT);

        GameRegistry.registerBlock(KoP, Strings.KOP_NAME);

        LanguageRegistry.addName(KoP, "K.o.P");
    }

}
