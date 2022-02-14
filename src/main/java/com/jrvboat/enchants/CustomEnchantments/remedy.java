package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;

public class remedy extends Enchantment {
    public remedy() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[] {EquipmentSlot.LEGS});
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
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(!attacker.isPlayer())
        {
            for(Integer i = 0; i < user.getEntityWorld().getPlayers().size(); i++)
            {
                PlayerEntity player = user.getEntityWorld().getPlayers().get(i);
                Integer PlayersHealed = 0;
                if(player.distanceTo(user) <= level * 5 && player != (PlayerEntity) user)
                {
                    PlayersHealed++;
                    player.sendMessage(Text.of("you were healed by " + user.getName().asString()), true);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, (int) (level * 2d * 20), 2));
                }
                ((PlayerEntity) user).sendMessage(Text.of("You Healed " + PlayersHealed + " Players"), true);
            }
            user.getEntityWorld().getPlayers();
        }
    }
}
