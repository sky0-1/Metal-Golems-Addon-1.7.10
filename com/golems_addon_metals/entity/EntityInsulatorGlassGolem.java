package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems.entity.GolemColorized;
import com.golems_addon_metals.main.MetalGolems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class EntityInsulatorGlassGolem extends GolemColorized 
{
	public static final ResourceLocation BASE = GolemBase.getGolemTexture(MetalGolems.MODID, "insulator_glass");
	public static final ResourceLocation OVERLAY = GolemBase.getGolemTexture(MetalGolems.MODID, "insulator_glass_overlay");
	
	public EntityInsulatorGlassGolem(World world) 
	{
		super(world, 5.0F, 0xDC573, BASE, OVERLAY);
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel) 
	{
		GolemBase.addDropEntry(dropList, Blocks.glass, 0, 1, 4, 60 + lootingLevel * 8);
	}

	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeGlass.soundName;
	}
	
	/**
     * Whether {@link overlay} should be rendered as transparent.
     * This is not called for rendering {@link base},
     * only for rendering the colorized layer.
     **/
    @SideOnly(Side.CLIENT)
    public boolean hasTransparency()
    {
    	return true;
    }
}
