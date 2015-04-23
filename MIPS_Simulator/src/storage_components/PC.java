package storage_components;

public class PC {
	
	public static int pcint;
	public static String pc;
	public static String instructionpc;
	public PC (){
		this.pc = String.format("%32s", Integer.toBinaryString(0)).replace(' ', '0');
	}
	
	public void add(){
		this.pcint += 1;
		this.pc = String.format("%32s", Integer.toBinaryString(pcint)).replace(' ', '0');
	}
	
	public void set(int pc){
		this.pcint = pc;
		this.pc =  String.format("%32s", Integer.toBinaryString(pcint)).replace(' ', '0');
	}

}
