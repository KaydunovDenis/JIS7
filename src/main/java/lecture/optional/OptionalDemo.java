import java.util.Optional;

/**
 * https://www.youtube.com/watch?v=fbEnhHjEX3M - урок об Optional
 */
public class OptionalDemo {
    public static void main(String[] args) {

        Optional<Object> empty = Optional.empty();//CTRL+ALT+V -- создание ссылки
        System.out.println(empty);

        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional);

        System.out.println(optional.isPresent());

        String orElse = optional.orElse("World");
        System.out.println(orElse);

        //1 - if not null
        soutOptional(optional);

        //2 - if null
        optional = Optional.ofNullable(null);
        soutOptional(optional);

        //3 - if null then throw
//        soutOptionalOrThrow(optional);

        Optional<String> optionalNull = Optional.ofNullable("not null");
        optionalNull.ifPresent(System.out::println);

        optionalNull = Optional.ofNullable(null);
        optionalNull.ifPresent(System.out::println);//не отрабатывает так как содержит null

        optionalNull = Optional.ofNullable("Hello");
        //optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("Data is null"));

        Person person = new Person("Sergey", null);
        var message = person
                .getEmail()
                .map(String::toLowerCase)
                .orElse(person.name + " dont have the email.");
        System.out.println(message);
    }

    private static void soutOptional(Optional<String> optional) {
        String data_is_null = optional
                .map(String::toUpperCase)
                .orElse("Data is null");
        System.out.println(data_is_null);
    }

    private static void soutOptionalOrThrow(Optional<String> optional) {
        String data_is_null = optional
                .map(String::toUpperCase)
                .orElseThrow(IllegalArgumentException::new);
        System.out.println(data_is_null);
    }

}
