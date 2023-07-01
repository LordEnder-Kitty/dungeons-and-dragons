package net.enderkitty.block;

import net.enderkitty.DndMod;
import net.enderkitty.block.blocks.*;
import net.enderkitty.bombage.MyBombBlock;
import net.enderkitty.item.ModItemGroup;
import net.enderkitty.world.feature.tree.AlderSaplingGenerator;
import net.enderkitty.world.feature.tree.AshSaplingGenerator;
import net.enderkitty.world.feature.tree.BalsaSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class ModBlocks {

    public static final Block BALL_BEARINGS = registerBlock("ball_bearings", new BallBearingsBlock(FabricBlockSettings.of(Material.METAL)
            .strength(0.6f).slipperiness(1F).nonOpaque().sounds(BlockSoundGroup.METAL)), ModItemGroup.MISC, "tooltip.dndmod.ball_bearings");
    public static final Block ALCHEMY_TABLE = registerBlock("alchemy_table", new AlchemyTableBlock(FabricBlockSettings.of(Material.STONE).strength(2f).nonOpaque()), ModItemGroup.MISC);
    public static final Block ADVENTURING_TABLE = registerBlock("adventuring_table", new AdventuringTableBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC, "tooltip.dndmod.adventuring_table");

    public static final Block FOG_BLOCK = registerBlock("fog_block", new Block(FabricBlockSettings.of(Material.WOOL)
            .strength(-1f).nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL)), ModItemGroup.MISC);

    public static final Block SILVER_BLOCK = registerBlock("silver_block", new Block(FabricBlockSettings.of(Material.METAL)
            .strength(6f).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ModItemGroup.MISC);
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool()), ModItemGroup.MISC);
    public static final Block SILVER_ORE = registerBlock("silver_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool(), UniformIntProvider.create(3, 7)), ModItemGroup.MISC);
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(4, 8)), ModItemGroup.MISC);
    public static final Block ENDSTONE_SILVER_ORE = registerBlock("endstone_silver_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool(), UniformIntProvider.create(4, 8)), ModItemGroup.MISC);
    public static final Block SILVERED_BLACKSTONE = registerBlock("silvered_blackstone", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(4.5f).requiresTool().sounds(BlockSoundGroup.GILDED_BLACKSTONE), UniformIntProvider.create(1, 5)), ModItemGroup.MISC);
    public static final Block CHISELED_SILVER_BLOCK = registerBlock("chiseled_silver_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(5.6f).requiresTool()), ModItemGroup.MISC);
    public static final Block CRACKED_SILVER_BLOCK = registerBlock("cracked_silver_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(5.6f).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ModItemGroup.MISC);
    public static final Block SILVER_STAIRS = registerBlock("silver_stairs", new StairsBlock(ModBlocks.SILVER_BLOCK.getDefaultState(),
            FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ModItemGroup.MISC);
    public static final Block SILVER_SLAB = registerBlock("silver_slab", new SlabBlock(FabricBlockSettings.of(Material.METAL)
            .strength(4.0f).requiresTool().sounds(BlockSoundGroup.NETHERITE)), ModItemGroup.MISC);

    public static final Block ELECTRUM_BLOCK = registerBlock("electrum_block", new Block(FabricBlockSettings.of(Material.METAL)
            .strength(6f).requiresTool().sounds(BlockSoundGroup.COPPER)), ModItemGroup.MISC);
    public static final Block RAW_ELECTRUM_BLOCK = registerBlock("raw_electrum_block", new Block(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool()), ModItemGroup.MISC);
    public static final Block ELECTRUM_ORE = registerBlock("electrum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool(), UniformIntProvider.create(2, 6)), ModItemGroup.MISC);
    public static final Block DEEPSLATE_ELECTRUM_ORE = registerBlock("deepslate_electrum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(2, 6)), ModItemGroup.MISC);
    public static final Block ENDSTONE_ELECTRUM_ORE = registerBlock("endstone_electrum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool(), UniformIntProvider.create(2, 6)), ModItemGroup.MISC);
    public static final Block NETHERRACK_ELECTRUM_ORE = registerBlock("netherrack_electrum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(1f).requiresTool().sounds(BlockSoundGroup.NETHER_GOLD_ORE), UniformIntProvider.create(2, 6)), ModItemGroup.MISC);
    public static final Block ELECTRUM_STAIRS = registerBlock("electrum_stairs", new StairsBlock(ModBlocks.SILVER_BLOCK.getDefaultState(),
            FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().sounds(BlockSoundGroup.COPPER)), ModItemGroup.MISC);
    public static final Block ELECTRUM_SLAB = registerBlock("electrum_slab", new SlabBlock(FabricBlockSettings.of(Material.METAL)
            .strength(4.0f).requiresTool().sounds(BlockSoundGroup.COPPER)), ModItemGroup.MISC);

    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block", new Block(FabricBlockSettings.of(Material.METAL)
            .strength(6f).requiresTool().sounds(BlockSoundGroup.COPPER)), ModItemGroup.MISC);
    public static final Block RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block", new Block(FabricBlockSettings.of(Material.METAL)
            .strength(6f).requiresTool()), ModItemGroup.MISC);
    public static final Block PLATINUM_ORE = registerBlock("platinum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6f).requiresTool(), UniformIntProvider.create(1, 3)), ModItemGroup.MISC);
    public static final Block DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore", new OreBlock(FabricBlockSettings.of(Material.STONE)
            .strength(6.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(1, 3)), ModItemGroup.MISC);
    public static final Block SCULK_PLATINUM_ORE = registerBlock("sculk_platinum_ore", new OreBlock(FabricBlockSettings.of(Material.SCULK)
            .strength(0.2f).sounds(BlockSoundGroup.SCULK_CATALYST), UniformIntProvider.create(1, 5)), ModItemGroup.MISC);
    public static final Block PLATINUM_STAIRS = registerBlock("platinum_stairs", new StairsBlock(ModBlocks.SILVER_BLOCK.getDefaultState(),
            FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().sounds(BlockSoundGroup.COPPER)), ModItemGroup.MISC);
    public static final Block PLATINUM_SLAB = registerBlock("platinum_slab", new SlabBlock(FabricBlockSettings.of(Material.METAL)
            .strength(4.0f).requiresTool().sounds(BlockSoundGroup.COPPER)), ModItemGroup.MISC);

    public static final Block STONE_STATUE = registerBlock("stone_statue", new StoneStatueBlock(FabricBlockSettings.of(Material.STONE).strength(3f, 3f).requiresTool().nonOpaque()), ModItemGroup.MISC);

    public static final Block MY_BOMB = registerBlock("my_bomb", new MyBombBlock(FabricBlockSettings.of(Material.METAL).strength(1f)), ModItemGroup.MISC);
    public static final Block STRIPMINER = registerBlock("stripminer", new MyBombBlock(FabricBlockSettings.of(Material.METAL).strength(1f)), ModItemGroup.MISC);


    //The Tavern
    public static final Block BAR_TABLE = registerBlock("bar_table", new BarTableBlock(FabricBlockSettings.of(Material.WOOD).strength(2.8f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.THE_TAVERN);

    public static final Block KEG_OF_ALE = registerBlock("keg_of_ale", new AleKegBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f, 1.5f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.THE_TAVERN);
    public static final Block KEG = registerBlock("keg", new KegBlock(FabricBlockSettings.of(Material.WOOD).strength(1.0f, 1.5f).nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.THE_TAVERN);

    public static final Block YEAST_PLANT = registerBlock("yeast_plant", new YeastPlantBlock(FabricBlockSettings.of(Material.PLANT).strength(0.5f).nonOpaque().noCollision().sounds(BlockSoundGroup.GRASS)), ModItemGroup.THE_TAVERN);

    public static final Block HOP_PLANT = registerBlock("hop_plant", new TallFlowerBlock(FabricBlockSettings.of(Material.PLANT).breakInstantly().nonOpaque().noCollision().sounds(BlockSoundGroup.AZALEA_LEAVES)), ModItemGroup.THE_TAVERN);

    public static final Block MUG = registerGrouplessBlock("mug", new MugBlock(FabricBlockSettings.of(Material.WOOD).breakInstantly().nonOpaque().sounds(BlockSoundGroup.WOOD)));
    public static final Block MUG_OF_WATER = registerGrouplessBlock("mug_of_water", new MugOfWaterBlock(FabricBlockSettings.of(Material.WOOD).breakInstantly().nonOpaque().sounds(BlockSoundGroup.WOOD)));
    public static final Block MUG_OF_ALE = registerGrouplessBlock("mug_of_ale", new MugOfAleBlock(FabricBlockSettings.of(Material.WOOD).breakInstantly().nonOpaque().sounds(BlockSoundGroup.WOOD)));



    //Dungeon Decorations
    public static final Block PRONE_SKELETON = registerBlock("prone_skeleton", new BodyProneBlock(null, FabricBlockSettings.of(Material.STONE)
            .strength(2.5f).requiresTool().nonOpaque().noCollision().sounds(BlockSoundGroup.BONE)), ModItemGroup.MISC);
    public static final Block SITTING_SKELETON = registerBlock("sitting_skeleton", new BodySittingBlock(null, FabricBlockSettings.of(Material.STONE)
            .strength(2.5f).requiresTool().nonOpaque().noCollision().sounds(BlockSoundGroup.BONE)), ModItemGroup.MISC);
    public static final Block WALL_SKELETON = registerBlock("wall_skeleton", new BodyWallBlock(null, FabricBlockSettings.of(Material.STONE)
            .strength(2.5f).requiresTool().nonOpaque().noCollision().sounds(BlockSoundGroup.BONE)), ModItemGroup.MISC);
    public static final Block HEADLESS_SKELETON = registerBlock("headless_skeleton", new BodyHeadlessBlock(null, FabricBlockSettings.of(Material.STONE)
            .strength(2.5f).requiresTool().nonOpaque().noCollision().sounds(BlockSoundGroup.BONE)), ModItemGroup.MISC);

    //Assembleable Corpses
    public static final Block SKELETON_PRONE_HEAD_HALF = registerBlock("skeleton_prone_head_half", new SkeletonProneHeadHalfBlock(FabricBlockSettings.of(Material.STONE)
            .strength(3f).requiresTool().nonOpaque().sounds(BlockSoundGroup.BONE)), ModItemGroup.MISC);


    //Trees
    public static final Block IMMOVABLE_LEAVES = registerBlock("immovable_leaves", createImmovableLeavesBlock(BlockSoundGroup.GRASS), ModItemGroup.MISC);
    public static final Block IMMOVABLE_LOG = registerBlock("immovable_log", createImmovableLogBlock(MapColor.OAK_TAN, MapColor.SPRUCE_BROWN), ModItemGroup.MISC);

    public static final Block ALDER_LEAVES = registerBlock("alder_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.BIRCH_LEAVES)), ModItemGroup.MISC);
    public static final Block ALDER_LOG = registerBlock("alder_log", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_LOG)), ModItemGroup.MISC);
    public static final Block ALDER_WOOD = registerBlock("alder_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_WOOD)), ModItemGroup.MISC);
    public static final Block STRIPPED_ALDER_LOG = registerBlock("stripped_alder_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_BIRCH_LOG)), ModItemGroup.MISC);
    public static final Block STRIPPED_ALDER_WOOD = registerBlock("stripped_alder_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_BIRCH_WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_PLANKS = registerBlock("alder_planks", new Block(FabricBlockSettings.copy(Blocks.BIRCH_PLANKS)), ModItemGroup.MISC);
    public static final Block ALDER_SAPLING = registerBlock("alder_sapling", new SaplingBlock(new AlderSaplingGenerator(), FabricBlockSettings.copy(Blocks.BIRCH_SAPLING)), ModItemGroup.MISC);
    public static final Block ALDER_BUTTON = registerBlock("alder_button", new WoodenButtonBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().noCollision().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_PRESSURE_PLATE = registerBlock("alder_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_FENCE = registerBlock("alder_fence", new FenceBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_FENCE_GATE = registerBlock("alder_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_SLAB = registerBlock("alder_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_STAIRS = registerBlock("alder_stairs", new StairsBlock(ModBlocks.ALDER_PLANKS.getDefaultState(),
            FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_DOOR = registerBlock("alder_door", new DoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ALDER_TRAPDOOR = registerBlock("alder_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block POTTED_ALDER_SAPLING = registerBlockWithoutBlockItem("potted_alder_sapling",
            new FlowerPotBlock(ModBlocks.ALDER_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_BIRCH_SAPLING)));
    public static final Block ALDER_WALL_SIGN = registerBlockWithoutBlockItem("alder_wall_sign", new WallSignBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0f).noCollision().sounds(BlockSoundGroup.WOOD), ModSignTypes.ALDER));
    public static final Block ALDER_SIGN = registerBlockWithoutBlockItem("alder_sign", new SignBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1.0f).noCollision().sounds(BlockSoundGroup.WOOD), ModSignTypes.ALDER));


    public static final Block ASH_LEAVES = registerBlock("ash_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.BIRCH_LEAVES)), ModItemGroup.MISC);
    public static final Block ASH_LOG = registerBlock("ash_log", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_LOG)), ModItemGroup.MISC);
    public static final Block ASH_WOOD = registerBlock("ash_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_WOOD)), ModItemGroup.MISC);
    public static final Block STRIPPED_ASH_LOG = registerBlock("stripped_ash_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_BIRCH_LOG)), ModItemGroup.MISC);
    public static final Block STRIPPED_ASH_WOOD = registerBlock("stripped_ash_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_BIRCH_WOOD)), ModItemGroup.MISC);
    public static final Block ASH_PLANKS = registerBlock("ash_planks", new Block(FabricBlockSettings.copy(Blocks.BIRCH_PLANKS)), ModItemGroup.MISC);
    public static final Block ASH_SAPLING = registerBlock("ash_sapling", new SaplingBlock(new AshSaplingGenerator(), FabricBlockSettings.copy(Blocks.BIRCH_SAPLING)), ModItemGroup.MISC);
    public static final Block ASH_BUTTON = registerBlock("ash_button", new WoodenButtonBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().noCollision().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_PRESSURE_PLATE = registerBlock("ash_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_FENCE = registerBlock("ash_fence", new FenceBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_FENCE_GATE = registerBlock("ash_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_SLAB = registerBlock("ash_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_STAIRS = registerBlock("ash_stairs", new StairsBlock(ModBlocks.ASH_PLANKS.getDefaultState(),
            FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_DOOR = registerBlock("ash_door", new DoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block ASH_TRAPDOOR = registerBlock("ash_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block POTTED_ASH_SAPLING = registerBlockWithoutBlockItem("potted_ash_sapling",
            new FlowerPotBlock(ModBlocks.ASH_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_BIRCH_SAPLING)));


    public static final Block BALSA_LEAVES = registerBlock("balsa_leaves", new LeavesBlock(FabricBlockSettings.copy(Blocks.BIRCH_LEAVES)), ModItemGroup.MISC);
    public static final Block BALSA_LOG = registerBlock("balsa_log", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_LOG)), ModItemGroup.MISC);
    public static final Block BALSA_WOOD = registerBlock("balsa_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.BIRCH_WOOD)), ModItemGroup.MISC);
    public static final Block STRIPPED_BALSA_LOG = registerBlock("stripped_balsa_log", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_BIRCH_LOG)), ModItemGroup.MISC);
    public static final Block STRIPPED_BALSA_WOOD = registerBlock("stripped_balsa_wood", new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_BIRCH_WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_PLANKS = registerBlock("balsa_planks", new Block(FabricBlockSettings.copy(Blocks.BIRCH_PLANKS)), ModItemGroup.MISC);
    public static final Block BALSA_SAPLING = registerBlock("balsa_sapling", new SaplingBlock(new BalsaSaplingGenerator(), FabricBlockSettings.copy(Blocks.BIRCH_SAPLING)), ModItemGroup.MISC);
    public static final Block BALSA_BUTTON = registerBlock("balsa_button", new WoodenButtonBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().noCollision().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_PRESSURE_PLATE = registerBlock("balsa_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_FENCE = registerBlock("balsa_fence", new FenceBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_FENCE_GATE = registerBlock("balsa_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_SLAB = registerBlock("balsa_slab", new SlabBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_STAIRS = registerBlock("balsa_stairs", new StairsBlock(ModBlocks.BALSA_PLANKS.getDefaultState(),
            FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).requiresTool().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_DOOR = registerBlock("balsa_door", new DoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block BALSA_TRAPDOOR = registerBlock("balsa_trapdoor", new TrapdoorBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(2.0f, 3.0f).requiresTool().nonOpaque().sounds(BlockSoundGroup.WOOD)), ModItemGroup.MISC);
    public static final Block POTTED_BALSA_SAPLING = registerBlockWithoutBlockItem("potted_balsa_sapling",
            new FlowerPotBlock(ModBlocks.BALSA_SAPLING, FabricBlockSettings.copy(Blocks.POTTED_BIRCH_SAPLING)));








    public static LeavesBlock createLeavesBlock(BlockSoundGroup soundGroup) {
        return new LeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(soundGroup).nonOpaque()
                .allowsSpawning(ModBlocks::canSpawnOnLeaves).suffocates(ModBlocks::never).blockVision(ModBlocks::never));
    }
    public static ImmovableLeavesBlock createImmovableLeavesBlock(BlockSoundGroup soundGroup) {
        return new ImmovableLeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.4F).ticksRandomly().sounds(soundGroup).nonOpaque()
                .allowsSpawning(ModBlocks::canSpawnOnLeaves).suffocates(ModBlocks::never).blockVision(ModBlocks::never));
    }
    public static ImmovablePillarBlock createImmovableLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new ImmovablePillarBlock(AbstractBlock.Settings.of(Material.WOOD, (state) -> {
            return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }


    public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    public static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(DndMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(DndMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(DndMod.MOD_ID, name), block);
    }
    private static Block registerGrouplessBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(DndMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(DndMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {return Registry.register(Registry.ITEM, new Identifier(DndMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));}
    public static void registerModBlocks() {DndMod.LOGGER.debug("Register ModBlocks for " + DndMod.MOD_ID);}
}
