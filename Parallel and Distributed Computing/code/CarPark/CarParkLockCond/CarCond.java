class CarCond extends Thread
{
	private ParkCond a_park;

	
	public CarCond (ParkCond a) {
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
