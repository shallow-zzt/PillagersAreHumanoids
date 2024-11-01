package blue.amquora.pillagersarehumanoids.mixin;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.*;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
@Mixin(AbstractSkeletonEntity.class)
public abstract class SkeletonEntityMixin extends HostileEntity {

    SkeletonEntityMixin(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void initCustomGoals(CallbackInfo info) {

        targetSelector.add(3, new ActiveTargetGoal<>(this, IllagerEntity.class, true));
        targetSelector.add(3, new ActiveTargetGoal<>(this, RavagerEntity.class, true));
        targetSelector.add(3, new ActiveTargetGoal<>(this, VexEntity.class, true));
        targetSelector.add(6, new ActiveTargetGoal<>(this, WitchEntity.class, true));
    }
}
