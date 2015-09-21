

/* First created by JCasGen Mon Sep 21 10:12:55 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Subclass of span annotating an answer choice for a particular TestElement.  Is aware of whether it is a correct answer choice or not.

Fields inherited from Span: 	begin, end, annotator, text
 * Updated by JCasGen Mon Sep 21 11:28:24 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class Answer extends Span {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Answer.class);
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
  protected Answer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Answer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Answer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Answer(JCas jcas, int begin, int end) {
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
  //* Feature: correct

  /** getter for correct - gets Indicates correctness of this Span as an answer choice under "gold" labels.
   * @generated
   * @return value of the feature 
   */
  public boolean getCorrect() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_correct == null)
      jcasType.jcas.throwFeatMissing("correct", "Answer");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Answer_Type)jcasType).casFeatCode_correct);}
    
  /** setter for correct - sets Indicates correctness of this Span as an answer choice under "gold" labels. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setCorrect(boolean v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_correct == null)
      jcasType.jcas.throwFeatMissing("correct", "Answer");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Answer_Type)jcasType).casFeatCode_correct, v);}    
   
    
  //*--------------*
  //* Feature: number

  /** getter for number - gets The integer answer number of this answer choice.
   * @generated
   * @return value of the feature 
   */
  public int getNumber() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_number == null)
      jcasType.jcas.throwFeatMissing("number", "Answer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Answer_Type)jcasType).casFeatCode_number);}
    
  /** setter for number - sets The integer answer number of this answer choice. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNumber(int v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_number == null)
      jcasType.jcas.throwFeatMissing("number", "Answer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Answer_Type)jcasType).casFeatCode_number, v);}    
  }

    