package com.codenation.cifra.service;

public class CipherService {
    private int alfaStart = 97;
    private int alfaEnd = 122;
    private int changeFactor;

    public CipherService(int changeFactor) {
        this.changeFactor = changeFactor;
    }

    public String encode (String phase) {
        phase = phase.toLowerCase();
        String res = "";
        for (char c : phase.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int ascii = getASCII(c);
                c = this.forwardChar(ascii);
            }
            res += c;
        }
        return res;
    }

    public String decode (String encoded) {
        encoded = encoded.toLowerCase();
        String res = "";
        for (char c : encoded.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int ascii = getASCII(c);
                c = this.backwardChar(ascii);
            }
            res += c;
        }
        return res;
    }

    private int getASCII (char character) {
        return (int) character;
    }

    private char forwardChar (int ascii) {
        char newChar = (char) (ascii + this.changeFactor);
        System.out.println(getASCII(newChar) );
        if(getASCII(newChar) > alfaEnd) newChar = (char) (alfaStart + ((changeFactor - (alfaEnd - ascii) ) -1));
        return newChar;
    }

    private char backwardChar (int ascii) {
        char newChar = (char) (ascii - this.changeFactor);
        System.out.println(getASCII(newChar) );
        if(getASCII(newChar) < alfaStart) newChar = (char) (alfaEnd - ((changeFactor - (ascii - alfaStart) ) - 1));
        return newChar;
    }
}
