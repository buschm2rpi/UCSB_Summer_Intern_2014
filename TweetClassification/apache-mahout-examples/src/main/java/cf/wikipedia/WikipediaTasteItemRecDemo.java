package cf.wikipedia;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
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
 * Demonstrates getting Item-Item recommendations from a DataModel in Taste
 */
public class WikipediaTasteItemRecDemo {


  public static void main(String[] args) throws IOException, TasteException, SAXException, ParserConfigurationException {
    String recsFile = args[0];
    String docIdsTitle = args[1];
    long itemId = Long.parseLong(args[2]);
    Integer numRecs = Integer.parseInt(args[3]);
    //Integer neighbors = Integer.parseInt(args[2]);
    InputSource is = new InputSource(new FileInputStream(docIdsTitle));
    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setValidating(false);
    SAXParser sp = factory.newSAXParser();
    WikiContentHandler handler = new WikiContentHandler();
    //load the ids and titles
    sp.parse(is, handler);

    //create the data model
    FileDataModel dataModel = new FileDataModel(new File(recsFile));
    //Create an ItemSimilarity
    ItemSimilarity itemSimilarity = new LogLikelihoodSimilarity(dataModel);
    //Create an Item Based Recommender
    ItemBasedRecommender recommender =
            new GenericItemBasedRecommender(dataModel, itemSimilarity);
    //Get the recommendations for the Item
    List<RecommendedItem> simItems = recommender.mostSimilarItems(itemId, numRecs);
    TasteUtils.printRecs(simItems, handler.map);
  }

}