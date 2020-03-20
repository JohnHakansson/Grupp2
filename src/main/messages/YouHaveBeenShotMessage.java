package main.messages;

import java.io.Serializable;

public class YouHaveBeenShotMessage implements Serializable {
    private String target;
    private String shooter;

    public YouHaveBeenShotMessage(String target, String shooter) {
        this.target = target;
        this.shooter = shooter;
    }

    public String getShooter() {
        return shooter;
    }

    public String getTarget() {
        return target;
    }
}
