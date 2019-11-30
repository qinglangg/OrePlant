package com.ore.oreplant.ores;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

import com.ore.oreplant.OreTabs;

/**
 * @author 卿岚
 */
public class Gold_ore2 extends Block
{
	public Gold_ore2()
	{
		super(Material.rock);
		setCreativeTab(OreTabs.TAB);
        setHardness(8.0F); 
        setResistance(5.0F);
		setBlockTextureName("oreplant:gold_ore");
        setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Items.gold_ingot;
	}

	@Override
	public int quantityDropped(Random rand){
		return rand.nextInt(3) + 2;
	}
}
