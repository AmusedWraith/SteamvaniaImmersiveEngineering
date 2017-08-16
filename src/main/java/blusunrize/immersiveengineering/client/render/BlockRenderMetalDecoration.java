package blusunrize.immersiveengineering.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import blusunrize.immersiveengineering.client.ClientUtils;
import blusunrize.immersiveengineering.common.blocks.metal.BlockMetalDecoration;

import blusunrize.immersiveengineering.common.blocks.metal.TileEntityLantern;


import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class BlockRenderMetalDecoration implements ISimpleBlockRenderingHandler
{
	public static int renderID = RenderingRegistry.getNextAvailableRenderId();
	private static final TileEntityLantern lantern = new TileEntityLantern();


	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		GL11.glPushMatrix();
		try{

			if(metadata==BlockMetalDecoration.META_fence||metadata==BlockMetalDecoration.META_aluminiumFence)
			{
				renderer.setRenderBounds(0,0,.375, .25,1,.625);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
				renderer.setRenderBounds(.75,0,.375, 1,1,.625);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
				renderer.setRenderBounds(-.125,.8125,.4375, 1.125,.9375,.5625);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
				renderer.setRenderBounds(-.125,.3125,.4375, 1.125,.4375,.5625);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
			}
			else if(metadata==BlockMetalDecoration.META_scaffolding||metadata==BlockMetalDecoration.META_scaffolding2||metadata==BlockMetalDecoration.META_aluminiumScaffolding||metadata==BlockMetalDecoration.META_aluminiumScaffolding2)
			{
				block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.setRenderBoundsFromBlock(block);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
			}
			else if(metadata==BlockMetalDecoration.META_lantern)
			{
				Tessellator.instance.startDrawingQuads();
				ClientUtils.handleStaticTileRenderer(lantern);
				Tessellator.instance.draw();
			}
		


			else
			{
				block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				renderer.setRenderBoundsFromBlock(block);
				ClientUtils.drawInventoryBlock(block, metadata, renderer);
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
		int meta = world.getBlockMetadata(x, y, z);
		if(meta==BlockMetalDecoration.META_fence||meta==BlockMetalDecoration.META_aluminiumFence)
		{
			renderer.setRenderBounds(.375,0,.375, .625,1,.625);
			renderer.renderStandardBlock(block, x, y, z);
			BlockMetalDecoration md = (BlockMetalDecoration)block;

			if(md.canConnectFenceTo(world, x+1, y, z))
			{
				renderer.setRenderBounds(.625,.375,.4375, 1,.5625,.5625);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(.625,.75,.4375, 1,.9375,.5625);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(md.canConnectFenceTo(world, x-1, y, z))
			{
				renderer.setRenderBounds(0,.375,.4375, .375,.5625,.5625);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(0,.75,.4375, .375,.9375,.5625);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(md.canConnectFenceTo(world, x, y, z+1))
			{
				renderer.setRenderBounds(.4375,.375,.625, .5625,.5625,1);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(.4375,.75,.625, .5625,.9375,1);
				renderer.renderStandardBlock(block, x, y, z);
			}
			if(md.canConnectFenceTo(world, x, y, z-1))
			{
				renderer.setRenderBounds(.4375,.375,0, .5625,.5625,.375);
				renderer.renderStandardBlock(block, x, y, z);
				renderer.setRenderBounds(.4375,.75,0, .5625,.9375,.375);
				renderer.renderStandardBlock(block, x, y, z);
			}
			return true;
		}
		else if(meta==BlockMetalDecoration.META_scaffolding||meta==BlockMetalDecoration.META_scaffolding2||meta==BlockMetalDecoration.META_aluminiumScaffolding||meta==BlockMetalDecoration.META_aluminiumScaffolding2)
		{
			renderer.setRenderBoundsFromBlock(block);
			float f = .015625f;
			float f1 = 0;
			renderer.renderFromInside=true;
			renderer.renderMinX+=block.shouldSideBeRendered(world,x-1,y,z,4)?f:f1;
			renderer.renderMinY+=block.shouldSideBeRendered(world,x,y-1,z,0)?f:f1;
			renderer.renderMinZ+=block.shouldSideBeRendered(world,x,y,z-1,2)?f:f1;
			renderer.renderMaxX-=block.shouldSideBeRendered(world,x+1,y,z,5)?f:f1;
			renderer.renderMaxY-=block.shouldSideBeRendered(world,x,y+1,z,1)?f:f1;
			renderer.renderMaxZ-=block.shouldSideBeRendered(world,x,y,z+1,3)?f:f1;
			renderer.renderStandardBlock(block, x, y, z);
			renderer.renderMinX-=block.shouldSideBeRendered(world,x-1,y,z,4)?f:f1;
			renderer.renderMinY-=block.shouldSideBeRendered(world,x,y-1,z,0)?f:f1;
			renderer.renderMinZ-=block.shouldSideBeRendered(world,x,y,z-1,2)?f:f1;
			renderer.renderMaxX+=block.shouldSideBeRendered(world,x+1,y,z,5)?f:f1;
			renderer.renderMaxY+=block.shouldSideBeRendered(world,x,y+1,z,1)?f:f1;
			renderer.renderMaxZ+=block.shouldSideBeRendered(world,x,y,z+1,3)?f:f1;
			renderer.renderFromInside=false;
			return renderer.renderStandardBlock(block, x, y, z);
		}
		else if(meta==BlockMetalDecoration.META_lantern)
		{
			TileEntityLantern tile = (TileEntityLantern)world.getTileEntity(x, y, z);
			ClientUtils.handleStaticTileRenderer(tile);
			return true;
		}
		


		else
		{
			renderer.setRenderBounds(0,0,0,1,1,1);
			return renderer.renderStandardBlock(block, x, y, z);
		}
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