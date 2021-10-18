package com.jrvboat.enchants;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class BlockHelper {
    public static ArrayList<Block> blocks = new ArrayList<>();
    public static ArrayList<Item> items = new ArrayList<>();


    public static void BlockFactory(String Name, FabricBlockSettings BlockSettings, FabricItemSettings ItemSettings)
    {
        final Block CUSTOMBLOCK = new Block(BlockSettings);
        final Item CUSTOMITEM = new BlockItem(CUSTOMBLOCK, ItemSettings);
        Registry.register(Registry.BLOCK, new Identifier(Main.ModID, Name), CUSTOMBLOCK);
        Registry.register(Registry.ITEM, new Identifier(Main.ModID, Name), CUSTOMITEM);
        blocks.add(CUSTOMBLOCK);
        items.add(CUSTOMITEM);
    }
    public static void BlockFactory(String Name, Block block, FabricItemSettings ItemSettings)
    {
        Registry.register(Registry.BLOCK, new Identifier(Main.ModID, Name), block);
        Registry.register(Registry.ITEM, new Identifier(Main.ModID, Name), new BlockItem(block, ItemSettings));
        blocks.add(block);
    }

}
