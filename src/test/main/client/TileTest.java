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
        Tile tile = new Tile("vik", true, true, false);
        Character ch = new Character("Viktor", 1, 1);
        tile.setCharacter(ch);
        assertEquals(ch, tile.getCharacter());
        tile.moveCharacterToSleeping();
        assertEquals(ch, tile.getSleepingCharacter());
        assertNull(tile.getCharacter());
    }

    @Test
    public void removeCharacter() {
        Tile tile = new Tile("vik", true, true, false);
        Character ch = new Character("Viktor", 1, 1);
        tile.setCharacter(ch);
        assertEquals(ch, tile.getCharacter());
        tile.removeCharacter();
        assertNull(tile.getCharacter());
    }

    //TDD kallar på moveCharacterToSleeping 2 gånger irad så character redan är null andra anropet
    @Test
    public void moveCharaterToSleeping2(){
        Tile tile = new Tile("vik", true, true, false);
        Character ch1 = new Character("Viktor", 1,1 );
        tile.setCharacter(ch1);
        assertEquals(ch1, tile.getCharacter());
        tile.moveCharacterToSleeping();
        assertNull(tile.getCharacter());
        assertEquals(ch1, tile.getSleepingCharacter());
        tile.moveCharacterToSleeping();
        assertNull(tile.getCharacter());
        assertEquals(ch1, tile.getSleepingCharacter());

    }
}