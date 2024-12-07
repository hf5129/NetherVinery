// src/main/java/fabric/net/satisfy/nethervinery/fabric/NetherVineryFabric.java
package net.satisfy.nethervinery.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.satisfy.nethervinery.core.NetherVinery;
import net.satisfy.nethervinery.fabric.world.NetherVineryBiomeModification;
import net.satisfy.vinery.fabric.config.VineryFabricConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherVineryFabric implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("nethervinery");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing NetherVineryFabric...");

        if (!FabricLoader.getInstance().isModLoaded("vinery")) {
            LOGGER.error("Vinery is required for NetherVinery to load! Disabling mod.");
            return; // Gracefully disable the mod
        }

        try {
            // Access the Vinery configuration
            VineryFabricConfig config = AutoConfig.getConfigHolder(VineryFabricConfig.class).getConfig();
            LOGGER.info("Vinery configuration loaded successfully: {}", config);
        } catch (Exception e) {
            LOGGER.error("Failed to load Vinery configuration! NetherVinery cannot start.", e);
            return; // Gracefully disable the mod
        }

        // Initialize your mod's core functionalities
        NetherVinery.init();
        NetherVineryBiomeModification.init();

        LOGGER.info("NetherVineryFabric has been initialized successfully.");
    }
}
