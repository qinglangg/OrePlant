package com.ore.oreplant.config;

import com.elementtimes.elementcore.api.annotation.ModNetwork;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@ModNetwork(handlerClass = "com.ore.oreplant.config.OPConfigNetwork", side = Side.SERVER)
public class OPConfigNetwork implements IMessage, IMessageHandler<OPConfigNetwork, IMessage> {

    private static final Consumer<Object> EMPTY = (o) -> {};

    private static Map<String, Consumer<? super ByteBuf>> FB = new HashMap<>();
    private static Map<String, Consumer<? super ByteBuf>> TB = new HashMap<>();
    private static Map<String, Consumer<? super MessageContext>> R = new HashMap<>();
    static List<String> SI = new ArrayList<>();

    public static void register(String id, Consumer<? super ByteBuf> fromBytes, Consumer<? super ByteBuf> toBytes, Consumer<? super MessageContext> reload) {
        SI.add(id);
        FB.put(id, fromBytes);
        TB.put(id, toBytes);
        R.put(id, reload);
    }

    private String id;

    public OPConfigNetwork(String id) {
        this.id = id;
    }

    public OPConfigNetwork() {}

    @Override
    public void fromBytes(ByteBuf buf) {
        id = ByteBufUtils.readUTF8String(buf);
        FB.getOrDefault(id, EMPTY).accept(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, id);
        TB.getOrDefault(id, EMPTY).accept(buf);
    }

    @Override
    public IMessage onMessage(OPConfigNetwork message, MessageContext ctx) {
        ConfigManager.sync(id, Config.Type.INSTANCE);
        R.getOrDefault(id, EMPTY).accept(ctx);
        return null;
    }
}
