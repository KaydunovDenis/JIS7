package L5.T2_TV;

import java.util.Objects;

/**
 * -Текущий канал
 * -Текущая громкость
 * -Производитель
 * -Включен ли телевизор
 * Для каждого из полей написать вспомогательные методы
 * getter (напр. int getCurrentChannel()).
 * Необходимо переопределить методы equals() и toString().
 * Продемонстрировать работу всех методов, включая переопределенные в
 * демонстрационном классе TvDemo.
 * Написать тестовые сценарии для класса Tv в классе TvTest.
 */
public class Tv {
    private int currentChanel;
    private int currentVolume;
    private String manufacturer;
    private boolean isOn;

    public Tv(int currentChanel, int currentVolume, String manufacturer, boolean isOn) {
        this.currentChanel = currentChanel;
        this.currentVolume = currentVolume;
        this.manufacturer = manufacturer;
        this.isOn = isOn;
    }

    /**
     * * Методы:
     * * +Переключить на следующий канал (увеличить текущий канал на 1 ед.)
     * * +Переключить на предыдущий канал (уменьшить текущий канал на 1 ед.)
     * * +Увеличить звук (увеличить громкость на 1 ед.)
     * * +Уменьшить звук (уменьшить громкость на 1 ед.)
     * * +Включить телевизор
     * * +Выключить телевизор
     * * :Переключать каналы и менять громкость можно только у включенного телевизора.
     */
    public void toSwithNext() {
        if (isOn) {
            currentChanel++;
        }
    }

    public void toSwithBack() {
        if (isOn){ currentChanel--;}
    }

    public void volumePlus() {
        if (isOn) {
            currentVolume++;
        }
    }

    public void volumeMinus() {
        if (isOn) {
            currentVolume--;
        }
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public int getCurrentChanel() {
        return currentChanel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tv tv = (Tv) o;
        return currentChanel == tv.currentChanel && currentVolume == tv.currentVolume && isOn == tv.isOn && manufacturer.equals(tv.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentChanel, currentVolume, manufacturer, isOn);
    }

    @Override
    public String toString() {
        return "Tv{" +
                "currentChanel=" + currentChanel +
                ", currentVolume=" + currentVolume +
                ", manufacturer='" + manufacturer + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
