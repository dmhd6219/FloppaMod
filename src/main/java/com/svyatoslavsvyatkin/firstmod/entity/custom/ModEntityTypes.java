package com.svyatoslavsvyatkin.firstmod.entity.custom;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    private ModEntityTypes(){}

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, FirstMod.MOD_ID);

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPES.register("example_entity",
            () -> EntityType.Builder.of(ExampleEntity::new,MobCategory.CREATURE).sized(0.8f, 0.6f)
                    .build(new ResourceLocation(FirstMod.MOD_ID, "example_entity").toString()));

    public static final RegistryObject<EntityType<FloppaEntity>> FLOPPA_ENTITY = ENTITY_TYPES.register("floppa_entity",
            () -> EntityType.Builder.of(FloppaEntity::new,MobCategory.CREATURE).sized(2f, 2f)
                    .build(new ResourceLocation(FirstMod.MOD_ID, "floppa_entity").toString()));

}
