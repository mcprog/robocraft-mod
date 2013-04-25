package rbc;

import net.minecraft.creativetab.CreativeTabs;
import rbc.block.ModBlocks;
import rbc.core.proxy.CommonProxy;
import rbc.creativetab.CreativeTabRBC;
import rbc.item.ModItems;
import rbc.lib.Reference;
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

/**
 * Robocraft
 * 
 * Robocraft
 * 
 * @author michaelcurtis96
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Robocraft {

    @Instance(Reference.MOD_ID)
    public static Robocraft instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    /**
     * Creation of tabRobocraft object (tab is initialized in preInit)
     */
    public static final CreativeTabs tabRobocraft = new CreativeTabRBC(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

        // preInit of robocraft tab
        CreativeTabRBC.initTab();

        // preInit of robocraft blocks
        ModBlocks.init();

        // perInit of robocraft items
        ModItems.init();

    }

    @Init
    public void load(FMLInitializationEvent event) {

        LanguageRegistry.instance().addStringLocalization(
                "itemGroup.tabRobocraft", "en_US", "Robocraft");

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }

}
