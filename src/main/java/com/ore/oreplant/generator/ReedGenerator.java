package com.ore.oreplant.generator;

import com.ore.oreplant.plants.Reeds;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;
import java.util.function.DoubleSupplier;

/**
 * 甘蔗的世界生成
 * @author luqin2007
 */
public class ReedGenerator extends WorldGenerator {

    private Reeds mReeds;
    private DoubleSupplier mProbability;

    public ReedGenerator(Reeds reeds, DoubleSupplier probability) {
        mReeds = reeds;
        mProbability = probability;
    }

    @Override
    public boolean generate(World world, Random rand, int posX, int posY, int posZ) {
        int cX = posX % 16, cZ = posZ % 16;
        if ((cX <= 4 || cX >= 12) && (cZ <= 4 || cZ >= 12)) {
            return false;
        }

        Chunk chunkPos = world.getChunkFromBlockCoords(posX, posZ);
        int xStart = chunkPos.xPosition, xEnd = xStart + 16;
        int zStart = chunkPos.zPosition, zEnd = zStart + 16;
        double probability = mProbability.getAsDouble();
        for (int i = 0; i < 20; ++i) {
            if (rand.nextDouble() < probability) {
                int x = chunkPos.xPosition + rand.nextInt(4) - rand.nextInt(4);
                int z = chunkPos.zPosition + rand.nextInt(4) - rand.nextInt(4);
                int y = world.getHeightValue(x, z);
                if (xStart < x && x < xEnd && zStart < z && z < zEnd && world.isAirBlock(x, y, z)) {
                    if (world.getBlock(x+1, y-1, z).getMaterial() == Material.water
                            || world.getBlock(x-1, y-1, z).getMaterial() == Material.water
                            || world.getBlock(x, y-1, z+1).getMaterial() == Material.water
                            || world.getBlock(x, y-1, z-1).getMaterial() == Material.water) {
                        int height = 2 + rand.nextInt(rand.nextInt(3) + 1);
                        for (int k = 0; k < height; ++k) {
                            if (mReeds.canBlockStay(world, x, y, z)) {
                                world.setBlock(x, y-k, z, mReeds, 0, 2);
                            }
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }
}
