package net.enderkitty.entity.entities.boats;

import net.enderkitty.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class ModBoatEntity extends BoatEntity {
    private static final TrackedData<Integer> WOOD_TYPE = DataTracker.registerData(ModBoatEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public ModBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

    public static ModBoatEntity create(World world, double x, double y, double z) {
        ModBoatEntity boat = ModBoatEntities.BOAT.get().create(world);
        boat.setPosition(x, y, z);
        boat.prevX = x;
        boat.prevY = y;
        boat.prevZ = z;
        return boat;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(WOOD_TYPE, 0);
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Type", 8)) {
            this.setWoodType(Type.byName(nbt.getString("Type")));
        }
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putString("Type", this.getWoodType().name);
    }

    public Type getWoodType() {
        return Type.getType(this.dataTracker.get(WOOD_TYPE));
    }

    public void setWoodType(Type type) {
        this.dataTracker.set(WOOD_TYPE, type.ordinal());
    }

    @Override
    public Item asItem() {
        return this.getWoodType().getItemDrop();
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    public enum Type {
        ALDER("alder", () -> ModItems.ALDER_BOAT.get(), () -> ModItems.ALDER_CHEST_BOAT.get()),
        ASH("ash", () -> ModItems.ASH_BOAT.get(), () -> ModItems.ASH_CHEST_BOAT.get()),
        BALSA("balsa", () -> ModItems.BALSA_BOAT.get(), () -> ModItems.BALSA_CHEST_BOAT.get());

        private final String name;
        private final Supplier<Item> item;
        private final Supplier<Item> chestItem;

        Type(String name, Supplier<Item> boatItem, Supplier<Item> chestBoatItem) {
            this.name = name;
            this.item = boatItem;
            this.chestItem = chestBoatItem;
        }

        public static Type getType(int type) {
            Type[] types = values();
            if (type < 0 || type >= types.length) {
                type = 0;
            }
            return types[type];
        }

        public static Type byName(String name) {
            Type[] values = values();

            for (Type value : values) {
                if (value.getName().equals(name)) {
                    return value;
                }
            }
            return values[0];
        }

        public String getName() {
            return name;
        }

        public Item getItemDrop() {
            return item.get();
        }

        public Item getChestItemDrop() {
            return chestItem.get();
        }
    }
}