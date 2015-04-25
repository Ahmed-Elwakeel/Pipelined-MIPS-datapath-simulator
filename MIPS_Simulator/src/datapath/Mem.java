package datapath;

import logic_components.SignExtend;
import storage_components.Memory;
import storage_components.PC;

public class Mem {
	public static boolean pcSrc;
	
	public Mem(){
		memoryPart();	
		branchPart();
		if(EX_MEM.jal){ // 3shan al jal
			MEM_WB.aluResult = EX_MEM.returnAddress;

		}else{
			MEM_WB.aluResult = EX_MEM.aluResult;
		}
			MEM_WB.regWrite = EX_MEM.regWrite;
			MEM_WB.memToReg = EX_MEM.memToReg;
			MEM_WB.outregdst = EX_MEM.outregdst;
			
			settingPc();
		Wb wb = new Wb();
	}
	public void settingPc(){
		if(EX_MEM.jr){
			
			PC.set(Integer.parseInt(ID_EX.readdata1,2));
			System.out.println(Integer.parseInt(ID_EX.readdata1,2)+"AHMED");
		}else{
			if(EX_MEM.j){
				PC.set(Integer.parseInt(EX_MEM.jpc,2));
			}else{
				if (Mem.pcSrc) {
					PC.set(Integer.parseInt(EX_MEM.pc,2)) ;
				}else{
					PC.set(Integer.parseInt(Fetch_Instruction.newPc,2));
				}
			}
		}
		System.out.println(PC.pc+"PCCCCCCCCCCCCCc");
	}
	public void memoryPart(){
	
		if(EX_MEM.memRead){
			
			String address = EX_MEM.aluResult;
			int intAdress = Integer.parseInt(address,2);
			if(EX_MEM.lb){
				SignExtend se = new SignExtend();
				
				MEM_WB.readdata = se.signextend(Integer.parseInt(Memory.memory[intAdress].substring(24,32),2));
			}else{
				MEM_WB.readdata = Memory.memory[intAdress];
			}
		}else if(EX_MEM.memWrite){
			String address = EX_MEM.aluResult;
			int intAdress = Integer.parseInt(address,2);
			if(EX_MEM.sb){
				SignExtend se = new SignExtend();
				System.out.println(se.signextend(Integer.parseInt(EX_MEM.data2.substring(24,32),2))+"AHME");
				Memory.memory[intAdress] = se.signextend(Integer.parseInt(EX_MEM.data2.substring(24,32),2));

			}else{
				Memory.memory[intAdress] = EX_MEM.data2;
			}
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
