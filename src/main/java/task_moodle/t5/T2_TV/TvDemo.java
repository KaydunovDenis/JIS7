package task_moodle.t5.T2_TV;

/**
 * @author Denis Kaydunov
 * Далее расписывать проверки и тесты не вижу необходимости.
 */
public class TvDemo {
    public static void main(String[] args) {
        Tv tv = new Tv(0, 0, "Acer", false);
        System.out.println(tv.isOn());
        System.out.println(tv.getCurrentChanel());
        tv.toSwithNext();
        System.out.println(tv.getCurrentChanel());
        tv.turnOn();
        tv.toSwithNext();
        System.out.println(tv.getCurrentChanel());
        System.out.println(tv.getManufacturer());
        System.out.println(tv);
        System.out.println(tv.getCurrentVolume());
    }
}
