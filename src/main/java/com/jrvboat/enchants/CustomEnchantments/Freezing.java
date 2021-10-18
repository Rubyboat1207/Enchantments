package com.jrvboat.enchants.CustomEnchantments;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;



public class Freezing extends Enchantment {

    private Object target;
    LivingEntity entity = (LivingEntity) target;

    
    public Freezing() {
        super(Rarity.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
        return 2;
    }
    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) target;
            int frozentime = 0;
            if(entity.getFrozenTicks() > 100)
            {
                frozentime = 120 * level;
            }else if(entity.getFrozenTicks() < 100)
            {
                frozentime = 100 * level;
            }else
            {
                frozentime = 0;
            }
            entity.setFrozenTicks(entity.getFrozenTicks() + frozentime);
        }
    }
}
