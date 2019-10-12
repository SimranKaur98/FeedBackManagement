package model;


public class FeedBack {

int tId;
    int sId;
    int fb[] = new int[5];

    public FeedBack(int tId) {
        this.tId = tId;
    }

    public FeedBack(int tId, int sId) {
        this.tId = tId;
        this.sId = sId;
    }

    public int[] getFb() {
        return fb;
    }

    public void setFb(int[] fb) {
        this.fb = fb;
    }

    public FeedBack() {
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int[] getF() {
        return fb;
    }

    public void setF(int[] f) {
        this.fb = f;
    }

    
}
