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
 * 双对农田
 * @author luqin2007
 */
public class Field2 extends StructureVillagePieces.Village {
    
    protected Block[] cropTypes = new Block[2];

    @SuppressWarnings("unused")
    public Field2() { }

    public Field2(StructureVillagePieces.Start start, int type, Random rand, StructureBoundingBox box, EnumFacing facing) {
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
        fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 1, 0, 6, 4, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.getDefaultState(), Blocks.FARMLAND.getDefaultState(), false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 0, 0, 0, 0, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 6, 0, 0, 6, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 0, 5, 0, 0, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 1, 0, 8, 5, 0, 8, iblockstate, iblockstate, false);
        fillWithBlocks(worldIn, structureBoundingBoxIn, 3, 0, 1, 3, 0, 7, Blocks.WATER.getDefaultState(), Blocks.WATER.getDefaultState(), false);

        for (int i = 1; i <= 7; ++i) {
            int j = ((BlockCrops)this.cropTypes[0]).getMaxAge();
            int k = j / 3;
            this.setBlockState(worldIn, this.cropTypes[0].getStateFromMeta(MathHelper.getInt(randomIn, k, j)), 1, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypes[0].getStateFromMeta(MathHelper.getInt(randomIn, k, j)), 2, 1, i, structureBoundingBoxIn);
            int l = ((BlockCrops)this.cropTypes[1]).getMaxAge();
            int i1 = l / 3;
            this.setBlockState(worldIn, this.cropTypes[1].getStateFromMeta(MathHelper.getInt(randomIn, i1, l)), 4, 1, i, structureBoundingBoxIn);
            this.setBlockState(worldIn, this.cropTypes[1].getStateFromMeta(MathHelper.getInt(randomIn, i1, l)), 5, 1, i, structureBoundingBoxIn);
        }

        for (int j1 = 0; j1 < 9; ++j1) {
            for (int k1 = 0; k1 < 7; ++k1) {
                this.clearCurrentPositionBlocksUpwards(worldIn, k1, 4, j1, structureBoundingBoxIn);
                this.replaceAirAndLiquidDownwards(worldIn, Blocks.DIRT.getDefaultState(), k1, -1, j1, structureBoundingBoxIn);
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

    public static Field2 createPiece(StructureVillagePieces.Start start, List<StructureComponent> p_175852_1_, Random rand, int p_175852_3_, int p_175852_4_, int p_175852_5_, EnumFacing facing, int p_175852_7_) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p_175852_3_, p_175852_4_, p_175852_5_, 0, 0, 0, 7, 4, 9, facing);
        //noinspection ConstantConditions
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(p_175852_1_, structureboundingbox) == null ? new Field2(start, p_175852_7_, rand, structureboundingbox, facing) : null;
    }
}
