package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Lunar extends Enchantment {
    public Lunar() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[] {EquipmentSlot.CHEST});
    }
    @Override
    public int getMinPower(int level) {
        return level * 5;
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
    public boolean canAccept(Enchantment other) {
        return !(other instanceof ProtectionEnchantment) && super.canAccept(other);
    }
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(Items.ELYTRA);
    }
}
