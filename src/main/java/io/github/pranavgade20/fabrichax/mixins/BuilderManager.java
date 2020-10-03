package io.github.pranavgade20.fabrichax.mixins;

import io.github.pranavgade20.fabrichax.Builder;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class BuilderManager {
    @Inject(at = @At("RETURN"), method = "interactBlock(Lnet/minecraft/client/network/ClientPlayerEntityLnet/minecraft/client/world/ClientWorldLnet/minecraft/util/HandLnet/minecraft/util/hit/BlockHitResult;)Lnet/minecraft/util/ActionResult;")
    private ActionResult onInteractBlock(ClientPlayerEntity player, ClientWorld world, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir) {
        if (Builder.enabled) Builder.build(hand, hitResult);
        return cir.getReturnValue();
    }
}
