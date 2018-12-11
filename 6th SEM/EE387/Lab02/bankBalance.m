function newb = bankBalance(b, p, n)
%p net saving
%b balance
%n month
newb = [];
for i = 1:length(n)
    b = (b*1.01+p(i));
    newb = [newb b];
    
end