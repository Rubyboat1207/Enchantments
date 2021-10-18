package com.jrvboat.enchants.mixins;

import com.jrvboat.enchants.Main;
import net.minecraft.block.Material;
import net.minecraft.data.client.model.BlockStateSupplier;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci)
    {
        World world = ((PlayerEntity)(Object)this).getEntityWorld();
        Position pos = ((PlayerEntity)(Object)this).getPos();
        if(EnchantmentHelper.getLevel(Main.LUNAR, ((PlayerEntity)(Object)this).getInventory().getArmorStack(2)) != 0)
        {
            LivingEntity player = ((PlayerEntity)(Object)this);
            player.setNoGravity(true);
        }else
        {
            LivingEntity player = ((PlayerEntity)(Object)this);
            player.setNoGravity(false);
        }
    }
}
