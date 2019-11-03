package com.ore.oreplant;

import com.elementtimes.elementcore.ElementCore;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/**
 * @author 深圳市咕咕咕科技有限公司-我的世界矿石系列制作组版权所有
 */

@Mod(modid = OrePlant.MODID, name = OrePlant.NAME, version = OrePlant.VERSION, dependencies = "required-after:elementcore@[0.2.5,0.3.0)")
public class OrePlant
{
    public static final String MODID = "oreplant";
    public static final String NAME = "Ore Plant";
    public static final String VERSION = "1.1";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ElementCore.builder().disableDebugMessage().build(event);
    }
    @EventHandler
    public void Init(FMLInitializationEvent event) {      
    	OrePlantRecipe.init(event);
    }
}
