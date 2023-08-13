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
/*    */ public class RefreshRequest
/*    */ {
/*    */   private String accessToken;
/*    */   private String clientToken;
/*    */   
/*    */   public RefreshRequest(String accessToken, String clientToken) {
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


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\request\RefreshRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */