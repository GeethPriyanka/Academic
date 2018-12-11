clear all;
close all;

month = -50:200;
y = unitImpulse(month);
investorBalance = bankBalance(0,y,month);
ht = conv(investorBalance,y);

subplot(3,2,1);
stem(month,y);
title('Graph of x(t)(investor)');

subplot(3,2,3);
stem(month,investorBalance);
title('Graph of y(t)(investor)');

subplot(3,2,5);
stem(ht);
title('Graph of h(t)(investor)');

merchantBalance = merchant(0, 100, month);
ht = conv(merchantBalance, y);

subplot(3,2,2);
stem(month,y);
title('Graph of x(t)(merchant)');

subplot(3,2,4);
stem(month,merchantBalance);
title('Graph of y(t)(merchant)');

subplot(3,2,6);
stem(ht);
title('Graph of h(t)(merchant)');