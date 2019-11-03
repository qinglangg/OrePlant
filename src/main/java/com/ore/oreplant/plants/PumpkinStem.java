package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.render.IColorProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class PumpkinStem extends BlockStem implements IColorProvider {

    private final int color;
    private final Block colorBlock;
    private final Supplier<Item> seed;

    private PumpkinStem(int color, Block colorBlock, Block result, Supplier<Item> seed) {
        super(result);
        this.color = color;
        this.seed = seed;
        this.colorBlock = colorBlock;
    }

    public PumpkinStem(int color, Block result, Supplier<Item> seed) {
        this(color, null, result, seed);
    }

    public PumpkinStem(Block color, Block result, Supplier<Item> seed) {
        this(0, color, result, seed);
    }

    @Nullable
    @Override
    protected Item getSeedItem() {
        return seed.get();
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (colorBlock != null) {
            return colorBlock.getDefaultState().getMapColor(world, pos).colorValue;
        }
        return color;
    }
}
