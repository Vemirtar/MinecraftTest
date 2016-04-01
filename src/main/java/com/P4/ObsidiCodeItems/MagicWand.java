package com.P4.ObsidiCodeItems;

import com.P4.Utility.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Created by Nete on 16-02-2016.
 */
public class MagicWand extends Item {
    BlockLoader bl;
    //C:\Users\Nete\Documents\Forge\classes\production\Forge\com\P4\ObisiCodeBlocks/TestBlock.class
    public MagicWand ()
    {
        this.setUnlocalizedName("MagicWand");
        bl = new BlockLoader("/home/esben/documents/P4/DynamicClasses/TestBlock.class");
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        world.destroyBlock(pos, false);
        Block newBlock = bl.getBlock();

        world.setBlockState(pos, (IBlockState) newBlock.getBlockState());
        return false;

    }
}
