

/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** Subclass of SelfAwareAnnotation holding question and Answer Span annotations for a TestElement.

Fields inherited from SelfAwareAnnotation: 	begin, end, annotator
 * Updated by JCasGen Mon Sep 21 11:28:24 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class TestElementAnnotation extends SelfAwareAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TestElementAnnotation.class);
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
  protected TestElementAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TestElementAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TestElementAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TestElementAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: question

  /** getter for question - gets Identifies the question for this TestElement.
   * @generated
   * @return value of the feature 
   */
  public Span getQuestion() {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "TestElementAnnotation");
    return (Span)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_question)));}
    
  /** setter for question - sets Identifies the question for this TestElement. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestion(Span v) {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "TestElementAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_question, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: answers

  /** getter for answers - gets Array holding annotations identifying each answer choice for this TestElement.
   * @generated
   * @return value of the feature 
   */
  public FSArray getAnswers() {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_answers == null)
      jcasType.jcas.throwFeatMissing("answers", "TestElementAnnotation");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_answers)));}
    
  /** setter for answers - sets Array holding annotations identifying each answer choice for this TestElement. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswers(FSArray v) {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_answers == null)
      jcasType.jcas.throwFeatMissing("answers", "TestElementAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_answers, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answers - gets an indexed value - Array holding annotations identifying each answer choice for this TestElement.
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Answer getAnswers(int i) {
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_answers == null)
      jcasType.jcas.throwFeatMissing("answers", "TestElementAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_answers), i);
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_answers), i)));}

  /** indexed setter for answers - sets an indexed value - Array holding annotations identifying each answer choice for this TestElement.
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setAnswers(int i, Answer v) { 
    if (TestElementAnnotation_Type.featOkTst && ((TestElementAnnotation_Type)jcasType).casFeat_answers == null)
      jcasType.jcas.throwFeatMissing("answers", "TestElementAnnotation");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_answers), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TestElementAnnotation_Type)jcasType).casFeatCode_answers), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    