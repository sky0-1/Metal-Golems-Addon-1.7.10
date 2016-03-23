package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemMultiTextured;
import com.golems.main.Config;
import com.golems_addon_metals.content.BlockRedstonePowerProvider;
import com.golems_addon_metals.main.BlockInit;
import com.golems_addon_metals.main.MetalConfig;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityWireCoilGolem extends GolemMultiTextured 
{
	public static final String[] SUFFIXES = new String[] {"copper","electrum","hv"};
	
	public EntityWireCoilGolem(World world) 
	{
		super(world, 2.0F, SUFFIXES);	
	}

	@Override
	public String getModId() 
	{
		return MetalGolems.MODID;
	}

	@Override
	public String getTexturePrefix() 
	{
		return "coil";
	}

	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(14.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel) 
	{
		GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Items.redstone, 8 + rand.nextInt(8 + lootingLevel * 4)));
		GolemBase.addDropEntry(dropList, Items.redstone, 0, 8, 16, lootingLevel * 40);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeStone.soundName;
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		// calling every 2 ticks reduces lag by 50%
		if(MetalConfig.ALLOW_WIRE_SPECIAL && this.ticksExisted % 2 == 0)
		{
			placePowerNearby(false);
		}
	}
	
	@Override
	public boolean interact(EntityPlayer player)
	{
		if(super.interact(player))
		{
			this.placePowerNearby(true);
			return true;
		}
		return false;
	}
	
	/** Finds air blocks nearby and replaces them with BlockMovingPowerSource **/
	public boolean placePowerNearby(boolean replaceCurrent) 
	{
		int x = MathHelper.floor_double(this.posX);
		int y = MathHelper.floor_double(this.posY - 0.20000000298023224D); // y-pos of block below golem
		int z = MathHelper.floor_double(this.posZ);
		
		// power 3 layers at golem location
		for(int k = -1; k < 3; ++k)
		{	
			int yPos = y + k;
			// if the block is air, make it a power block
			if(this.worldObj.isAirBlock(x, yPos, z) || (replaceCurrent && this.worldObj.getBlock(x, yPos, z) instanceof BlockRedstonePowerProvider))
			{
				return this.worldObj.setBlock(x, yPos, z, BlockInit.blockPowerSource, this.getPowerMeta(), 3);
			}
		}
		return false;
	}
	
	private int getPowerMeta()
	{
		switch(this.getTextureNum())
		{
		case 0: return MetalConfig.WIRE_COIL_MIN;
		case 1: return MetalConfig.WIRE_COIL_MID;
		case 2: return MetalConfig.WIRE_COIL_MAX;
		default: return 0;
		}
	}
}