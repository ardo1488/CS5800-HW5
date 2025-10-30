package org.example.FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class ColorFactory{
    private static Map<String, CharColor> colors = new HashMap<>();

    public static CharColor getCharColor(String color){
        CharColor charColor = colors.get(color);
        if(charColor == null){
            charColor = new CharColor(color);
            colors.put(color,charColor);
        }
        return charColor;
    }
}