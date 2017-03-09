/**Demo on Semaphore
**/
import java.util.concurrent.Semaphore;
public	class	HRmanager2 
{
	public static void main(String[] args)throws Exception 
	{
	Semaphore questionpaperPool=new Semaphore(2);
	TechLead t1=new TechLead("suresh",questionpaperPool);
	TechLead t2=new TechLead("harish",questionpaperPool);
	TechLead t3=new TechLead("manish",questionpaperPool);
	TechLead t4=new TechLead("lalu",questionpaperPool);
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	System.out.println("No	work for hr manager");
	
	}
}
class TechLead extends Thread
{
	Semaphore questionpaperPool;
	TechLead(String s,Semaphore questionpaperPool)
	{
super(s);
this.questionpaperPool=questionpaperPool;
	}
@Override
public void run()
{
try
{
System.out.println(Thread.currentThread().getName()+" : waiting");	
questionpaperPool.acquire();
System.out.println(Thread.currentThread().getName()+" : question ppr acquired");	
System.out.println(Thread.currentThread().getName()+" : completing it");	
Thread.sleep(2000);
System.out.println(Thread.currentThread().getName()+" : giving back");
questionpaperPool.release();	

}
catch(Exception e){e.printStackTrace();}

}
}