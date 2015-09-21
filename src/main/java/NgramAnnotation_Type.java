
/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** Subclass of SelfAwareAnnotation holding ngram annotations for a TestElement.

Fields inherited from SelfAwareAnnotation: 	begin, end, annotator
 * Updated by JCasGen Mon Sep 21 11:48:38 EDT 2015
 * @generated */
public class NgramAnnotation_Type extends SelfAwareAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (NgramAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = NgramAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new NgramAnnotation(addr, NgramAnnotation_Type.this);
  			   NgramAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new NgramAnnotation(addr, NgramAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NgramAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("NgramAnnotation");
 
  /** @generated */
  final Feature casFeat_questionNgrams;
  /** @generated */
  final int     casFeatCode_questionNgrams;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestionNgrams(int addr) {
        if (featOkTst && casFeat_questionNgrams == null)
      jcas.throwFeatMissing("questionNgrams", "NgramAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_questionNgrams);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestionNgrams(int addr, int v) {
        if (featOkTst && casFeat_questionNgrams == null)
      jcas.throwFeatMissing("questionNgrams", "NgramAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_questionNgrams, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answersNgrams;
  /** @generated */
  final int     casFeatCode_answersNgrams;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswersNgrams(int addr) {
        if (featOkTst && casFeat_answersNgrams == null)
      jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswersNgrams(int addr, int v) {
        if (featOkTst && casFeat_answersNgrams == null)
      jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_answersNgrams, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getAnswersNgrams(int addr, int i) {
        if (featOkTst && casFeat_answersNgrams == null)
      jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setAnswersNgrams(int addr, int i, int v) {
        if (featOkTst && casFeat_answersNgrams == null)
      jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersNgrams), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NgramAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_questionNgrams = jcas.getRequiredFeatureDE(casType, "questionNgrams", "NgramSet", featOkTst);
    casFeatCode_questionNgrams  = (null == casFeat_questionNgrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionNgrams).getCode();

 
    casFeat_answersNgrams = jcas.getRequiredFeatureDE(casType, "answersNgrams", "uima.cas.FSArray", featOkTst);
    casFeatCode_answersNgrams  = (null == casFeat_answersNgrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answersNgrams).getCode();

  }
}



    