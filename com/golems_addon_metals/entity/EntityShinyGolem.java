package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityShinyGolem extends GolemBase
{
	public EntityShinyGolem(World world) 
	{
		super(world, 15.0F);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "shiny"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(210.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.29D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 6 + rand.nextInt(8);
		List<ItemStack> list = OreDictionary.getOres("ingotPlatinum");
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