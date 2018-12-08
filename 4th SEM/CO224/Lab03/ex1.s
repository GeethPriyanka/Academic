@ ARM Assembly - exercise 1


	.text 	@ instruction memory

	
@ Write YOUR CODE HERE	

@ ---------------------	
@ mypow:
@ implement using loops

mypow:
	cmp r1, #0
	beq zeroend

	mul r6, r8, r0
	add r7, r7, #1

	mov r8, r6
	cmp r1, r7
	bne mypow

	b end
@ ---------------------	

	.global main
main:
	@ stack handling, will discuss later
	@ push (store) lr to the stack
	sub sp, sp, #4
	str lr, [sp, #0]

	mov r4, #8 	@the value x
	mov r5, #3 	@the value n

	mov r7, #0
	mov r8, r0

	@ calling the mypow function
	mov r0, r4 	@the arg1 load
	mov r1, r5 	@the arg2 load
	bl mypow
zeroend:
	mov r6, #1

end:

	@ load aguments and print
	ldr r0, =format
	mov r1, r4
	mov r2, r5
	mov r3, r6
	bl printf

	@ stack handling (pop lr from the stack) and return
	ldr lr, [sp, #0]
	add sp, sp, #4
	mov pc, lr

	.data	@ data memory
format: .asciz "%d^%d is %d\n"

