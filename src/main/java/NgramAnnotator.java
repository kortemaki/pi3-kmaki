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
import org.apache.uima.resource.ResourceInitializationException;

/**
 * A simple ngram annotator for PI3.
 * 
 * Expects each CAS to contain at least one TokenAnnotation.
 * Processes each TokenAnnotation by adding a corresponding TokenAnnotation to the CAS.
 * 
 * This annotator has a single configuration parameters, NgramSize,
 *    that configures the length of ngrams to be annotated.
 * It requires no initialization method.
 */

public class NgramAnnotator extends CasAnnotator_ImplBase {
	
	private int n;
	
	public void initialize() throws ResourceInitializationException
	{
		this.n = (int) getContext().getConfigParameterValue("NgramSize");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void process(CAS aCas) throws AnalysisEngineProcessException {

		String name = this.getClass().getName();
		
		// Get the Token Annotations for each Test Element in the document
		FSIndex<TokenAnnotation> teIndex = (FSIndex) ((JCas) aCas).getAnnotationIndex(TokenAnnotation.type);

		// Iterate over them in sequence
		for(TokenAnnotation te : teIndex)
		{
			// Create the TokenAnnotation for this test element
			NgramAnnotation annot = new NgramAnnotation(); 
			TokenizedSpan question = te.getQuestionTokens();
			annot.setQuestionNgrams(this.ngramize(question,(JCas) aCas,name));
			FSArray answers = te.getAnswersTokens();
			FSArray anstoks = new FSArray((JCas) aCas, answers.size());
			for(int i=0; i<answers.size(); i++)
			{
				TokenizedSpan answer = (TokenizedSpan) answers.get(i);
				anstoks.set(i, this.ngramize(answer,(JCas) aCas,name));
			}
			annot.setBegin(te.getBegin());
			annot.setEnd(te.getEnd());
			annot.setAnnotator(name);
			
			annot.addToIndexes();
		}
	}

	/**
	 * Ngramizes the tokens of a given TokenizedSpan and returns the ngrams as an NgramSet
	 * 
	 * @param span the span to tokenize
	 * @return
	 */
	private NgramSet ngramize(TokenizedSpan tokens, JCas jcas, String name)
	{
		
		// Extract relevant fields from span
		int begin = tokens.getBegin();
		int end = tokens.getEnd();
		
		NgramSet ngrams = new NgramSet();
		ngrams.setBegin(begin);
		ngrams.setEnd(end);
		ngrams.setText(tokens.getText());
		ngrams.setAnnotator(this.getClass().getName());
		
		FSArray toks = tokens.getTokens();
		int numNgrams = toks.size()+1-this.n;
		
		for(int i=0; i<numNgrams; i++)
		{
			//copy the relevant tokens into ngram
			FSArray fstokens = new FSArray(jcas,this.n);
			for(int j=0; j<this.n; j++)
			{
				fstokens.set(j, toks.get(i+j));
			}

			Ngram ngram = new Ngram();
			ngram.setN(this.n);
			ngram.setBegin(((Span) toks.get(i)).getBegin());
			ngram.setEnd(((Span) toks.get(i+this.n-1)).getEnd());
			ngram.setText(getTextForSpansIn((Span[]) Arrays.copyOfRange(toks.toArray(), i, i+this.n)));
			ngram.setAnnotator(this.getClass().getName());
			
			ngram.setTokens(fstokens);
			
			ngrams.setNgrams(i,ngram);
		}
		return ngrams;
		
	}
	private String getTextForSpansIn(Span[] arr)
	{
		String[] strings = new String[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			strings[i] = arr[i].getText();
		}
		
		return String.join(" ",strings);
	}
}
