package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.FluidTags;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class WaterWalker extends Enchantment {
    public WaterWalker(){
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[] {EquipmentSlot.FEET});
    }
    @Override
    public int getMinPower(int level){return 1;}
    @Override
    public int getMaxLevel(){ return 3;}
    @Override
    public void tick(CallbackInfo ci){
        public boolean canWalkOnFluid(Fluid EntityType<T> fluid;
        fluid) {
            return fluid.isIn(FluidTags.WATER);
        }
    }
}
