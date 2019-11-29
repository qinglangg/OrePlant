package com.ore.oreplant.generator;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
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

    public TreeGenerators(BlockLog wood, BlockLeaves leaf) {
        this.wood = wood;
        this.leaf = leaf;
        setGrower(new TreeGrowGenerator(wood, leaf));
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
