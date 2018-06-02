package org.swarthon.androidpoker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.files.FileHandle;

class CardDesign {
    static CardDesign singleton = null;
    static CardDesign getSingleton() {
        if(singleton == null)
            singleton = new CardDesign();
        return singleton;
    }

    Pixmap cardMap;
    FileHandle dataFile = Gdx.files.internal("cards.png");

    public static final int CARD_WIDTH = 536;
    public static final int CARD_HEIGHT = 750;
    
    protected CardDesign() {
        if(dataFile.exists())
            cardMap = new Pixmap(dataFile);
        else
            System.exit(1);
    }
    public Pixmap getCardDesign(Card c) {
        Card.Color color = c.getColor();
        Card.Number number = c.getNumber();
        
        Pixmap pixmap = new Pixmap(CARD_WIDTH, CARD_HEIGHT, Format.RGBA8888);
        pixmap.drawPixmap(cardMap,
                          number.ordinal() * CARD_WIDTH,
                          color.ordinal() * CARD_HEIGHT,
                          CARD_WIDTH, CARD_HEIGHT,
                          0, 0,
                          CARD_WIDTH, CARD_HEIGHT);
        return pixmap;
    }
}
