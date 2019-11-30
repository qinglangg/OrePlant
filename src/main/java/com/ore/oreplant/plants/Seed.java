package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.interfaces.IDropEvent;
import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

public class Seed extends ItemSeeds implements IDropEvent {
    public Seed(Block crop, String key) {
        super(crop, Blocks.farmland);
        setCreativeTab(OreTabs.TAB);
        setTextureName("oreplant:" + key);
    }

    @Override
    public void onDrop(BlockEvent.HarvestDropsEvent event) {
        if (Loader.isModLoaded("oreflower") && event.block == Blocks.tallgrass && event.world.rand.nextFloat() <= .001f && event.drops.size() <= 3) {
            event.drops.add(new ItemStack(this));
        }
    }
}
