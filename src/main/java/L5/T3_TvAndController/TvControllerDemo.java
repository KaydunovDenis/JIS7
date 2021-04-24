package L5.T3_TvAndController;

public class TvControllerDemo {
    public static void main(String[] args) {
        Tv tv1 = new Tv(0, 1, "LG", false);
        TvController pult = new TvController();
        pult.setCurrentTv(tv1);
        pult.turnOn();
        pult.toSwithBack();
        pult.volumPlus();

        Tv tv2 = new Tv(10, 10, "LG+", false);
        pult.setCurrentTv(tv2);
        pult.volumMinus();
        pult.turnOn();
        pult.volumMinus();
        pult.turnOff();

        pult.setCurrentTv(tv1);
        pult.turnOff();

        tv1.turnOn();
        tv1.turnOff();
    }
}
