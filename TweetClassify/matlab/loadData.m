function [X, Y, Xval, Yval] = loadData(topic)

dataX = load('csvX_pm.csv');
dataY = load('csvY.csv');

%% random indexs
%% training sample numbers
m = 4800;

%% validation sample numbers
n = 1100;

%% random integer from 1 to 5970 for csvX_pm
%% random integer from 1 to 5965 for csvX_m
%%rng(0,'twister');
indexs = randperm(5970);


%% init X, Y
X = zeros(m,size(dataX,2) - 1);
Y = zeros(m,1);

%% init Xval, Yval
Xval = zeros(n,size(dataX,2) - 1);
Yval = zeros(n,1);

for j = 1:m
    %%while dataY(indexs(i),topic+1) == 0
        %%i = i+1;
        %%continue
    %%end
    
    X(j,:) = dataX(indexs(j),2:end);
    Y(j,1) = dataY(indexs(j),topic + 1);
    
end

for k = 1:n
    %%while dataY(indexs(i),topic+1) == 0
        %%i = i+1;
        %%continue
    %%end
    
    Xval(k,:) = dataX(indexs(k+m),2:end);
    Yval(k,1) = dataY(indexs(k+m),topic+1);
  
end

end