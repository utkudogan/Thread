package com.udogan.threads;

public class YerliThread extends Thread {
	
	private static int statikSabit = 0; 
	private static int kontrol =0;
	
	@Override
	public void run() {
		hangiThread(this);
		statikSabitiArttýr(this);
	}	

	private static void statikSabitiArttýr(YerliThread thread) {		
		if (kontrol < 50) {
			if (statikSabit <= 0) {
				for (int i = 0; statikSabit < 25; i++) {
					statikSabit++;
					kontrol++;
					System.out.println(thread.getName() + "thread çalýþtý. statikSabit'in deðeri: " + statikSabit);
				}
			}
			else if (statikSabit > 0) {
				for (int i = 0; statikSabit > 25; i++) {
					statikSabit--;
					kontrol++;
					System.out.println(thread.getName() + "thread çalýþtý. statikSabit'in deðeri: " + statikSabit);
				}
			}			
		}
	}

	private static synchronized void hangiThread(YerliThread thread) {
		for (int i = 0; i < 10; i++) {
			System.out.println(thread.getName());
		}				
	}
	
	public static void main(String[] args) {
		YerliThread birinciThread = new YerliThread();
		birinciThread.setName("birinci");
		birinciThread.start();
		YerliThread ikinciThread = new YerliThread();
		ikinciThread.setName("ikinci");
		ikinciThread.start();		
	}
}
