package blue.amquora.pillagersarehumanoids.mixin;


import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(PiglinBruteEntity.class)
public abstract class PiglinEntityMixin extends HostileEntity{

    PiglinEntityMixin(EntityType<? extends HostileEntity> type, World world) {super(type, world);}

    @Inject(method = "initEquipment", at = @At("TAIL"))
    private void initCustomEquipment(CallbackInfo info) {
        this.equipStack(EquipmentSlot.OFFHAND,new ItemStack(Items.GOLDEN_PICKAXE));
        this.equipStack(EquipmentSlot.HEAD,new ItemStack(Items.GOLDEN_HELMET));
    }
}