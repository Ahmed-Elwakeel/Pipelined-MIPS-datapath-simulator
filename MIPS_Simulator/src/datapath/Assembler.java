package datapath;

import storage_components.Memory;
import storage_components.PC;
import storage_components.Registers;

public class Assembler {

	public Assembler() {
		Fetch_Instruction fetch_instruction = new Fetch_Instruction();
		int starting = Integer.parseInt(PC.instructionpc, 2);
		int end = (Memory.instructionMemSize * 4) + starting;
		/*
		 * for(int i=starting ; i < end ; i=i+4){ if(EX_MEM.visited){
		 * if(EX_MEM.branch && EX_MEM.zero){ i = Integer.parseInt(EX_MEM.pc, 2);
		 * fetch_instruction.fetching(EX_MEM.pc); }else{
		 * fetch_instruction.fetching(String.format("%32s",
		 * Integer.toBinaryString(i)).replace(' ', '0')); } }else{
		 * fetch_instruction.fetching(String.format("%32s",
		 * Integer.toBinaryString(i)).replace(' ', '0')); } }
		 */
		while (!(PC.pc.equals(PC.endinstruction))) {
			
				if (Mem.pcSrc) {
					PC.set(Integer.parseInt(EX_MEM.pc,2)) ;
				}
			
			fetch_instruction.fetching(PC.pc);
			PC.add();
			for(int i = 0 ; i <= 28 ;i= i+4){
				System.out.println(Memory.memory[i]);	
			}
			System.out.println();
			
		}
	}
}
