package utils;

public class TestWait {

	public static void hardwait(int seconds) {
		try {
			Thread.sleep(seconds* 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
