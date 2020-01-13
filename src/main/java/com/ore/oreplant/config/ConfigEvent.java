package com.ore.oreplant.config;

import com.ore.oreplant.Register;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author luqin2007
 */
@Mod.EventBusSubscriber(value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class ConfigEvent {

    /**
     * 当配置文件改变时触发
     * @param event 事件
     */
    @SubscribeEvent
    public static void onConfigurationChanged(ConfigChangedEvent.PostConfigChangedEvent event) {
        if (ConfigNetwork.SI.contains(event.getModID())) {
            Register.channel.sendToServer(new ConfigNetwork(event.getModID()));
        }
    }
}
