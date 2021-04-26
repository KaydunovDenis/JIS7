package L3.task4_Encoder;
//**********@Checked***************//
public class EncoderDemo {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        char symbol = 'A';
        short number = 129;

        System.out.println("symbol = " + symbol);
        System.out.println("number = " + number);
        encoder.decode(symbol);
        encoder.encode(number);
    }
}
