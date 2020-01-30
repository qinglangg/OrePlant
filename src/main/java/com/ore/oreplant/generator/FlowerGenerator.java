package com.ore.oreplant.generator;

import com.ore.oreplant.plants.Flower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

/**
 * 矿花世界生成
 * @author luqin2007
 */
public class FlowerGenerator extends WorldGenerator {

    private Flower mFlower;
    private IBlockState mState;
    private DoubleSupplier mProbability;
    private IntSupplier mMaxCount;

    public FlowerGenerator(Flower flower, DoubleSupplier probability, IntSupplier maxCount) {
        mFlower = flower;
        mState = flower.getDefaultState();
        mProbability = probability;
        mMaxCount = maxCount;
    }

    @Override
    public boolean generate(World worldIn, @Nonnull Random rand, @Nonnull BlockPos position) {
        ChunkPos chunkPos = worldIn.getChunkFromBlockCoords(position).getPos();
        int xStart = chunkPos.getXStart(), xEnd = chunkPos.getXEnd();
        int zStart = chunkPos.getZStart(), zEnd = chunkPos.getZEnd();
        int count = 0;
        int maxCount = mMaxCount.getAsInt();
        double probability = mProbability.getAsDouble();
        for (int i = 0; i < 64; ++i) {
            int x = position.getX() + rand.nextInt(8) - rand.nextInt(8);
            int z = position.getZ() + rand.nextInt(8) - rand.nextInt(8);
            int y = worldIn.getHeight(x, z) + rand.nextInt(4) - rand.nextInt(4);
            BlockPos pos = new BlockPos(x, y, z);
            if (xStart < x && x < xEnd && zStart < z && z < zEnd
                    && worldIn.isAirBlock(pos)
                    && (!worldIn.provider.isNether() || pos.getY() < 255)
                    && mFlower.canSustainBush(worldIn.getBlockState(pos.down()))) {
                if (rand.nextDouble() <= probability) {
                    worldIn.setBlockState(pos, mState, 2);
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
