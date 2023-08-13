/*    */ package fr.litarvan.openauth.model;
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
/*    */ public class AuthError
/*    */ {
/*    */   private String error;
/*    */   private String errorMessage;
/*    */   private String cause;
/*    */   
/*    */   public AuthError(String error, String errorMessage, String cause) {
/* 55 */     this.error = error;
/* 56 */     this.errorMessage = errorMessage;
/* 57 */     this.cause = cause;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getError() {
/* 66 */     return this.error;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getErrorMessage() {
/* 75 */     return this.errorMessage;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCause() {
/* 84 */     return this.cause;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\AuthError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */