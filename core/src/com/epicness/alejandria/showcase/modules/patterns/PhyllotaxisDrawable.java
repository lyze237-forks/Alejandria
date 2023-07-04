package com.epicness.alejandria.showcase.modules.patterns;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType.Filled;
import static com.epicness.alejandria.showcase.constants.PatternsConstants.PHYLLOTAXIS_CIRCLES;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.epicness.alejandria.showcase.stuff.Drawable;
import com.epicness.fundamentals.stuff.shapes.Circle;

public class PhyllotaxisDrawable implements Drawable {

    private final Circle[] circles;

    public PhyllotaxisDrawable() {
        circles = new Circle[PHYLLOTAXIS_CIRCLES];
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(Filled);
        for (int i = 0; i < PHYLLOTAXIS_CIRCLES; i++) {
            circles[i].draw(shapeRenderer);
        }
        shapeRenderer.end();
    }

    public Circle[] getCircles() {
        return circles;
    }
}