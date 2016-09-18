package me.peregrine;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RunSpeedUpWithSwordEventHandler {

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        //System.out.println("test");
        EntityPlayer entP = event.player;
        ItemStack helditem = entP.getHeldItem();

        if (!(entP == null) && !(this.checkKindsOfSwords(entP, helditem) == 0)) {
            RunSpeedUpWithSwordCore.instance.DebugMessage("ゲームモード:サバイバル，所持物：剣", entP);
			/*Memo:初期値0.1F*/
            //必ず最初に初期化する
            entP.capabilities.setPlayerWalkSpeed(0.1F);
            float walkspeed = entP.capabilities.getWalkSpeed();
            if (this.checkKindsOfSwords(entP, helditem) == 1) {
                //木の剣を持っていた場合，移動速度を1.5倍にする
                entP.capabilities.setPlayerWalkSpeed(walkspeed * 1.5f);
            } else if (this.checkKindsOfSwords(entP, helditem) == 2) {
                //石の剣を持っていた場合，移動速度を2倍にする
                entP.capabilities.setPlayerWalkSpeed(walkspeed * 2f);
            } else if (this.checkKindsOfSwords(entP, helditem) == 3) {
                //鉄の剣を持っていた場合，移動速度を2.5倍にする
                entP.capabilities.setPlayerWalkSpeed(walkspeed * 2.5f);
            } else if (this.checkKindsOfSwords(entP, helditem) == 4) {
                //金の剣を持っていた場合，移動速度を3倍にする
                entP.capabilities.setPlayerWalkSpeed(walkspeed * 3f);
            } else if (this.checkKindsOfSwords(entP, helditem) == 5) {
                //ダイヤモンドの剣を持っていた場合，移動速度を6倍にする（仮仕様）
                entP.capabilities.setPlayerWalkSpeed(walkspeed * 6f);
            }
        }


//		}else if(!entP.capabilities.isCreativeMode){
//			RunSpeedUpWithSwordCore.instance.DebugMessage("ゲームモード：サバイバル", entP);
//			entP.capabilities.setPlayerWalkSpeed(0.1F);
//		}

        if (entP.capabilities.isCreativeMode && (entP.capabilities.isFlying) && !(entP == null) && !(this.checkKindsOfSwords(entP, helditem) == 0)) {
            RunSpeedUpWithSwordCore.instance.DebugMessage("ゲームモード：クリエイティブ，所持物：剣，浮遊状態", entP);
			/*Memo:初期値0.05F*/
            //必ず最初に初期化する
            entP.capabilities.setFlySpeed(0.05F);
            float flyspeed = entP.capabilities.getFlySpeed();
            if (this.checkKindsOfSwords(entP, helditem) == 1) {
                //木の剣を持っていた場合，飛行速度を1.5倍にする
                entP.capabilities.setFlySpeed(flyspeed * 1.5f);
            }
            if (this.checkKindsOfSwords(entP, helditem) == 2) {
                //石の剣を持っていた場合，飛行速度を2倍にする
                entP.capabilities.setFlySpeed(flyspeed * 2f);
            }
            if (this.checkKindsOfSwords(entP, helditem) == 3) {
                //鉄の剣を持っていた場合，飛行速度を2.5倍にする
                entP.capabilities.setFlySpeed(flyspeed * 2.5f);
            }
            if (this.checkKindsOfSwords(entP, helditem) == 4) {
                //金の剣を持っていた場合，飛行速度を3倍にする
                entP.capabilities.setFlySpeed(flyspeed * 3);
            }
            if (this.checkKindsOfSwords(entP, helditem) == 5) {
                //ダイアモンドの剣を持っていた場合，飛行速度を6倍にする（仮仕様）
                entP.capabilities.setFlySpeed(flyspeed * 6);
            }
        }
    }


	/*
	 * 剣以外を持っていた・何も持っていない場合0を返す
	 * 木の剣を持っていた場合1，石の剣を持っていた場合2，鉄の剣を持っていた場合3，金の剣を持っていた場合4，ダイアモンドの剣を持っていた場合5を返す
	 */

    int checkKindsOfSwords(EntityPlayer entP, ItemStack item) {
        if (!(entP == null) && !(item == null)) {
            if (!(item == entP.getHeldItem())) {
                return 0;
            }
            if (item.getItem() == Items.wooden_sword) {
                return 1;
            } else if (item.getItem() == Items.stone_sword) {
                return 2;
            } else if (item.getItem() == Items.iron_sword) {
                return 3;
            } else if (item.getItem() == Items.golden_sword) {
                return 4;
            } else if (item.getItem() == Items.diamond_sword) {
                return 5;
            }
        }
        return 0;
    }


}