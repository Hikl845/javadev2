package org.example;

class DigitSplitter{
    public int getFirstDigit(int number){
        String str = Integer.toString(number);
        char b = str.charAt(1);
        return b;
    }
}