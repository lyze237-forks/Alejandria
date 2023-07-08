package com.epicness.fundamentals.stuff;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.epicness.fundamentals.renderer.ShapeBatch;
import com.epicness.fundamentals.stuff.interfaces.Actor;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;

public class Sprited implements Actor, Buttonable {

    private final Sprite sprite;

    public Sprited(Sprite sprite) {
        this.sprite = new Sprite(sprite);
    }

    public void setSprite(Sprite sprite) {
        this.sprite.setRegion(sprite);
    }

    @Override
    public void draw(SpriteBatch spriteBatch, ShapeBatch shapeBatch) {
        sprite.draw(spriteBatch);
    }

    @Override
    public void drawDebug(ShapeBatch shapeBatch) {
        Rectangle bounds = sprite.getBoundingRectangle();
        shapeBatch.rect(bounds);
    }

    @Override
    public boolean contains(float x, float y) {
        return sprite.getBoundingRectangle().contains(x, y);
    }

    public Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public void translateX(float amount) {
        sprite.translateX(amount);
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    public void translateY(float amount) {
        sprite.translateY(amount);
    }

    @Override
    public void stretchWidth(float amount) {
        sprite.setSize(sprite.getWidth() + amount, sprite.getHeight());
    }

    @Override
    public void stretchHeight(float amount) {
        sprite.setSize(sprite.getWidth(), sprite.getHeight() + amount);
    }

    @Override
    public float getWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getHeight() {
        return sprite.getHeight();
    }

    public void setOriginBasedPosition(float x, float y) {
        sprite.setOriginBasedPosition(x, y);
    }

    public float getCenterX() {
        return sprite.getX() + sprite.getWidth() / 2f;
    }

    public float getCenterY() {
        return sprite.getY() + sprite.getHeight() / 2f;
    }

    public Vector2 getCenter() {
        return new Vector2(getCenterX(), getCenterY());
    }

    public float getOriginBasedX() {
        return sprite.getX() + sprite.getOriginX();
    }

    public float getOriginBasedY() {
        return sprite.getY() + sprite.getOriginY();
    }

    public Vector2 getOriginBasedCenter() {
        return new Vector2(getOriginBasedX(), getOriginBasedY());
    }

    public Vector2 getScale() {
        return new Vector2(sprite.getScaleX(), sprite.getScaleY());
    }

    public void setScale(float scale) {
        sprite.setScale(scale);
    }

    public float getOriginX() {
        return sprite.getOriginX();
    }

    public float getOriginY() {
        return sprite.getOriginY();
    }

    public void setOrigin(float originX, float originY) {
        sprite.setOrigin(originX, originY);
    }

    public void setOriginCenter() {
        sprite.setOriginCenter();
    }

    public float getRotation() {
        return sprite.getRotation();
    }

    public void setRotation(float degrees) {
        sprite.setRotation(degrees);
    }

    public void rotate(float degrees) {
        sprite.rotate(degrees);
    }

    public boolean isFlipX() {
        return sprite.isFlipX();
    }

    public void setFlip(boolean flipX, boolean flipY) {
        sprite.setFlip(flipX, flipY);
    }

    public Color getColor() {
        return sprite.getColor();
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }

    public void useBilinearFilter() {
        sprite.getTexture().setFilter(Linear, Linear);
    }
}