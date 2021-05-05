package by.jrr.start.service;

import by.jrr.start.exception.UserValidationException;
import by.jrr.start.model.User;
import org.apache.log4j.Logger;

/**
 * [] Минимальная длина имени / фамилии пользователя - 3 символа;
 * [] Максимальная длина имени / фамилии пользователя - 15 символов;
 * [] Допустимый возраст пользователя: от 0 до 120 лет включительно;
 * [] В случае, если данные не проходят одну из проверок, то необходимо выбросить
 * UserValidationException с причиной ошибки
 */
public class UserValidationService extends Throwable {
    private static final Logger logger = Logger.getLogger(UserValidationException.class);


    public void validate(User user) {
        try {
            if (user.getFirstName().length() < 3 || user.getLastName().length() < 3) {
                throw new UserValidationException("Name or Last name must be minimum 3 symbols.");
            }
            if (user.getFirstName().length() > 15 || user.getLastName().length() > 15) {
                throw new UserValidationException("Name or Last name must be maximum 15 symbols.");
            }
            if (user.getAge() < 0 || user.getAge() > 120) {
                throw new UserValidationException("User age is invalid. Age must be >0 and <120.");
            }
            logger.info(user + " is validate successful.");
        } catch (UserValidationException e) {
            logger.info(e.toString());
        }
    }
}
