package com.svyatoslavsvyatkin.firstmod.entity.render;

import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.FloppaEntity;
import com.svyatoslavsvyatkin.firstmod.entity.model.FloppaEntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FloppaEntityRenderer<Type extends FloppaEntity> extends MobRenderer<Type, FloppaEntityModel<Type>> {

    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(FirstMod.MOD_ID, "textures/entity/floppa_texture.png");

    public FloppaEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new FloppaEntityModel<>(context.bakeLayer(FloppaEntityModel.LAYER_LOCATION)), 0.5f);


    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
