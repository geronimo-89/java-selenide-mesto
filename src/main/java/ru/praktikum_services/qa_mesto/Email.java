package ru.praktikum_services.qa_mesto;

import java.util.Random;
import java.util.UUID;

public class Email {

    public static String generateEmail() {
        Random random = new Random();
        int n = random.nextInt(999999999);
        return "testusername" + n + "@yandex.ru";
    }

    public static String generateRandomEmail() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "") + "@yandex.ru";
    }

}
