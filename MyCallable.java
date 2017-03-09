/**Demo on FixedThreadPool
**/
import java.util.*;
import java.util.concurrent.*;
public class MyCallable implements Callable<String>
{
	@Override
	public String call()throws Exception
	{
		System.out.println("Thread started at:"+new Date());
		Thread.sleep(5000);
		return (Thread.currentThread().getName());

	}
	public static void main(String[] args) 
	{
		ExecutorService exec=Executors.newFixedThreadPool(1);
		Callable<String> cc=new MyCallable();
		Future<String> future=exec.submit(cc);
		System.out.println("After");
		
		try
		{System.out.println(future.get()+"::"+new Date());

		}
		catch(InterruptedException|ExecutionException e)
		{
			e.printStackTrace();
		}
		exec.shutdown();
	}
}
