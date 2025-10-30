package org.example.FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static final Map<String, CharFont> fonts = new HashMap<>();

    public static CharFont getCharFont(String font) {
        CharFont charFont = fonts.get(font);
        if(charFont == null) {
            charFont = new CharFont(font);
            fonts.put(font, charFont);
        }
        return charFont;
    }
}
