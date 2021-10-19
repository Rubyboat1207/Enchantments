package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.ai.brain.task.WaitTask;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class Martyrdom extends Enchantment {
    public Martyrdom() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
    }
    @Override
    public int getMinPower(int level) {
        return level * 25;
    }
    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {

    }

    public static void onUserDeath(LivingEntity user)
    {
        ServerWorld serverWorld = (ServerWorld) user.getEntityWorld();
        TntEntity tntEntity = new TntEntity(serverWorld, user.getX(), user.getY(), user.getZ(), user);
        //PlayerEntity playerEntity = (PlayerEntity) user;
        //playerEntity.sendMessage(Text.of("KABOOM"), false);
        tntEntity.setFuse(10);
        serverWorld.spawnEntity(tntEntity);
    }
}
