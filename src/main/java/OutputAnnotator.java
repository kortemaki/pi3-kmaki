/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.FloatArray;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

/**
 * A simple scoring annotator for PI3.
 * 
 * Expects each CAS to contain at least one NgramAnnotation.
 * Processes each NgramAnnotation by adding a corresponding AnswerScoringAnnotation to the CAS.
 * 
 * This annotator has no parameters and requires no initialization method.
 */

public class OutputAnnotator extends CasAnnotator_ImplBase {	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {
		
		// Get the Ngram Annotations for each Test Element in the document
		FSIndex<AnswerScoringAnnotation> scoreIndex = (FSIndex) ((JCas) aCas).getAnnotationIndex(AnswerScoringAnnotation.type);

		// Iterate over them in sequence
		for(AnswerScoringAnnotation annot : scoreIndex)
		{			
			//////////////////////
			// Handle the question
			// get the question number
			String qnum = annot.getQuestion().getQNumber();
			String filename = "a"+qnum+".txt";
			
			//////////////////////
			// Handle the answers
			// Iterate over the answers for this Test Element and compute the scores
			FSArray answers = annot.getAnswers();
			FloatArray scores = annot.getScores();
			Map<String,Integer> map = new TreeMap<String,Integer>(); 
			for(int i = 0; i < answers.size(); i++)
			{
				Answer ans = (Answer) answers.get(i);
				Float score = scores.get(i);
				String line = "A"+ans.getNumber()+" "+String.format("%.4f",score);
				map.put(line,i);
			}
			// Get the Precision at N while sorting the lines by score
			int correct = 0;
			int N = countNumCorrect(answers);
			String[] lines = new String[answers.size()];
			for(int i=0; i < answers.size(); i++)
			{
				//Identify our system's next guess
				Float best = (float) 0;
				String next = null;
				for(String el : map.keySet())
				{
					if(next==null || scores.get(map.get(el)) > best)
					{
						best = scores.get(map.get(el));
						next = el;
					}
				}
				
				//See if it counts for precision@N
				int j = map.get(next);
				Answer ans = (Answer) answers.get(j);
				if(i<N && ans.getCorrect())
					correct++;
				
				//Remove it from the map and add it to our output lines
				map.remove(next);
				lines[i] = next;
			}
			//Compute final output
			String precAtN = String.format("%.4f",((float) correct)/N);
			String text = precAtN+"\n"+String.join("\n",lines);
			
			OutputAnnotation output = new OutputAnnotation();
			output.setAnnotator(this.getClass().getName());
			output.setFilename(filename);
			output.setText(text);
			output.addToIndexes();
		}
	}
	/**
	 * Auxiliary method to compute the number of answers which are correct in arr
	 * 
	 * @return the number of "correct" answers in arr
	 */
	private int countNumCorrect(FSArray arr)
	{
		int count = 0;
		for(int i=0; i<arr.size(); i++)
		{
			Answer ans = (Answer) arr.get(i);
			if(ans.getCorrect())
				count++;
		}
		return count;
	}
}
