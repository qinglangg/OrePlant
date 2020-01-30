package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OrePlant;
import com.ore.oreplant.config.TreeConfig;
import com.ore.oreplant.generator.TreeGenerator;
import com.ore.oreplant.interfaces.IDecorator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class Sapling extends BlockSapling implements IDecorator {

    private Supplier<Block> wood, leaf;
    private TreeGenerator grower, decorator;
    private DoubleSupplier probabilityGetter;
    private IIcon icon;

    public Sapling(String textureKey, Supplier<Block> wood, Supplier<Block> leaf, DoubleSupplier probabilityGetter) {
        super();
        this.textureName = textureKey;
        setCreativeTab(OrePlant.TAB);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        this.wood = wood;
        this.leaf = leaf;
        grower = null;
        decorator = null;
        this.probabilityGetter = probabilityGetter;
    }

    // generate
    @Override
    public void func_149878_d(World worldIn, int x, int y, int z, Random rand) {
        if (net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, x, y, z)) {
            worldIn.setBlockToAir(x, y, z);
            if (!getGrower().generate(worldIn, rand, x, y, z) && worldIn.isAirBlock(x, y, z)) {
                worldIn.setBlock(x, y, z, this);
            }
        }
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        p_149666_3_.add(new ItemStack(this));
    }

    @Override
    public int damageDropped(int p_149692_1_) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        icon = register.registerIcon("oreplant:sapling_" + textureName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return icon;
    }

    public TreeGenerator getGrower() {
        if (grower == null) {
            grower = new TreeGenerator(true, (BlockLog) wood.get(), (BlockLeaves) leaf.get(), this);
        }
        return grower;
    }

    public TreeGenerator getDecorator() {
        if (decorator == null) {
            decorator = new TreeGenerator(false, (BlockLog) wood.get(), (BlockLeaves) leaf.get(), this, probabilityGetter);
        }
        return decorator;
    }

    @Override
    public void decorate(World world, Random rand, int x, int y, int z) {
        getDecorator().generate(world, rand, x + rand.nextInt(16), world.getHeightValue(x, z), z + rand.nextInt(16));
    }

    @Override
    public boolean canDecorator(World world, Random rand, int x, int y, int z, int chunkX, int chunkZ) {
        return TreeConfig.generate && TerrainGen.saplingGrowTree(world, rand, x, y, z);
    }
}
