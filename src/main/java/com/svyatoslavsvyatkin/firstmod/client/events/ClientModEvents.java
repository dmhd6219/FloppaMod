package com.svyatoslavsvyatkin.firstmod.client.events;


import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ExampleEntity;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ModEntityTypes;
import com.svyatoslavsvyatkin.firstmod.entity.model.ExampleEntityModel;
import com.svyatoslavsvyatkin.firstmod.entity.model.FloppaEntityModel;
import com.svyatoslavsvyatkin.firstmod.entity.render.ExampleEntityRenderer;
import com.svyatoslavsvyatkin.firstmod.entity.render.FloppaEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FirstMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
    private ClientModEvents(){

    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
        event.registerLayerDefinition(FloppaEntityModel.LAYER_LOCATION, FloppaEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.FLOPPA_ENTITY.get(), FloppaEntityRenderer::new);
    }
}
