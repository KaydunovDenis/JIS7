package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.Person;
import com.github.kaydunovDenis.model.Product;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Рефлексия - это механизм обращения к данным программы во время её выполнения.
 */
public class ReflectionDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//        Product product = new Product();// приватный, нельзя создать объект
//        однако рефлексия позволяет нам это сделать

       //способы создания объекта
        Person person = new Person();
        //1 по объекту
        Class<? extends Person> getClassForPeron = person.getClass();
        //2 по классу
        Class<Person> personClass = Person.class;
        //3 по пути к классу
        try {
            Class<?> classForPerson = Class.forName("com.github.kaydunovDenis.model.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(getClassForPeron.getName());


        Class<Product> productClass = Product.class;
        String productClassName = productClass.getName();
        String productClassSimpleName = productClass.getSimpleName();
        Field[] fields = productClass.getFields();
        Field[] declaredFields = productClass.getDeclaredFields();
        Method[] methods = productClass.getMethods();
        Method[] declaredMethod = productClass.getDeclaredMethods();
        Constructor<?>[] declaredConstructors = productClass.getDeclaredConstructors();//получаем список конуструкторов

        System.out.printf("className = %s,\nsimpleClassName = %s,\nfields = %s,\ndeclaredFields = %s\n\n",
                productClassName, productClassSimpleName, Arrays.toString(fields), Arrays.toString(declaredFields));
        System.out.println("Methods:");
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println("DeclaredMethods:");
        Arrays.stream(declaredMethod).forEach(System.out::println);
        System.out.println("Annotations:");
        Arrays.stream(productClass.getAnnotations()).forEach(System.out::println);
        System.out.println("Declared constructors:");
        Arrays.stream(declaredConstructors).forEach(System.out::println);

        Constructor<Product> declaredConstructor = productClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Product product = declaredConstructor.newInstance();//create private product
        System.out.println(product);

        Field field = product.getClass().getField(declaredFields[0].getName());
        field.set(product, "Exclusive name");//записываем значение в приватное поле
        System.out.println(product);
        System.out.println(field.get(product));

        System.out.println(declaredMethod[8]);// вызываем один из методов из общего списка методов класса.

    }
}

