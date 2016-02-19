package com.golems_addon_metals.main;

import com.golems.events.GolemPaperAddInfoEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class GAMClientEventHandler 
{
	private static final String loreIntroTF = new ChatComponentTranslation(
			EnumChatFormatting.WHITE + "Thermal Foundation materials:").getFormattedText();
	private static final String loreIntroIC2 = new ChatComponentTranslation(
			EnumChatFormatting.WHITE + "IndustrialCraft 2 materials:").getFormattedText();
	
	@SubscribeEvent
	public void onAddInfo(GolemPaperAddInfoEvent event)
	{
		event.infoList.add(loreIntroTF);
		event.infoList.add("Bronze Block, Copper Block,");
		event.infoList.add("Electrum Block, Enderium Block,");
		event.infoList.add("Ferrous Block, Invar Block,");
		event.infoList.add("Lead Block, Lumium Block,");
		event.infoList.add("Mana Infused Block, Shiny Block,");
		event.infoList.add("Signalum Block, Silver Block,");
		event.infoList.add("Tin Block");
		event.infoList.add(loreIntroIC2);
		event.infoList.add("Refined Iron Block, Reinforced");
		event.infoList.add("Glass Block, Reinforced Stone Block,");
		event.infoList.add("Uranium Block");
	}
}
