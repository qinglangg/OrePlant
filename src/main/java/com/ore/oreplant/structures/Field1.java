package com.ore.oreplant.structures;

import com.ore.oreplant.Crops;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.template.TemplateManager;

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

    public Field1(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox box, EnumFacing facing) {
        super(start, type);
        this.setCoordBaseMode(facing);
        this.boundingBox = box;
        for (int i = 0; i < cropTypes.length; i++) {
            cropTypes[i] = getRandomCropType(rand);
        }
    }

    @Override
    public boolean addComponentParts(@Nonnull World worldIn, @Nonnull Random randomIn, @Nonnull StructureBoundingBox structureBoundingBoxIn) {
        if (averageGroundLvl < 0) {
            averageGroundLvl = getAverageGroundLevel(worldIn, structureBoundingBoxIn);
            if (averageGroundLvl < 0) {
                return true;
            }
            boundingBox.offset(0, averageGroundLvl - boundingBox.maxY + 4 - 1, 0);
        }

        IBlockState iblockstate = this.getBiomeSpecificBlockState(Blocks.LOG.getDefaultState());
        fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 0, 12, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 0, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 0, 0, 6, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 12, 0, 0, 12, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 11, 0, 0, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 8, 11, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 9, 0, 1, 9, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);

        for (int i = 1; i <= 7; ++i) {
            int j = ((BlockCrops)cropTypes[0]).getMaxAge();
            int k = j / 3;
            this.setBlockState(worldIn, this.cropTypes[0].getStateFromMeta(MathHelper.getInt(randomIn, k, j)), 1, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypes[0].getStateFromMeta(MathHelper.getInt(randomIn, k, j)), 2, 1, i, structureBoundingBoxIn);
            int l = ((BlockCrops)this.cropTypes[1]).getMaxAge();
            int i1 = l / 3;
            this.setBlockState(worldIn, this.cropTypes[1].getStateFromMeta(MathHelper.getInt(randomIn, i1, l)), 4, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypes[1].getStateFromMeta(MathHelper.getInt(randomIn, i1, l)), 5, 1, i, structureBoundingBoxIn);
            int j1 = ((BlockCrops)this.cropTypes[2]).getMaxAge();
            int k1 = j1 / 3;
            this.setBlockState(worldIn, this.cropTypes[2].getStateFromMeta(MathHelper.getInt(randomIn, k1, j1)), 7, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypes[2].getStateFromMeta(MathHelper.getInt(randomIn, k1, j1)), 8, 1, i, structureBoundingBoxIn);
            int l1 = ((BlockCrops)this.cropTypes[3]).getMaxAge();
            int i2 = l1 / 3;
            this.setBlockState(worldIn, this.cropTypes[3].getStateFromMeta(MathHelper.getInt(randomIn, i2, l1)), 10, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypes[3].getStateFromMeta(MathHelper.getInt(randomIn, i2, l1)), 11, 1, i, structureBoundingBoxIn);
        }

        for (int z = 0; z < 9; ++z) {
            for (int x = 0; x < 13; ++x) {
                clearCurrentPositionBlocksUpwards(worldIn, x, 4, z, structureBoundingBoxIn);
                replaceAirAndLiquidDownwards(worldIn, Blocks.DIRT.getDefaultState(), x, -1, z, structureBoundingBoxIn);
            }
        }

        return true;
    }

    private BlockCrops getRandomCropType(Random random) {
        int r = random.nextInt(80);
        if (r < 16) {
            return (BlockCrops) Blocks.CARROTS;
        } else if (r < 32) {
            return (BlockCrops) Blocks.POTATOES;
        } else if (r < 40) {
            return (BlockCrops) Blocks.BEETROOTS;
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
    protected void writeStructureToNBT(NBTTagCompound tagCompound) {
        super.writeStructureToNBT(tagCompound);
        NBTTagList list = new NBTTagList();
        for (Block cropType : cropTypes) {
            list.appendTag(new NBTTagInt(Block.REGISTRY.getIDForObject(cropType)));
        }
        tagCompound.setTag("C", list);
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager templateManager) {
        super.readStructureFromNBT(tagCompound, templateManager);
        if (tagCompound.hasKey("C")) {
            NBTTagList list = (NBTTagList) tagCompound.getTag("C");
            for (int i = 0; i < cropTypes.length; i++) {
                Block block = Block.getBlockById(list.getIntAt(i));
                if (!(block instanceof BlockCrops)) {
                    block = Blocks.WHEAT;
                }
                cropTypes[i] = block;
            }
        }
    }

    public static Field1 createPiece(StructureVillagePieces.Start start, List<StructureComponent> list, Random rand, int sX, int sY, int sZ, EnumFacing facing, int type) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(sX, sY, sZ, 0, 0, 0, 13, 4, 9, facing);
        //noinspection ConstantConditions
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(list, structureboundingbox) == null ? new Field1(start, type, rand, structureboundingbox, facing) : null;
    }
}
