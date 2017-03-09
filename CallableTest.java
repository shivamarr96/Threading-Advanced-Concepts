/**Demo on FixedThreadPool
**/
import java.util.*;
import java.util.concurrent.*;
class MyCallable1 implements Callable
{
	@Override
	public String call()throws Exception
	{
		System.out.println("Thread started at:"+new Date());
		Thread.sleep(5000);
		return (Thread.currentThread().getName());

	}
}
class CallableTest
{
	public static void main(String[] args) 
	{
		ExecutorService exec=Executors.newFixedThreadPool(5);
		ArrayList<Future<String>> al=new ArrayList<Future<String>>();
		for(int i=0;i<10;i++)
		{
		Future<String> future=exec.submit(new MyCallable());
		al.add(future);
		}
		try
		{
		for(Future<String> future:al)
		{
		System.out.println(future.get()+"::"+new Date());
		}
		}
		catch(InterruptedException|ExecutionException e)
		{
			e.printStackTrace();
		}
		exec.shutdown();
	}
}
