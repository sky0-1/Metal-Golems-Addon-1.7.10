package com.golems_addon_metals.entity;

import java.util.ArrayList;
import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityFerrousGolem extends GolemBase
{
	public EntityFerrousGolem(World world) 
	{
		super(world, 7.5F);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "ferrous"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(150.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.31D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 6 + rand.nextInt(8);
		List<ItemStack> list = OreDictionary.getOres("ingotNickel");
		if(!list.isEmpty()) 
		{
			ItemStack stack = list.get(0);
			stack.stackSize = size;
			GolemBase.addGuaranteedDropEntry(dropList, stack);
		}
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}