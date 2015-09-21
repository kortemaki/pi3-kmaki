

/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** Subclass of SelfAwareAnnotation holding ngram annotations for a TestElement.

Fields inherited from SelfAwareAnnotation: 	begin, end, annotator
 * Updated by JCasGen Mon Sep 21 10:12:56 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class NgramAnnotation extends SelfAwareAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NgramAnnotation.class);
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
  protected NgramAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NgramAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NgramAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NgramAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: questionNgrams

  /** getter for questionNgrams - gets The ngrams identified in the question for this TestElement.
   * @generated
   * @return value of the feature 
   */
  public NgramSet getQuestionNgrams() {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_questionNgrams == null)
      jcasType.jcas.throwFeatMissing("questionNgrams", "NgramAnnotation");
    return (NgramSet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_questionNgrams)));}
    
  /** setter for questionNgrams - sets The ngrams identified in the question for this TestElement. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestionNgrams(NgramSet v) {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_questionNgrams == null)
      jcasType.jcas.throwFeatMissing("questionNgrams", "NgramAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_questionNgrams, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: answersNgrams

  /** getter for answersNgrams - gets Array of ngrams identified in each answer choice for this TestElement.
   * @generated
   * @return value of the feature 
   */
  public FSArray getAnswersNgrams() {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_answersNgrams == null)
      jcasType.jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_answersNgrams)));}
    
  /** setter for answersNgrams - sets Array of ngrams identified in each answer choice for this TestElement. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswersNgrams(FSArray v) {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_answersNgrams == null)
      jcasType.jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_answersNgrams, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answersNgrams - gets an indexed value - Array of ngrams identified in each answer choice for this TestElement.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public NgramSet getAnswersNgrams(int i) {
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_answersNgrams == null)
      jcasType.jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_answersNgrams), i);
    return (NgramSet)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_answersNgrams), i)));}

  /** indexed setter for answersNgrams - sets an indexed value - Array of ngrams identified in each answer choice for this TestElement.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setAnswersNgrams(int i, NgramSet v) { 
    if (NgramAnnotation_Type.featOkTst && ((NgramAnnotation_Type)jcasType).casFeat_answersNgrams == null)
      jcasType.jcas.throwFeatMissing("answersNgrams", "NgramAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_answersNgrams), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((NgramAnnotation_Type)jcasType).casFeatCode_answersNgrams), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    