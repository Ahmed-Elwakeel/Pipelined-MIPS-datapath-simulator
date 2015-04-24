package simulator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import storage_components.Instruction_Memory;
import storage_components.Memory;
import storage_components.PC;
import storage_components.Registers;
import datapath.Assembler;


public class Simulator {
	
	public static Map<String , String> opNameAndBinary ;
	public static Registers registers;
	public static Instruction_Memory instructionmem;
	//public static PC pc;
	//public static IF_ID if_id;
	static int size;
	public Simulator() throws IOException{
		init();
		readInput();
		String currentpc = PC.instructionpc;
		Memory.instructionMemSize = size;
		/*for(int i = 0 ;i < size ;i++){
			Fetch_Instruction fetch = new Fetch_Instruction(currentpc);
			
			System.out.println(IF_ID.instruction);
		}*/
		//Fetch_Instruction fetch = new Fetch_Instruction();
		Assembler assembler = new Assembler();
	}
	public void nameToBinary (){
		opNameAndBinary = new HashMap<String , String>();
		opNameAndBinary.put("zero", "00000");
		opNameAndBinary.put("$at" , "00001");
		opNameAndBinary.put("$v0" , "00010");
		opNameAndBinary.put("$v1" , "00011");
		opNameAndBinary.put("$a0" , "00100");
		opNameAndBinary.put("$a1" , "00101");
		opNameAndBinary.put("$a2" , "00110");
		opNameAndBinary.put("$a3" ,"00111");
		int var = 8;
		for(int i = 0 ;i <= 7 ; i++ ){
			opNameAndBinary.put("$t"+i, String.format("%5s", Integer.toBinaryString(var)).replace(' ', '0'));
			var++;
		}
		var = 16;
		for(int i = 0 ;i <= 7 ; i++ ){
			opNameAndBinary.put("$s"+i, String.format("%5s", Integer.toBinaryString(var)).replace(' ', '0'));
			var++;
		}
		opNameAndBinary.put("$t8", "11000");
		opNameAndBinary.put("$t9", "11001");
		opNameAndBinary.put("$k0", "11010");
		opNameAndBinary.put("$k1", "11011");
		opNameAndBinary.put("$gp", "11100");
		opNameAndBinary.put("$sp", "11101");
		opNameAndBinary.put("$s8", "11110"); // not $fp
		opNameAndBinary.put("$ra", "11111");

	}
	
	public void init(){
		// instructionmem = new Instruction_Memory();
		// pc = new PC();
		// if_id = new IF_ID();
		// ID_EX id_ex = new ID_EX();
		// EX_MEM ex_mem= new EX_MEM();
		  registers = new Registers();
		 nameToBinary();
	}

	
	public void readInput() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		size = 0;
		while(!((line = br.readLine()).equals("end"))){
			if(line.equals("data")){
				while(!(line=br.readLine()).equals("text")){
					String arrayString [] = line.split(" ");
					if(arrayString[0].equals("pc")){
						//pc.set(Integer.parseInt(arrayString[1]));
						PC.set(Integer.parseInt(arrayString[1]));
						PC.instructionpc = String.format("%32s", Integer.toBinaryString(Integer.parseInt(arrayString[1]))).replace(' ', '0');
					}else{
						Memory.memory[Integer.parseInt(arrayString[0])] =  String.format("%32s", Integer.toBinaryString(Integer.parseInt(arrayString[1]))).replace(' ', '0');
					}
				}
				line = br.readLine(); //3shan hayb2a wa2ef 3and al text
			}
			
			//instructionmem.add(line, i );
			//i++;
			Memory.memory[PC.pcint] = line;
			PC.add();
			size++;
		}
		PC.endinstruction = PC.pc;
		PC.set(Integer.parseInt(PC.instructionpc,2));
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		Simulator sim = new Simulator();
		
	}
}
