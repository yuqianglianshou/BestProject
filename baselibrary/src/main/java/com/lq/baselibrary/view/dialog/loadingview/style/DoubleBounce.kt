package com.lq.baselibrary.view.dialog.loadingview.style

import android.animation.ValueAnimator
import com.lq.baselibrary.view.dialog.loadingview.animation.SpriteAnimatorBuilder
import com.lq.baselibrary.view.dialog.loadingview.sprite.CircleSprite
import com.lq.baselibrary.view.dialog.loadingview.sprite.Sprite
import com.lq.baselibrary.view.dialog.loadingview.sprite.SpriteContainer

/**
 * @author tamsiree
 */
class DoubleBounce : SpriteContainer() {
    override fun onCreateChild(): Array<Sprite?>? {
        return arrayOf(
                Bounce(), Bounce()
        )
    }

    override fun onChildCreated(vararg sprites: Sprite?) {
        super.onChildCreated(*sprites)
        sprites[1]?.setAnimationDelay(-1000)
    }

    private inner class Bounce internal constructor() : CircleSprite() {
        override fun onCreateAnimation(): ValueAnimator? {
            val fractions = floatArrayOf(0f, 0.5f, 1f)
            return SpriteAnimatorBuilder(this).scale(fractions, 0f, 1f, 0f).duration(2000).easeInOut(*fractions)
                    .build()
        }

        init {
            alpha = 153
            setScale(0f)
        }
    }
}