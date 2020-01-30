package com.ore.oreplant;

import com.ore.oreplant.config.ConfigNetwork;
import com.ore.oreplant.config.Configuration;
import com.ore.oreplant.event.OreHandler;
import com.ore.oreplant.structures.Field1;
import com.ore.oreplant.structures.Field2;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import java.util.List;
import java.util.Random;

/**
 * @author 深圳市咕咕咕科技有限公司-我的世界矿石系列制作组版权所有
 */
@Mod(modid = OrePlant.MODID, name = OrePlant.NAME, version = OrePlant.VERSION, guiFactory = "com.ore.oreplant.config.ConfigGui")
public class OrePlant
{
    public static final String MODID = "oreplant";
    public static final String NAME = "Ore Plant";
    public static final String VERSION = "1.3.0";

    public OrePlant() {
        ConfigNetwork.register(MODID, Configuration::fromBytes, Configuration::toBytes, Configuration::reload);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Register.network();
        MinecraftForge.ORE_GEN_BUS.register(new OreHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Register.smelt();
        VillagerRegistry.instance().registerVillageCreationHandler(new VillagerRegistry.IVillageCreationHandler() {
            @Override
            public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) {
                return new StructureVillagePieces.PieceWeight(Field1.class, 3, MathHelper.getInt(random, 1 + size, 4 + size));
            }

            @Override
            public Class<?> getComponentClass() {
                return Field1.class;
            }

            @Override
            public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5) {
                return Field1.createPiece(startPiece, pieces, random, p1, p2, p3, facing, p5);
            }
        });
        VillagerRegistry.instance().registerVillageCreationHandler(new VillagerRegistry.IVillageCreationHandler() {
            @Override
            public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) {
                return new StructureVillagePieces.PieceWeight(Field2.class, 3, MathHelper.getInt(random, 2 + size, 4 + size * 2));
            }

            @Override
            public Class<?> getComponentClass() {
                return Field2.class;
            }

            @Override
            public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5) {
                return Field2.createPiece(startPiece, pieces, random, p1, p2, p3, facing, p5);
            }
        });
        MapGenStructureIO.registerStructureComponent(Field1.class, "ViOF");
        MapGenStructureIO.registerStructureComponent(Field2.class, "ViODF");
    }
}
