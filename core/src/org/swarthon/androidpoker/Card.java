package org.swarthon.androidpoker;

class Card {
    enum Color {
        Club, Heart, Spade, Diamond
    };
    enum Number {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    };

    Color color;
    Number number;

    Card(Color c, Number n) {
        color = c;
        number = n;
    }
    Color getColor() {
        return color;
    }
    Number getNumber() {
        return number;
    }
}
