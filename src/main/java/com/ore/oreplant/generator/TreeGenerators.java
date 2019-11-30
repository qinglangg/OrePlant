package com.ore.oreplant.generator;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSapling;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 树苗生成
 * @author luqin2007
 */
@SuppressWarnings("unused")
public class TreeGenerators {

    private WorldGenerator grower = null;
    private WorldGenerator decorator = null;
    private boolean canGenerator = true;

    public BlockLog wood;
    public BlockLeaves leaf;
    public BlockSapling sapling;

    public TreeGenerators(BlockLog wood, BlockLeaves leaf, BlockSapling sapling) {
        this.wood = wood;
        this.leaf = leaf;
        this.sapling = sapling;
        setGrower(new TreeGenerator(true, wood, leaf, sapling));
    }

    public void setDecorator(WorldGenerator decorator) {
        this.decorator = decorator;
    }

    public WorldGenerator getDecorator() {
        return canGenerator ? decorator : null;
    }

    public void setGrower(WorldGenerator grower) {
        this.grower = grower;
    }

    public WorldGenerator getGrower() {
        return grower;
    }

    public void setCanGenerator(boolean canGenerator) {
        this.canGenerator = canGenerator;
    }
}
