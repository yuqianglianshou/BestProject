package com.lq.baselibrary.view.dialog.loadingview.style

import android.animation.ValueAnimator
import com.lq.baselibrary.view.dialog.loadingview.animation.SpriteAnimatorBuilder
import com.lq.baselibrary.view.dialog.loadingview.sprite.CircleSprite

/**
 * @author tamsiree
 */
class Pulse : CircleSprite() {
    override fun onCreateAnimation(): ValueAnimator? {
        val fractions = floatArrayOf(0f, 1f)
        return SpriteAnimatorBuilder(this).scale(fractions, 0f, 1f).alpha(fractions, 255, 0).duration(1000).easeInOut(*fractions)
                .build()
    }

    init {
        setScale(0f)
    }
}