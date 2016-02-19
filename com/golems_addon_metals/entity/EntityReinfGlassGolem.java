package com.golems_addon_metals.entity;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityReinfGlassGolem extends GolemBase
{
	// TODO balance
	
	public EntityReinfGlassGolem(World world) 
	{
		super(world, 7.5F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "reinforced_glass"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(65.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}
	
	@Override
	protected void damageEntity(DamageSource source, float amount) 
	{ 
		super.damageEntity(source, amount / 2);
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 1 + rand.nextInt(3);
		return new ItemStack(Blocks.glass, size);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}