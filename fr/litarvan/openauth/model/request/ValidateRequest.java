/*    */ package fr.litarvan.openauth.model.request;
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
/*    */ public class ValidateRequest
/*    */ {
/*    */   private String accessToken;
/*    */   
/*    */   public ValidateRequest(String accessToken) {
/* 41 */     this.accessToken = accessToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAccessToken(String accessToken) {
/* 51 */     this.accessToken = accessToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 60 */     return this.accessToken;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\request\ValidateRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */