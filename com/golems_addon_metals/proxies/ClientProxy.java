package com.golems_addon_metals.proxies;

import com.golems.entity.GolemBase;
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
import com.golems_addon_metals.main.GAMClientEventHandler;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy 
{	
	@Override
	public void registerRenders()
	{		
		register(EntityAluminumGolem.class);
		register(EntityBronzeGolem.class);
		register(EntityConstantanGolem.class);
		register(EntityCopperGolem.class);
		register(EntityElectrumGolem.class);
		register(EntityEnderiumGolem.class);
		register(EntityFerrousGolem.class);
		register(EntityInvarGolem.class);
		register(EntityLeadGolem.class);
		register(EntityLumiumGolem.class);
		register(EntityMithrilGolem.class);
		register(EntityRefinedGolem.class);
		register(EntityReinfGlassGolem.class);
		register(EntityReinfStoneGolem.class);
		register(EntityShinyGolem.class);
		register(EntitySignalumGolem.class);
		register(EntitySilverGolem.class);
		register(EntitySteelGolem.class);
		register(EntityTinGolem.class);
		register(EntityUraniumGolem.class);
	}
	
	@Override
	public void registerEvents()
	{
		MinecraftForge.EVENT_BUS.register(new GAMClientEventHandler());
	}
	
	/**	Registers an entity with the RenderGolem rendering class */
	private void register(Class<? extends GolemBase> golem)
	{
		RenderingRegistry.registerEntityRenderingHandler(golem, new com.golems.renders.RenderGolem());
	}
}
