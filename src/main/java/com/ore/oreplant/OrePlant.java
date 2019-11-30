package com.ore.oreplant;

import com.elementtimes.elementcore.ElementCore;
import com.ore.oreplant.event.DropHandler;
import com.ore.oreplant.event.GeneratorHandler;
import com.ore.oreplant.recipes.CraftingRecipes;
import com.ore.oreplant.recipes.SmeltRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = OrePlant.MODID, name = OrePlant.NAME, version = OrePlant.VERSION, dependencies = "required-after:elementcore")
public class OrePlant
{
    public static final String MODID = "oreplant";
    public static final String NAME = "Ore Plant";
    public static final String VERSION = "1.1.0";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ElementCore.builder().disableDebugMessage().disableDebugMessage().build(event);
        MinecraftForge.EVENT_BUS.register(new DropHandler());
        MinecraftForge.EVENT_BUS.register(new GeneratorHandler());
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
    	SmeltRecipe.init(event);
        CraftingRecipes.registerAll();
    }
}
