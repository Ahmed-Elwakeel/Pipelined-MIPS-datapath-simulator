package datapath;

import storage_components.Memory;
import storage_components.Registers;

public class Wb {
	public Wb(){
		
		if(MEM_WB.memToReg){
			Registers.registers.put(MEM_WB.outregdst, MEM_WB.readdata);

		}else{
			Registers.registers.put(MEM_WB.outregdst, MEM_WB.aluResult);

		}
		for(int i = 0 ; i <= 28 ;i= i+4){
			System.out.println(Memory.memory[i]);	
		}
		System.out.println();
		
	}
}
