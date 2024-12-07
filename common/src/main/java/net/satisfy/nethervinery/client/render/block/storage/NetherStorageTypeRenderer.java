package net.satisfy.nethervinery.client.render.block.storage;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.satisfy.nethervinery.core.block.entity.NetherStorageBlockEntity;

public interface NetherStorageTypeRenderer {
    void render(NetherStorageBlockEntity entity, PoseStack matrices, MultiBufferSource vertexConsumers, NonNullList<ItemStack> itemStacks);
}
