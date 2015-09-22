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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.CasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

/**
 * A simple segmentat annotator for PI3.
 * 
 * Expects a file in the below format as input 
 * Creates annotations for the question and its answers as output
 * 
 * This annotator has no configuration parameters
 * 
 * Q John loves Mary?
 * A1 1 John loves Mary with all his heart.
 * A2 1 Mary is dearly loved by John.
 * A3 0 Mary doesn't love John.
 * A4 0 John doesn't love Mary.
 * A5 1 John loves Mary.
 */

public class TestElementAnnotator extends CasAnnotator_ImplBase 
{
	private Pattern questionPattern = Pattern.compile("Q .+\\n");
	private Pattern answerPattern = Pattern.compile("A\\d+ \\d .+\\n");


	public void process(CAS aCas) throws AnalysisEngineProcessException 
	{
		// Get the text
		String text = aCas.getDocumentText();

		Matcher question = questionPattern.matcher(text);
		Matcher answers  = answerPattern.matcher(text);
		int pos = 0;
		while(question.find(pos))
		{    	
			// Annotate the question
			Question q = new Question();
			int questionBegin = question.start();
			pos = question.end();
			q.setBegin(questionBegin);
			q.setEnd(pos);
			q.setQNumber(getQuestionNumber(aCas));
			q.setText(text.substring(question.start()+2,question.end()));
			q.setAnnotator(this.getClass().getName());
			
			// Annotate the answers
			List<Answer> as = new LinkedList<Answer>();
			while(answers.find(pos))
			{
				// Stop looking for answers once we reach the next question, if any
				if(question.find(pos) && answers.end() > question.start())
					break;

				// Extract relevant info
				int begin  = answers.start();
				int end    = answers.end();
				String raw = text.substring(begin, end);
				String[] toks  = raw.split("\\s+");
				String anstext = String.join(" ", Arrays.copyOfRange(toks, 2, toks.length));

				// Box up the answer
				Answer ans = new Answer();
				ans.setBegin(begin);
				ans.setEnd(end);
				ans.setNumber(Integer.parseInt(toks[0].substring(1)));
				ans.setCorrect(Integer.parseInt(toks[1])==1);
				ans.setText(anstext); // a bit redundant, but this is a simple annotator  
				ans.setAnnotator(this.getClass().getName());
				as.add(ans);

				pos = end; //move to next answer choice
			}

			// Prepare answers to be added to TestElement
			FSArray a = new FSArray((JCas) aCas, as.size());
			a.copyFromArray(as.toArray(new Answer[as.size()]), 0, 0, as.size());

			// We have identified a new TestElement!
			TestElementAnnotation te = new TestElementAnnotation();	
			te.setQuestion(q);
			te.setAnswers(a);
			te.setBegin(questionBegin);
			te.setEnd(pos);
			te.setAnnotator(this.getClass().getName());
			te.addToIndexes();
		}
	}
	
	private String getQuestionNumber(CAS cas)
	{
		String[] path = cas.getSofaDataURI().split("\\\\/");
		String ofinterest = path[path.length-1];
		return ofinterest.substring(1,ofinterest.length()-4);
	}
}