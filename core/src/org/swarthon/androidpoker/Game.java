package org.swarthon.androidpoker;

import java.util.Vector;
import java.util.Random;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

class Game {
    Player[] players;
    Card[] center;
    Vector<Card> deck = new Vector();

    Game(int numPlayers, int money) {
        for(Card.Color c : Card.Color.values())
            for(Card.Number n : Card.Number.values())
                deck.add(new Card(c,n));
        shuffle(deck);

        players = new Player[numPlayers];
        for(Player p : players)
            p = new Player(draw(), draw(), money);
    }

    Vector<Card> getDeck() {
        return deck;
    }
    Card draw() {
        return deck.remove(0); 
    }

    Player[] getPlayers() {
        return players;
    }

    public static <T> void shuffle(Vector<T> vec) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = vec.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Collections.swap(vec,index,i);
        }
    }
}
