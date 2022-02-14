package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class WaterWalker extends Enchantment {
    public WaterWalker() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_FEET, EquipmentSlot.values());
    }

}
