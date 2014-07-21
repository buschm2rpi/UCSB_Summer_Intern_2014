%% Initialization
clear; close all; clc

%% check different regularized parameter with errors
%for j = 1:10
%    figure;
%    for i = 1:5
%        lambda_test(i);
%    end
%end

%for i = 1:10
%    figure;
    
%% Run for topic ArtsCulture    
%    topic = 1;
%    lambda = 6;
%    [x1,y1,theta1] = main(topic,lambda);

%% Run for topic Business
%    topic = 2;
%    lambda = 10;
%    [x2,y2,theta2] = main(topic,lambda);

%% Run for topic Sports 
%    topic = 3;
%    lambda = 10;
%    [x3,y3,theta3] = main(topic,lambda);

%% Run for topic Politics    
%    topic = 4;
%    lambda = 10;
%    [x4,y4,theta4] = main(topic,lambda);

%% Run for topic ScienceTechnology
    
    
%    topic = 5;
%    lambda = 10;
%    [x5,y5,theta5] = main(topic,lambda);
%end

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
figure;
for i = 1:5
    subplot(2,3,i);
    hist(errors_train(:,i)',10);
    title('training error distributions')   
    xlabel('scaled error values')
    ylabel('count Errors')

end

%% plot errors_val
figure;
for i = 1:5
    subplot(2,3,i);
    hist(errors_val(:,i)',10);
    title('validation error distributions')   
    xlabel('scaled error values')
    ylabel('count Errors')

end
