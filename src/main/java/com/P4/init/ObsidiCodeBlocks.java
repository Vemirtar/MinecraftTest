package com.P4.init;

import blocks.KurtBlock;
import com.P4.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Morell on 05-02-2016.
 */
public class ObsidiCodeBlocks {
    public static Block kurt_egelund_nu_som_block;
    public static void init(){
        kurt_egelund_nu_som_block = new KurtBlock(Material.ground).setUnlocalizedName("kurt_egelund_nu_som_block");

    }

    public static void register(){
        GameRegistry.registerBlock(kurt_egelund_nu_som_block, kurt_egelund_nu_som_block.getUnlocalizedName().substring(5));
    }

    public static void registerRenders(){
        registerRender(kurt_egelund_nu_som_block);
    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
