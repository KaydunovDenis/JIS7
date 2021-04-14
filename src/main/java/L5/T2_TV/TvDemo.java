package L5.T2_TV;

/**
 * @author Denis
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
    }
}
