module test
	instruction = 8'b00000010
	
	always @(instruction) 
		
		for(i=0; i<8; i=i+1)
		begin
			#1 
			instruction  <= instruction<<1;
			$display("%b",instruction);
		end
		
		
		//use the instruction flow given in the last page. Convert them to 32bit binary.
	end
	



endmodule
