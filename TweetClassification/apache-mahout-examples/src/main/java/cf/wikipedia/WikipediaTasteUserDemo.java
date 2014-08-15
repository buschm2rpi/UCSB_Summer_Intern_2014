package cf.wikipedia;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.AveragingPreferenceInferrer;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;

import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * Demonstrates getting User-User recommendations from a DataModel in Taste
 */
public class WikipediaTasteUserDemo {


  public static void main(String[] args) throws IOException, TasteException, SAXException, ParserConfigurationException {
    String recsFile = args[0];
    String docIdsTitle = args[1];
    Integer neighborhoodSize = Integer.parseInt(args[2]);
    Long userId = Long.parseLong(args[3]);
    boolean printCommonalities = Boolean.parseBoolean(args[4]);
    InputSource is = new InputSource(new FileInputStream(docIdsTitle));
    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setValidating(false);
    SAXParser sp = factory.newSAXParser();
    WikiContentHandler handler = new WikiContentHandler();
    sp.parse(is, handler);
    //create the data model
    FileDataModel dataModel = new FileDataModel(new File(recsFile));
    System.out.println("Data Model: Users: " + dataModel.getNumUsers() + " Items: " + dataModel.getNumItems());

    UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
// Optional:
    userSimilarity.setPreferenceInferrer(new AveragingPreferenceInferrer(dataModel));
    //Get a neighborhood of users
    UserNeighborhood neighborhood =
            new NearestNUserNeighborhood(neighborhoodSize, userSimilarity, dataModel);
    //Create the recommender
    Recommender recommender =
            new GenericUserBasedRecommender(dataModel, neighborhood, userSimilarity);
    System.out.println("-----");
    System.out.println("User: " + userId);
    //Print out the users own preferences first
    TasteUtils.printPreferences(dataModel, userId, handler.map);
    if (printCommonalities) {
      long[] users = neighborhood.getUserNeighborhood(userId);
      for (int i = 0; i < users.length; i++) {
        long neighbor = users[i];
        System.out.println("Neighbor: " + neighbor);
        TasteUtils.printCommonalities(dataModel, userId, neighbor, handler.map);
      }

      System.out.println("");
    }
    //Get the top 5 recommendations
    List<RecommendedItem> recommendations =
            recommender.recommend(userId, 5);
    TasteUtils.printRecs(recommendations, handler.map);
  }
}
