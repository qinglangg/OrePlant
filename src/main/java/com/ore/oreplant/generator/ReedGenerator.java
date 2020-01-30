package com.ore.oreplant.generator;

import com.ore.oreplant.plants.Reeds;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import javax.annotation.Nonnull;
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
    public boolean generate(World worldIn, @Nonnull Random rand, @Nonnull BlockPos position) {
        ChunkPos chunkPos = worldIn.getChunkFromBlockCoords(position).getPos();
        int xStart = chunkPos.getXStart(), xEnd = chunkPos.getXEnd();
        int zStart = chunkPos.getZStart(), zEnd = chunkPos.getZEnd();
        double probability = mProbability.getAsDouble();
        for (int i = 0; i < 20; ++i) {
            if (rand.nextDouble() < probability) {
                int x = position.getX() + rand.nextInt(4) - rand.nextInt(4);
                int z = position.getZ() + rand.nextInt(4) - rand.nextInt(4);
                BlockPos pos = new BlockPos(x, worldIn.getHeight(x, z), z);
                if (xStart < x && x < xEnd && zStart < z && z < zEnd && worldIn.isAirBlock(pos)) {
                    BlockPos down = pos.down();
                    if (worldIn.getBlockState(down.west()).getMaterial() == Material.WATER
                            || worldIn.getBlockState(down.east()).getMaterial() == Material.WATER
                            || worldIn.getBlockState(down.north()).getMaterial() == Material.WATER
                            || worldIn.getBlockState(down.south()).getMaterial() == Material.WATER) {
                        int height = 2 + rand.nextInt(rand.nextInt(3) + 1);
                        for (int k = 0; k < height; ++k) {
                            if (mReeds.canBlockStay(worldIn, pos)) {
                                worldIn.setBlockState(pos.up(k), mReeds.getDefaultState(), 2);
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
