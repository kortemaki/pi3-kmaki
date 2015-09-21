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
import java.util.StringTokenizer;

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

public class ScoreAnnotator extends CasAnnotator_ImplBase {	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {
		
		// Get the Ngram Annotations for each Test Element in the document
		FSIndex<NgramAnnotation> ngramIndex = (FSIndex) ((JCas) aCas).getAnnotationIndex(NgramAnnotation.type);

		// Iterate over them in sequence
		for(NgramAnnotation ngramAnnot : ngramIndex)
		{			
			//////////////////////
			// Handle the question
			// Get the ngrams for this Test Element's question
			NgramSet questionNgrams = ngramAnnot.getQuestionNgrams();

			//////////////////////
			// Handle the answers
			// Create an array to hold our scoring for each answer choice
			AnswerScoringAnnotation output = new AnswerScoringAnnotation();
			output.setAnnotator(this.getClass().getName());
			output.setBegin(Math.min(questionNgrams.getBegin(),getMin(ngramAnnot.getAnswersNgrams())));
			output.setEnd(Math.max(questionNgrams.getEnd(), getMax(ngramAnnot.getAnswersNgrams())));
			
			// Iterate over the answers for this Test Element and compute the scores
			for(int i = 0; i < ngramAnnot.getAnswersNgrams().size(); i++)
			{
				// Get the ngrams for this answer choice 
				NgramSet answerNgrams = ngramAnnot.getAnswersNgrams(i);
				
				// Perform scoring for this answer
				output.setScores(i, this.score(questionNgrams, answerNgrams));
			}
			output.addToIndexes();
		}
	}

	/**
	 * Auxiliary method to compute the smallest begin index of the Annotations in arr 
	 * @param arr the array of Annotations to look at
	 * @return the minimum begin index
	 */
	private int getMin(FSArray arr) {
		int min = ((Annotation) arr.get(0)).getBegin();
		for(int i = 1; i < arr.size(); i++)
		{
			int begin = ((Annotation) arr.get(i)).getBegin();
			if(begin < min)
				min = begin;
		}
		return min;
	}

	/**
	 * Auxiliary method to compute the largest end index of the Annotations in arr 
	 * @param arr the array of Annotations to look at
	 * @return the maximum end index
	 */
	private int getMax(FSArray arr) {
		int max = ((Annotation) arr.get(0)).getEnd();
		for(int i = 1; i < arr.size(); i++)
		{
			int end = ((Annotation) arr.get(i)).getEnd();
			if(end > max)
				max = end;
		}
		return max;
	}
	
	/**
	 * Scores the agreement between the two NgramSet params based on ngram overlap 
	 * 
	 * @return
	 */
	private Float score(NgramSet tokens1, NgramSet tokens2)
	{	
		return (float) 0; //TODO: Do something actually interesting!
	}
}
