package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OreTabs;
import com.ore.oreplant.generator.TreeGenerators;
import com.ore.oreplant.interfaces.IDecorator;
import com.ore.oreplant.interfaces.IStateMapProvider;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;
import java.util.function.Supplier;

/**
 * 树苗
 * @author luqin2007
 */
public class Sapling extends BlockSapling implements IDecorator, IStateMapProvider {

    private static Object mapper = null;

    private Supplier<TreeGenerators> generatorSupplier;
    private TreeGenerators generator = null;

    public Sapling(Supplier<TreeGenerators> generatorSupplier) {
        super();
        this.generatorSupplier = generatorSupplier;
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
        //noinspection deprecation
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

    public TreeGenerators getGenerators() {
        if (generator == null) {
            generator = generatorSupplier.get();
        }
        return generator;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
    }
    @Override
    public void generateTree( World worldIn, BlockPos pos,  IBlockState state,  Random rand) {
        if (net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) {
            worldIn.setBlockToAir(pos);
            if (!getGenerators().getGrower().generate(worldIn, rand, pos) && worldIn.isAirBlock(pos)) {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        getGenerators().getDecorator().generate(world, rand, pos);
    }

    @Override
    public boolean canDecorator(World world, Random rand, BlockPos pos, ChunkPos chunkPos) {
        return getGenerators().getDecorator() != null && TerrainGen.saplingGrowTree(world, rand, pos);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public net.minecraft.client.renderer.block.statemap.StateMapperBase getStateMapper() {
        if (mapper == null) {
            mapper = new com.ore.oreplant.render.SaplingMap();
        }
        return (net.minecraft.client.renderer.block.statemap.StateMapperBase) mapper;
    }
}
