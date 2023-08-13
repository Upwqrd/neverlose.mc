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
/*    */ public class XboxLoginResponse
/*    */ {
/*    */   private final String IssueInstant;
/*    */   private final String NotAfter;
/*    */   private final String Token;
/*    */   private final XboxLiveLoginResponseClaims DisplayClaims;
/*    */   
/*    */   public XboxLoginResponse(String IssueInstant, String NotAfter, String Token, XboxLiveLoginResponseClaims DisplayClaims) {
/* 30 */     this.IssueInstant = IssueInstant;
/* 31 */     this.NotAfter = NotAfter;
/* 32 */     this.Token = Token;
/* 33 */     this.DisplayClaims = DisplayClaims;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIssueInstant() {
/* 38 */     return this.IssueInstant;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getNotAfter() {
/* 43 */     return this.NotAfter;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getToken() {
/* 48 */     return this.Token;
/*    */   }
/*    */ 
/*    */   
/*    */   public XboxLiveLoginResponseClaims getDisplayClaims() {
/* 53 */     return this.DisplayClaims;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class XboxLiveLoginResponseClaims
/*    */   {
/*    */     private final XboxLoginResponse.XboxLiveUserInfo[] xui;
/*    */     
/*    */     public XboxLiveLoginResponseClaims(XboxLoginResponse.XboxLiveUserInfo[] xui) {
/* 62 */       this.xui = xui;
/*    */     }
/*    */ 
/*    */     
/*    */     public XboxLoginResponse.XboxLiveUserInfo[] getUsers() {
/* 67 */       return this.xui;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class XboxLiveUserInfo
/*    */   {
/*    */     private final String uhs;
/*    */     
/*    */     public XboxLiveUserInfo(String uhs) {
/* 77 */       this.uhs = uhs;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getUserHash() {
/* 82 */       return this.uhs;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\response\XboxLoginResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */