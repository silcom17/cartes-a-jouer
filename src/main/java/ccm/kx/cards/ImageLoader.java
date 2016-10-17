package ccm.kx.cards;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.EnumMap;
import java.util.Map;

/**
 * Tools to find provided images.
 * 
 * @author KX
 */
public final class ImageLoader {

    private ImageLoader() {
    }

    private final static Map<Suit, Map<Value, Image>> cardsCache;
    static {
        cardsCache = new EnumMap<Suit, Map<Value, Image>>(Suit.class);
        for (Suit suit : Suit.values())
            cardsCache.put(suit, new EnumMap<Value, Image>(Value.class));
    }

    public static Image getCard(Card card) {
        if (card == null)
            return null;
        return getCard(card.getValue(), card.getSuit());
    }

    public static Image getCard(Value value, Suit suit) {
        if (value == null || suit == null)
            return null;
        Image img = cardsCache.get(suit).get(value);
        if (img == null) {
            img = loadImage(value, suit);
            cardsCache.get(suit).put(value, img);
        }
        return img;
    }

    private static Image loadImage(Value value, Suit suit) {
        String fileName = "/cards/" + String.valueOf(new Card(value, suit)).toLowerCase() + ".png";
        return Toolkit.getDefaultToolkit().getImage(ImageLoader.class.getResource(fileName));
    }
}
