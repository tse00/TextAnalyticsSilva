

/* First created by JCasGen Thu Feb 25 09:32:51 CET 2016 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Feb 25 09:32:51 CET 2016
 * XML source: /Users/TSE_/git/TextAnalyticsSilva/de.unidue.langtech.teaching.pp.Silva/src/main/resources/desc/type/CountPOSType.xml
 * @generated */
public class CountPos2 extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(CountPos2.class);
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
  protected CountPos2() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public CountPos2(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public CountPos2(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public CountPos2(JCas jcas, int begin, int end) {
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
  //* Feature: CountADJ

  /** getter for CountADJ - gets 
   * @generated
   * @return value of the feature 
   */
  public int getCountADJ() {
    if (CountPos2_Type.featOkTst && ((CountPos2_Type)jcasType).casFeat_CountADJ == null)
      jcasType.jcas.throwFeatMissing("CountADJ", "de.unidue.langtech.teaching.pp.type.CountPos2");
    return jcasType.ll_cas.ll_getIntValue(addr, ((CountPos2_Type)jcasType).casFeatCode_CountADJ);}
    
  /** setter for CountADJ - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountADJ(int v) {
    if (CountPos2_Type.featOkTst && ((CountPos2_Type)jcasType).casFeat_CountADJ == null)
      jcasType.jcas.throwFeatMissing("CountADJ", "de.unidue.langtech.teaching.pp.type.CountPos2");
    jcasType.ll_cas.ll_setIntValue(addr, ((CountPos2_Type)jcasType).casFeatCode_CountADJ, v);}    
  }

    