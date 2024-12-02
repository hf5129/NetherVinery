package net.satisfy.nethervinery.util;

import net.minecraft.resources.ResourceLocation;
import net.satisfy.nethervinery.NetherVinery;

public class NetherVineryIdentifier extends ResourceLocation {

    public NetherVineryIdentifier(String path) {
        super(NetherVinery.MODID, path);
    }
}
