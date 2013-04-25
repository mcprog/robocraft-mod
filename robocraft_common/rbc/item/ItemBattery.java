package rbc.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import rbc.Robocraft;
import rbc.lib.Reference;
import rbc.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Robocraft
 * 
 * ItemBattery
 * 
 * @author michaelcurtis96
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class ItemBattery extends Item {

    public ItemBattery(int id) {

        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        this.setUnlocalizedName(Strings.KOP_NAME);
        this.setCreativeTab(Robocraft.tabRobocraft);
        maxStackSize = 64;

    }

    public Icon battery;

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {
        iconIndex = iconRegister.registerIcon("Robocraft:battery");

    }

}
