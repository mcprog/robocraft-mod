package com.michaelcurtis96.rbc;

import net.minecraft.creativetab.CreativeTabs;

import com.michaelcurtis96.rbc.block.ModBlocks;
import com.michaelcurtis96.rbc.core.proxy.CommonProxy;
import com.michaelcurtis96.rbc.creativetab.CreativeTabRBC;
import com.michaelcurtis96.rbc.item.ModItems;
import com.michaelcurtis96.rbc.lib.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Robocraft {

    @Instance(Reference.MOD_ID)
    public static Robocraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final CreativeTabs tabRobocraft = new CreativeTabRBC(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
        CreativeTabRBC.initTab();
    }

    // When the mod is loaded
    @Init
    public void load(FMLInitializationEvent event) {
        // proxy.registerRenderers();
        LanguageRegistry.instance().addStringLocalization(
                "itemGroup.tabRobocraft", "en_US", "Robocraft");

    }

    // After the mod is loaded
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }

}
