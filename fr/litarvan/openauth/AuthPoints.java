/*     */ package fr.litarvan.openauth;
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
/*     */ 
/*     */ 
/*     */ public class AuthPoints
/*     */ {
/*  36 */   public static final AuthPoints NORMAL_AUTH_POINTS = new AuthPoints("authenticate", "refresh", "validate", "signout", "invalidate");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String authenticatePoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String refreshPoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String validatePoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String signoutPoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String invalidatePoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthPoints(String authenticatePoint, String refreshPoint, String validatePoint, String signoutPoint, String invalidatePoint) {
/*  78 */     this.authenticatePoint = authenticatePoint;
/*  79 */     this.refreshPoint = refreshPoint;
/*  80 */     this.validatePoint = validatePoint;
/*  81 */     this.signoutPoint = signoutPoint;
/*  82 */     this.invalidatePoint = invalidatePoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAuthenticatePoint() {
/*  91 */     return this.authenticatePoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRefreshPoint() {
/* 100 */     return this.refreshPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValidatePoint() {
/* 109 */     return this.validatePoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSignoutPoint() {
/* 118 */     return this.signoutPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInvalidatePoint() {
/* 127 */     return this.invalidatePoint;
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\AuthPoints.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */