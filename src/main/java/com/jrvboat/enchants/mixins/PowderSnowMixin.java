package com.jrvboat.enchants.mixins;

import com.jrvboat.enchants.Main;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.swing.*;

@Mixin(PowderSnowBucketItem.class)
public abstract class PowderSnowMixin{

    //TODO: Fix
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Inject(at = @At("HEAD"), method = "useOnBlock", cancellable = true)
    public void finishUsing(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir)
    {
        ActionResult actionResult = ActionResult.SUCCESS;

        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        ItemStack stack = player.getMainHandStack();
        World world = context.getWorld();
        player.sendMessage(Text.of("TEST"), false);

        if (actionResult.isAccepted() && player != null && !player.isCreative()) {
            player.setStackInHand(hand, Items.BUCKET.getDefaultStack());
            int randomnumber = getRandomNumber(0, 100);

            if (player instanceof ServerPlayerEntity) {
                player.sendMessage(Text.of("RandomNumber is: " + String.valueOf(randomnumber)), false);
                player.sendMessage(Text.of(String.valueOf(EnchantmentHelper.getLevel(Main.BOTTOMLESS, stack))), false);
                if(EnchantmentHelper.getLevel(Main.BOTTOMLESS, stack) != 0)
                {
                    if (randomnumber < 90)
                    {
                        player.setStackInHand(hand, stack);
                        if (!world.isClient) {
                            player.clearStatusEffects();
                        }
                    }
                }
            }
        }
        cir.setReturnValue(actionResult);
    }
}
