package com.ore.oreplant.generator;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

/**
 * 用于矿物生成
 * @author luqin2007
 */
public class SimpleOreGenerator extends WorldGenerator {
    private final int yRange = 48;
    private final int yMin = 16;
    private final int times = 6;
    private final float probability = .6f;
    private final int[] dimBlackList = new int[0];
    private final int[] dimWhiteList = new int[] {0};

    private final WorldGenMinable mWorldGenerator;

    public SimpleOreGenerator(IBlockState block) {
        this.mWorldGenerator = new WorldGenMinable(block, 8);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (canGenerator(worldIn.provider.getDimension())) {
            for (int i = 0; i < times; i++) {
                int x = position.getX() + 8;
                int y = yMin + rand.nextInt(yRange);
                int z = position.getZ() + 8;
                if (rand.nextFloat() <= probability) {
                    mWorldGenerator.generate(worldIn, rand, new BlockPos(x, y, z));
                }
            }
        }
        return true;
    }

    private boolean canGenerator(int dimId) {
        boolean canGenerator = true;

        if (dimWhiteList.length > 0) {
            canGenerator = ArrayUtils.contains(dimWhiteList, dimId);
        }

        if (canGenerator && dimBlackList.length > 0) {
            canGenerator = !ArrayUtils.contains(dimBlackList, dimId);
        }

        return canGenerator;
    }
}
