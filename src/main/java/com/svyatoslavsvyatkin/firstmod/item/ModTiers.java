package com.svyatoslavsvyatkin.firstmod.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {
    public static final ForgeTier TITANIUM = new ForgeTier(4, 1500, 10f, 5f,
            15, Tags.Blocks.NEEDS_NETHERITE_TOOL,
            () -> Ingredient.of(ModItems.TITANIUM_INGOT.get()));
}
