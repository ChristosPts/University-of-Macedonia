public class CarParkMainCond
{
	public static void main(String[] args) {
		ParkCond x = new ParkCond();
		int cars = 10;
		CarCond p[] = new CarCond[cars];

		for (int i=0; i<cars; i++) {
			p[i] = new CarCond(x);
			p[i].start(); 
		}
		for (int i=0; i<cars; i++) 
			try { 
				 p[i].join(); 
			} catch (InterruptedException e) { }
    }
}
