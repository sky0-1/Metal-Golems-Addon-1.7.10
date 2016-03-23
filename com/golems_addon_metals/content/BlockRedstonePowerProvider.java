package com.golems_addon_metals.content;

import com.golems.content.BlockPowerProvider;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstonePowerProvider extends BlockPowerProvider 
{
	public BlockRedstonePowerProvider() 
	{
		super(1);
	}
	
	@Override
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int par5)
    {
        return world.getBlockMetadata(x, y, z);
    }
    
    @Override
    public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int par5) 
    {
        return world.getBlockMetadata(x, y, z);
    }

	@Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityMovingRedstonePowerSource();
    }
}
