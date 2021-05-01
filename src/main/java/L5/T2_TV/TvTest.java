package L5.T2_TV;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TvTest {
    Tv tv = new Tv(0,0, "Horizonte", false);

    @Test
    void toSwitchBack() {
        Assert.assertEquals(0, tv.getCurrentChanel());
        tv.toSwithBack();
        Assert.assertNotEquals(-1, tv.getCurrentChanel());

        tv.turnOn();
        tv.toSwithBack();
        Assert.assertEquals(-1, tv.getCurrentChanel());
    }
}
