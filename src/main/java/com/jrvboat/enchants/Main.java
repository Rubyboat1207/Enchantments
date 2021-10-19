package com.jrvboat.enchants;

import com.jrvboat.enchants.CustomEnchantments.*;
import com.jrvboat.enchants.blocks.EnrichingStationEntity;
import com.jrvboat.enchants.items.EnchantTable;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");
	public static String ModID = "rbjrvench";
	private static Enchantment WITHERING = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "withering"),
			new Withering()
	);
	private static Enchantment FREEZING = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "freezing"),
			new Freezing()
	);
	private static Enchantment Gilded = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "gilded"),
			new Gilded()
	);
	private static Enchantment THUNDERSTRUCK = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "thunderstruck"),
			new ThunderStruck()
	);
	private static Enchantment EXPERIENCE = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "experience"),
			new Experience()
	);
	private static Enchantment REMEDY = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "remedy"),
			new remedy()
	);
	private static Enchantment HOTHEADED = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "hot_headed"),
			new HotHeaded()
	);
	public static Enchantment MARTYRDOM = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "martyrdom"),
			new Martyrdom()
	);
	public static Enchantment BOTTOMLESS = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "bottomless"),
			new Bottomless()
	);
	//public static Enchantment WATERWALKER = Registry.register(
			//Registry.ENCHANTMENT,
			//new Identifier(ModID, "waterwalker"),
			//new WaterWalker()
	//);
	public static Enchantment LUNAR = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "lunar"),
			new Lunar()
	);
	public static Item ENCHANTMENT_TABLE = Registry.register(
			Registry.ITEM,
			new Identifier(ModID, "enchant_table_on_a_stick"),
			new EnchantTable(new FabricItemSettings().maxCount(1))
	);
	public static Enchantment VEXPROTECTIONG = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "vexprotection"),
			new VexProtection()
	);
	//public static BlockEntityType<EnrichingStationEntity> ENRICHING_STATION_ENTITY;
	//public static EnrichingStation ENRICHING_STATION = new EnrichingStation(FabricBlockSettings.of(Material.WOOL));
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		//BlockHelper.BlockFactory("enriching_station", ENRICHING_STATION, new FabricItemSettings().group(ItemGroup.DECORATIONS));
		//ENRICHING_STATION_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModID, "quiver"), FabricBlockEntityTypeBuilder.create(EnrichingStationEntity::new, ENRICHING_STATION).build(null));
	}
}
