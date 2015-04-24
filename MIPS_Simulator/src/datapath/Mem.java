package datapath;

import storage_components.Memory;

public class Mem {
	public static boolean pcSrc;
	public Mem(){
		memoryPart();	
		branchPart();
			MEM_WB.aluResult = EX_MEM.aluResult;
			MEM_WB.regWrite = EX_MEM.regWrite;
			MEM_WB.memToReg = EX_MEM.memToReg;
			MEM_WB.outregdst = EX_MEM.outregdst;
		Wb wb = new Wb();
	}
	
	public void memoryPart(){
		if(EX_MEM.memRead){
			String address = EX_MEM.aluResult;
			int intAdress = Integer.parseInt(address,2);
			MEM_WB.readdata = Memory.memory[intAdress];
		}else if(EX_MEM.memWrite){
			String address = EX_MEM.aluResult;
			int intAdress = Integer.parseInt(address,2);
			Memory.memory[intAdress] = EX_MEM.data2;
		}
	}
	
	public void branchPart(){
		if((EX_MEM.branch && EX_MEM.zero)||(EX_MEM.bneBranch && !(EX_MEM.zero))){
			pcSrc = true;
		}else{
			pcSrc = false;
		}
	}
}
