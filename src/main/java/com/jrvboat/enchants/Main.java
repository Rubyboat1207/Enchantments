package com.jrvboat.enchants;

import com.jrvboat.enchants.CustomEnchantments.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
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
	private static final Enchantment WITHERING = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "withering"),
			new Withering()
	);
	private static final Enchantment FREEZING = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "freezing"),
			new Freezing()
	);
	private static final Enchantment Gilded = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "gilded"),
			new Gilded()
	);
	private static final Enchantment THUNDERSTRUCK = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "thunderstruck"),
			new ThunderStruck()
	);
	private static final Enchantment EXPERIENCE = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "experience"),
			new Experience()
	);
	private static final Enchantment REMEDY = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "remedy"),
			new remedy()
	);
	private static final Enchantment HOTHEADED = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "hot_headed"),
			new HotHeaded()
	);
	/*public static Enchantment MARTYRDOM = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "martyrdom"),
			new Martyrdom()
	);*/
	public static Enchantment BOTTOMLESS = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "bottomless"),
			new Bottomless()
	);
	public static Enchantment WATERWALKER = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "waterwalker"),
			new WaterWalker()
	);
	public static final Enchantment LUNAR = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "lunar"),
			new Lunar()
	);
	/*public static final Enchantment VEXPROTECTIONG = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "vexprotection"),
			new VexProtection()
	);*/
	//public static BlockEntityType<EnrichingStationEntity> ENRICHING_STATION_ENTITY;
	//public static EnrichingStation ENRICHING_STATION = new EnrichingStation(FabricBlockSettings.of(Material.WOOL));
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		//BlockHelper.BlockFactory("enriching_station", ENRICHING_STATION, new FabricItemSettings().group(ItemGroup.DECORATIONS));
		//ENRICHING_STATION_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModID, "quiver"), FabricBlockEntityTypeBuilder.create(EnrichingStationEntity::new, ENRICHING_STATION).build(null));
	}
}
