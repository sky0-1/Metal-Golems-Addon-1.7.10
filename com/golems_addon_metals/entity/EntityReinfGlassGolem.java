package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityReinfGlassGolem extends GolemBase
{	
	public EntityReinfGlassGolem(World world) 
	{
		super(world, 8.5F);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "reinforced_glass"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(65.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}
	
	@Override
	protected void damageEntity(DamageSource source, float amount) 
	{ 
		super.damageEntity(source, amount / 2);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 1 + rand.nextInt(3) + lootingLevel * 2;
		GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Blocks.glass, size > 16 ? 16 : size));
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}