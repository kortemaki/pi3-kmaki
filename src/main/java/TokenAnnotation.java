

/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** Subclass of SelfAwareAnnotation holding tokenization annotations for a TestElement.

Fields inherited from SelfAwareAnnotation:	begin, end, annotator
 * Updated by JCasGen Mon Sep 21 11:28:24 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class TokenAnnotation extends SelfAwareAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TokenAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected TokenAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TokenAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TokenAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TokenAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: questionTokens

  /** getter for questionTokens - gets Tokenization of the question for this TestElement.
   * @generated
   * @return value of the feature 
   */
  public TokenizedSpan getQuestionTokens() {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_questionTokens == null)
      jcasType.jcas.throwFeatMissing("questionTokens", "TokenAnnotation");
    return (TokenizedSpan)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_questionTokens)));}
    
  /** setter for questionTokens - sets Tokenization of the question for this TestElement. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestionTokens(TokenizedSpan v) {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_questionTokens == null)
      jcasType.jcas.throwFeatMissing("questionTokens", "TokenAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_questionTokens, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: answersTokens

  /** getter for answersTokens - gets Array holding a tokenization for each answer choice for this TestElement.
   * @generated
   * @return value of the feature 
   */
  public FSArray getAnswersTokens() {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_answersTokens == null)
      jcasType.jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_answersTokens)));}
    
  /** setter for answersTokens - sets Array holding a tokenization for each answer choice for this TestElement. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswersTokens(FSArray v) {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_answersTokens == null)
      jcasType.jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_answersTokens, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answersTokens - gets an indexed value - Array holding a tokenization for each answer choice for this TestElement.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public TokenizedSpan getAnswersTokens(int i) {
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_answersTokens == null)
      jcasType.jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_answersTokens), i);
    return (TokenizedSpan)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_answersTokens), i)));}

  /** indexed setter for answersTokens - sets an indexed value - Array holding a tokenization for each answer choice for this TestElement.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setAnswersTokens(int i, TokenizedSpan v) { 
    if (TokenAnnotation_Type.featOkTst && ((TokenAnnotation_Type)jcasType).casFeat_answersTokens == null)
      jcasType.jcas.throwFeatMissing("answersTokens", "TokenAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_answersTokens), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TokenAnnotation_Type)jcasType).casFeatCode_answersTokens), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    