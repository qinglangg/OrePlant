package com.ore.oreplant.plants.tree;

import com.elementtimes.elementcore.api.common.ECUtils;
import com.ore.oreplant.OreTabs;
import com.ore.oreplant.render.IColorProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;
import java.util.function.Supplier;

public class Leaf extends BlockLeaves implements IColorProvider {

    private final Supplier<BlockSapling> sapling;

    private final int color;
    private final IBlockState colorState;

    private Leaf(int color, IBlockState colorState, Supplier<BlockSapling> sapling) {
        setCreativeTab(OreTabs.TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, true));
        this.sapling = sapling;
        if (ECUtils.common.isClient()) {
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getMinecraft();
            setGraphicsLevel(mc.gameSettings.fancyGraphics);
        }
        this.color = color;
        this.colorState = colorState;
    }

    public Leaf(int color, Supplier<BlockSapling> sapling) {
        this(color, null, sapling);
    }

    public Leaf(Block color, Supplier<BlockSapling> sapling) {
        this(0, color.getDefaultState(), sapling);
    }

    public Leaf(IBlockState color, Supplier<BlockSapling> sapling) {
        this(0, color, sapling);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY, (meta & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if (!state.getValue(DECAYABLE)) {
            i |= 4;
        }
        if (state.getValue(CHECK_DECAY)) {
            i |= 8;
        }
        return i;
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return  Item.getItemFromBlock(sapling.get());
    }

    @Override
    public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this));
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (colorState != null) {
            return colorState.getMapColor(world, pos).colorValue;
        }
        return color;
    }
}
