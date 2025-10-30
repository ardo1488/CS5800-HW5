package org.example.FlyweightDesignPattern;

public class Driver {
    public static void main(String[] args) {

        Document document = new Document();

//        String font = "Arial";
//        String color = "Black";
//        int size = 12;
//
//        String text = "HelloWorldCS5800";
//
//        for (char ch : text.toCharArray()) {
//            document.storeCharacter(ch, font, color, size);
//        }

        document.storeCharacter('H', "Arial", "Red", 16);
        document.storeCharacter('e', "Arial", "Red", 12);
        document.storeCharacter('l', "Calibri", "Blue", 14);
        document.storeCharacter('l', "Calibri", "Purple", 12);
        document.storeCharacter('o', "Verdana", "Green", 12);
        document.storeCharacter('W', "Arial", "Red", 14);
        document.storeCharacter('o', "Arial", "Green", 12);
        document.storeCharacter('r', "Arial", "Blue", 16);
        document.storeCharacter('l', "Calibri", "Purple", 12);
        document.storeCharacter('d', "Calibri", "Red", 12);
        document.storeCharacter('C', "Verdana", "Red", 14);
        document.storeCharacter('S', "Arial", "Blue", 16);
        document.storeCharacter('5', "Arial", "Red", 14);
        document.storeCharacter('8', "Verdana", "Yellow", 12);
        document.storeCharacter('0', "Verdana", "Yellow", 16);
        document.storeCharacter('0', "Arial", "Red", 12);



        document.print();
    }
}
