
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

/** Subclass of SelfAwareAnnotation holding tokenization annotations for a TestElement.

Fields inherited from SelfAwareAnnotation:	begin, end, annotator
 * Updated by JCasGen Mon Sep 21 11:28:24 EDT 2015
 * @generated */
public class TokenAnnotation_Type extends SelfAwareAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TokenAnnotation_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TokenAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TokenAnnotation(addr, TokenAnnotation_Type.this);
  			   TokenAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TokenAnnotation(addr, TokenAnnotation_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TokenAnnotation.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("TokenAnnotation");
 
  /** @generated */
  final Feature casFeat_questionTokens;
  /** @generated */
  final int     casFeatCode_questionTokens;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestionTokens(int addr) {
        if (featOkTst && casFeat_questionTokens == null)
      jcas.throwFeatMissing("questionTokens", "TokenAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_questionTokens);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestionTokens(int addr, int v) {
        if (featOkTst && casFeat_questionTokens == null)
      jcas.throwFeatMissing("questionTokens", "TokenAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_questionTokens, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answersTokens;
  /** @generated */
  final int     casFeatCode_answersTokens;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswersTokens(int addr) {
        if (featOkTst && casFeat_answersTokens == null)
      jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswersTokens(int addr, int v) {
        if (featOkTst && casFeat_answersTokens == null)
      jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    ll_cas.ll_setRefValue(addr, casFeatCode_answersTokens, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getAnswersTokens(int addr, int i) {
        if (featOkTst && casFeat_answersTokens == null)
      jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setAnswersTokens(int addr, int i, int v) {
        if (featOkTst && casFeat_answersTokens == null)
      jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersTokens), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TokenAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_questionTokens = jcas.getRequiredFeatureDE(casType, "questionTokens", "TokenizedSpan", featOkTst);
    casFeatCode_questionTokens  = (null == casFeat_questionTokens) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionTokens).getCode();

 
    casFeat_answersTokens = jcas.getRequiredFeatureDE(casType, "answersTokens", "uima.cas.FSArray", featOkTst);
    casFeatCode_answersTokens  = (null == casFeat_answersTokens) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answersTokens).getCode();

  }
}



    