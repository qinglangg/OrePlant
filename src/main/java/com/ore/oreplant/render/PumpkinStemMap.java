package com.ore.oreplant.render;

import com.ore.oreplant.plants.PumpkinStem;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collections;

@SideOnly(Side.CLIENT)
public class PumpkinStemMap extends StateMapperBase {

    public static IBlockState STEM_STATE = Blocks.PUMPKIN_STEM.getDefaultState();

    @Override
    protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
        EnumFacing facing = state.getValue(PumpkinStem.FACING);
        if (facing == EnumFacing.UP) {
            return new ModelResourceLocation(Block.REGISTRY.getNameForObject(STEM_STATE.getBlock()), this.getPropertyString(state.getProperties()));
        } else {
            return new ModelResourceLocation(Block.REGISTRY.getNameForObject(STEM_STATE.getBlock()), getPropertyString(Collections.singletonMap(PumpkinStem.FACING, facing)));
        }
    }
}
