package blue.amquora.pillagersarehumanoids;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.world.World;

import java.util.List;

public class PillagersAreHumanoids implements ModInitializer{
    @Override
    public void onInitialize() {
        ServerLivingEntityEvents.AFTER_DEATH.register(this::illagerEntityDeath);
    }

    private void illagerEntityDeath(LivingEntity entity, DamageSource source) {
        if ((entity instanceof IllagerEntity || entity instanceof WitchEntity) && source.getAttacker() instanceof ZombieEntity) {
            World world = entity.getWorld();
            ZombieVillagerEntity zombieVillager = new ZombieVillagerEntity(EntityType.ZOMBIE_VILLAGER, world);
            zombieVillager.copyPositionAndRotation(entity);
            zombieVillager.equipStack(EquipmentSlot.MAINHAND,entity.getEquippedStack(EquipmentSlot.MAINHAND));
            zombieVillager.equipStack(EquipmentSlot.OFFHAND,entity.getEquippedStack(EquipmentSlot.OFFHAND));
            zombieVillager.equipStack(EquipmentSlot.HEAD,entity.getEquippedStack(EquipmentSlot.HEAD));
            zombieVillager.equipStack(EquipmentSlot.CHEST,entity.getEquippedStack(EquipmentSlot.CHEST));
            zombieVillager.equipStack(EquipmentSlot.LEGS,entity.getEquippedStack(EquipmentSlot.LEGS));
            zombieVillager.equipStack(EquipmentSlot.FEET,entity.getEquippedStack(EquipmentSlot.FEET));
            world.spawnEntity(zombieVillager);
            entity.setHealth(0);
            entity.remove(Entity.RemovalReason.KILLED);
        }
    }

}
