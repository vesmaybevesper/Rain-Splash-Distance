package dev.vesper.rainsplashdistance.mixin;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.client.Options.genericValueLabel;

@Mixin(Options.class)
public abstract class OptionsMixin {

    @Mutable
    @Shadow
    @Final
    private OptionInstance<@NotNull Integer> weatherRadius;

    @Shadow
    protected abstract void setGraphicsPresetToCustom();

    @Shadow
    @Final
    private static Component GRAPHICS_TOOLTIP_WEATHER_RADIUS;

    @ModifyVariable(method = "", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;weatherRadius:Lnet/minecraft/client/OptionInstance;"))
    private void modifyWeatherRadius(CallbackInfo ci) {
        this.weatherRadius = new OptionInstance<>("options.weatherRadius", OptionInstance.cachedConstantTooltip(GRAPHICS_TOOLTIP_WEATHER_RADIUS), (component, integer) -> genericValueLabel(component, Component.translatable("options.blocks", new Object[]{integer})), new OptionInstance.IntRange(3, 50, true), 10, (integer) -> this.setGraphicsPresetToCustom());
    }

}
