package rbc.block;

import net.minecraft.block.Block;
import rbc.lib.BlockIds;
import rbc.lib.RenderIds;
import rbc.lib.Strings;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Robocraft
 * 
 * ModBlocks
 * 
 * @author michaelcurtis96
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class ModBlocks {

    public static Block KoP;

    public static void init() {
        KoP = new BlockKoP(BlockIds.KOP_DEFAULT);

        GameRegistry.registerBlock(KoP, Strings.KOP_NAME);

        RenderIds.KoPRenderId = RenderingRegistry.getNextAvailableRenderId();

        LanguageRegistry.addName(KoP, "K.o.P");
    }

}
