package blusunrize.immersiveengineering.common.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.AchievementPage;
import blusunrize.immersiveengineering.ImmersiveEngineering;
import blusunrize.immersiveengineering.common.Config;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalMultiblocks;


import cpw.mods.fml.common.Loader;

public class IEAchievements
{
	public static AchievementPage ieAchievementPage;

	public static Achievement openManual;//0,0
	public static Achievement craftHammer;//3,1
	public static Achievement connectWire;//0,-2
	public static Achievement blastfurnace;//2,0
	public static Achievement makeSteel;//2,-2

	public static Achievement placeConveyor;//1,2
	public static Achievement placeWindmill;//1,-1
	public static Achievement craftHeater;//2,-2
	public static Achievement craftPump;//2,3

	
	public static Achievement craftWorkbench;


	public static Achievement craftSkyhook;
	public static Achievement skyhookPro;
	public static Achievement craftChemthrower;

	public static Achievement craftWolfPack;

	public static Achievement mbImprovedBlastFurnace;
	public static Achievement mbSilo;
	public static Achievement mbCrusher;

	public static Achievement mbExcavator;
	public static Achievement mbArcFurnace;

	public static Achievement secret_birthdayParty;
	public static Achievement secret_luckOfTheDraw;
	
	public static StatBase statDistanceSkyhook;

	public static void init()
	{
		openManual = new AchievementIE("openManual", 0, 0, new ItemStack(IEContent.itemTool,1,3), null);
		craftHammer = new AchievementIE("craftHammer", 3, 1, IEContent.itemTool, openManual).setNormalCrafting();

		blastfurnace = new AchievementIE("blastfurnace", 2, 0, new ItemStack(IEContent.blockStoneDevice,1,2), craftHammer);
		makeSteel = new AchievementIE("makeSteel", 2, -2, new ItemStack(IEContent.itemMetal,1,7), blastfurnace);
		
		placeConveyor = new AchievementIE("placeConveyor", 1, 2, new ItemStack(IEContent.blockMetalDevice,1,11), openManual).setPlacement(new ItemStack(IEContent.blockMetalDevice,1,11),new ItemStack(IEContent.blockMetalDevice,1,15));
		placeWindmill = new AchievementIE("placeWindmill", -1, 2, new ItemStack(IEContent.blockWoodenDevice,1,2), openManual).setPlacement(new ItemStack(IEContent.blockWoodenDevice,1,2),new ItemStack(IEContent.blockWoodenDevice,1,3));
		craftHeater = new AchievementIE("craftHeater", -2, 3, new ItemStack(IEContent.blockMetalDevice,1,12), openManual).setNormalCrafting();
		craftPump = new AchievementIE("craftPump", 2, 3, new ItemStack(IEContent.blockMetalDevice2,1,6), openManual).setNormalCrafting();

		
		mbImprovedBlastFurnace = new AchievementIE("mbImprovedBlastFurnace", 6, -4, new ItemStack(IEContent.blockStoneDevice,1,5), makeSteel).setSpecial();
		mbSilo = new AchievementIE("mbSilo", 6, -3, new ItemStack(IEContent.blockMetalMultiblocks,1,BlockMetalMultiblocks.META_silo), craftHammer).setSpecial();
		mbCrusher = new AchievementIE("mbCrusher", 6, -2, new ItemStack(IEContent.blockMetalMultiblocks,1,BlockMetalMultiblocks.META_crusher), craftHammer).setSpecial();
		mbExcavator = new AchievementIE("mbExcavator", 6, 0, new ItemStack(IEContent.blockMetalMultiblocks,1,BlockMetalMultiblocks.META_excavator), craftHammer).setSpecial();
		mbArcFurnace = new AchievementIE("mbArcFurnace", 6, 1, new ItemStack(IEContent.blockMetalMultiblocks,1,BlockMetalMultiblocks.META_arcFurnace), craftHammer).setSpecial();
		
		craftWorkbench = new AchievementIE("craftWorkbench", 2, -4, new ItemStack(IEContent.blockWoodenDevice,1,5), makeSteel).setNormalCrafting();
	

		
		craftSkyhook = new AchievementIE("craftSkyhook", 1, -6, IEContent.itemSkyhook, craftWorkbench).setNormalCrafting();
		ItemStack hook = new ItemStack(IEContent.itemSkyhook);
		hook.addEnchantment(Enchantment.unbreaking, 1);
		skyhookPro = new AchievementIE("skyhookPro", 0, -6, hook, craftSkyhook);
		
		craftChemthrower = new AchievementIE("craftChemthrower", 3, -5, IEContent.itemChemthrower, craftWorkbench).setNormalCrafting();
		
		
		secret_birthdayParty = new AchievementIE("secret_birthdayParty", -4,-2, new ItemStack(IEContent.itemFakeIcons,1,0), null).setSpecial();
		secret_luckOfTheDraw = new AchievementIE("secret_luckOfTheDraw", -4, 0, new ItemStack(IEContent.itemFakeIcons,1,1), null).setSpecial();
		
		ieAchievementPage = new AchievementPage(ImmersiveEngineering.MODNAME, AchievementIE.achievements.toArray(new Achievement[AchievementIE.achievements.size()]));
		AchievementPage.registerAchievementPage(ieAchievementPage);
	
		statDistanceSkyhook = new StatBase("stat.skyhookOneCm", new ChatComponentTranslation("stat.skyhookOneCm", new Object[0]), StatBase.distanceStatType)
		{
			@Override
		    public StatBase registerStat()
		    {
		        super.registerStat();
		        StatList.generalStats.add(12,this);
		        return this;
		    }
		}.initIndependentStat().registerStat();
	    
	}

	public static class AchievementIE extends Achievement
	{
		public static List<Achievement> achievements = new ArrayList();
		public AchievementIE(String name, int x, int y, ItemStack icon, Achievement parent)
		{
			super("achievement.immersiveengineering."+name, "immersiveengineering." + name, x, y, icon, parent);
			achievements.add(this);
			registerStat();
		}
		public AchievementIE(String name, int x, int y, Item icon, Achievement parent)
		{
			this(name, x, y, new ItemStack(icon), parent);
		}
		public AchievementIE(String name, int x, int y, Block icon, Achievement parent)
		{
			this(name, x, y, new ItemStack(icon), parent);
		}
		
		public ItemStack[] triggerItems;
		public AchievementIE setNormalCrafting(ItemStack... triggerItems)
		{
			this.triggerItems = triggerItems;
			normalCraftingAchievements.add(this);
			return this;
		}
		public AchievementIE setBlueprintCrafting(ItemStack... triggerItems)
		{
			this.triggerItems = triggerItems;
			blueprintCraftingAchievements.add(this);
			return this;
		}
		public AchievementIE setPlacement(ItemStack... triggerItems)
		{
			this.triggerItems = triggerItems;
			placementAchievements.add(this);
			return this;
		}
	}
	
	public static ArrayList<AchievementIE> normalCraftingAchievements = new ArrayList();
	public static ArrayList<AchievementIE> blueprintCraftingAchievements = new ArrayList();
	public static ArrayList<AchievementIE> placementAchievements = new ArrayList();
}