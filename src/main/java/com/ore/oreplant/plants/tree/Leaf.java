package com.ore.oreplant.plants.tree;

import com.google.common.collect.Lists;
import com.ore.oreplant.OrePlant;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Leaf extends BlockLeaves {

    private final Supplier<BlockSapling> sapling;

    private IIcon icon;
    private final Block colorBlock;

    public Leaf(Block color, Supplier<BlockSapling> sapling) {
        setCreativeTab(OrePlant.TAB);
        this.sapling = sapling;
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getMinecraft();
            setGraphicsLevel(mc.gameSettings.fancyGraphics);
        }
        this.colorBlock = color;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        int chance = this.func_150123_b(metadata);

        if (fortune > 0) {
            chance -= 2 << fortune;
            if (chance < 10) {
                chance = 10;
            }
        }

        if (world.rand.nextInt(chance) == 0) {
            ret.add(new ItemStack(sapling.get()));
        }

        this.captureDrops(true);
        ret.addAll(this.captureDrops(false));
        return ret;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        return Lists.newArrayList(new ItemStack(this));
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(this));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return icon;
    }

    @Override
    public String[] func_150125_e() {
        return new String[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(net.minecraft.client.renderer.texture.IIconRegister register) {
        icon = register.registerIcon("oreplant:leaves");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
        return colorBlock.getMapColor(0).colorValue;
    }
}
