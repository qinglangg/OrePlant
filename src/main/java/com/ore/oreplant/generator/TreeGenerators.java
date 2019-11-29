package com.ore.oreplant.generator;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;

import java.util.function.DoubleSupplier;

public class TreeGenerators {

    public final TreeGrowGenerator grower;
    public final TreeNatureGenerator decorator;

    public TreeGenerators(BlockLog wood, BlockLeaves leaf, DoubleSupplier probability) {
        grower = new TreeGrowGenerator(wood, leaf);
        decorator = new TreeNatureGenerator(wood, leaf, probability);
    }
}
