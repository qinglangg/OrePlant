package com.ore.oreplant;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OreTabs extends CreativeTabs {

    public static CreativeTabs TAB = new OreTabs();

    public OreTabs() {
        super("ore");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Seeds.saplingCoal);
    }
}
