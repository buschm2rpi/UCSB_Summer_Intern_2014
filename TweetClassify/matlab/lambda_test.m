function [] = lambda_test(topic)

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

%% test lambda values
[lambda_vec,train_error,val_error] = ...
    regulationCurve(X,Y,Xval,Yval);

t = ['ArtsCulture' 'Business' 'Sports' 'Politics' 'ScienceTechnology'];

%% plot result
subplot(2,3,topic);
plot(lambda_vec,train_error,lambda_vec,val_error);
title(t(topic))
legend('Train', 'Validation')
xlabel('lambda')
ylabel('Error')
%axis([0 10 0 100]);
