module regfile8x8a
	(input clk,input [3:0] INaddr,
	input [8:0] IN,
	input [3:0] OUT1addr,
	output [8:0] OUT1,
	input [3:0] OUT2addr,
	output [8:0] OUT2);

	reg [8:0] reg0,reg1,reg2,reg3,reg4,reg5,reg6,reg7;

		assign 
		OUT1 =	OUT1addr == 0 ? reg0 :
				OUT1addr == 1 ? reg1 :
				OUT1addr == 2 ? reg2 :
				OUT1addr == 3 ? reg3 : 
				OUT1addr == 4 ? reg4 :
				OUT1addr == 5 ? reg5 :
				OUT1addr == 6 ? reg6 :
				OUT1addr == 7 ? reg7 ;
				// add until 8 //
		assign 
		OUT2= 	OUT2addr == 0 ? reg0 :
				OUT2addr == 1 ? reg1 :
				OUT2addr == 2 ? reg2 :
				OUT2addr == 3 ? reg3 : 
				OUT2addr == 4 ? reg4 :
				OUT2addr == 5 ? reg5 :
				OUT2addr == 6 ? reg6 :
				OUT2addr == 7 ? reg7 ;
				//add until 8//
			always @(negedgeclk) 
			begin
				case(INaddr)
				// your code here
				
				
				
				
				
			end // always @ (negedgeclk)
endmodule
