/*    */ package fr.litarvan.openauth.microsoft;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class MicrosoftAuthenticationException
/*    */   extends Exception
/*    */ {
/*    */   public MicrosoftAuthenticationException(String message) {
/* 27 */     super(message);
/*    */   }
/*    */ 
/*    */   
/*    */   public MicrosoftAuthenticationException(IOException cause) {
/* 32 */     super("I/O exception thrown during Microsoft HTTP requests", cause);
/*    */   }
/*    */ 
/*    */   
/*    */   public MicrosoftAuthenticationException(Throwable cause) {
/* 37 */     super(cause);
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\MicrosoftAuthenticationException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */