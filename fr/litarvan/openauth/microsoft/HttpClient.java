/*     */ package fr.litarvan.openauth.microsoft;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLEncoder;
/*     */ import java.nio.charset.StandardCharsets;
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
/*     */ public class HttpClient
/*     */ {
/*     */   public static final String MIME_TYPE_JSON = "application/json";
/*     */   public static final String MIME_TYPE_URLENCODED_FORM = "application/x-www-form-urlencoded";
/*  41 */   private final Gson gson = new Gson();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText(String url, Map<String, String> params) throws MicrosoftAuthenticationException {
/*  47 */     return readResponse(createConnection(url + '?' + buildParams(params)));
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T getJson(String url, String token, Class<T> responseClass) throws MicrosoftAuthenticationException {
/*  52 */     HttpURLConnection connection = createConnection(url);
/*  53 */     connection.addRequestProperty("Authorization", "Bearer " + token);
/*  54 */     connection.addRequestProperty("Accept", "application/json");
/*     */     
/*  56 */     return readJson(connection, responseClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpURLConnection postForm(String url, Map<String, String> params) throws MicrosoftAuthenticationException {
/*  61 */     return post(url, "application/x-www-form-urlencoded", "*/*", buildParams(params));
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T postJson(String url, Object request, Class<T> responseClass) throws MicrosoftAuthenticationException {
/*  66 */     HttpURLConnection connection = post(url, "application/json", "application/json", this.gson.toJson(request));
/*  67 */     return readJson(connection, responseClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T postFormGetJson(String url, Map<String, String> params, Class<T> responseClass) throws MicrosoftAuthenticationException {
/*  72 */     return readJson(postForm(url, params), responseClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpURLConnection post(String url, String contentType, String accept, String data) throws MicrosoftAuthenticationException {
/*  78 */     HttpURLConnection connection = createConnection(url);
/*  79 */     connection.setDoOutput(true);
/*  80 */     connection.addRequestProperty("Content-Type", contentType);
/*  81 */     connection.addRequestProperty("Accept", accept);
/*     */     
/*     */     try {
/*  84 */       connection.setRequestMethod("POST");
/*  85 */       connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
/*  86 */     } catch (IOException e) {
/*  87 */       throw new MicrosoftAuthenticationException(e);
/*     */     } 
/*     */     
/*  90 */     return connection;
/*     */   }
/*     */ 
/*     */   
/*     */   protected <T> T readJson(HttpURLConnection connection, Class<T> responseType) throws MicrosoftAuthenticationException {
/*  95 */     return (T)this.gson.fromJson(readResponse(connection), responseType);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String readResponse(HttpURLConnection connection) throws MicrosoftAuthenticationException {
/* 100 */     String redirection = connection.getHeaderField("Location");
/* 101 */     if (redirection != null) {
/* 102 */       return readResponse(createConnection(redirection));
/*     */     }
/*     */     
/* 105 */     StringBuilder response = new StringBuilder();
/* 106 */     try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
/*     */       String line;
/* 108 */       while ((line = br.readLine()) != null) {
/* 109 */         response.append(line).append('\n');
/*     */       }
/* 111 */     } catch (IOException e) {
/* 112 */       throw new MicrosoftAuthenticationException(e);
/*     */     } 
/*     */     
/* 115 */     return response.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected HttpURLConnection followRedirects(HttpURLConnection connection) throws MicrosoftAuthenticationException {
/* 120 */     String redirection = connection.getHeaderField("Location");
/* 121 */     if (redirection != null) {
/* 122 */       connection = followRedirects(createConnection(redirection));
/*     */     }
/*     */     
/* 125 */     return connection;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String buildParams(Map<String, String> params) {
/* 130 */     StringBuilder query = new StringBuilder();
/* 131 */     params.forEach((key, value) -> {
/*     */           if (query.length() > 0) {
/*     */             query.append('&');
/*     */           }
/*     */           
/*     */           try {
/*     */             query.append(key).append('=').append(URLEncoder.encode(value, "UTF-8"));
/* 138 */           } catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 143 */     return query.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected HttpURLConnection createConnection(String url) throws MicrosoftAuthenticationException {
/*     */     HttpURLConnection connection;
/*     */     try {
/* 150 */       connection = (HttpURLConnection)(new URL(url)).openConnection();
/* 151 */     } catch (IOException e) {
/* 152 */       throw new MicrosoftAuthenticationException(e);
/*     */     } 
/*     */     
/* 155 */     String userAgent = "Mozilla/5.0 (XboxReplay; XboxLiveAuth/3.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     connection.setRequestProperty("Accept-Language", "en-US");
/* 161 */     connection.setRequestProperty("Accept-Charset", "UTF-8");
/* 162 */     connection.setRequestProperty("User-Agent", userAgent);
/*     */     
/* 164 */     return connection;
/*     */   }
/*     */ }


/* Location:              C:\Users\PC\Downloads\neverlose public.jar!\fr\litarvan\openauth\microsoft\HttpClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */