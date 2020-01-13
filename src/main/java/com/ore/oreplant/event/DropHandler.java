package com.ore.oreplant.event;

import com.ore.oreplant.Register;
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
            for (Item item : Register.items.values()) {
                if (item instanceof IDropEvent) {
                    ((IDropEvent) item).onDrop(event);
                }
            }
        }
    }
}
