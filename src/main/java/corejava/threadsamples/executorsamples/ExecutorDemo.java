package corejava.threadsamples.executorsamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//https://www.baeldung.com/java-executor-service-tutorial
		
		Runnable runnableTask = () -> {
		    try {
		    	System.out.println("Runnable Task Start");
		        TimeUnit.MILLISECONDS.sleep(300);
		        System.out.println("Runnable Task End");
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		};

		Callable<String> callableTask = () -> {
			System.out.println("Callable Task Start");
		    TimeUnit.MILLISECONDS.sleep(300);
		    System.out.println("Callable Task End");
		    return "Task's execution";
		};
		/**
		 * We can assign tasks to the ExecutorService using several methods including execute(), 
		 * which is inherited from the Executor interface, 
		 * and also submit(), invokeAny() and invokeAll().
		 */
		executorService.execute(runnableTask);
		executorService.shutdown();
		
		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		
		try {
			List<Future<String>> futures = executorService.invokeAll(callableTasks);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
