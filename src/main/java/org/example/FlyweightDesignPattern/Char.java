package org.example.FlyweightDesignPattern;

public class Char {
    private final char character;
    private final CharacterStyle characterStyle;

    public Char(char character, CharacterStyle characterStyle) {
        this.character = character;
        this.characterStyle = characterStyle;
    }

    public char getCharacter() {
        return character;
    }

    public CharacterStyle getCharacterStyle() {
        return characterStyle;
    }
}
