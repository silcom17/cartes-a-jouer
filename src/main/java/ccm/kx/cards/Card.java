package ccm.kx.cards;

import java.awt.Image;
import java.io.Serializable;

/**
 * Playing card with French suits.
 * 
 * @author KX
 */
public class Card implements Serializable {

    private static final long serialVersionUID = -1016030140274078139L;

    /**
     * Black joker, build as Joker of diamonds to match Unicode 6.0 standard U+1F0CF.
     * 
     * @see UnicodeTools#getCard(Card)
     */
    public final static Card BLACK_JOKER = new Card(Value.JOKER, Suit.DIAMONDS);

    /**
     * White joker, build as Joker of clubs to match Unicode 6.0 standard U+1F0DF.
     * 
     * @see UnicodeTools#getCard(Card)
     */
    public final static Card WHITE_JOKER = new Card(Value.JOKER, Suit.CLUBS);

    /**
     * Red joker, build as Joker of hearts to match Unicode 7.0 standard U+1F0BF.
     * 
     * @see UnicodeTools#getCard(Card)
     */
    public final static Card RED_JOKER = new Card(Value.JOKER, Suit.HEARTS);

    /**
     * Blue joker, build as Joker of spades to match <b>not</b> Unicode standard U+1F0AF.
     * 
     * @see UnicodeTools#getCard(Card)
     */
    public final static Card BLUE_JOKER = new Card(Value.JOKER, Suit.SPADES);

    private final Value value;
    private final Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Image getImage() {
        return ImageLoader.getCard(value, suit);
    }

    @Override
    public String toString() {
        if (value != Value.JOKER)
            return value + " OF " + suit;
        switch (suit) {
        case SPADES:
            return "BLUE JOKER";
        case HEARTS:
            return "RED JOKER";
        case DIAMONDS:
            return "BLACK JOKER";
        case CLUBS:
            return "WHITE JOKER";
        }
        return null; // not reached
    }

    @Override
    public int hashCode() {
        return (value == null ? 0 : value.hashCode()) + 31 * ((suit == null ? 0 : suit.hashCode()) + 31);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != Card.class)
            return false;
        Card card = (Card) obj;
        if (card.value != value)
            return false;
        if (card.suit != suit)
            return false;
        return true;
    }
}
