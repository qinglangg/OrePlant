package com.ore.oreplant.event;

import com.ore.oreplant.Register;
import com.ore.oreplant.interfaces.IDecorator;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import java.util.Random;

/**
 * 世界生成相关事件
 * @author luqin2007
 */
public class GeneratorHandler {

    @SubscribeEvent
    public void onGenerator(DecorateBiomeEvent.Post event) {
        World world = event.world;
        if (!world.isRemote) {
            if (world.getBiomeGenForCoords(event.chunkX, event.chunkZ).theBiomeDecorator.currentWorld != null) {
                System.out.println("Warn: Already decorating!!");
                return;
            }
            Random rand = event.rand;
            for (Block block : Register.BLOCKS) {
                Chunk chunk = event.world.getChunkFromChunkCoords(event.chunkX, event.chunkZ);
                if (block instanceof IDecorator && ((IDecorator) block).canDecorator(world, rand, chunk.xPosition, 0, chunk.zPosition, event.chunkX, event.chunkZ)) {
                    ((IDecorator) block).decorate(world, rand, chunk.xPosition, 0, chunk.zPosition);
                }
            }
        }
    }
}
