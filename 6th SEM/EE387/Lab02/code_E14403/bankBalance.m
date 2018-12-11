function newBalance = bankBalance(balance, netSaving, month)

newBalance = [];

for i = 1:length(month)
    
    balance = (balance+balance*0.01+netSaving(i));
    newBalance = [newBalance balance];
    
end