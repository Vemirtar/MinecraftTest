package blocks;

import com.P4.ObsidiCodeMod;
import com.P4.network.ObsidiCodeGuiHandler;
import com.P4.tileentity.KurtBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by esben on 08/02/16.
 */
public class KurtBlock extends Block implements ITileEntityProvider{

    public KurtBlock(Material materialIn) {
        super(materialIn);
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5.0f);
        this.setResistance(2000.1f);
        this.setLightLevel(1.0f);
        this.canProvidePower();
    }

    //@Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new KurtBlockTileEntity();
    }
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    @Override
    public boolean isFullCube(){
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
        KurtBlockTileEntity te = (KurtBlockTileEntity) world.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(world, pos, te);
        super.breakBlock(world, pos, blockstate);
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName()) {
            ((KurtBlockTileEntity) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            player.openGui(ObsidiCodeMod.instance, ObsidiCodeGuiHandler.KURTBLOCK_TILE_ENTITY_GUI, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
    @Override
    public int getRenderType() {
        return 3;
    }

}