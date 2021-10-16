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
        LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(serverWorld);
        LivingEntity entity = (LivingEntity) target;
        lightningEntity.refreshPositionAfterTeleport(target.getX(), target.getY(), target.getZ());
        lightningEntity.setCosmetic(true);

        if (target instanceof LivingEntity) {
            serverWorld.spawnEntity(lightningEntity);
            entity.damage(DamageSource.LIGHTNING_BOLT, 2);
            entity.setFireTicks(60);
        }
    }
}
