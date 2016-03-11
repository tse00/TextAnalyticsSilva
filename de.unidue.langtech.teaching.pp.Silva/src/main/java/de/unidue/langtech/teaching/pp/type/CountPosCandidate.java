

/* First created by JCasGen Wed Mar 09 23:54:59 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Mar 09 23:54:59 CET 2016
 * XML source: /Users/TSE_/git/TextAnalyticsSilva/de.unidue.langtech.teaching.pp.Silva/src/main/resources/desc/type/CountPOSType.xml
 * @generated */
public class CountPosCandidate extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CountPosCandidate.class);
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
  protected CountPosCandidate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CountPosCandidate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CountPosCandidate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CountPosCandidate(JCas jcas, int begin, int end) {
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
  //* Feature: CountCandidate

  /** getter for CountCandidate - gets 
   * @generated
   * @return value of the feature 
   */
  public int getCountCandidate() {
    if (CountPosCandidate_Type.featOkTst && ((CountPosCandidate_Type)jcasType).casFeat_CountCandidate == null)
      jcasType.jcas.throwFeatMissing("CountCandidate", "de.unidue.langtech.teaching.pp.type.CountPosCandidate");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CountPosCandidate_Type)jcasType).casFeatCode_CountCandidate);}
    
  /** setter for CountCandidate - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountCandidate(int v) {
    if (CountPosCandidate_Type.featOkTst && ((CountPosCandidate_Type)jcasType).casFeat_CountCandidate == null)
      jcasType.jcas.throwFeatMissing("CountCandidate", "de.unidue.langtech.teaching.pp.type.CountPosCandidate");
    jcasType.ll_cas.ll_setIntValue(addr, ((CountPosCandidate_Type)jcasType).casFeatCode_CountCandidate, v);}    
  }

    