/*    */ package fr.litarvan.openauth.microsoft.model.request;
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
/*    */ public class MinecraftLoginRequest
/*    */ {
/*    */   private final String identityToken;
/*    */   
/*    */   public MinecraftLoginRequest(String identityToken) {
/* 27 */     this.identityToken = identityToken;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIdentityToken() {
/* 32 */     return this.identityToken;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\request\MinecraftLoginRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */