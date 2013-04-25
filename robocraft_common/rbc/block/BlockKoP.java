package rbc.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import rbc.Robocraft;
import rbc.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Robocraft
 * 
 * BlockKoP
 * 
 * @author michaelcurtis96
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class BlockKoP extends Block {

    @SideOnly(Side.CLIENT)
    private Icon top;

    // giving id, and material params
    public BlockKoP(int id) {
        super(id, Material.wood);

        this.setUnlocalizedName(Strings.KOP_NAME);
        this.setHardness(2.5f);
        this.setResistance(2000.0f);
        this.setStepSound(soundWoodFootstep);
        this.setCreativeTab(Robocraft.tabRobocraft);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int side, int metadata) {
        switch (side) {
            case 1:
                return top;
            default:
                return blockIcon;
        }

    }

    // public String getTextureFile() {
    // return CommonProxy.BLOCKS_PNG;
    // }

    public Icon KoPTop;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("Robocraft:KoPSide");
        top = iconRegister.registerIcon("Robocraft:KoPTop2");
    }

}
