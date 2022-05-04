package com.svyatoslavsvyatkin.firstmod.events;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ExampleEntity;
import com.svyatoslavsvyatkin.firstmod.entity.custom.FloppaEntity;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ModEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
        event.put(ModEntityTypes.FLOPPA_ENTITY.get(), FloppaEntity.createAttributes().build());

    }

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {

    }

    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
    }
}