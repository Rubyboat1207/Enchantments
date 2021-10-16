package com.jrvboat.enchants.CustomEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class Gilded extends Enchantment {
    public Gilded() {
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
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity)
        {
            if(((LivingEntity) target).isDead())
            {
                ServerWorld world = (ServerWorld) user.getEntityWorld();
                if(user instanceof PlayerEntity)
                {
                    PlayerEntity player = (PlayerEntity) user;
                    //player.sendMessage(Text.of(player.getInventory().getMainHandStack()));
                    player.getInventory().insertStack(new ItemStack(Items.GOLD_NUGGET, level));
                }else
                {
                    ItemEntity itemEntity = new ItemEntity(world, user.getX(),user.getY(), user.getZ(), new ItemStack(Items.GOLD_NUGGET, level));
                    world.spawnEntity(itemEntity);
                }

            }
        }

        super.onTargetDamaged(user, target, level);
    }
}
