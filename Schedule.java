import java.util.concurrent.*;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        // Step 1: Create a scheduled executor with a pool of 1 thread
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Step 2: Define a task
        Runnable task = () -> {
            System.out.println("Task executed at: " + java.time.LocalTime.now());
        };

        // Step 3: Schedule the task to run at fixed intervals
        // Initial delay: 2 seconds, Interval: 3 seconds
        scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);

        // Let the task run for some time (e.g., 12 seconds) and then shut down
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
        System.out.println("Scheduler shut down.");
    }
  }
