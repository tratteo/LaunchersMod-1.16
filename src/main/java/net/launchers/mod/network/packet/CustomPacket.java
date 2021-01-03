package net.launchers.mod.network.packet;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.launchers.mod.loader.LMLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public abstract class CustomPacket
{

    
    public CustomPacket()
    {
    }
    
    public abstract void sendTo(PlayerEntity player);
    
    protected abstract void onReceive(PacketContext ctx);
    
    public abstract void write(PacketByteBuf buf);
}
