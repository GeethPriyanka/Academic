function newBalance = merchant(saving, money, month)

newBalance = [];

for i = 1:length(month)
    saving = saving+(money/2);
    newBalance = [newBalance saving];
end