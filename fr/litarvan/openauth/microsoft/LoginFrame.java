/*     */ package fr.litarvan.openauth.microsoft;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.IOException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.Proxy;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.net.URLStreamHandler;
/*     */ import java.util.concurrent.CompletableFuture;
/*     */ import javafx.application.Platform;
/*     */ import javafx.beans.value.ObservableValue;
/*     */ import javafx.embed.swing.JFXPanel;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.web.WebView;
/*     */ import javax.swing.JFrame;
/*     */ import sun.net.www.protocol.https.Handler;
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
/*     */ public class LoginFrame
/*     */   extends JFrame
/*     */ {
/*     */   private CompletableFuture<String> future;
/*     */   
/*     */   public LoginFrame() {
/*  48 */     setTitle("Connexion à Microsoft");
/*  49 */     setSize(750, 750);
/*  50 */     setLocationRelativeTo((Component)null);
/*     */     
/*  52 */     setContentPane(new JFXPanel());
/*     */   }
/*     */ 
/*     */   
/*     */   public CompletableFuture<String> start(String url) {
/*  57 */     if (this.future != null) {
/*  58 */       return this.future;
/*     */     }
/*     */     
/*  61 */     this.future = new CompletableFuture<>();
/*  62 */     addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent e) {
/*  65 */             LoginFrame.this.future.completeExceptionally(new MicrosoftAuthenticationException("User closed the authentication window"));
/*     */           }
/*     */         });
/*     */     
/*  69 */     Platform.runLater(() -> init(url));
/*  70 */     return this.future;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(String url) {
/*     */     try {
/*  76 */       overrideFactory();
/*  77 */     } catch (Throwable throwable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     WebView webView = new WebView();
/*  83 */     JFXPanel content = (JFXPanel)getContentPane();
/*     */     
/*  85 */     content.setScene(new Scene(webView, getWidth(), getHeight()));
/*     */     
/*  87 */     webView.getEngine().locationProperty().addListener((observable, oldValue, newValue) -> {
/*     */           if (newValue.contains("access_token")) {
/*     */             setVisible(false);
/*     */             this.future.complete(newValue);
/*     */           } 
/*     */         });
/*  93 */     webView.getEngine().load(url);
/*     */     
/*  95 */     setVisible(true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static void overrideFactory() {
/* 100 */     URL.setURLStreamHandlerFactory(protocol -> "https".equals(protocol) ? new Handler()
/*     */         {
/*     */ 
/*     */ 
/*     */           
/*     */           protected URLConnection openConnection(URL url) throws IOException
/*     */           {
/* 107 */             return openConnection(url, null);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
/* 113 */             HttpURLConnection connection = (HttpURLConnection)super.openConnection(url, proxy);
/*     */             
/* 115 */             if (("login.microsoftonline.com".equals(url.getHost()) && url.getPath().endsWith("/oauth2/authorize")) || ("login.live.com"
/* 116 */               .equals(url.getHost()) && "/oauth20_authorize.srf".equals(url.getPath())) || ("login.live.com"
/* 117 */               .equals(url.getHost()) && "/ppsecure/post.srf".equals(url.getPath())) || ("login.microsoftonline.com"
/* 118 */               .equals(url.getHost()) && "/login.srf".equals(url.getPath())) || ("login.microsoftonline.com"
/* 119 */               .equals(url.getHost()) && url.getPath().endsWith("/login")) || ("login.microsoftonline.com"
/* 120 */               .equals(url.getHost()) && url.getPath().endsWith("/SAS/ProcessAuth")) || ("login.microsoftonline.com"
/* 121 */               .equals(url.getHost()) && url.getPath().endsWith("/federation/oauth2")) || ("login.microsoftonline.com"
/* 122 */               .equals(url.getHost()) && url.getPath().endsWith("/oauth2/v2.0/authorize"))) {
/* 123 */               return new MicrosoftPatchedHttpURLConnection(url, connection);
/*     */             }
/*     */             
/* 126 */             return connection;
/*     */           }
/*     */         } : null);
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\LoginFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */