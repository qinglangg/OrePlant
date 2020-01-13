package com.ore.oreplant.event;

import com.ore.oreplant.Register;
import com.ore.oreplant.interfaces.IOreGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 处理世界生成事件
 * @author luqin2007
 */
public class OreHandler {

    @SubscribeEvent
    public void onGenerateOre(OreGenEvent.Post event) {
        for (Block block : Register.blocks.values()) {
            if (block instanceof IOreGenerator) {
                WorldGenerator generator = ((IOreGenerator) block).getOreGenerator();
                if (TerrainGen.generateOre(event.getWorld(), event.getRand(), generator, event.getPos(), OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
                    generator.generate(event.getWorld(), event.getRand(), event.getPos());
                }
            }
        }
    }
}
