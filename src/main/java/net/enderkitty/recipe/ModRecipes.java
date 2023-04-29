package net.enderkitty.recipe;

import net.enderkitty.DndMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(DndMod.MOD_ID, AlchemyRecipe.Serializer.ID),
                AlchemyRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(DndMod.MOD_ID, AlchemyRecipe.Type.ID),
                AlchemyRecipe.Type.INSTANCE);
    }
}
