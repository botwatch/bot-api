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
            //login if account already exists
            if(me == null) me = Users.authenticate("testacc","MyTest123");
            BotClient client = Clients.create("testxD123", "Tests shit", "test43.com", "swipe,qosmiof2");
            if(client == null){
                client = new BotClient();
                client.name = "testxD123";
            }

            OldSchoolAccount acc1 = Accounts.create("abc");
            if(acc1 == null){
                acc1 = new OldSchoolAccount();
                acc1.alias = "abc";
            }
            OldSchoolAccount acc2 = Accounts.create("efg");
            if(acc2 == null){
                acc2 = new OldSchoolAccount();
                acc2.alias = "efg";
            }

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
                        Experiences.create(random.nextInt(2000), random.nextInt(3000), s1.id);
                        System.out.println("exp - s1");
                        break;
                    case 5:
                        Experiences.create(random.nextInt(2000), random.nextInt(3000), s2.id);
                        System.out.println("exp - s2");
                        break;
                }
                try {
                    Thread.sleep(100);
                    times++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
