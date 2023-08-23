package com.epicness.alejandria.showcase.modules.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.epicness.alejandria.showcase.logic.Module;

public class FrameBuffering extends Module<FrameBufferingModuleDrawable> {

    public FrameBuffering() {
        super(
                "Frame Buffer Example",
                "Blue means normal rendering\n\n" +
                        "Red means we are using a frame buffer\n\n" +
                        "Space to toggle"
        );
    }

    @Override
    public FrameBufferingModuleDrawable setup() {
        return new FrameBufferingModuleDrawable(sharedAssets.getGlow());
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) drawable.toggleDrawDirect();
    }
}