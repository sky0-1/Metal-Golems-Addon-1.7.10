package com.golems_addon_metals.entity;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntitySteelGolem extends GolemIETF
{
	public EntitySteelGolem(World world) 
	{
		super(world, 8.5F);
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(165.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotSteel");
		if(!list.isEmpty()) 
		{
			ItemStack ret = list.get(0);
			ret.stackSize = size;
			return ret;
		}
		else return null;
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}

	@Override
	public String getTexturePrefix() 
	{
		return "steel";
	}
}