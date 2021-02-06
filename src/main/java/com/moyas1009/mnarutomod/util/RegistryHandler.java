package com.moyas1009.mnarutomod.util;

import com.moyas1009.mnarutomod.NarutoMod;
import com.moyas1009.mnarutomod.blocks.BlockItemBase;
import com.moyas1009.mnarutomod.blocks.CaveBlock;
import com.moyas1009.mnarutomod.blocks.MoonDirt;
import com.moyas1009.mnarutomod.blocks.PaperWall;
import com.moyas1009.mnarutomod.items.ItemBase;
import com.moyas1009.mnarutomod.world.biomes.Moon;
import com.moyas1009.mnarutomod.world.biomes.MountMyoboku;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.ArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.PlainsBiome;
import net.minecraft.world.biome.provider.CheckerboardBiomeProviderSettings;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, NarutoMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, NarutoMod.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, NarutoMod.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Items

    public static final RegistryObject<Item> BRONZE_RYO = ITEMS.register("bronze_ryo", ItemBase::new);

    //Blocks

    public static final RegistryObject<Block> PAPER_WALL = BLOCKS.register("paper_wall", PaperWall::new);
    public static final RegistryObject<Block> CAVE_BLOCK = BLOCKS.register("cave_block", CaveBlock::new);
    public static final RegistryObject<Block> MOON_DIRT = BLOCKS.register("moon_dirt", MoonDirt::new);

    //Block Items

    public static final RegistryObject<Item> PAPER_WALL_ITEM = ITEMS.register("paper_wall", () -> new BlockItemBase(PAPER_WALL.get()));
    public static final RegistryObject<Item> CAVE_BLOCK_ITEM = ITEMS.register("cave_block", () -> new BlockItemBase(CAVE_BLOCK.get()));
    public static final RegistryObject<Item> MOON_DIRT_ITEM = ITEMS.register("moon_dirt", () -> new BlockItemBase(MOON_DIRT.get()));

    //Biomes

    public static final RegistryObject<Biome> MOUNT_MYOBOKU = BIOMES.register("mount_myoboku", () -> new MountMyoboku(new Biome.Builder().downfall(0.75f).precipitation(Biome.RainType.RAIN).scale(1.2f).temperature(1.0f).waterColor(3138454).waterFogColor(3138485).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState())).category(Biome.Category.JUNGLE).depth(0.12f).parent(null)));
    public static final RegistryObject<Biome> MOON = BIOMES.register("moon", () -> new Moon(new Biome.Builder().downfall(0f).precipitation(Biome.RainType.RAIN).scale(0.05f).temperature(0.05f).waterColor(1907740).waterFogColor(14408412).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(MOON_DIRT.get().getDefaultState(), MOON_DIRT.get().getDefaultState(), Blocks.STONE.getDefaultState())).category(Biome.Category.DESERT).depth(0.12f).parent(null)));

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types)
    {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome,100));
    }

    public static void registerBiomes()
    {
        registerBiome(MOUNT_MYOBOKU.get(), BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.OVERWORLD);
        registerBiome(MOON.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }
}

