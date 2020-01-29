package com.ore.oreplant.config;

import net.minecraftforge.common.config.Configuration;

/**
 * 配置
 * @author luqin2007
 */
public class VillageConfig {

    public static double probability = 0.003;
    public static void load(Configuration config) {
//        probability = config.get(Configuration.CATEGORY_GENERAL, "probability", 0.003, "Generate Probability").getDouble();
    }
}
