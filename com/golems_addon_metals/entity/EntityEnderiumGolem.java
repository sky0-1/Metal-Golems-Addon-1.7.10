package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.EntityEndstoneGolem;
import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalConfig;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityEnderiumGolem extends EntityEndstoneGolem
{
	public EntityEnderiumGolem(World world) 
	{
		super(world, 9.0F, 48.0D, MetalConfig.ALLOW_ENDERIUM_SPECIAL, true);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "enderium"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(95.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 6 + rand.nextInt(8);
		List<ItemStack> list = OreDictionary.getOres("ingotEnderium");
		if(!list.isEmpty()) 
		{
			ItemStack stack = list.get(0);
			stack.stackSize = size;
			GolemBase.addGuaranteedDropEntry(dropList, stack);
		}
		GolemBase.addDropEntry(dropList, Items.ender_pearl, 0, size, size * 2, 50 + (list.isEmpty() ? 50 : lootingLevel * 4));
		GolemBase.addDropEntry(dropList, Items.ender_eye, 0, 1, 1, 5 + lootingLevel * 10);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}