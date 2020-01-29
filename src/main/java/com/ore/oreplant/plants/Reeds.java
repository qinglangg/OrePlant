package com.ore.oreplant.plants;

import com.google.common.collect.Lists;
import com.ore.oreplant.OrePlant;
import com.ore.oreplant.config.ReedConfig;
import com.ore.oreplant.generator.ReedGenerator;
import com.ore.oreplant.interfaces.IDecorator;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.DoubleSupplier;

/**
 * 甘蔗
 * @author luqin2007
 */
public class Reeds extends BlockReed implements IDecorator {

    private final Block colorBlock;
    private ReedGenerator generator;
    private String name;

    public Reeds(Block color, String name, DoubleSupplier probability) {
        this.colorBlock = color;
        setCreativeTab(OrePlant.TAB);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        setBlockTextureName("reeds");
        setBlockName(OrePlant.MODID + "." + name);
        disableStats();
        this.name = name;
        this.generator = new ReedGenerator(this, probability);
    }

    public static class ItemReeds extends ItemBlock {

        public ItemReeds(Block p_i45328_1_) {
            super(p_i45328_1_);
        }

        @Override
        public int getColorFromItemStack(ItemStack p_82790_1_, int p_82790_2_) {
            return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? Block.getBlockFromItem(p_82790_1_.getItem()).getBlockColor() : super.getColorFromItemStack(p_82790_1_, p_82790_2_);
        }
    }

    @Override
    public void updateTick(World worldIn, int x, int y, int z, Random random) {
        if (worldIn.getBlock(x, y - 1, z) == this || func_150170_e(worldIn, x, y, z)) {
            if (worldIn.isAirBlock(x, y + 1, z)) {
                int i = 1;
                int posY = y - 1;
                while (worldIn.getBlock(x, posY, z) == this) {
                    i++;
                    posY--;
                }
                if (i < 3) {
                    int j = worldIn.getBlockMetadata(x, y, z);
                    if (j >= 15) {
                        worldIn.setBlock(x, y + 1, z, this);
                        worldIn.setBlockMetadataWithNotify(x, y + 1, z, 0, 4);
                    } else {
                        worldIn.setBlockMetadataWithNotify(x, y, z, j + 1, 4);
                    }
                }
            }
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        return Lists.newArrayList(new ItemStack(this));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess world, int x, int y, int z) {
        return colorBlock.getMapColor(0).colorValue;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return colorBlock.getMapColor(0).colorValue;
    }

    @Override
    public int getRenderColor(int p_149741_1_) {
        return super.getRenderColor(p_149741_1_);
    }

    @Override
    public void decorate(World world, Random rand, int x, int y, int z) {
        generator.generate(world, rand, x + rand.nextInt(16), world.getHeightValue(x, z), z + rand.nextInt(16));
    }

    @Override
    public boolean canDecorator(World world, Random rand, int x, int y, int z, int chunkX, int chunkZ) {
        return ReedConfig.generate && TerrainGen.decorate(world, rand, chunkX, chunkZ, DecorateBiomeEvent.Decorate.EventType.REED);
    }

    public String getName() {
        return name;
    }
}
