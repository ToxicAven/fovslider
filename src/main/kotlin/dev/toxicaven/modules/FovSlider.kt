package dev.toxicaven.modules

import dev.toxicaven.FovSliderPlugin
import com.lambda.client.module.Category
import com.lambda.client.plugin.api.PluginModule
import com.lambda.client.util.threads.safeListener
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent

internal object FovSlider : PluginModule(
    name = "FovSlider",
    category = Category.RENDER,
    description = "Allows you to set your FOV higher than the game permits",
    pluginMain = FovSliderPlugin
) {

    private val fov by setting("FOV", 90f, 30f..200f, 1f)
    private var oldFOV = 0f

    init {
        safeListener<ClientTickEvent> {
            mc.gameSettings.fovSetting = fov
        }

        onEnable {
            oldFOV = mc.gameSettings.fovSetting
        }

        onDisable {
            mc.gameSettings.fovSetting = oldFOV
        }
    }
}