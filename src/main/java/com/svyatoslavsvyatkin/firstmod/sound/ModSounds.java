package com.svyatoslavsvyatkin.firstmod.sound;


import com.svyatoslavsvyatkin.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FirstMod.MOD_ID);

    public static final RegistryObject<SoundEvent> FLOPPA_ENTITY_AMBIENT = SOUNDS.register("entity.floppa_entity.ambient",
            () -> new SoundEvent(new ResourceLocation(FirstMod.MOD_ID, "entity.floppa_entity.ambient")));

    public static final RegistryObject<SoundEvent> FLOPPA_ENTITY_HURT = SOUNDS.register("entity.floppa_entity.hurt",
            () -> new SoundEvent(new ResourceLocation(FirstMod.MOD_ID, "entity.floppa_entity.hurt")));

    public static final RegistryObject<SoundEvent> FLOPPA_ENTITY_DEATH = SOUNDS.register("entity.floppa_entity.death",
            () -> new SoundEvent(new ResourceLocation(FirstMod.MOD_ID, "entity.floppa_entity.death")));

    private ModSounds(){

    }
}


