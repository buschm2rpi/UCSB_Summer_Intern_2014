function [error_train, error_val] = ...
    learningCurve(X, y, Xval, yval, lambda)

% Number of training examples
m = size(X, 1);


error_train = zeros(m, 1);
error_val   = zeros(m, 1);


% ---------------------- Sample Solution ----------------------
for i = 1:m
	error_train(i) = linearCost(X(1:i,:), y(1:i,:), linearGradientDescent(X(1:i,:),y(1:i,:),lambda), 0);
	error_val(i) = linearCost(Xval,yval,linearGradientDescent(X(1:i,:),y(1:i,:),lambda),0);
end



% -------------------------------------------------------------

% =========================================================================

end
