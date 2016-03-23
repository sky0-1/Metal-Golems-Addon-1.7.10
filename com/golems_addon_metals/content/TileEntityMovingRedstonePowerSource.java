package com.golems_addon_metals.content;

import java.util.List;

import com.golems.entity.GolemBase;
import com.golems_addon_metals.entity.EntityWireCoilGolem;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityMovingRedstonePowerSource extends TileEntity
{    
	private AxisAlignedBB aabb = (AxisAlignedBB)null;
    public TileEntityMovingRedstonePowerSource() { }

    @Override
    public void updateEntity()
    {
    	List<GolemBase> entityList = worldObj.getEntitiesWithinAABB(GolemBase.class, this.getAABBToCheck(this.xCoord, this.yCoord, this.zCoord));
    	boolean foundGolem = false;
    	// check each entity in the list looking for a wire golem
        for(GolemBase golem : entityList)
        {
            if(golem instanceof EntityWireCoilGolem)
            {
                foundGolem = true;
				break;
            }
        }
        // if no golem was found, delete this tile entity and its block
    	if(!foundGolem)
        {
            if(worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord) instanceof BlockRedstonePowerProvider)
            {
            	worldObj.removeTileEntity(this.xCoord, this.yCoord, this.zCoord);
                worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
            }
        }
    } 
    
    private AxisAlignedBB getAABBToCheck(int x, int y, int z)
    {
    	if(this.aabb == (AxisAlignedBB)null)
    	{
    		this.aabb = AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)x + 1D, (double)y + 1D, (double)z + 1D);
    	}
    	return this.aabb;	
    }
}