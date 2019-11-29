package com.ore.oreplant.interfaces;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * 用于世界生成 Decorator
 * 目前用于 DecorateBiomeEvent.Post 事件中调用
 * @author luqin2007
 */
public interface IDecorator {

    /**
     * 生成
     * 一般使用 {@link net.minecraft.world.gen.feature.WorldGenerator#generate(World, Random, BlockPos)}
     * @param world 所在世界
     * @param rand 随机数
     * @param pos 所在区块起点
     */
    void decorate(World world, Random rand, BlockPos pos);

    /**
     * 判断是否可是生成
     * 一般使用 {@link net.minecraftforge.event.terraingen.TerrainGen#decorate(World, Random, ChunkPos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType)} 判断
     * @param world 所在世界
     * @param rand 随机数
     * @param pos 所在区块起点
     * @param chunkPos 所在区块
     * @return 是否已经生成
     */
    boolean canDecorator(World world, Random rand, BlockPos pos, ChunkPos chunkPos);
}
