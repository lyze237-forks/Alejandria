package com.epicness.alejandria.showcase.modules.collisions;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.alejandria.showcase.stuff.modules.ModuleDrawable;
import com.epicness.fundamentals.renderer.ShapeDrawerPlus;
import com.epicness.fundamentals.renderer.ShapeRendererPlus;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.utils.PixmapUtils;

public class PixelPerfectCollisionDrawable implements ModuleDrawable {

    private final Pixmap pixmap;
    private final Sprited[] shapes;

    public PixelPerfectCollisionDrawable(Sprite weirdShape) {
        pixmap = PixmapUtils.convertToPixmap(weirdShape);
        shapes = new Sprited[5];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = new Sprited(weirdShape);
            shapes[i].setSize(MathUtils.random(175, 225));
        }
        shapes[0].useBilinearFilter();
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeDrawerPlus shapeDrawer, ShapeRendererPlus shapeRenderer) {
        spriteBatch.begin();
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw(spriteBatch);
        }
        spriteBatch.end();
    }

    @Override
    public void drawDebug(ShapeRendererPlus shapeRenderer) {
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].drawDebug(shapeRenderer);
        }
    }

    public Pixmap getPixmap() {
        return pixmap;
    }

    public Sprited[] getShapes() {
        return shapes;
    }
}