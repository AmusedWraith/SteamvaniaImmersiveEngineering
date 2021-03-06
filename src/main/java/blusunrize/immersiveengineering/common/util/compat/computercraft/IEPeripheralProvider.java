package blusunrize.immersiveengineering.common.util.compat.computercraft;

import blusunrize.immersiveengineering.common.blocks.TileEntityIEBase;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityArcFurnace;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityAssembler;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityBottlingMachine;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityCapacitorCreative;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityCapacitorHV;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityCapacitorLV;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityCapacitorMV;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityCrusher;

import blusunrize.immersiveengineering.common.blocks.metal.TileEntityExcavator;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityFermenter;

import blusunrize.immersiveengineering.common.blocks.metal.TileEntityRefinery;

import blusunrize.immersiveengineering.common.blocks.metal.TileEntitySqueezer;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class IEPeripheralProvider implements IPeripheralProvider
{

	@Override
	public IPeripheral getPeripheral(World world, int x, int y, int z, int side)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityIEBase)
		{

			if (te instanceof TileEntityCrusher)
			{
				TileEntityCrusher crush = (TileEntityCrusher) te;
				if (crush.pos==9&&crush.facing==side)
					return new PeripheralCrusher(world, x-crush.offset[0], y-crush.offset[1], z-crush.offset[2]);
				else
					return null;
			}
			if (te instanceof TileEntityArcFurnace)
			{
				TileEntityArcFurnace arc = (TileEntityArcFurnace) te;
				if (arc.pos==25&&arc.facing==side)
					return new PeripheralArcFurnace(world, x-arc.offset[0], y-arc.offset[1], z-arc.offset[2]);
				else
					return null;
			}
			if (te instanceof TileEntityExcavator)
			{
				TileEntityExcavator exc = (TileEntityExcavator) te;
				if (exc.pos==3&&exc.facing==side)
					return new PeripheralExcavator(world, x-exc.offset[0], y-exc.offset[1], z-exc.offset[2]);
				else
					return null;
			}
			if (te instanceof TileEntityRefinery)
			{
				TileEntityRefinery ref = (TileEntityRefinery) te;
				if (ref.pos==9&&ref.facing==side)
					return new PeripheralRefinery(world, x-ref.offset[0], y-ref.offset[1], z-ref.offset[2]);
				else
					return null;
			}



			if (te instanceof TileEntityFermenter)
			{
				TileEntityFermenter fer = (TileEntityFermenter) te;
				return new PeripheralFermenter(world, x-fer.offset[0], y-fer.offset[1], z-fer.offset[2]);
			}
			if (te instanceof TileEntitySqueezer)
			{
				TileEntitySqueezer sq = (TileEntitySqueezer) te;
				return new PeripheralSqueezer(world, x-sq.offset[0], y-sq.offset[1], z-sq.offset[2]);
			}
			if (te instanceof TileEntityAssembler)
			{
				TileEntityAssembler assembler = (TileEntityAssembler) te;
				if (assembler.offset[1]==-1)
					return new PeripheralAssembler(world, x-assembler.offset[0], y-assembler.offset[1], z-assembler.offset[2]);
				else
					return null;
			}
			if (te instanceof TileEntityBottlingMachine)
			{
				TileEntityBottlingMachine bott = (TileEntityBottlingMachine) te;
				if (bott.offset[1]==0&&bott.pos!=0&&bott.pos!=2)
					return new PeripheralBottlingMachine(world, x-bott.offset[0], y, z-bott.offset[2]);
				else
					return null;
			}
			if (te instanceof TileEntityCapacitorLV)
			{

				String type = "";
				if (te instanceof TileEntityCapacitorCreative)
					type = "creative";
				else if (te instanceof TileEntityCapacitorHV)
					type = "hv";
				else if (te instanceof TileEntityCapacitorMV)
					type = "mv";
				else if (te instanceof TileEntityCapacitorLV)
					type = "lv";
				return new PeripheralCapacitor(world, x, y, z, type);
			}
		}
		return null;
	}

}
