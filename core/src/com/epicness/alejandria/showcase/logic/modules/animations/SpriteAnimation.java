package com.epicness.alejandria.showcase.logic.modules.animations;

import com.epicness.alejandria.showcase.logic.modules.Module;
import com.epicness.alejandria.showcase.stuff.modules.animations.SpriteAnimationDrawable;

public class SpriteAnimation extends Module<SpriteAnimationDrawable> {

    public SpriteAnimation() {
        super("Sprite Animation", "This animation uses a Texture containing all the frames");
    }

    @Override
    public SpriteAnimationDrawable setup() {
        return drawable = new SpriteAnimationDrawable(assets.getStickmanRunFrames());
    }

    @Override
    public void update(float delta) {
        drawable.getAnimation().addTime(delta);
    }
}