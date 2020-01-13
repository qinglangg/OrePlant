package com.ore.oreplant.render;

import com.google.common.collect.ImmutableMap;
import com.ore.oreplant.plants.PumpkinStem;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collections;

/**
 * 南瓜藤材质重定向
 * @author luqin2007
 */
@SideOnly(Side.CLIENT)
public class PumpkinStemMap extends StateMapperBase {

    public static IBlockState STEM_STATE = Blocks.PUMPKIN_STEM.getDefaultState();

    @Override
    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
        EnumFacing facing = state.getValue(PumpkinStem.FACING);
        if (facing == EnumFacing.UP) {
            ImmutableMap<IProperty<?>, Comparable<?>> properties = state.getProperties();
            return new ModelResourceLocation(Block.REGISTRY.getNameForObject(STEM_STATE.getBlock()), getPropertyString(properties));
        } else {
            return new ModelResourceLocation(Block.REGISTRY.getNameForObject(STEM_STATE.getBlock()), getPropertyString(Collections.singletonMap(PumpkinStem.FACING, facing)));
        }
    }
}
