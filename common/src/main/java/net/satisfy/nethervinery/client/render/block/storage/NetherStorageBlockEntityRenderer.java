package net.satisfy.nethervinery.client.render.block.storage;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.satisfy.nethervinery.core.block.NetherStorageBlock;
import net.satisfy.nethervinery.core.block.entity.NetherStorageBlockEntity;

import java.util.HashMap;

public class NetherStorageBlockEntityRenderer implements BlockEntityRenderer<NetherStorageBlockEntity> {
    private static final HashMap<ResourceLocation, NetherStorageTypeRenderer> STORAGE_TYPES = new HashMap<>();

    public static void registerStorageType(ResourceLocation name, NetherStorageTypeRenderer renderer){
        STORAGE_TYPES.put(name, renderer);
    }

    public static NetherStorageTypeRenderer getRendererForId(ResourceLocation name){
        return STORAGE_TYPES.get(name);
    }

    public NetherStorageBlockEntityRenderer(){
    }

    @Override
    public void render(NetherStorageBlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        if (entity == null || !entity.hasLevel()) {
            return;
        }

        BlockState state = entity.getBlockState();
        if (state.getBlock() instanceof NetherStorageBlock sB) {
            NonNullList<ItemStack> itemStacks = entity.getInventory();
            matrices.pushPose();
            applyBlockAngle(matrices, state, 180);

            ResourceLocation type = sB.type();
            NetherStorageTypeRenderer renderer = getRendererForId(type);

            if (renderer != null) {
                renderer.render(entity, matrices, vertexConsumers, itemStacks);
            }

            matrices.popPose();
        }
    }

    public static void applyBlockAngle(PoseStack matrices, BlockState state, float angleOffset) {
        float angle = state.getValue(NetherStorageBlock.FACING).toYRot();
        matrices.translate(0.5, 0, 0.5);
        matrices.mulPose(Axis.YP.rotationDegrees(angleOffset - angle));
    }
}
