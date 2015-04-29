package datapath;

import storage_components.Control;
import storage_components.Memory;
import storage_components.Registers;

public class Printing {
	
	public static  void printing(){
		for(int i = 0 ; i < 32 ; i++){
			System.out.println("REGISTERS");
			System.out.println(Registers.registers.get(String.format("%32s", Integer.toBinaryString(i)).replace(' ', '0')));
		}
		
		for(int i = 0 ; i < 200 ; i++){
			System.out.println("MEMORY");
			System.out.println(Memory.memory[i]);
		}
		System.out.println("regDst "+Control.regDst);
		System.out.println("branch "+Control.branch);
		System.out.println("memRead "+Control.memRead);
		System.out.println("memToReg" + Control.memToReg);
		System.out.println("ALUOp "+Control.ALUOp);
		System.out.println("memWrite "+ Control.memWrite);
		System.out.println("ALUSrc "+Control.ALUSrc);
		System.out.println("regWrite "+Control.regWrite);
		System.out.println("bneBranch "+Control.bneBranch);
		System.out.println("lb "+Control.lb);
		System.out.println("sb "+Control.sb);
		System.out.println("j "+Control.j);
		System.out.println("jal "+Control.jal);
		System.out.println("jr "+Control.jr);
		System.out.println("lui "+Control.lui);

	}

}
