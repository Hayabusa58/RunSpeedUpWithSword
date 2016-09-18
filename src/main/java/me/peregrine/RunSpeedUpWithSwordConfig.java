package me.peregrine;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class RunSpeedUpWithSwordConfig {
	static float woodenswordspeedmagnification;
	static float stoneswordspeedmagnification;
	static float ironswordspeedmagnification;
	static float goldenswordspeedmagnification;
	static float diamondswordspeedmagnification;

	public static void load(File file){
		Configuration cfg = new Configuration(file);

		try {
			cfg.load();

			String magnification = "Magnification";
			woodenswordspeedmagnification = cfg.getFloat("1. WoodenSwordSpeedMagnification", magnification, 1.5f, 1, 10, "Speed magnification when you have woodensword.");
			stoneswordspeedmagnification = cfg.getFloat("2. StoneSwordSpeedMagnification", magnification, 2, 1, 10, "Speed magnification when you have stonesword.");
			ironswordspeedmagnification = cfg.getFloat("3. IronSwordSpeedMagnification", magnification, 2.5f, 1, 10, "Speed magnification when you have ironsword.");
			goldenswordspeedmagnification = cfg.getFloat("4. GoldenSwordSpeedMagnification", magnification, 3, 1, 10, "Speed magnification when you have goldensword.");
			diamondswordspeedmagnification = cfg.getFloat("5. GoldenSwordSpeedMagnification", magnification, 6, 1, 10, "Speed magnification when you have diamondsword.");

			cfg.save();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
