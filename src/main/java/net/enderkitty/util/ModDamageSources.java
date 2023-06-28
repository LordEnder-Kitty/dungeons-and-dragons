package net.enderkitty.util;

import net.enderkitty.DndMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.ProjectileDamageSource;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class ModDamageSources {

    public static DamageSource DAGGER(Entity dagger, @Nullable Entity attacker) {
        return new ProjectileDamageSource("dagger", dagger, attacker).setProjectile();
    }

    public static final DamageSource BLUNT = new DamageSource("blunt") {
        public Text getDeathMessage(LivingEntity entity) {
            return Text.translatable("death.attack.blunt", entity.getDisplayName());
        }
    };



    public static void registerDamageSources() {DndMod.LOGGER.debug("Registering Custom Damage Sources For DndMod");}
}
