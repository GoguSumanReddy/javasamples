package Tasks;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FirstConcurrency {

	public static void main(String args[]) {
		
		Callable<String> task1=new Callable<String>() {

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return "Task1 is complted";
			}
			
		};
		
		ExecutorService es=Executors.newSingleThreadExecutor();
		Future<String> future =es.submit(task1);
		
		if(future.isDone()) {
			try {
				System.out.println(future.get());
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
