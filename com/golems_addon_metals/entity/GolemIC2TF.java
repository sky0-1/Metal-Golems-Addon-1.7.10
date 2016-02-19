package com.golems_addon_metals.entity;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemMultiTextured;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class GolemIC2TF extends GolemMultiTextured
{
	public static final String[] SUFFIXES = {"tf","ic2"};
	
	public GolemIC2TF(World world, float attack) 
	{
		super(world, attack, SUFFIXES);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
	
	@Override
	public String getModId()
	{
		return MetalGolems.MODID;
	}
}