package com.ore.oreplant;

import com.ore.oreplant.config.CommonConfig;
import com.ore.oreplant.event.DropHandler;
import com.ore.oreplant.event.GeneratorHandler;
import com.ore.oreplant.recipes.CraftingRecipes;
import com.ore.oreplant.recipes.SmeltRecipe;
import com.ore.oreplant.structure.Field1;
import com.ore.oreplant.structure.Field2;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;
import java.util.Random;

@Mod(modid = OrePlant.MODID, name = OrePlant.NAME, version = OrePlant.VERSION)
public class OrePlant
{
    public static final String MODID = "oreplant";
    public static final String NAME = "Ore Plant";
    public static final String VERSION = "1.3.1";

    public static CreativeTabs TAB = new CreativeTabs("ore") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Seeds.saplingCoal);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CommonConfig.load(event);
        MinecraftForge.EVENT_BUS.register(new DropHandler());
        MinecraftForge.EVENT_BUS.register(new GeneratorHandler());
        Register.register();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {
    	SmeltRecipe.init(event);
        CraftingRecipes.registerAll();
        VillagerRegistry.instance().registerVillageCreationHandler(new VillagerRegistry.IVillageCreationHandler() {
            @Override
            public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) {
                return new StructureVillagePieces.PieceWeight(Field1.class, 3, MathHelper.getRandomIntegerInRange(random, 1 + size, 4 + size));
            }

            @Override
            public Class<?> getComponentClass() {
                return Field1.class;
            }

            @Override
            public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
                return Field1.func_74900_a(startPiece, pieces, random, p1, p2, p3, p4, p5);
            }
        });
        VillagerRegistry.instance().registerVillageCreationHandler(new VillagerRegistry.IVillageCreationHandler() {
            @Override
            public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) {
                return new StructureVillagePieces.PieceWeight(Field2.class, 3, MathHelper.getRandomIntegerInRange(random, 2 + size, 4 + size * 2));
            }

            @Override
            public Class<?> getComponentClass() {
                return Field2.class;
            }

            @Override
            public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
                return Field2.func_74900_a(startPiece, pieces, random, p1, p2, p3, p4, p5);
            }
        });
        MapGenStructureIO.func_143031_a(Field1.class, "ViOF");
        MapGenStructureIO.func_143031_a(Field2.class, "ViODF");
    }
}
