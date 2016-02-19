package com.golems_addon_metals.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityRefinedGolem extends GolemBase
{
	// TODO balance
	
	public EntityRefinedGolem(World world) 
	{
		super(world, 7.5F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "refined_iron"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(125.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 8 + rand.nextInt(14);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotRefinedIron");
		if(!list.isEmpty()) 
		{
			ItemStack ret = list.get(0);
			ret.stackSize = size;
			return ret;
		}
		else return new ItemStack(Items.iron_ingot, size * 2);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}