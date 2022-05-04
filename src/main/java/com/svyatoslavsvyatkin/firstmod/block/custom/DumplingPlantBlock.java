package com.svyatoslavsvyatkin.firstmod.block.custom;

import com.svyatoslavsvyatkin.firstmod.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class DumplingPlantBlock extends CropBlock {
    public DumplingPlantBlock(Properties properties_) {
        super(properties_);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.DUMPLING_SEEDS.get();
    }
}
