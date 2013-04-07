package com.michaelcurtis96.rbc.item;

import net.minecraft.item.Item;

import com.michaelcurtis96.rbc.lib.ItemIds;
import com.michaelcurtis96.rbc.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {

    public static Item battery;

    public static void init() {
        battery = new ItemBattery(ItemIds.BATTERY_DEFAULT);

        GameRegistry.registerItem(battery, Strings.BATTERY_NAME);

        LanguageRegistry.addName(battery, "Battery");
    }

}
