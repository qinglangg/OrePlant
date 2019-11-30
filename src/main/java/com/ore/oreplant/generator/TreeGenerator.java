package com.ore.oreplant.generator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSapling;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;
import java.util.function.DoubleSupplier;

/**
 * 用于生成树
 * @author luqin2007
 */
public class TreeGenerator extends WorldGenTrees {

    private Block wood, leaf;
    private BlockSapling sapling;
    private int minHeight;
    private DoubleSupplier probabilityGetter;
    private boolean isGrow;

    public TreeGenerator(boolean notify, BlockLog wood, BlockLeaves leaf, BlockSapling sapling) {
        this(notify, wood, leaf, sapling, () -> 1);
    }

    public TreeGenerator(boolean notify, BlockLog wood, BlockLeaves leaf, BlockSapling sapling, DoubleSupplier probability) {
        super(notify, 4, 0, 0, false);
        this.wood = wood;
        this.leaf = leaf;
        this.sapling = sapling;
        this.minHeight = 4;
        this.probabilityGetter = probability;
        this.isGrow = notify;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (random.nextDouble() > probabilityGetter.getAsDouble()) return false;
        if (!isGrow) {
            int cX = x % 16, cZ = z % 16;
            if ((cX <= 4 || cX >= 12) && (cZ <= 4 || cZ >= 12)) return false;
        }
        int height = random.nextInt(3) + minHeight;
        boolean flag = true;
        if (y >= 1 && y + height + 1 <= 256) {
            byte radius;
            int posZ;
            Block block;
            for (int posY = y; posY <= y + 1 + height; ++posY) {
                radius = 1;
                if (posY == y) {
                    radius = 0;
                }
                if (posY >= y + 1 + height - 2) {
                    radius = 2;
                }
                for (int posX = x - radius; posX <= x + radius && flag; ++posX) {
                    for (posZ = z - radius; posZ <= z + radius && flag; ++posZ) {
                        if (posY >= 0 && posY < 256) {
                            if (!this.isReplaceable(world, posX, posY, posZ)) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                Block base = world.getBlock(x, y - 1, z);
                boolean isSoil = base.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, sapling);
                if (isSoil && y < 256 - height - 1) {
                    base.onPlantGrow(world, x, y - 1, z, x, y, z);
                    radius = 3;
                    byte b1 = 0;
                    int l1;
                    int i2;
                    int j2;
                    int i3;

                    for (posZ = y - radius + height; posZ <= y + height; ++posZ)
                    {
                        i3 = posZ - (y + height);
                        l1 = b1 + 1 - i3 / 2;

                        for (i2 = x - l1; i2 <= x + l1; ++i2)
                        {
                            j2 = i2 - x;

                            for (int k2 = z - l1; k2 <= z + l1; ++k2)
                            {
                                int l2 = k2 - z;

                                if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || random.nextInt(2) != 0 && i3 != 0)
                                {
                                    Block block1 = world.getBlock(i2, posZ, k2);

                                    if (block1.isAir(world, i2, posZ, k2) || block1.isLeaves(world, i2, posZ, k2))
                                    {
                                        this.setBlockAndNotifyAdequately(world, i2, posZ, k2, leaf, 0);
                                    }
                                }
                            }
                        }
                    }

                    for (posZ = 0; posZ < height; ++posZ)
                    {
                        block = world.getBlock(x, y + posZ, z);

                        if (block.isAir(world, x, y + posZ, z) || block.isLeaves(world, x, y + posZ, z))
                        {
                            this.setBlockAndNotifyAdequately(world, x, y + posZ, z, wood, 0);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}
