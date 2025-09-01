
public class BlockTimer extends Thread {
	private long breaktime;
	private Start start;
	private boolean isgameover;
	public BlockTimer(long bt,Start start) {
		this.breaktime = bt;
		this.start = start;
		isgameover = false;
	}
	public void run(){
		while(!isgameover) {
			try {
				sleep(breaktime);
				start.timerNotified();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void setBreakTime(long bt) {
		breaktime = bt;
	}
	public void gameOver() {
		isgameover =true;
	}
}
