package main.messages;

public class YouHaveBeenShotMessage {
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
