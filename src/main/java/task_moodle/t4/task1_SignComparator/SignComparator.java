package task_moodle.t4.task1_SignComparator;
//**********@Checked***************//
public class SignComparator {

    public String compare(int number) {
        if (number > 0) {
            return "Number is positive";
        } else if (number < 0) {
            return "Number is negative";
        } else return "Number is equal zero";
    }
}
