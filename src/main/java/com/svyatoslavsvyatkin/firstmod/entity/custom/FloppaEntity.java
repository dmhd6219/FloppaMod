package com.svyatoslavsvyatkin.firstmod.entity.custom;

import com.svyatoslavsvyatkin.firstmod.item.ModItems;
import com.svyatoslavsvyatkin.firstmod.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDeathEvent;


public class FloppaEntity extends Animal {
    public FloppaEntity(EntityType<? extends Animal> entityType,Level level) {
        super(entityType,level);
    }
    private static final Ingredient FOOD_ITEMS = Ingredient.of(ModItems.TITANIUM_INGOT.get());

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.CARROT_ON_A_STICK), false));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
        return ModEntityTypes.FLOPPA_ENTITY.get().create(level);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAT_PURR;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.CAT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CAT_DEATH;
    }


    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        Level pLevel = pPlayer.level;
        if (!pLevel.isClientSide()){
            if (pHand == InteractionHand.MAIN_HAND){
                pPlayer.sendMessage(new TextComponent("Floppa: MEOWWWWW"), Util.NIL_UUID);

                if (pPlayer.getMainHandItem().getItem() == ModItems.DUMPLING.get()){
                    this.playSound(ModSounds.ANECDOT1.get(), 1f, 1f);

                    pPlayer.getMainHandItem().shrink(1);
                    pPlayer.sendMessage(new TextComponent("Floppa eat your dumpling"), Util.NIL_UUID);
                }


            }
        }

        return super.mobInteract(pPlayer, pHand);
    }

}