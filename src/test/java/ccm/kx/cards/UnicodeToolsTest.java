package ccm.kx.cards;

import org.junit.Assert;
import org.junit.Test;

/**
 * Check consistency of Unicode standards.
 * 
 * @author KX
 */
public class UnicodeToolsTest {

    @Test
    public void testGetSuit() {
        for (boolean isWhite : new boolean[] { true, false }) {
            for (Suit suit : Suit.values()) {
                String msg = suit + "+" + isWhite;
                char c = UnicodeTools.getSuit(suit, isWhite);
                String name = Character.getName(c);
                String[] parts = name.split(" ");
                Assert.assertEquals(msg, isWhite ? "WHITE" : "BLACK", parts[0]);
                Assert.assertEquals(msg, suit.toString(), parts[1] + "S");
                Assert.assertEquals(msg, "SUIT", parts[2]);
            }
        }
    }

    @Test
    public void testGetCard() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                String msg = suit + "+" + value;
                int codePoint = UnicodeTools.getCard(value, suit);
                Assert.assertEquals(msg, codePoint, UnicodeTools.getCard(new Card(value, suit)));
                if (value == Value.JOKER)
                    continue;
                String name = Character.getName(codePoint);
                String[] parts = name.split(" ");
                Assert.assertEquals(msg, "PLAYING", parts[0]);
                Assert.assertEquals(msg, "CARD", parts[1]);
                Assert.assertEquals(msg, value.toString(), parts[2]);
                Assert.assertEquals(msg, "OF", parts[3]);
                Assert.assertEquals(msg, suit.toString(), parts[4]);
            }
        }
        Assert.assertEquals("PLAYING CARD BLACK JOKER", Character.getName(UnicodeTools.getCard(Card.BLACK_JOKER)));
        Assert.assertEquals("PLAYING CARD WHITE JOKER", Character.getName(UnicodeTools.getCard(Card.WHITE_JOKER)));
    }

    @Test
    public void testGetNull() {
        Assert.assertEquals("REPLACEMENT CHARACTER", Character.getName(UnicodeTools.getSuit(null, true)));
        Assert.assertEquals("REPLACEMENT CHARACTER", Character.getName(UnicodeTools.getSuit(null, false)));
        Assert.assertEquals("REPLACEMENT CHARACTER", Character.getName(UnicodeTools.getCard(null)));
        Assert.assertEquals("REPLACEMENT CHARACTER", Character.getName(UnicodeTools.getCard(null, null)));
        Assert.assertEquals("REPLACEMENT CHARACTER", Character.getName(UnicodeTools.getCard(Value.ACE, null)));
        Assert.assertEquals("REPLACEMENT CHARACTER", Character.getName(UnicodeTools.getCard(null, Suit.SPADES)));
    }

    @Test
    public void testToString() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                String msg = suit + "+" + value;
                Card card = new Card(value, suit);
                String name = Character.getName(UnicodeTools.getCard(card));
                if (name != null)
                    Assert.assertEquals(msg, name, "PLAYING CARD " + card.toString());
            }
        }
    }
}
