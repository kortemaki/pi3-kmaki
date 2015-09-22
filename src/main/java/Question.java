

/* First created by JCasGen Mon Sep 21 21:54:12 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** An annotation indicating a question.  Holds the question number as well as the info for that question's Span.
 * Updated by JCasGen Mon Sep 21 21:54:12 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class Question extends Span {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
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
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Question(JCas jcas, int begin, int end) {
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
  //* Feature: qNumber

  /** getter for qNumber - gets The number associated with the question for this annotation.  Must be saved as a string to preserve "001" style format.
   * @generated
   * @return value of the feature 
   */
  public String getQNumber() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_qNumber == null)
      jcasType.jcas.throwFeatMissing("qNumber", "Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_qNumber);}
    
  /** setter for qNumber - sets The number associated with the question for this annotation.  Must be saved as a string to preserve "001" style format. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setQNumber(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_qNumber == null)
      jcasType.jcas.throwFeatMissing("qNumber", "Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_qNumber, v);}    
  }

    