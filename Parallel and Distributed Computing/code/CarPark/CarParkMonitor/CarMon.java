class CarMon extends Thread
{
	private ParkMon a_park;

	
	public CarMon (ParkMon a) {
		a_park = a;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			 a_park.arrive();
			 a_park.park();
			 a_park.depart();
		}        
	}
}
