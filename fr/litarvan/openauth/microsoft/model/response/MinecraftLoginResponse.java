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
/*    */ public class MinecraftLoginResponse
/*    */ {
/*    */   private final String username;
/*    */   private final String access_token;
/*    */   private final String token_type;
/*    */   private final long expires_in;
/*    */   
/*    */   public MinecraftLoginResponse(String username, String access_token, String token_type, long expires_in) {
/* 30 */     this.username = username;
/* 31 */     this.access_token = access_token;
/* 32 */     this.token_type = token_type;
/* 33 */     this.expires_in = expires_in;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsername() {
/* 38 */     return this.username;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 43 */     return this.access_token;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTokenType() {
/* 48 */     return this.token_type;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getExpiresIn() {
/* 53 */     return this.expires_in;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\response\MinecraftLoginResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */