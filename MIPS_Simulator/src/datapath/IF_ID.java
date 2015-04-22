package datapath;

public class IF_ID {
	
	public static int pc;
	public static String instruction;
	
	public IF_ID (){

	}
	//malhash lazma
	public void set(int pc  , String instruction){
		this.pc = pc;
		this.instruction = instruction;
	}
}
