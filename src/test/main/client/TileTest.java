package main.client;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    @Test
    public void removeSleepingCharacter() {
        Tile tile = new Tile("vik", true, true, false);
        Character ch = tile.getCharacter();
        tile.moveCharacterToSleeping();
        assertEquals(ch, tile.getSleepingCharacter());
        assertNull(tile.getCharacter());
        tile.removeSleepingCharacter();
        assertEquals(ch, tile.getCharacter());
        assertNull(tile.getSleepingCharacter());
    }

    @Test
    public void moveCharacterToSleeping() {
        Character ch = new Character("Vik", 1,2);
    }

    @Test
    public void removeCharacter() {
        Character ch = new Character("Vik", 1,2);

    }

    @Test
    public void treasureOn() {
    }

    @Test
    public void treasureOff() {
    }
}