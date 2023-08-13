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
/*    */ public class XboxLoginRequest<T>
/*    */ {
/*    */   private final T Properties;
/*    */   private final String RelyingParty;
/*    */   private final String TokenType;
/*    */   
/*    */   public XboxLoginRequest(T Properties, String RelyingParty, String TokenType) {
/* 29 */     this.Properties = Properties;
/* 30 */     this.RelyingParty = RelyingParty;
/* 31 */     this.TokenType = TokenType;
/*    */   }
/*    */ 
/*    */   
/*    */   public T getProperties() {
/* 36 */     return this.Properties;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSiteName() {
/* 41 */     return this.RelyingParty;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTokenType() {
/* 46 */     return this.TokenType;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\request\XboxLoginRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */