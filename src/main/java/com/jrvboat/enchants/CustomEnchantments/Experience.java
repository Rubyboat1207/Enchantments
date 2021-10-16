package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.enchantment.ThornsEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

public class Experience extends Enchantment {
    public Experience() {
        super(Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    @Override
    public int getMinPower(int level) { return 1;}
    @Override
    public int getMaxLevel() {return 3;}
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(((LivingEntity) target).isDead()) {
            LivingEntity entity = (LivingEntity) target;
            ServerWorld serverWorld = (ServerWorld) user.getEntityWorld();
            ExperienceOrbEntity experienceOrbEntity = new ExperienceOrbEntity(serverWorld, target.getX(),target.getY(),target.getZ(), level*3);
            serverWorld.spawnEntity(experienceOrbEntity);


        }
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return other instanceof MendingEnchantment ? false : super.canAccept(other);
    }
}
