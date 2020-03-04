package main.client;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    @Test
    public void passATurn() {
        Character ch = new Character("Viktor", 1,2);
        ch.shot();
        ch.passATurn();
        assertEquals(3, ch.sleeping());
    }

    @Test
    public void stealPieces() {
        Character ch = new Character("Vik", 1,2);
        ch.setPieces(2);
        assertEquals(2, ch.getPieces());
        ch.stealPieces();
        assertEquals(0, ch.getPieces());

    }


}