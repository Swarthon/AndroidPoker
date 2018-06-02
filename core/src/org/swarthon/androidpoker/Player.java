package org.swarthon.androidpoker;

class Player {
    int money;
    Card cards[];

    Player(Card one, Card two, int money) {
        cards = new Card[2];
        cards[0] = one;
        cards[1] = two;
    }

    public Card[] getCards() {
        return cards;
    }
}
