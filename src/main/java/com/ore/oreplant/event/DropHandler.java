package com.ore.oreplant.event;

import com.ore.oreplant.Register;
import com.ore.oreplant.interfaces.IDropEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraftforge.event.world.BlockEvent;

/**
 * 掉落相关事件
 * @author luqin2007
 */
public class DropHandler {

    @SubscribeEvent
    public void onDrop(BlockEvent.HarvestDropsEvent event) {
        if (!event.world.isRemote) {
            for (Item item : Register.ITEMS) {
                if (item instanceof IDropEvent) {
                    ((IDropEvent) item).onDrop(event);
                }
            }
        }
    }
}
