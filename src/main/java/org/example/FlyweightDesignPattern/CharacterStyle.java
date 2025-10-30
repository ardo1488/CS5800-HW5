package org.example.FlyweightDesignPattern;

public class CharacterStyle {

    private CharFont font;
    private CharColor color;
    private CharSize size;

    public CharacterStyle(CharFont font, CharColor color, CharSize size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public CharFont getFont() {
        return font;
    }

    public void setFont(CharFont font) {
        this.font = font;
    }

    public CharColor getColor() {
        return color;
    }

    public void setColor(CharColor color) {
        this.color = color;
    }

    public CharSize getSize() {
        return size;
    }

    public void setSize(CharSize size) {
        this.size = size;
    }
}
