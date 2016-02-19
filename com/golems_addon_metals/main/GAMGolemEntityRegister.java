package com.golems_addon_metals.main;

import com.golems_addon_metals.entity.EntityAluminumGolem;
import com.golems_addon_metals.entity.EntityBronzeGolem;
import com.golems_addon_metals.entity.EntityConstantanGolem;
import com.golems_addon_metals.entity.EntityCopperGolem;
import com.golems_addon_metals.entity.EntityElectrumGolem;
import com.golems_addon_metals.entity.EntityEnderiumGolem;
import com.golems_addon_metals.entity.EntityFerrousGolem;
import com.golems_addon_metals.entity.EntityInvarGolem;
import com.golems_addon_metals.entity.EntityLeadGolem;
import com.golems_addon_metals.entity.EntityLumiumGolem;
import com.golems_addon_metals.entity.EntityMithrilGolem;
import com.golems_addon_metals.entity.EntityRefinedGolem;
import com.golems_addon_metals.entity.EntityReinfGlassGolem;
import com.golems_addon_metals.entity.EntityReinfStoneGolem;
import com.golems_addon_metals.entity.EntityShinyGolem;
import com.golems_addon_metals.entity.EntitySignalumGolem;
import com.golems_addon_metals.entity.EntitySilverGolem;
import com.golems_addon_metals.entity.EntitySteelGolem;
import com.golems_addon_metals.entity.EntityTinGolem;
import com.golems_addon_metals.entity.EntityUraniumGolem;

import cpw.mods.fml.common.registry.EntityRegistry;

public class GAMGolemEntityRegister 
{
	private static int entityIDMetalGolems;

	public static void mainRegistry() 
	{
		entityIDMetalGolems = 0;
		register(EntityAluminumGolem.class, "golem_aluminum");
		register(EntityBronzeGolem.class, "golem_bronze");
		register(EntityConstantanGolem.class, "golem_const");
		register(EntityCopperGolem.class, "golem_copper");
		register(EntityElectrumGolem.class, "golem_electrum");
		register(EntityEnderiumGolem.class, "golem_enderium");
		register(EntityFerrousGolem.class, "golem_ferrous");
		register(EntityInvarGolem.class, "golem_invar");
		register(EntityLeadGolem.class, "golem_lead");
		register(EntityLumiumGolem.class, "golem_lumium");
		register(EntityMithrilGolem.class, "golem_mithril");
		register(EntityRefinedGolem.class, "golem_refined");
		register(EntityReinfGlassGolem.class, "golem_reinf_glass");
		register(EntityReinfStoneGolem.class, "golem_reinf_stone");
		register(EntityShinyGolem.class, "golem_shiny");
		register(EntitySignalumGolem.class, "golem_signalum");
		register(EntitySilverGolem.class, "golem_silver");
		register(EntitySteelGolem.class, "golem_steel");
		register(EntityTinGolem.class, "golem_tin");
		register(EntityUraniumGolem.class, "golem_uranium");
	}

	private static void register(Class entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, ++entityIDMetalGolems, MetalGolems.instance, 48, 3, true);
	}

}
