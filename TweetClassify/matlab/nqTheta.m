function [theta] = trainingTheta(X,Y,lambda)

%% create diagonal matrix
v = ones(1,size(X,2));
v(1) = 0;
D = diag(v);

%theta = pinv(X' * X) * X' * Y;

%% regularized normal equation
theta = pinv(X' * X + lambda * D) * X' * Y;

end