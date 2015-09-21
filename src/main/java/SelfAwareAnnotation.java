

/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Annotation subclass which is aware of the annotator that produced it.

Fields inherited from Annotation:	begin, end
 * Updated by JCasGen Mon Sep 21 11:48:38 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/java/TestElementAnnotator.xml
 * @generated */
public class SelfAwareAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SelfAwareAnnotation.class);
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
  protected SelfAwareAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SelfAwareAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SelfAwareAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public SelfAwareAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: annotator

  /** getter for annotator - gets The name of the annotator that produced this annotation.
   * @generated
   * @return value of the feature 
   */
  public String getAnnotator() {
    if (SelfAwareAnnotation_Type.featOkTst && ((SelfAwareAnnotation_Type)jcasType).casFeat_annotator == null)
      jcasType.jcas.throwFeatMissing("annotator", "SelfAwareAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SelfAwareAnnotation_Type)jcasType).casFeatCode_annotator);}
    
  /** setter for annotator - sets The name of the annotator that produced this annotation. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnnotator(String v) {
    if (SelfAwareAnnotation_Type.featOkTst && ((SelfAwareAnnotation_Type)jcasType).casFeat_annotator == null)
      jcasType.jcas.throwFeatMissing("annotator", "SelfAwareAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((SelfAwareAnnotation_Type)jcasType).casFeatCode_annotator, v);}    
  }

    