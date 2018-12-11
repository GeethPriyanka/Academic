function y = unitImpulse(n)

y = [];
for i=n
    if(i==0)
        y = [y 1];
    else
        y = [y 0];
    end
end

end

