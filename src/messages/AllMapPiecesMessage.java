package messages;

import java.io.Serializable;

public class AllMapPiecesMessage implements Serializable {
    private String username;

    public AllMapPiecesMessage(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
