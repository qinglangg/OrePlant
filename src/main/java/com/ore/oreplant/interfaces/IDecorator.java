package com.ore.oreplant.interfaces;

import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

import java.util.Random;

/**
 * 用于世界生成 Decorator
 * 目前用于 DecorateBiomeEvent.Post 事件中调用
 * @author luqin2007
 */
public interface IDecorator {

    /**
     * 生成
     * 一般使用 {@link net.minecraft.world.gen.feature.WorldGenerator#generate(World, Random, int, int, int)}
     * @param world 所在世界
     * @param rand 随机数
     * @param x x
     * @param y y
     * @param z z
     */
    void decorate(World world, Random rand, int x, int y, int z);

    /**
     * 判断是否可是生成
     * 一般使用 {@link net.minecraftforge.event.terraingen.TerrainGen#decorate(World, Random, int, int, DecorateBiomeEvent.Decorate.EventType)} 判断
     * @param world 所在世界
     * @param rand 随机数
     * @return 是否已经生成
     */
    boolean canDecorator(World world, Random rand, int x, int y, int z, int chunkX, int chunkZ);
}
