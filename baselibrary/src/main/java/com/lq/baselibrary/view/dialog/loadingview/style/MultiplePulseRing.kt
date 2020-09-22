package com.lq.baselibrary.view.dialog.loadingview.style

import com.lq.baselibrary.view.dialog.loadingview.sprite.Sprite
import com.lq.baselibrary.view.dialog.loadingview.sprite.SpriteContainer

/**
 * @author tamsiree
 */
class MultiplePulseRing : SpriteContainer() {
    override fun onCreateChild(): Array<Sprite?>? {
        return arrayOf(
                PulseRing(),
                PulseRing(),
                PulseRing())
    }

    override fun onChildCreated(vararg sprites: Sprite?) {
        for (i in 0 until sprites.size) {
            sprites[i]?.setAnimationDelay(200 * (i + 1))
        }
    }
}