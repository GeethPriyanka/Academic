%part2_a
function y = convolution(x,h)
xa = length(x);
hb = length(h);
n = xa+hb-1;   
y = zeros(1,n); %initial values are given as zero

for p = 0:n
    for q = 0:n
        if((p-q+1)>0 && (p-q+1)<=hb && (q+1)<=xa)
           y(p+1) = y(p+1)+ x(q+1).*h(p-q+1);
        end
    end
end
