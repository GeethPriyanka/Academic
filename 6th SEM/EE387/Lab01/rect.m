function x = rect(t)
x=[];
    for i=t
        if ((i>-0.5) && (i<0.5))
            x = [x 1];
        else
            x = [x 0];
        end
    end

end
%
% RECT rectangular pulse
% 
% Usage: x = rect(t)
%
% This function takes in a vector t of sample instants and outputs the
% corresponding rectangular pulse contained in the function x 