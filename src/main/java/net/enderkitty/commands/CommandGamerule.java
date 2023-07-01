package net.enderkitty.commands;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class CommandGamerule {


    public static final GameRules.Key<GameRules.BooleanRule> DOOM_COMMANDS =
            GameRuleRegistry.register("doomCommands", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));

    public static void register() {}
}
