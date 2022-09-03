class ProducerConsumer{
	
	public static void main(String[] args){
		int bufferSize = 10^100;
		int noIterations = 20;
		int producerDelay = 1;
		int consumerDelay = 100;
		int noProds = 3;
		int noCons = 2;
		Producer prod[] = new Producer[noProds];
		Consumer cons[] = new Consumer[noCons];
		

		// Bounded Buffer
		Buffer buff = new Buffer(bufferSize);
		
		// Producer threads
		for (int i=0; i<noProds; i++) {
			prod[i] = new Producer(buff, noIterations, producerDelay);
			prod[i].start();
		}

		// Consumer threads
		for (int j=0; j<noCons; j++) {
	        cons[j] = new Consumer(buff, consumerDelay);
			cons[j].start();
		}
	}
}
