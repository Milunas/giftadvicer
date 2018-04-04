package milunas.giftadvicer.multithread;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class MyExecuter {

    List<Callable<String>> task = new ArrayList();

    public void add(Socket client){
        task.add(() -> {
            System.out.println("Task");
            return "Task' execution";
        });
    }

}
