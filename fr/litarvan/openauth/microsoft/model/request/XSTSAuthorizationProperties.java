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
/*    */ public class XSTSAuthorizationProperties
/*    */ {
/*    */   private final String SandboxId;
/*    */   private final String[] UserTokens;
/*    */   
/*    */   public XSTSAuthorizationProperties(String SandboxId, String[] UserTokens) {
/* 28 */     this.SandboxId = SandboxId;
/* 29 */     this.UserTokens = UserTokens;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSandboxId() {
/* 34 */     return this.SandboxId;
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getUserTokens() {
/* 39 */     return this.UserTokens;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\request\XSTSAuthorizationProperties.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */