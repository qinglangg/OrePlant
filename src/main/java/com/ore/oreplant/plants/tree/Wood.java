package com.ore.oreplant.plants.tree;

import com.elementtimes.elementcore.api.annotation.ModBlock;
import com.ore.oreplant.OreTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class Wood extends BlockLog {

    private final MapColor mMapColor;
    private final IBlockState mStateColor;

    private Wood(MapColor color, IBlockState colorState) {
        super();
        setCreativeTab(OreTabs.TAB);
        mMapColor = color;
        mStateColor = colorState;
        setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
    }

    public Wood(MapColor color) {
        this(color, null);
    }

    public Wood(Block color) {
        this(null, color.getDefaultState());
    }

    public Wood(IBlockState color) {
        this(null, color);
    }

    @Override
    @Nonnull
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        if (mMapColor != null) {
            return mMapColor;
        } else if (mStateColor != null) {
            return mStateColor.getMapColor(worldIn, pos);
        } else {
            return Blocks.LOG.getDefaultState().getMapColor(worldIn, pos);
        }
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

    @ModBlock
    public static Wood woodCoal = new Wood(Blocks.COAL_BLOCK);
    @ModBlock
    public static Wood woodDiamond = new Wood(Blocks.DIAMOND_BLOCK);
    @ModBlock
    public static Wood woodEmerald = new Wood(Blocks.EMERALD_BLOCK);
    @ModBlock
    public static Wood woodGold = new Wood(Blocks.GOLD_BLOCK);
    @ModBlock
    public static Wood woodIron = new Wood(Blocks.IRON_BLOCK);
    @ModBlock
    public static Wood woodLapis = new Wood(Blocks.LAPIS_BLOCK);
    @ModBlock
    public static Wood woodRedstone = new Wood(Blocks.REDSTONE_BLOCK);
    @ModBlock
    public static Wood woodQuartz = new Wood(Blocks.QUARTZ_BLOCK);
    @ModBlock
    public static Wood woodObsidian = new Wood(Blocks.OBSIDIAN);
    @ModBlock
    public static Wood woodGlowstone = new Wood(Blocks.GLOWSTONE);

}
