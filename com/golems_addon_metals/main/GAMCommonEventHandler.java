package com.golems_addon_metals.main;

import java.util.ArrayList;

import com.golems.events.GolemBuildEvent;
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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GAMCommonEventHandler 
{
	@SubscribeEvent
	public void onBuildGolem(GolemBuildEvent event)
	{
		if(event.isGolemNull())
		{
			String name = event.blockBelow.getUnlocalizedName();
			// debug:
			//String message = "Unlocalized Name = '" + name + "' - meta = " + event.blockMeta;
			//FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().sendChatMsg(new ChatComponentText(message));	
			if(event.areBlocksSameMeta)
			{	
				///////// first, generic oredict lookups /////////
				if(this.matchesOreDict(event.blockBelow, "blockBronze"))
				{
					event.setGolem(new EntityBronzeGolem(event.worldObj), GAMConfig.ALLOW_BRONZE);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockCopper"))
				{
					event.setGolem(new EntityCopperGolem(event.worldObj), GAMConfig.ALLOW_COPPER);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockElectrum"))
				{
					event.setGolem(new EntityElectrumGolem(event.worldObj), GAMConfig.ALLOW_ELECTRUM);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockNickel"))
				{
					event.setGolem(new EntityFerrousGolem(event.worldObj), GAMConfig.ALLOW_FERROUS);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockInvar"))
				{
					event.setGolem(new EntityInvarGolem(event.worldObj), GAMConfig.ALLOW_INVAR);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockLead"))
				{
					event.setGolem(new EntityLeadGolem(event.worldObj), GAMConfig.ALLOW_LEAD);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockSteel"))
				{
					event.setGolem(new EntityRefinedGolem(event.worldObj), GAMConfig.ALLOW_REFINED_IRON);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockSilver"))
				{
					event.setGolem(new EntitySilverGolem(event.worldObj), GAMConfig.ALLOW_SILVER);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockTin"))
				{
					event.setGolem(new EntityTinGolem(event.worldObj), GAMConfig.ALLOW_TIN);
				}
				///////// next, check against mod-specific block names /////////
				if(name.equalsIgnoreCase("tile.thermalfoundation.storage"))
				{
					// if blockBelow is thermal foundation metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), GAMConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), GAMConfig.ALLOW_TIN);
					break;
					case 2:		event.setGolem(new EntitySilverGolem(event.worldObj), GAMConfig.ALLOW_SILVER);
					break;
					case 3: 	event.setGolem(new EntityLeadGolem(event.worldObj), GAMConfig.ALLOW_LEAD);
					break;
					case 4:		event.setGolem(new EntityFerrousGolem(event.worldObj), GAMConfig.ALLOW_FERROUS);
					break;
					case 5:		event.setGolem(new EntityShinyGolem(event.worldObj), GAMConfig.ALLOW_SHINY);
					break;
					case 6:		event.setGolem(new EntityMithrilGolem(event.worldObj), GAMConfig.ALLOW_MITHRIL);
					break;
					case 7:		event.setGolem(new EntityElectrumGolem(event.worldObj), GAMConfig.ALLOW_ELECTRUM);
					break;
					case 8:		event.setGolem(new EntityInvarGolem(event.worldObj), GAMConfig.ALLOW_INVAR);
					break;
					case 9:		event.setGolem(new EntityBronzeGolem(event.worldObj), GAMConfig.ALLOW_BRONZE);
					break;
					case 10:	event.setGolem(new EntitySignalumGolem(event.worldObj), GAMConfig.ALLOW_SIGNALUM);
					break;
					case 11:	event.setGolem(new EntityLumiumGolem(event.worldObj), GAMConfig.ALLOW_LUMIUM);
					break;
					case 12:	event.setGolem(new EntityEnderiumGolem(event.worldObj), GAMConfig.ALLOW_ENDERIUM);
					break;
					}
				}
				else if(name.equalsIgnoreCase("blockMetal"))
				{
					// if blockBelow is IC2 metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), GAMConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), GAMConfig.ALLOW_TIN);
					break;
					case 2:		event.setGolem(new EntityBronzeGolem(event.worldObj), GAMConfig.ALLOW_BRONZE);
					break;
					case 3:		event.setGolem(new EntityUraniumGolem(event.worldObj), GAMConfig.ALLOW_URANIUM);
					break;
					case 4: 	event.setGolem(new EntityLeadGolem(event.worldObj), GAMConfig.ALLOW_LEAD);
					break;
					case 5: 	event.setGolem(new EntityRefinedGolem(event.worldObj), GAMConfig.ALLOW_REFINED_IRON);
					break;
					}
				}		
				else if(name.equalsIgnoreCase("blockAlloy"))
				{
					// IC2 reinforced stone block
					event.setGolem(new EntityReinfStoneGolem(event.worldObj), GAMConfig.ALLOW_REINF_STONE);
				}
				else if(name.equalsIgnoreCase("blockAlloyGlass"))
				{
					// IC2 reinforced glass block
					event.setGolem(new EntityReinfGlassGolem(event.worldObj), GAMConfig.ALLOW_REINF_GLASS);
				}
				// TINKERS' CONSTRUCT
				else if(name.equalsIgnoreCase("tile.tconstruct.metalblock"))
				{
					if(event.areBlocksSameMeta)
					{
						switch(event.blockMeta)
						{
						case 3: event.setGolem(new EntityCopperGolem(event.worldObj), GAMConfig.ALLOW_COPPER);
						break;
						case 4: event.setGolem(new EntityBronzeGolem(event.worldObj), GAMConfig.ALLOW_BRONZE);
						break;
						case 5: event.setGolem(new EntityTinGolem(event.worldObj), GAMConfig.ALLOW_TIN);
						break;
						case 6: event.setGolem(new EntityAluminumGolem(event.worldObj), GAMConfig.ALLOW_ALUMINUM);
						break;
						case 9: event.setGolem(new EntitySteelGolem(event.worldObj), GAMConfig.ALLOW_STEEL);
						break;
						}
					}
				}
				// IMMERSIVE ENGINEERING
				else if(name.equalsIgnoreCase("tile.ImmersiveEngineering.storage"))
				{
					if(event.areBlocksSameMeta)
					{
						// if blockBelow is IE metal block, use metadata to pick GolemBase
						switch(event.blockMeta)
						{
						case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), GAMConfig.ALLOW_COPPER);
						break;
						case 1:		event.setGolem(new EntityAluminumGolem(event.worldObj), GAMConfig.ALLOW_ALUMINUM);
						break;
						case 2:		event.setGolem(new EntityLeadGolem(event.worldObj), GAMConfig.ALLOW_LEAD);
						break;
						case 3:		event.setGolem(new EntitySilverGolem(event.worldObj), GAMConfig.ALLOW_SILVER);
						break;
						case 4:		event.setGolem(new EntityFerrousGolem(event.worldObj), GAMConfig.ALLOW_FERROUS);
						break;
						case 5:		event.setGolem(new EntityConstantanGolem(event.worldObj), GAMConfig.ALLOW_CONSTANTAN);
						break;
						case 6:		event.setGolem(new EntityElectrumGolem(event.worldObj), GAMConfig.ALLOW_ELECTRUM);
						break;
						case 7:		event.setGolem(new EntitySteelGolem(event.worldObj), GAMConfig.ALLOW_STEEL);
						break;
						}
					}
				}
			} // end "are blocks same meta" check
		}
	}

	public boolean matchesOreDict(Block block, String toCheck)
	{
		ItemStack oreStack = new ItemStack(block);
		ArrayList<ItemStack> stackCheck = OreDictionary.getOres(toCheck);	
		boolean flag = !stackCheck.isEmpty() && oreStack.equals(stackCheck.get(0));
		// debug:
		//System.out.print("checking OreDict for '" + toCheck + "' for block '" + oreStack.getItem().getUnlocalizedName(oreStack) + "' and result is " + flag + "\n");
		return flag;
	}
}
