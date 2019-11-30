package com.ore.oreplant.event;

import com.elementtimes.elementcore.api.common.ECModContainer;
import com.ore.oreplant.interfaces.IDecorator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Random;

/**
 * 世界生成相关事件
 * @author luqin2007
 */
public class GeneratorHandler {

    @SubscribeEvent
    public void onTreeGenerator(DecorateBiomeEvent.Post event) {

        World world = event.world;
        if (!world.isRemote) {
            Random rand = event.rand;
            for (ECModContainer container : ECModContainer.MODS.values()) {
                for (Pair<String, Block> blockPair : container.elements.blocks.values()) {
                    Block block = blockPair.getValue();
                    Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX, event.chunkZ);
                    if (block instanceof IDecorator && ((IDecorator) block).canDecorator(world, rand, chunk.xPosition, 0, chunk.zPosition, event.chunkX, event.chunkZ)) {
                        ((IDecorator) block).decorate(world, rand, chunk.xPosition, 0, chunk.zPosition);
                    }
                }
            }
        }
    }
}
