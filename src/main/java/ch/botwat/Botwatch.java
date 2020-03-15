package ch.botwat;

import ch.botwat.api.*;
import ch.botwat.data.BotClient;
import ch.botwat.data.OldSchoolAccount;
import ch.botwat.data.Session;
import ch.botwat.data.User;
import com.sun.javafx.applet.ExperimentalExtensions;

import java.io.IOException;
import java.util.Random;

public class Botwatch {

    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            User me = Users.create("MyTest22", "MyTest2@google.com", "MyTest123");

            BotClient client = Clients.create("MYTestClient22", "Tests shit", "test.com", "swipe,qosmiof2");

            OldSchoolAccount acc1 = Accounts.create("TestAccount122");
            OldSchoolAccount acc2 = Accounts.create("TestAccount222");

            Session s1 = Sessions.create(client.name, acc1.alias);
            Session s2 = Sessions.create(client.name, acc2.alias);

            System.out.println(s1.id + " " + s2.id);

            Random random = new Random();
            while (true) {
                switch (random.nextInt(30)) {
                    case 0:
                        Interactions.create(69, 69, 69, 69, 69, 69, 69, 69, s1.id);
                        System.out.println("interaction - s1");
                        break;
                    case 1:
                        Interactions.create(69, 69, 69, 69, 69, 69, 69, 69, s2.id);
                        System.out.println("interaction - s2");
                        break;
                    case 2:
                        s1 = Sessions.create(client.name, acc1.alias);
                        System.out.println("session 1 redone");
                        break;
                    case 3:
                        s2 = Sessions.create(client.name, acc2.alias);
                        System.out.println("session 2 redone");
                        break;
                    case 4:
                        Experiences.create(random.nextInt(20), random.nextInt(100), s1.id);
                        System.out.println("exp - s1");
                        break;
                    case 5:
                        Experiences.create(random.nextInt(20), random.nextInt(100), s2.id);
                        System.out.println("exp - s2");
                        break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
