package com.ore.oreplant.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

/**
 * 配置
 * @author luqin2007
 */
public class ReedConfig {

    public static boolean generate = true;
    public static double      coal = 0.030;
    public static double      iron = 0.020;
    public static double  redstone = 0.010;
    public static double      gold = 0.010;
    public static double    quartz = 0.010;
    public static double  obsidian = 0.010;
    public static double glowstone = 0.010;
    public static double     lapis = 0.005;
    public static double   diamond = 0.001;
    public static double   emerald = 0.001;

    public static void load(Configuration config) {
        generate = config.get("reed", "generate", true, "是否自然生成").getBoolean();
        coal = config.get("reed", "coal", 0.030, "煤甘蔗生成概率").getDouble();
        iron = config.get("reed", "iron", 0.020, "铁甘蔗生成概率").getDouble();
        redstone = config.get("reed", "redstone", 0.010, "红石甘蔗生成概率").getDouble();
        gold = config.get("reed", "gold", 0.010, "金甘蔗生成概率").getDouble();
        quartz = config.get("reed", "quartz", 0.010, "石英甘蔗生成概率").getDouble();
        obsidian = config.get("reed", "obsidian", 0.010, "黑曜石甘蔗生成概率").getDouble();
        glowstone = config.get("reed", "glowstone", 0.010, "萤石甘蔗生成概率").getDouble();
        lapis = config.get("reed", "lapis", 0.005, "青金石甘蔗生成概率").getDouble();
        diamond = config.get("reed", "diamond", 0.001, "钻石甘蔗生成概率").getDouble();
        emerald = config.get("reed", "emerald", 0.001, "绿宝石甘蔗生成概率").getDouble();
    }
}
