package com.ore.oreplant.plants;

import com.ore.oreplant.OreTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Wheat extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private IIcon[] textures;
    private String textureKey;
    private final Supplier<ItemStack> drop;
    private final Supplier<ItemStack> seed;

    public Wheat(String textureKey, Supplier<ItemStack> drop, Supplier<ItemStack> seed) {
        this.drop = drop;
        this.seed = seed;
        this.textureKey = textureKey;
        setCreativeTab(OreTabs.TAB);
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) { }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> items = new ArrayList<>();
        items.add(seed.get());
        if (metadata >= 3) {
            items.add(drop.get());
        }
        return items;
    }

    @Override
    public boolean onBlockActivated(World worldIn, int x, int y, int z, EntityPlayer playerIn, int p_149727_6_, float hitX, float hitY, float hitZ) {
        int metadata = getPlantMetadata(worldIn, x, y, z);
        if (!worldIn.isRemote) {
            if (metadata >= 3) {
                worldIn.setBlockMetadataWithNotify(x, y, z, 0, 2);
                List<ItemStack> stacks = getDrops(worldIn, x, y, z, metadata, 0);
                for (ItemStack stack : stacks) {
                    EntityItem item = new EntityItem(worldIn, x, y, z, stack);
                    worldIn.spawnEntityInWorld(item);
                }
                EntityXPOrb xpOrb = new EntityXPOrb(worldIn, x, y, z, (int) Math.sqrt(stacks.size()));
                worldIn.spawnEntityInWorld(xpOrb);
            } else if (playerIn.getHeldItem() != null && playerIn.getHeldItem().getItem() == Items.dye && playerIn.getHeldItem().getItemDamage() == 15){
                ItemDye.applyBonemeal(playerIn.getHeldItem(), worldIn, x, y, z, playerIn);
            }
        }
        return true;
    }

    @Override
    public void updateTick(World worldIn, int x, int y, int z, Random rand) {
        this.checkAndDropBlock(worldIn, x, y, z);
        if (worldIn.getBlockLightValue(x, y + 1, z) >= 9)
        {
            int l = worldIn.getBlockMetadata(x, y, z);

            if (l < 3) {
                float f = this.func_149864_n(worldIn, x, y, z);
                if (rand.nextInt((int)(25.0F / f) + 1) == 0) {
                    ++l;
                    worldIn.setBlockMetadataWithNotify(x, y, z, l, 2);
                }
            }
        }
    }

    /*
    不知道返回个啥破参数，判断 tick 的
     */
    private float func_149864_n(World worldIn, int x, int y, int z)
    {
        float f = 1.0F;
        Block block = worldIn.getBlock(x, y, z - 1);
        Block block1 = worldIn.getBlock(x, y, z + 1);
        Block block2 = worldIn.getBlock(x - 1, y, z);
        Block block3 = worldIn.getBlock(x + 1, y, z);
        Block block4 = worldIn.getBlock(x - 1, y, z - 1);
        Block block5 = worldIn.getBlock(x + 1, y, z - 1);
        Block block6 = worldIn.getBlock(x + 1, y, z + 1);
        Block block7 = worldIn.getBlock(x - 1, y, z + 1);
        boolean flag = block2 == this || block3 == this;
        boolean flag1 = block == this || block1 == this;
        boolean flag2 = block4 == this || block5 == this || block6 == this || block7 == this;
        for (int l = x - 1; l <= x + 1; ++l) {
            for (int i1 = z - 1; i1 <= z + 1; ++i1) {
                float f1 = 0.0F;
                if (worldIn.getBlock(l, y - 1, i1).canSustainPlant(worldIn, l, y - 1, i1, ForgeDirection.UP, this)) {
                    f1 = 1.0F;
                    if (worldIn.getBlock(l, y - 1, i1).isFertile(worldIn, l, y - 1, i1)) {
                        f1 = 3.0F;
                    }
                }
                if (l != x || i1 != z) {
                    f1 /= 4.0F;
                }
                f += f1;
            }
        }

        if (flag2 || flag && flag1) {
            f /= 2.0F;
        }

        return f;
    }

    // 成长？
    @Override
    public void func_149863_m(World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z) + 1;
        if (l > 3) {
            l = 3;
        }
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
    }

    // 长成？
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_) {
        return world.getBlockMetadata(x, y, z) != 3;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        textures = new IIcon[4];
        for (int i = 0; i < textures.length; i++) {
            textures[i] = register.registerIcon("oreplant:wheat_" + textureKey + "_" + i);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return textures[Math.max(0, Math.min(meta, 3))];
    }
}
