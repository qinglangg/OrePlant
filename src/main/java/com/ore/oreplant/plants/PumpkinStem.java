package com.ore.oreplant.plants;

import com.google.common.collect.Lists;
import com.ore.oreplant.OrePlant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static net.minecraftforge.common.util.ForgeDirection.UP;

public class PumpkinStem extends BlockStem {

    private final int color;
    private final Block colorBlock;
    private final Block result;
    private final Supplier<Item> seed;

    private PumpkinStem(int color, Block colorBlock, Block result, Supplier<Item> seed) {
        super(result);
        this.result = result;
        this.color = color;
        this.seed = seed;
        this.colorBlock = colorBlock;
        setCreativeTab(OrePlant.TAB);
        setHardness(0.0F);
        setStepSound(soundTypeWood);
        setBlockTextureName("pumpkin_stem");
    }

    public PumpkinStem(int color, Block result, Supplier<Item> seed) {
        this(color, null, result, seed);
    }

    public PumpkinStem(Block color, Block result, Supplier<Item> seed) {
        this(0, color, result, seed);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        this.checkAndDropBlock(world, x, y, z);
        if (world.getBlockLightValue(x, y + 1, z) >= 9)
        {
            float f = func_149875_n(world, x, y, z);

            if (rand.nextInt((int)(25.0F / f) + 1) == 0)
            {
                int l = world.getBlockMetadata(x, y, z);

                if (l < 7)
                {
                    ++l;
                    world.setBlockMetadataWithNotify(x, y, z, l, 2);
                }
                else
                {
                    if (world.getBlock(x - 1, y, z) == result)
                    {
                        return;
                    }

                    if (world.getBlock(x + 1, y, z) == result)
                    {
                        return;
                    }

                    if (world.getBlock(x, y, z - 1) == result)
                    {
                        return;
                    }

                    if (world.getBlock(x, y, z + 1) == result)
                    {
                        return;
                    }

                    int i1 = rand.nextInt(4);
                    int j1 = x;
                    int k1 = z;

                    if (i1 == 0)
                    {
                        j1 = x - 1;
                    }

                    if (i1 == 1)
                    {
                        ++j1;
                    }

                    if (i1 == 2)
                    {
                        k1 = z - 1;
                    }

                    if (i1 == 3)
                    {
                        ++k1;
                    }

                    Block block = world.getBlock(j1, y - 1, k1);

                    if (world.isAirBlock(j1, y, k1) && (block == Blocks.dirt || block == Blocks.grass))
                    {
                        world.setBlock(j1, y, k1, this.result);
                    }
                }
            }
        }
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) { }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
        return Lists.newArrayList(new ItemStack(seed.get()));
    }

    @Override
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
        if (colorBlock != null) {
            return colorBlock.getMapColor(0).colorValue;
        }
        return color;
    }

    private float func_149875_n(World p_149875_1_, int p_149875_2_, int p_149875_3_, int p_149875_4_)
    {
        float f = 1.0F;
        Block block = p_149875_1_.getBlock(p_149875_2_, p_149875_3_, p_149875_4_ - 1);
        Block block1 = p_149875_1_.getBlock(p_149875_2_, p_149875_3_, p_149875_4_ + 1);
        Block block2 = p_149875_1_.getBlock(p_149875_2_ - 1, p_149875_3_, p_149875_4_);
        Block block3 = p_149875_1_.getBlock(p_149875_2_ + 1, p_149875_3_, p_149875_4_);
        Block block4 = p_149875_1_.getBlock(p_149875_2_ - 1, p_149875_3_, p_149875_4_ - 1);
        Block block5 = p_149875_1_.getBlock(p_149875_2_ + 1, p_149875_3_, p_149875_4_ - 1);
        Block block6 = p_149875_1_.getBlock(p_149875_2_ + 1, p_149875_3_, p_149875_4_ + 1);
        Block block7 = p_149875_1_.getBlock(p_149875_2_ - 1, p_149875_3_, p_149875_4_ + 1);
        boolean flag = block2 == this || block3 == this;
        boolean flag1 = block == this || block1 == this;
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;

        for (int l = p_149875_2_ - 1; l <= p_149875_2_ + 1; ++l)
        {
            for (int i1 = p_149875_4_ - 1; i1 <= p_149875_4_ + 1; ++i1)
            {
                Block block8 = p_149875_1_.getBlock(l, p_149875_3_ - 1, i1);
                float f1 = 0.0F;

                if (block8.canSustainPlant(p_149875_1_, l, p_149875_3_ - 1, i1, UP, this))
                {
                    f1 = 1.0F;

                    if (block8.isFertile(p_149875_1_, l, p_149875_3_ - 1, i1))
                    {
                        f1 = 3.0F;
                    }
                }

                if (l != p_149875_2_ || i1 != p_149875_4_)
                {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }
}
