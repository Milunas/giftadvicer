package milunas.giftadvicer.multithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyRun {

    ExecutorService service = Executors.newFixedThreadPool(10);


    Callable<String> callableTask = () -> {
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("Task");
        return "Task' execution";
    };
    Callable<String> longTask = () -> {
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println("Very long operation");
        return "Task' execution";
    };

        /*MyRun runner = new MyRun();
        List<Callable<String>> tasks = new ArrayList();
       tasks.add(runner.longTask);
       tasks.add(runner.callableTask);
       tasks.add(runner.callableTask);
       tasks.add(runner.longTask);
       //runner.service.execute(runner);
       runner.service.invokeAll(tasks);*/

        //Future<String> futureString = runner.service.submit(runner.callableTask);
       //System.out.println(futureString.get());

}
