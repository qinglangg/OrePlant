package com.ore.oreplant;

import com.ore.oreplant.config.ConfigNetwork;
import com.ore.oreplant.interfaces.IColorProvider;
import com.ore.oreplant.interfaces.IStateMapProvider;
import com.ore.oreplant.oreblock.OreBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 所有合成表
 * @author 卿岚
 */
@Mod.EventBusSubscriber
public class Register {

	public static SimpleNetworkWrapper channel;
	private static boolean isLoaded = false;
	public static HashMap<String, Item> items = new HashMap<>();
	public static HashMap<String, Block> blocks = new HashMap<>();

    public static void smelt() {
    	//树干
		GameRegistry.addSmelting(Crops.woodCoal, new ItemStack(Items.COAL, 1,0), 5.0f);
		GameRegistry.addSmelting(Crops.woodDiamond, new ItemStack(Items.DIAMOND, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodEmerald, new ItemStack(Items.EMERALD, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodGlowstone, new ItemStack(Items.GLOWSTONE_DUST, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodGold, new ItemStack(Items.GOLD_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodIron, new ItemStack(Items.IRON_INGOT, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodLapis, new ItemStack(Items.DYE, 1,4), 5.0f);
		GameRegistry.addSmelting(Crops.woodRedstone, new ItemStack(Items.REDSTONE, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodObsidian, new ItemStack(Blocks.OBSIDIAN, 1), 5.0f);
		GameRegistry.addSmelting(Crops.woodQuartz, new ItemStack(Items.QUARTZ, 1), 5.0f);
		//劣质钻石矿
		GameRegistry.addSmelting(OreBlock.diamond_ore, new ItemStack(Items.DIAMOND, 1), 5.0f);
		GameRegistry.addSmelting(OreBlock.diamond_ore2, new ItemStack(Blocks.DIAMOND_BLOCK, 1), 5.0f);
    }

    public static void network() {
		channel = NetworkRegistry.INSTANCE.newSimpleChannel("channel");
		channel.registerMessage(new ConfigNetwork(), ConfigNetwork.class, 0, Side.SERVER);
	}

	@SubscribeEvent
	public static void item(RegistryEvent.Register<Item> event) {
    	loadElements();
    	items.forEach((name, item) -> {
    		item.setRegistryName(OrePlant.MODID, name);
    		item.setUnlocalizedName(OrePlant.MODID + "." + name);
    		event.getRegistry().register(item);
		});
    	blocks.values().forEach(block -> {
			ItemBlock ib = new ItemBlock(block);
			ib.setRegistryName(block.getRegistryName());
			event.getRegistry().register(ib);
		});
	}

	@SubscribeEvent
	public static void block(RegistryEvent.Register<Block> event) {
    	loadElements();
		blocks.forEach((name, blocks) -> {
			blocks.setRegistryName(OrePlant.MODID, name);
			blocks.setUnlocalizedName(OrePlant.MODID + "." + name);
			event.getRegistry().register(blocks);
		});
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void model(net.minecraftforge.client.event.ModelRegistryEvent event) {
		items.values().forEach(item -> {
			net.minecraft.client.renderer.block.model.ModelResourceLocation location =
					new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory");
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, location);
		});
		blocks.values().forEach(block -> {
			Item item = Item.getItemFromBlock(block);
			net.minecraft.client.renderer.block.model.ModelResourceLocation location = block instanceof IStateMapProvider
					? ((IStateMapProvider) block).getStateMapper().putStateModelLocations(block).get(block.getDefaultState())
					: new net.minecraft.client.renderer.block.model.ModelResourceLocation(item.getRegistryName(), "inventory");
			net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(item, 0, location);
			if (block instanceof IStateMapProvider) {
				net.minecraftforge.client.model.ModelLoader.setCustomStateMapper(block, ((IStateMapProvider) block).getStateMapper());
			}
		});
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void colorBlock(net.minecraftforge.client.event.ColorHandlerEvent.Block event) {
		event.getBlockColors().registerBlockColorHandler(com.ore.oreplant.render.PlantColorRender.INSTANCE,
				blocks.values().stream().filter(block -> block instanceof IColorProvider).toArray(Block[]::new));
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void colorItem(net.minecraftforge.client.event.ColorHandlerEvent.Item event) {
		event.getItemColors().registerItemColorHandler(com.ore.oreplant.render.PlantColorRender.INSTANCE,
				blocks.values().stream().filter(block -> block instanceof IColorProvider).toArray(Block[]::new));
	}

	private static void loadElements() {
    	if (isLoaded) {
    		return;
		}
    	try {
    		ArrayList<Field> fields = new ArrayList<>();
			Collections.addAll(fields, Seeds.class.getFields());
			Collections.addAll(fields, Crops.class.getFields());
			Collections.addAll(fields, OreBlock.class.getFields());
			for (Field field : fields) {
				int modifiers = field.getModifiers();
				if (Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
					if (Item.class.isAssignableFrom(field.getType())) {
						items.put(field.getName().toLowerCase(), (Item) field.get(null));
					} else if (Block.class.isAssignableFrom(field.getType())) {
						blocks.put(field.getName().toLowerCase(), (Block) field.get(null));
					}
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
    		isLoaded = true;
		}
	}
}
