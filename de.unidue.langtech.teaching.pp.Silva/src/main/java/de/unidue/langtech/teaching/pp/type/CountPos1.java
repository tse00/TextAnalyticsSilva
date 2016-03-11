

/* First created by JCasGen Wed Feb 24 21:30:42 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Mar 09 23:54:59 CET 2016
 * XML source: /Users/TSE_/git/TextAnalyticsSilva/de.unidue.langtech.teaching.pp.Silva/src/main/resources/desc/type/CountPOSType.xml
 * @generated */
public class CountPos1 extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CountPos1.class);
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
  protected CountPos1() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CountPos1(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CountPos1(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CountPos1(JCas jcas, int begin, int end) {
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
  //* Feature: CountN

  /** getter for CountN - gets 
   * @generated
   * @return value of the feature 
   */
  public int getCountN() {
    if (CountPos1_Type.featOkTst && ((CountPos1_Type)jcasType).casFeat_CountN == null)
      jcasType.jcas.throwFeatMissing("CountN", "de.unidue.langtech.teaching.pp.type.CountPos1");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CountPos1_Type)jcasType).casFeatCode_CountN);}
    
  /** setter for CountN - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountN(int v) {
    if (CountPos1_Type.featOkTst && ((CountPos1_Type)jcasType).casFeat_CountN == null)
      jcasType.jcas.throwFeatMissing("CountN", "de.unidue.langtech.teaching.pp.type.CountPos1");
    jcasType.ll_cas.ll_setIntValue(addr, ((CountPos1_Type)jcasType).casFeatCode_CountN, v);}    
  }

    