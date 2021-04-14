package L5.T3_TvAndController;

public class TvController {
    private Tv currentTv;



    public void toSwithNext() {
        if (currentTv.isOn()) currentTv.toSwithNext();
    }

    public void toSwithBack() {
        if (currentTv.isOn()) currentTv.toSwithBack();
    }

    public void volumPlus() {
        if (currentTv.isOn()) currentTv.volumPlus();
    }

    public void volumMinus() {
        if (currentTv.isOn()) currentTv.volumMinus();
    }

    public void turnOn() {
        currentTv.turnOn();
    }

    public void turnOff() {
        currentTv.turnOff();
    }

    public void setCurrentTv(Tv currentTv) {
        this.currentTv = currentTv;
    }
}
