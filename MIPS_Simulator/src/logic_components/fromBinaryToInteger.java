package logic_components;

public class fromBinaryToInteger {
	
	public fromBinaryToInteger(){
		
	}
	public static  String integerToBinary(int number , int noOfBits){
		if(number >= 0){
			return String.format("%"+noOfBits+"s", Integer.toBinaryString(number)).replace(' ', '0');
		}else{
			String x = Integer.toBinaryString(number*-1);
			String res ="";
			for(int i =0 ; i<x.length() ;i++){
				if(x.charAt(i)=='0'){
					res = res+"1";
				}else{
					res = res+"0";
				}
			}
	
			int intRes = Integer.parseInt(res,2);
			intRes += 1;
			 
			return String.format("%"+noOfBits+"s", Integer.toBinaryString(intRes)).replace(' ', '1');  
		}
	}
	
	public static int binaryToInteger(String binary){
		if(binary.charAt(0)== '0'){
			return Integer.parseInt(binary,2); 
		}else{
			String res="";
			for(int i = 0; i< binary.length() ; i++){
				if(binary.charAt(i)=='0'){
					res = res+"1";
				}else{
					res = res+"0";
				}
			}
			int intRes = Integer.parseInt(res,2);
			intRes += 1;
			return intRes;
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(binaryToInteger("1101"));
	}
}
