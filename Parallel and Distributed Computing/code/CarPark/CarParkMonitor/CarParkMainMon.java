public class CarParkMainMon
{
	public static void main(String[] args) {
		ParkMon x = new ParkMon();
		
		int cars = 10;
		CarMon p[] = new CarMon[cars];

		for (int i=0; i<cars; i++) {
			p[i] = new CarMon(x);
			p[i].start(); 
		}
		for (int i=0; i<cars; i++) 
			try { 
				 p[i].join(); 
			} catch (InterruptedException e) { }
	}
}
