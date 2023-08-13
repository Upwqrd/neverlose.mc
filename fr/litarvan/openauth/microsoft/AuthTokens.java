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
/*    */ public class AuthTokens
/*    */ {
/*    */   private final String accessToken;
/*    */   private final String refreshToken;
/*    */   
/*    */   public AuthTokens(String accessToken, String refreshToken) {
/* 28 */     this.accessToken = accessToken;
/* 29 */     this.refreshToken = refreshToken;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 34 */     return this.accessToken;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRefreshToken() {
/* 39 */     return this.refreshToken;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\AuthTokens.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */