package com.ore.oreplant.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

/**
 * 配置
 * @author luqin2007
 */
public class FlowerConfig {
    public static boolean generate = true;
    public static double coalProbability      = 0.0030;
    public static double ironProbability      = 0.0020;
    public static double redstoneProbability  = 0.0010;
    public static double goldProbability      = 0.0010;
    public static double quartzProbability    = 0.0010;
    public static double obsidianProbability  = 0.0010;
    public static double glowstoneProbability = 0.0010;
    public static double lapisProbability     = 0.0005;
    public static double diamondProbability   = 0.0001;
    public static double emeraldProbability   = 0.0001;
    public static int coalCount      = 10;
    public static int ironCount      =  7;
    public static int redstoneCount  =  5;
    public static int goldCount      =  5;
    public static int quartzCount    =  5;
    public static int obsidianCount  =  5;
    public static int glowstoneCount =  5;
    public static int lapisCount     =  3;
    public static int diamondCount   =  1;
    public static int emeraldCount   =  1;

    public static void load(Configuration config) {
        generate = config.get("flower", "generate", true, "Natural Generate").getBoolean();
        coalProbability      = config.get("flower",     "coalProbability", 0.0030,      "Coal Flower Probability").getDouble();
        ironProbability      = config.get("flower",     "ironProbability", 0.0020,      "Iron Flower Probability").getDouble();
        redstoneProbability  = config.get("flower", "redstoneProbability", 0.0010,  "Redstone Flower Probability").getDouble();
        goldProbability      = config.get("flower",     "goldProbability", 0.0010,      "Gold Flower Probability").getDouble();
        quartzProbability    = config.get("flower",   "quartzProbability", 0.0010,    "Quartz Flower Probability").getDouble();
        obsidianProbability  = config.get("flower", "obsidianProbability", 0.0010,  "Obsidian Flower Probability").getDouble();
        glowstoneProbability = config.get("flower","glowstoneProbability", 0.0010, "Glowstone Flower Probability").getDouble();
        lapisProbability     = config.get("flower",    "lapisProbability", 0.0005,     "Lapis Flower Probability").getDouble();
        diamondProbability   = config.get("flower",  "diamondProbability", 0.0001,   "Diamond Flower Probability").getDouble();
        emeraldProbability   = config.get("flower",  "emeraldProbability", 0.0001,   "Emerald Flower Probability").getDouble();
        coalCount      = config.get("flower",     "coalCount", 10,      "Max Coal Flower Count Per Chunk").getInt();
        ironCount      = config.get("flower",     "ironCount",  7,      "Max Iron Flower Count Per Chunk").getInt();
        redstoneCount  = config.get("flower", "redstoneCount",  5,  "Max Redstone Flower Count Per Chunk").getInt();
        goldCount      = config.get("flower",     "goldCount",  5,      "Max Gold Flower Count Per Chunk").getInt();
        quartzCount    = config.get("flower",   "quartzCount",  5,    "Max Quartz Flower Count Per Chunk").getInt();
        obsidianCount  = config.get("flower", "obsidianCount",  5,  "Max Obsidian Flower Count Per Chunk").getInt();
        glowstoneCount = config.get("flower","glowstoneCount",  5, "Max Glowstone Flower Count Per Chunk").getInt();
        lapisCount     = config.get("flower",    "lapisCount",  3,     "Max Lapis Flower Count Per Chunk").getInt();
        diamondCount   = config.get("flower",  "diamondCount",  1,   "Max Diamond Flower Count Per Chunk").getInt();
        emeraldCount   = config.get("flower",  "emeraldCount",  1,   "Max Emerald Flower Count Per Chunk").getInt();
    }
}
