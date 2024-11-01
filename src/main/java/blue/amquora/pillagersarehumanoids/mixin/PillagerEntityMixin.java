package blue.amquora.pillagersarehumanoids.mixin;


import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(IllagerEntity.class)
public abstract class PillagerEntityMixin extends HostileEntity{

    PillagerEntityMixin(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void initCustomGoals(CallbackInfo info) {
        targetSelector.add(3, new ActiveTargetGoal<>(this, AnimalEntity.class, true));
        targetSelector.add(3, new ActiveTargetGoal<>(this, MobEntity.class, 5, false, false, (entity)
                -> entity instanceof Monster && !(entity instanceof CreeperEntity||entity instanceof WitchEntity||entity instanceof RavagerEntity||entity instanceof VexEntity)));

    }


}