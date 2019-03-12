package main.java;

public class ROT {
    private int shiftForward;
    private int shiftBackward;
    public ROT(Character cs, Character cf) {
        shiftForward = cf - cs;
        shiftBackward = 26 - shiftForward;
    }

    public String encrypt(String text) {
        return crypt(text, true);
    }

    public String decrypt(String text) {
        return crypt(text, false);
    }

    public String crypt(String text, boolean forward) {
        int shiftDistance = forward ? shiftForward : shiftBackward;
        StringBuilder stringBuilder = new StringBuilder();
        for(char character: text.toCharArray()) {
            stringBuilder.append(shift(character, shiftDistance));
        }
        return stringBuilder.toString();
    }

    private char shift(char character, int shiftDistance) {
        if (!Character.isLetter(character)) {
            return character;
        } else if (Character.isUpperCase(character)) {
                return (char) (((int) character + shiftDistance - 65) % 26 + 65);
        } else {
                return (char) (((int) character + shiftDistance - 97) % 26 + 97);
        }
    }

    public static String rotate(String s, Character c) {
        int characterAt = s.indexOf(c);
        return  s.substring(characterAt) + s.substring(0, characterAt);
    }

}
