package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OreTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Supplier;

public class Sapling extends BlockSapling {

    private Supplier<WorldGenAbstractTree> generator;

    public Sapling(Supplier<WorldGenAbstractTree> generator) {
        super();
        this.generator = generator;
        setCreativeTab(OreTabs.TAB);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE, STAGE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        getDefaultState().withProperty(STAGE, (meta & 1) == 1 ? 1 : 0);
        return super.getStateFromMeta(meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(STAGE);
    }

    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(this.getUnlocalizedName() + ".name");
    }

    @Override
    public boolean isTypeAt(World worldIn, BlockPos pos, BlockPlanks.EnumType type) {
        return false;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
    }
    @Override
    public void generateTree(@Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state, @Nonnull Random rand) {
        if (net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) {
            worldIn.setBlockToAir(pos);
            if (!generator.get().generate(worldIn, rand, pos) && worldIn.isAirBlock(pos)) {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }
}
