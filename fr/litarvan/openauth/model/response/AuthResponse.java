/*     */ package fr.litarvan.openauth.model.response;
/*     */ 
/*     */ import fr.litarvan.openauth.model.AuthProfile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuthResponse
/*     */ {
/*     */   private String accessToken;
/*     */   private String clientToken;
/*     */   private AuthProfile[] availableProfiles;
/*     */   private AuthProfile selectedProfile;
/*     */   
/*     */   public AuthResponse(String accessToken, String clientToken, AuthProfile[] availableProfiles, AuthProfile selectedProfile) {
/*  64 */     this.accessToken = accessToken;
/*  65 */     this.clientToken = clientToken;
/*  66 */     this.availableProfiles = availableProfiles;
/*  67 */     this.selectedProfile = selectedProfile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccessToken() {
/*  76 */     return this.accessToken;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getClientToken() {
/*  85 */     return this.clientToken;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthProfile[] getAvailableProfiles() {
/*  94 */     return this.availableProfiles;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthProfile getSelectedProfile() {
/* 103 */     return this.selectedProfile;
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\response\AuthResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */