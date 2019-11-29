package com.ore.oreplant.event;

import com.elementtimes.elementcore.api.common.ECModContainer;
import com.ore.oreplant.interfaces.IDropEvent;
import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 掉落相关事件
 * @author luqin2007
 */
@Mod.EventBusSubscriber
public class DropHandler {

    @SubscribeEvent
    public static void onDrop(BlockEvent.HarvestDropsEvent event) {
        if (!event.getWorld().isRemote) {
            for (ECModContainer container : ECModContainer.MODS.values()) {
                for (Item item : container.elements.items.values()) {
                    if (item instanceof IDropEvent) {
                        ((IDropEvent) item).onDrop(event);
                    }
                }
            }
        }
    }
}
