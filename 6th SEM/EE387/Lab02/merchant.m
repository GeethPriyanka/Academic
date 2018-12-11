function newsaving = merchant(saving, m, n)
%m =amout of money
%n =month
newsaving = [];

for i = 1:length(n)
    saving = saving+(m/2);
    newsaving = [newsaving saving];
end