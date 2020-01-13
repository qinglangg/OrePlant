package com.ore.oreplant.interfaces;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IStateMapProvider {

    @SideOnly(Side.CLIENT)
    net.minecraft.client.renderer.block.statemap.StateMapperBase getStateMapper();
}
