package com.ore.oreplant.config;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 用于同步客户端与服务端的配置文件
 * @author luqin2007
 */
public class ConfigNetwork implements IMessage, IMessageHandler<ConfigNetwork, IMessage> {

    private static final Consumer<Object> EMPTY = (o) -> {};

    private static Map<String, Consumer<? super ByteBuf>> FB = new HashMap<>();
    private static Map<String, Consumer<? super ByteBuf>> TB = new HashMap<>();
    private static Map<String, Consumer<? super MessageContext>> R = new HashMap<>();
    static List<String> SI = new ArrayList<>();

    /**
     * 注册配置文件同步支持
     * @param id 配置文件所在 mod id
     * @param fromBytes fromBytes 方法中调用，用于将配置写入服务端
     * @param toBytes toBytes 方法中调用，用于从客户端读取配置
     * @param reload 服务端保存配置文件后调用，用于更新数据
     */
    public static void register(String id, Consumer<? super ByteBuf> fromBytes, Consumer<? super ByteBuf> toBytes, Consumer<? super MessageContext> reload) {
        SI.add(id);
        FB.put(id, fromBytes);
        TB.put(id, toBytes);
        R.put(id, reload);
    }

    private String id;

    public ConfigNetwork(String id) {
        this.id = id;
    }

    public ConfigNetwork() {}

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
    public IMessage onMessage(ConfigNetwork message, MessageContext ctx) {
        ConfigManager.sync(id, Config.Type.INSTANCE);
        R.getOrDefault(id, EMPTY).accept(ctx);
        return null;
    }
}
