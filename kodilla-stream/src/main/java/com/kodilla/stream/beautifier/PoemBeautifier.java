package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String textToEnrich,PoemDecorator PD)
    {
        return PD.decorate(textToEnrich);
    }
}
