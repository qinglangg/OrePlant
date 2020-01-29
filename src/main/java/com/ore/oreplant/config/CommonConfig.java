package com.ore.oreplant.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class CommonConfig {

    private static Configuration config;

    public static void load(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        ReedConfig.load(config);
        FlowerConfig.load(config);
        TreeConfig.load(config);
        VillageConfig.load(config);
        config.save();
    }
}
