package com.ore.oreplant.oreblock;
import com.ore.oreplant.generator.SulfurGenerator;
import com.ore.oreplant.interfaces.IOreGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

import com.ore.oreplant.OreTabs;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * @author 卿岚
 */
public class Iron_ore extends Block implements IOreGenerator
{
	private WorldGenerator mGenerator;

	public Iron_ore()
	{
		super(Material.ROCK);
		setCreativeTab(OreTabs.TAB);
        setHardness(8.0F); 
        setResistance(5.0F); 
        setHarvestLevel("pickaxe", 1);
        mGenerator = new SulfurGenerator(this);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return Items.IRON_NUGGET;
	}

	@Override
	public int quantityDropped(Random rand){
		return rand.nextInt(3) + 2;
	}

	@Override
	public WorldGenerator getOreGenerator() {
		return mGenerator;
	}
}
