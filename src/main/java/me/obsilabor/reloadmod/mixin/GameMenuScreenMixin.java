package me.obsilabor.reloadmod.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {

    protected GameMenuScreenMixin(Text text) {
        super(text);
    }

    @Inject(method = "initWidgets", at = @At("TAIL"))
    private void injectReloadResourcesButton(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(0, this.height - 20, 98, 20, Text.translatable("gui.reloadResources"), (buttonWidgetx) -> this.client.reloadResources()));
    }
}
