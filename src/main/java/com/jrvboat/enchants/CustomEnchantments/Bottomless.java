package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

public class Bottomless extends Enchantment {

    public boolean isAcceptableItem(Item item) {
        return item instanceof MilkBucketItem ^ item instanceof BucketItem;
    }
    public Bottomless() { // IGNORE ENCHANT TARGET
        super(Rarity.UNCOMMON, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(Items.MILK_BUCKET) ^ stack.isOf(Items.SUSPICIOUS_STEW) ^ stack.isOf(Items.MUSHROOM_STEM);
    }
}
