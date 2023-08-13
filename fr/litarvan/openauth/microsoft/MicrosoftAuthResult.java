/*    */ package fr.litarvan.openauth.microsoft;
/*    */ 
/*    */ import fr.litarvan.openauth.microsoft.model.response.MinecraftProfile;
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
/*    */ public class MicrosoftAuthResult
/*    */ {
/*    */   private final MinecraftProfile profile;
/*    */   private final String accessToken;
/*    */   private final String refreshToken;
/*    */   
/*    */   public MicrosoftAuthResult(MinecraftProfile profile, String accessToken, String refreshToken) {
/* 42 */     this.profile = profile;
/* 43 */     this.accessToken = accessToken;
/* 44 */     this.refreshToken = refreshToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MinecraftProfile getProfile() {
/* 52 */     return this.profile;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 60 */     return this.accessToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRefreshToken() {
/* 69 */     return this.refreshToken;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\MicrosoftAuthResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */