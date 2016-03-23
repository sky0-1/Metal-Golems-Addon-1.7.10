package com.golems_addon_metals.main;

import com.golems_addon_metals.content.BlockRedstonePowerProvider;
import com.golems_addon_metals.content.TileEntityMovingRedstonePowerSource;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockInit 
{
	public static Block blockPowerSource;
	
	public static void mainRegistry()
	{
		blockPowerSource = new BlockRedstonePowerProvider().setBlockName("redstone_power_provider");
		
		GameRegistry.registerTileEntity(TileEntityMovingRedstonePowerSource.class, MetalGolems.MODID + "_TileEntityMovingRedstonePowerSource");
		
		GameRegistry.registerBlock(blockPowerSource, blockPowerSource.getUnlocalizedName());
	}
}
