package datapath;

import storage_components.Registers;

public class Wb {
	public Wb(){
		if(MEM_WB.memToReg){
			Registers.registers.put(MEM_WB.outregdst, MEM_WB.aluResult);
		}else{
			Registers.registers.put(MEM_WB.outregdst, MEM_WB.readdata);
		}
	}
}
