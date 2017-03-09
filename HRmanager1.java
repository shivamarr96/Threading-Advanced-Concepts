/**Demo on CyclicBarrier
**/
import java.util.concurrent.CyclicBarrier;
public	class	HRmanager1 
{
	public static void main(String[] args)throws Exception {
	CyclicBarrier cb=new CyclicBarrier(3);
	TechLead t1=new TechLead("suresh",cb);
	TechLead t2=new TechLead("harish",cb);
	TechLead t3=new TechLead("manish",cb);
	t1.start();
	t2.start();
	t3.start();
	System.out.println("HRmanager1 exiting.");
	
	}
}
class TechLead extends Thread
{
	CyclicBarrier cb;
	TechLead(String s,CyclicBarrier cb)
	{
super(s);
this.cb=cb;
	}
@Override
public void run()
{
try
{
Thread.sleep(2000);

System.out.println(Thread.currentThread().getName()+" : recruiting");
cb.await();
System.out.println("all finished "+Thread.currentThread().getName()+"	distribute offer letter");
}
catch(Exception e){}
}
}