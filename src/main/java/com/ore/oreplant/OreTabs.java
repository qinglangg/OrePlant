package com.ore.oreplant;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * 矿植创造栏
 * @author luqin2007
 */
public class OreTabs extends CreativeTabs {

    public static CreativeTabs TAB = new OreTabs();

    public OreTabs() {
        super("ore");
    }

    @Override
    @Nonnull
    public ItemStack getTabIconItem() {
        return new ItemStack(Seeds.saplingCoal);
    }
}
