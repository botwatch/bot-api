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
            int times = 0;
            User me = Users.create("testacc", "testacc@google.com", "MyTest123");

            BotClient client = Clients.create("test", "Tests shit", "test.com", "swipe,qosmiof2");

            OldSchoolAccount acc1 = Accounts.create("testacc");
            OldSchoolAccount acc2 = Accounts.create("testacc2");

            Session s1 = Sessions.create(client.name, acc1.alias);
            Session s2 = Sessions.create(client.name, acc2.alias);

            System.out.println(s1.id + " " + s2.id);

            Random random = new Random();
            while (true) {
                switch (random.nextInt(30)) {
                    case 0:
                        Interactions.create(random.nextInt(600), random.nextInt(600),
                                random.nextInt(600), random.nextInt(600), random.nextInt(600),
                                random.nextInt(600), random.nextInt(600), random.nextInt(600),
                                random.nextInt(5000), random.nextInt(5000), s1.id);
                        System.out.println("interaction - s1");
                        break;
                    case 1:
                        Interactions.create(random.nextInt(600), random.nextInt(600),
                                random.nextInt(600), random.nextInt(600), random.nextInt(600),
                                random.nextInt(600), random.nextInt(600), random.nextInt(600),
                                random.nextInt(5000), random.nextInt(5000), s2.id);
                        System.out.println("interaction - s2");
                        break;
                    case 2:
                        if (times > 1200) {
                            s1 = Sessions.create(client.name, acc1.alias);
                            System.out.println("session 1 redone");
                            times = 0;
                        }
                        break;
                    case 3:
                        if (times > 1200) {
                            s2 = Sessions.create(client.name, acc2.alias);
                            System.out.println("session 2 redone");
                            times = 0;
                        }
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
                    times++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
