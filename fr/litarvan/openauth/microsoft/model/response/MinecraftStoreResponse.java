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
/*    */ public class MinecraftStoreResponse
/*    */ {
/*    */   private final StoreProduct[] items;
/*    */   private final String signature;
/*    */   private final String keyId;
/*    */   
/*    */   public MinecraftStoreResponse(StoreProduct[] items, String signature, String keyId) {
/* 29 */     this.items = items;
/* 30 */     this.signature = signature;
/* 31 */     this.keyId = keyId;
/*    */   }
/*    */ 
/*    */   
/*    */   public StoreProduct[] getItems() {
/* 36 */     return this.items;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSignature() {
/* 41 */     return this.signature;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getKeyId() {
/* 46 */     return this.keyId;
/*    */   }
/*    */ 
/*    */   
/*    */   public static class StoreProduct
/*    */   {
/*    */     private final String name;
/*    */     private final String signature;
/*    */     
/*    */     public StoreProduct(String name, String signature) {
/* 56 */       this.name = name;
/* 57 */       this.signature = signature;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getName() {
/* 62 */       return this.name;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getSignature() {
/* 67 */       return this.signature;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\response\MinecraftStoreResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */