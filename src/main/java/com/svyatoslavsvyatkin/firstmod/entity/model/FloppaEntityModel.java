package com.svyatoslavsvyatkin.firstmod.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.svyatoslavsvyatkin.firstmod.FirstMod;
import com.svyatoslavsvyatkin.firstmod.entity.custom.FloppaEntity;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class FloppaEntityModel<Type extends FloppaEntity> extends AgeableListModel<Type> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(FirstMod.MOD_ID, "floppa_entity"), "main");
    private final ModelPart back_left_leg;
    private final ModelPart back_right_leg;
    private final ModelPart front_left_leg;
    private final ModelPart front_right_leg;
    private final ModelPart body;
    private final ModelPart right_ear;
    private final ModelPart left_ear;
    private final ModelPart head;
    private final ModelPart tail;

    public FloppaEntityModel(ModelPart root) {
        this.back_left_leg = root.getChild("back_left_leg");
        this.back_right_leg = root.getChild("back_right_leg");
        this.front_left_leg = root.getChild("front_left_leg");
        this.front_right_leg = root.getChild("front_right_leg");
        this.body = root.getChild("body");
        this.right_ear = root.getChild("right_ear");
        this.left_ear = root.getChild("left_ear");
        this.head = root.getChild("head");
        this.tail = root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(34, 21).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 14.5F, 6.5F));

        PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(21, 28).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 14.5F, 6.5F));

        PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(34, 35).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 15.5F, -6.5F));

        PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(0, 39).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 15.5F, -6.5F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(26, 8).addBox(-3.5F, -2.1667F, -3.1667F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.5F, -3.1667F, 1.8333F, 9.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-4.5F, -3.1667F, -9.1667F, 9.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.1667F, 0.1667F));

        PartDefinition right_ear = partdefinition.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(2.0187F, 10.5644F, -8.5F));

        PartDefinition back_right_leg_r1 = right_ear.addOrReplaceChild("back_right_leg_r1", CubeListBuilder.create().texOffs(44, 35).addBox(-1.5F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 39).addBox(-2.5F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 28).addBox(-2.5F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-3.5F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(47, 21).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0187F, -0.5644F, -0.5F, 0.0F, 0.0F, 1.0472F));

        PartDefinition left_ear = partdefinition.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(-2.2066F, 10.7502F, -8.5F));

        PartDefinition back_right_leg_r2 = left_ear.addOrReplaceChild("back_right_leg_r2", CubeListBuilder.create().texOffs(45, 0).addBox(-5.5F, 1.0F, 0.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-7.5F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-6.5F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-6.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-5.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2066F, -0.7502F, -0.5F, 0.0F, 0.0F, 0.5672F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 0).addBox(-3.0F, -1.8333F, -1.6667F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(22, 42).addBox(-1.5F, -0.3333F, -3.6667F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-2.5F, -2.8333F, -2.6667F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.8333F, -8.3333F));

        PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 12.9129F, 9.0617F));

        PartDefinition back_right_leg_r3 = tail.addOrReplaceChild("back_right_leg_r3", CubeListBuilder.create().texOffs(13, 40).addBox(-1.0F, -1.5F, -3.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8257F, 1.8766F, 0.829F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.back_left_leg.render(poseStack, buffer, packedLight, packedOverlay);
        this.back_right_leg.render(poseStack, buffer, packedLight, packedOverlay);
        this.front_left_leg.render(poseStack, buffer, packedLight, packedOverlay);
        this.front_right_leg.render(poseStack, buffer, packedLight, packedOverlay);
        this.body.render(poseStack, buffer, packedLight, packedOverlay);
        this.right_ear.render(poseStack, buffer, packedLight, packedOverlay);
        this.left_ear.render(poseStack, buffer, packedLight, packedOverlay);
        this.head.render(poseStack, buffer, packedLight, packedOverlay);
        this.tail.render(poseStack, buffer, packedLight, packedOverlay);
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return ImmutableList.of(this.body, this.back_right_leg, this.back_left_leg, this.front_right_leg, this.front_left_leg);
    }

    @Override
    public void setupAnim(Type pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
        this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.back_right_leg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
        this.back_left_leg.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount;
        this.front_right_leg.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount;
        this.front_left_leg.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount;
    }
}