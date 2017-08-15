package blusunrize.immersiveengineering.common.util;

import com.emoniph.witchery.util.EntityDamageSourceIndirectSilver;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class IEDamageSources
{
	public static class IEDamageSource_Indirect extends EntityDamageSourceIndirect
	{
		public IEDamageSource_Indirect(String tag, Entity shot, Entity shooter)
		{
			super(tag, shot, shooter);
		}
	}
	public static class IEDamageSource_Direct extends EntityDamageSource
	{
		public IEDamageSource_Direct(String tag, Entity attacker)
		{
			super(tag, attacker);
		}
	}
	public static class IEDamageSource extends DamageSource
	{
		public IEDamageSource(String tag)
		{
			super(tag);
		}
	}



	public static DamageSource causeAcidDamage()
	{
		return new IEDamageSource(Lib.DMG_Acid);
	}

	public static DamageSource causeCrusherDamage()
	{
		return new IEDamageSource(Lib.DMG_Crusher);
	}
	

}