package com.jrvboat.enchants.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.EnchantmentScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnchantTable extends Item {
    public EnchantTable(Settings settings) {
        super(settings);
    }
    private static final Text TITLE = new TranslatableText("container.enchanting");


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient()) {
            playerEntity.openHandledScreen(createScreenHandlerFactory(world, playerEntity.getBlockPos()));
        }
        return new TypedActionResult<>(ActionResult.PASS, playerEntity.getStackInHand(hand));
    }

    private NamedScreenHandlerFactory createScreenHandlerFactory(World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory(
                (id, playerInv, player) -> new EnchantmentScreenHandler(id, playerInv, ScreenHandlerContext.create(world, pos)),
                TITLE
        );
    }
}
