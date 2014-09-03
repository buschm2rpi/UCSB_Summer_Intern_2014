How to reconstruct Bag of Words from Wikipedia Dataset
(The results of these steps have already been in the "data_preprocess/" directory. So user doesn't need to do these steps.)

1. go to TweetClassification/apache-mahout-examples/, (the enwiki-latest-pages-articles.xml is under wikipedia folder)

2. go to "mahout-src/examples/src/test/resources/subjects.txt", in this file , you can set up the topic(or I should say wiki category you want to classify)

3. back to TweetClassification/apache-mahout-examples/ 

4. in terminal:
ant install

5.ant prepare-docs

6. after the process finished, go to TweetClassification/apache-mahout-examples/wikipedia/subjects/prepared/

7. copy all topic txt files

8. go to TweetClassification/data_preprocess/apache_mahout/, and paste those topic txt files there

9. Run Run.java at TweetClassification/src/NaiveBayes/Run.java

10. enter 5

11. input file path example : "data_preprocess/apache_mahout/business.txt"

12. output file path example : "data_preprocess/words/bag_business.txt"

*13. After you have all bags, manually change parameters in NaiveBayes/UnionBags.java and run it to get bag_total.txt, I will integrate this step in the future.


Reference:
http://www.ibm.com/developerworks/library/j-mahout/
