package xyz.frish2021.bettitle;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BetterFabricGameTitle implements ModInitializer {
    public static Logger getLogger = LogManager.getLogger("BFGT");

    @Override
    public void onInitialize() {
        getLogger.info("BetterFabricGameTitle Mod Starting...");
    }
}
