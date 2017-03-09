class Shared
{
	int data=0;
	int flag=0;
	synchronized void submit(int i)
	{
		while(flag==1)
		{
			try{wait();}catch(Exception e){}
			
			}
		data=i;
		System.out.println("Producer put : "+i);
		flag=1;
		notifyAll();
		
		}
	synchronized int withdraw()
	{
		while(flag==0)
		{
			try{wait();}catch(Exception e){}
			
		}
		flag=0;
		System.out.println("Consumer got : "+data);
		notifyAll();
		return data;
}
}
class RunSync
{
	public static void main(String[] args) 
	{
	Shared st=new Shared();
	Producer p=new Producer(st,"one");
	Consumer c=new Consumer(st,"two");
	p.start();
	c.start();
}
}
class Consumer extends Thread
{
	Shared st;
	Consumer(Shared st,String name)
	{
		super(name);
		this.st=st;
		
	}
	@Override
	public void run()
	{	
		int value=0;
for(int i=1;i<=10;i++)
{	
	value=st.withdraw();
	//System.out.println("Consumer got : "+value);
	}
}
}
class Producer extends Thread
{
Shared st;
Producer(Shared st,String name)
{
	super(name);
	this.st=st;
	
}
@Override
public void run()
{
	for(int i=1;i<=10;i++)
	{
		st.submit(i);
		//System.out.println("Producer put : "+i);
		try{Thread.sleep(1000);}catch(Exception e){}
	}
}
}	