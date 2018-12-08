%%%%%%%%%%%%
% E/14/403 %
%%%%%%%%%%%%

%_____________________________________________________________________________
%   Question a

img1 = imread('football.jpg');   %reading the image
threshold = 127;
 

bw = rgb2gray(img1);     %converting color image to black and white inorder to have a single threshold

[row,col] = size(bw);   %taking the size of the image

for i = 1:row           %iterating through the row
    for j = 1:col       %iterating through the column
        if bw(i,j)<threshold      %if the pixel value is less than the threshold value --> 0
            bw(i,j) = 0;
        else
            bw(i,j) = 255;  %if the pixel value is greater than the threshold value --> 255
        end
    end
end
figure('Name', 'Question a');
subplot(1,2,1),imshow(img1);title('Original image');     %printing the original image
subplot(1,2,2),imshow(bw);title('Thresholded image'); %Answer of the question a

%_____________________________________________________________________________
%   Question b

img2 = imread('rice.png');      %reading image 2
%subplot(1,2,2), imshow(img2);
img3 = imread('cameraman.tif');     %reading image 3 of same size as 2
added_im = imadd(img2,img3,'uint16');   %adding two images
sub_im = imsubtract(img3,img2);     %subtracting the images


figure('Name', 'Question b');
subplot(2,2,1),imshow(img2);title('Image 1');
subplot(2,2,2),imshow(img3);title('Image 2');
subplot(2,2,3),imshow(added_im,[]),title('Addition of two Images');
subplot(2,2,4),imshow(sub_im),title('Subtraction of two images');

%_____________________________________________________________________________
%   Question c

%in log transformation s = c log (1+r)

c = 255/2.4;    % this value is given as an input

img4 = imread('onion.png');         %read the image
bw_onion = rgb2gray(img4);          %getting the black & white image
bw_onion_trans = bw_onion;
[row1, col1] = size(bw_onion);      %getting the size

for p = 1:row1
   for q = 1:col1                   %iterate through the image pixel by pixel
      m = double(bw_onion(p,q));    %taking the double value of intensity for the next calculation
      bw_onion_trans(p,q) = c.*log10(1+m);%log transformation formula
   end
end


figure('Name', 'Question c - log transformation');
subplot(1,2,1),imshow(bw_onion);title('Original image');
subplot(1,2,2),imshow(bw_onion_trans);title('log transformed image');


%in power law transformation s = c*(r).^gamma

c = 1;                          % constant
gamma = 0.6;                    % to make dark gamma > 1, to make bright gamma < 1
img5 = imread('onion.png');     % read the image
r = double(img5)/255;           % normalize the image
gamma_onion = c*(r).^gamma;               % formula to implement power law transformation

figure('Name', 'Question c - power law transformation');
subplot(1,2,1),imshow(img5);title('Original image');
subplot(1,2,2),imshow(gamma_onion);title('Power law transformed image');


%gray level slicing

low_level = 100;                    %low margine of the area of interest
high_level = 150;                   %high margine of the area of interest
img6 = imread('football.jpg');      %reading the image
bw_football = rgb2gray(img6);       %getting the black and white image
bw_football_1 = bw_football;
[row2, col2] = size(bw_football);   %getting the size


for i = 1:row2
    for j = 1:col2                      %iterate through the image
        m = bw_football(i,j);           
        if(m<high_level && m>low_level) 
            bw_football_1(i,j)=255;       %area of interest is assigned to the high
        else
            bw_football_1(i,j)=0;         %area of not interest is assigned to the low
        end
    end
end

figure('Name', 'Question c - gray level slicing');
subplot(1,2,1),imshow(bw_football);title('Original image');
subplot(1,2,2),imshow(bw_football_1);title('gray level sliced image')


%bit plane slicing

img7= imread('onion.png');      %read the image
bw_img7 = rgb2gray(img7);       %getting the black white image
s = zeros(r,c,8);               %pre allocate a variable to store 8 bit planes of the image
[r,c]= size(bw_img7);           %get the dimensions of image

for k = 1:8                     %iterate through bits
    for i = 1:r                 
        for j = 1:c                %iterate through the image
            s(i,j,k) = bitget(bw_img7(i,j),k);    %get kth bit from each pixel 
        end
    end
end


figure('Name', 'Question c - bit plane slicing');                         %display all the 8 bit planes
    subplot(3,3,1);imshow(s(:,:,8));title('8th bit(MSB)Plane');
    subplot(3,3,2);imshow(s(:,:,7));title('7th bit Plane');
    subplot(3,3,3);imshow(s(:,:,6));title('6th bit Plane');
    subplot(3,3,4);imshow(s(:,:,5));title('5th bit Plane');
    subplot(3,3,5);imshow(s(:,:,4));title('4th bit Plane');
    subplot(3,3,6);imshow(s(:,:,3));title('3th bit Plane');
    subplot(3,3,7);imshow(s(:,:,2));title('2nd bit Plane');
    subplot(3,3,8);imshow(s(:,:,1));title('1st bit(LSB)Plane')
    subplot(3,3,9);imshow(bw_img7);title('Original Image')%display original image

  
    
%_____________________________________________________________________________
%   Question d

%square mask

img8 = imread('pears.png');                 %read the image
resized_img8 = imresize(img8,[256 256]);    %resizing the image to 256X256
bw_resized_img8 = rgb2gray(resized_img8);
bw_resized_img8_1 = rgb2gray(resized_img8);   %black & white image for the square mask
bw_resized_img8_2 = rgb2gray(resized_img8); %black & white image for the circular mask

for i = 1:256
    for j = 1:256                           %iterate through the image
        if(i<64 || i>192 || j<64 || j>192)  %setting the margins of the mask
            bw_resized_img8_1(i,j)=0;         %set mask intensity to 0
        end
    end
end




%Circular mask

for p = -128:128
    for q = -128:128                        %iterate through the image
        if(p^2 + q^2>10000)                 %consider the circle with radius of 100 pixels
            bw_resized_img8_2(p+129,q+129)=0;%converting center based coordinates to corner based coordinates and setting intensity to 0
        end
    end
end


figure('Name', 'Question d');
subplot(2,2,1),imshow(bw_resized_img8);title('Original image');
subplot(2,2,3),imshow(bw_resized_img8_1);title('Square masked image');
subplot(2,2,4),imshow(bw_resized_img8_2);title('Circular masked image');

%_____________________________________________________________________________
%   Question e

img9 = imread('greens.jpg');    %reading the image
brighten_img9 = img9+60;        %increasing the intensity value

figure('Name', 'Question e');
subplot(1,2,1),imshow(img9);title('Original image');
subplot(1,2,2),imshow(brighten_img9);title('Brightened image');

%_____________________________________________________________________________
%   Question f

img10 = imread('pears.png');        %reading the image
img10_bw = rgb2gray(img10);         %getting the black and white

figure('Name', 'Question f');
subplot(1,2,1),imshow(img10_bw);title('Image');
subplot(1,2,2),imhist(img10_bw);title('Histogram');
