package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import io.netty.util.internal.MathUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Supplier;

public class Wheat extends BlockCrops {

    private final Supplier<List<ItemStack>> drop;

    public Wheat(Supplier<List<ItemStack>> drop) {
        this.drop = drop;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        drops.addAll(drop.get());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && isMaxAge(state)) {
            worldIn.setBlockState(pos, state.withProperty(AGE, 0), 3);
            List<ItemStack> stacks = drop.get();
            for (ItemStack stack : stacks) {
                Block.spawnAsEntity(worldIn, pos, stack);
            }
            EntityXPOrb xpOrb = new EntityXPOrb(worldIn, pos.getX(), pos.getY(), pos.getZ(), (int) Math.sqrt(stacks.size()));
            worldIn.spawnEntity(xpOrb);
        }
        return true;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }
}
