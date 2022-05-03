package com.svyatoslavsvyatkin.firstmod.entity.render;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ExampleEntity;
import com.svyatoslavsvyatkin.firstmod.entity.model.ExampleEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer<Type extends ExampleEntity> extends MobRenderer<Type, ExampleEntityModel<Type>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(FirstMod.MOD_ID, "textures/entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5f);


    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
