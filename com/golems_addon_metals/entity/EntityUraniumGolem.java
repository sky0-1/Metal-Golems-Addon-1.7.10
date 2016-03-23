package com.golems_addon_metals.entity;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.main.MetalConfig;
import com.golems_addon_metals.main.MetalGolems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class EntityUraniumGolem extends GolemBase
{	
	public EntityUraniumGolem(World world) 
	{
		super(world, 4.5F);
	}

	@Override
	protected void applyTexture()
	{
		this.setTextureType(this.getGolemTexture(MetalGolems.MODID, "uranium"));
	}
	
	@Override
	protected void applyAttributes() 
	{
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24D);
	}
	
	/** Attack by adding potion effect as well */
	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(entity instanceof EntityLivingBase)
			{
				poisonEntity((EntityLivingBase)entity);
			}
			return true;
		}
		return false;
	}
	
	public void poisonEntity(EntityLivingBase entity)
	{
		if(MetalConfig.ALLOW_URANIUM_SPECIAL)
		{
			int potionID = entity instanceof EntitySpider ? Potion.wither.id : Potion.poison.id;
			entity.addPotionEffect(new PotionEffect(potionID, 20 * (2 + rand.nextInt(5)), 1 + rand.nextInt(3)));
		}
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
		List<EntityLivingBase> entities = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(1.5D, 1.5D, 1.5D));
		for(EntityLivingBase e : entities)
		{
			if(e != this)
			{
				poisonEntity(e);
			}
		}
		
		if(rand.nextInt(10000) < 10)
		{
			// mimics "half-life" of uranium :P
			this.damageEntity(DamageSource.magic, 2F);
		}
	}

	@Override
	public void addGolemDrops(List<WeightedRandomChestContent> dropList, boolean recentlyHit, int lootingLevel)
	{
		int size = 6 + rand.nextInt(8);
		List<ItemStack> list = OreDictionary.getOres("ingotUranium");
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