package net.enderkitty.sound;

import net.enderkitty.DndMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

    public static SoundEvent STOP_EATING_METAL = registerSoundEvent("stop_eating_metal");
    public static SoundEvent RICK_ROLL = registerSoundEvent("rick_roll");



    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(DndMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerModSounds() {
        DndMod.LOGGER.debug("Registering Sound Events for " + DndMod.MOD_ID);
    }
}
