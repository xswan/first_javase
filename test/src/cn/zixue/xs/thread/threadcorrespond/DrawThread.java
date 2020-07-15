package cn.zixue.xs.thread.threadcorrespond;

public class DrawThread extends Thread{
	//模拟用户账号
	private final Account account;
	//当前线程希望的取钱数
	private final double drawAmount;

	
	public DrawThread(String name,Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	//重复执行100次取钱操作
	@Override
	public void run() {
		for (int i = 0; i <100; i++) {
			account.draw(drawAmount);
		}
		
	}
}
