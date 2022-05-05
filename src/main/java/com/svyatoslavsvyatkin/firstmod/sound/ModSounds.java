package com.svyatoslavsvyatkin.firstmod.sound;


import com.svyatoslavsvyatkin.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FirstMod.MOD_ID);

    public static final RegistryObject<SoundEvent> ANECDOT1 = SOUNDS.register("anecdot1",
            () -> new SoundEvent(new ResourceLocation(FirstMod.MOD_ID, "anecdot1")));

    public static final RegistryObject<SoundEvent> SHT = SOUNDS.register("sht",
            () -> new SoundEvent(new ResourceLocation(FirstMod.MOD_ID, "sht")));


    private ModSounds(){

    }
}


