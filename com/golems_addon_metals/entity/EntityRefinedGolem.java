package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityRefinedGolem extends GolemBase
{	
	public EntityRefinedGolem(World world) 
	{
		super(world, 7.5F);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "refined_iron"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(125.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 8 + rand.nextInt(14) + lootingLevel * 5;
		List<ItemStack> list = OreDictionary.getOres("ingotRefinedIron");
		if(!list.isEmpty()) 
		{
			ItemStack stack = list.get(0);
			stack.stackSize = size;
			GolemBase.addGuaranteedDropEntry(dropList, stack);
		}
		else GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Items.iron_ingot, size * 2));
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}