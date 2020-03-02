package Threading;

public class SharedDouble {
	private Double d = 0.0;

	public Double getD() {
		return d;
	}

	public void compare(Double a) {
		synchronized (this) {
			if (a > d) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				d = a;
			}
		}
	}
}
//	private Double d = 0.0;
//
//	public Double getD() {
//		return d;
//	}
//
//	public void setD(Double d) {
//		this.d = d;
