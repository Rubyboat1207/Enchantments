package com.jrvboat.enchants.mixins;

import com.jrvboat.enchants.Main;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SuspiciousStewItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SuspiciousStewItem.class)
public abstract class SuspiciousStewMixin {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Inject(at = @At("HEAD"), method = "finishUsing", cancellable = true)
    public void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir)
    {
        if(EnchantmentHelper.getLevel(Main.BOTTOMLESS, stack) != 0)
        {
            NbtCompound nbtCompound = stack.getNbt();
            if (nbtCompound != null && nbtCompound.contains("Effects", 9)) {
                NbtList nbtList = nbtCompound.getList("Effects", 10);

                for(int i = 0; i < nbtList.size(); ++i) {
                    int j = 160;
                    NbtCompound nbtCompound2 = nbtList.getCompound(i);
                    if (nbtCompound2.contains("EffectDuration", 3)) {
                        j = nbtCompound2.getInt("EffectDuration");
                    }

                    StatusEffect statusEffect = StatusEffect.byRawId(nbtCompound2.getByte("EffectId"));
                    if (statusEffect != null) {
                        user.addStatusEffect(new StatusEffectInstance(statusEffect, j));
                    }
                }
            }
            int randomnumber = getRandomNumber(0, 100);
            if (randomnumber < 70)
            {
                cir.setReturnValue(stack);
            }
        }
    }
}
