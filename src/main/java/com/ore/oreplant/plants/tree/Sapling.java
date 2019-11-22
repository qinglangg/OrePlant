package com.ore.oreplant.plants.tree;

import com.ore.oreplant.OreTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Sapling extends BlockSapling {

    private Supplier<WorldGenAbstractTree> generator;
    private IIcon icon;

    public Sapling(String textureKey, Supplier<WorldGenAbstractTree> generator) {
        super();
        this.textureName = textureKey;
        this.generator = generator;
        setCreativeTab(OreTabs.TAB);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
    }

    // generate
    @Override
    public void func_149878_d(World worldIn, int x, int y, int z, Random rand) {
        if (net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, x, y, z)) {
            worldIn.setBlockToAir(x, y, z);
            if (!generator.get().generate(worldIn, rand, x, y, z) && worldIn.isAirBlock(x, y, z)) {
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
}
