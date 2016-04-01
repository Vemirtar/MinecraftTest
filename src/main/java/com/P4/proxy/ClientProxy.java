package com.P4.proxy;

import com.P4.ObsidiCodeMod;
import com.P4.init.ObsidiCodeBlocks;
import com.P4.init.ObsidiCodeItems;
import com.P4.network.ObsidiCodeGuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Morell on 05-02-2016.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders()
    {
        ObsidiCodeBlocks.registerRenders();
        ObsidiCodeItems.registerRenders();
    }
}
