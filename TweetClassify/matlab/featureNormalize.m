function [X_norm] = featureNormalize(X)

X_norm = X;
m = size(X,2);
mu = mean(X,1);
sigma = std(X,0,1);


for i = 1:m,
	X_norm(:,i) = (X(:,i) - mu(1,i)) ./ sigma(1,i);
end;

end
