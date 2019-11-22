package com.ore.oreplant.plants;

import com.google.common.collect.Lists;
import com.ore.oreplant.OreTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class Reeds extends BlockReed {

    private final int color;
    private final Block colorBlock;

    private Reeds(int color, Block colorBlock) {
        this.color = color;
        this.colorBlock = colorBlock;
        setCreativeTab(OreTabs.TAB);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        setBlockTextureName("reeds");
        disableStats();
    }

    public Reeds(int color) {
        this(color, null);
    }

    public Reeds(Block color) {
        this(0, color);
    }

    @Override
    public void updateTick(World worldIn, int x, int y, int z, Random random) {
        if (worldIn.getBlock(x, y - 1, z) == this || func_150170_e(worldIn, x, y, z)) {
            if (worldIn.isAirBlock(x, y + 1, z)) {
                int i = 1;
                int posY = y - 1;
                while (worldIn.getBlock(x, posY, z) == this) {
                    i++;
                    posY--;
                }
                if (i < 3) {
                    int j = worldIn.getBlockMetadata(x, y, z);
                    if (j >= 15) {
                        worldIn.setBlock(x, y + 1, z, this);
                        worldIn.setBlockMetadataWithNotify(x, y + 1, z, 0, 4);
                    } else {
                        worldIn.setBlockMetadataWithNotify(x, y, z, j + 1, 4);
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        return Lists.newArrayList(new ItemStack(this));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
        if (colorBlock != null) {
            return colorBlock.getMapColor(0).colorValue;
        }
        return color;
    }
}
