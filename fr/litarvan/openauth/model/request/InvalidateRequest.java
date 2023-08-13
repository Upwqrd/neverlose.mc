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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InvalidateRequest
/*    */ {
/*    */   private String accessToken;
/*    */   private String clientToken;
/*    */   
/*    */   public InvalidateRequest(String accessToken, String clientToken) {
/* 48 */     this.accessToken = accessToken;
/* 49 */     this.clientToken = clientToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAccessToken(String accessToken) {
/* 59 */     this.accessToken = accessToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 68 */     return this.accessToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setClientToken(String clientToken) {
/* 78 */     this.clientToken = clientToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getClientToken() {
/* 87 */     return this.clientToken;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\request\InvalidateRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */