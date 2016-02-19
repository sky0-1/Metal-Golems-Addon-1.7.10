package com.golems_addon_metals.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityFerrousGolem extends GolemBase
{
	public EntityFerrousGolem(World world) 
	{
		super(world, 7.5F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "ferrous"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.31D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotNickel");
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
}