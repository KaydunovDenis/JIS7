package service;

import exception.UserValidationException;
import model.User;

import java.util.logging.Logger;

/**
 * [] Минимальная длина имени / фамилии пользователя - 3 символа;
 * [] Максимальная длина имени / фамилии пользователя - 15 символов;
 * [] Допустимый возраст пользователя: от 0 до 120 лет включительно;
 * [] В случае, если данные не проходят одну из проверок, то необходимо выбросить
 * UserValidationException с причиной ошибки
 */
public class UserValidationService {
    private static final Logger LOG = Logger.getGlobal();
    private static final int MIN_POSSIBLE_SYMBOLS_NAME = 3;
    private static final int MAX_POSSIBLE_SYMBOLS_NAME = 15;
    private static final int MIN_POSSIBLE_AGE = 0;
    private static final int MAX_POSSIBLE_AGE = 120;

    public void validateAll(User user) {
        validateLengthOfName(user.getFirstName());
        validateLengthOfName(user.getLastName());
        validateUserAge(user);
        LOG.info(user + " is validate successful.");
    }

    private void validateUserAge(User user) {
        if (user.getAge() < MIN_POSSIBLE_AGE || user.getAge() > MAX_POSSIBLE_AGE) {
            throw new UserValidationException("User age is invalid. Age must be >0 and <120.");
        }
    }

    private void validateLengthOfName(String name) {
        if (name.length() < MIN_POSSIBLE_SYMBOLS_NAME) {
            throw new UserValidationException("Name must be minimum " + MIN_POSSIBLE_SYMBOLS_NAME + " symbols.");
        }
        if (name.length() > MAX_POSSIBLE_SYMBOLS_NAME) {
            throw new UserValidationException("Name must be maximum " + MAX_POSSIBLE_SYMBOLS_NAME + " symbols.");
        }
    }
}
