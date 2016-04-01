package com.P4.GuiContainer;

import com.P4.tileentity.KurtBlockTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;


/**
 * Created by esben on 23/02/16.
 */
public class ContainerKurtBlockTileEntity extends Container{
    private IInventory playerInv;
    private KurtBlockTileEntity KBTE;

    public KurtBlockTileEntity getKBTE(){
        return KBTE;
    }

    public IInventory getPlayerInv(){
        return playerInv;
    }
    public ContainerKurtBlockTileEntity(IInventory playerInv, KurtBlockTileEntity KBTE){
        this.KBTE = KBTE;
        this.playerInv = playerInv;

        // Tile Entity, Slot 0-8, Slot IDs 0-8
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 5; ++x) {
                this.addSlotToContainer(new Slot(KBTE, x + y * 5, 44 + x * 18, 17 + y * 18));
            }
        }
        // Player Inventory, Slot 9-35, Slot IDs 9-35
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        //this.

        // Player Inventory, Slot 0-8, Slot IDs 36-44
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn){
        return this.KBTE.isUseableByPlayer(playerIn);
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 48) {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 9, 48, true))
                    return null;
            } else {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 9, false))
                    return null;
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }
}

