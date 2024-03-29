package com.udogan.threads;

public class YerliThread extends Thread {
	
	private static int statikSabit = 0; 
	private static int kontrol =0;
	
	@Override
	public void run() {
		hangiThread(this);
		statikSabitiArttır(this);
	}	

	private static void statikSabitiArttır(YerliThread thread) {		
		if (kontrol < 50) {
			if (statikSabit <= 0) {
				for (int i = 0; statikSabit < 25; i++) {
					statikSabit++;
					kontrol++;
					System.out.println(thread.getName() + "thread çalıştı. statikSabit'in değeri: " + statikSabit);
				}
			}
			else if (statikSabit > 0) {
				for (int i = 0; statikSabit > 25; i++) {
					statikSabit--;
					kontrol++;
					System.out.println(thread.getName() + "thread çalıştı. statikSabit'in değeri: " + statikSabit);
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
