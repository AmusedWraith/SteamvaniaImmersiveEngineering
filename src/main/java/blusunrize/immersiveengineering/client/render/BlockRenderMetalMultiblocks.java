package blusunrize.immersiveengineering.client.render;

import org.lwjgl.opengl.GL11;

import blusunrize.immersiveengineering.client.ClientUtils;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalMultiblocks;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityArcFurnace;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityAssembler;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityBottlingMachine;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityCrusher;

import blusunrize.immersiveengineering.common.blocks.metal.TileEntityExcavator;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityFermenter;

import blusunrize.immersiveengineering.common.blocks.metal.TileEntityMetalPress;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntityRefinery;
import blusunrize.immersiveengineering.common.blocks.metal.TileEntitySqueezer;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockArcFurnace;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockBucketWheel;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockCrusher;

import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockExcavatorDemo;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockMetalPress;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockRefinery;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockSheetmetalTank;
import blusunrize.immersiveengineering.common.blocks.multiblocks.MultiblockSilo;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockRenderMetalMultiblocks implements ISimpleBlockRenderingHandler
{
	public static int renderID = RenderingRegistry.getNextAvailableRenderId();

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		GL11.glPushMatrix();
		try{
			if(metadata==BlockMetalMultiblocks.META_squeezer)
			{
				block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.setOverrideBlockTexture( ((BlockMetalMultiblocks)block).icons[metadata][0]);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
				renderer.clearOverrideBlockTexture();
			}
			else if(metadata==BlockMetalMultiblocks.META_fermenter)
			{
				block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.setRenderBoundsFromBlock(block);
				renderer.setOverrideBlockTexture( ((BlockMetalMultiblocks)block).icons[metadata][0]);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
				renderer.clearOverrideBlockTexture();
			}
			else if(metadata==BlockMetalMultiblocks.META_refinery)
			{
				GL11.glTranslatef(1.25f, 1.125F, 1.625f);
				GL11.glScalef(.3125f, .3125f, .3125f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockRefinery.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_crusher)
			{
				GL11.glTranslatef(1.25f, 1.125F, 1.625f);
				GL11.glScalef(.3125f, .3125f, .3125f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockCrusher.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_bucketWheel)
			{
				GL11.glTranslatef(1.5f, 1.125F, 1.5f);
				GL11.glScalef(.25f, .25f, .25f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockBucketWheel.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_excavator)
			{
				GL11.glTranslatef(1.25f, 1.125F, 1.625f);
				GL11.glScalef(.25f, .25f, .25f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockExcavatorDemo.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_arcFurnace)
			{
				GL11.glTranslatef(1.5f, 1.1875F, 1.5f);
				GL11.glScalef(.25f, .25f, .25f);
				GL11.glRotatef(90, 0, 1, 0);
				MultiblockArcFurnace.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_tank)
			{
				GL11.glTranslatef(1.5f, 1.25F, 1.5f);
				GL11.glScalef(.3125f, .3125f, .3125f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockSheetmetalTank.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_silo)
			{
				GL11.glTranslatef(1.5f, 1.25F, 1.5f);
				GL11.glScalef(.25f, .25f, .25f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockSilo.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
			else if(metadata==BlockMetalMultiblocks.META_metalPress)
			{
				GL11.glScalef(.5f, .5f, .5f);
				GL11.glRotatef(180, 0, 1, 0);
				MultiblockMetalPress.instance.renderFormedStructure();
				GL11.glEnable(32826);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		TileEntity te = world.getTileEntity(x, y, z);
		 if(metadata==BlockMetalMultiblocks.META_squeezer)
		{
			if(te instanceof TileEntitySqueezer && ((TileEntitySqueezer)te).formed)
			{
				if(((TileEntitySqueezer)te).pos==13)
					renderer.setRenderBounds(-1,-1,-1, 2,2,2);
				else
					return false;
			}
			else
				renderer.setRenderBounds(0,0,0, 1,1,1);
			return renderer.renderStandardBlock(block, x, y, z);
		}
		else if(metadata==BlockMetalMultiblocks.META_fermenter)
		{
			if(te instanceof TileEntityFermenter && ((TileEntityFermenter)te).formed)
			{
				if(((TileEntityFermenter)te).pos==13)
					renderer.setRenderBounds(-1,-1,-1, 2,2,2);
				else
					return false;
			}
			else
				renderer.setRenderBounds(0,0,0, 1,1,1);
			return renderer.renderStandardBlock(block, x, y, z);
		}

		else if(te instanceof TileEntityRefinery && ((TileEntityRefinery)te).pos==17)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		else if(te instanceof TileEntityCrusher && ((TileEntityCrusher)te).pos==17)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		else if(te instanceof TileEntityExcavator && ((TileEntityExcavator)te).pos==4)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		else if(te instanceof TileEntityArcFurnace && ((TileEntityArcFurnace)te).pos==62)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		else if(te instanceof TileEntityAssembler && ((TileEntityAssembler)te).pos==4)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		else if(te instanceof TileEntityBottlingMachine && ((TileEntityBottlingMachine)te).pos==4)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		else if(te instanceof TileEntityMetalPress && ((TileEntityMetalPress)te).pos==4)
		{
			ClientUtils.handleStaticTileRenderer(te);
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelID)
	{
		return true;
	}
	@Override
	public int getRenderId()
	{
		return renderID;
	}

}
