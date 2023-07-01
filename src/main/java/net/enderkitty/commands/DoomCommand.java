package net.enderkitty.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.enderkitty.sound.ModSounds;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

public class DoomCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("doom")
                .executes(context -> execute(context.getSource())));
        // Alias for command
        dispatcher.register(CommandManager.literal("rampage")
                .executes(context -> execute(context.getSource())));
    }

    private static int execute(ServerCommandSource source) {
        ServerPlayerEntity player = source.getPlayer();
        assert player != null;
        World world = player.getEntityWorld();
        if (world.getGameRules().getBoolean(CommandGamerule.DOOM_COMMANDS)) {

            world.playSound(
                    null,
                    player.getBlockPos(),
                    ModSounds.DOOM,
                    SoundCategory.MASTER,
                    20.0f, 1.0f);

        }
        return 1;
    }
}
