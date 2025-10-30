package org.example.FlyweightDesignPattern;

import java.util.List;
import java.util.ArrayList;

public class Document {

    private final List<Char> document = new ArrayList<>();

    public void storeCharacter(char character, String font, String color, int size) {

        CharacterStyle characterStyle = CharacterStyleFactory.getCharacterStyle(font, color, size);
        document.add(new Char(character, characterStyle));
    }

    @Override
    public String toString(){
        StringBuilder doc = new StringBuilder();

        for(Char c : document){
            doc.append(c.getCharacter());
        }
        return doc.toString();
    }

    public void print(){
        for(Char c : document){
            CharacterStyle characterStyle = c.getCharacterStyle();
            System.out.println(c.getCharacter() + " [Font=" + characterStyle.getFont().getFont() + ", Color=" + characterStyle.getColor().getColor()
                    + ", Size=" + characterStyle.getSize().getSize() + "]");
        }
    }
}


