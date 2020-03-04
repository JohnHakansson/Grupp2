package main.messages;

import java.io.Serializable;

public class ClientDisconnectMessage implements Serializable {
    private main.client.Character character;
    private String username;

    public ClientDisconnectMessage(main.client.Character character, String username) {
        this.character = character;
        this.username = username;
    }

    public main.client.Character getCharacter() {
        return character;
    }

    public String getUsername() {
        return username;
    }
}
