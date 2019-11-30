package com.ore.oreplant.interfaces;

import net.minecraftforge.event.world.BlockEvent;

/**
 * 当方块破坏收集掉落物时调用
 * 目前在 BlockEvent.HarvestDropsEvent 中调用
 * @author luqin2007
 */
public interface IDropEvent {

    /**
     * 掉落触发
     * @param event 事件
     */
    void onDrop(BlockEvent.HarvestDropsEvent event);
}
