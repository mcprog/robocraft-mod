package com.michaelcurtis96.rbc.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

import com.michaelcurtis96.rbc.Robocraft;
import com.michaelcurtis96.rbc.lib.Reference;
import com.michaelcurtis96.rbc.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
