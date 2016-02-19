package com.golems_addon_metals.main;

import com.golems_addon_metals.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = MetalGolems.MODID, name = MetalGolems.NAME, version = MetalGolems.VERSION, dependencies = "required-after:" + MetalGolems.DEPENDENCY_MODID, acceptedMinecraftVersions = MetalGolems.MCVERSION)
public class MetalGolems 
{
	public static final String MODID = "golems_addon_metals";
	public static final String DEPENDENCY_MODID = "golems";
	public static final String NAME = "Metal Golems Addon";
	public static final String VERSION = "1.11";
	public static final String MCVERSION = "1.7.10";
	public static final String CLIENT = "com." + MODID + ".proxies.ClientProxy";
	public static final String SERVER = "com." + MODID + ".proxies.CommonProxy";
	
	@Mod.Instance(MetalGolems.MODID)
	public static MetalGolems instance;
	
	@SidedProxy(clientSide = MetalGolems.CLIENT, serverSide = MetalGolems.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{	
		GAMConfig.mainRegistry(new Configuration(event.getSuggestedConfigurationFile()));
		GAMGolemEntityRegister.mainRegistry();
		proxy.registerRenders();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new GAMCommonEventHandler());
		proxy.registerEvents();
	}
}

