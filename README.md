
Tweet classification with Wikipedia Dataset

----------------------------------------------
How to run the classification program :
 
1. Under data_preprocess/words/
unzip file "bag_total.txt.tar", make sure file "bag_total.txt" is under data_preprocess/words/, no extra inner directory

( 1.5 make sure Maven plug-in is installed :
If not installed :
In Linux system, run : sudo apt-get install maven
In windows, install from m2e Marketplace : 
* Click Window -> Preferences -> Maven -> Discovery -> Open Catalog
* Select m2e-subclipse then click Finish.
* Complete the installation process.
* Also in Window -> Preferences -> Maven, check Download repository index updates on startup.

If you use an older version of Eclipse (before the Kepler release), 
you need to install the m2eclipse plugin first from the Eclipse update site http://download.eclipse.org/technology/m2e/releases. 
You'll also need to install the m2e-wtp plugin from the m2e Marketplace.
)

2. In Eclipse, import Maven project 
File--> Import --> Maven --> Existing Maven Projects
Browse file "pom.xml" under TweetClassification

3. In Eclipse, Run the entry point
go to NaiveBayes package, run "Run.java" 

------------------------------------------------

How to reconstruct Bag of Words from Wikipedia dataset : 