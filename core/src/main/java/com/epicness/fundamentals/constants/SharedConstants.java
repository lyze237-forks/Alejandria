package com.epicness.fundamentals.constants;

import com.badlogic.gdx.Gdx;

public class SharedConstants {

    // Camera
    public static final float RATIO = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
    public static final float CAMERA_HEIGHT = 1000;
    public static final float CAMERA_WIDTH = CAMERA_HEIGHT * RATIO;
    public static final float CAMERA_HALF_HEIGHT = CAMERA_HEIGHT / 2f;

    public static final float VIEWPORT_WIDTH = 1000f;
    public static final float VIEWPORT_HEIGHT = 1000f;
    public static final float VIEWPORT_HALF_WIDTH = VIEWPORT_WIDTH / 2f;
    public static final float VIEWPORT_HALF_HEIGHT = VIEWPORT_HEIGHT / 2f;
}