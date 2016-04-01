package com.P4.network;

import com.P4.GUI.GuiKurtBlockTileEntity;
import com.P4.GuiContainer.ContainerKurtBlockTileEntity;
import com.P4.tileentity.KurtBlockTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by esben on 23/02/16.
 */
public class ObsidiCodeGuiHandler implements IGuiHandler {

    public static final int KURTBLOCK_TILE_ENTITY_GUI = 0;
    public KurtBlockTileEntity KBTE = new KurtBlockTileEntity();

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == KURTBLOCK_TILE_ENTITY_GUI)
            return new ContainerKurtBlockTileEntity(player.inventory, (KurtBlockTileEntity) world.getTileEntity(new BlockPos(x, y, z))); //Just remove this

        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == KURTBLOCK_TILE_ENTITY_GUI)
            return new GuiKurtBlockTileEntity(new ContainerKurtBlockTileEntity(player.inventory, (KurtBlockTileEntity) world.getTileEntity(new BlockPos(x, y, z)))); //Just remove this


        return null;
    }
}
