package com.svyatoslavsvyatkin.firstmod.item.custom;

import com.google.common.collect.ImmutableMap;
import com.svyatoslavsvyatkin.firstmod.block.ModBlocks;
import com.svyatoslavsvyatkin.firstmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.commands.arguments.ItemEnchantmentArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.server.command.ModIdArgument;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class SmartBlowtorchItem extends Item {
    private static final Map<Block, Item> BLOW_TORCH_ITEM_CRAFT = new ImmutableMap.Builder<Block, Item>()
            .put(ModBlocks.TITANIUM_BLOCK.get(), ModItems.TITANIUM_NUGGET.get())
            .put(Blocks.SAND, Blocks.GLASS.asItem())
            .build();


    public SmartBlowtorchItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if (canBlowTorch(blockClicked)){
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(BLOW_TORCH_ITEM_CRAFT.get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {p.broadcastBreakEvent(pContext.getHand());});
            } else{
                pContext.getPlayer().sendMessage(new TextComponent("Cant blow this block :("), Util.NIL_UUID);
            }

        return InteractionResult.SUCCESS;
        }

        return super.useOn(pContext);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(!Screen.hasShiftDown()){
            pTooltipComponents.add(new TranslatableComponent("tooltip.firstmod.blowtorch"));
        } else{
            pTooltipComponents.add(new TranslatableComponent("tooltip.firstmod.blowtorch_shift"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private boolean canBlowTorch(Block block){
        return BLOW_TORCH_ITEM_CRAFT.containsKey(block);
    }
}
