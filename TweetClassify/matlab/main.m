function [Xval,Yval,theta] = main(topic,lambda)

%% load data
[X,Y,Xval,Yval] = loadData(topic);

%% m: number of training samples
m = length(Y);

%% n: number of validation samples
n = length(Yval);

%% X data features normalize
[X] = featureNormalize(X);

%% init X
X = [ones(m,1) X];

%% init Xval
Xval = [ones(n,1) Xval];

%% init train_error, val_error
train_error = zeros(m,1);
val_error = zeros(m,1);


%% Run linear regression and plot training error with validation error

for i = 1:m
%% normal equation
    [theta] = nqTheta(X(1:i,:),Y(1:i,:),lambda);
%% gradient descent
%    [theta] = gradientDescentTheta(X(1:i,:),Y(1:i,:),lambda);
    [train_error(i,1)] = linearCost(X(1:i,:),Y(1:i,:),theta,lambda);
    [val_error(i,1)] = linearCost(Xval,Yval,theta,lambda);
end

subplot(2,3,topic);
plot(1:m, train_error, 1:m,val_error);
title('Learning curve for linear regression')
legend('Train','Cross Validation')
xlabel('Number of training samples')
ylabel('Error')
axis([0 m 0 20])

%% Polynomial Regression



