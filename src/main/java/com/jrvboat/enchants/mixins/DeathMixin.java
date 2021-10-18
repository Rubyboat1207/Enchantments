package com.jrvboat.enchants.mixins;

import com.jrvboat.enchants.CustomEnchantments.Martyrdom;
import com.jrvboat.enchants.Main;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class DeathMixin {
    @Inject(at = @At("HEAD"), method = "onDeath")
    public void onDeath(DamageSource source, CallbackInfo ci)
    {
        ((PlayerEntity)(Object)this).sendMessage(Text.of("Test"), false);
        if(EnchantmentHelper.getLevel(Main.MARTYRDOM, ((PlayerEntity)(Object)this).getInventory().getArmorStack(2)) != 0)
        {
            Martyrdom.onPlayerDeath(((PlayerEntity)(Object)this));
        }
    }
}
