package com.ore.oreplant.config;

import com.ore.oreplant.OrePlant;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

@Config(modid = OrePlant.MODID)
public class Configuration {

    public static void read(ByteBuf buf) {}
    public static void write(ByteBuf buf) {}
    public static void reload(MessageContext buf) {}
}
