package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.config.Configuration;
import com.ore.oreplant.generator.FlowerGenerator;
import com.ore.oreplant.interfaces.IColorProvider;
import com.ore.oreplant.interfaces.IDecorator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

/**
 * 矿物花
 * @author luqin2007
 */
@SuppressWarnings("unused")
public class Flower extends BlockBush implements IColorProvider, IDecorator {

    private IBlockState colorState;
    private FlowerGenerator generator;

    public Flower(Block color, DoubleSupplier probability, IntSupplier maxCount) {
        this.colorState = color.getDefaultState();
        setCreativeTab(OreTabs.TAB);
        generator = new FlowerGenerator(this, probability, maxCount);
    }

    @Override
    @Nonnull
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return super.getBoundingBox(state, source, pos).offset(state.getOffset(source, pos));
    }

    @Override
    @Nonnull
    public EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XZ;
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        if (colorState != null) {
            return colorState.getMapColor(world, pos).colorValue;
        }
        return -1;
    }

    @Override
    public boolean canSustainBush(IBlockState state) {
        return super.canSustainBush(state);
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        generator.generate(world, rand, pos);
    }

    @Override
    public boolean canDecorator(World world, Random rand, BlockPos pos, ChunkPos chunkPos) {
        return Configuration.flower.generate && generator != null && TerrainGen.decorate(world, rand, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
    }
}
