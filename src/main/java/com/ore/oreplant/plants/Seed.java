package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.interfaces.IDropEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Loader;

/**
 * 种子
 * @author luqin2007
 */
public class Seed extends ItemSeeds implements IDropEvent {

    public Seed(Block crops) {
        super(crops, Blocks.FARMLAND);
        setCreativeTab(OreTabs.TAB);
    }

    @Override
    public void onDrop(BlockEvent.HarvestDropsEvent event) {
        if (Loader.isModLoaded("oreflower") && event.getState().getBlock() == Blocks.TALLGRASS && event.getWorld().rand.nextFloat() <= .001f && event.getDrops().size() <= 3) {
            event.getDrops().add(new ItemStack(this));
        }
    }
}
