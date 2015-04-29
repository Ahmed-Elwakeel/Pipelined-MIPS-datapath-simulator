package datapath;

import logic_components.ALUControl;
import storage_components.Memory;
import storage_components.PC;
import storage_components.Registers;

public class Assembler {
	
	
	

	public Assembler() {
		//Fetch_Instruction fetch_instruction = new Fetch_Instruction();
		int starting = Integer.parseInt(PC.instructionpc, 2);
		int end = (Memory.instructionMemSize * 4) + starting;
		int size  = Memory.instructionMemSize;
		while(size > 0){
		Wb wb = new Wb();
		Mem mem = new Mem();
		Execute_Instruction execute_instruction = new Execute_Instruction();
		Decode_Instruction decode_instruction = new Decode_Instruction();
		Fetch_Instruction fetch_instruction = new Fetch_Instruction();
		size--;
		}
		
		
		/*
		 * for(int i=starting ; i < end ; i=i+4){ if(EX_MEM.visited){
		 * if(EX_MEM.branch && EX_MEM.zero){ i = Integer.parseInt(EX_MEM.pc, 2);
		 * fetch_instruction.fetching(EX_MEM.pc); }else{
		 * fetch_instruction.fetching(String.format("%32s",
		 * Integer.toBinaryString(i)).replace(' ', '0')); } }else{
		 * fetch_instruction.fetching(String.format("%32s",
		 * Integer.toBinaryString(i)).replace(' ', '0')); } }
		 */
		
		
	/*while (!(PC.pc.equals(PC.endinstruction))) { */
				
				/*if (Mem.pcSrc) {
					PC.set(Integer.parseInt(EX_MEM.pc,2)) ;
				}else{
					PC.set(Fetch_instruction.);
				}*/
		//	fetch_instruction.fetching(PC.pc);
			
		/*	
			if(EX_MEM.jr){
				PC.set(Integer.parseInt(ID_EX.readdata1,2));
				System.out.println(Integer.parseInt(ID_EX.readdata1)+"AHMED");
			}else{
				if(EX_MEM.j){
					PC.set(Integer.parseInt(EX_MEM.jpc,2));
				}else{
					if (Mem.pcSrc) {
						PC.set(Integer.parseInt(EX_MEM.pc,2)) ;
					}else{
						PC.set(Integer.parseInt(fetch_instruction.newPc,2));
					}
				}
			}
		*/
			//PC.add();
		/*for(int i = 0 ; i <= 28 ;i= i+4){
				System.out.println(Memory.memory[i]);	
			}
			System.out.println();
			*/
		/*}*/
	}
}
