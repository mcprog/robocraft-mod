package rbc.item;

import net.minecraft.item.Item;
import rbc.lib.ItemIds;
import rbc.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Robocraft
 * 
 * ModItems
 * 
 * @author michaelcurtis96
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class ModItems {

    public static Item battery;

    public static void init() {
        battery = new ItemBattery(ItemIds.BATTERY_DEFAULT);

        GameRegistry.registerItem(battery, Strings.BATTERY_NAME);

        LanguageRegistry.addName(battery, "Battery");
    }

}
