package org.example.FlyweightDesignPattern;

import java.util.Map;
import java.util.HashMap;

public class CharacterStyleFactory {

    private static final Map<String, CharacterStyle> characterStyles = new HashMap<>();

    public static CharacterStyle getCharacterStyle(String font, String color, int size) {

        CharFont charFont = FontFactory.getCharFont(font);
        CharColor charColor = ColorFactory.getCharColor(color);
        CharSize charSize = SizeFactory.getCharSize(size);

        String key = font + color + size;

        CharacterStyle characterStyle = characterStyles.get(key);
        if (characterStyle == null) {
            characterStyle = new CharacterStyle(charFont, charColor, charSize);
            characterStyles.put(key, characterStyle);
        }
        return characterStyle;
    }
}
