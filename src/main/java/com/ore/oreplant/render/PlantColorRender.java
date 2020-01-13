package com.ore.oreplant.render;

import com.ore.oreplant.interfaces.IColorProvider;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 对于实现 IColorProvider 接口的物品和方块的染色
 * @author luqin2007
 */
@SideOnly(Side.CLIENT)
@SuppressWarnings("unused")
public class PlantColorRender implements IItemColor, IBlockColor {

    public static PlantColorRender INSTANCE = new PlantColorRender();

    @Override
    public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
        Block block = state.getBlock();
        if (block instanceof IColorProvider) {
            return ((IColorProvider) block).getColor(worldIn, state, pos, null);
        }
        return 0;
    }

    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        Item item = stack.getItem();
        if (item instanceof IColorProvider) {
            return ((IColorProvider) item).getColor(Minecraft.getMinecraft().world, null, null, stack);
        } else {
            Block block = Block.getBlockFromItem(item);
            if (block instanceof IColorProvider) {
                return ((IColorProvider) block).getColor(Minecraft.getMinecraft().world, block.getDefaultState(), null, stack);
            }
        }
        return 0;
    }
}
