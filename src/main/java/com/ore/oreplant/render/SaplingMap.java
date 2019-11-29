package com.ore.oreplant.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * 树苗材质重定向
 * @author luqin2007
 */
@SideOnly(Side.CLIENT)
@SuppressWarnings("unused")
public class SaplingMap extends StateMapperBase {
    @Override
    @Nonnull
    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
        return new ModelResourceLocation(Objects.requireNonNull(state.getBlock().getRegistryName()), "inventory");
    }
}
