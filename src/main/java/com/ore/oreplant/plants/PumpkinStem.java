package com.ore.oreplant.plants;

import com.ore.oreplant.interfaces.IColorProvider;
import com.ore.oreplant.interfaces.IStateMapProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.function.Supplier;

/**
 * 矿物南瓜藤
 * @author luqin2007
 */
public class PumpkinStem extends BlockStem implements IColorProvider, IStateMapProvider {

    private static Object mapper = null;

    private final Block colorBlock;
    private final Supplier<Item> seed;

    public PumpkinStem(Block color, Block result, Supplier<Item> seed) {
        super(result);
        this.seed = seed;
        this.colorBlock = color;
    }

    @Override
    protected Item getSeedItem() {
        return seed.get();
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        return colorBlock.getDefaultState().getMapColor(world, pos).colorValue;
    }

    @Override
    public net.minecraft.client.renderer.block.statemap.StateMapperBase getStateMapper() {
        if (mapper == null) {
            mapper = new com.ore.oreplant.render.PumpkinStemMap();
        }
        return (net.minecraft.client.renderer.block.statemap.StateMapperBase) mapper;
    }
}
