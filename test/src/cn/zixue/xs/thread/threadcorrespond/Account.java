package cn.zixue.xs.thread.threadcorrespond;

public class Account {
	//封装账号编号，账号余额的成员变量
	private String accountNo;
	private double balance;
	//标识账号中是否已经有存款的旗帜
	private boolean flag=false;
	
	//记录第多少次存钱
	private int depositCount=0;
	//记录第多少次取钱
	private int drawCount=0;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	//因为账号余额不能随意修改，所以只提供getter方法
	public double getBalance() {
		return balance;
	}
	
	public synchronized void draw(double drawAmount) {
		
		try {
			//如果flag为假，表示账号还没人存钱，取钱方法阻塞
			if(!flag) {
				this.wait();
			}else {
				//执行取钱操作
				drawCount++;
				System.out.println(Thread.currentThread().getName()+"取钱："+drawAmount+"取钱次数"+drawCount);
				balance-=drawAmount;
				System.out.println("账号余额为："+balance);
				//将标识账号是否有存款的旗帜设为false
				flag=false;
				//唤醒其他线程
				notifyAll();
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount) {
		
		try {
			//如果flag为真，表示账号已经有人存钱进去，存钱方法阻塞
			if(flag) {
				this.wait();
			}else {
				//执行存钱操作
				depositCount++;
				System.out.println(Thread.currentThread().getName()+"存钱："+depositAmount+"存钱次数"+depositCount);
				balance+=depositAmount;
				System.out.println("账号余额为："+balance);
				//将标识账号是否有存款的旗帜设为true
				flag=true;
				//唤醒其他线程
				notifyAll();
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (flag ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (flag != other.flag)
			return false;
		return true;
	}
	

	
}
