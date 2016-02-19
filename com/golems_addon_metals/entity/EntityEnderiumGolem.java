package com.golems_addon_metals.entity;

import java.util.ArrayList;

import com.golems.entity.EntityEndstoneGolem;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityEnderiumGolem extends EntityEndstoneGolem
{
	public EntityEnderiumGolem(World world) 
	{
		super(world);
		this.attackDamage = 9.0F;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "enderium"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(95.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotEnderium");
		if(!list.isEmpty()) 
		{
			ItemStack ret = list.get(0);
			ret.stackSize = size;
			return ret;
		}
		else return new ItemStack(Items.ender_pearl, size * 2);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}