package ccm.kx.cards;

/**
 * Tools to find Unicode symbols representing playing cards.
 * 
 * @author KX
 */
public final class UnicodeTools {

    private UnicodeTools() {
    }

    private final static char UNKNOWN = '\ufffd';

    /**
     * Miscellaneous symbol for a suit.<br>
     * Unicode U+2660–2667
     * 
     * @param suit
     * @param isWhite
     * @return white or red/black suit symbol
     */
    public static char getSuit(Suit suit, boolean isWhite) {
        if (suit == null)
            return UNKNOWN;
        if (isWhite) {
            switch (suit) {
            case SPADES:
                return '\u2664';
            case HEARTS:
                return '\u2661';
            case DIAMONDS:
                return '\u2662';
            case CLUBS:
                return '\u2667';
            }
        } else {
            switch (suit) {
            case SPADES:
                return '\u2660';
            case HEARTS:
                return '\u2665';
            case DIAMONDS:
                return '\u2666';
            case CLUBS:
                return '\u2663';
            }
        }
        return UNKNOWN;
    }

    /**
     * Playing card symbol for a card.<br>
     * Unicode U+1F0A0–1F0FF
     * 
     * @param value
     * @param suit
     * @return card symbol codePoint
     * @see Character#getName(int)
     */
    public static int getCard(Value value, Suit suit) {
        if (value == null || suit == null)
            return UNKNOWN;
        return 0x1F0A1 + 16 * suit.ordinal() + value.ordinal();
    }

    /**
     * Playing card symbol for a card<br>
     * Unicode U+1F0A0–1F0FF
     * 
     * @param card
     * @return card symbol codePoint
     * @see Character#getName(int)
     */
    public static int getCard(Card card) {
        if (card == null)
            return UNKNOWN;
        return getCard(card.getValue(), card.getSuit());
    }
}
