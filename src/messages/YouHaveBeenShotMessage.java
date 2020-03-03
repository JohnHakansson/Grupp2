package messages;

public class YouHaveBeenShotMessage {
    private String thePlayerBeingShot;
    private String shooter;

    public YouHaveBeenShotMessage(String shooter, String thePlayerBeingShot) {
           this.shooter = shooter;
           this.thePlayerBeingShot = thePlayerBeingShot;
    }

    public String getThePlayerBeingShot() {
        return thePlayerBeingShot;
    }

    public String getShooter() {
        return shooter;
    }
}
