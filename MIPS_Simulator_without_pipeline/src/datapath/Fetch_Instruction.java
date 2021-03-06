package datapath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import simulator.Simulator;
import storage_components.Memory;
import storage_components.PC;

public class Fetch_Instruction {
	
/*	static String [] threeFields = {"add","addi","sub","sll","srl","and","nor","beq","bne","slt","sltu"};
	static String [] twoFields = {"lw","lb","lbu","sw","sb","lui"};
	static String [] oneField = {"j","jal","jr"};	
*/	
	static String [] RInstruction = {"add","sub","sll","srl","and","nor","slt","sltu"};
	static String [] IThreeFields = {"addi","beq","bne"};
	static String [] ITwoFields   = {"lw","lb","lbu","sw","sb","lui"};
	static String [] JInstruction = {"j","jal","jr"};
	
	public static Map<String , String> funct ;
	public static Map<String , String> op ;

	public static String newPc;
	public void funct(){
		funct = new HashMap<String , String>();
		funct.put("add", "100000");
		funct.put("sub", "100010");
		funct.put("sll", "000000");
		funct.put("srl", "000010");
		funct.put("and", "100100");
		funct.put("nor", "100111");
		funct.put("slt", "101010");
		funct.put("sltu","101011");
		funct.put("jr", "001000");
	}
	
	public void op(){
		op = new HashMap<String , String>();
		op.put("addi", "001000");
		op.put("beq" , "000100");
		op.put("bne" , "000101");
		op.put("lw"  , "100011");
		op.put("lb"  , "100000");
		op.put("lbu" , "100100");
		op.put("sw"  , "101011");
		op.put("sb"  , "101000");
		op.put("lui" , "001111");

		op.put("j"   , "000010");
		op.put("jal" , "000011");

	}
	public Fetch_Instruction(){
		
		
		funct();
		op();
		
		
		

	}
	
	
	public void fetching(String currentpc){
//System.out.println(currentpc);
		System.out.println(Integer.parseInt(currentpc,2) + "     fgfgfg");
		String instruction[] = Memory.memory[Integer.parseInt(currentpc,2)].split(" ");
		//String instruction[] = Simulator.instructionmem.get(pc).split(" ");
		String operation = instruction[0];
		String rs = "";
		String rt = "";
		String rd = "";
		String inst = "";
//R-Instruction
		if(Arrays.asList(RInstruction).contains(operation) ){
			 rs = Simulator.opNameAndBinary.get(instruction[2]);
			 rt = Simulator.opNameAndBinary.get(instruction[3]);
			 rd = Simulator.opNameAndBinary.get(instruction[1]);
			
			 if(instruction[0].equals("sll") ||instruction[0].equals("srl") ){
				 String shamt = String.format("%5s", Integer.toBinaryString(Integer.parseInt(instruction[3]))).replace(' ', '0');
				 inst = "000000"+"00000"+rs+rd+shamt+funct.get(instruction[0]);
		
			 }else{
				 inst = "000000"+rs+rt+rd+"00000"+ funct.get(instruction[0]);
			 }
//I-Instruction with three fields
		}else if(Arrays.asList(IThreeFields).contains(operation)){

			if(operation.equals("addi")){
			rs = Simulator.opNameAndBinary.get(instruction[2]);
			 rt = Simulator.opNameAndBinary.get(instruction[1]);
			}else{
				rs = Simulator.opNameAndBinary.get(instruction[1]);
				 rt = Simulator.opNameAndBinary.get(instruction[2]);
			}
			long imm = Long.parseLong(instruction[3]);
			int intImm =(int) imm;
			if(imm >= 0){
				inst = op.get(instruction[0]) + rs + rt +String.format("%16s", Integer.toBinaryString(Integer.parseInt(instruction[3]))).replace(' ', '0');
			}else{
			
			inst = op.get(instruction[0]) + rs + rt +String.format("%16s", Integer.toBinaryString(Integer.parseInt(instruction[3]))).replace(' ', '0').substring(16, 32);
			}
//I-Instruction with two fields 
		}else if(Arrays.asList(ITwoFields).contains(operation)){
			if((operation.equals("lui"))){
				rs = "00000";
				rt = Simulator.opNameAndBinary.get(instruction[1]);
				inst = op.get(instruction[0])+rs+rt+ String.format("%16s", Integer.toBinaryString(Integer.parseInt(instruction[2]))).replace(' ', '0');
				
			}else{
			 rt = Simulator.opNameAndBinary.get(instruction[1]);
			 int i =0;
			 int j =0;
			 while(instruction[2].charAt(i)!='('){
				i++; 
			 }
			 j = i;
			 while(instruction[2].charAt(j)!=')'){
				 j++;
			 }
			 String reg = instruction[2].substring(i+1,j);
			 rs = Simulator.opNameAndBinary.get(reg);
			 
			 int number = Integer.parseInt(instruction[2].substring(0,i));
			 inst = op.get(instruction[0]) + rs + rt + String.format("%16s", Integer.toBinaryString(number)).replace(' ', '0');
			}
//J-Instruction		
		}else if(Arrays.asList(JInstruction).contains(operation)){
			if(operation.equals("jr")){ // r-type jr
				rs = Simulator.opNameAndBinary.get(instruction[1]);
				inst = "000000"+ rs + "00000" + "00000" + "00000" + "001000";
			}else {
				inst = op.get(instruction[0]) +String.format("%26s", Integer.toBinaryString(Integer.parseInt(instruction[1]))).replace(' ', '0');
			}
		}
		
		//Simulator.if_id.set(pc, inst);
		IF_ID.instruction = inst;
		int intPc = Integer.parseInt(currentpc,2);
		intPc += 4;
	    newPc = String.format("%32s", Integer.toBinaryString(intPc)).replace(' ', '0');
		IF_ID.pc =newPc;
		
		Decode_Instruction decode_instruction = new Decode_Instruction();
	}
	
	

	
	public static void main(String[] args) {
		
	}
}
