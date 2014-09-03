%% Initialization
clear; close all; clc

%% check different regularized parameter with errors
%% to get average results, you can change j = 1: (some other numbers)
for j = 1:1
    figure;
    for i = 1:5
        lambda_test(i);
    end
end


train_errors = zeros(4800,5);
val_errors = zeros(4800,5);

%% to get average results, you can change i = 1: (some other numbers)
for i = 1:1
    figure;
    
%% Run for topic ArtsCulture    
    topic = 1;
    lambda = 0;
    [x1,y1,theta1,train_errors(:,1),val_errors(:,1)] = main(topic,lambda);

%% Run for topic Business
    topic = 2;
    lambda = 0;
    [x2,y2,theta2,train_errors(:,2),val_errors(:,2)] = main(topic,lambda);

%% Run for topic Sports 
    topic = 3;
    lambda = 0;
    [x3,y3,theta3,train_errors(:,3),val_errors(:,3)] = main(topic,lambda);

%% Run for topic Politics    
    topic = 4;
    lambda = 0;
    [x4,y4,theta4,train_errors(:,4),val_errors(:,4)] = main(topic,lambda);

%% Run for topic ScienceTechnology    
    topic = 5;
    lambda = 0;
    [x5,y5,theta5,train_errors(:,5),val_errors(:,5)] = main(topic,lambda);
end

figure;
boxplot(train_errors,'Labels',{'ArtsCulture','Business','Sports','Politics','ScienceTechnology'});
title('Training errors')

figure;
boxplot(val_errors,'Labels',{'ArtsCulture','Business','Sports','Politics','ScienceTechnology'});
title('Validation errors')
ylim([0.5 2.5])

%% init iteration times
iter = 100;

%% init errors_train, errors_val
errors_train = zeros(iter,5);
errors_val = zeros(iter,5);

%% iterate random inputs to get error distribution
for i = 1:iter
    for j = 1:5
        [errors_train(i,j),errors_val(i,j)] = error_distribution(j);
    end

end

%% plot errors_trains
t = {'ArtsCulture' 'Business' 'Sports' 'Politics' 'ScienceTechnology'};
figure;
for i = 1:5
    subplot(2,3,i);
    hist(errors_train(:,i)',10);
    title(t(i))
   
    xlabel('Error')
    ylabel('Count Errors')

end

%% plot errors_val
figure;
for i = 1:5 
    subplot(2,3,i);
    hist(errors_val(:,i)',10);
    title(t(i))
   
    xlabel('Error')
    ylabel('Count Errors')

end
