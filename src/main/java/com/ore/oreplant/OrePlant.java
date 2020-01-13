package com.ore.oreplant;

import com.ore.oreplant.config.ConfigNetwork;
import com.ore.oreplant.config.Configuration;
import com.ore.oreplant.event.OreHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author 深圳市咕咕咕科技有限公司-我的世界矿石系列制作组版权所有
 */
@Mod(modid = OrePlant.MODID, name = OrePlant.NAME, version = OrePlant.VERSION, guiFactory = "com.ore.oreplant.config.ConfigGui")
public class OrePlant
{
    public static final String MODID = "oreplant";
    public static final String NAME = "Ore Plant";
    public static final String VERSION = "1.2.0";

    public OrePlant() {
        ConfigNetwork.register(MODID, Configuration::read, Configuration::write, Configuration::reload);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Register.network();
        MinecraftForge.ORE_GEN_BUS.register(new OreHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Register.smelt();
    }
}
