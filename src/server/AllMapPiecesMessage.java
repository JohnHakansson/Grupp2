package server;

import java.io.Serializable;

public class AllMapPiecesMessage implements Serializable {
    private client.Character character;
    private String username;

    public AllMapPiecesMessage(client.Character character, String username) {
        this.character = character;
        this.username = username;
    }

    public client.Character getCharacter() {
        return character;
    }

    public String getUsername() {
        return username;
    }
}
