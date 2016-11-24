package forHbase;

//Over 1 million or 100 millions update operations will be tricky
//100,000 records ，100,000/1000 = 100 threadss
//The program is to use 100 threads to process, and each thread to take care of 1000 records
//which the data cannot be overlapped. 


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class DySchedule {
	private static AtomicInteger line = new AtomicInteger(0);
	static ExecutorService pool = Executors.newFixedThreadPool(100);
	
	public static int getLine() {
		return line.addAndGet(1000);
	}
	public static void doJobs() {
		for (int i = 0; i < 100; i++) {
			Thread thread = new MyThread();
			pool.execute(thread);
		}
		pool.shutdown();
	}

	public static void main(String[] args) {
		DySchedule.doJobs();

	}

}

/*Thread:pool-1-thread-2
Thread:pool-1-thread-3
Thread:pool-1-thread-1
Thread:pool-1-thread-4
startLine = 1000, endline = 2000
startLine = 2000, endline = 3000
startLine = 0, endline = 1000
Thread:pool-1-thread-5
startLine = 4000, endline = 5000
startLine = 3000, endline = 4000
Thread:pool-1-thread-6
startLine = 5000, endline = 6000
Thread:pool-1-thread-7
startLine = 6000, endline = 7000
Thread:pool-1-thread-8
startLine = 7000, endline = 8000
Thread:pool-1-thread-9
startLine = 8000, endline = 9000
Thread:pool-1-thread-10
startLine = 9000, endline = 10000
Thread:pool-1-thread-11
startLine = 10000, endline = 11000
Thread:pool-1-thread-12
startLine = 11000, endline = 12000
Thread:pool-1-thread-13
startLine = 12000, endline = 13000
Thread:pool-1-thread-15
startLine = 13000, endline = 14000
Thread:pool-1-thread-14
startLine = 14000, endline = 15000
Thread:pool-1-thread-16
startLine = 15000, endline = 16000
Thread:pool-1-thread-17
startLine = 16000, endline = 17000
Thread:pool-1-thread-18
startLine = 17000, endline = 18000
Thread:pool-1-thread-19
startLine = 18000, endline = 19000
Thread:pool-1-thread-20
startLine = 19000, endline = 20000
Thread:pool-1-thread-21
startLine = 20000, endline = 21000
Thread:pool-1-thread-22
startLine = 21000, endline = 22000
Thread:pool-1-thread-23
startLine = 22000, endline = 23000
Thread:pool-1-thread-24
startLine = 23000, endline = 24000
Thread:pool-1-thread-25
startLine = 24000, endline = 25000
Thread:pool-1-thread-26
startLine = 25000, endline = 26000
Thread:pool-1-thread-27
startLine = 26000, endline = 27000
Thread:pool-1-thread-28
startLine = 27000, endline = 28000
Thread:pool-1-thread-29
startLine = 28000, endline = 29000
Thread:pool-1-thread-30
startLine = 29000, endline = 30000
Thread:pool-1-thread-31
startLine = 30000, endline = 31000
Thread:pool-1-thread-32
Thread:pool-1-thread-33
Thread:pool-1-thread-34
startLine = 31000, endline = 32000
Thread:pool-1-thread-35
startLine = 33000, endline = 34000
startLine = 32000, endline = 33000
Thread:pool-1-thread-36
startLine = 34000, endline = 35000
startLine = 35000, endline = 36000
Thread:pool-1-thread-37
startLine = 36000, endline = 37000
Thread:pool-1-thread-38
startLine = 37000, endline = 38000
Thread:pool-1-thread-39
startLine = 38000, endline = 39000
Thread:pool-1-thread-40
startLine = 39000, endline = 40000
Thread:pool-1-thread-41
startLine = 40000, endline = 41000
Thread:pool-1-thread-42
startLine = 41000, endline = 42000
Thread:pool-1-thread-43
startLine = 42000, endline = 43000
Thread:pool-1-thread-44
startLine = 43000, endline = 44000
Thread:pool-1-thread-45
startLine = 44000, endline = 45000
Thread:pool-1-thread-46
startLine = 45000, endline = 46000
Thread:pool-1-thread-47
startLine = 46000, endline = 47000
Thread:pool-1-thread-48
Thread:pool-1-thread-49
startLine = 47000, endline = 48000
startLine = 48000, endline = 49000
Thread:pool-1-thread-50
startLine = 49000, endline = 50000
Thread:pool-1-thread-51
startLine = 50000, endline = 51000
Thread:pool-1-thread-52
startLine = 51000, endline = 52000
Thread:pool-1-thread-53
startLine = 52000, endline = 53000
Thread:pool-1-thread-54
startLine = 53000, endline = 54000
Thread:pool-1-thread-55
startLine = 54000, endline = 55000
Thread:pool-1-thread-56
startLine = 55000, endline = 56000
Thread:pool-1-thread-57
startLine = 56000, endline = 57000
Thread:pool-1-thread-58
startLine = 57000, endline = 58000
Thread:pool-1-thread-59
startLine = 58000, endline = 59000
Thread:pool-1-thread-60
startLine = 59000, endline = 60000
Thread:pool-1-thread-61
startLine = 60000, endline = 61000
Thread:pool-1-thread-62
startLine = 61000, endline = 62000
Thread:pool-1-thread-63
startLine = 62000, endline = 63000
Thread:pool-1-thread-64
startLine = 63000, endline = 64000
Thread:pool-1-thread-65
startLine = 64000, endline = 65000
Thread:pool-1-thread-66
startLine = 65000, endline = 66000
Thread:pool-1-thread-67
startLine = 66000, endline = 67000
Thread:pool-1-thread-68
startLine = 67000, endline = 68000
Thread:pool-1-thread-69
startLine = 68000, endline = 69000
Thread:pool-1-thread-70
startLine = 69000, endline = 70000
Thread:pool-1-thread-71
startLine = 70000, endline = 71000
Thread:pool-1-thread-72
startLine = 71000, endline = 72000
Thread:pool-1-thread-73
startLine = 72000, endline = 73000
Thread:pool-1-thread-74
startLine = 73000, endline = 74000
Thread:pool-1-thread-75
startLine = 74000, endline = 75000
Thread:pool-1-thread-76
startLine = 75000, endline = 76000
Thread:pool-1-thread-77
startLine = 76000, endline = 77000
Thread:pool-1-thread-78
startLine = 77000, endline = 78000
Thread:pool-1-thread-79
startLine = 78000, endline = 79000
Thread:pool-1-thread-80
startLine = 79000, endline = 80000
Thread:pool-1-thread-81
Thread:pool-1-thread-82
startLine = 81000, endline = 82000
Thread:pool-1-thread-83
startLine = 82000, endline = 83000
startLine = 80000, endline = 81000
Thread:pool-1-thread-84
startLine = 83000, endline = 84000
Thread:pool-1-thread-85
startLine = 84000, endline = 85000
Thread:pool-1-thread-86
startLine = 85000, endline = 86000
Thread:pool-1-thread-87
startLine = 86000, endline = 87000
Thread:pool-1-thread-88
startLine = 87000, endline = 88000
Thread:pool-1-thread-89
startLine = 88000, endline = 89000
Thread:pool-1-thread-90
startLine = 89000, endline = 90000
Thread:pool-1-thread-91
startLine = 90000, endline = 91000
Thread:pool-1-thread-92
startLine = 91000, endline = 92000
Thread:pool-1-thread-93
startLine = 92000, endline = 93000
Thread:pool-1-thread-94
startLine = 93000, endline = 94000
Thread:pool-1-thread-95
startLine = 94000, endline = 95000
Thread:pool-1-thread-96
startLine = 95000, endline = 96000
Thread:pool-1-thread-97
startLine = 96000, endline = 97000
Thread:pool-1-thread-98
startLine = 97000, endline = 98000
Thread:pool-1-thread-99
startLine = 98000, endline = 99000
Thread:pool-1-thread-100
startLine = 99000, endline = 100000
*/