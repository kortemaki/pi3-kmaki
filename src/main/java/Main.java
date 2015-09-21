import java.io.*;
import java.util.List;

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

public class Main extends Thread 
{
	/**
	 * The CPE instance.
	 */
	private CollectionProcessingEngine mCPE;

	/**
	 * Start time of CPE initialization
	 */
	private long mStartTime;

	/**
	 * Start time of the processing
	 */
	private long mInitCompleteTime;

	/**
	 * This method is the main program and entry point of your system for PI3. It runs a Collection
	 * Processing Engine (CPE).
	 * 
	 * @param args
	 * 			command line arguments into the program - see class description
	 */
	public static void main(String[] args) throws Exception 
	{	
		new Main(args);
	}

	public Main(String[] args) throws Exception
	{
		mStartTime = System.currentTimeMillis();

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

		mCPE = UIMAFramework.produceCollectionProcessingEngine(cpeDesc);

		/**************************************************
		 * TODO: Update parameters in UIMAContext:        *
		 *        CollectionReader: InputDirectory, Regex *
		 *        NgramAnnotator: NgramSize               *
		 **************************************************/
		
		mCPE.addStatusCallbackListener(new StatusCallbackListenerImpl());
		
		System.out.println("Running CPE");
		mCPE.process();

		// Allow user to abort by pressing Enter
		System.out.println("To abort processing, type \"abort\" and press enter.");
		while (true) {
			String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
			if ("abort".equals(line) && mCPE.isProcessing()) {
				System.out.println("Aborting...");
				mCPE.stop();
				break;
			}
		}
	}

	/**
	 * Callback Listener. Receives event notifications from CPE.
	 * 
	 * 
	 */
	class StatusCallbackListenerImpl implements StatusCallbackListener {
		int entityCount = 0;

		long size = 0;

		/**
		 * Called when the initialization is completed.
		 * 
		 * @see org.apache.uima.collection.processing.StatusCallbackListener#initializationComplete()
		 */
		public void initializationComplete() {      
			System.out.println("CPM Initialization Complete");
			mInitCompleteTime = System.currentTimeMillis();
		}

		/**
		 * Called when the batchProcessing is completed.
		 * 
		 * @see org.apache.uima.collection.processing.StatusCallbackListener#batchProcessComplete()
		 * 
		 */
		public void batchProcessComplete() {
			System.out.print("Completed " + entityCount + " documents");
			if (size > 0) {
				System.out.print("; " + size + " characters");
			}
			System.out.println();
			long elapsedTime = System.currentTimeMillis() - mStartTime;
			System.out.println("Time Elapsed : " + elapsedTime + " ms ");
		}

		/**
		 * Called when the collection processing is completed.
		 * 
		 * @see org.apache.uima.collection.processing.StatusCallbackListener#collectionProcessComplete()
		 */
		public void collectionProcessComplete() {
			long time = System.currentTimeMillis();
			System.out.print("Completed " + entityCount + " documents");
			if (size > 0) {
				System.out.print("; " + size + " characters");
			}
			System.out.println();
			long initTime = mInitCompleteTime - mStartTime; 
			long processingTime = time - mInitCompleteTime;
			long elapsedTime = initTime + processingTime;
			System.out.println("Total Time Elapsed: " + elapsedTime + " ms ");
			System.out.println("Initialization Time: " + initTime + " ms");
			System.out.println("Processing Time: " + processingTime + " ms");

			System.out.println("\n\n ------------------ PERFORMANCE REPORT ------------------\n");
			System.out.println(mCPE.getPerformanceReport().toString());
			// stop the JVM. Otherwise main thread will still be blocked waiting for
			// user to press Enter.
			System.exit(1);
		}

		/**
		 * Called when the CPM is paused.
		 * 
		 * @see org.apache.uima.collection.processing.StatusCallbackListener#paused()
		 */
		public void paused() {
			System.out.println("Paused");
		}

		/**
		 * Called when the CPM is resumed after a pause.
		 * 
		 * @see org.apache.uima.collection.processing.StatusCallbackListener#resumed()
		 */
		public void resumed() {
			System.out.println("Resumed");
		}

		/**
		 * Called when the CPM is stopped abruptly due to errors.
		 * 
		 * @see org.apache.uima.collection.processing.StatusCallbackListener#aborted()
		 */
		public void aborted() {
			System.out.println("Aborted");
			// stop the JVM. Otherwise main thread will still be blocked waiting for
			// user to press Enter.
			System.exit(1);
		}

		/**
		 * Called when the processing of a Document is completed. <br>
		 * The process status can be looked at and corresponding actions taken.
		 * 
		 * @param aCas
		 *          CAS corresponding to the completed processing
		 * @param aStatus
		 *          EntityProcessStatus that holds the status of all the events for aEntity
		 */
		public void entityProcessComplete(CAS aCas, EntityProcessStatus aStatus) {
			if (aStatus.isException()) {
				List exceptions = aStatus.getExceptions();
				for (int i = 0; i < exceptions.size(); i++) {
					((Throwable) exceptions.get(i)).printStackTrace();
				}
				return;
			}
			entityCount++;
			String docText = aCas.getDocumentText();
			if (docText != null) {
				size += docText.length();
			}
		}
	}

}

