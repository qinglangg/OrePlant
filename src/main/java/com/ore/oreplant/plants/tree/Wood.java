package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OrePlant;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class Wood extends BlockLog {

    private final String textureKey;
    private IIcon side, top;

    public Wood(String textureKey) {
        this.textureKey = textureKey;
        setCreativeTab(OrePlant.TAB);
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(this));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister render) {
        top = render.registerIcon("oreplant:wood_top_" + textureKey);
        side = render.registerIcon("oreplant:wood_side_" + textureKey);
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(int p_150163_1_) {
        return side;
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(int p_150161_1_) {
        return top;
    }
}
