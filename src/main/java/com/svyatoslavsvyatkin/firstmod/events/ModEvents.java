package com.svyatoslavsvyatkin.firstmod.events;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ExampleEntity;
import com.svyatoslavsvyatkin.firstmod.entity.custom.FloppaEntity;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ModEntityTypes;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
        event.put(ModEntityTypes.FLOPPA_ENTITY.get(), FloppaEntity.createAttributes().build());

    }

}