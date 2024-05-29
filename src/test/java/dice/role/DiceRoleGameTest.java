package dice.role;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DiceRoleGameTest
    extends TestCase
{

    @Test
    public void testPlayGameLessInput() {
        Integer[] sequence = {1, 1, 1, 1, 1, 1};
        try {
            DiceRoleGame.playGame(sequence);
        } catch (IllegalArgumentException e) {
            assertEquals("Input array cannot be less or more than 3 elements", e.getMessage());
        }
    }

    @Test
    public void testPlayGameHigherInput() {
        Integer[] sequence = {1, 1};
        try {
            DiceRoleGame.playGame(sequence);
        } catch (IllegalArgumentException e) {
            assertEquals("Input array cannot be less or more than 3 elements", e.getMessage());
        }
    }

    @Test
    public void testPlayGameNullInput() {
        Integer[] sequence = null;
        try {
            DiceRoleGame.playGame(sequence);
        } catch (IllegalArgumentException e) {
            assertEquals("Input array cannot be null", e.getMessage());
        }
    }
}
