package com.ore.oreplant.render;

import com.ore.oreplant.OrePlant;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LeafMap extends StateMapperBase {
    public static ResourceLocation LEAF = new ResourceLocation(OrePlant.MODID, "leaf");

    @Override
    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
        return new ModelResourceLocation(LEAF, "inventory");
    }
}
