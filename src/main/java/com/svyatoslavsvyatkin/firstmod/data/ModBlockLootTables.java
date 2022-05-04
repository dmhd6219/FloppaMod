package com.svyatoslavsvyatkin.firstmod.data;

import com.svyatoslavsvyatkin.firstmod.block.ModBlocks;
import com.svyatoslavsvyatkin.firstmod.block.custom.DumplingPlantBlock;
import com.svyatoslavsvyatkin.firstmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected void addTables() {

        this.add(ModBlocks.TITANIUM_SLAB.get(), (block) -> {
            return createSlabItemTable(ModBlocks.TITANIUM_SLAB.get());
        });

        this.add(ModBlocks.TITANIUM_ORE.get(), (block) -> {
            return createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get());
        });

        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.TITANIUM_FENCE.get());
        this.dropSelf(ModBlocks.TITANIUM_WALL.get());
        this.dropSelf(ModBlocks.SPEEDY_BLOCK.get());
        this.dropSelf(ModBlocks.TITANIUM_STAIRS.get());

        LootItemCondition.Builder dumplingLootConditionBuilder = LootItemBlockStatePropertyCondition.
                hasBlockStateProperties(ModBlocks.DUMPLING_PLANT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DumplingPlantBlock.AGE, 7));

        this.add(ModBlocks.DUMPLING_PLANT.get(), createCropDrops(ModBlocks.DUMPLING_PLANT.get(),
                ModItems.DUMPLING.get(), ModItems.DUMPLING_SEEDS.get(), dumplingLootConditionBuilder));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
