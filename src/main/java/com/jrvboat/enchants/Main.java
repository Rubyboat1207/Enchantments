package com.jrvboat.enchants;

import com.jrvboat.enchants.CustomEnchantments.Freezing;
import com.jrvboat.enchants.CustomEnchantments.Gilded;
import com.jrvboat.enchants.CustomEnchantments.Withering;
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
	private static Enchantment WITHERING = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "withering"),
			new Withering()
	);
	private static Enchantment Gilded = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier(ModID, "gilded"),
			new Gilded()
	);
	//private static Enchantment FREEZING = Registry.register(
	//		Registry.ENCHANTMENT,
	//		new Identifier(ModID, "freezing"),
	//		new Freezing()
	//);
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
