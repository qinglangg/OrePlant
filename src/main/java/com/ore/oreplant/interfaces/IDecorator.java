package com.ore.oreplant.generator;

import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public interface IGeneratorProvider {

    WorldGenerator getGenerator();

    DecorateBiomeEvent.Decorate.EventType getType();

    boolean canSpawn();
}
