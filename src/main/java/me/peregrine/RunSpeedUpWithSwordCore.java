package main.java.me.peregrine;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;

/* The main class this mod.
 * @auther Hayabusa
 */
@Mod(name = "RunSpeedUpWithSword", modid = "me.peregrine.runspeedupwithsword", version = "MC1.7.10_1.0.0")
public class RunSpeedUpWithSwordCore {
	@Instance("me.peregrine.runspeedupwithsword")
	public static RunSpeedUpWithSwordCore instance;

	public static RunSpeedUpWithSwordEventHandler eh = new RunSpeedUpWithSwordEventHandler();

	@EventHandler
	public static void init(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(eh);
	}
}
