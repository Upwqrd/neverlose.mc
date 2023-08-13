/*    */ package fr.litarvan.openauth.microsoft.model.response;
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
/*    */ public class MicrosoftRefreshResponse
/*    */ {
/*    */   private final String token_type;
/*    */   private final long expires_in;
/*    */   private final String scope;
/*    */   private final String access_token;
/*    */   private final String refresh_token;
/*    */   private final String user_id;
/*    */   
/*    */   public MicrosoftRefreshResponse(String token_type, long expires_in, String scope, String access_token, String refresh_token, String user_id) {
/* 32 */     this.token_type = token_type;
/* 33 */     this.expires_in = expires_in;
/* 34 */     this.scope = scope;
/* 35 */     this.access_token = access_token;
/* 36 */     this.refresh_token = refresh_token;
/* 37 */     this.user_id = user_id;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTokenType() {
/* 42 */     return this.token_type;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getExpiresIn() {
/* 47 */     return this.expires_in;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getScope() {
/* 52 */     return this.scope;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 57 */     return this.access_token;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRefreshToken() {
/* 62 */     return this.refresh_token;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUserId() {
/* 67 */     return this.user_id;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\response\MicrosoftRefreshResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */