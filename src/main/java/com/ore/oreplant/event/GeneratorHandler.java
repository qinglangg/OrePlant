package com.ore.oreplant.event;

import com.ore.oreplant.OrePlant;
import com.ore.oreplant.config.OPConfiguration;
import com.ore.oreplant.plants.Flower;
import com.ore.oreplant.plants.tree.Sapling;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

@Mod.EventBusSubscriber
public class GeneratorEventHandler {

    @SubscribeEvent
    public static void onTreeGenerator(DecorateBiomeEvent.Post event) {
        World world = event.getWorld();
        if (!world.isRemote) {
            Random rand = event.getRand();
            ChunkPos chunkPos = event.getChunkPos();
            BlockPos pos = chunkPos.getBlock(0, 0, 0);
            for (Block block : OrePlant.CONTAINER.elements.blocks.values()) {
                if (block instanceof Sapling && OPConfiguration.tree) {
                    Sapling sapling = (Sapling) block;
                    if (TerrainGen.saplingGrowTree(world, rand, pos)) {
                        sapling.getGenerators().decorator.generate(world, rand, pos);
                    }
                } else if (block instanceof Flower && OPConfiguration.flower) {
                    Flower flower = (Flower) block;
                    if (TerrainGen.decorate(world, rand, chunkPos, DecorateBiomeEvent.Decorate.EventType.FLOWERS)) {
                        flower.getGenerator().generate(world, rand, pos);
                    }
                }
            }
        }
    }
}
