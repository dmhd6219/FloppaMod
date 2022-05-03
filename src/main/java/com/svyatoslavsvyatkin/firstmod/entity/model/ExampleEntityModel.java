package com.svyatoslavsvyatkin.firstmod.entity.model;// Made with Blockbench 4.2.4


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.ExampleEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ExampleEntityModel<Type extends ExampleEntity> extends EntityModel<Type> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(FirstMod.MOD_ID, "example_entity"), "main");
    private final ModelPart body;

    public ExampleEntityModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -6.0F, 10.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(26, 22).addBox(-6.0F, -2.0F, 5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(17, 22).addBox(6.0F, -2.0F, 5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.0F, -2.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 6).addBox(-6.0F, -2.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -11.0F, 8.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 28).addBox(-2.0F, -12.0F, 8.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 28).addBox(2.0F, -12.0F, 8.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}