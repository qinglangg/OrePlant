package com.ore.oreplant.render;

import com.ore.oreplant.OrePlant;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * 树叶材质重定向
 * @author luqin2007
 */
@SideOnly(Side.CLIENT)
@SuppressWarnings("unused")
public class LeafMap extends StateMapperBase {
    public static ResourceLocation LEAF = new ResourceLocation(OrePlant.MODID, "leaf");

    @Override
    @Nonnull
    protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
        return new ModelResourceLocation(LEAF, "inventory");
    }
}
