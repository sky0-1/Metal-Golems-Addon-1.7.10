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

public class EntityReinfStoneGolem extends GolemBase
{	
	public EntityReinfStoneGolem(World world) 
	{
		super(world, 6.5F);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "reinforced_stone"));
	}
		
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(125.0D);
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
		int size = 4 + rand.nextInt(6) + lootingLevel;
		GolemBase.addGuaranteedDropEntry(dropList, new ItemStack(Blocks.stone, size));
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}