package com.jrvboat.enchants.mixins;

import com.jrvboat.enchants.Main;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.StewItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(StewItem.class)
public abstract class MushroomStewMixin {

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Inject(at = @At("HEAD"), method = "finishUsing", cancellable = true)
    public void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir)
    {

        if(EnchantmentHelper.getLevel(Main.BOTTOMLESS, stack) != 0)
        {
            int randomnumber = getRandomNumber(0, 100);
            if (randomnumber < 80)
            {
                if (user instanceof ServerPlayerEntity) {
                    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
                    Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
                    PlayerEntity player = (PlayerEntity) user;
                    player.getHungerManager().add(FoodComponents.MUSHROOM_STEW.getHunger(),FoodComponents.MUSHROOM_STEW.getSaturationModifier() );

                }
                cir.setReturnValue(stack);
            }
        }
    }
}
