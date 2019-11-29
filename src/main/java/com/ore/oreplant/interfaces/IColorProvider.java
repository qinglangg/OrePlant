package com.ore.oreplant.interfaces;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * 用于获取颜色代码，目前用于 IItemColor, IBlockColor
 * @author luqin2007
 */
public interface IColorProvider {

    /**
     * 获取颜色
     * @param world 所在世界
     * @param state 方块状态
     * @param pos 方块位置
     * @param stack 物品栈
     * @return 颜色
     */
    int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack);
}
