package simulator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import storage_components.Instruction_Memory;
import storage_components.PC;
import datapath.EX_MEM;
import datapath.Fetch_Instruction;
import datapath.ID_EX;
import datapath.IF_ID;


public class Simulator {
	
	public static Map<String , String> opNameAndBinary ;

	public static Instruction_Memory instructionmem;
	public static PC pc;
	public static IF_ID if_id;
	public Simulator() throws IOException{
		init();
		readInput();
		for(int i = 0 ;i < instructionmem.size ;i++){
			Fetch_Instruction fetch = new Fetch_Instruction(i);
			System.out.println(IF_ID.instruction);
		}
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
		 instructionmem = new Instruction_Memory();
		 pc = new PC();
		// if_id = new IF_ID();
		// ID_EX id_ex = new ID_EX();
		// EX_MEM ex_mem= new EX_MEM();
		 nameToBinary();
	}

	
	public void readInput() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = "";
		int i = 0;
		while((line = br.readLine())!= null){
			instructionmem.add(line, i );
			i++;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Simulator sim = new Simulator();
	}
}
