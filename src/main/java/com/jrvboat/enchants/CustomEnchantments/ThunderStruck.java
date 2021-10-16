package com.jrvboat.enchants.CustomEnchantments;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;

public class ThunderStruck extends Enchantment {



    public ThunderStruck() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) { return level * 25;}
    @Override
    public int getMaxPower(int level) {return this.getMinPower(level) + 50;}
    @Override
    public int getMaxLevel() {return 3;}
    @Override
    public void onUserDamaged(LivingEntity user, Entity target, int level) {

        ServerWorld serverWorld = (ServerWorld) target.getEntityWorld();
        LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(serverWorld); //creates lightning
        LivingEntity entity = (LivingEntity) target; //defines entity
        lightningEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ()); //gets lightning postion at target postion
        lightningEntity.setCosmetic(true); //makes lightning cosmetic (no damage just lightning bolt)

        if (target instanceof LivingEntity) {
            serverWorld.spawnEntity(lightningEntity); //spawns lightning bolt
            entity.damage(DamageSource.LIGHTNING_BOLT, 2); //damages entity because lightning doesnt do damage
            entity.setFireTicks(60); //sets entity on fire for 3 seconds
        }
    }

}
