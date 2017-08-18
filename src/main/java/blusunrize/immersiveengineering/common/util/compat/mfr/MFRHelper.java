package blusunrize.immersiveengineering.common.util.compat.mfr;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import powercrystals.minefactoryreloaded.api.FactoryRegistry;
import blusunrize.immersiveengineering.api.tool.ChemthrowerHandler;
import blusunrize.immersiveengineering.api.tool.ChemthrowerHandler.ChemthrowerEffect_Potion;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.util.IEPotions;
import blusunrize.immersiveengineering.common.util.compat.IECompatModule;

public class MFRHelper extends IECompatModule
{
	@Override
	public void preInit()
	{
	}

	@Override
	public void postInit()
	{
	}

	@Override
	public void init()
	{
		FactoryRegistry.sendMessage("registerPlantable",new IEPlantable(IEContent.itemSeeds, IEContent.blockCrop));
		FactoryRegistry.sendMessage("registerHarvestable", new IEHarvestable());

	
		
	}
}
