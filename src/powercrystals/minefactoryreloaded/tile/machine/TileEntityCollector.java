package powercrystals.minefactoryreloaded.tile.machine;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;

import powercrystals.core.util.UtilInventory;
import powercrystals.minefactoryreloaded.core.IEntityCollidable;
import powercrystals.minefactoryreloaded.core.MFRUtil;
import powercrystals.minefactoryreloaded.setup.Machine;
import powercrystals.minefactoryreloaded.tile.base.TileEntityFactoryInventory;

public class TileEntityCollector extends TileEntityFactoryInventory implements IEntityCollidable
{
	public TileEntityCollector()
	{
		super(Machine.ItemCollector);
		setManageSolids(true);
	}

	@Override
	public void onEntityCollided(Entity entity)
	{
		if (entity instanceof EntityItem && !entity.isDead)
			addToChests((EntityItem)entity);
	}

	protected void addToChests(EntityItem i)
	{
		if (i.isDead)
			return;
		
		ItemStack s = i.getEntityItem();
		s = UtilInventory.dropStack(this, s, MFRUtil.directionsWithoutConveyors(worldObj, xCoord, yCoord, zCoord), ForgeDirection.UNKNOWN);
		if(s == null)
		{
			i.setDead();
			return;
		}
		i.setEntityItemStack(s);
	}
	
	@Override
	public boolean canUpdate()
	{
		return false;
	}
	
	@Override
	public int getSizeInventory()
	{
		return 0;
	}
}
