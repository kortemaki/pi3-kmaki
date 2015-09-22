

/* First created by JCasGen Mon Sep 21 21:54:12 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** A final annotation to hold the filename and contents of an output file.
 * Updated by JCasGen Mon Sep 21 21:54:12 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class OutputAnnotation extends TestElementAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(OutputAnnotation.class);
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
  protected OutputAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public OutputAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public OutputAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public OutputAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: filename

  /** getter for filename - gets The file to which this output will be written.
   * @generated
   * @return value of the feature 
   */
  public String getFilename() {
    if (OutputAnnotation_Type.featOkTst && ((OutputAnnotation_Type)jcasType).casFeat_filename == null)
      jcasType.jcas.throwFeatMissing("filename", "OutputAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OutputAnnotation_Type)jcasType).casFeatCode_filename);}
    
  /** setter for filename - sets The file to which this output will be written. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setFilename(String v) {
    if (OutputAnnotation_Type.featOkTst && ((OutputAnnotation_Type)jcasType).casFeat_filename == null)
      jcasType.jcas.throwFeatMissing("filename", "OutputAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((OutputAnnotation_Type)jcasType).casFeatCode_filename, v);}    
   
    
  //*--------------*
  //* Feature: text

  /** getter for text - gets The output to be written to the file.
   * @generated
   * @return value of the feature 
   */
  public String getText() {
    if (OutputAnnotation_Type.featOkTst && ((OutputAnnotation_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "OutputAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((OutputAnnotation_Type)jcasType).casFeatCode_text);}
    
  /** setter for text - sets The output to be written to the file. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setText(String v) {
    if (OutputAnnotation_Type.featOkTst && ((OutputAnnotation_Type)jcasType).casFeat_text == null)
      jcasType.jcas.throwFeatMissing("text", "OutputAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((OutputAnnotation_Type)jcasType).casFeatCode_text, v);}    
  }

    