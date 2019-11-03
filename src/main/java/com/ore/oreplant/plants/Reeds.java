package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.render.IColorProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Reeds extends BlockReed implements IColorProvider {

    private final Supplier<List<ItemStack>> drops;
    private final int color;
    private final Block colorBlock;

    private Reeds(int color, Block colorBlock, Supplier<List<ItemStack>> drops) {
        this.drops = drops;
        this.color = color;
        this.colorBlock = colorBlock;
        setCreativeTab(OreTabs.TAB);
    }

    public Reeds(int color, Supplier<List<ItemStack>> drops) {
        this(color, null, drops);
    }

    public Reeds(Block color, Supplier<List<ItemStack>> drops) {
        this(0, color, drops);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        int maxHeight = 3;
        int maxAge = 15;

        if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.REEDS || checkForDrop(worldIn, pos, state)) {
            if (worldIn.isAirBlock(pos.up())) {
                int i = 1;
                BlockPos p = pos.down();
                while (worldIn.getBlockState(p).getBlock() == this) {
                    i++;
                    p = p.down();
                }
                if (i < maxHeight) {
                    int j = state.getValue(AGE);
                    if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
                        if (j >= maxAge) {
                            BlockPos up = pos.up();
                            worldIn.setBlockState(up, this.getDefaultState());
                            worldIn.setBlockState(pos, state.withProperty(AGE, 0), 4);
                        } else {
                            worldIn.setBlockState(pos, state.withProperty(AGE, j + 1), 4);
                        }
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    }
                }
            }
        }
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.add(new ItemStack(this));
        drops.addAll(this.drops.get());
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (colorBlock != null) {
            return colorBlock.getDefaultState().getMapColor(world, pos).colorValue;
        }
        return color;
    }
}
