package com.ore.oreplant.generator;

import com.ore.oreplant.plants.Flower;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

/**
 * 矿花世界生成
 * @author luqin2007
 */
public class FlowerGenerator extends WorldGenerator {

    private Flower mFlower;
    private DoubleSupplier mProbability;
    private IntSupplier mMaxCount;

    public FlowerGenerator(Flower flower, DoubleSupplier probability, IntSupplier maxCount) {
        mFlower = flower;
        mProbability = probability;
        mMaxCount = maxCount;
    }

    @Override
    public boolean generate(World world, Random rand, int posX, int posY, int posZ) {
        Chunk chunk = world.getChunkFromBlockCoords(posX, posZ);
        int xStart = posX, xEnd = posX + 16;
        int zStart = posZ, zEnd = posZ + 16;
        int count = 0;
        int maxCount = mMaxCount.getAsInt();
        double probability = mProbability.getAsDouble();
        for (int i = 0; i < 64; ++i) {
            int x = posX + rand.nextInt(8) - rand.nextInt(8);
            int z = posZ + rand.nextInt(8) - rand.nextInt(8);
            int y = world.getHeightValue(x, z) + rand.nextInt(4) - rand.nextInt(4);
            if (xStart < x && x < xEnd && zStart < z && z < zEnd
                    && world.isAirBlock(x, y, z)
                    && (world.provider.dimensionId != -1 || posY < 255)
                    && mFlower.canSustainBush(world.getBlock(x, y-1, z))) {
                if (rand.nextDouble() <= probability) {
                    world.setBlock(x, y, z, mFlower, 0, 2);
                    count++;
                    if (count >= maxCount) {
                        break;
                    }
                }
            }
        }
        return true;
    }
}
