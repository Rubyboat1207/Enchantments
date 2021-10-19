package com.jrvboat.enchants.mixins;
import com.jrvboat.enchants.CustomEnchantments.Martyrdom;
import com.jrvboat.enchants.Main;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(at = @At("HEAD"), method = "updatePostDeath", cancellable = true)
    public void updatePostDeath(CallbackInfo ci)
    {
        if(((LivingEntity)(Object)this).deathTime == 19 && EnchantmentHelper.getLevel(Main.MARTYRDOM, ((LivingEntity)(Object)this).getEquippedStack(EquipmentSlot.CHEST)) != 0)
        {
            Martyrdom.onUserDeath(((LivingEntity)(Object)this));
        }
    }
}
