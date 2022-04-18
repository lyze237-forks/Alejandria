package com.epicness.alejandria.showcase.logic.modules.masking;

import static com.epicness.alejandria.Constants.INITIAL_WINDOW_SIZE;
import static com.epicness.alejandria.showcase.constants.LayeredMaskingConstants.SHAPE_SIZE;

import com.badlogic.gdx.Gdx;
import com.epicness.alejandria.showcase.logic.modules.Module;
import com.epicness.alejandria.showcase.stuff.modules.masking.LayeredMaskingDrawable;
import com.epicness.fundamentals.stuff.Circle;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;

import java.util.List;

public class LayeredMasking extends Module {

    private LayeredMaskingDrawable drawable;

    @Override
    public void setup() {
        drawable = new LayeredMaskingDrawable(
                sharedAssets.getWeirdShape(),
                sharedAssets.getSquare(),
                sharedAssets.getSquareInverted(),
                sharedAssets.getPixel()
        );
        stuff.getShowcase().setDrawable(drawable);
        Gdx.gl.glLineWidth(3f);
    }

    @Override
    public void update(float delta) {
        Sprited mask = drawable.getMask();
        mask.rotate(delta * 5f);
        List<DualSprited> shapes = drawable.getShapes();
        for (int i = 0; i < shapes.size(); i++) {
            DualSprited shape = shapes.get(i);
            shape.translateY(delta * 30f);
            if (shape.getY() >= INITIAL_WINDOW_SIZE) {
                shape.setY(-SHAPE_SIZE);
            }
        }

        Circle circle1 = drawable.getCircle1();
        circle1.translateX(delta * 100f);
        if (circle1.getX() - circle1.getRadius() >= INITIAL_WINDOW_SIZE) {
            circle1.setX(-circle1.getRadius());
        }

        Circle circle2 = drawable.getCircle2();
        circle2.translateX(-delta * 100f);
        if (circle2.getX() + circle2.getRadius() <= 0f) {
            circle2.setX(INITIAL_WINDOW_SIZE + circle2.getRadius());
        }
    }

    @Override
    public void exit() {
        Gdx.gl.glLineWidth(1f);
        drawable = null;
    }
}