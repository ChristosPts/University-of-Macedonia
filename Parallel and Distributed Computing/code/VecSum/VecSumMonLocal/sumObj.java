class sumObj {

    double sum;
    
    public sumObj (){
		this.sum = 0;
    }

    public synchronized void add (double localsum){
		this.sum = this.sum + localsum;
    }

    public synchronized void printout() {
		System.out.println(this.sum);
    }
}
