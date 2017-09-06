// skeleton version of the class

public class Guitar221 implements Guitar {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
    private GuitarString[] String37=new GuitarString[37];//an array of 37 notes
    
    //create ring buffer for each note
    public Guitar221() {
    	int i=0;
	    for(i=0;i<37;i++){
		    double concert=440* Math.pow(2.0,((double)(i- 24)/(double)12.0));
		    String37[i] = new GuitarString(concert);
	    }
    }
    
    // play the notes with the given pitch
    public void playNote(int pitch) {
    	// play the pitch in the range of the guitar
    	if((pitch+12)<=36&&(pitch+12)>=0){
    		String37[pitch+12].pluck();
        }
    	return;
    }
    
    
    // returns whether there is a string that corresponds to this character
    public boolean hasString(char key){
    	if (KEYBOARD.indexOf(key)==-1){
    		return false;
    	}
    	return true;
    }

    // plucks the string for this character
    //the character must be one of the 37 keys
    public void pluck(char key){
    	if(hasString(key)){
	    	int note=KEYBOARD.indexOf(key);
	    	String37[note].pluck();
	    	
    	}else{
    		throw new IllegalArgumentException();
    	}	
    }

    // returns the current sound (sum of all strings)
    public double sample(){
    	double SumOfSamples=0.0;
    	for(int j=0;j<37;j++){
    		SumOfSamples=SumOfSamples+ String37[j].sample();
    	}
    	return SumOfSamples;
    }

    // advances the simulation by having each string tic forward
    public void tic(){
    	for(int z=0;z<37;z++){
    		String37[z].tic();
    	}
    }
    
    // method that returns the number of times tic has been called;
    // returns -1 if not implemented
    public int time(){
    	return -1;
    }
}
