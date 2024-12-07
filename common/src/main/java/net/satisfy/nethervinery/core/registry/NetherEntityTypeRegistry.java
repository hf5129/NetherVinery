package net.satisfy.nethervinery.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.satisfy.nethervinery.core.NetherVinery;
import net.satisfy.nethervinery.core.util.NetherVineryIdentifier;
import net.satisfy.vinery.core.block.entity.StorageBlockEntity;

import java.util.HashSet;
import java.util.function.Supplier;

public class NetherEntityTypeRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(NetherVinery.MODID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<StorageBlockEntity>> STORAGE_ENTITY = registerBlockEntity("nether_storage", () -> BlockEntityType.Builder.of(StorageBlockEntity::new, NetherStorageTypes.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));


    private static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(final String path, final Supplier<T> type) {
        return BLOCK_ENTITY_TYPES.register(new NetherVineryIdentifier(path), type);
    }

    public static void init() {
        BLOCK_ENTITY_TYPES.register();
    }
}