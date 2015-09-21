

/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FloatArray;


/** Subclass of SelfAwareAnnotation holding answer scoring annotations for a TestElement.

Fields inherited from SelfAwareAnnotation: 	begin, end, annotator
 * Updated by JCasGen Mon Sep 21 11:28:24 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class AnswerScoringAnnotation extends SelfAwareAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AnswerScoringAnnotation.class);
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
  protected AnswerScoringAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public AnswerScoringAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public AnswerScoringAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public AnswerScoringAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: scores

  /** getter for scores - gets Array of scores assigned to each answer by the analysis engine.
   * @generated
   * @return value of the feature 
   */
  public FloatArray getScores() {
    if (AnswerScoringAnnotation_Type.featOkTst && ((AnswerScoringAnnotation_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "AnswerScoringAnnotation");
    return (FloatArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerScoringAnnotation_Type)jcasType).casFeatCode_scores)));}
    
  /** setter for scores - sets Array of scores assigned to each answer by the analysis engine. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setScores(FloatArray v) {
    if (AnswerScoringAnnotation_Type.featOkTst && ((AnswerScoringAnnotation_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "AnswerScoringAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((AnswerScoringAnnotation_Type)jcasType).casFeatCode_scores, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for scores - gets an indexed value - Array of scores assigned to each answer by the analysis engine.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public float getScores(int i) {
    if (AnswerScoringAnnotation_Type.featOkTst && ((AnswerScoringAnnotation_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "AnswerScoringAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerScoringAnnotation_Type)jcasType).casFeatCode_scores), i);
    return jcasType.ll_cas.ll_getFloatArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerScoringAnnotation_Type)jcasType).casFeatCode_scores), i);}

  /** indexed setter for scores - sets an indexed value - Array of scores assigned to each answer by the analysis engine.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setScores(int i, float v) { 
    if (AnswerScoringAnnotation_Type.featOkTst && ((AnswerScoringAnnotation_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "AnswerScoringAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerScoringAnnotation_Type)jcasType).casFeatCode_scores), i);
    jcasType.ll_cas.ll_setFloatArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((AnswerScoringAnnotation_Type)jcasType).casFeatCode_scores), i, v);}
  }

    