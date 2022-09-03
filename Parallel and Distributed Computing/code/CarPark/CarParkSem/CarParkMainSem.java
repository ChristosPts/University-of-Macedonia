public class CarParkMainSem
{
	public static void main(String[] args) {
		ParkSem x = new ParkSem();
		int cars = 10;
        CarSem p[] = new CarSem[cars];

		for (int i=0; i<cars; i++) {
			p[i] = new CarSem(x);
			p[i].start(); 
		}
		for (int i=0; i<cars; i++) 
			try { 
				 p[i].join(); 
			} catch (InterruptedException e) { }
    	}
}
