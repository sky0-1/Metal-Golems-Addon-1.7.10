package com.golems_addon_metals.entity;

import java.util.ArrayList;

import com.golems.entity.GolemBase;
import com.golems.main.Config;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityUraniumGolem extends GolemBase
{
	// TODO balance
	
	public EntityUraniumGolem(World world) 
	{
		super(world, 5.5F);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "uranium"));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(110.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}
	
	/** Attack by adding potion effect as well */
	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(Config.ALLOW_LAPIS_SPECIAL && entity instanceof EntityLivingBase)
			{
				int potionID = entity instanceof EntitySpider ? Potion.wither.id : Potion.poison.id;
				((EntityLivingBase)entity).addPotionEffect(new PotionEffect(potionID, 20 * (2 + rand.nextInt(5)), 1 + rand.nextInt(3)));
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		if(this.getActivePotionEffect(Potion.poison) != null)
		{
			this.removePotionEffect(Potion.poison.id);
		}
	}

	@Override
	public ItemStack getGolemDrops() 
	{
		int size = 6 + rand.nextInt(8);
		ArrayList<ItemStack> list = OreDictionary.getOres("ingotUranium");
		if(!list.isEmpty()) 
		{
			ItemStack ret = list.get(0);
			ret.stackSize = size;
			return ret;
		}
		else return null;
	}

	@Override
	public String getGolemSound() 
	{
		return Block.soundTypeMetal.soundName;
	}
}