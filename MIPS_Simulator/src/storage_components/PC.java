package storage_components;

public class PC {
	
	public static int pcint;
	public static String pc;
	public static String instructionpc;  // awl pc ll instruction
	public PC (){
		this.pc = String.format("%32s", Integer.toBinaryString(0)).replace(' ', '0');
	}
	
	public static void add(){
		pcint += 4;
		pc = String.format("%32s", Integer.toBinaryString(pcint)).replace(' ', '0');
	}
	
	public static void set(int intpc){
		pcint = intpc;
		pc =  String.format("%32s", Integer.toBinaryString(pcint)).replace(' ', '0');
	}

}
