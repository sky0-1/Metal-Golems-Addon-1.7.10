package com.golems_addon_metals.main;

import net.minecraftforge.common.config.Configuration;

/** Registers the config settings to adjust aspects of this mod **/
public class GAMConfig 
{
	public static boolean ALLOW_ALUMINUM;
	public static boolean ALLOW_BRONZE;
	public static boolean ALLOW_CONSTANTAN;
	public static boolean ALLOW_COPPER;
	public static boolean ALLOW_ELECTRUM;
	public static boolean ALLOW_ENDERIUM;
	public static boolean ALLOW_FERROUS;
	public static boolean ALLOW_INVAR;
	public static boolean ALLOW_LEAD;
	public static boolean ALLOW_LUMIUM;
	public static boolean ALLOW_MITHRIL;
	public static boolean ALLOW_REFINED_IRON;
	public static boolean ALLOW_REINF_GLASS;
	public static boolean ALLOW_REINF_STONE;
	public static boolean ALLOW_SHINY;
	public static boolean ALLOW_SIGNALUM;
	public static boolean ALLOW_SILVER;
	public static boolean ALLOW_STEEL;
	public static boolean ALLOW_TIN;
	public static boolean ALLOW_URANIUM;
	
	public static boolean ALLOW_URANIUM_SPECIAL;
	
	
	private static final String CATEGORY_SPAWNS = "spawns";
	private static final String CATEGORY_ABILITY = "abilities";
	
	public static void mainRegistry(Configuration config)
	{
		config.load();
		
		ALLOW_BRONZE = config.getBoolean("Allow Bronze Golem", CATEGORY_SPAWNS, true, 
				"Whether the Bronze Golem can be constructed.");
		ALLOW_COPPER = config.getBoolean("Allow Copper Golem", CATEGORY_SPAWNS, true, 
				"Whether the Copper Golem can be constructed.");
		ALLOW_ELECTRUM = config.getBoolean("Allow Electrum Golem", CATEGORY_SPAWNS, true, 
				"Whether the Electrum Golem can be constructed.");
		ALLOW_ENDERIUM = config.getBoolean("Allow Enderium Golem", CATEGORY_SPAWNS, true, 
				"Whether the Enderium Golem can be constructed.");
		ALLOW_FERROUS = config.getBoolean("Allow Ferrous Golem", CATEGORY_SPAWNS, true, 
				"Whether the Ferrous Golem can be constructed.");
		ALLOW_INVAR = config.getBoolean("Allow Invar Golem", CATEGORY_SPAWNS, true, 
				"Whether the Invar Golem can be constructed.");
		ALLOW_LEAD = config.getBoolean("Allow Lead Golem", CATEGORY_SPAWNS, true, 
				"Whether the Lead Golem can be constructed.");
		ALLOW_LUMIUM = config.getBoolean("Allow Lumium Golem", CATEGORY_SPAWNS, true, 
				"Whether the Lumium Golem can be constructed.");
		ALLOW_MITHRIL = config.getBoolean("Allow Mithril Golem", CATEGORY_SPAWNS, true, 
				"Whether the Mana-Infused (Mithril) Golem can be constructed.");		
		ALLOW_SHINY = config.getBoolean("Allow Platinum Golem", CATEGORY_SPAWNS, true, 
				"Whether the Shiny (Platinum) Golem can be constructed.");
		ALLOW_SIGNALUM = config.getBoolean("Allow Signalum Golem", CATEGORY_SPAWNS, true, 
				"Whether the Signalum Golem can be constructed.");
		ALLOW_SILVER = config.getBoolean("Allow Silver Golem", CATEGORY_SPAWNS, true, 
				"Whether the Silver Golem can be constructed.");
		ALLOW_TIN = config.getBoolean("Allow Tin Golem", CATEGORY_SPAWNS, true, 
				"Whether the Tin Golem can be constructed.");
		
		///////////////////////////////////////////////////////////////////////////////

		ALLOW_ALUMINUM = config.getBoolean("IE: Allow Aluminum Golem", CATEGORY_SPAWNS, true, 
				"Whether the Aluminum Golem can be constructed.");
		ALLOW_STEEL = config.getBoolean("IE: Allow Steel Golem", CATEGORY_SPAWNS, true, 
				"Whether the Steel Golem can be constructed.");
		ALLOW_CONSTANTAN = config.getBoolean("IE: Allow Constantan Golem", CATEGORY_SPAWNS, true, 
				"Whether the Constantan Golem can be constructed.");
		
		///////////////////////////////////////////////////////////////////////////////
		
		ALLOW_REFINED_IRON = config.getBoolean("IC2: Allow Refined Iron Golem", CATEGORY_SPAWNS, true, 
				"Whether the Refined Iron Golem can be constructed.");
		ALLOW_REINF_GLASS = config.getBoolean("IC2: Allow Reinf Glass Golem", CATEGORY_SPAWNS, true, 
				"Whether the Reinforced Glass Golem can be constructed.");
		ALLOW_REINF_STONE = config.getBoolean("IC2: Allow Reinf Stone Golem", CATEGORY_SPAWNS, true, 
				"Whether the Reinforced Stone Golem can be constructed.");
		ALLOW_URANIUM = config.getBoolean("IC2: Allow Uranium Golem", CATEGORY_SPAWNS, true, 
				"Whether the Uranium Block Golem can be constructed.");
		
		//////////////////////////////////////////////////////////////////////////////
		
		ALLOW_URANIUM_SPECIAL = config.getBoolean("IC2: Allow Uranium Golem Special", CATEGORY_ABILITY, true, 
				"Whether the Uranium Golem can poison enemies.");
		
		config.save();
	}
}
