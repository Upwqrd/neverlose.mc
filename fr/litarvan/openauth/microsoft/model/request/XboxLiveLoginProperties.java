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
/*    */ public class XboxLiveLoginProperties
/*    */ {
/*    */   private final String AuthMethod;
/*    */   private final String SiteName;
/*    */   private final String RpsTicket;
/*    */   
/*    */   public XboxLiveLoginProperties(String AuthMethod, String SiteName, String RpsTicket) {
/* 29 */     this.AuthMethod = AuthMethod;
/* 30 */     this.SiteName = SiteName;
/* 31 */     this.RpsTicket = RpsTicket;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAuthMethod() {
/* 36 */     return this.AuthMethod;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSiteName() {
/* 41 */     return this.SiteName;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getRpsTicket() {
/* 46 */     return this.RpsTicket;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\request\XboxLiveLoginProperties.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */