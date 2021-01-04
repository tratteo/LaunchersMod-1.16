package net.launchers.mod.entity_renderer.abstraction;

import net.launchers.mod.block.abstraction.AbstractLauncherBlock;
import net.launchers.mod.entity.abstraction.AbstractLauncherBlockEntity;
import net.launchers.mod.utils.MathUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public abstract class AbstractLauncherBlockEntityRenderer<T extends AbstractLauncherBlockEntity> extends BlockEntityRenderer<T>
{
    public AbstractLauncherBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher)
    {
        super(dispatcher);
    }
    
    protected final BlockRenderManager blockRenderManager = MinecraftClient.getInstance().getBlockRenderManager();
    
    public void render(T blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay)
    {
        BlockState entityState = blockEntity.getCachedState();
        matrices.push();
        float extension = blockEntity.getDeltaProgress(tickDelta);
        BakedModel model = null;
        BlockState blockState = blockEntity.getCachedState();
        if(extension < 0.35F)
        {
            model = blockRenderManager.getModel(blockState.with(AbstractLauncherBlock.MODELS, 2).with(AbstractLauncherBlock.FACING, blockState.get(AbstractLauncherBlock.FACING)));
        }
        else
        {
            model = blockRenderManager.getModel(blockState.with(AbstractLauncherBlock.MODELS, 1).with(AbstractLauncherBlock.FACING, blockState.get(AbstractLauncherBlock.FACING)));
        }
        Vec3d translation = MathUtils.fromDirection(blockState.get(AbstractLauncherBlock.FACING));
        matrices.translate(translation.x * extension, translation.y * extension, translation.z * extension);
        RenderLayer renderLayer = RenderLayers.getEntityBlockLayer(entityState, true);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        this.blockRenderManager.getModelRenderer().render(blockEntity.getWorld(), model, entityState, blockEntity.getPos(), matrices, vertexConsumer, true, new Random(), 4, overlay);
        matrices.pop();
    }
}
