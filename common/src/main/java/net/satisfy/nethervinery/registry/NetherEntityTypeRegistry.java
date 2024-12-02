package net.satisfy.nethervinery.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.satisfy.nethervinery.util.NetherVineryIdentifier;
import net.satisfy.vinery.core.Vinery;
import net.satisfy.vinery.core.block.entity.ApplePressBlockEntity;
import net.satisfy.vinery.core.block.entity.FermentationBarrelBlockEntity;
import net.satisfy.vinery.core.block.entity.StorageBlockEntity;

import java.util.HashSet;
import java.util.function.Supplier;

public class NetherEntityTypeRegistry {

    private static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Vinery.MOD_ID, Registries.BLOCK_ENTITY_TYPE).getRegistrar();

    public static final RegistrySupplier<BlockEntityType<ApplePressBlockEntity>> APPLE_PRESS_BLOCK_ENTITY = registerBlockEntity("crimson_apple_press", () -> BlockEntityType.Builder.of(ApplePressBlockEntity::new, NetherObjectRegistry.WARPED_APPLE_PRESS.get(), NetherObjectRegistry.CRIMSON_APPLE_PRESS.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<FermentationBarrelBlockEntity>> FERMENTATION_BARREL_ENTITY = registerBlockEntity("fermentation_barrel", () -> BlockEntityType.Builder.of(FermentationBarrelBlockEntity::new, NetherObjectRegistry.WARPED_FERMENTATION_BARREL.get(), NetherObjectRegistry.CRIMSON_FERMENTATION_BARREL.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<StorageBlockEntity>> NETHER_STORAGE_ENTITY = registerBlockEntity("nether_storage", () -> BlockEntityType.Builder.of(StorageBlockEntity::new, NetherStorageTypes.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));


    private static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(new NetherVineryIdentifier(path), type);
    }

    public static void init() {

    }
}