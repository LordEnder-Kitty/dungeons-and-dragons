package net.enderkitty.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<AlchemyScreenHandler> ALCHEMY_SCREEN_HANDLER;
//    public static ScreenHandlerType<BallistaScreenHandler> BALLISTA_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        ALCHEMY_SCREEN_HANDLER = new ScreenHandlerType<>(AlchemyScreenHandler::new);
//        BALLISTA_SCREEN_HANDLER = new ScreenHandlerType<>(BallistaScreenHandler::new);
    }
}
