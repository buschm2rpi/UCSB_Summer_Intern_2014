function [train_error, val_error] = error_distribution(topic)

%% load data
[X,Y,Xval,Yval] = loadData(topic);

%% m: number of training samples
m = length(Y);

%% n: number of validation samples
n = length(Yval);

%% X data features normalize
%[X] = featureNormalize(X);
%[Xval] = featureNormalize(Xval);

%% init X
X = [ones(m,1) X];

%% init Xval
Xval = [ones(n,1) Xval];

%% init lambda
lambda = 10;

%% normal equation
    [theta] = nqTheta(X,Y,lambda);
%% gradient descent
%    [theta] = gradientDescentTheta(X(1:i,:),Y(1:i,:),lambda);
    [train_error] = linearCost(X,Y,theta,lambda);
    [val_error] = linearCost(Xval,Yval,theta,lambda);


end