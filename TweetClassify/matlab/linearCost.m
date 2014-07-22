function [J, grad] = linearCost(X,y,theta,lambda)

m = length(y);
grad = zeros(size(theta));

J = 1/(2*m) * sum(( X * theta - y) .^ 2) + lambda / (2*m) * sum(theta(2:end) .^ 2);

temp = theta;
temp(1) = 0;

for i = 1 : size(theta,1)
    grad(i) = 1/m * sum((X*theta - y) .* X(:,i)) + lambda/m * temp(i);
end

grad = grad(:);

end
