package com.epicness.alejandria.showcase.modules.viewports;

import static com.badlogic.gdx.graphics.Color.RED;
import static com.epicness.alejandria.showcase.constants.ShowcaseConstants.WINDOW_SIZE;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.constants.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.alejandria.showcase.stuff.modules.ModuleDrawable;
import com.epicness.fundamentals.renderer.ShapeRendererPlus;

public class WideViewportModuleDrawable implements ModuleDrawable {

    private final Matrix4 normalProjectionMatrix, wideProjectionMatrix;
    private final FrameBuffer frameBuffer;
    private final Sprite weirdShape, bufferSprite;

    public WideViewportModuleDrawable(OrthographicCamera camera, Sprite weirdShapeSprite) {
        normalProjectionMatrix = camera.combined;
        camera.setToOrtho(false, CAMERA_WIDTH * 2f, CAMERA_HEIGHT);
        wideProjectionMatrix = camera.combined.cpy();
        camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT); // Affects normalProjectionMatrix

        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, WINDOW_SIZE, WINDOW_SIZE, false);

        weirdShape = new Sprite(weirdShapeSprite);
        weirdShape.setOriginCenter();
        weirdShape.setOriginBasedPosition(CAMERA_WIDTH + CAMERA_HALF_WIDTH, CAMERA_HALF_HEIGHT);

        bufferSprite = new Sprite();
        bufferSprite.setSize(800f, 400f); // Must have same aspect ratio as wideProjectionMatrix
        bufferSprite.setOriginCenter();
        bufferSprite.setOriginBasedPosition(CAMERA_HALF_WIDTH, CAMERA_HALF_HEIGHT);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeRendererPlus shapeRenderer) {
        // Use the wide projection matrix with the frame buffer
        spriteBatch.setProjectionMatrix(wideProjectionMatrix);
        // Render whatever to the frame buffer
        frameBuffer.begin();
        ScreenUtils.clear(RED);
        spriteBatch.begin();
        weirdShape.draw(spriteBatch);
        spriteBatch.end();
        frameBuffer.end();
        // Buffer rendering done, back to un-stretched projection matrix
        spriteBatch.setProjectionMatrix(normalProjectionMatrix);
        // Get the texture from the frame buffer and render it
        Texture texture = frameBuffer.getColorBufferTexture();
        bufferSprite.setRegion(texture); // setTexture will not work
        spriteBatch.begin();
        bufferSprite.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void drawDebug(ShapeRendererPlus shapeRenderer) {
    }
}