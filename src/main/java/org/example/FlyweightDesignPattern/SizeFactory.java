package org.example.FlyweightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class SizeFactory{
    private static Map<Integer, CharSize> sizes = new HashMap<>();

    public static CharSize getCharSize(int size){
        CharSize charSize = sizes.get(size);
        if(charSize == null){
            charSize = new CharSize(size);
            sizes.put(size, charSize);
        }
        return charSize;
    }
}
