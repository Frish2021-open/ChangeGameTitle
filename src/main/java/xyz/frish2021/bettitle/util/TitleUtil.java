package xyz.frish2021.bettitle.util;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.vehicle.Minecart;
import org.lwjgl.glfw.GLFW;

public class TitleUtil {
    public static void setTitle(String string) {
        GLFW.glfwSetWindowTitle(Minecraft.getInstance().getWindow().getWindow(), string);
    }
}
