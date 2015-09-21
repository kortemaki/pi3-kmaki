import java.io.*;

import org.apache.uima.UIMAFramework;
import org.apache.uima.UIMAException;
import org.apache.uima.collection.CollectionProcessingEngine;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.collection.metadata.CpeDescription;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.collection.EntityProcessStatus;
import org.apache.uima.collection.StatusCallbackListener;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;
import org.xml.sax.SAXException;

public class Main 
{

	/**
	 * This method is the main program and entry point of your system for PI3. It runs a Collection
	 * Processing Engine (CPE).
	 * 
	 * @param args
	 */
    public static void main(String[] args) 
    {
    	// ### A guideline for implementing this method ###
    	// 1. Accept integer n (1, 2, or 3) as a positional argument, specifying the length of n-grams.
    	// 2. Initialize a CPE by loading your CPE descriptor at 'src/main/resources/cpeDescriptor.xml'.
    	// 3. Pass the parameter n to your analysis engine(s) properly.
    	// 4. Run the CPE.

    	//////////////
    	// Parse args
	 
    	//Handle improper usage case
    	if(args.length != 3)
    	{
    		System.err.println("Usage error: three arguments required: length of ngrams (n = 1, 2, or 3); input directory; output directory.");
    		System.exit(1);
    	}
	
    	//Open files and create output directory if necessary
    	int n = Integer.parseInt(args[0]);
    	File inputDir = new File(args[1]);
    	File outputDir = new File(args[2]);
    	if(!outputDir.exists())
    	{
    		try
    		{
    			outputDir.mkdir();
    		}
    		catch(SecurityException se)
    		{
    			System.err.println("Could not create directory: " + args[2] + "Exiting..");
    			System.exit(2);
    		}
    	}
	
    	//////////////////
    	// Initialize CPE
    	CpeDescription cpeDesc = null;
    	CollectionProcessingEngine mCPE = null;
    	try {
			cpeDesc = UIMAFramework.getXMLParser().parseCpeDescription(new XMLInputSource("src/main/resources/cpeDescriptor.xml"));
		} catch (InvalidXMLException | IOException e) {
			System.err.println("Internal error when parsing CPE descriptor. Exiting..");
			System.exit(2);
		}
    	try {
			mCPE = UIMAFramework.produceCollectionProcessingEngine(cpeDesc);
		} catch (ResourceInitializationException e) {
			System.err.println("Internal error when initializing CPE. Exiting..");
			System.exit(2);
		}
    	//add listener here if necessary
    	try {
			mCPE.process();
		} catch (ResourceInitializationException e) {
			System.err.println("Internal error when processing CPE. Exiting..");
			System.exit(2);
		}
    	
    }
}
