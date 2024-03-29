package com.svyatoslavsvyatkin.firstmod.item;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.block.ModBlocks;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ModEntityTypes;
import com.svyatoslavsvyatkin.firstmod.item.custom.CoalCokeItem;
import com.svyatoslavsvyatkin.firstmod.item.custom.SmartBlowtorchItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            ( () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
            ( () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            ( () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            ( () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build()))));

    public static final RegistryObject<Item> DUMPLING = ITEMS.register("dumpling",
            ( () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build()))));

    public static final RegistryObject<Item> SMART_BLOW_TORCH = ITEMS.register("smart_blow_torch",
            ( () -> new SmartBlowtorchItem(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB).durability(64))));


    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
            ( () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            ( () -> new SwordItem(ModTiers.TITANIUM, 2, 3f, new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            ( () -> new PickaxeItem(ModTiers.TITANIUM, 0, 1f, new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            ( () -> new ShovelItem(ModTiers.TITANIUM, 0, 1f, new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            ( () -> new AxeItem(ModTiers.TITANIUM, 4, -2f, new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            ( () -> new HoeItem(ModTiers.TITANIUM, 0, 1f, new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));


    public static final RegistryObject<Item> DUMPLING_SEEDS = ITEMS.register("dumpling_seeds",
            ( () -> new ItemNameBlockItem(ModBlocks.DUMPLING_PLANT.get(), new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB))));

    public static final RegistryObject<ForgeSpawnEggItem> FLOPPA_SPAWN_EGG = ITEMS.register("floppa_spawn_egg",
            ()->new ForgeSpawnEggItem(ModEntityTypes.FLOPPA_ENTITY, 0x2E51ED, 0x34BD27, new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB).stacksTo(64)));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
