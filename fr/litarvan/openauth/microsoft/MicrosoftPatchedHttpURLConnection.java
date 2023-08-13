/*     */ package fr.litarvan.openauth.microsoft;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.ProtocolException;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class MicrosoftPatchedHttpURLConnection
/*     */   extends HttpURLConnection
/*     */ {
/*     */   private final HttpURLConnection inner;
/*     */   
/*     */   public MicrosoftPatchedHttpURLConnection(URL url, HttpURLConnection inner) {
/*  34 */     super(url);
/*     */     
/*  36 */     this.inner = inner;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequestMethod(String method) throws ProtocolException {
/*  42 */     this.inner.setRequestMethod(method);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstanceFollowRedirects(boolean followRedirects) {
/*  48 */     this.inner.setInstanceFollowRedirects(followRedirects);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getInstanceFollowRedirects() {
/*  54 */     return this.inner.getInstanceFollowRedirects();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRequestMethod() {
/*  60 */     return this.inner.getRequestMethod();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getResponseCode() throws IOException {
/*  66 */     return this.inner.getResponseCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getResponseMessage() throws IOException {
/*  72 */     return this.inner.getResponseMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, List<String>> getHeaderFields() {
/*  78 */     return this.inner.getHeaderFields();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHeaderField(String name) {
/*  84 */     return this.inner.getHeaderField(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHeaderField(int n) {
/*  90 */     return this.inner.getHeaderField(n);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void disconnect() {
/*  96 */     this.inner.disconnect();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDoOutput(boolean dooutput) {
/* 102 */     this.inner.setDoOutput(dooutput);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usingProxy() {
/* 108 */     return this.inner.usingProxy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect() throws IOException {
/* 114 */     this.inner.connect();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream() throws IOException {
/* 120 */     ByteArrayOutputStream buffer = new ByteArrayOutputStream();
/* 121 */     try (InputStream in = this.inner.getInputStream()) {
/*     */       
/* 123 */       byte[] data = new byte[8192];
/*     */       int n;
/* 125 */       while ((n = in.read(data, 0, data.length)) != -1) {
/* 126 */         buffer.write(data, 0, n);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     byte[] patched = buffer.toString("UTF-8").replaceAll("integrity ?=", "integrity.disabled=").replaceAll("setAttribute\\(\"integrity\"", "setAttribute(\"integrity.disabled\"").getBytes(StandardCharsets.UTF_8);
/*     */     
/* 136 */     return new ByteArrayInputStream(patched);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputStream getOutputStream() throws IOException {
/* 142 */     return this.inner.getOutputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getErrorStream() {
/* 148 */     return this.inner.getErrorStream();
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\MicrosoftPatchedHttpURLConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */