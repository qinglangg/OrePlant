package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.config.Configuration;
import com.ore.oreplant.generator.ReedGenerator;
import com.ore.oreplant.interfaces.IColorProvider;
import com.ore.oreplant.interfaces.IDecorator;
import com.ore.oreplant.interfaces.IStateMapProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.DoubleSupplier;

/**
 * 甘蔗
 * @author luqin2007
 */
public class Reeds extends BlockReed implements IColorProvider, IStateMapProvider, IDecorator {

    private final Block colorBlock;
    private ReedGenerator generator;

    public Reeds(Block color, DoubleSupplier probability) {
        this.colorBlock = color;
        setCreativeTab(OreTabs.TAB);
        generator = new ReedGenerator(this, probability);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, @Nonnull IBlockState state, Random rand) {
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
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, @Nonnull IBlockState state, int fortune) {
        drops.add(new ItemStack(this));
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (colorBlock != null) {
            return colorBlock.getDefaultState().getMapColor(world, pos).colorValue;
        }
        return -1;
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        generator.generate(world, rand, pos);
    }

    @Override
    public boolean canDecorator(World world, Random rand, BlockPos pos, ChunkPos chunkPos) {
        return Configuration.reed.generate && TerrainGen.decorate(world, rand, chunkPos, DecorateBiomeEvent.Decorate.EventType.REED);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public net.minecraft.client.renderer.block.statemap.StateMapperBase getStateMapper() {
        return new com.ore.oreplant.render.ReedMap();
    }
}
