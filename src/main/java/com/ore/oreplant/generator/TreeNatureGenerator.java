package com.ore.oreplant.generator;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.DoubleSupplier;

/**
 * 用于生成树
 * @author luqin2007
 */
public class TreeNatureGenerator extends WorldGenTrees {

    private static final int CHUNK_SIZE = 16;
    private static final int TREE_RADIUS = 3;
    private static final int MAX_SPAWN_COUNT = 1;

    private DoubleSupplier probability;

    public TreeNatureGenerator(BlockLog wood, BlockLeaves leaf, DoubleSupplier probabilityGetter) {
        super(false, 4, wood.getDefaultState(), leaf.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.TRUE).withProperty(BlockLeaves.DECAYABLE, Boolean.TRUE), false);
        probability = probabilityGetter;
    }

    @Override
    public boolean generate(@Nonnull World worldIn, Random rand, BlockPos position) {
        int spawnCount = 0;
        for (int x = position.getX() + TREE_RADIUS; spawnCount < MAX_SPAWN_COUNT && x < position.getX() + CHUNK_SIZE - TREE_RADIUS; x += TREE_RADIUS) {
            for (int z = position.getZ() + TREE_RADIUS; spawnCount < MAX_SPAWN_COUNT && z < position.getZ() + CHUNK_SIZE - TREE_RADIUS; z += TREE_RADIUS) {
                BlockPos pos = new BlockPos(x, worldIn.getHeight(x, z), z);
                if (rand.nextDouble() <= probability.getAsDouble()) {
                    if (super.generate(worldIn, rand, pos)) {
                        spawnCount++;
                    }
                }
            }
        }
        return spawnCount > 0;
    }
}
