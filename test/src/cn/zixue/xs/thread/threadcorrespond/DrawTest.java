package cn.zixue.xs.thread.threadcorrespond;

public class DrawTest {
public static void main(String[] args) {
	//创建一个账号
	Account account=new Account("123456",0);
	new DrawThread("取钱者", account, 800).start();
	new DepositThread("存钱者甲", account, 800).start();
	new DepositThread("存钱者乙", account, 800).start();
	new DepositThread("存钱者丙", account, 800).start();
	
	
	
}
}
