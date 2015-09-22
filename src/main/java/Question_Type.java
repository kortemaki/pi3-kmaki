
/* First created by JCasGen Mon Sep 21 21:54:12 EDT 2015 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** An annotation indicating a question.  Holds the question number as well as the info for that question's Span.
 * Updated by JCasGen Mon Sep 21 21:54:12 EDT 2015
 * @generated */
public class Question_Type extends Span_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Question_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Question_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Question(addr, Question_Type.this);
  			   Question_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Question(addr, Question_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Question.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("Question");
 
  /** @generated */
  final Feature casFeat_qNumber;
  /** @generated */
  final int     casFeatCode_qNumber;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getQNumber(int addr) {
        if (featOkTst && casFeat_qNumber == null)
      jcas.throwFeatMissing("qNumber", "Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_qNumber);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQNumber(int addr, String v) {
        if (featOkTst && casFeat_qNumber == null)
      jcas.throwFeatMissing("qNumber", "Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_qNumber, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Question_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_qNumber = jcas.getRequiredFeatureDE(casType, "qNumber", "uima.cas.String", featOkTst);
    casFeatCode_qNumber  = (null == casFeat_qNumber) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_qNumber).getCode();

  }
}



    