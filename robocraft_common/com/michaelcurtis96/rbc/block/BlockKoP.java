package com.michaelcurtis96.rbc.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.michaelcurtis96.rbc.Robocraft;
import com.michaelcurtis96.rbc.client.gui.inventory.GuiKoP;
import com.michaelcurtis96.rbc.lib.GuiIds;
import com.michaelcurtis96.rbc.lib.Strings;
import com.michaelcurtis96.rbc.tileentity.TileKoP;


import cpw.mods.fml.client.GuiIdMismatchScreen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockKoP extends BlockContainer {

    @SideOnly(Side.CLIENT)
    private Icon top;

    // giving id, texture, and material params
    public BlockKoP(int id) {
        super(id, Material.wood);

        this.setUnlocalizedName(Strings.KOP_NAME);
        this.setHardness(2.5f);
        this.setResistance(2000.0f);
        this.setStepSound(soundWoodFootstep);
        this.setCreativeTab(Robocraft.tabRobocraft);

    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {

        int direction = 0;
        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal();
        }
        else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal();
        }
        else if (facing == 2) {
            direction = ForgeDirection.SOUTH.ordinal();
        }
        else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal();
        }

        world.setBlockMetadataWithNotify(x, y, z, direction, 3);

        if (itemStack.hasDisplayName()) {
            ((TileKoP) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
        }

        ((TileKoP) world.getBlockTileEntity(x, y, z)).setOwner(entityLiving.getEntityName());
        ((TileKoP) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int par6, float par7, float par8, float par9) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking())
            return false;

        player.openGui(Robocraft.instance, GuiIds.BLOCK_KOP, world, x, y, z);
        return true;

    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    private void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if (!(tileEntity instanceof IInventory))
            return;
        IInventory inventory = (IInventory) tileEntity;

        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack item = inventory.getStackInSlot(i);

            if (item != null && item.stackSize > 0) {
                float rx = rand.nextFloat() * 0.8F + 0.1F;
                float ry = rand.nextFloat() * 0.8F + 0.1F;
                float rz = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z
                        + rz, new ItemStack(item.itemID, item.stackSize,
                        item.getItemDamage()));

                if (item.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound(
                            (NBTTagCompound) item.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                item.stackSize = 0;
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
        return par1 == 1 ? top : par1 == 0 ? blockIcon
                : par2 == 2 && par1 == 2 ? blockIcon
                        : par2 == 3 && par1 == 5 ? blockIcon : par2 == 0
                                && par1 == 3 ? blockIcon : par2 == 1
                                && par1 == 4 ? blockIcon : blockIcon;
    }

    // public String getTextureFile() {
    // return CommonProxy.BLOCKS_PNG;
    // }

    public Icon KoPTop;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon("Robocraft:KoPSide");
        top = iconRegister.registerIcon("Robocraft:KoPTop2");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileKoP();
    }
}
