package xyz.frish2021.bettitle.mixin;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.frish2021.bettitle.util.JsonTitle;
import xyz.frish2021.bettitle.util.TitleUtil;

@Mixin(Minecraft.class)
public class MinecraftClientMixin {

    @Shadow @Final private Window window;
    private final JsonTitle jt = new JsonTitle();

    /**
     * @author Frish2021
     * @reason 1.0
     */
    @Overwrite
    public void updateTitle() {
        jt.saveJson(jt.getTitleStringFile());
        TitleUtil.setTitle(jt.getTitle(jt.getTitleStringFile()));
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    public void runTick(CallbackInfo callbackInfo) {
        this.updateTitle();
    }
}
