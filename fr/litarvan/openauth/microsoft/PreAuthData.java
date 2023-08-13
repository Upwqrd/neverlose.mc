/*    */ package fr.litarvan.openauth.microsoft;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PreAuthData
/*    */ {
/*    */   private final String ppft;
/*    */   private final String urlPost;
/*    */   
/*    */   public PreAuthData(String ppft, String urlPost) {
/* 28 */     this.ppft = ppft;
/* 29 */     this.urlPost = urlPost;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getPPFT() {
/* 34 */     return this.ppft;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUrlPost() {
/* 39 */     return this.urlPost;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\PreAuthData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */