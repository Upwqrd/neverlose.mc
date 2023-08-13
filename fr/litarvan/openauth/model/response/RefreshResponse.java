/*    */ package fr.litarvan.openauth.model.response;
/*    */ 
/*    */ import fr.litarvan.openauth.model.AuthProfile;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RefreshResponse
/*    */ {
/*    */   private String accessToken;
/*    */   private String clientToken;
/*    */   private AuthProfile selectedProfile;
/*    */   
/*    */   public RefreshResponse(String accessToken, String clientToken, AuthProfile selectedProfile) {
/* 59 */     this.accessToken = accessToken;
/* 60 */     this.clientToken = clientToken;
/* 61 */     this.selectedProfile = selectedProfile;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAccessToken() {
/* 70 */     return this.accessToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getClientToken() {
/* 79 */     return this.clientToken;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AuthProfile getSelectedProfile() {
/* 88 */     return this.selectedProfile;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\response\RefreshResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */