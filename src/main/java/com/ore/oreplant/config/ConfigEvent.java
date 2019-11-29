package com.ore.oreplant.config;

import com.ore.oreplant.OrePlant;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
@SideOnly(Side.CLIENT)
public class OPConfigEvent {

    @SubscribeEvent
    public static void onConfigurationChanged(ConfigChangedEvent.PostConfigChangedEvent event) {
        if (OPConfigNetwork.SI.contains(event.getModID())) {
            OrePlant.CONTAINER.elements.channel.sendToServer(new OPConfigNetwork(event.getModID()));
        }
    }
}
