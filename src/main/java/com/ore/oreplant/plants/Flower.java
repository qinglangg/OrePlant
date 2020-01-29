package com.ore.oreplant.plants;

import com.ore.oreplant.OrePlant;
import com.ore.oreplant.config.FlowerConfig;
import com.ore.oreplant.generator.FlowerGenerator;
import com.ore.oreplant.interfaces.IDecorator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

/**
 * 矿物花
 * @author luqin2007
 */
@SuppressWarnings("unused")
public class Flower extends BlockBush implements IDecorator {

    private FlowerGenerator generator;

    public Flower(Block color, String typeName, DoubleSupplier probability, IntSupplier maxCount) {
        setCreativeTab(OrePlant.TAB);
        setBlockTextureName(OrePlant.MODID + ":" + typeName + "_flower");
        setBlockName(OrePlant.MODID + ".flower" + typeName);
        generator = new FlowerGenerator(this, probability, maxCount);
    }

    public boolean canSustainBush(Block block) {
        return canPlaceBlockOn(block);
    }

    @Override
    public void decorate(World world, Random random, int x, int y, int z) {
        generator.generate(world, random, x, y, z);
    }

    @Override
    public boolean canDecorator(World world, Random random, int x, int y, int z, int chunkX, int chunkZ) {
        return FlowerConfig.generate && generator != null && TerrainGen.decorate(world, random, chunkX, chunkZ, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
    }
}
