package com.ore.oreplant.event;

import com.elementtimes.elementcore.api.common.ECModContainer;
import com.ore.oreplant.interfaces.IDecorator;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * 世界生成相关事件
 * @author luqin2007
 */
@Mod.EventBusSubscriber
public class GeneratorHandler {

    @SubscribeEvent
    public static void onTreeGenerator(DecorateBiomeEvent.Post event) {
        World world = event.getWorld();
        if (!world.isRemote) {
            Random rand = event.getRand();
            ChunkPos chunkPos = event.getChunkPos();
            BlockPos pos = chunkPos.getBlock(0, 0, 0);
            for (ECModContainer container : ECModContainer.MODS.values()) {
                for (Block block : container.elements.blocks.values()) {
                    if (block instanceof IDecorator && ((IDecorator) block).canDecorator(world, rand, pos, chunkPos)) {
                        ((IDecorator) block).decorate(world, rand, pos);
                    }
                }
            }
        }
    }
}
