package com.RK.fabricyes;
import com.RK.fabricyes.registry.ModBlocks;
import com.RK.fabricyes.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class Fabricyes implements ModInitializer{

public static final String MOD_ID = "fabricyes";
public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"),
        () -> new ItemStack(Blocks.WHEAT)
        );

    private static ConfiguredFeature<?, ?> ORE_CHICKEN_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.CHICKEN_BLOCK.getDefaultState(),
                    9)) // Vein size
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(20);

    private static ConfiguredFeature<?, ?> ORE_WHEAT_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlocks.WHEAT_BLOCK.getDefaultState(),
                    9))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(20);
    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        RegistryKey<ConfiguredFeature<?, ?>> oreWheatOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("fabricyes", "ore_wheat_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreWheatOverworld.getValue(), ORE_WHEAT_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreWheatOverworld);
        RegistryKey<ConfiguredFeature<?, ?>> oreChickenOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("fabricyes", "ore_chicken_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreChickenOverworld.getValue(), ORE_CHICKEN_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreChickenOverworld);
    }
}
