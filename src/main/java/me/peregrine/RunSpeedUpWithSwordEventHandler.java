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
		if(!(entP == null) && !(this.checkKindsOfSwords(entP, helditem) == 0)){
			/*Memo:初期値0.1F*/
			//entP.capabilities.setPlayerWalkSpeed(10f);
		}
	}

	/*
	 * 剣以外を持っていた・何も持っていない場合0を返す
	 * 木の剣を持っていた場合1，石の剣を持っていた場合2，金の剣を持っていた場合3，ダイアモンドの剣を持っていた場合4を返す */
	int checkKindsOfSwords(EntityPlayer entP, ItemStack item){
		if(!(entP == null) && !(item == null)){
			if(!(item == entP.getHeldItem())){
				return 0;
			}
			if (item.getItem() == Items.wooden_sword ) {
				return 1;
			}else if (item.getItem() == Items.stone_sword) {
				return 2;
			}else if (item.getItem() ==  Items.golden_sword) {
				return 3;
			}else if (item.getItem() == Items.diamond_sword) {
				return 4;
			}
		}
		return 0;
	}
}
