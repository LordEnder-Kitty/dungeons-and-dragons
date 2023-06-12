package net.enderkitty.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.enderkitty.sound.ModSounds;
import net.minecraft.network.packet.s2c.play.StopSoundS2CPacket;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundCategory;

public class StopDoomCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("stopDoom")
                .executes(context -> execute(context.getSource())));
        // Alias for command
        dispatcher.register(CommandManager.literal("ceaseRampage")
                .executes(context -> execute(context.getSource())));
    }

    private static int execute(ServerCommandSource source) {
        source.getWorld().getServer().getPlayerManager().sendToAll(
                new StopSoundS2CPacket(
                        ModSounds.DOOM.getId(),
                        SoundCategory.MASTER
                )
        );
        return 1;
    }
}
