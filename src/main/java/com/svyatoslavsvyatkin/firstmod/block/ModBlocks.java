package com.svyatoslavsvyatkin.firstmod.block;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.block.custom.SpeedyBlock;
import com.svyatoslavsvyatkin.firstmod.item.ModCreativeModeTab;
import com.svyatoslavsvyatkin.firstmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(12f).requiresCorrectToolForDrops()), "tooltip.block.firstmod.titanium_block");

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(10f).requiresCorrectToolForDrops()), "tooltip.block.firstmod.titanium_ore");

    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock("speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f).requiresCorrectToolForDrops()), "tooltip.block.firstmod.speedy_block");

    public static final RegistryObject<Block> TITANIUM_STAIRS = registerBlock("titanium_stairs",
            () -> new StairBlock(() -> TITANIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TITANIUM_FENCE = registerBlock("titanium_fence",
            () -> new FenceBlock(
                    BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TITANIUM_WALL = registerBlock("titanium_wall",
            () -> new WallBlock(
                    BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> TITANIUM_SLAB = registerBlock("titanium_slab",
            () -> new SlabBlock(
                    BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));

    // объявление блока с кастомной вкладкой и подписью
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab,  String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab,  String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)) {
            @Override
            public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
                tooltip.add(new TranslatableComponent(tooltipKey));
                super.appendHoverText(stack, level, tooltip, flagIn);
            }
        });
    }

    // объявление блока с подписью
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB)) {
            @Override
            public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
                tooltip.add(new TranslatableComponent(tooltipKey));
                super.appendHoverText(stack, level, tooltip, flagIn);
            }
        });
    }

    // объявление блока с кастомной вкладкой
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    // объявление блока

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB)));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
