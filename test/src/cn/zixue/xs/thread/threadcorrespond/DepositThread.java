package cn.zixue.xs.thread.threadcorrespond;

public class DepositThread extends Thread {
	//模拟用户账号
		private final Account account;
		//当前线程希望的存钱数
		private final double depositAmount;

		
		public DepositThread(String name,Account account, double depositAmount) {
			super(name);
			this.account = account;
			this.depositAmount = depositAmount;
		}

		//重复执行100次存钱操作
		@Override
		public void run() {
			for (int i = 0; i <200; i++) {
				account.deposit(depositAmount);
			}
			
		}
}
