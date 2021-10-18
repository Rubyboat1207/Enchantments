package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class VexProtection extends Enchantment {
    public VexProtection() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }
    @Override
    public int getMinPower(int level) {return 1;}
    @Override
    public int getMaxLevel() {return 1;}
    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {

        if (user.getHealth() <= 2) {
            for(int i = 0; i < 10; i++) {
                ServerWorld serverWorld = (ServerWorld) target.getEntityWorld();
                LivingEntity livingEntity = (LivingEntity) EntityType.VEX.create(serverWorld);
                livingEntity.setPos(target.getX(),target.getY(),target.getZ());
                serverWorld.spawnEntity(livingEntity);
                PlayerEntity playerEntity = (PlayerEntity) user;
                playerEntity.sendMessage(Text.of("KABOOM"), false);
            }
        }
    }
}
