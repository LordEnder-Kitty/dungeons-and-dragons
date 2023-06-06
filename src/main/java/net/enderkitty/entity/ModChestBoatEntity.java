package net.enderkitty.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.RideableInventory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.VehicleInventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ModChestBoatEntity  extends ModBoatEntity implements RideableInventory, VehicleInventory {
    private static final int CONTAINER_SIZE = 27;
    private DefaultedList<ItemStack> itemStacks = DefaultedList.ofSize(CONTAINER_SIZE, ItemStack.EMPTY);
    @Nullable
    private Identifier lootTableId;
    private long lootTableSeed;

    public ModChestBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

    public static ModChestBoatEntity create(World world, double x, double y, double z) {
        ModChestBoatEntity boat = ModBoatEntities.CHEST_BOAT.get().create(world);
        boat.setPosition(x, y, z);
        boat.prevX = x;
        boat.prevY = y;
        boat.prevZ = z;
        return boat;
    }

    @Override
    protected float getPassengerHorizontalOffset() {
        return 0.15F;
    }

    @Override
    protected int getMaxPassengers() {
        return 1;
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound pCompound) {
        super.writeCustomDataToNbt(pCompound);
        this.writeInventoryToNbt(pCompound);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound pCompound) {
        super.readCustomDataFromNbt(pCompound);
        this.readInventoryFromNbt(pCompound);
    }

    @Override
    public void dropItems(DamageSource source) {
        super.dropItems(source);
        this.onBroken(source, this.world, this);
    }

    @Override
    public void remove(Entity.RemovalReason reason) {
        if (!this.world.isClient && reason.shouldDestroy()) {
            ItemScatterer.spawn(this.world, this, this);
        }
        super.remove(reason);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        return this.canAddPassenger(player) && !player.shouldCancelInteraction() ? super.interact(player, hand) : this.open(this::emitGameEvent, player);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        player.openHandledScreen(this);
        if (!player.world.isClient) {
            this.emitGameEvent(GameEvent.CONTAINER_OPEN, player);
            PiglinBrain.onGuardedBlockInteracted(player, true);
        }
    }

    @Override
    public Item asItem() {
        return getWoodType().getChestItemDrop();
    }

    @Override
    public void clear() {
        this.clearInventory();
    }

    @Override
    public int size() {
        return 27;
    }

    @Override
    public ItemStack getStack(int pIndex) {
        return this.getInventoryStack(pIndex);
    }

    @Override
    public ItemStack removeStack(int pIndex, int pCount) {
        return this.removeInventoryStack(pIndex, pCount);
    }

    @Override
    public ItemStack removeStack(int pIndex) {
        return this.removeInventoryStack(pIndex);
    }

    @Override
    public void setStack(int pIndex, ItemStack pStack) {
        this.setInventoryStack(pIndex, pStack);
    }

    @Override
    public StackReference getStackReference(int pSlot) {
        return this.getInventoryStackReference(pSlot);
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return this.canPlayerAccess(player);
    }

    @Nullable
    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        if (this.lootTableId != null && playerEntity.isSpectator()) {
            return null;
        } else {
            this.generateLoot(playerInventory.player);
            return GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, this);
        }
    }

    public void generateLoot(@Nullable PlayerEntity player) {
        this.generateInventoryLoot(player);
    }

    @Nullable
    public Identifier getLootTableId() {
        return this.lootTableId;
    }

    @Override
    public void setLootTableId(@Nullable Identifier location) {
        this.lootTableId = location;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(long seed) {
        this.lootTableSeed = seed;
    }

    @Override
    public DefaultedList<ItemStack> getInventory() {
        return this.itemStacks;
    }

    @Override
    public void resetInventory() {
        this.itemStacks = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
    }
}