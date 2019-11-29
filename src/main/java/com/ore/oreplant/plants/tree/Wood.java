package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OreTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

/**
 * 原木
 * @author luqin2007
 */
public class Wood extends BlockLog {

    private final IBlockState mStateColor;

    public Wood(Block color) {
        super();
        setCreativeTab(OreTabs.TAB);
        mStateColor = color.getDefaultState();
        setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return mStateColor.getMapColor(worldIn, pos);
    }

    @Override
    @Nonnull
    public IBlockState getStateFromMeta(int meta) {
        IBlockState state = getDefaultState();
        if ((meta & 0b0001) == 0b0001) {
            return state.withProperty(LOG_AXIS, EnumAxis.X);
        } else if ((meta & 0b0010) == 0b0010) {
            return state.withProperty(LOG_AXIS, EnumAxis.Y);
        } else if ((meta & 0b0011) == 0b0011) {
            return state.withProperty(LOG_AXIS, EnumAxis.Z);
        } else {
            return state.withProperty(LOG_AXIS, EnumAxis.NONE);
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        switch (state.getValue(LOG_AXIS)) {
            case X: return 0b0001;
            case Y: return 0b0010;
            case Z: return 0b0011;
            default: return 0b0000;
        }
    }

    @Override
    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOG_AXIS);
    }

}
