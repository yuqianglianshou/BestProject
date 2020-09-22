package com.lq.baselibrary.view.dialog.loadingview.style

import com.lq.baselibrary.view.dialog.loadingview.sprite.Sprite
import com.lq.baselibrary.view.dialog.loadingview.sprite.SpriteContainer

/**
 * @author tamsiree
 */
class MultiplePulse : SpriteContainer() {
    override fun onCreateChild(): Array<Sprite?>? {
        return arrayOf(
                Pulse(),
                Pulse(),
                Pulse())
    }

    override fun onChildCreated(vararg sprites: Sprite?) {
        for (i in sprites.indices) {
            sprites[i]?.setAnimationDelay(200 * (i + 1))
        }
    }
}