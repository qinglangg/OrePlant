package com.ore.oreplant.event;

import com.elementtimes.elementcore.api.common.ECModContainer;
import com.ore.oreplant.interfaces.IDropEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent;
import org.apache.commons.lang3.tuple.Pair;

/**
 * 掉落相关事件
 * @author luqin2007
 */
public class DropHandler {

    @SubscribeEvent
    public void onDrop(BlockEvent.HarvestDropsEvent event) {
        if (!event.world.isRemote) {
            for (ECModContainer container : ECModContainer.MODS.values()) {
                for (Pair<String, Item> items : container.elements.items.values()) {
                    if (items.getValue() instanceof IDropEvent) {
                        ((IDropEvent) items.getValue()).onDrop(event);
                    }
                }
            }
        }
    }
}
