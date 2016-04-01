package com.P4.proxy;

import com.P4.ObsidiCodeMod;
import com.P4.init.ObsidiCodeBlocks;
import com.P4.init.ObsidiCodeItems;
import com.P4.network.ObsidiCodeGuiHandler;
import net.minecraft.client.main.Main;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void registerRenders()
    {
    }

    public void init(FMLInitializationEvent e){
        NetworkRegistry.INSTANCE.registerGuiHandler(ObsidiCodeMod.instance, new ObsidiCodeGuiHandler());
    }
}
