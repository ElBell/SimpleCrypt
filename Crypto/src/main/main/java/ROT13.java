package main.java;

public class ROT13 extends ROT{

    public ROT13() {
        super('a', 'n');
    }

    public String crypt(String text) {
        return crypt(text, true);
    }
}
