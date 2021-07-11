package com.RK.fabricyes.registry;

import com.RK.fabricyes.Fabricyes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final BlockItem WHEAT_BLOCK = new BlockItem(ModBlocks.WHEAT_BLOCK,new Item.Settings().group(Fabricyes.ITEM_GROUP));
    public static final BlockItem CHICKEN_BLOCK = new BlockItem(ModBlocks.CHICKEN_BLOCK,new Item.Settings().group(Fabricyes.ITEM_GROUP));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Fabricyes.MOD_ID, "wheat_block"), WHEAT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Fabricyes.MOD_ID, "chicken_block"), CHICKEN_BLOCK);
    }
}
