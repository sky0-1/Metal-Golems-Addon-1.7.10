package com.golems_addon_metals.main;

import java.util.List;

import com.golems.events.GolemBuildEvent;
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
					event.setGolem(new EntityBronzeGolem(event.worldObj), MetalConfig.ALLOW_BRONZE);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockCopper"))
				{
					event.setGolem(new EntityCopperGolem(event.worldObj), MetalConfig.ALLOW_COPPER);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockElectrum"))
				{
					event.setGolem(new EntityElectrumGolem(event.worldObj), MetalConfig.ALLOW_ELECTRUM);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockNickel"))
				{
					event.setGolem(new EntityFerrousGolem(event.worldObj), MetalConfig.ALLOW_FERROUS);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockInvar"))
				{
					event.setGolem(new EntityInvarGolem(event.worldObj), MetalConfig.ALLOW_INVAR);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockLead"))
				{
					event.setGolem(new EntityLeadGolem(event.worldObj), MetalConfig.ALLOW_LEAD);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockSteel"))
				{
					event.setGolem(new EntityRefinedGolem(event.worldObj), MetalConfig.ALLOW_REFINED_IRON);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockSilver"))
				{
					event.setGolem(new EntitySilverGolem(event.worldObj), MetalConfig.ALLOW_SILVER);
				}
				else if(this.matchesOreDict(event.blockBelow, "blockTin"))
				{
					event.setGolem(new EntityTinGolem(event.worldObj), MetalConfig.ALLOW_TIN);
				}
				///////// next, check against mod-specific block names /////////
				if(name.equalsIgnoreCase("tile.thermalfoundation.storage"))
				{
					// if blockBelow is thermal foundation metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), MetalConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), MetalConfig.ALLOW_TIN);
					break;
					case 2:		event.setGolem(new EntitySilverGolem(event.worldObj), MetalConfig.ALLOW_SILVER);
					break;
					case 3: 	event.setGolem(new EntityLeadGolem(event.worldObj), MetalConfig.ALLOW_LEAD);
					break;
					case 4:		event.setGolem(new EntityFerrousGolem(event.worldObj), MetalConfig.ALLOW_FERROUS);
					break;
					case 5:		event.setGolem(new EntityShinyGolem(event.worldObj), MetalConfig.ALLOW_SHINY);
					break;
					case 6:		event.setGolem(new EntityMithrilGolem(event.worldObj), MetalConfig.ALLOW_MITHRIL);
					break;
					case 7:		event.setGolem(new EntityElectrumGolem(event.worldObj), MetalConfig.ALLOW_ELECTRUM);
					break;
					case 8:		event.setGolem(new EntityInvarGolem(event.worldObj), MetalConfig.ALLOW_INVAR);
					break;
					case 9:		event.setGolem(new EntityBronzeGolem(event.worldObj), MetalConfig.ALLOW_BRONZE);
					break;
					case 10:	event.setGolem(new EntitySignalumGolem(event.worldObj), MetalConfig.ALLOW_SIGNALUM);
					break;
					case 11:	event.setGolem(new EntityLumiumGolem(event.worldObj), MetalConfig.ALLOW_LUMIUM);
					break;
					case 12:	event.setGolem(new EntityEnderiumGolem(event.worldObj), MetalConfig.ALLOW_ENDERIUM);
					break;
					}
				}
				else if(name.equalsIgnoreCase("blockMetal"))
				{
					// if blockBelow is IC2 metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), MetalConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityTinGolem(event.worldObj), MetalConfig.ALLOW_TIN);
					break;
					case 2:		event.setGolem(new EntityBronzeGolem(event.worldObj), MetalConfig.ALLOW_BRONZE);
					break;
					case 3:		event.setGolem(new EntityUraniumGolem(event.worldObj), MetalConfig.ALLOW_URANIUM);
					break;
					case 4: 	event.setGolem(new EntityLeadGolem(event.worldObj), MetalConfig.ALLOW_LEAD);
					break;
					case 5: 	event.setGolem(new EntityRefinedGolem(event.worldObj), MetalConfig.ALLOW_REFINED_IRON);
					break;
					}
				}		
				else if(name.equalsIgnoreCase("blockAlloy"))
				{
					// IC2 reinforced stone block
					event.setGolem(new EntityReinfStoneGolem(event.worldObj), MetalConfig.ALLOW_REINF_STONE);
				}
				else if(name.equalsIgnoreCase("blockAlloyGlass"))
				{
					// IC2 reinforced glass block
					event.setGolem(new EntityReinfGlassGolem(event.worldObj), MetalConfig.ALLOW_REINF_GLASS);
				}
				// TINKERS' CONSTRUCT
				else if(name.equalsIgnoreCase("tile.tconstruct.metalblock"))
				{
					switch(event.blockMeta)
					{
					case 3: event.setGolem(new EntityCopperGolem(event.worldObj), MetalConfig.ALLOW_COPPER);
					break;
					case 4: event.setGolem(new EntityBronzeGolem(event.worldObj), MetalConfig.ALLOW_BRONZE);
					break;
					case 5: event.setGolem(new EntityTinGolem(event.worldObj), MetalConfig.ALLOW_TIN);
					break;
					case 6: event.setGolem(new EntityAluminumGolem(event.worldObj), MetalConfig.ALLOW_ALUMINUM);
					break;
					case 9: event.setGolem(new EntitySteelGolem(event.worldObj), MetalConfig.ALLOW_STEEL);
					break;
					}
				}
				// IMMERSIVE ENGINEERING
				else if(name.equalsIgnoreCase("tile.ImmersiveEngineering.storage"))
				{
					// if blockBelow is IE metal block, use metadata to pick GolemBase
					switch(event.blockMeta)
					{
					case 0:		event.setGolem(new EntityCopperGolem(event.worldObj), MetalConfig.ALLOW_COPPER);
					break;
					case 1:		event.setGolem(new EntityAluminumGolem(event.worldObj), MetalConfig.ALLOW_ALUMINUM);
					break;
					case 2:		event.setGolem(new EntityLeadGolem(event.worldObj), MetalConfig.ALLOW_LEAD);
					break;
					case 3:		event.setGolem(new EntitySilverGolem(event.worldObj), MetalConfig.ALLOW_SILVER);
					break;
					case 4:		event.setGolem(new EntityFerrousGolem(event.worldObj), MetalConfig.ALLOW_FERROUS);
					break;
					case 5:		event.setGolem(new EntityConstantanGolem(event.worldObj), MetalConfig.ALLOW_CONSTANTAN);
					break;
					case 6:		event.setGolem(new EntityElectrumGolem(event.worldObj), MetalConfig.ALLOW_ELECTRUM);
					break;
					case 7:		event.setGolem(new EntitySteelGolem(event.worldObj), MetalConfig.ALLOW_STEEL);
					break;
					case 8:	case 9:	case 10:	event.setGolem(new EntityWireCoilGolem(event.worldObj), MetalConfig.ALLOW_WIRE_COIL); 
					break;
					}
				}
				else if(name.equalsIgnoreCase("tile.ImmersiveEngineering.stoneDevice") && event.blockMeta == 4)
				{
					event.setGolem(new EntityInsulatorGlassGolem(event.worldObj), MetalConfig.ALLOW_INSULATED_GLASS);
				}
			} // end "are blocks same meta" check
		}
	}

	public static boolean matchesOreDict(Block block, String toCheck)
	{
		if(OreDictionary.doesOreNameExist(toCheck)) 
		{
			ItemStack passedBlock = new ItemStack(block);
			List<ItemStack> matches = OreDictionary.getOres(toCheck);
			return matches.isEmpty() ? false : OreDictionary.itemMatches(passedBlock, matches.get(0), true);
		}
		else return false;
	}
}
