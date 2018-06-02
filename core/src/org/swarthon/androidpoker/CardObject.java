package org.swarthon.androidpoker;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

class CardObject extends Image {
    Card card;
    
    CardObject(Card c) {
        super(createSkin(c), "badlogic");
        setSize(CardDesign.CARD_WIDTH/2, CardDesign.CARD_HEIGHT/2);
        addListener(new DragListener() {
                public void drag(InputEvent event, float x, float y, int pointer) {
                    moveBy(x - getWidth() / 2, y - getHeight() / 2);
                }
            });
        card = c;
    }

    protected static Skin createSkin(Card c) {
        final Skin skin = new Skin();
        final Pixmap pixmap = CardDesign.getSingleton().getCardDesign(c);
        skin.add("badlogic", new Texture(pixmap));
        pixmap.dispose();
        return skin;
    }
}
