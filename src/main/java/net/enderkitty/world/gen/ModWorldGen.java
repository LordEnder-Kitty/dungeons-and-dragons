package net.enderkitty.world.gen;

public class ModWorldGen {
    public static void generateWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
        ModFlowerGeneration.generateFlowers();
    }
}
