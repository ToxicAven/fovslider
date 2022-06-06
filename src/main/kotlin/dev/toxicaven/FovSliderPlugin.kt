package dev.toxicaven

import com.lambda.client.plugin.api.Plugin
import dev.toxicaven.modules.FovSlider

internal object FovSliderPlugin : Plugin() {

    override fun onLoad() {
        modules.add(FovSlider)
    }

    override fun onUnload() {
        // Here you can unregister threads etc...
    }
}