import javafx.application.Application;
import java.util.LinkedList;
import java.util.Queue;

public class GuitarString {
	int Size;
	Queue <Double> bufferQueue = new LinkedList<Double>( );	
	
	public GuitarString(double freq){
		double N= StdAudio.SAMPLE_RATE/freq;
		Size=(int) Math.round(N);
		
		// If the frequency is less than or equal to 0 or if the resulting size of 
		//the ring buffer would be less than 2, your method should throw an IllegalArgumentException.
	    if (Size<2||freq<=0){
	    	throw new IllegalArgumentException();
	    }
	    else{
		    for (int i=0;i<Size;i++){
		    	bufferQueue.add(0.0);
		    }
	    } 
	}
	
    public GuitarString( double[] init ){
    	if (init.length<2){
	    	throw new IllegalArgumentException();
	    }
    	else{
    		for (int i=0;i<init.length;i++){
    			bufferQueue.add(init[i]);
    		}
    	}
    
	}
	
    
    //This method should replace the N elements 
	//in the ring buffer with N random values between -0.5 inclusive and +0.5 
	//exclusive (i.e. -0.5 <= value < 0.5).
    public void pluck( ){
    	for(int i=0;i<Size;i++){
    	double radnum= Math.random()-0.5;
    	bufferQueue.remove();
    	bufferQueue.add(radnum);
    	}
    }

	public void tic( ){
		double firstNum =bufferQueue.peek();
		bufferQueue.remove();
		double secondNum=bufferQueue.peek();
		bufferQueue.add((firstNum+secondNum)/2*0.996);
    }
    
    public double sample( ){
    	double sampleNum =bufferQueue.peek();
    return sampleNum;
    }
}



