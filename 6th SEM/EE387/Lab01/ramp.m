function y = ramp(t,m,ad)
 
    y=[];

    for i=t
        i = i+ad;
        if i<=0
            y = [y 0];
        else
            y = [y m*i];
        end
    end

end
