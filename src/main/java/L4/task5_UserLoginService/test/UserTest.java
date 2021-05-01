package L4.task5_UserLoginService.test;

import L4.task5_UserLoginService.src.User;

//**********@Checked***************//
public class UserTest {
    public static void main(String[] args) {
        User user = new User("Den", "qwerty");
        System.out.println(user);
        user.blockUser();
        System.out.println(user);
    }
}
//**********@Названия классов заканчивающиеся на test должны быть в package test и
// предназначены для тестирования работы методов и сервиса в целом.
//Твой же класс представляет класс точки входа в программу из за метода main********//
//такие классы нужно называть UserApp и в приложении должен быть один метод main

//*****@answer******
//Исправлю это в другой ветке