package main.java.me.peregrine;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RunSpeedUpWithSwordEventHandler {

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event){
		//System.out.println("test");
		EntityPlayer entP = event.player;
		//EntityPlayerMP entMP = event.
		ItemStack helditem = entP.getHeldItem();
		if(!(entP == null) && this.isCurrentItemSwords(entP, helditem)){
			RunSpeedUpWithSwordCore.instance.DebugMessage("Your item is sword.", entP);
		}
	}

	boolean isCurrentItemSwords(EntityPlayer entP, ItemStack item){
		if(!(entP == null) && !(item == null)){
			if(!(item == entP.getHeldItem())){
				return false;
			}
			if (item.getItem() == Items.wooden_sword || item.getItem() == Items.stone_sword
					|| item.getItem() ==  Items.golden_sword || item.getItem() == Items.diamond_sword) {
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
