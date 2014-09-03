function [lambda_vec, train_error, val_error] = ...
    regulationCurve(X, y, Xval, yval)

lambda_vec = [0 0.001 0.003 0.01 0.03 0.1 0.3 0.6 1 1.3 1.6 1.9 2.2 2.5 2.8 3 6 10 30]';


train_error = zeros(length(lambda_vec), 1);
val_error = zeros(length(lambda_vec), 1);



for i = 1:length(lambda_vec)
	lambda = lambda_vec(i);
    %% normal equation
    [theta] = nqTheta(X,y,lambda);
    
    %% gradientDescent
    %[theta] = gradientDescentTheta(X,y,lambda);
	train_error(i) = linearCost(X,y,theta,lambda);
	val_error(i) = linearCost(Xval,yval,theta,lambda);

end



% =========================================================================

end