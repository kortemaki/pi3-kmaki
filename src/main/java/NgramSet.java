

/* First created by JCasGen Mon Sep 21 10:12:56 EDT 2015 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSList;


/** Subclass of Span annotating selected ngrams for the given span.

Fields inherited from Span: begin, end, annotator, text
 * Updated by JCasGen Mon Sep 21 11:28:24 EDT 2015
 * XML source: /media/maki/OS/Users/Keith/Documents/CMU/Coursework/11791/PI3/pi3-kmaki/src/main/resources/pi2-kmaki-typesystem.xml
 * @generated */
public class NgramSet extends Span {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NgramSet.class);
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
  protected NgramSet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NgramSet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NgramSet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NgramSet(JCas jcas, int begin, int end) {
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
  //* Feature: ngrams

  /** getter for ngrams - gets List of ngrams identified for this Span.
   * @generated
   * @return value of the feature 
   */
  public FSList getNgrams() {
    if (NgramSet_Type.featOkTst && ((NgramSet_Type)jcasType).casFeat_ngrams == null)
      jcasType.jcas.throwFeatMissing("ngrams", "NgramSet");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams)));}
    
  /** setter for ngrams - sets List of ngrams identified for this Span. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNgrams(FSList v) {
    if (NgramSet_Type.featOkTst && ((NgramSet_Type)jcasType).casFeat_ngrams == null)
      jcasType.jcas.throwFeatMissing("ngrams", "NgramSet");
    jcasType.ll_cas.ll_setRefValue(addr, ((NgramSet_Type)jcasType).casFeatCode_ngrams, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    