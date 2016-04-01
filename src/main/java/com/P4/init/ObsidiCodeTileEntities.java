package com.P4.init;


import com.P4.tileentity.KurtBlockTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by esben on 16/02/16.
 */
public final class ObsidiCodeTileEntities extends TileEntity {

    public static void register(){
        GameRegistry.registerTileEntity(KurtBlockTileEntity.class, "ObCoKurtBlock");
    }
}
