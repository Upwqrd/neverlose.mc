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
/*    */ public class AuthAgent
/*    */ {
/* 32 */   public static final AuthAgent MINECRAFT = new AuthAgent("Minecraft", 1);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 37 */   public static final AuthAgent SCROLLS = new AuthAgent("Scrolls", 1);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String name;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private int version;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AuthAgent(String name, int version) {
/* 58 */     this.name = name;
/* 59 */     this.version = version;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setName(String name) {
/* 69 */     this.name = name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 78 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVersion(int version) {
/* 88 */     this.version = version;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getVersion() {
/* 97 */     return this.version;
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\model\AuthAgent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */