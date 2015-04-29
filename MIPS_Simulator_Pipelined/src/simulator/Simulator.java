package simulator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import storage_components.Instruction_Memory;
import storage_components.PC;


public class Simulator {
	
	public static Instruction_Memory instructionmem;
	public static PC pc;
	public Simulator() throws IOException{
		init();
		readInput();
		
	}
	
	
	public void init(){
		 instructionmem = new Instruction_Memory();
		 pc = new PC();
	}

	
	public void readInput() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("input"));
		String line = "";
		int i = 1;
		while((line = br.readLine())!= null){
			instructionmem.add(line, i );
			i++;
		}
	}
	
	
	
	public static void main(String[] args) {

	}
}
