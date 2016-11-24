package forHbase;

public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread:" + Thread.currentThread().getName());
		Integer num = DySchedule.getLine();
		System.out.println("startLine = " + (num - 1000) + ", endline = " + num);
	}

}
