package net.satisfy.nethervinery.client;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.satisfy.nethervinery.client.render.block.storage.*;
import net.satisfy.nethervinery.core.registry.NetherEntityTypeRegistry;
import net.satisfy.nethervinery.core.registry.NetherObjectRegistry;
import net.satisfy.nethervinery.core.registry.NetherStorageTypeRegistry;

@Environment(EnvType.CLIENT)
public class NetherVineryClient {
    public static void onInitializeClient() {

        RenderTypeRegistry.register(RenderType.cutout(),
                NetherObjectRegistry.BLAZEWINE_PINOT.get(),
                NetherObjectRegistry.NETHER_FIZZ.get(),
                NetherObjectRegistry.GHASTLY_GRENACHE.get(),
                NetherObjectRegistry.IMPROVED_LAVA_FIZZ.get(),
                NetherObjectRegistry.LAVA_FIZZ.get(),
                NetherObjectRegistry.IMPROVED_LAVA_FIZZ.get(),
                NetherObjectRegistry.NETHERITE_NECTAR.get(),
                NetherObjectRegistry.CRIMSON_WINE_RACK_MID.get(),
                NetherObjectRegistry.WARPED_GRAPE_BUSH.get(),
                NetherObjectRegistry.WARPED_WINE_RACK_MID.get(),
                NetherObjectRegistry.CRIMSON_GRAPE_BUSH.get(),
                NetherObjectRegistry.IMPROVED_NETHER_FIZZ.get(),
                NetherObjectRegistry.OBSIDIAN_STEM.get(),
                NetherObjectRegistry.WARPED_LATTICE.get(),
                NetherObjectRegistry.CRIMSON_LATTICE.get()
        );

        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
                    if(world == null || pos == null){
                        return -1;
                    }
                    return BiomeColors.getAverageFoliageColor(world, pos);
                },
                NetherObjectRegistry.OBSIDIAN_STEM.get()
        );

        BlockEntityRendererRegistry.register(NetherEntityTypeRegistry.STORAGE_ENTITY.get(), context -> new NetherStorageBlockEntityRenderer());

        registerNetherStorageType();

    }


    public static void registerNetherStorageTypes(ResourceLocation location, NetherStorageTypeRenderer renderer){
        NetherStorageBlockEntityRenderer.registerStorageType(location, renderer);
    }

    public static void registerNetherStorageType(){
        registerNetherStorageTypes(NetherStorageTypeRegistry.BIG_BOTTLE, new NetherBigBottleRenderer());
        registerNetherStorageTypes(NetherStorageTypeRegistry.FOUR_BOTTLE, new NetherFourBottleRenderer());
        registerNetherStorageTypes(NetherStorageTypeRegistry.NINE_BOTTLE, new NetherNineBottleRenderer());
        registerNetherStorageTypes(NetherStorageTypeRegistry.WINE_BOTTLE, new NetherWineBottleRenderer());
    }
}
