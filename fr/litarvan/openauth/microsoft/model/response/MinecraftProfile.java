/*     */ package fr.litarvan.openauth.microsoft.model.response;
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
/*     */ public class MinecraftProfile
/*     */ {
/*     */   private final String id;
/*     */   private final String name;
/*     */   private final MinecraftSkin[] skins;
/*     */   
/*     */   public MinecraftProfile(String id, String name, MinecraftSkin[] skins) {
/*  39 */     this.id = id;
/*  40 */     this.name = name;
/*  41 */     this.skins = skins;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/*  49 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  57 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public MinecraftSkin[] getSkins() {
/*  62 */     return this.skins;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class MinecraftSkin
/*     */   {
/*     */     private final String id;
/*     */     private final String state;
/*     */     private final String url;
/*     */     private final String variant;
/*     */     private final String alias;
/*     */     
/*     */     public MinecraftSkin(String id, String state, String url, String variant, String alias) {
/*  75 */       this.id = id;
/*  76 */       this.state = state;
/*  77 */       this.url = url;
/*  78 */       this.variant = variant;
/*  79 */       this.alias = alias;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getId() {
/*  84 */       return this.id;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getState() {
/*  89 */       return this.state;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getUrl() {
/*  94 */       return this.url;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getVariant() {
/*  99 */       return this.variant;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getAlias() {
/* 104 */       return this.alias;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\model\response\MinecraftProfile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */