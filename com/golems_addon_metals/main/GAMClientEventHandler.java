package com.golems_addon_metals.main;

import com.golems.events.GolemPaperAddInfoEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class GAMClientEventHandler 
{	
	@SubscribeEvent
	public void onAddInfo(GolemPaperAddInfoEvent event)
	{
		String loreIntroTF = EnumChatFormatting.WHITE + "Thermal Foundation materials:";
		event.infoList.add(loreIntroTF);
		event.infoList.add("Bronze Block, Copper Block,");
		event.infoList.add("Electrum Block, Enderium Block,");
		event.infoList.add("Ferrous Block, Invar Block,");
		event.infoList.add("Lead Block, Lumium Block,");
		event.infoList.add("Mana Infused Block, Shiny Block,");
		event.infoList.add("Signalum Block, Silver Block, Tin Block");
		String loreIntroIC2 = EnumChatFormatting.WHITE + "IndustrialCraft 2 materials:";
		event.infoList.add(loreIntroIC2);
		event.infoList.add("Refined Iron Block, Reinforced Glass,");
		event.infoList.add("Reinforced Stone, Uranium Block");
		String loreIntroIE = EnumChatFormatting.WHITE + "Immersive Engineering materials:";
		event.infoList.add(loreIntroIE);
		event.infoList.add("Constantan Block, Insulated Glass,");
		event.infoList.add("Wire Coil Block (any)");
	}
}
