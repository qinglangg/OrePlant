package com.ore.oreplant;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OreTabs extends CreativeTabs {

//    public static List<Object>
//    ITEMS = new ArrayList<>();

    public static CreativeTabs TAB = new OreTabs();

    public OreTabs() {
        super("ore");
//        collect(Crops.class);
//        collect(Seed.class);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Seeds.saplingCoal);
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public ItemStack getTabIconItem() {
//        if (!ITEMS.isEmpty()) {
//            Object displayItem = ITEMS.get(0);
//            if (displayItem instanceof Item) {
//                return new ItemStack((Item) displayItem);
//            } else if (displayItem instanceof Block) {
//                return new ItemStack((Block) displayItem);
//            } else if (displayItem instanceof ItemStack) {
//                return (ItemStack) displayItem;
//            }
//        }
//        return ItemStack.EMPTY;
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
//        super.displayAllRelevantItems(items);
//        for (Object displayItem : ITEMS) {
//            if (displayItem instanceof Item) {
//                items.add(new ItemStack((Item) displayItem));
//            } else if (displayItem instanceof Block) {
//                items.add(new ItemStack((Block) displayItem));
//            } else if (displayItem instanceof ItemStack) {
//                items.add((ItemStack) displayItem);
//            }
//        }
//    }
//
//    private void collect(Class clazz) {
//        for (Field field : clazz.getDeclaredFields()) {
//            if (field.getAnnotation(SkipGroup.class) == null && Modifier.isStatic(field.getModifiers())) {
//                if (Block.class.isAssignableFrom(field.getType()) || Item.class.isAssignableFrom(field.getType())) {
//                    if (!field.isAccessible()) {
//                        field.setAccessible(true);
//                    }
//                    try {
//                        ITEMS.add(field.get(null));
//                    } catch (IllegalAccessException ignored) { }
//                }
//            }
//        }
//    }
}
