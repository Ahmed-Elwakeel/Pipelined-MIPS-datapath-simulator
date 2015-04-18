package storage_components;


public class Instruction_Memory {
	
	static String [] instructionMemory = new String[1];
	public static int size= 0;
	public Instruction_Memory(){
		
	}
	
	public void add(String instuction , int pc){
		this.instructionMemory[pc] = instuction;
		size++;
	}
	
	public String get(int pc ){
		return instructionMemory[pc];
	}
	
	public static void main(String[] args) {
		
		//System.out.println(String.format("%16s", Integer.toBinaryString(1)).replace(' ', '0'));
	}
	
	
}