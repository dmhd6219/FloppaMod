package com.svyatoslavsvyatkin.firstmod.item;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.item.custom.SmartBlowtorchItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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

    public static final RegistryObject<Item> SMART_BLOW_TORCH = ITEMS.register("smart_blow_torch",
            ( () -> new SmartBlowtorchItem(new Item.Properties().tab(ModCreativeModeTab.FIRSTMODE_TAB).durability(64))));




    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
