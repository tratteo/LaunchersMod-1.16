package net.launchers.mod.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.launchers.mod.block.abstraction.AbstractLauncherBlock;
import net.launchers.mod.entity.LauncherBlockEntity;
import net.launchers.mod.initializer.LMSounds;
import net.launchers.mod.loader.LMLoader;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import net.minecraft.world.BlockView;

public class LauncherBlock extends AbstractLauncherBlock
{
    public static final Identifier ID = new Identifier(LMLoader.MOD_ID, "launcher_block");
    
    public LauncherBlock()
    {
        super(FabricBlockSettings.of(Material.METAL).breakByHand((true)).strength(0.8F, 0.5F).sounds(BlockSoundGroup.METAL).nonOpaque().dynamicBounds().build());
        baseMultiplier = 1.25F;
        stackPowerPercentage = 0.335F;
        stackMultiplier = baseMultiplier * stackPowerPercentage;
    }
    
    @Override public PlaySoundS2CPacket createLaunchSoundPacket(double x, double y, double z)
    {
        return new PlaySoundS2CPacket(LMSounds.LAUNCHER_BLOCK_LAUNCH_SOUNDEVENT, SoundCategory.BLOCKS, x, y, z, 0.8F, 0.95F);
    }
    
    @Override
    public BlockEntity createBlockEntity(BlockView view)
    {
        return new LauncherBlockEntity();
    }
}