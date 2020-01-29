package com.ore.oreplant.structure;

import com.ore.oreplant.Crops;
import com.ore.oreplant.plants.Wheat;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

/**
 * 单对农田
 * @author luqin2007
 */
public class Field1 extends StructureVillagePieces.Village {
    
    protected Block[] cropTypes = new Block[4];

    @SuppressWarnings("unused")
    public Field1() { }

    public Field1(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox box, int mode) {
        super(start, type);
        this.coordBaseMode = mode;
        this.boundingBox = box;
        for (int i = 0; i < cropTypes.length; i++) {
            cropTypes[i] = getRandomCropType(rand);
        }
    }

    @Override
    public boolean addComponentParts(@Nonnull World worldIn, @Nonnull Random randomIn, @Nonnull StructureBoundingBox structureBoundingBoxIn) {
        System.out.println("spawn at: " + structureBoundingBoxIn.maxX + ", " + structureBoundingBoxIn.maxZ);
        if (field_143015_k < 0) {
            field_143015_k = getAverageGroundLevel(worldIn, structureBoundingBoxIn);
            if (field_143015_k < 0) {
                return true;
            }
            boundingBox.offset(0, field_143015_k - boundingBox.maxY + 4 - 1, 0);
        }

        fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 0, 12, 4, 8, Blocks.air, Blocks.air, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 1, 2, 0, 7, Blocks.farmland, Blocks.farmland, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 1, 5, 0, 7, Blocks.farmland, Blocks.farmland, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 0, 1, 8, 0, 7, Blocks.farmland, Blocks.farmland, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 0, 1, 11, 0, 7, Blocks.farmland, Blocks.farmland, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 0, 0, 8, Blocks.log, Blocks.log, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 0, 0, 6, 0, 8, Blocks.log, Blocks.log, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 0, 0, 12, 0, 8, Blocks.log, Blocks.log, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 11, 0, 0, Blocks.log, Blocks.log, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 8, 11, 0, 8, Blocks.log, Blocks.log, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 0, 1, 3, 0, 7, Blocks.water, Blocks.water, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 0, 1, 9, 0, 7, Blocks.water, Blocks.water, false);

        for (int i = 1; i <= 7; ++i) {
            int j = cropTypes[0] instanceof Wheat ? 3 : 7;
            int k = j / 3;
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[0], MathHelper.getRandomIntegerInRange(randomIn, k, j), 1, 1, i, structureBoundingBoxIn);
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[0], MathHelper.getRandomIntegerInRange(randomIn, k, j), 2, 1, i, structureBoundingBoxIn);
            int l = cropTypes[1] instanceof Wheat ? 3 : 7;
            int i1 = l / 3;
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[1], MathHelper.getRandomIntegerInRange(randomIn, i1, l), 4, 1, i, structureBoundingBoxIn);
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[1], MathHelper.getRandomIntegerInRange(randomIn, i1, l), 5, 1, i, structureBoundingBoxIn);
            int j1 = cropTypes[2] instanceof Wheat ? 3 : 7;
            int k1 = j1 / 3;
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[2], MathHelper.getRandomIntegerInRange(randomIn, k1, j1), 7, 1, i, structureBoundingBoxIn);
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[2], MathHelper.getRandomIntegerInRange(randomIn, k1, j1), 8, 1, i, structureBoundingBoxIn);
            int l1 = cropTypes[3] instanceof Wheat ? 3 : 7;
            int i2 = l1 / 3;
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[3], MathHelper.getRandomIntegerInRange(randomIn, i2, l1), 10, 1, i, structureBoundingBoxIn);
            placeBlockAtCurrentPosition(worldIn, this.cropTypes[3], MathHelper.getRandomIntegerInRange(randomIn, i2, l1), 11, 1, i, structureBoundingBoxIn);
        }

        for (int z = 0; z < 9; ++z) {
            for (int x = 0; x < 13; ++x) {
                clearCurrentPositionBlocksUpwards(worldIn, x, 4, z, structureBoundingBoxIn);
                func_151554_b(worldIn, Blocks.dirt, 0, x, -1, z, structureBoundingBoxIn);
            }
        }

        return true;
    }

    private Block getRandomCropType(Random random) {
        int r = random.nextInt(80);
        if (r < 20) {
            return Blocks.carrots;
        } else if (r < 40) {
            return Blocks.potatoes;
        } else if (r == 40){
            return Crops.wheatLapis;
        } else if (r == 41) {
            return Crops.wheatDiamond;
        } else if (r == 42) {
            return Crops.wheatEmerald;
        } else if (r < 50) {
            return Crops.wheatIron;
        } else if (r < 60) {
            return Crops.wheatCoal;
        } else if (r < 65) {
            return Crops.wheatGold;
        } else if (r < 70) {
            return Crops.wheatQuartz;
        } else if (r < 73) {
            return Crops.wheatRedstone;
        } else if (r < 77) {
            return Crops.wheatObsidian;
        } else {
            return Crops.wheatGlowstone;
        }
    }

    @Override
    protected void func_143012_a(NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        int[] ids = new int[cropTypes.length];
        for (int i = 0; i < cropTypes.length; i++) {
            ids[i] = Block.blockRegistry.getIDForObject(cropTypes[i]);
        }
        tagCompound.setIntArray("C", ids);
    }

    @Override
    protected void func_143011_b(NBTTagCompound tagCompound) {
        super.func_143011_b(tagCompound);
        if (tagCompound.hasKey("C")) {
            int[] ids = tagCompound.getIntArray("C");
            for (int i = 0; i < cropTypes.length; i++) {
                cropTypes[i] = Block.getBlockById(ids[i]);
            }
        }
    }

    public static Field1 func_74900_a(StructureVillagePieces.Start p_74900_0_, List p_74900_1_, Random p_74900_2_, int p_74900_3_, int p_74900_4_, int p_74900_5_, int p_74900_6_, int p_74900_7_) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_74900_3_, p_74900_4_, p_74900_5_, 0, 0, 0, 13, 4, 9, p_74900_6_);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_74900_1_, structureboundingbox) == null ? new Field1(p_74900_0_, p_74900_7_, p_74900_2_, structureboundingbox, p_74900_6_) : null;
    }
}
