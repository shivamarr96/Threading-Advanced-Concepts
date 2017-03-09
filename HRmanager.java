/**Demo on CountDownLatch
**/
import java.util.concurrent.CountDownLatch;
public	class	HRmanager 
{
	public static void main(String[] args)throws Exception {
	CountDownLatch cdl=new CountDownLatch(3);
	TechLead t1=new TechLead("suresh",cdl);
	TechLead t2=new TechLead("harish",cdl);
	TechLead t3=new TechLead("manish",cdl);
	t1.start();
	t2.start();
	t3.start();
	System.out.println("Awaiting for interview to get over");
	cdl.await();
	System.out.println("Distribute offer letter");
	
	}
}
class TechLead extends Thread
{
	CountDownLatch cdl;
	TechLead(String s,CountDownLatch cdl)
	{
super(s);
this.cdl=cdl;
	}
@Override
public void run()
{
try
{
Thread.sleep(2000);
}
catch(Exception e){}
System.out.println(Thread.currentThread().getName()+" : recruiting");
cdl.countDown();
try
{
Thread.sleep(3000);
}
catch(Exception e){}
System.out.println(Thread.currentThread().getName()+" : dead");

}
}