package storage_components;

public class PC {
	
	static int pcint = 1;
	static String pc;
	public PC (){
		this.pc = String.format("%32s", Integer.toBinaryString(0)).replace(' ', '0');
	}
	
	public void add(){
		this.pcint += 1;
		this.pc =this.pc = String.format("%32s", Integer.toBinaryString(pcint)).replace(' ', '0');

	}

}
