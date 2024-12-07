package net.satisfy.nethervinery.core.util;

import net.minecraft.resources.ResourceLocation;
import net.satisfy.nethervinery.core.NetherVinery;

public class NetherVineryIdentifier extends ResourceLocation {

    public NetherVineryIdentifier(String path) {
        super(NetherVinery.MODID, path);
    }
}
