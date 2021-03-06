package com.ore.oreplant.generator;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

/**
 * 用于生成树
 * @author luqin2007
 */
public class TreeGrowGenerator extends WorldGenTrees {

    public TreeGrowGenerator(BlockLog wood, BlockLeaves leaf) {
        super(true, 4, wood.getDefaultState(), leaf.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.TRUE).withProperty(BlockLeaves.DECAYABLE, Boolean.TRUE), false);
    }

    @Override
    public boolean generate( World worldIn, Random rand, BlockPos position) {
        return super.generate(worldIn, rand, worldIn.getHeight(position));
    }
}
