package com.ore.oreplant.plants;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Supplier;

/**
 * 矿麦
 * @author luqin2007
 */
public class Wheat extends BlockCrops {

    private final Supplier<ItemStack> seed, drop;

    public Wheat(Supplier<ItemStack> seed, Supplier<ItemStack> drop) {
        this.seed = seed;
        this.drop = drop;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull IBlockState state, int fortune) {
        drops.add(seed.get());
        if (isMaxAge(state)) {
            drops.add(drop.get());
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float x, float y, float z) {
        if (!worldIn.isRemote) {
            if (isMaxAge(state)) {
                worldIn.setBlockState(pos, state.withProperty(AGE, 0), 3);
                ItemStack stack = drop.get();
                Block.spawnAsEntity(worldIn, pos, stack);
                EntityXPOrb xpOrb = new EntityXPOrb(worldIn, pos.getX(), pos.getY(), pos.getZ(), (int) Math.sqrt(stack.getCount()));
                worldIn.spawnEntity(xpOrb);
            } else {
                ItemStack heldItem = playerIn.getHeldItem(hand);
                if (heldItem.getItem() == Items.DYE && EnumDyeColor.byDyeDamage(heldItem.getItemDamage()) == EnumDyeColor.WHITE) {
                    grow(worldIn, pos, state);
                    heldItem.shrink(1);
                    worldIn.playEvent(2005, pos, 0);
                }
            }
        }
        return true;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }
}
