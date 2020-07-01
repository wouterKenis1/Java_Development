package be.intecbrussel.sellers;

public class Stock {
    private int iceRockets, cones, balls, magni;

    public Stock(){
        iceRockets = 0;
        cones = 0;
        balls = 0;
        magni = 0;
    }
    public Stock(int rocket, int cone, int ball, int magnum)
    {
        iceRockets = rocket;
        cones = cone;
        balls = ball;
        magni = magnum;
    }

    public int getIceRockets() {
        return iceRockets;
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public int getCones() {
        return cones;
    }

    public void setCones(int cones) {
        this.cones = cones;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getMagni() {
        return magni;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }
}
