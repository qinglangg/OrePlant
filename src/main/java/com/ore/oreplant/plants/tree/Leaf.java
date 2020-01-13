package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.interfaces.IColorProvider;
import com.ore.oreplant.interfaces.IStateMapProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Random;
import java.util.function.Supplier;

/**
 * 树叶
 * @author luqin2007
 */
public class Leaf extends BlockLeaves implements IColorProvider, IStateMapProvider {

    private static Object mapper = null;

    private final Supplier<BlockSapling> sapling;
    private final IBlockState colorState;

    public Leaf(Block color, Supplier<BlockSapling> sapling) {
        setCreativeTab(OreTabs.TAB);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, true));
        this.sapling = sapling;
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getMinecraft();
            setGraphicsLevel(mc.gameSettings.fancyGraphics);
        }
        this.colorState = color.getDefaultState();
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY, (meta & 8) > 0);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        if (!state.getValue(DECAYABLE)) {
            i |= 4;
        }
        if (state.getValue(CHECK_DECAY)) {
            i |= 8;
        }
        return i;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, CHECK_DECAY, DECAYABLE);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(sapling.get());
    }

    @Override
    public NonNullList<ItemStack> onSheared( ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this));
    }

    @Override
    public int getColor(IBlockAccess world, IBlockState state, BlockPos pos, ItemStack stack) {
        return colorState.getMapColor(world, pos).colorValue;
    }

    @Override
    public net.minecraft.client.renderer.block.statemap.StateMapperBase getStateMapper() {
        if (mapper == null) {
            mapper = new com.ore.oreplant.render.LeafMap();
        }
        return (net.minecraft.client.renderer.block.statemap.StateMapperBase) mapper;
    }
}
