package com.RK.fabricyes.registry;

import com.RK.fabricyes.Fabricyes;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static final Block WHEAT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
            .breakByHand(true));
    public static final Block CHICKEN_BLOCK = new Block(FabricBlockSettings.of(Material.METAL)
            .breakByHand(true));
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Fabricyes.MOD_ID, "wheat_block"), WHEAT_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Fabricyes.MOD_ID, "chicken_block"), CHICKEN_BLOCK);
    }
}
