function h = impulse(x)

    h =[];
    for n = x
        if n>=0 && n<4
            h =[h (0.5^n)];
        else
            h = [h 0];
    end

end

