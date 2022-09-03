class CarSem extends Thread {
	private ParkSem a_park;

	
	public CarSem (ParkSem a) {
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
