package com.golems_addon_metals.proxies;

import com.golems_addon_metals.entity.EntityAluminumGolem;
import com.golems_addon_metals.entity.EntityBronzeGolem;
import com.golems_addon_metals.entity.EntityConstantanGolem;
import com.golems_addon_metals.entity.EntityCopperGolem;
import com.golems_addon_metals.entity.EntityElectrumGolem;
import com.golems_addon_metals.entity.EntityEnderiumGolem;
import com.golems_addon_metals.entity.EntityFerrousGolem;
import com.golems_addon_metals.entity.EntityInsulatorGlassGolem;
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
import com.golems_addon_metals.entity.EntityWireCoilGolem;
import com.golems_addon_metals.main.GAMClientEventHandler;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy 
{	
	@Override
	public void registerRenders()
	{		
		com.golems.proxies.ClientProxy.register(EntityAluminumGolem.class);
		com.golems.proxies.ClientProxy.register(EntityBronzeGolem.class);
		com.golems.proxies.ClientProxy.register(EntityConstantanGolem.class);
		com.golems.proxies.ClientProxy.register(EntityCopperGolem.class);
		com.golems.proxies.ClientProxy.register(EntityElectrumGolem.class);
		com.golems.proxies.ClientProxy.register(EntityEnderiumGolem.class);
		com.golems.proxies.ClientProxy.register(EntityFerrousGolem.class);
		com.golems.proxies.ClientProxy.registerColorized(EntityInsulatorGlassGolem.class);
		com.golems.proxies.ClientProxy.register(EntityInvarGolem.class);
		com.golems.proxies.ClientProxy.register(EntityLeadGolem.class);
		com.golems.proxies.ClientProxy.register(EntityLumiumGolem.class);
		com.golems.proxies.ClientProxy.register(EntityMithrilGolem.class);
		com.golems.proxies.ClientProxy.register(EntityRefinedGolem.class);
		com.golems.proxies.ClientProxy.register(EntityReinfGlassGolem.class);
		com.golems.proxies.ClientProxy.register(EntityReinfStoneGolem.class);
		com.golems.proxies.ClientProxy.register(EntityShinyGolem.class);
		com.golems.proxies.ClientProxy.register(EntitySignalumGolem.class);
		com.golems.proxies.ClientProxy.register(EntitySilverGolem.class);
		com.golems.proxies.ClientProxy.register(EntitySteelGolem.class);
		com.golems.proxies.ClientProxy.register(EntityTinGolem.class);
		com.golems.proxies.ClientProxy.register(EntityWireCoilGolem.class);
		com.golems.proxies.ClientProxy.register(EntityUraniumGolem.class);
	}
	
	@Override
	public void registerEvents()
	{
		MinecraftForge.EVENT_BUS.register(new GAMClientEventHandler());
	}
}
