package com.ore.oreplant.oreblock;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.generator.SimpleOreGenerator;
import com.ore.oreplant.interfaces.IOreGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.gen.feature.WorldGenerator;

public class Diamond_ore1 extends Block implements IOreGenerator {

    WorldGenerator mGenerator;

    public Diamond_ore1() {
        super(Material.ROCK);
        setHardness(10f);
        setResistance(6f);
        setCreativeTab(OreTabs.TAB);
        setHarvestLevel("pickaxe", 2);
        mGenerator = new SimpleOreGenerator(getDefaultState());
    }

    @Override
    public WorldGenerator getOreGenerator() {
        return mGenerator;
    }
}
