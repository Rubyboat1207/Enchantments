package com.jrvboat.enchants.mixins;

import com.jrvboat.enchants.Main;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract ItemStack getActiveItem();

    @Shadow public abstract boolean canWalkOnFluid(Fluid fluid);

    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(at = @At("HEAD"), method = "updatePostDeath", cancellable = true)
    public void updatePostDeath(CallbackInfo ci)
    {
        if(((LivingEntity)(Object)this).deathTime == 19)
        {
            if(((LivingEntity)(Object)this).isPlayer())
            {
                PlayerEntity pl = ((PlayerEntity)(Object)this);
                /*if(EnchantmentHelper.getLevel(Main.MARTYRDOM, pl.getInventory().getArmorStack(2)) != 0)
                {
                    Martyrdom.onUserDeath(((PlayerEntity)(Object)this));
                }*/
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "canWalkOnFluid", cancellable = true)
    void canwalkonfluid(Fluid fluid, CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(EnchantmentHelper.getLevel(Main.WATERWALKER, this.getEquippedStack(EquipmentSlot.FEET)) >= 1);
    }
}
