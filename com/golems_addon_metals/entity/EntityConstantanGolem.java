package com.golems_addon_metals.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityConstantanGolem extends GolemBase
{
	public EntityConstantanGolem(World world) 
	{
		super(world, 7.0F);
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "constantan"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(110.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 1 + rand.nextInt(3);
		ArrayList<ItemStack> list = OreDictionary.getOres("blockConstantan");
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